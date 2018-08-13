/*
 * generated by Xtext 2.12.0
 */
package de.fhdo.ddmm.scoping

import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import de.fhdo.ddmm.service.ServicePackage
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.scoping.impl.MapBasedScope
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.EcoreUtil2
import de.fhdo.ddmm.data.DataModel
import org.eclipse.xtext.resource.EObjectDescription
import de.fhdo.ddmm.utils.DdmmUtils
import de.fhdo.ddmm.service.ImportedType
import de.fhdo.ddmm.technology.Technology
import de.fhdo.ddmm.service.ImportedProtocol
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.scoping.Scopes
import de.fhdo.ddmm.service.Microservice
import de.fhdo.ddmm.ServiceDslQualifiedNameProvider
import com.google.inject.Inject
import de.fhdo.ddmm.service.ServiceModel
import de.fhdo.ddmm.service.Parameter
import de.fhdo.ddmm.service.Interface
import de.fhdo.ddmm.service.ReferredOperation
import java.util.List
import de.fhdo.ddmm.service.PossiblyImportedInterface
import de.fhdo.ddmm.service.Import
import de.fhdo.ddmm.service.PossiblyImportedOperation
import de.fhdo.ddmm.service.PossiblyImportedMicroservice
import de.fhdo.ddmm.service.Operation
import com.google.common.base.Predicate

/**
 * This class implements a custom scope providerfor the Service DSL.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de>Florian Rademacher</a>
 */
class ServiceDslScopeProvider extends AbstractServiceDslScopeProvider {
    @Inject
    private ServiceDslQualifiedNameProvider nameProvider

    /**
     * Build scope for a given context and a given reference
     */
    override getScope(EObject context, EReference reference) {
        val scope = switch (context) {
            /* Microservices */
            Microservice: context.getScope(reference)

            /* Possibly imported microservices */
            PossiblyImportedMicroservice: context.getScope(reference)

            /* Possibly imported interfaces */
            PossiblyImportedInterface: context.getScope(reference)

            /* Possibly imported operations */
            PossiblyImportedOperation: context.getScope(reference)

            /* Parameters */
            Parameter: context.getScope(reference)

            /* Referred operations */
            ReferredOperation: context.getScope(reference)

            /* Imported type */
            ImportedType: context.getScope(reference)

            /* Imported protocol */
            ImportedProtocol: context.getScope(reference)
        }

        if (scope !== null)
            return scope

        // Try default scope resolution, if no scope could be determined
        else if (scope === null)
            return super.getScope(context, reference)
    }

    /**
     * Build scope for microservices and the given reference
     */
    private def getScope(Microservice microservice, EReference reference) {
        switch (reference) {
            /* Super microservices */
            case ServicePackage::Literals.MICROSERVICE__SUPER:
                return microservice.getScopeForSuperMicroservice(reference)

            /*
             * Available imports and their aliases for possibly imported microservices, interfaces
             * and operations that could potentially be required by a microservice
             */
            case ServicePackage::Literals.POSSIBLY_IMPORTED_MICROSERVICE__IMPORT,
                case ServicePackage::Literals.POSSIBLY_IMPORTED_INTERFACE__IMPORT,
                case ServicePackage::Literals.POSSIBLY_IMPORTED_OPERATION__IMPORT:
                return microservice.getScopeForImportsOfType(ServiceModel)

            /*
             * Possibly imported, required microservices (will be passed by the scope provider in
             * the context of a Microservice, if no import is given. Otherwise this will happen with
             * an instance of the PossiblyImportedMicroservice concept as the context).
             */
            case ServicePackage::Literals.POSSIBLY_IMPORTED_MICROSERVICE__MICROSERVICE:
                return microservice.getScopeForPossiblyImportedMicroservice()

            /*
             * Possibly imported, required interfaces (will be passed by the scope provider in the
             * context of a Microservice, if no import is given. Otherwise this will happen with an
             * instance of the PossiblyImportedInterface concept as the context).
             */
            case ServicePackage::Literals.POSSIBLY_IMPORTED_INTERFACE__INTERFACE:
                return microservice.getScopeForPossiblyImportedInterface()

            /*
             * Possibly imported, required operations (will be passed by the scope provider in the
             * context of a Microservice, if no import is given. Otherwise this will happen with an
             * instance of the PossiblyImportedOperation concept as the context).
             */
            case ServicePackage::Literals.POSSIBLY_IMPORTED_OPERATION__OPERATION:
                return microservice.getScopeForPossiblyImportedOperation()

            /*
             * Annotated technology
             */
            case ServicePackage::Literals.MICROSERVICE__TECHNOLOGY:
                return microservice.getScopeForImportsOfType(Technology)
        }

        return null
    }

    /**
     * Build scope for possibly imported microservices and the given reference
     */
    private def getScope(PossiblyImportedMicroservice importedMicroservice, EReference reference) {
        switch (reference) {
            /*
             * Available imports and their aliases for possibly imported microservices that could
             * potentially be required by a microservice
             */
            case ServicePackage::Literals.POSSIBLY_IMPORTED_MICROSERVICE__IMPORT:
                return importedMicroservice.getScopeForImportsOfType(ServiceModel)

            /*
             * Possibly imported, required microservices. The scope provider will delegate the scope
             * resolution with PossiblyImportedMicroservice as the context, if its import feature
             * was set. Otherwise, the context will be an instance of Microservice (see above).
             */
            case ServicePackage::Literals.POSSIBLY_IMPORTED_MICROSERVICE__MICROSERVICE:
                return importedMicroservice
                    .getScopeForPossiblyImportedMicroservice(importedMicroservice.import)
        }

        return null
    }

    /**
     * Build scope for possibly imported interface and the given reference
     */
    private def getScope(PossiblyImportedInterface importedInterface, EReference reference) {
        switch (reference) {
            /*
             * Available imports and their aliases for possibly imported interfaces that could
             * potentially be required by a microservice
             */
            case ServicePackage::Literals.POSSIBLY_IMPORTED_INTERFACE__IMPORT:
                return importedInterface.getScopeForImportsOfType(ServiceModel)

            /*
             * Possibly imported, required interfaces. The scope provider will delegate the scope
             * resolution with PossiblyImportedInterface as the context, if its import feature was
             * set. Otherwise, the context will be an instance of Microservice (see above).
             */
            case ServicePackage::Literals.POSSIBLY_IMPORTED_INTERFACE__INTERFACE:
                return importedInterface
                    .getScopeForPossiblyImportedInterface(importedInterface.import)
        }

        return null
    }

    /**
     * Build scope for possibly imported operation and the given reference
     */
    private def getScope(PossiblyImportedOperation importedOperation, EReference reference) {
        switch (reference) {
            /*
             * Available imports and their aliases for possibly imported operations that could
             * potentially be required by a microservice
             */
            case ServicePackage::Literals.POSSIBLY_IMPORTED_OPERATION__IMPORT:
                return importedOperation.getScopeForImportsOfType(ServiceModel)

            /*
             * Possibly imported, required operations. The scope provider will delegate the scope
             * resolution with PossiblyImportedOperation as the context, if its import feature was
             * set. Otherwise, the context will be an instance of Microservice (see above).
             */
            case ServicePackage::Literals.POSSIBLY_IMPORTED_OPERATION__OPERATION:
                return importedOperation
                    .getScopeForPossiblyImportedOperation(importedOperation.import)
        }

        return null
    }

    /**
     * Build scope for parameters of operations
     */
    private def getScope(Parameter parameter, EReference reference) {
        switch (reference) {
            /*
             * Available imports and their aliases for possibly imported operations that could
             * potentially initialize the parameter
             */
            case ServicePackage::Literals.POSSIBLY_IMPORTED_OPERATION__IMPORT:
                return parameter.getScopeForOperationImport()

            /*
             * Possibly imported, operations that may initialize the parameter. The scope provider
             * will delegate the scope resolution with PossiblyImportedOperation as the context, if
             * its import feature was set. Otherwise, the context will be an instance of
             * Microservice (see above).
             */
            case ServicePackage::Literals.POSSIBLY_IMPORTED_OPERATION__OPERATION:
                return parameter.getScopeForInitializingOperation()
        }

        return null
    }

    /**
     * Build scope for referred operations in interfaces
     */
    private def getScope(ReferredOperation operation, EReference reference) {
        if (reference != ServicePackage::Literals.REFERRED_OPERATION__OPERATION)
            return IScope.NULLSCOPE

        // The interface may refer to all operations of its siblings, i.e., all interfaces of its
        // containing microservice
        val scopeElements = EcoreUtil2.getSiblingsOfType(operation.interface, Interface)
            .map[it.operations]
            .flatten
            .map[
                val operationName = QualifiedName.create(it.interface.name, it.name)
                EObjectDescription.create(operationName, it)
            ]

        return MapBasedScope.createScope(IScope.NULLSCOPE, scopeElements)
    }

    /**
     * Build scope for imported types of operation parameters
     */
    private def getScope(ImportedType importedType, EReference reference) {
        switch (reference) {
            /*
             * Available imports and their aliases for imported types used to specify the parameter
             */
            case ServicePackage::Literals.IMPORTED_TYPE__IMPORT:
                return importedType.getScopeForImportsOfType(DataModel, Technology)

            /* Type of an imported type */
            case ServicePackage::Literals.IMPORTED_TYPE__TYPE:
                return importedType.getScopeForImportedType()
        }

        return null
    }

    /**
     * Build scope for imported types of operation parameters
     */
    private def getScopeForImportedType(ImportedType importedType) {
        val resourceContents = getImportedModelContents(importedType.eResource,
            importedType.import.importURI)
        if (resourceContents === null || resourceContents.empty)
            return IScope.NULLSCOPE

        // Types may be imported from data models (complex types) or technology models (technology-
        // specific primitive types)
        val resourceRoot = resourceContents.get(0)
        switch (resourceRoot) {
            DataModel: return resourceRoot.getScopeForImportedComplexTypes
            Technology: return resourceRoot.getScopeForImportedTypes
            default: return IScope.NULLSCOPE
        }
    }

    /**
     * Build scope for imported protocols used to annotate microservices, interface, or operations
     */
    private def getScope(ImportedProtocol protocol, EReference reference) {
        switch (reference) {
            /*
             * Available imports and their aliases for protocols imported from technology models
             * for the annotated element
             */
            case ServicePackage.Literals.IMPORTED_PROTOCOL__IMPORT:
                return protocol.getScopeForImportsOfType(Technology)

            /* Protocols */
            case ServicePackage::Literals.IMPORTED_PROTOCOL__PROTOCOL:
                return protocol.getScopeForImportedProtocol()

            /* Data formats corresponding to an imported protocol */
            case ServicePackage::Literals.IMPORTED_PROTOCOL__DATA_FORMAT:
                return protocol.getScopeForDataFormat()
        }

        return null
    }

    /**
     * Convenience method for building a scope for a possibly imported microservice without an
     * import specification
     */
    private def getScopeForPossiblyImportedMicroservice(EObject context) {
        return getScopeForPossiblyImportedMicroservice(context, null)
    }

    /**
     * Helper method to build a scope for possibly imported microservices, i.e., a microservices
     * with or without import specifications. Microservices required by another microservice may
     * possibly be imported.
     */
    private def getScopeForPossiblyImportedMicroservice(EObject context, Import ^import) {
        if (!(
            context instanceof Microservice ||
            context instanceof PossiblyImportedMicroservice
        ))
            return IScope.NULLSCOPE

        /* Determine relevant microservice */
        val microservice =
            switch (context) {
                Microservice: context as Microservice

                // Possibly imported microservice is required by microservice
                PossiblyImportedMicroservice: EcoreUtil2.getContainerOfType(context, Microservice)
            }

        /*
         * Build the scope considering possible import specification:
         *     - If no import specification is given, get all microservices that can be required by
         *       by the determined microservice from the current service model.
         *     - If an import specification is given, get all microservices that can be required by
         *       the determined microservice from the service model the import specification points
         *       to.
         */
        val importUri = if (import !== null) import.importURI else null
        return DdmmUtils.getScopeForPossiblyImportedConcept(
            microservice,
            microservice.qualifiedNameParts,
            ServiceModel,
            importUri,
            [microservices.toList],
            [qualifiedNameParts],
            [microservice.canRequire(it, importUri !== null)]
        )
    }

    /**
     * Convenience method to build a scope for a possibly imported interface without an import
     * specification
     */
    private def getScopeForPossiblyImportedInterface(EObject context) {
        return getScopeForPossiblyImportedInterface(context, null)
    }

    /**
     * Build scope for possibly imported interfaces, i.e., interfaces with or without import
     * specifications. Interfaces required by a microservice may possibly be imported.
     */
    private def getScopeForPossiblyImportedInterface(EObject context, Import ^import) {
        if (!(
            context instanceof Microservice ||
            context instanceof PossiblyImportedInterface
        ))
            return IScope.NULLSCOPE

        /* Determine relevant microservice */
        val microservice =
            switch (context) {
                Microservice: context as Microservice

                // Possibly imported interface is required by microservice
                PossiblyImportedInterface: EcoreUtil2.getContainerOfType(context, Microservice)
            }

        /*
         * Build the scope considering possible import specification:
         *     - If no import specification is given, get all interfaces that can be required by
         *       by the determined microservice from the current service model.
         *     - If an import specification is given, get all interfaces that can be required by
         *       the determined microservice from the service model the import specification points
         *       to.
         */
        val importUri = if (import !== null) import.importURI else null
        return DdmmUtils.getScopeForPossiblyImportedConcept(
            microservice,
            microservice.qualifiedNameParts,
            ServiceModel,
            importUri,
            [containedInterfaces.toList],
            [qualifiedNameParts],
            [microservice.canRequire(it, importUri !== null)]
        )
    }

    /**
     * Convenience method to build a scope for a possibly imported operation without an import
     * specification
     */
    private def getScopeForPossiblyImportedOperation(EObject context) {
        return getScopeForPossiblyImportedOperation(context, null)
    }

    /**
     * Build scope for possibly imported operations, i.e., operations with or without import
     * specifications. Operations required by a microservice or used to initialize parameters of
     * other operations may possibly be imported.
     */
    private def getScopeForPossiblyImportedOperation(EObject context, Import ^import) {
        if (!(
            context instanceof Microservice ||
            context instanceof PossiblyImportedOperation
        ))
            return IScope.NULLSCOPE

        /* Prepare scope resolution */
        var EObject scopeContainer = null
        var List<String> scopeContainerNameParts = null
        val predicates = <Predicate<Operation>> newArrayList
        val importUri = if (import !== null) import.importURI else null
        switch (context) {
            // Operations required by microservices (context is Microservice, if user has not
            // entered an operation or import alias)
            Microservice: {
                val microservice = context
                scopeContainer = microservice
                scopeContainerNameParts = microservice.qualifiedNameParts
                predicates.add([context.canRequire(it, importUri !== null)])
            }

            // Operations required by microservices (context is PossiblyImportedOperation, if user
            // has entered an operation or import alias)
            PossiblyImportedOperation case context.eContainer instanceof Microservice: {
                val microservice = context.eContainer as Microservice
                scopeContainer = microservice
                scopeContainerNameParts = microservice.qualifiedNameParts
                predicates.add([microservice.canRequire(it, importUri !== null)])
            }

            // Initializing operations of parameter
            PossiblyImportedOperation case context.eContainer instanceof Parameter: {
                val operation = EcoreUtil2.getContainerOfType(context, Operation)
                scopeContainer = operation
                scopeContainerNameParts = operation.qualifiedNameParts
                predicates.add([(context.eContainer as Parameter).basicallyInitializableBy(it)])
            }
        }

        return DdmmUtils.getScopeForPossiblyImportedConcept(
            scopeContainer,
            scopeContainerNameParts,
            ServiceModel,
            importUri,
            [containedOperations.toList],
            [qualifiedNameParts],
            predicates
        )
    }

    /**
     * Build scope for imports of possibly imported Operations
     */
    private def getScopeForOperationImport(Parameter parameter) {
        val containingMicroservice = EcoreUtil2.getContainerOfType(parameter, Microservice)
        return Scopes::scopeFor(containingMicroservice.requiredImports)
    }

    /**
     * Build scope for initializing operations
     */
    private def getScopeForInitializingOperation(Parameter parameter) {
        val microservice = EcoreUtil2.getContainerOfType(parameter, Microservice)
        val import = parameter.initializedByOperation.import

        // Candidates for initializing operations are all operations directly or indirectly required
        // by a microservice (possibly imported), and all operations of the service itself, in case
        // no import alias was specified
        val candidateOperations = <Operation> newHashSet(
            microservice.getAllRequiredOperations(import))
        if (import === null) {
            val localOperations = microservice.containedOperations
            candidateOperations.addAll(localOperations)
        }

        val operation = EcoreUtil2.getContainerOfType(parameter, Operation)
        return DdmmUtils.getScopeWithRelativeQualifiedNames(
            candidateOperations.toList,
            [qualifiedNameParts],
            operation,
            operation.qualifiedNameParts,
            ServiceModel,
            [parameter.basicallyInitializableBy(it)]
        )
    }

    /**
     * Build scope for super microservices considering custom, version-aware name provider
     */
    private def getScopeForSuperMicroservice(Microservice microservice, EReference reference) {
        val serviceModel = microservice.serviceModel
        if (serviceModel === null)
            return IScope.NULLSCOPE

        val scopeElements = serviceModel.microservices.filter[microservice.canExtend(it)]
        return Scopes::scopeFor(scopeElements, nameProvider, IScope.NULLSCOPE)
    }

    /**
     * Build scope for imported protocols
     */
    private def getScopeForImportedProtocol(ImportedProtocol protocol) {
        val resourceContents = getImportedModelContents(protocol.eResource,
            protocol.import.importURI)
        if (resourceContents === null || resourceContents.empty)
            return IScope.NULLSCOPE

        // Return scope elements, i.e., defined protocols, that match the ImportedProtocol's
        // communication type
        val resourceRoot = resourceContents.get(0) as Technology
        val scopeElements = resourceRoot.protocols
            .filter[communicationType == protocol.communicationType]
            .map[
                val protocolName = QualifiedName.create(it.qualifiedNameParts)
                EObjectDescription.create(protocolName, it)
            ]

        return MapBasedScope.createScope(IScope.NULLSCOPE, scopeElements)
    }

    /**
     * Build scope for data formats of imported protocols
     */
    private def getScopeForDataFormat(ImportedProtocol importedProtocol) {
        val resourceContents = getImportedModelContents(importedProtocol.eResource,
            importedProtocol.import.importURI)
        if (resourceContents === null || resourceContents.empty)
            return IScope.NULLSCOPE

        // May happen if syntax errors in the technology model exist
        val protocolName = importedProtocol.protocol.name
        if (protocolName === null)
            return IScope.NULLSCOPE

        // Return scope elements, i.e., defined data formats, that exist for the ImportedProtocol's
        // protocol
        val resourceRoot = resourceContents.get(0) as Technology
        val scopeElements = resourceRoot.protocols
            .findFirst[it.name == protocolName]  // protocols must have unique names
            .dataFormats

        return Scopes::scopeFor(scopeElements)
    }

    /**
     * Build scope for complex types imported from a data model
     */
    private def getScopeForImportedComplexTypes(DataModel dataModel) {
        val scopeElements = dataModel.containedComplexTypes.map[
            val typeName = QualifiedName.create(it.qualifiedNameParts)
            EObjectDescription.create(typeName, it)
        ]

        return MapBasedScope.createScope(IScope.NULLSCOPE, scopeElements)
    }

    /**
     * Build scope for primitive and complex types imported from technology
     */
    private def getScopeForImportedTypes(Technology technology) {
        // Technology-specific primitive types
        val scopeElements = technology.primitiveTypes.map[
            val typeName = QualifiedName.create(it.qualifiedNameParts)
            EObjectDescription.create(typeName, it)
        ]

        // Technology-specific list types
        scopeElements.addAll(technology.listTypes.map[
            val typeName = QualifiedName.create(it.qualifiedNameParts)
            EObjectDescription.create(typeName, it)
        ])

        // Technology-specific data structures
        scopeElements.addAll(technology.dataStructures.map[
            val typeName = QualifiedName.create(it.qualifiedNameParts)
            EObjectDescription.create(typeName, it)
        ])

        return MapBasedScope.createScope(IScope.NULLSCOPE, scopeElements)
    }

    /**
     * Convenience method to create a scope for imports of certain types
     */
    private def getScopeForImportsOfType(EObject context, Class<? extends EObject>... types) {
        val allImports = EcoreUtil2.getContainerOfType(context, ServiceModel).imports
        val validImports = DdmmUtils.getImportsOfModelTypes(allImports, [it.importURI], types)
        return Scopes::scopeFor(validImports)
    }

    /**
     * Convenience method to retrieve contents of an imported resource (deals also with import URI
     * resolution)
     */
    private def getImportedModelContents(Resource containingResource, String importUri) {
        // The URI might be null, if the referenced import alias does not exist, i.e., was not
        // declared within an instantiation of the respective import rule
        if (importUri === null)
            return null

        val importResource = EcoreUtil2.getResource(containingResource, importUri)

        // Get model contents
        val resourceContents = DdmmUtils.getImportedModelContents(importResource, importUri)
        if (resourceContents !== null || !resourceContents.empty)
            return resourceContents
        else
            return null
    }
}