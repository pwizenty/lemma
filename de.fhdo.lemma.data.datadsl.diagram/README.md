# Data model diagrams

Generates a PlantUML class diagram from a LEMMA data model. Select one or more
`.data` files in the Project Explorer, **Generate PlantUML diagram** from the
context menu, and a `.puml` lands beside each of them.

```
context CustomerManagement {                 ->   package "CustomerManagement" {
    structure CustomerDto {                           class "CustomerDto" {
        string customerId,                                customerId : string
        CustomerProfileDto customerProfile            }
    }                                              }
}                                                  "CustomerDto" --> "CustomerProfileDto" : customerProfile
```

## What it draws

| In the model | In the diagram |
|---|---|
| `structure` | a class, with its primitive fields as attributes |
| a field whose type is another structure | an association labelled with the field's name |
| `collection` | a class marked `<<collection>>`; a collection of a primitive shows `of <type>` |
| `enum` | an enum with its values |
| `<entity>`, `<valueObject>`, `<aggregate>`, … | UML stereotypes on the class |
| `<identifier>`, `<part>`, `<neverEmpty>` | UML stereotypes on the attribute |
| `unspecified` | shown as it is, so a gap a reconstruction left is visible |
| an imported type | the alias and the type, as the model wrote them |

PlantUML text rather than a picture: it is diffable, it renders in GitHub, VS
Code and LaTeX, and generating it needs nothing installed.

## Why a field of an imported type is an attribute

A reference becomes an association only when the class it points at is in the
same diagram. A type from another model is not, so it stays an attribute with
its name - an arrow to a box that is not drawn would point at nothing.

The name of such a type is read from the parse tree rather than from the linked
model. Linking a type across models needs the index that a running Xtext
provides, and it is not available to a plain resource set - so the diagram shows
what the model wrote, which is right either way.

## Structure

`DataModelDiagramGenerator` is a function of a data model and nothing else: no
file system, no workspace, no Eclipse. `GenerateDataModelDiagramHandler` is the
shell that finds the selected files, loads them and writes the result. Everything
that decides what a diagram looks like is therefore testable without an Eclipse,
and was checked against all 83 data models of this repository - 538 classes, 24
enums, 338 associations, no failures.

## Checking the dependencies this bundle declares

```sh
python3 tools/check-bundle-requires.py .
```

Resolves every package the sources import against the `Export-Package` of the
bundles the manifest requires, following `visibility:=reexport` as Eclipse does,
and fails on one that nothing exports.

This is here because the headless build cannot catch a missing `Require-Bundle`
entry. It compiles against a flat classpath of every jar of the Eclipse
installation, which ignores OSGi boundaries, so a bundle can compile headlessly
and still fail to resolve inside Eclipse - which is how
`org.eclipse.core.runtime` came to be missing from this manifest. The check
takes any bundle directory, not just this one.
