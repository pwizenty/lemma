package de.fhdo.lemma.servicedsl.diagram.test

import de.fhdo.lemma.servicedsl.diagram.Dependency
import de.fhdo.lemma.servicedsl.diagram.DependencyLevel
import de.fhdo.lemma.servicedsl.diagram.InterfaceDiagramGenerator
import de.fhdo.lemma.servicedsl.diagram.ServiceGraph
import de.fhdo.lemma.servicedsl.diagram.ServiceModelReader
import java.nio.file.Path
import java.nio.file.Paths

/**
 * Checks that service models are read and their dependencies resolved.
 *
 * Run it from the IDE with "Run As -> Java Application", with this bundle as
 * the working directory. No database and no running Eclipse are needed, which
 * is the point of keeping the reader free of both.
 *
 * Each check states what it would catch, because a check that cannot fail
 * proves nothing.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class ServiceGraphTest {
    static val FIXTURES = "test/fixtures"
    static val LAKESIDE =
        "../de.fhdo.lemma.reconstruction/test/expected/lakeside-mutual/service"

    static var failures = 0
    static var checks = 0

    def static void main(String[] args) {
        theLongestMatchWins
        theMatchEndsOnADot
        anUndeclaredMicroserviceIsNotInvented
        anUndeclaredAliasIsReported
        aCycleOfImportsTerminates
        lakesideMutualResolvesAcrossModels
        theVerbComesFromTheAspectThatSaysSo
        anOperationShowsItsOwnPath
        aResultIsNotConfusedWithAParameter
        anInterfaceNameIsScopedToItsMicroservice
        anInterfaceDiagramShowsTheSelectionOnly

        println('''
        ---
        «checks» check(s), «failures» failed''')
        if (failures > 0) {
            System.exit(1)
        }
    }

    /**
     * One microservice's name is a dot-boundary prefix of another's.
     *
     * ``com.example.orders.Order`` and ``com.example.orders.Order.History`` are
     * both valid prefixes of the required operation's name, so a match that
     * takes the first candidate rather than the longest resolves the dependency
     * onto ``Order`` and then reads three names where it expects two.
     */
    private def static void theLongestMatchWins() {
        val graph = read(FIXTURES + "/prefix-trap/caller.services")
        val dependency = dependencyOf(graph, "LongestWins")

        check("the longest matching name wins",
            dependency?.target?.qualifiedName, "com.example.orders.Order.History")
        check("its interface is read", dependency?.targetInterface, "Queries")
        check("its operation is read", dependency?.targetOperation, "find")
        check("it is resolved", dependency?.resolved, true)
    }

    /**
     * A required name extends a declared one without a dot between them.
     *
     * ``com.example.orders.OrderArchive`` is not declared, but
     * ``com.example.orders.Order`` is, and the one is a textual prefix of the
     * other. Catches a match that does not end on a dot, which resolves this
     * onto ``Order`` - the wrong microservice, named in the diagram as though
     * the model had required it.
     */
    private def static void theMatchEndsOnADot() {
        val graph = read(FIXTURES + "/prefix-trap/caller.services")
        val dependency = dependencyOf(graph, "NeedsBoundary")

        check("a name without a dot boundary does not match",
            dependency?.target?.qualifiedName?.startsWith(
                "com.example.orders.OrderArchive"), true)
        check("and it is not resolved onto the shorter name",
            dependency?.target?.qualifiedName == "com.example.orders.Order", false)
        check("it stays unresolved", dependency?.resolved, false)
    }

    /**
     * A required operation names a microservice the provider does not declare.
     *
     * Catches resolution by position rather than by what was found: taking the
     * last two segments as interface and operation yields the plausible triple
     * (Nonexistent, Queries, find) and reports a dependency on a microservice
     * that does not exist. Matching against the microservices actually read
     * cannot do that.
     */
    private def static void anUndeclaredMicroserviceIsNotInvented() {
        val graph = read(FIXTURES + "/prefix-trap/caller.services")
        val dependency = dependencyOf(graph, "WrongName")

        check("an undeclared microservice stays unresolved",
            dependency?.resolved, false)
        check("a reason is given", dependency?.reason !== null, true)
        check("the edge still has a target to draw",
            dependency?.target !== null, true)
        check("the target is marked unresolved",
            dependency?.target?.resolved, false)
        check("what the model wrote is kept",
            dependency?.written?.contains("Nonexistent"), true)
    }

    /**
     * A dependency is written through an alias that no import declares.
     *
     * Catches an alias looked up without checking the imports of the model it
     * was written in, which would resolve against whatever model happened to be
     * read, or throw.
     */
    private def static void anUndeclaredAliasIsReported() {
        val graph = read(FIXTURES + "/prefix-trap/caller.services")
        val dependency = dependencyOf(graph, "WrongAlias")

        check("an unknown alias stays unresolved", dependency?.resolved, false)
        check("the reason names the alias",
            dependency?.reason?.contains("missing"), true)
    }

    /**
     * Two models import each other.
     *
     * Catches following imports without a visited set, which does not
     * terminate.
     */
    private def static void aCycleOfImportsTerminates() {
        val graph = read(FIXTURES + "/cyclic-imports/a.services")

        check("both microservices are read once", graph.services.size, 2)
        check("both dependencies are resolved",
            graph.dependencies.filter[resolved].size, 2)
        check("nothing went wrong", graph.problems.empty, true)

        val a = graph.dependencies.findFirst[source.name == "A"]
        check("A requires B", a?.target?.name, "B")
        check("at microservice level", a?.level, DependencyLevel.MICROSERVICE)
    }

    /**
     * The reconstructed Lakeside Mutual models, which mix the levels.
     *
     * Catches a reader that does not follow imports: CustomerCore is reached
     * only through the import of CustomerSelfService. Catches a reader that
     * handles one level only: CustomerManagement requires three operations
     * while the others require a whole microservice.
     */
    private def static void lakesideMutualResolvesAcrossModels() {
        val graph = read(LAKESIDE + "/CustomerSelfService.services")
        if (graph.empty) {
            check("the Lakeside Mutual fixture was found", false, true)
            return
        }

        check("CustomerCore is reached through the import",
            graph.services.exists[name == "CustomerCore"], true)
        check("nothing went wrong", graph.problems.empty, true)

        val selfService = dependencyOf(graph, "CustomerSelfService")
        check("CustomerSelfService requires CustomerCore",
            selfService?.target?.name, "CustomerCore")
        check("at microservice level",
            selfService?.level, DependencyLevel.MICROSERVICE)
        check("resolved", selfService?.resolved, true)

        // Reading the whole system is a second step: the detail level only
        // appears in CustomerManagement, which CustomerSelfService does not
        // import.
        val whole = read(#[
            LAKESIDE + "/CustomerSelfService.services",
            LAKESIDE + "/CustomerManagement.services",
            LAKESIDE + "/PolicyManagement.services"
        ])
        val operations = whole.dependencies
            .filter[level === DependencyLevel.OPERATION].toList
        check("CustomerManagement requires three operations",
            operations.size, 3)
        check("every one of them is resolved",
            operations.forall[resolved], true)
        check("they name an interface of CustomerCore",
            operations.forall[targetInterface == "CustomerInformationHolder"], true)
        check("they name the operations",
            operations.map[targetOperation].sort.join(","),
            "getCustomer,getCustomers,updateCustomer")
        check("the levels are mixed, not normalised",
            whole.dependencies.filter[level === DependencyLevel.MICROSERVICE].size, 2)
    }

    /**
     * The verb is read from the aspect, and only where the aspect says it.
     *
     * Catches a verb guessed from the operation's name, and catches
     * ``RequestMapping`` being read as a ``GET``: it carries its verb in a
     * property rather than in its name, so claiming one would state something
     * the model does not say.
     */
    private def static void theVerbComesFromTheAspectThatSaysSo() {
        val diagram = draw(FIXTURES + "/interface-shapes/shapes.services")

        check("GetMapping is a GET",
            diagram.contains("GET read(id : string) : string"), true)
        check("RequestMapping claims no verb",
            diagram.contains("any(id : string) : string"), true)
        check("and is not read as a GET", diagram.contains("GET any"), false)
        check("an operation with no aspect claims no verb",
            diagram.contains("plain(id : string) : string"), true)
    }

    /**
     * An operation's own path is shown beside its verb.
     *
     * Catches a diagram that shows only the interface's path, which would say
     * that every operation of it answers under the same address.
     */
    private def static void anOperationShowsItsOwnPath() {
        val diagram = draw(LAKESIDE + "/CustomerCore.services")

        check("the interface's path is shown once",
            diagram.contains("/customers"), true)
        check("an operation's own path is shown with its verb",
            diagram.contains("GET /{ids} getCustomer("), true)
        check("an operation without one shows none",
            diagram.contains("POST createCustomer("), true)
    }

    /**
     * What an operation returns, and what it does not.
     *
     * Catches an outgoing parameter drawn as a parameter of the call, a fault
     * drawn as the result - which would state that a failure is what the
     * operation returns - and a second outgoing value dropped, which LEMMA
     * allows and a diagram showing only the first would hide.
     */
    private def static void aResultIsNotConfusedWithAParameter() {
        val diagram = draw(FIXTURES + "/interface-shapes/shapes.services")

        check("an operation with nothing outgoing returns void",
            diagram.contains("notify(message : string) : void"), true)
        check("several outgoing values are all shown",
            diagram.contains("split(id : string) : (first : string, second : int)"), true)
        check("a fault is not the result",
            diagram.contains("risky(id : string) : string {fault string}"), true)
        check("an asynchronous operation is marked",
            diagram.contains("stream(id : string) : string {async}"), true)
        check("an optional parameter is marked",
            diagram.contains("search(filter? : string)"), true)
    }

    /**
     * Two microservices of one system offer an interface of the same name.
     *
     * Catches an alias that is only the interface name: PlantUML identifies a
     * type by the name it is declared with whatever package it sits in, so one
     * interface would be drawn holding the operations of both. This is the
     * defect the data model diagram was corrected for.
     */
    private def static void anInterfaceNameIsScopedToItsMicroservice() {
        val diagram = draw(FIXTURES + "/interface-shapes/shapes.services")
        val aliases = diagram.split("\n")
            .filter[contains("interface ") && contains(" as ")]
            .map[substring(indexOf(" as ") + 4).split(" ").head.trim]
            .toList

        check("both Shared interfaces are drawn",
            diagram.split("interface .Shared.").size - 1, 2)
        check("under aliases of their own", aliases.size, aliases.toSet.size)
        check("scoped to the microservice",
            aliases.exists[endsWith("Shapes_Shared")]
                && aliases.exists[endsWith("Helper_Shared")], true)
        check("a microservice that is neither public nor functional says so",
            diagram.contains("package \"Helper\" <<internal, utility>>"), true)
        check("a noimpl interface is marked",
            diagram.contains("<<noimpl>>"), true)
    }

    /**
     * An interface diagram shows the model that was opened, not its imports.
     *
     * The reader follows imports because a dependency diagram needs them, so
     * the graph of CustomerSelfService holds CustomerCore as well. Catches an
     * interface diagram that draws it too: a reader who opens one service model
     * is asking what that service offers, and drawing everything reachable made
     * this diagram two packages wide where it should be one.
     */
    private def static void anInterfaceDiagramShowsTheSelectionOnly() {
        val graph = read(LAKESIDE + "/CustomerSelfService.services")
        val diagram = new InterfaceDiagramGenerator().generate(graph)

        check("the graph still reaches CustomerCore, for the dependencies",
            graph.services.exists[name == "CustomerCore"], true)
        check("the diagram draws the selected service",
            diagram.contains("package \"CustomerSelfService\""), true)
        check("and not the one it imports",
            diagram.contains("package \"CustomerCore\""), false)
        check("exactly one package is drawn",
            diagram.split("package \"").size - 1, 1)
    }

    private def static String draw(String file) {
        return new InterfaceDiagramGenerator().generate(read(file))
    }

    private def static ServiceGraph read(String file) {
        return new ServiceModelReader().read(Paths.get(file))
    }

    private def static ServiceGraph read(Iterable<String> files) {
        return new ServiceModelReader().read(
            files.map[Paths.get(it) as Path].toList)
    }

    /**
     * The one dependency of the microservice of this name.
     */
    private def static Dependency dependencyOf(ServiceGraph graph, String serviceName) {
        return graph.dependencies.findFirst[source.name == serviceName]
    }

    private def static void check(String what, Object actual, Object expected) {
        checks++
        if (expected == actual) {
            println('''  ok    «what»''')
        } else {
            failures++
            println('''  FAIL  «what»: expected «expected», got «actual»''')
        }
    }
}
