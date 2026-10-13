package de.fhdo.lemma.servicedsl.smells.validation

import de.fhdo.lemma.service.ImportedServiceAspect
import de.fhdo.lemma.service.Microservice
import de.fhdo.lemma.service.ServicePackage
import java.util.Map
import org.eclipse.xtext.validation.AbstractDeclarativeValidator
import org.eclipse.xtext.validation.Check
import org.eclipse.xtext.validation.EValidatorRegistrar

/**
 * Warns in the model editor where a microservice interacts with another over an
 * unprotected channel.
 *
 * The editor's half of the detection; the command line's half is
 * ``de.fhdo.lemma.servicedsl.smells``. Both decide with [[ChannelVerdict]], so
 * the two agree by construction rather than by review.
 *
 * ## Why this reads the model directly
 *
 * Inside a running Xtext a cross-reference resolves, which it does not outside
 * one. So this validator follows ``required microservices`` to the callee
 * itself and reads its ``ServerEndpoint`` aspects, where the command line has
 * to match the target by name against what the models wrote. The editor
 * therefore judges with better information, not merely sooner.
 *
 * ## Why a warning on the microservice
 *
 * The smell is a property of a channel between two microservices declared in
 * two files, so there is no single line that is wrong. The warning goes on the
 * microservice that needs the other, which is where a reader can act on it, and
 * it names the channel and the refactoring.
 *
 * It is a warning rather than an error because the model is not wrong: the
 * architecture has a risk. Ponce et al. do not rank their smells, so the
 * severity is a presentation choice and not a finding.
 *
 * Composed into the Service DSL's validator, which is the one line this needs
 * of that bundle. This bundle requires only the metamodels, so nothing cycles.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class NonSecuredCommunicationValidator extends AbstractDeclarativeValidator {
    static val SERVICE_CALL = "ServiceCall"
    static val MESSAGE_CHANNEL = "MessageChannel"
    static val SERVER_ENDPOINT = "ServerEndpoint"

    static val TARGET = "target"
    static val TARGET_KIND = "targetKind"
    static val SCHEME = "scheme"
    static val TRANSPORT = "transport"
    static val QUEUE = "queue"
    static val ROLE = "role"
    static val TLS_ENABLED = "tlsEnabled"

    /**
     * A composed validator registers no EPackage of its own: the validator it
     * is composed into has done that.
     */
    override register(EValidatorRegistrar registrar) {
        // Deliberately empty, as Xtext requires of a composed validator.
    }

    /**
     * Warn for every unprotected channel this microservice is the near end of.
     */
    @Check
    def void checkNonSecuredCommunication(Microservice microservice) {
        for (aspect : microservice.aspects) {
            switch (aspect.aspectName) {
                case SERVICE_CALL: microservice.checkCall(aspect)
                case MESSAGE_CHANNEL: microservice.checkQueue(aspect)
                default: {}
            }
        }
    }

    private def void checkCall(Microservice microservice, ImportedServiceAspect aspect) {
        val values = aspect.valuesOf
        val target = values.get(TARGET)
        val verdict = ChannelVerdict.ofCall(values.get(SCHEME), values.get(TARGET_KIND),
            microservice.calleeAcceptsPlaintext(target))

        if (verdict.smell) {
            microservice.warn(verdict, '''the call to «target ?: "another service"»''')
        }
    }

    private def void checkQueue(Microservice microservice, ImportedServiceAspect aspect) {
        val values = aspect.valuesOf
        val queue = values.get(QUEUE)
        val verdict = ChannelVerdict.ofQueue(values.get(ROLE), values.get(TRANSPORT),
            values.get(SCHEME), values.get(TARGET) !== null)

        if (verdict.smell) {
            microservice.warn(verdict,
                '''the queue «queue ?: "it produces to"» shared with «values.get(TARGET)»''')
        }
    }

    /**
     * Whether the callee answers on a connector that accepts plaintext.
     *
     * Found by following ``required microservices`` to the microservice itself,
     * which resolves here. ``null`` where this model does not require the
     * target, or where the target declares no connector - neither of which
     * means it refuses plaintext.
     */
    private def Boolean calleeAcceptsPlaintext(Microservice microservice, String target) {
        if (target === null) {
            return null
        }
        val callee = microservice.requiredMicroservices
            .map[it.microservice]
            .filterNull
            .findFirst[name !== null && (name == target || name.endsWith("." + target))]
        if (callee === null) {
            return null
        }

        val connectors = callee.aspects.filter[aspectName == SERVER_ENDPOINT].toList
        if (connectors.empty) {
            return null
        }
        return connectors.exists["false" == (valuesOf.get(TLS_ENABLED) ?: "false").toLowerCase]
    }

    private def void warn(Microservice microservice, ChannelVerdict verdict, String channel) {
        warning(
            '''«ChannelVerdict.SMELL» («ChannelVerdict.REFERENCE»): «channel» is not secured - «
                verdict.reason». Suggested refactoring: «ChannelVerdict.REFACTORING».''',
            microservice,
            ServicePackage.Literals.MICROSERVICE__NAME
        )
    }

    /**
     * The name of an aspect, which resolves here.
     */
    private def String aspectName(ImportedServiceAspect aspect) {
        return aspect.importedAspect?.name
    }

    /**
     * The values an aspect carries, by property name.
     *
     * A boolean or a number is read as its text, because the rule compares
     * text - the Mongo seam the facts came through carries only text, and the
     * two halves of the detection have to compare the same thing.
     */
    private def Map<String, String> valuesOf(ImportedServiceAspect aspect) {
        val values = newLinkedHashMap
        for (assignment : aspect.values) {
            val name = assignment.property?.name
            val value = assignment.value
            if (name !== null && value !== null) {
                values.put(name, value.asText)
            }
        }
        return values
    }

    private def String asText(de.fhdo.lemma.data.PrimitiveValue value) {
        if (value.stringValue !== null) {
            return value.stringValue
        }
        if (value.booleanValue !== null) {
            return value.booleanValue.toString
        }
        if (value.numericValue !== null) {
            return value.numericValue.toString
        }
        return null
    }
}
