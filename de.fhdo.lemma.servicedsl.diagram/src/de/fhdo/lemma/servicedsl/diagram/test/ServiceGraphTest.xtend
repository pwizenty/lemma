package de.fhdo.lemma.servicedsl.diagram.test

import de.fhdo.lemma.servicedsl.diagram.Dependency
import de.fhdo.lemma.servicedsl.diagram.DependencyLevel
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
