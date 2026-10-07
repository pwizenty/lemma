# Service model diagrams

Reads LEMMA service models, resolves what they require of each other, and draws
the interfaces they offer. Steps 1 and 2 of `docs/service-diagram-plan.md`: the
reader, the graph and the interface diagram. The dependency diagrams and the
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

## The interface diagram

```
package "CustomerCore" {
    interface "CustomerInformationHolder" as com_…_CustomerCore_CustomerInformationHolder <<rest>> {
        /customers
        ..
        GET getCustomers(filter : string, limit : int) : PaginatedCustomerResponseDto
        GET /{ids} getCustomer(ids : string) : CustomersResponseDto
        PUT /{customerId} updateCustomer(customerId : CustomerId, …) : CustomerResponseDto
        POST createCustomer(requestDto : CustomerProfileUpdateRequestDto) : CustomerResponseDto
    }
}
```

An interface is an interface, an operation a method, its incoming parameters the
method's parameters and its outgoing one the result. What makes it a REST
interface rather than an abstract one is the verb and the path, so those are on
every operation that has them.

| In the model | In the diagram |
|---|---|
| `microservice` | a package, labelled with its simple name |
| `interface` | an interface, stereotyped with the protocol of its endpoints |
| `@endpoints(…rest:"/customers";)` | the path, on the interface or the operation |
| `@…_aspects.GetMapping` | `GET` in front of the operation |
| `sync in` parameter | a parameter of the method |
| `sync out` parameter | the result; several become a named tuple |
| `fault` parameter | `{fault T}`, never the result |
| `async` parameter | `{async}` |
| `?` | `name? : T` |
| `noimpl` | `<<noimpl>>` |
| a microservice that is not `public functional` | `<<internal, utility>>` on the package |

Three things it deliberately does not do:

- **`RequestMapping` gets no verb.** It carries the verb in a property rather
  than in its name, so claiming `GET` would state something the model does not.
- **It draws the model that was opened, not the models it imports.** The reader
  follows imports because the dependency diagram needs them, so the graph of
  `CustomerSelfService` holds `CustomerCore` too. A reader who opens one service
  model is asking what *that* service offers; drawing everything reachable made
  this diagram two packages at four times as wide as high.
- **A parameter's type is shown by its simple name.** In a service model every
  complex type is imported, so the alias and the context would be on every
  parameter and say nothing about the interface.

`skinparam wrapWidth 500` is emitted because PlantUML does not wrap a class
member by itself, and an operation with several parameters, several results and a
fault runs past 240 characters. The widest reconstructed interface came out
4786x1010 without it and 2638x1504 with it. A model that declares several
microservices in one file is still wide — `examples/parking-spaces` draws five
packages side by side at 2745x188 — because that is what the model holds.

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
of keeping the reader and the generator free of both. 50 checks over the fixtures
in `test/` and the reconstructed Lakeside Mutual models.

A sweep over every service model of the repository backs them up: 31 models, 91
interfaces, 225 operations, nothing silently empty, no two interfaces sharing an
alias, every diagram rendered to valid SVG.

**Every decision it defends was mutation-tested** — a check that cannot fail
proves nothing, and two of these did not fail until the fixture was rewritten to
isolate them:

| Decision | Reversed to | Checks that go red |
|---|---|---|
| the match ends on a dot | `startsWith(name)` | 2 |
| the longest match wins | the first match wins | 4 |
| match what was read | split from the end of the name | 1 |
| a visited set when following imports | follow unconditionally | 1 |
| an interface alias is scoped to its service | the interface name alone | 2 |
| `RequestMapping` claims no verb | mapped to `GET` | 1 |
| a fault is not the result | counted as outgoing | 1 |
| every outgoing value is shown | only the first | 1 |
| an outgoing parameter is not a call parameter | listed as one | 7 |

`tools/check-bundle-requires.py` resolves every imported package against the
bundles the manifest requires. It is here because a headless compile cannot see a
missing `Require-Bundle` entry: it uses a flat classpath of every jar of the
Eclipse installation, which ignores OSGi boundaries.

## Not yet here

The dependency diagrams and the context-menu command — steps 3 and 4 of the
plan. Until then nothing in this bundle is reachable from the user interface.
