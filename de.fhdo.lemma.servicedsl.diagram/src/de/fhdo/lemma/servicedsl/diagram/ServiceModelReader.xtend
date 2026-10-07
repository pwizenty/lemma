package de.fhdo.lemma.servicedsl.diagram

import com.google.inject.Injector
import de.fhdo.lemma.ServiceDslStandaloneSetup
import de.fhdo.lemma.data.DataPackage
import de.fhdo.lemma.service.Import
import de.fhdo.lemma.service.ImportType
import de.fhdo.lemma.service.ImportedServiceAspect
import de.fhdo.lemma.service.Endpoint
import de.fhdo.lemma.service.Interface
import de.fhdo.lemma.service.Microservice
import de.fhdo.lemma.service.Operation
import de.fhdo.lemma.service.Parameter
import de.fhdo.lemma.service.ServiceModel
import de.fhdo.lemma.service.ServicePackage
import de.fhdo.lemma.technology.TechnologyPackage
import java.nio.file.Files
import java.nio.file.Path
import java.util.List
import java.util.Map
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EPackage
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.resource.XtextResourceSet

/**
 * Reads service models into a [[ServiceGraph]], following their imports.
 *
 * A dependency crosses model files, so reading one file is not enough: the
 * imports of a model are followed transitively until nothing new is reachable,
 * and every ``required`` entry is then resolved against the microservices that
 * were found.
 *
 * ## Why the parse tree is read
 *
 * A cross-reference of a service model does not resolve outside a running
 * Xtext. Measured on the four Lakeside Mutual models, loaded into one resource
 * set with every EPackage registered:
 *
 *     required microservice -> MicroserviceImpl  proxy=true  name=null
 *
 * Linking across models needs the index that only a running Xtext provides. The
 * node model is the parse tree of the file, so what the model wrote is still
 * there - and what it wrote is enough, because it wrote the qualified name.
 *
 * Local features are therefore read from EMF, and cross-references - the
 * ``required`` entries, the aspects, a parameter's imported type - from the
 * parse tree.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class ServiceModelReader {
    static val SERVICES_EXTENSION = ".services"
    static val ALIAS_SEPARATOR = "::"

    val XtextResourceSet resourceSet

    /**
     * Imports of each model read, as alias to the model it names.
     */
    val Map<String, Map<String, String>> importsByModel = newLinkedHashMap

    /**
     * What a microservice requires, kept until every model has been read:
     * a dependency may point at a model that is only reached later.
     */
    val List<PendingDependency> pending = newLinkedList

    new() {
        EPackage.Registry.INSTANCE.put(ServicePackage.eNS_URI, ServicePackage.eINSTANCE)
        EPackage.Registry.INSTANCE.put(DataPackage.eNS_URI, DataPackage.eINSTANCE)
        EPackage.Registry.INSTANCE.put(TechnologyPackage.eNS_URI, TechnologyPackage.eINSTANCE)
        val Injector injector = new ServiceDslStandaloneSetup()
            .createInjectorAndDoEMFRegistration
        resourceSet = injector.getInstance(XtextResourceSet)
    }

    /**
     * Read a service model and everything it imports.
     *
     * @param entry the service model to start from
     * @return the microservices reachable from it, dependencies resolved
     */
    def ServiceGraph read(Path entry) {
        return read(#[entry])
    }

    /**
     * Read service models and everything they import.
     *
     * @param entries the service models to start from
     * @return the microservices reachable from them, dependencies resolved
     */
    def ServiceGraph read(List<Path> entries) {
        val graph = new ServiceGraph
        val queue = <String>newLinkedList
        val visited = <String>newLinkedHashSet

        for (entry : entries) {
            val file = canonical(entry)
            queue.add(file)
            graph.addEntryFile(file)
        }

        while (!queue.empty) {
            val file = queue.remove(0)
            if (visited.add(file)) {
                // A model that cannot be read must not stop the others.
                try {
                    queue.addAll(readModel(file, graph))
                } catch (Exception exception) {
                    graph.addProblem('''«file»: «exception.message»''')
                }
            }
        }

        resolveDependencies(graph)
        return graph
    }

    /**
     * Read one model into the graph, and return the service models it imports.
     */
    private def List<String> readModel(String file, ServiceGraph graph) {
        val path = Path.of(file)
        if (!Files.isRegularFile(path)) {
            throw new IllegalStateException("no such file")
        }

        val resource = resourceSet.createResource(URI.createFileURI(file))
        resource.load(resourceSet.loadOptions)
        if (resource.contents.empty) {
            throw new IllegalStateException("the file holds no service model")
        }
        val model = resource.contents.head
        if (!(model instanceof ServiceModel)) {
            throw new IllegalStateException("the file holds no service model")
        }

        val serviceModel = model as ServiceModel
        val imports = newLinkedHashMap
        val reachable = <String>newLinkedList

        for (anImport : serviceModel.imports) {
            // Xtend has no continue, and an import naming no usable file is
            // simply not recorded.
            val target = importedFile(anImport, path)
            if (target !== null) {
                imports.put(anImport.name, target)
                // Only another service model can hold a microservice, so only
                // one is worth following.
                if (anImport.importType === ImportType.MICROSERVICES) {
                    reachable.add(target)
                }
            }
        }
        importsByModel.put(file, imports)

        for (microservice : serviceModel.microservices) {
            graph.add(readMicroservice(microservice, file))
        }
        return reachable
    }

    /**
     * The file an import names, resolved against the importing model.
     *
     * @return the absolute path, or null when the import names no usable file
     */
    private def String importedFile(Import anImport, Path model) {
        val uri = anImport.importURI
        if (uri.nullOrEmpty) {
            return null
        }
        try {
            return canonical(model.parent.resolve(uri))
        } catch (Exception exception) {
            return null
        }
    }

    /**
     * Read a microservice, its interfaces and what it requires.
     */
    private def ServiceNode readMicroservice(Microservice microservice, String file) {
        val node = new ServiceNode(microservice.name)
        node.modelFile = file
        node.visibility = microservice.visibility?.toString
        node.type = microservice.type?.toString
        node.aspects.addAll(microservice.aspects.map[aspectReference])

        for (anInterface : microservice.interfaces) {
            node.interfaces.add(readInterface(anInterface))
        }

        // Kept rather than resolved: the model it points at may not have been
        // read yet.
        for (required : microservice.requiredMicroservices) {
            pending.add(new PendingDependency(
                node, DependencyLevel.MICROSERVICE, written(required), file))
        }
        for (required : microservice.requiredInterfaces) {
            pending.add(new PendingDependency(
                node, DependencyLevel.INTERFACE, written(required), file))
        }
        for (required : microservice.requiredOperations) {
            pending.add(new PendingDependency(
                node, DependencyLevel.OPERATION, written(required), file))
        }
        return node
    }

    private def InterfaceNode readInterface(Interface anInterface) {
        val node = new InterfaceNode(anInterface.name)
        node.notImplemented = anInterface.notImplemented
        node.aspects.addAll(anInterface.aspects.map[aspectReference])
        for (endpoint : anInterface.endpoints) {
            node.endpoints.add(endpointReference(endpoint))
        }
        for (operation : anInterface.operations) {
            node.operations.add(readOperation(operation))
        }
        return node
    }

    private def OperationNode readOperation(Operation operation) {
        val node = new OperationNode(operation.name)
        node.notImplemented = operation.notImplemented
        node.aspects.addAll(operation.aspects.map[aspectReference])
        for (endpoint : operation.endpoints) {
            node.endpoints.add(endpointReference(endpoint))
        }
        for (parameter : operation.parameters) {
            node.parameters.add(readParameter(parameter))
        }
        return node
    }

    private def ParameterNode readParameter(Parameter parameter) {
        val node = new ParameterNode(parameter.name)
        node.communicationType = parameter.communicationType?.toString
        node.exchangePattern = parameter.exchangePattern?.toString
        node.optional = parameter.optional
        node.fault = parameter.communicatesFault
        node.aspects.addAll(parameter.aspects.map[aspectReference])

        val primitiveType = parameter.primitiveType
        if (primitiveType !== null) {
            node.primitive = true
            node.typeName = primitiveType.typeName
            return node
        }
        // An imported type is a cross-reference, so what the model wrote is all
        // there is - and it wrote the alias and the qualified name.
        node.typeName = written(parameter.importedType)
        return node
    }

    /**
     * An endpoint as its protocol and its addresses.
     *
     * The protocol is a cross-reference, so its name is read from what the
     * model wrote: ``javaWithSpring::_protocols.rest`` is ``rest``.
     */
    private def EndpointReference endpointReference(Endpoint endpoint) {
        val protocol = endpoint.protocols.map[protocolName(written(it))]
            .filterNull.join(", ")
        val reference = new EndpointReference(
            if (protocol.empty) null else protocol)
        reference.addresses.addAll(endpoint.addresses)
        return reference
    }

    /**
     * The name of a protocol, read from what the model wrote.
     *
     * ``javaWithSpring::_protocols.rest`` is a ``rest``; a data format in
     * parentheses behind it is not part of the name.
     */
    static def String protocolName(String written) {
        if (written.nullOrEmpty) {
            return null
        }
        var text = written
        val parenthesis = text.indexOf("(")
        if (parenthesis >= 0) {
            text = text.substring(0, parenthesis)
        }
        val separator = text.lastIndexOf(".")
        if (separator >= 0) {
            text = text.substring(separator + 1)
        }
        return text.trim
    }

    /**
     * An aspect as its name and as the model wrote it.
     */
    private def AspectReference aspectReference(ImportedServiceAspect aspect) {
        val text = written(aspect)
        return new AspectReference(aspectName(text), text)
    }

    /**
     * The name of an aspect, read from what the model wrote.
     *
     * ``@javaWithSpring::_aspects.GetMapping(…)`` is a ``GetMapping``: the
     * property values and the path to the aspect are not what a diagram decides
     * by.
     */
    static def String aspectName(String written) {
        if (written.nullOrEmpty) {
            return null
        }
        var text = written
        val parenthesis = text.indexOf("(")
        if (parenthesis >= 0) {
            text = text.substring(0, parenthesis)
        }
        val separator = text.lastIndexOf(".")
        if (separator >= 0) {
            text = text.substring(separator + 1)
        }
        return text.replace("@", "").trim
    }

    /**
     * Resolve every kept dependency, now that every model has been read.
     */
    private def void resolveDependencies(ServiceGraph graph) {
        for (entry : pending) {
            graph.add(resolve(entry, graph))
        }
        pending.clear
    }

    /**
     * Resolve one dependency onto the microservice it points at.
     */
    private def Dependency resolve(PendingDependency entry, ServiceGraph graph) {
        val dependency = new Dependency(entry.source, entry.level, entry.written)
        if (entry.written.nullOrEmpty) {
            return unresolved(dependency, "the model names nothing")
        }

        val text = entry.written.replaceAll("\\s+", "")
        val separator = text.indexOf(ALIAS_SEPARATOR)
        var String alias = null
        var String qualifiedName = text
        if (separator >= 0) {
            alias = text.substring(0, separator)
            qualifiedName = text.substring(separator + ALIAS_SEPARATOR.length)
        }

        // Without an alias the dependency is on a microservice of the same
        // model; with one, on a microservice of the model that alias imports.
        var String targetFile = entry.modelFile
        if (alias !== null) {
            targetFile = importsByModel.get(entry.modelFile)?.get(alias)
            if (targetFile === null) {
                return unresolved(dependency,
                    '''no import is named «alias»''')
            }
        }

        val candidates = graph.servicesOf(targetFile)
        if (candidates.empty) {
            return unresolved(dependency,
                '''«targetFile» declares no microservice''')
        }

        val service = longestPrefix(qualifiedName, candidates)
        if (service === null) {
            return unresolved(dependency,
                '''no microservice of «targetFile» is named in it''')
        }
        dependency.target = service

        val remainder = remainderAfter(qualifiedName, service.qualifiedName)
        return switch (entry.level) {
            case MICROSERVICE:
                if (remainder.empty)
                    dependency
                else
                    unresolved(dependency,
                        '''a microservice is required but «remainder.join(".")» follows its name''')
            case INTERFACE:
                resolveInterface(dependency, service, remainder)
            case OPERATION:
                resolveOperation(dependency, service, remainder)
        }
    }

    private def Dependency resolveInterface(Dependency dependency, ServiceNode service,
        List<String> remainder) {
        if (remainder.size !== 1) {
            return unresolved(dependency,
                '''an interface is required but «remainder.size» name(s) follow the microservice''')
        }
        dependency.targetInterface = remainder.head
        if (service.interfaceOf(remainder.head) === null) {
            return unresolved(dependency,
                '''«service.name» declares no interface «remainder.head»''')
        }
        return dependency
    }

    private def Dependency resolveOperation(Dependency dependency, ServiceNode service,
        List<String> remainder) {
        if (remainder.size !== 2) {
            return unresolved(dependency,
                '''an operation is required but «remainder.size» name(s) follow the microservice''')
        }
        dependency.targetInterface = remainder.get(0)
        dependency.targetOperation = remainder.get(1)

        val anInterface = service.interfaceOf(remainder.get(0))
        if (anInterface === null) {
            return unresolved(dependency,
                '''«service.name» declares no interface «remainder.get(0)»''')
        }
        if (anInterface.operationOf(remainder.get(1)) === null) {
            return unresolved(dependency,
                '''«remainder.get(0)» declares no operation «remainder.get(1)»''')
        }
        return dependency
    }

    /**
     * The microservice whose qualified name is the longest prefix of a name.
     *
     * A microservice name is itself qualified and the number of parts it has is
     * not fixed, so a required operation cannot be split positionally:
     *
     *     com.lakesidemutual.customercore.CustomerCore . CustomerInformationHolder . getCustomer
     *     └──────────── microservice ───────────────┘   └──── interface ───────┘   └── op ──┘
     *
     * The name is matched against the microservices that were actually found,
     * longest first, and only what is left over is read as interface and
     * operation. The match ends on a dot, so a microservice whose name is a
     * prefix of another's does not swallow it.
     */
    private def ServiceNode longestPrefix(String qualifiedName, List<ServiceNode> candidates) {
        var ServiceNode match = null
        for (candidate : candidates) {
            val name = candidate.qualifiedName
            if (name !== null
                && (qualifiedName == name || qualifiedName.startsWith(name + "."))
                && (match === null || name.length > match.qualifiedName.length)) {
                match = candidate
            }
        }
        return match
    }

    /**
     * The parts of a qualified name that follow a microservice's name.
     */
    private def List<String> remainderAfter(String qualifiedName, String serviceName) {
        if (qualifiedName.length <= serviceName.length) {
            return emptyList
        }
        val rest = qualifiedName.substring(serviceName.length + 1)
        return rest.split("\\.").filter[!empty].toList
    }

    private def Dependency unresolved(Dependency dependency, String reason) {
        dependency.resolved = false
        dependency.reason = reason
        if (dependency.target === null) {
            // A stub, so the diagram can still draw the edge to something.
            val stub = new ServiceNode(stubName(dependency.written))
            stub.resolved = false
            dependency.target = stub
        }
        return dependency
    }

    /**
     * The name to show for a dependency that could not be followed: what the
     * model wrote, without the alias.
     */
    private def String stubName(String written) {
        if (written.nullOrEmpty) {
            return "<unnamed>"
        }
        val text = written.replaceAll("\\s+", "")
        val separator = text.indexOf(ALIAS_SEPARATOR)
        return if (separator >= 0) text.substring(separator + ALIAS_SEPARATOR.length) else text
    }

    /**
     * What the model wrote for an element, read from the parse tree.
     *
     * The only way to read a cross-reference without a running Xtext.
     */
    private def String written(EObject element) {
        if (element === null) {
            return null
        }
        val node = NodeModelUtils.findActualNodeFor(element)
        if (node === null) {
            return null
        }
        val text = NodeModelUtils.getTokenText(node)?.trim
        return if (text.nullOrEmpty) null else text
    }

    /**
     * Whether a file is a service model, by its name.
     */
    static def boolean isServiceModel(String file) {
        return file !== null && file.endsWith(SERVICES_EXTENSION)
    }

    private def String canonical(Path path) {
        return path.toAbsolutePath.normalize.toString
    }
}

/**
 * A dependency read but not yet resolved.
 *
 * Resolution waits until every model has been read, because a dependency may
 * point at a model that is only reached through another one.
 */
class PendingDependency {
    public val ServiceNode source
    public val DependencyLevel level
    public val String written
    public val String modelFile

    new(ServiceNode source, DependencyLevel level, String written, String modelFile) {
        this.source = source
        this.level = level
        this.written = written
        this.modelFile = modelFile
    }
}
