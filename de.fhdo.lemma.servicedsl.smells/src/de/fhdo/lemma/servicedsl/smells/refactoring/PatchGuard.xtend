package de.fhdo.lemma.servicedsl.smells.refactoring

import java.util.List

/**
 * Checks a patch against the constraints that must hold, before it is recorded
 * or shown to anybody.
 *
 * The constraints are stated in the prompt, but a prompt is instruction and not
 * enforcement: a proposer may ignore it, so what it produces is checked rather
 * than trusted. This is the mechanical half of that - the rest is the
 * verification step, which re-reconstructs and re-detects.
 *
 * Reads the diff as text. That is enough for what has to be caught here and it
 * needs nothing applied anywhere, which matters because a patch is rejected
 * before anything acts on it.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class PatchGuard {
    /**
     * Model files are reconstructed output. A patch that edits one would make
     * the model contradict the system it describes - and the next
     * reconstruction would truncate the edit anyway.
     */
    static val FORBIDDEN_EXTENSIONS = #[".services", ".data", ".operation"]

    /**
     * Each of these makes a connection succeed while verifying nothing, so it
     * trades this smell for a different one.
     */
    static val WEAKENINGS = #{
        "TrustAllStrategy" -> "trusts every certificate",
        "NoopHostnameVerifier" -> "verifies no hostname",
        "InsecureTrustManagerFactory" -> "disables trust management",
        "setEndpointIdentificationAlgorithm(null)" -> "disables hostname verification"
    }

    /**
     * Everything wrong with a patch, or an empty list.
     *
     * All of them rather than the first, so one run tells the whole story.
     */
    static def List<String> violations(String patch) {
        val found = <String>newLinkedList
        if (patch.nullOrEmpty) {
            found.add("the patch is empty")
            return found
        }

        for (path : patch.changedPaths) {
            if (FORBIDDEN_EXTENSIONS.exists[path.endsWith(it)]) {
                found.add('''the patch edits «path», which is reconstructed output'''.toString)
            }
        }

        for (weakening : WEAKENINGS.entrySet) {
            if (patch.addsLineContaining(weakening.key)) {
                found.add('''the patch adds «weakening.key», which «weakening.value»'''.toString)
            }
        }
        // Spelt out rather than put in the map: it is the only one whose text
        // varies by whitespace, and in JavaScript rather than Java.
        if (patch.addsRejectUnauthorizedFalse) {
            found.add("the patch adds rejectUnauthorized:false, which accepts any certificate")
        }
        return found
    }

    /**
     * The paths a diff touches, read from its ``+++`` headers.
     */
    static def List<String> changedPaths(String patch) {
        val paths = <String>newLinkedList
        for (line : patch.split("\n")) {
            if (line.startsWith("+++ ") && !line.startsWith("+++ /dev/null")) {
                var path = line.substring(4).trim
                if (path.startsWith("b/")) {
                    path = path.substring(2)
                }
                paths.add(path)
            }
        }
        return paths
    }

    /**
     * Whether the patch *adds* a line holding this text.
     *
     * Added lines only: a patch that removes an existing weakening, or merely
     * shows one as context, is not introducing it - and a guard that cannot
     * tell the difference would block the very patches worth having.
     */
    private static def boolean addsLineContaining(String patch, String text) {
        return patch.split("\n").exists[
            startsWith("+") && !startsWith("+++") && contains(text)
        ]
    }

    private static def boolean addsRejectUnauthorizedFalse(String patch) {
        return patch.split("\n").exists[
            startsWith("+") && !startsWith("+++")
                && replaceAll("\\s", "").contains("rejectUnauthorized:false")
        ]
    }
}
