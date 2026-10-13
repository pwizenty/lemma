package de.fhdo.lemma.servicedsl.smells

import de.fhdo.lemma.servicedsl.diagram.AspectReference
import de.fhdo.lemma.servicedsl.diagram.ServiceGraph
import de.fhdo.lemma.servicedsl.diagram.ServiceNode
import de.fhdo.lemma.servicedsl.smells.validation.ChannelVerdict
import de.fhdo.lemma.servicedsl.smells.validation.Outcome

/**
 * Detector of **Non-Secured Service-to-Service Communications**, §3.7 of
 *
 *     Ponce, Soldani, Astudillo, Brogi: Smells and refactorings for
 *     microservices security. JSS 192 (2022) 111393.
 *
 * The paper defines the smell as two microservices interacting "without
 * enacting a secure communication channel, **even if they are within the same
 * network**". That last clause is what makes a plaintext call inside a
 * container network a finding rather than a false positive.
 *
 * ## What it decides, and what it does not
 *
 * MRF collects facts; this decides the smell (ADR-0009). A channel is judged
 * from the facts the model carries for it:
 *
 * - a synchronous call: the scheme the caller uses, and whether the callee's
 *   connector accepts plaintext
 * - a channel through a queue: the transport of the broker
 *
 * A channel whose facts do not settle the question is reported as **undecided**
 * rather than as secure or as a smell. A system that does not smell and a
 * system whose facts were never reconstructed must not look alike.
 *
 * The detector is a function of a [[ServiceGraph]] and nothing else: no file
 * system, no workspace, no Eclipse.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class NonSecuredCommunicationDetector {
    public static val SMELL = ChannelVerdict.SMELL
    public static val REFERENCE = ChannelVerdict.REFERENCE
    public static val REFACTORING = ChannelVerdict.REFACTORING

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
    static val CONNECTOR = "connector"
    static val PORT = "port"
    static val CLIENT_AUTH = "clientAuth"

    static val KIND_SERVICE = "SERVICE"
    static val ROLE_PRODUCER = "producer"
    static val PLAINTEXT = "plaintext"
    static val UNRESOLVED = "unresolved"
    static val CLIENT_AUTH_REQUIRED = "need"

    /**
     * Judge every interaction the graph holds.
     *
     * @param graph the services and their facts
     * @return the findings, the channels judged secure, and the undecided ones
     */
    def DetectionResult detect(ServiceGraph graph) {
        val result = new DetectionResult
        if (graph.empty) {
            result.problems.add("No service model was read, so nothing was judged.")
            return result
        }

        for (service : graph.services.filter[resolved]) {
            for (aspect : service.aspects) {
                switch (aspect.name) {
                    case SERVICE_CALL: judgeCall(service, aspect, graph, result)
                    case MESSAGE_CHANNEL: judgeChannel(service, aspect, result)
                    default: {}
                }
            }
        }
        return result
    }

    /**
     * Judge one synchronous call.
     *
     * A call to something that is not a service of this system is not this
     * smell: the paper's smell is about two microservices of the application.
     */
    private def void judgeCall(ServiceNode caller, AspectReference aspect,
        ServiceGraph graph, DetectionResult result) {
        val target = aspect.valueOf(TARGET)
        if (target === null) {
            result.undecided.add(
                '''«caller.name» makes a call whose target the model does not name''')
            return
        }
        val kind = aspect.valueOf(TARGET_KIND)
        if (kind !== null && KIND_SERVICE != kind) {
            // A third party, not a microservice of this application.
            return
        }

        val channel = '''call to «target»'''.toString
        val callee = graph.services.findFirst[name == target && resolved]
        val verdict = ChannelVerdict.ofCall(aspect.valueOf(SCHEME), kind,
            calleeAcceptsPlaintext(callee))

        switch (verdict.outcome) {
            case NOT_APPLICABLE: return
            case UNDECIDED: {
                result.undecided.add(
                    '''«caller.name» -> «target» («channel»): «verdict.reason»''')
                return
            }
            case PROTECTED: {
                result.secured.add('''«caller.name» -> «target»: «verdict.reason»''')
                return
            }
            case SMELL: {
                val finding = newFinding(caller.name, target, channel)
                finding.reason = verdict.reason
                finding.evidence.add(aspect.written)
                if (callee !== null) {
                    callee.aspects.filter[name == SERVER_ENDPOINT].forEach[
                        finding.evidence.add(written)
                    ]
                }
                addMutualTlsNote(finding, callee)
                result.add(finding)
            }
        }
    }

    /**
     * Judge one channel through a queue.
     *
     * Only the producer's end is judged, although both ends carry the fact: the
     * channel is one interaction, and judging it twice would report the same
     * finding from each side. A consumer-only channel - nothing of this system
     * publishes to it - is undecided rather than judged, because the other end
     * is outside what was reconstructed.
     */
    private def void judgeChannel(ServiceNode service, AspectReference aspect,
        DetectionResult result) {
        val target = aspect.valueOf(TARGET)
        val queue = aspect.valueOf(QUEUE) ?: "a queue"
        val role = aspect.valueOf(ROLE)

        if (target === null) {
            result.undecided.add(
                '''«service.name» uses «queue» and nothing of this system is at the other end''')
            return
        }
        if (ROLE_PRODUCER != role) {
            return
        }

        val channel = '''queue «queue»'''.toString
        val verdict = ChannelVerdict.ofQueue(role, aspect.valueOf(TRANSPORT),
            aspect.valueOf(SCHEME), target !== null)

        switch (verdict.outcome) {
            case NOT_APPLICABLE: return
            case UNDECIDED:
                result.undecided.add(
                    '''«service.name» uses «queue»: «verdict.reason»''')
            case PROTECTED:
                result.secured.add(
                    '''«service.name» -> «target» («channel»): «verdict.reason»''')
            case SMELL: {
                val finding = newFinding(service.name, target, channel)
                finding.reason = verdict.reason
                finding.evidence.add(aspect.written)
                result.add(finding)
            }
        }
    }

    /**
     * Whether the callee answers on a connector that accepts plaintext.
     *
     * ``null`` where the model says nothing about the callee's connectors,
     * which is not the same as "it does not".
     */
    private def Boolean calleeAcceptsPlaintext(ServiceNode callee) {
        if (callee === null) {
            return null
        }
        val endpoints = callee.aspects.filter[name == SERVER_ENDPOINT].toList
        if (endpoints.empty) {
            return null
        }
        return endpoints.exists[
            "false" == (valueOf(TLS_ENABLED) ?: "false").toLowerCase
        ]
    }

    /**
     * Say where TLS is in place but not mutual.
     *
     * The paper's refactoring is *mutual* TLS, because it also authenticates
     * the peers. A connector with TLS and no ``clientAuth = need`` has the
     * confidentiality half and not the authenticity half.
     */
    private def void addMutualTlsNote(Finding finding, ServiceNode callee) {
        if (callee === null) {
            return
        }
        val tlsWithoutClientAuth = callee.aspects.filter[name == SERVER_ENDPOINT].exists[
            "true" == (valueOf(TLS_ENABLED) ?: "false").toLowerCase
                && CLIENT_AUTH_REQUIRED != valueOf(CLIENT_AUTH)
        ]
        if (tlsWithoutClientAuth) {
            finding.evidence.add(
                "a TLS connector of the callee does not require a client certificate, "
                    + "so the channel is not mutually authenticated")
        }
    }

    private def Finding newFinding(String caller, String callee, String channel) {
        val finding = new Finding(SMELL, REFERENCE, caller, callee)
        finding.channel = channel
        finding.refactoring = REFACTORING
        return finding
    }

    /**
     * Which connector of a service accepts plaintext, for a report.
     */
    static def String plaintextConnectorsOf(ServiceNode service) {
        return service.aspects
            .filter[name == SERVER_ENDPOINT]
            .filter["false" == (valueOf(TLS_ENABLED) ?: "false").toLowerCase]
            .map['''«valueOf(CONNECTOR)»:«valueOf(PORT)»''']
            .join(", ")
    }
}
