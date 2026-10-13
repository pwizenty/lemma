package de.fhdo.lemma.servicedsl.smells.validation

import org.eclipse.xtend.lib.annotations.Accessors

/**
 * Whether one channel between two microservices is protected.
 *
 * The decision of **Non-Secured Service-to-Service Communications**, §3.7 of
 *
 *     Ponce, Soldani, Astudillo, Brogi: Smells and refactorings for
 *     microservices security. JSS 192 (2022) 111393.
 *
 * Plain values in, a verdict out: no model, no EMF, no Xtext. That is what lets
 * the editor's validator and the command line share one rule rather than agree
 * by accident - the validator reads resolved cross-references inside Eclipse,
 * the command line reads a graph built from parse trees, and both arrive here
 * with the same four facts.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class ChannelVerdict {
    public static val SMELL = "Non-Secured Service-to-Service Communications"
    public static val REFERENCE = "Ponce et al. (2022) §3.7"

    /**
     * What the paper suggests. Mutual rather than plain TLS, because it also
     * authenticates the peers - which is what additionally mitigates
     * §3.8 Unauthenticated traffic.
     */
    public static val REFACTORING = "Use Mutual TLS"

    static val KIND_SERVICE = "SERVICE"
    static val ROLE_PRODUCER = "producer"
    static val PLAINTEXT = "plaintext"
    static val UNRESOLVED = "unresolved"
    static val HTTPS = "https"

    @Accessors
    val Outcome outcome

    @Accessors
    val String reason

    private new(Outcome outcome, String reason) {
        this.outcome = outcome
        this.reason = reason
    }

    def boolean isSmell() {
        return outcome === Outcome.SMELL
    }

    /**
     * Judge a synchronous call.
     *
     * Both halves decide it: the scheme the caller uses, and whether the callee
     * accepts plaintext. A TLS call to a callee that also answers on a
     * plaintext connector is still the smell, because the smell is about the
     * channel and that callee can be reached over plaintext however this caller
     * calls it.
     *
     * @param scheme scheme the caller uses, or null when the model does not say
     * @param targetKind whether the target is a service of this application
     * @param calleeAcceptsPlaintext true, false, or null where the model says
     *     nothing about the callee's connectors - which is not the same as "it
     *     does not"
     * @return the verdict
     */
    static def ChannelVerdict ofCall(String scheme, String targetKind,
        Boolean calleeAcceptsPlaintext) {
        if (targetKind !== null && KIND_SERVICE != targetKind) {
            // A third party. The paper's smell is about two microservices of
            // the application, so this rule has nothing to say about it.
            return new ChannelVerdict(Outcome.NOT_APPLICABLE, null)
        }
        if (scheme.nullOrEmpty || UNRESOLVED.equalsIgnoreCase(scheme)) {
            return new ChannelVerdict(Outcome.UNDECIDED,
                "the model does not say which scheme the call uses")
        }

        if (HTTPS.equalsIgnoreCase(scheme)) {
            if (calleeAcceptsPlaintext === Boolean.TRUE) {
                return new ChannelVerdict(Outcome.SMELL,
                    "the caller uses TLS, but the callee also answers on a plaintext connector")
            }
            return new ChannelVerdict(Outcome.PROTECTED,
                if (calleeAcceptsPlaintext === Boolean.FALSE)
                    "the call uses TLS and the callee accepts only TLS"
                else
                    "the call uses TLS")
        }
        return new ChannelVerdict(Outcome.SMELL,
            '''the call uses «scheme», which does not protect the channel'''.toString)
    }

    /**
     * Judge a channel through a queue.
     *
     * Only the producer's end is judged, although both ends carry the fact: the
     * channel is one interaction, and judging it twice would report the same
     * finding from each side.
     *
     * @param role which end this service is
     * @param transport whether the broker's channel is protected
     * @param scheme scheme of the broker's address, for the reason
     * @param paired whether a service of this application is at the other end
     * @return the verdict
     */
    static def ChannelVerdict ofQueue(String role, String transport, String scheme,
        boolean paired) {
        if (!paired) {
            return new ChannelVerdict(Outcome.UNDECIDED,
                "nothing of this system is at the other end of the queue")
        }
        if (ROLE_PRODUCER != role) {
            // The producer's end carries the same channel.
            return new ChannelVerdict(Outcome.NOT_APPLICABLE, null)
        }
        if (transport.nullOrEmpty || UNRESOLVED.equalsIgnoreCase(transport)) {
            return new ChannelVerdict(Outcome.UNDECIDED,
                "the model does not say how the broker is reached")
        }
        if (!PLAINTEXT.equalsIgnoreCase(transport)) {
            return new ChannelVerdict(Outcome.PROTECTED,
                '''the broker is reached over «transport»'''.toString)
        }
        return new ChannelVerdict(Outcome.SMELL,
            '''the broker is reached over «scheme ?: transport», which does not protect the channel'''
                .toString)
    }
}

/**
 * What judging a channel can come to.
 *
 * ``UNDECIDED`` is deliberately not ``PROTECTED``: a system that does not smell
 * and a system whose facts were never reconstructed must not look alike.
 */
enum Outcome {
    SMELL,
    PROTECTED,
    UNDECIDED,
    NOT_APPLICABLE
}
