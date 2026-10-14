# Pull request bodies

One file per feature branch, named after it. Written when the branch was ready
and kept so the text survives the session it was written in.

They are a record of what a change claimed and what it was verified against, so
a later reader can check the claim rather than take it. The evidence sections
name the exact commands and their output - which matters here, because this
repository has no headless build and the verification was done by compiling the
Xtend with the batch compiler and running `ReconstructionRegressionTest` by hand.

At the repository root rather than inside a bundle: these changes span several
of them - `de.fhdo.lemma.reconstruction` and `de.fhdo.lemma.servicedsl.extractor`
for the reconstruction work, the `*.diagram` bundles for the visualisations, and
`de.fhdo.lemma.servicedsl.smells*` for the smell detection.

The first three arrived together on the branch `feat/communication-aspect`, which
contains the commits of the other two; the earlier branches are left alone so
their own diffs stay free of files describing themselves.

| File | Branch | Into |
|---|---|---|
| `feat-deployment-configuration.md` | `feat/deployment-configuration` | `dev` |
| `feat-rest-technology-information.md` | `feat/rest-technology-information` | `dev` |
| `feat-communication-aspect.md` | `feat/communication-aspect` | `dev` |
| `feat-service-dependencies.md` | `feat/service-dependencies` | `dev` |
| `feat-protobuf-fixture.md` | `feat/protobuf-fixture` | `dev` |
| `fix-asynchronous-communication.md` | `fix/asynchronous-communication` | `dev` |
| `feat-data-model-diagram.md` | `feat/data-model-diagram` | `dev` |
| `feat-service-model-diagram.md` | `feat/service-model-diagram` | `dev` |
| `feat-operation-model-diagram.md` | `feat/operation-model-diagram` | `dev` |
| `feat-server-endpoint-aspect.md` | `feat/server-endpoint-aspect` | `dev` |
| `feat-security-smell-detection.md` | `feat/security-smell-detection` | `dev` |
| `docs-smell-resolution-plan.md` | `docs/smell-resolution-plan` | `dev` |

Merge order matters for `feat/communication-aspect`: it contains the commits of
`feat/rest-technology-information`, so that branch goes first. Most also need
their counterpart in the MRF repository - neither side produces visible output
alone. The `*.diagram` branches are the exception: they read models that already
exist and depend on nothing in MRF.
