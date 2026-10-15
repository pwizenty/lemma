package de.fhdo.lemma.servicedsl.smells.refactoring

import java.io.File
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Path
import java.util.concurrent.TimeUnit

/**
 * Carries out what [[ProposalApplication]] decided.
 *
 * Deliberately thin: it runs git and a shell script and reports what happened.
 * Every judgement - whether the base matches, what the branch is called,
 * whether a certificate script is needed - is made in
 * [[ProposalApplication]], which is covered by the headless suite. This class
 * is the one part that touches the user's checkout, so it contains nothing
 * worth arguing about.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class ProposalApplier {
    /**
     * The commit a checkout is on, or null when it is not a git checkout.
     */
    static def String headOf(String root) {
        return capture(new File(root), "git", "rev-parse", "HEAD")?.trim
    }

    /**
     * A one-line description of a commit, for a refusal that names two of them.
     */
    static def String describe(String root, String commit) {
        if (commit.nullOrEmpty) {
            return null
        }
        val described = capture(new File(root), "git", "--no-pager", "log", "-1",
            "--format=%h %s", commit)?.trim
        return if (described.nullOrEmpty) commit else described
    }

    /**
     * Whether the patch would apply, without applying it.
     */
    static def boolean applies(String root, Path patch) {
        return run(new File(root), "git", "apply", "--check", patch.toString)
    }

    /**
     * Whether the checkout has uncommitted changes.
     *
     * Worth knowing before applying: a patch landing on top of unrelated edits
     * produces a commit nobody can attribute.
     */
    static def boolean isDirty(String root) {
        val status = capture(new File(root), "git", "status", "--porcelain")
        return status !== null && !status.trim.empty
    }

    /**
     * Apply a proposal, and report what was done or why it stopped.
     *
     * Each step is reported as it happens, because a partial apply the reader
     * cannot see is worse than a refusal.
     */
    static def Outcome apply(RecordedProposal proposal, String root, String branch,
        boolean commit, String certificateScript) {
        val outcome = new Outcome
        val directory = new File(root)

        if (!branch.nullOrEmpty) {
            if (!run(directory, "git", "switch", "-c", branch)) {
                outcome.failure = '''The branch «branch» could not be created. It may already exist.'''
                    .toString
                return outcome
            }
            outcome.branch = branch
            outcome.done.add('''created and switched to «branch»'''.toString)
        }

        if (!run(directory, "git", "apply", proposal.patch.toString)) {
            outcome.failure = "The patch did not apply. The checkout is unchanged."
            return outcome
        }
        outcome.done.add('''applied «proposal.changedPaths.size» file(s)'''.toString)

        if (commit) {
            run(directory, "git", "add", "-A")
            val message = '''«proposal.cause ?: "Resolve a security smell"»

Resolves security smell §3.7, Non-Secured Service-to-Service Communications
(Ponce et al. 2022). AI-authored proposal «proposal.folder.fileName», recorded
with its prompt, the skill that produced it, and the model and cost.

Not verified by this commit. A patch is not evidence that the smell is
resolved.'''.toString
            if (run(directory, "git", "commit", "-m", message)) {
                outcome.committed = true
                outcome.done.add("committed")
            } else {
                outcome.failure = "The changes applied but could not be committed."
                return outcome
            }
        }

        if (!certificateScript.nullOrEmpty) {
            if (run(directory, "bash", certificateScript)) {
                outcome.done.add('''ran «certificateScript»'''.toString)
            } else {
                // Not a failure of the apply: the patch is in, the material is
                // not. Saying so is more useful than undoing the work.
                outcome.warnings.add('''«certificateScript» did not run cleanly - the system
will not start until key material exists.'''.toString)
            }
        }
        return outcome
    }

    /**
     * What an apply did.
     */
    static class Outcome {
        public val done = <String>newLinkedList
        public val warnings = <String>newLinkedList
        public String branch
        public boolean committed
        public String failure

        def boolean isSuccess() {
            return failure.nullOrEmpty
        }
    }

    private static def boolean run(File directory, String... command) {
        try {
            val process = new ProcessBuilder(command).directory(directory)
                .redirectErrorStream(true).start
            process.inputStream.readAllBytes
            return process.waitFor(5, TimeUnit.MINUTES) && process.exitValue == 0
        } catch (Exception exception) {
            return false
        }
    }

    private static def String capture(File directory, String... command) {
        try {
            val process = new ProcessBuilder(command).directory(directory).start
            val output = new String(process.inputStream.readAllBytes, StandardCharsets.UTF_8)
            if (!process.waitFor(2, TimeUnit.MINUTES) || process.exitValue != 0) {
                return null
            }
            return output
        } catch (Exception exception) {
            return null
        }
    }

    /**
     * The patched content of one file, for a side-by-side comparison.
     *
     * Produced by applying the patch in a throwaway worktree rather than by
     * interpreting the diff: git already knows how to apply a patch, and a
     * second implementation of that would be a second thing to get wrong.
     */
    static def Path patchedCopy(String root, String base, Path patch) {
        try {
            val worktree = Files.createTempDirectory("lemma-review")
            Files.delete(worktree)
            if (!run(new File(root), "git", "worktree", "add", "--detach",
                worktree.toString, base ?: "HEAD")) {
                return null
            }
            if (!run(new File(worktree.toString), "git", "apply", patch.toString)) {
                release(root, worktree)
                return null
            }
            return worktree
        } catch (Exception exception) {
            return null
        }
    }

    /**
     * Give back a worktree made by [[patchedCopy]].
     */
    static def void release(String root, Path worktree) {
        if (worktree === null) {
            return
        }
        run(new File(root), "git", "worktree", "remove", "--force", worktree.toString)
        run(new File(root), "git", "worktree", "prune")
    }
}
