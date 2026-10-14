package de.fhdo.lemma.servicedsl.smells.test

import de.fhdo.lemma.servicedsl.diagram.AspectReference
import de.fhdo.lemma.servicedsl.diagram.ServiceModelReader
import de.fhdo.lemma.servicedsl.smells.DetectionResult
import de.fhdo.lemma.servicedsl.smells.NonSecuredCommunicationDetector
import de.fhdo.lemma.servicedsl.smells.validation.ChannelVerdict
import de.fhdo.lemma.servicedsl.smells.validation.Outcome
import de.fhdo.lemma.servicedsl.smells.validation.RootCause
import java.nio.file.Path
import java.nio.file.Paths

/**
 * Checks the detection of Non-Secured Service-to-Service Communications.
 *
 * Run it from the IDE with "Run As -> Java Application", with this bundle as
 * the working directory. No database and no running Eclipse are needed.
 *
 * Each check states what it would catch. The fixtures carry the cases no
 * sample system has: TLS anywhere, a TLS broker, a mixed callee.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class SmellDetectionTest {
    static val FIXTURES = "test/fixtures"

    static var failures = 0
    static var checks = 0

    def static void main(String[] args) {
        aPlaintextCallIsTheSmell
        tlsOnBothEndsIsNotTheSmell
        aCalleeWithAPlaintextConnectorIsStillTheSmell
        aThirdPartyIsNotThisSmell
        whatCannotBeDecidedIsNotCalledSecure
        aPlaintextQueueIsTheSmell
        aChannelIsJudgedOnceNotTwice
        aFindingCarriesItsEvidenceAndRefactoring
        anAspectsValuesAreRead
        tlsIsNotTheSameAsMutualTls
        findingsGroupByTheirCause

        println('''
        ---
        «checks» check(s), «failures» failed''')
        if (failures > 0) {
            System.exit(1)
        }
    }

    /**
     * The case the paper defines, and the one Lakeside Mutual is in.
     *
     * Catches a detector that requires the callee to be unreachable or the
     * network to be public: the smell holds "even if they are within the same
     * network".
     */
    private def static void aPlaintextCallIsTheSmell() {
        val result = judge("/judged.services")

        check("a plaintext call to a service of the system is a finding",
            result.findings.exists[caller == "PlaintextCaller" && callee == "Callee"], true)
        check("and the reason names the scheme",
            result.findings.findFirst[caller == "PlaintextCaller"]?.reason?.contains("http"),
            true)
    }

    /**
     * TLS on both ends.
     *
     * Catches a detector that reports every call: a channel the model shows to
     * be protected is not a finding, and a rule that cannot clear anything
     * says nothing.
     */
    private def static void tlsOnBothEndsIsNotTheSmell() {
        val result = judge("/judged.services")

        check("a TLS call to a TLS-only callee is not a finding",
            result.findings.exists[caller == "TlsCaller"], false)
        check("it is reported as secured instead",
            result.secured.exists[contains("TlsCaller")], true)
    }

    /**
     * The callee answers on TLS *and* on a plaintext management connector.
     *
     * Catches judging the caller's scheme alone. The smell is about the
     * channel, and a callee that accepts plaintext can be reached over
     * plaintext however this caller happens to call it.
     */
    private def static void aCalleeWithAPlaintextConnectorIsStillTheSmell() {
        val result = judge("/judged.services")
        val finding = result.findings.findFirst[caller == "TlsCallerToMixed"]

        check("a TLS call to a callee that also accepts plaintext is a finding",
            finding !== null, true)
        check("and the reason says why",
            finding?.reason?.contains("plaintext connector"), true)
    }

    /**
     * A call to something outside the application.
     *
     * Catches reporting a third party: the paper's smell is about two
     * microservices *of the application*, so an external call is neither a
     * finding nor something this rule can clear.
     */
    private def static void aThirdPartyIsNotThisSmell() {
        val result = judge("/judged.services")

        check("an external target is not a finding",
            result.findings.exists[caller == "ExternalCaller"], false)
        check("and not reported as secured either",
            result.secured.exists[contains("ExternalCaller")], false)
        check("nor as undecided",
            result.undecided.exists[contains("ExternalCaller")], false)
    }

    /**
     * Facts that do not settle the question.
     *
     * Catches an unresolved scheme or transport being read as safe. A system
     * that does not smell and a system whose facts were never reconstructed
     * must not look alike - which is the difference between a rule and a
     * guess.
     */
    private def static void whatCannotBeDecidedIsNotCalledSecure() {
        val calls = judge("/judged.services")
        val channels = judge("/channels.services")

        check("an unresolved scheme is undecided",
            calls.undecided.exists[contains("UnknownSchemeCaller")], true)
        check("and not secured", calls.secured.exists[contains("UnknownSchemeCaller")], false)
        check("and not a finding",
            calls.findings.exists[caller == "UnknownSchemeCaller"], false)
        check("an unresolved broker transport is undecided",
            channels.undecided.exists[contains("UnknownProducer")], true)
        check("a consumer with nothing at the other end is undecided",
            channels.undecided.exists[contains("reports")], true)
    }

    /**
     * A queue over a plaintext broker.
     *
     * Catches a detector that judges only synchronous calls, which would miss
     * six of the nine interactions of Lakeside Mutual.
     */
    private def static void aPlaintextQueueIsTheSmell() {
        val result = judge("/channels.services")
        val finding = result.findings.findFirst[caller == "Producer"]

        check("a plaintext queue is a finding", finding !== null, true)
        check("the channel names the queue", finding?.channel?.contains("orders"), true)
        check("a TLS broker is secured instead",
            result.secured.exists[contains("SecureProducer")], true)
    }

    /**
     * Both ends of a queue carry the fact, and it is one interaction.
     *
     * Catches judging the consumer's end as well, which reports the same
     * channel twice - once from each side - and doubles every asynchronous
     * finding.
     */
    private def static void aChannelIsJudgedOnceNotTwice() {
        val result = judge("/channels.services")

        check("the orders queue yields one finding",
            result.findings.filter[channel !== null && channel.contains("orders")].size, 1)
        check("from the producer's end", result.findings.findFirst[
            channel !== null && channel.contains("orders")]?.caller, "Producer")
    }

    /**
     * What a finding has to carry to be worth reading.
     *
     * Catches a finding that states a verdict without the facts behind it, and
     * one that does not say what to do about it.
     */
    private def static void aFindingCarriesItsEvidenceAndRefactoring() {
        val finding = judge("/judged.services").findings.findFirst[caller == "PlaintextCaller"]

        check("it names the smell", finding?.smell,
            NonSecuredCommunicationDetector.SMELL)
        check("and where the smell is defined", finding?.reference,
            NonSecuredCommunicationDetector.REFERENCE)
        check("it suggests the literature's refactoring", finding?.refactoring,
            NonSecuredCommunicationDetector.REFACTORING)
        check("it carries the call it was decided from",
            finding?.evidence?.exists[contains("ServiceCall")], true)
        check("and the callee's connector",
            finding?.evidence?.exists[contains("ServerEndpoint")], true)
    }

    /**
     * An aspect's property values, read from what the model wrote.
     *
     * Catches a parser that splits on every comma: a value may hold one, and
     * splitting inside a quoted value loses the rest of it.
     */
    private def static void anAspectsValuesAreRead() {
        val values = AspectReference.valuesOf(
            '''@t::_aspects.MessageChannel(role = "producer", queue = "a,b", transport = "plaintext")''')

        check("every property is read", values.size, 3)
        check("a value holding a comma survives", values.get("queue"), "a,b")
        check("and the quotes are gone", values.get("role"), "producer")
        check("an aspect with no values yields none",
            AspectReference.valuesOf("@t::_aspects.Autowired").size, 0)
    }

    private def static DetectionResult judge(String fixture) {
        val graph = new ServiceModelReader().read(#[
            Paths.get(FIXTURES + fixture) as Path
        ])
        return new NonSecuredCommunicationDetector().detect(graph)
    }

    private def static void check(String what, Object actual, Object expected) {
        checks++
        if (expected == actual) {
            println('''  ok    «what»''')
        } else {
            failures++
            println('''  FAIL  «what»: expected «expected», got «actual»''')
        }
    }

    /**
     * Mutual TLS is the refactoring §3.7 prescribes, so plain TLS and mutual
     * TLS must not read alike.
     *
     * Catches a rule that treats any TLS as the refactoring applied, which
     * would let the verifier certify something weaker than the paper cites.
     * Tested against the rule directly: plain values in, verdict out, no model
     * needed - which is the property that lets the editor and the command line
     * share it.
     */
    private def static void tlsIsNotTheSameAsMutualTls() {
        val mutual = ChannelVerdict.ofCall("https", "SERVICE", false, "need")
        check("a TLS call to a callee requiring a client certificate is protected",
            mutual.outcome, Outcome.PROTECTED)
        check("and is not a finding", mutual.smell, false)
        check("and the reason says it is mutual",
            mutual.reason.contains("mutual TLS"), true)

        val notMutual = ChannelVerdict.ofCall("https", "SERVICE", false, "none")
        check("a TLS call to a callee requiring nothing is not mutual",
            notMutual.outcome, Outcome.PROTECTED_NOT_MUTUAL)
        check("which is still not a §3.7 finding", notMutual.smell, false)
        check("but is reported as protected", notMutual.protected, true)
        check("and flagged as not mutual", notMutual.protectedButNotMutual, true)

        // "want" asks for a certificate and then serves the request without
        // one, so it authenticates nobody. The trap this exists for.
        val want = ChannelVerdict.ofCall("https", "SERVICE", false, "want")
        check("clientAuth=want is not mutual either",
            want.outcome, Outcome.PROTECTED_NOT_MUTUAL)
        check("and the reason says why",
            want.reason.contains("serves the request without one"), true)

        // Absent is Spring's "none", and the reconstruction records absence
        // rather than defaulting it.
        check("an absent clientAuth is not mutual",
            ChannelVerdict.ofCall("https", "SERVICE", false, null).outcome,
            Outcome.PROTECTED_NOT_MUTUAL)

        // Mutuality must not rescue a callee that also answers on plaintext.
        check("a plaintext connector still wins over clientAuth=need",
            ChannelVerdict.ofCall("https", "SERVICE", true, "need").outcome,
            Outcome.SMELL)

        // A queue carries no client-authentication fact, so it must never be
        // guessed at in either direction.
        check("a TLS queue is protected, not judged on mutuality",
            ChannelVerdict.ofQueue("producer", "tls", "ssl", true).outcome,
            Outcome.PROTECTED)
    }

    /**
     * Findings group by what causes them, because a cause is what gets fixed.
     *
     * Catches a grouping keyed by the caller, which would make three services
     * calling one plaintext connector look like three separate repairs.
     */
    private def static void findingsGroupByTheirCause() {
        val callee = RootCause.ofCall("CustomerCore")
        check("two callers of one callee share a cause",
            RootCause.ofCall("CustomerCore").id, callee.id)
        check("a different callee is a different cause",
            RootCause.ofCall("PolicyManagement").id == callee.id, false)
        check("the cause names what has to change",
            callee.label.contains("connectors of CustomerCore"), true)
        check("and says which kind it is", callee.kind, RootCause.KIND_ENDPOINT)

        val broker = RootCause.ofQueue("activemq", "tcp")
        check("two queues of one broker share a cause",
            RootCause.ofQueue("activemq", "tcp").id, broker.id)
        check("a broker reached over another scheme is another cause",
            RootCause.ofQueue("activemq", "ssl").id == broker.id, false)
        check("a call and a queue never share a cause",
            broker.id == callee.id, false)

        // Equality is by id, so a cause can key a map.
        check("a cause equals another with the same id",
            broker == RootCause.ofQueue("activemq", "tcp"), true)
    }

}
