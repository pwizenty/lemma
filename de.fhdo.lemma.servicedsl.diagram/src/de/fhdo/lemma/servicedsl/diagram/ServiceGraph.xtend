package de.fhdo.lemma.servicedsl.diagram

import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * The microservices of a system, what they offer and what they require.
 *
 * Built by [[ServiceModelReader]] from one or more service models, with every
 * dependency already resolved to the microservice it points at. It exists so
 * that no generator parses anything: resolving a dependency across model files
 * is the hard part of drawing a service model, it happens once, it is testable
 * on its own, and a further diagram needs no further reading.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class ServiceGraph {
    @Accessors(PUBLIC_GETTER)
    val List<ServiceNode> services = newLinkedList

    @Accessors(PUBLIC_GETTER)
    val List<Dependency> dependencies = newLinkedList

    /**
     * Problems met while reading, reported rather than thrown.
     *
     * A model that cannot be read must not stop the others, and what could not
     * be read is itself worth saying.
     */
    @Accessors(PUBLIC_GETTER)
    val List<String> problems = newLinkedList

    def void add(ServiceNode service) {
        services.add(service)
    }

    def void add(Dependency dependency) {
        dependencies.add(dependency)
    }

    def void addProblem(String problem) {
        problems.add(problem)
    }

    /**
     * The microservice of this qualified name, or null.
     */
    def ServiceNode serviceOf(String qualifiedName) {
        return services.findFirst[it.qualifiedName == qualifiedName]
    }

    /**
     * The microservices a model file declares.
     */
    def List<ServiceNode> servicesOf(String modelFile) {
        return services.filter[it.modelFile == modelFile].toList
    }

    /**
     * Whether anything was read at all.
     */
    def boolean isEmpty() {
        return services.empty
    }
}

/**
 * A microservice, with the interfaces it offers.
 *
 * A microservice a dependency points at but no read model declares is kept as a
 * stub: ``resolved`` is false and only its name is known. A dependency the
 * diagram cannot follow is a fact about the model, not nothing.
 */
class ServiceNode {
    @Accessors
    String qualifiedName

    /**
     * The last segment of the qualified name, which is what a diagram labels a
     * microservice with.
     */
    @Accessors
    String name

    @Accessors
    String visibility

    @Accessors
    String type

    /**
     * Absolute path of the model that declares it, null for a stub.
     */
    @Accessors
    String modelFile

    @Accessors
    boolean resolved = true

    @Accessors
    val List<AspectReference> aspects = newLinkedList

    @Accessors
    val List<InterfaceNode> interfaces = newLinkedList

    new(String qualifiedName) {
        this.qualifiedName = qualifiedName
        this.name = simpleNameOf(qualifiedName)
    }

    def InterfaceNode interfaceOf(String interfaceName) {
        return interfaces.findFirst[it.name == interfaceName]
    }

    /**
     * The name a qualified name ends with.
     */
    static def String simpleNameOf(String qualifiedName) {
        if (qualifiedName === null) {
            return null
        }
        val separator = qualifiedName.lastIndexOf(".")
        return if (separator >= 0) qualifiedName.substring(separator + 1) else qualifiedName
    }
}

/**
 * An interface of a microservice, with its operations.
 */
class InterfaceNode {
    @Accessors
    String name

    @Accessors
    boolean notImplemented

    /**
     * The addresses its endpoints answer under, as the model wrote them.
     */
    @Accessors
    val List<String> endpoints = newLinkedList

    @Accessors
    val List<AspectReference> aspects = newLinkedList

    @Accessors
    val List<OperationNode> operations = newLinkedList

    new(String name) {
        this.name = name
    }

    def OperationNode operationOf(String operationName) {
        return operations.findFirst[it.name == operationName]
    }
}

/**
 * An operation of an interface, with its parameters.
 */
class OperationNode {
    @Accessors
    String name

    @Accessors
    boolean notImplemented

    /**
     * Its own endpoint addresses, which extend its interface's.
     */
    @Accessors
    val List<String> endpoints = newLinkedList

    @Accessors
    val List<AspectReference> aspects = newLinkedList

    @Accessors
    val List<ParameterNode> parameters = newLinkedList

    new(String name) {
        this.name = name
    }
}

/**
 * A parameter of an operation.
 */
class ParameterNode {
    @Accessors
    String name

    /**
     * ``SYNCHRONOUS`` or ``ASYNCHRONOUS``.
     */
    @Accessors
    String communicationType

    /**
     * ``IN``, ``OUT`` or null.
     */
    @Accessors
    String exchangePattern

    /**
     * The name of its type: a primitive's own name, or an imported type as the
     * model wrote it, alias included.
     */
    @Accessors
    String typeName

    @Accessors
    boolean primitive

    @Accessors
    boolean optional

    @Accessors
    val List<AspectReference> aspects = newLinkedList

    new(String name) {
        this.name = name
    }
}

/**
 * A technology aspect a model element carries.
 *
 * Kept as both the name and what the model wrote, because an aspect is a
 * cross-reference and therefore only readable as text outside a running Xtext.
 * The name is what a diagram decides by - a ``GetMapping`` is a ``GET`` - and
 * the written form keeps the property values a name drops.
 */
class AspectReference {
    @Accessors
    String name

    @Accessors
    String written

    new(String name, String written) {
        this.name = name
        this.written = written
    }
}

/**
 * The level a dependency is declared at.
 *
 * LEMMA offers ``required microservices``, ``required interfaces`` and
 * ``required operations`` as alternatives rather than as layers, and a system
 * may use different ones for different microservices - Lakeside Mutual does.
 */
enum DependencyLevel {
    MICROSERVICE,
    INTERFACE,
    OPERATION
}

/**
 * One microservice requiring something of another.
 */
class Dependency {
    @Accessors
    ServiceNode source

    @Accessors
    ServiceNode target

    @Accessors
    DependencyLevel level

    /**
     * The interface it requires, or null when it requires the whole service.
     */
    @Accessors
    String targetInterface

    /**
     * The operation it requires, or null when it requires more than one.
     */
    @Accessors
    String targetOperation

    /**
     * What the model wrote, which is the only thing an unresolved dependency
     * has to show.
     */
    @Accessors
    String written

    @Accessors
    boolean resolved = true

    /**
     * Why it could not be resolved, or null.
     */
    @Accessors
    String reason

    new(ServiceNode source, DependencyLevel level, String written) {
        this.source = source
        this.level = level
        this.written = written
    }
}
