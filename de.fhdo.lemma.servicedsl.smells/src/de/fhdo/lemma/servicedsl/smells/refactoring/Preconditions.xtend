package de.fhdo.lemma.servicedsl.smells.refactoring

import java.io.File
import java.util.concurrent.TimeUnit

/**
 * What has to hold before a proposal is attempted.
 *
 * Checked before anything is spawned, so a failure changes nothing and says
 * which condition did not hold. A refactoring tool that half-applies is worse
 * than one that declines.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class Preconditions {
    public static val CLI = "claude"

    /**
     * Why a proposal cannot be attempted, or null when it can.
     *
     * The message names the condition and, where there is one, the command to
     * run by hand instead.
     */
    static def String unmetReason(RefactoringRequest request) {
        if (request === null || !request.valid) {
            return "the finding carries no root cause this can act on"
        }

        val root = new File(request.sourceRoot)
        if (!root.isDirectory) {
            return '''The configured source root does not exist: «request.sourceRoot».
Set it to the checked-out system the models were reconstructed from.'''.toString
        }
        if (!new File(root, ".git").exists) {
            return '''The source root is not a git checkout: «request.sourceRoot».
A proposal is produced in a throwaway worktree of it, so it has to be one.'''
                .toString
        }
        if (!cliAvailable) {
            return '''The «CLI» command line is not on the PATH, or is not authenticated.
Install and authenticate it, then try again. The proposal can also be produced
by hand - the prompt and the constraints are written beside the report.'''
                .toString
        }
        return null
    }

    /**
     * Whether the CLI can be run at all.
     *
     * ``--version`` rather than a real call: it is cheap, it needs no network,
     * and it distinguishes "not installed" from "installed and busy". It does
     * **not** prove the CLI is authenticated - that only shows up when a
     * proposal comes back having done nothing, which the proposer reports as a
     * failure rather than as an empty patch.
     */
    static def boolean isCliAvailable() {
        try {
            val process = new ProcessBuilder(CLI, "--version")
                .redirectErrorStream(true)
                .start
            if (!process.waitFor(20, TimeUnit.SECONDS)) {
                process.destroyForcibly
                return false
            }
            return process.exitValue == 0
        } catch (Exception exception) {
            // Not on the PATH, or not executable.
            return false
        }
    }
}
