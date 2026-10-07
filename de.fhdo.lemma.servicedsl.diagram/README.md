# Service model diagrams

Reads LEMMA service models and resolves what they require of each other, so that
a diagram can be drawn from the result. Step 1 of
`docs/service-diagram-plan.md`: the reader and the graph. The generators and the
Eclipse command follow.

## What it does

```
ServiceModelReader.read(Paths.get("CustomerSelfService.services"))
  │
  ├─ loads the model, follows "import microservices" transitively
  ├─ reads what resolves from EMF, the rest from the parse tree
  └─ resolves every "required" entry onto the microservice it names
         │
         └─> ServiceGraph
               services      [CustomerSelfService, CustomerCore]
               dependencies  CustomerSelfService -> CustomerCore (MICROSERVICE)
               problems      []
```

`ServiceGraph` exists so that no generator parses anything. Resolving a
dependency across model files is the hard part of drawing a service model; it
happens once, it is testable on its own, and a further diagram needs no further
reading.

## Why the parse tree is read

A cross-reference of a service model does not resolve outside a running Xtext.
Measured on the four Lakeside Mutual models, loaded into one `XtextResourceSet`
with `ServicePackage`, `DataPackage` and `TechnologyPackage` registered:

```
required microservice -> MicroserviceImpl  proxy=true  name=null
```

Linking across models needs the index that only a running Xtext provides. The
node model is the parse tree of the file, so what the model wrote is still there
— and what it wrote is enough, because it wrote the qualified name.

| Read from EMF | Read from the parse tree |
|---|---|
| import alias, type, URI | the `required` entries |
| microservice name, visibility, type | service aspects, and so the HTTP verb |
| interface name, `noimpl` | a parameter's imported type |
| endpoint addresses | |
| operation name | |
| parameter name, `sync`/`async`, `in`/`out` | |
| a parameter's primitive type | |

## Resolving a required name

```
CustomerCore :: com.lakesidemutual.customercore.CustomerCore . CustomerInformationHolder . getCustomer
└─ alias ──┘    └──────────── microservice ───────────────┘   └──── interface ───────┘   └── op ──┘
```

The alias is looked up in the imports **of the model it was written in**. The
qualified name is then matched as the longest prefix against the microservices
actually found in that file, the match ending on a dot, and the remainder read as
interface and operation.

Matching rather than splitting, because matching detects a name that nothing
declares. Splitting `com.example.orders.Nonexistent.Queries.find` from the end
yields the plausible triple (`Nonexistent`, `Queries`, `find`) and reports a
dependency on a microservice that does not exist.

A dependency that cannot be followed keeps what the model wrote, gets a reason,
and is given an unresolved stub as its target — a dependency the diagram cannot
follow is a fact about the model, not nothing.

## Checking it

```sh
# in this bundle, "Run As -> Java Application" on ServiceGraphTest, or:
java de.fhdo.lemma.servicedsl.diagram.test.ServiceGraphTest

python3 tools/check-bundle-requires.py .
```

`ServiceGraphTest` needs no database and no running Eclipse, which is the point
of keeping the reader free of both. 29 checks over the fixtures in `test/` and
the reconstructed Lakeside Mutual models.

**Every decision it defends was mutation-tested** — a check that cannot fail
proves nothing, and two of these did not fail until the fixture was rewritten to
isolate them:

| Decision | Reversed to | Checks that go red |
|---|---|---|
| the match ends on a dot | `startsWith(name)` | 2 |
| the longest match wins | the first match wins | 4 |
| match what was read | split from the end of the name | 1 |
| a visited set when following imports | follow unconditionally | 1 |

`tools/check-bundle-requires.py` resolves every imported package against the
bundles the manifest requires. It is here because a headless compile cannot see a
missing `Require-Bundle` entry: it uses a flat classpath of every jar of the
Eclipse installation, which ignores OSGi boundaries.

## Not yet here

The generators and the context-menu command — steps 2 to 4 of the plan. Until
then nothing in this bundle is reachable from the user interface.
