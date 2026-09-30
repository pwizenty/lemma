# Regression test for the LEMMA model generation

`de.fhdo.lemma.reconstruction.test.ReconstructionRegressionTest` generates
LEMMA models from recorded reconstruction output and compares them against
models that were reviewed and accepted before. It needs neither a database nor
a running Eclipse application: run it from the IDE with **Run As → Java
Application**, with this bundle as the working directory.

```
test/
  fixtures/<system>/documents.json           input: the documents MRF writes to MongoDB
  expected/<system>/domain/*.data            accepted domain models
  expected/<system>/service/*.services       accepted service models
  expected/<system>/technology/*.technology  copied beside them, never compared
```

A generated model imports its technology model by a relative path, so the
technology models are copied into every system's folder, exactly as the wizard
copies them into the folder it writes to. Without them the imports of an
accepted model do not resolve and the folder shows errors although the models
are right. They are inputs rather than output, so the comparison ignores
them.

The test runs the same generators (`LemmaDomainGenerator`,
`LemmaServiceGenerator`) and the same writer (`ReconstructionModelWriter`,
including extraction, validation and masking) as the reconstruction wizard, so
a difference here is a difference in the wizard's output.

## Accepting new models

`--update` writes the generated models into `expected/` instead of comparing
them. Only ever run it after reading the reported difference and deciding that
the new models are the better ones. An expected model is a reviewed artefact,
not a recording of whatever the generator currently produces.

## Fixtures

A fixture holds exactly the documents the Microservice Reconstruction Framework
writes into the collections `context` and `microservice`:

```json
{ "context": [ … ], "microservice": [ … ] }
```

They can be exported from a MongoDB that MRF has filled, or produced without a
database by transforming the reconstruction result with
`mrf.repositories.domain.data.transform_context_for_database` and
`mrf.repositories.service.service.transform_microservice_for_database`.

### station-service

`de.dmsa.parkandcharge.station.StationService`, exported from the MongoDB that
MRF filled. Its expected models are the ones the reconstruction wizard produced
from those very documents, so this system also guards the test itself: if the
test and the wizard ever disagree, this is where it shows.

### customer-core

The `customer-core` service of Lakeside Mutual
(`https://github.com/Microservice-API-Patterns/LakesideMutual`) at commit
`357ca2d`.

Two of its files are missing from the reconstruction on purpose:

```
src/main/java/com/lakesidemutual/customercore/application/DataLoader.java
src/main/java/com/lakesidemutual/customercore/domain/city/CityLookupService.java
```

Both fail to parse with the Java parser MRF uses, on a nested generic local
variable inside a try-with-resources body
(`MappingIterator<Map<String, String>> readValues = …`), and MRF aborts the
whole run on an unparsable file rather than skipping it. Neither file is an
entity or a REST controller — both are `@Component` — so leaving them out does
not change what the reconstruction finds.
