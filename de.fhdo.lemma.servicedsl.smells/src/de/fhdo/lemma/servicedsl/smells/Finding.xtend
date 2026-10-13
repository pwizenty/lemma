package de.fhdo.lemma.servicedsl.smells

import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * One occurrence of a security smell, with what it was decided from.
 *
 * A finding names the smell, the two microservices whose channel it is about,
 * and the facts the decision rests on. It carries no severity: the literature
 * does not rank these smells, and inventing a ranking would put a judgement in
 * the tool that belongs to whoever reads it.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class Finding {
    /**
     * The smell, as the literature names it.
     */
    @Accessors
    String smell

    /**
     * Section of Ponce et al. (2022) that defines it.
     */
    @Accessors
    String reference

    @Accessors
    String caller

    @Accessors
    String callee

    /**
     * What the channel is: a protocol and a path, or a queue.
     */
    @Accessors
    String channel

    /**
     * Why the channel is held to be unprotected.
     */
    @Accessors
    String reason

    /**
     * The refactoring the literature suggests.
     */
    @Accessors
    String refactoring

    /**
     * The facts the decision rests on, as the model states them.
     */
    @Accessors
    val List<String> evidence = newLinkedList

    new(String smell, String reference, String caller, String callee) {
        this.smell = smell
        this.reference = reference
        this.caller = caller
        this.callee = callee
    }

    override String toString() {
        return '''«caller» -> «callee» («channel»): «reason»'''.toString
    }
}

/**
 * What a detection run found, and what it could not decide.
 *
 * A smell the reconstruction has no facts for is not reported as absent: it is
 * reported as undecidable, so a reader can tell a system that does not smell
 * from one whose facts were not reconstructed.
 */
class DetectionResult {
    @Accessors
    val List<Finding> findings = newLinkedList

    /**
     * Channels that were found but could not be judged, with the reason.
     */
    @Accessors
    val List<String> undecided = newLinkedList

    /**
     * Channels that were judged and found to be protected.
     */
    @Accessors
    val List<String> secured = newLinkedList

    @Accessors
    val List<String> problems = newLinkedList

    def void add(Finding finding) {
        findings.add(finding)
    }

    def int channelsJudged() {
        return findings.size + secured.size
    }
}
