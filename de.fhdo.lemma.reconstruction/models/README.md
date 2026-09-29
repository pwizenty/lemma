# Technology models for the reconstruction

LEMMA models that reconstructed models reference. They are written by hand: the
Microservice Reconstruction Framework does not reconstruct technology models,
it reconstructs what the sources of the analysed system state and leaves the
LEMMA concepts to LEMMA (ADR-0008 of the reconstruction framework).

| Model | Technology | Used by |
|---|---|---|
| `technology/deployment_base.technology` | `DeploymentBase` | operation models |
| `technology/deployment_base_relaxed.technology` | `DeploymentBaseRelaxed` | operation models, while containers carry no service values |
| `technology/spring.technology` | `javaWithSpring` | service models, once they are enhanced with technology |

## What a technology model decides

It is not only a reference target, it is the vocabulary of everything an
operation model may say:

- **`operation environments`** is a closed list. A base image the reconstruction
  reads from a `Dockerfile` can only reach the operation model when it is
  declared here. The list therefore names the images of the analysed systems -
  currently those of Lakeside Mutual: `openjdk:21-slim-buster` for the Java
  services, `node:16` for the frontends, `nginx` for the proxy.
- **`service properties`** declares which keys a `default values { … }` block
  may use, and which of them are mandatory.

## Why there are two deployment models

`OperationDslValidator.checkMandatoryPropertiesHaveValues` reports an error when
a node deploys more services than it has deployment specifications while a
mandatory service property has no value:

```xtend
hasMissingSpecifications =
    operationNode.deploymentSpecifications.size < operationNode.deployedServices.size
```

For a reconstructed container that is `0 < 1`. With `DeploymentBase`, where
`springApplicationName` and `serverPort` are mandatory, every container that
deploys a microservice is therefore an error until the reconstruction reads
those values from the `application.properties` of its service.

`DeploymentBaseRelaxed` drops the two `<mandatory>` markers and changes nothing
else, so a reconstruction that emits containers alone produces a model that
validates. Both declare the deployment technology as `Kubernetes`, so moving
from one to the other changes the import, not the references into it.

An infrastructure node is unaffected either way: it deploys nothing, the check
reads `0 < 0`, and `spring.technology` already declares a `SpringBootAdmin`
infrastructure technology for the node the reconstruction finds in Lakeside
Mutual's Compose specification.
