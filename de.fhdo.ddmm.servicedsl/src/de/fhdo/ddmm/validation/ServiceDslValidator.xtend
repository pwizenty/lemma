/*
 * generated by Xtext 2.12.0
 */
package de.fhdo.ddmm.validation

import org.eclipse.xtext.validation.Check
import de.fhdo.ddmm.utils.DdmmUtils
import de.fhdo.ddmm.service.ServicePackage
import de.fhdo.ddmm.service.Import
import de.fhdo.ddmm.service.Microservice
import de.fhdo.ddmm.service.Interface
import de.fhdo.ddmm.service.Operation
import de.fhdo.ddmm.technology.CommunicationType
import de.fhdo.ddmm.service.ImportType
import de.fhdo.ddmm.service.ServiceModel
import org.eclipse.xtext.EcoreUtil2
import de.fhdo.ddmm.ServiceDslQualifiedNameProvider
import com.google.inject.Inject
import de.fhdo.ddmm.service.PossiblyImportedOperation
import de.fhdo.ddmm.service.PossiblyImportedInterface
import de.fhdo.ddmm.service.ExchangePattern
import de.fhdo.ddmm.typechecking.TypeChecker
import de.fhdo.ddmm.typechecking.TypesNotCompatibleException
import org.eclipse.xtext.naming.QualifiedName
import de.fhdo.ddmm.technology.TechnologySpecificPrimitiveType
import de.fhdo.ddmm.data.Type
import de.fhdo.ddmm.service.Parameter
import de.fhdo.ddmm.technology.Technology
import de.fhdo.ddmm.service.ProtocolSpecification

/**
 * This class contains custom validation rules for service models.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de>Florian Rademacher</a>
 */
class ServiceDslValidator extends AbstractServiceDslValidator {
    @Inject
    private ServiceDslQualifiedNameProvider nameProvider

    /**
     * Check if an imported file exists
     */
    @Check
    def checkImportFileExists(Import ^import) {
        if (!DdmmUtils.importFileExists(^import.eResource, import.importURI))
            error("File not found", ServicePackage::Literals.IMPORT__IMPORT_URI)
    }

    /**
     * Check for cyclic imports (non-transitive)
     */
    @Check
    def checkForCyclicImports(Import ^import) {
        if (import.importType !== ImportType.MICROSERVICES) {
            return
        }

        val isCyclic = DdmmUtils.isCyclicImport(import, ServiceModel,
            [it.imports
                .filter[it.importType === ImportType.MICROSERVICES]
                .toList
                .map[EcoreUtil2.getResource(it.eResource, it.importURI)]
            ]
        )

        if (isCyclic)
            error("Cyclic import detected", import, ServicePackage::Literals.IMPORT__IMPORT_URI)
    }

    /**
     * Check that annotated technologies define types and protocols
     */
    @Check
    def checkTechnologyForMandatoryConcepts(Microservice microservice) {
        val technology = microservice.technology
        if (technology === null || technology.importURI === null || technology.importURI.empty) {
            return
        }

        val technologyModelContents = DdmmUtils.getImportedModelContents(microservice.eResource,
            technology.importURI)
        if (technologyModelContents === null || technologyModelContents.empty) {
            return
        }

        val modelRoot = technologyModelContents.get(0)
        if (!(modelRoot instanceof Technology)) {
            return
        }

        val technologyModel = modelRoot as Technology
        if (technologyModel === null) {
            return
        }

        if (technologyModel.primitiveTypes.empty || technologyModel.protocols.empty)
            error("Technology does not specify primitive types, protocols, or both",
                microservice, ServicePackage::Literals.MICROSERVICE__TECHNOLOGY)
    }

    /**
     * Check that interfaces are not empty, i.e., that they define or refer to at least one
     * operation
     */
    @Check
    def checkInterfaceNotEmpty(Interface ^interface) {
        val definesOperations = interface.operations !== null && !interface.operations.empty
        val refersOperations = interface.referredOperations !== null &&
            !interface.referredOperations.empty

        if (!definesOperations && !refersOperations)
            error("Interface must define or refer to at least one operation", interface,
                ServicePackage::Literals.INTERFACE__NAME)
    }

    /**
     * Warn, if a required interface is already marked as being required by its containing
     * microservice
     */
    @Check
    def checkAlreadyRequired(PossiblyImportedInterface importedInterface) {
        if (importedInterface.required && importedInterface.requiredByContainer) {
            val containingMicroserviceName = nameProvider
                .qualifiedName(importedInterface.interface.microservice)

            warning('''Interface is already required, because its microservice ''' +
                '''«containingMicroserviceName»  is required''', importedInterface,
                ServicePackage::Literals.POSSIBLY_IMPORTED_INTERFACE__INTERFACE)
        }
    }

    /**
     * Warn, if the interface of an operation, that is marked as being not implemented, is also
     * marked as being not implemented. That is, the operation is already implicitly marked as being
     * not implemented by its containing interface.
     */
    @Check
    def checkAlreadyNotImplemented(Operation operation) {
        if (operation.notImplemented && operation.notImplementedByContainer) {
            val containingInterfaceName = operation.interface.name
            warning('''Operation is already marked as being not implemented, because ''' +
                '''its interface «containingInterfaceName» is marked as being not implemented''',
                operation, ServicePackage::Literals.OPERATION__NOT_IMPLEMENTED)
        }
    }

    /**
     * Warn, if an internal operation is already implicitly internal because its containing
     * interface is internal
     */
    @Check
    def checkAlreadyInternal(Operation operation) {
        if (operation.effectivelyInternal && operation.interface.effectivelyInternal) {
            val interfaceName = operation.interface.name
            warning('''Operation is already implicitly internal, because its interface ''' +
                '''«interfaceName» is internal''', operation,
                ServicePackage::Literals.OPERATION__VISIBILITY)
        }
    }

    /**
     * Warn, if a required operation is already required because its containing interface or
     * microservice are required
     */
    @Check
    def checkAlreadyRequired(PossiblyImportedOperation importedOperation) {
        if (!importedOperation.required || !importedOperation.requiredByContainer) {
            return
        }

        val isInterfaceRequired = importedOperation.requiredByInterface
        val isServiceRequired = importedOperation.requiredByMicroservice
        val operation = importedOperation.operation

        if (isInterfaceRequired && isServiceRequired) {
            val interfaceName = operation.interface.name
            val serviceName = operation.interface.microservice.name
            warning('''Operation is already implicitly required, because both its interface ''' +
                '''«interfaceName» and microservice «serviceName» are required''',
                importedOperation,
                ServicePackage::Literals.POSSIBLY_IMPORTED_OPERATION__REQUIRED_BY_CONTAINER)
        } else if (isInterfaceRequired) {
            val interfaceName = operation.interface.name
            warning('''Operation is already implicitly required, because its interface ''' +
                '''«interfaceName» is required''', importedOperation,
                ServicePackage::Literals.POSSIBLY_IMPORTED_OPERATION__REQUIRED_BY_INTERFACE)
        } else if (isServiceRequired) {
            val serviceName = operation.interface.microservice.name
            warning('''Operation is already implicitly required, because its microservice ''' +
                '''«serviceName» is required''', importedOperation,
                ServicePackage::Literals.POSSIBLY_IMPORTED_OPERATION__REQUIRED_BY_MICROSERVICE)
        }
    }

    /**
     * Check non-cyclic inheritance relationships between microservices
     */
    @Check
    def checkCyclicInheritance(Microservice microservice) {
        if (DdmmUtils.hasCyclicInheritance(microservice, [it.super]))
            error("Cyclic inheritance detected", microservice,
                ServicePackage::Literals.MICROSERVICE__NAME)
    }

    /**
     * Check that there is at most one protocol per communication type annotated on microservices,
     * interfaces, operations, or referred operations
     */
    @Check
    def checkProtocolCommunicationType(ProtocolSpecification protocolSpecification) {
        val protocols = switch(protocolSpecification.eContainer) {
            Microservice : (protocolSpecification.eContainer as Microservice).protocols
            Interface : (protocolSpecification.eContainer as Interface).protocols
            Operation : (protocolSpecification.eContainer as Operation).protocols
            default : null
        }

        if (protocols === null || protocols.empty) {
            return
        }

        val containerName = switch(protocolSpecification.eContainer) {
            Microservice : "microservice"
            Interface : "interface"
            Operation : "operation"
        }

        for (int i : 0..<2) {
            val CommunicationType communicationType = switch (i) {
                case 1: CommunicationType.SYNCHRONOUS
                case 2: CommunicationType.ASYNCHRONOUS
            }

            val String protocolTypeName = switch (communicationType) {
                case SYNCHRONOUS: "synchronous"
                case ASYNCHRONOUS: "asynchronous"
            }

            val protocolsOfType = protocols.filter[it.communicationType == communicationType]
            if (protocolsOfType.size > 1)
                error('''There must not be more than one «protocolTypeName» protocol for the ''' +
                    '''«containerName»''', protocolsOfType.get(1),
                ServicePackage::Literals.PROTOCOL_SPECIFICATION__COMMUNICATION_TYPE)
        }
    }

    /**
     * Check type compatibility of parameter and initializing operation
     */
    @Check
    def checkParameter(PossiblyImportedOperation importedOperation) {
        // The operation may not have a container if the user didn't finish entering the
        // initializing operation's name and hence the DSL code is syntactically incorrect
        val operation = importedOperation.operation
        if (operation.eContainer === null) {
            return
        }

        val initializedParameter = importedOperation.initializedParameter
        if (initializedParameter === null) {
            return
        }

        if (initializedParameter.exchangePattern === ExchangePattern.OUT) {
            error("Outgoing parameters may not be initialized", initializedParameter,
                ServicePackage::Literals.PARAMETER__EXCHANGE_PATTERN)
            return
        }

        val parameterType = initializedParameter.effectiveType
        if (parameterType === null) {
            return
        }

        /*
         * If the operation has an output type that is the same as the initialized parameter's type
         * both types are equal and hence inherently compatible
         */
        val existsSameOutputType = operation.parameters.exists[
            (exchangePattern == ExchangePattern.OUT || exchangePattern == ExchangePattern.INOUT) &&
            effectiveType == parameterType
        ]

        if (existsSameOutputType) {
            return
        }

        /*
         * Check and warn if initialized parameter is of a technology-specific primitive type that
         * has no basic built-in primitive type
         */
        if (warnParameterLacksPrimitiveType(initializedParameter)) {
            return
        }

        /*
         * Check that initializing operation has output parameters and also get their types
         */
        val outputTypes = operation.parameters.filter[
                // may happen if no type has been entered by the user, yet
                effectiveType !== null &&
                (
                    exchangePattern === ExchangePattern.OUT ||
                    exchangePattern === ExchangePattern.INOUT
                )
            ].map[effectiveType]

        // Despite the fact that the scope provider filters out operations that do not have output
        // parameters to be used for parameter initialization, output types that are declared in
        // the DSL might not get recognized in case their technology-specific description contains
        // syntax errors
        if (outputTypes.empty) {
            error("Operation has no output parameters", operation,
                ServicePackage::Literals.POSSIBLY_IMPORTED_OPERATION__OPERATION)
            return
        }

        /* Perform full type check leveraging the data DSL's type checker */
        checkInitializingTypeCompatibility(importedOperation, outputTypes, parameterType)
    }

    /**
     * Helper method to determine if a technology-specific primitive type lacks underlying
     * built-in primitive types
     */
    private def warnParameterLacksPrimitiveType(Parameter initializedParameter) {
        /*
         * Only accept _technology-specific_ primitive types that do not have basic built-in
         * primitive types
         */
        val parameterType = initializedParameter.effectiveType
        if (!(parameterType instanceof TechnologySpecificPrimitiveType))
            return false

        val technologySpecificType = parameterType as TechnologySpecificPrimitiveType
        if (!technologySpecificType.basicBuiltinPrimitiveTypes.empty)
            return false

        /* Create warning */
        val qualifiedTypeName = new StringBuilder
        qualifiedTypeName.append(technologySpecificType.technology.name)
        qualifiedTypeName.append("::")
        qualifiedTypeName.append(QualifiedName.create(technologySpecificType.qualifiedNameParts))

        warning('''Technology-specific primitive type «qualifiedTypeName» of parameter ''' +
            '''«initializedParameter.name» has no basic type. To initialize the parameter, an ''' +
            '''additional type conversion would need to be implemented.''', initializedParameter,
            ServicePackage::Literals.PARAMETER__INITIALIZED_BY_OPERATION)

        return true
    }

    /**
     * Helper method to perform full type checks of a parameter and its initializing operation
     */
    private def checkInitializingTypeCompatibility(PossiblyImportedOperation importedOperation,
        Iterable<Type> outputTypes, Type parameterType) {
        // Iterate over all output types and check their compatibility with the initialized
        // parameter's type until one compatible type was found
        val typeChecker = new TypeChecker()
        var compatibleOutTypeFound = false
        var i = 0

        while (i < outputTypes.size && !compatibleOutTypeFound) {
            val outputType = outputTypes.get(i)

            try {
                typeChecker.checkTypeCompatibility(parameterType, outputType)
                compatibleOutTypeFound = true
            } catch (TypesNotCompatibleException ex) {
                i++
            }
        }

        // Warn, if no compatible type could be found
        if (compatibleOutTypeFound) {
            return
        }

        val initializedParameter = importedOperation.initializedParameter
        var typeName = QualifiedName
            .create(initializedParameter.effectiveTypeQualifiedNameParts)
            .toString

        if (parameterType instanceof TechnologySpecificPrimitiveType)
            typeName = parameterType.technology.name + "::" + typeName

        warning('''Types of output parameters are not directly compatible with type «typeName» ''' +
            '''of parameter «initializedParameter.name». To initialize the parameter, an ''' +
            '''additional type conversion would need to be implemented.''', importedOperation,
            ServicePackage::Literals.POSSIBLY_IMPORTED_OPERATION__OPERATION)
    }
}
