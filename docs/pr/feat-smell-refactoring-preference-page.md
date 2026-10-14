## Summary

The one setting the refactoring cannot work without had no user interface.

```diff
- .metadata/.plugins/org.eclipse.core.runtime/.settings/
-     de.fhdo.lemma.servicedsl.ui.prefs          edited by hand,
-                                                 in the right workspace,
-                                                 before launching
+ Window → Preferences → ServiceDsl → Security Smell Refactoring
```

Four fields:

| Field | Default |
|---|---|
| **Source root of the reconstructed system** | **none, deliberately** |
| Model | `claude-opus-5` |
| Give up after (minutes) | 45 |
| Keep proposals in | empty → beside the source root |

**The source root has no default on purpose.** There is no sensible guess, and
a wrong one would aim a proposal at the wrong checkout. It is also the reason
the page exists at all: a reconstructed model carries no source paths, because
those are absolute and a generated model has to be identical on every machine
to be diffable — so the toolchain genuinely cannot tell which checkout a model
came from, and nobody can infer it for them.

The page writes into the same instance-scope node `SmellRefactoringPreferences`
reads, so the page and the code cannot disagree about where a value lives. An
`AbstractPreferenceInitializer` contributes the defaults, or the fields open
blank.

```diff
  @Fix(NON_SECURED_COMMUNICATION)
  proposeMutualTls(...)
    if sourceRoot is unset
-     throw new IllegalStateException(...)      a stack trace in the error log
+     explain what is missing, and offer to open the page
```

## Evidence

**Before:** the only way to set it was editing

```text
<workspace>/.metadata/.plugins/org.eclipse.core.runtime/.settings/
    de.fhdo.lemma.servicedsl.ui.prefs
```

by hand, in the right workspace, before launching — and if you got the
workspace wrong, the quickfix threw an `IllegalStateException` into an error
log you had not asked for.

**After:** a page under the existing `ServiceDsl` category, and a refusal that
offers to take you to it.

```console
$ build-diagrams.sh
  compiled de.fhdo.lemma.diagram.common
  …
  compiled de.fhdo.lemma.servicedsl.ui        ← all seven, at --release 11

$ SmellDetectionTest              108 check(s), 0 failed
$ ReconstructionRegressionTest    all 4 systems match
$ plugin.xml                      well-formed; page and initializer registered
```

The page also states a trap that cost real time while writing the instructions
for this, **checked rather than assumed**:

```console
$ which claude                 /opt/homebrew/bin/claude
$ cat /etc/paths               (no /opt/homebrew/bin)
$ launchctl getenv PATH        (unset)
```

An Eclipse started from the Dock does not inherit the shell `PATH`, so the CLI
is invisible to it and the quickfix reports the command line as missing. Start
Eclipse from a terminal. That is on the page rather than in a commit message
nobody will read at the moment it matters.

**One Java level slip the build caught:** `String.stripIndent()` is Java 12 and
this bundle declares `JavaSE-11`. Same shape as the `List.getLast()` slip
earlier in this work, and again **only `--release 11` reports it** — a compile
against the running JDK accepts it and Eclipse then refuses.

## Merge Danger

**Door:** two-way. One page, one initializer, two `plugin.xml` extensions, and
one changed branch in the quickfix.

**Blast Radius:** the preference dialog, and nothing else

- **A new page appears** under `ServiceDsl` for anyone with this bundle
  installed, whether or not they use the refactoring.
- **An initializer now contributes defaults** into the
  `de.fhdo.lemma.servicedsl.ui` instance node. It sets only the two keys above
  and touches nothing Xtext owns, but it is a new contribution to a node the
  language also uses.
- **Existing hand-edited `.prefs` files keep working.** The page reads and
  writes the same keys, so a value set by hand shows up in it.

**Still unexercised, and this is the honest limit.** Neither the page nor the
quickfix has run in a live Eclipse. Compilation proves the API use is right; it
does not prove the page appears under the right category, that the field
editors lay out sensibly, that the initializer fires before the page opens, or
that `PreferencesUtil.createPreferenceDialogOn` finds the page by that id. All
of that needs launching a runtime workbench, which no amount of headless
testing substitutes for.

🤖 Generated with [Claude Code](https://claude.com/claude-code)
