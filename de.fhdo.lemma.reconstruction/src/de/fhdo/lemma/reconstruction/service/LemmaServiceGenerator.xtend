package de.fhdo.lemma.reconstruction.service

import de.fhdo.lemma.service.ServiceFactory
import de.fhdo.lemma.service.ServiceModel
import de.fhdo.lemma.service.Visibility
import de.fhdo.lemma.technology.ExchangePattern
import de.fhdo.lemma.technology.CommunicationType
import de.fhdo.lemma.reconstruction.util.Util
import de.fhdo.lemma.service.MicroserviceType
import de.fhdo.lemma.reconstruction.domain.ComplexType
import java.io.File
import de.fhdo.lemma.service.ImportType
import de.fhdo.lemma.data.DataFactory
import de.fhdo.lemma.data.PrimitiveUnspecified
import de.fhdo.lemma.reconstruction.domain.ClassType
import de.fhdo.lemma.service.ImportedType
import de.fhdo.lemma.technology.TechnologyFactory
import de.fhdo.lemma.reconstruction.util.TechnologyTypes

class LemmaServiceGenerator {
    static val SERVICE_FACTORY = ServiceFactory.eINSTANCE
    static val DATA_FACTORY = DataFactory.eINSTANCE

    /**
     * Meta-data names under which MRF conveys the visibility and the type of a
     * microservice. Both are reconstructed as meta-data entries rather than as
     * dedicated fields of the microservice document.
     */
    static val VISIBILITY_NAMES = #{"public", "internal", "architecture"}
    static val MICROSERVICE_TYPE_NAMES = #{"functional", "utility", "infrastructure"}

    static val TECHNOLOGY_FACTORY = TechnologyFactory.eINSTANCE

    /**
     * Alias and model of the technology the generated services reference. A
     * type the reconstruction has no source for, such as Spring's
     * Authentication, is left unspecified unless this model declares it.
     */
    static val TECHNOLOGY_ALIAS = "javaWithSpring"
    static val TECHNOLOGY_MODEL = "spring.technology"

    val model = SERVICE_FACTORY.createServiceModel

    var de.fhdo.lemma.service.Import technologyImport

    def ServiceModel generateModelFrom(Microservice reconstructedMicroservice) {
        generateModelFrom(reconstructedMicroservice, "technology")
    }

    /**
     * Generate a service model, with the technology model in the given folder.
     */
    def ServiceModel generateModelFrom(Microservice reconstructedMicroservice,
        String technologyFolder) {
        technologyImport = createTechnologyImport(technologyFolder)

        val microservice = generateMicroserviceFrom(reconstructedMicroservice)
        model.microservices.add(microservice)

        return model
    }

    private def generateMicroserviceFrom(Microservice reconstructedMicroservice) {
        val microservice = SERVICE_FACTORY.createMicroservice
        microservice.name = reconstructedMicroservice.qualifedName
        if (technologyImport !== null) {
            val reference = SERVICE_FACTORY.createTechnologyReference
            reference.technology = technologyImport
            microservice.technologyReferences.add(reference)
        }
        microservice.version = reconstructedMicroservice.version
        microservice.visibility = deriveLemmaVisibility(
            reconstructedMicroservice.visibility
                ?: reconstructedMicroservice.metaData.findFirst[
                    VISIBILITY_NAMES.contains(name.toLowerCase)
                ]?.name)
        microservice.type = deriveMicroserviceType(
            reconstructedMicroservice.type
                ?: reconstructedMicroservice.metaData.findFirst[
                    MICROSERVICE_TYPE_NAMES.contains(name.toLowerCase)
                ]?.name)

        reconstructedMicroservice.interfaces.forEach[
            microservice.interfaces.add(generateInterfaceFrom(it))
        ]

        return microservice
    }

    private def deriveMicroserviceType(String type) {
        if (type === null) {
        	return MicroserviceType.FUNCTIONAL
        }
        
        return switch(type.toLowerCase) {
            case "functional": MicroserviceType.FUNCTIONAL
            case "utility": MicroserviceType.UTILITY
            case "infrastructure": MicroserviceType.INFRASTRUCTURE
            default: MicroserviceType.FUNCTIONAL
        }
    }

    private def generateInterfaceFrom(Interface generatedInterface) {
        val interfaze = SERVICE_FACTORY.createInterface
        interfaze.name = generatedInterface.name.split("\\W").lastOrNull
        interfaze.version = generatedInterface.version
        interfaze.visibility = deriveLemmaVisibility(generatedInterface.visibility)
        generatedInterface.operations.forall[
            interfaze.operations.add(generateOperationFrom(it))
        ]
        return interfaze
    }

    /**
     * Derive the LEMMA visibility of a microservice or interface.
     *
     * The Service DSL extractor can only render ARCHITECTURE, INTERNAL and
     * PUBLIC; NONE and IN_MODEL make it fail with "Type ... is not supported."
     * An unknown or missing visibility therefore falls back to PUBLIC instead
     * of to the NONE default of the meta-model.
     */
    private def deriveLemmaVisibility(String visibility) {
		if (visibility === null) {
			return Visibility.PUBLIC
		}
        return switch (visibility.toLowerCase) {
            case "internal": Visibility.INTERNAL
            case "architecture": Visibility.ARCHITECTURE
            case "public": Visibility.PUBLIC
            default: Visibility.PUBLIC
        }
    }

    private def generateOperationFrom(Operation reconstructedOperation) {
        val operation = SERVICE_FACTORY.createOperation
        operation.name = reconstructedOperation.name
        reconstructedOperation.parameters.forEach[ reconstructedParameter |

            var parameter = operation.parameters.findFirst[param |
                param.name.toLowerCase == reconstructedParameter.name.toLowerCase
            ]

            if (parameter !== null) {
                parameter.exchangePattern = ExchangePattern.INOUT
                operation.parameters.add(parameter)

            } else {
                parameter = generateParameterFrom(reconstructedParameter)
                operation.parameters.add(parameter)
            }

        ]

        // A parameter of an unspecified type is only allowed in an operation
        // that is marked as not implemented, so a reconstruction that could
        // not resolve a type says so rather than writing a model the Service
        // DSL rejects.
        if (operation.parameters.exists[primitiveType instanceof PrimitiveUnspecified]) {
            operation.notImplemented = true
        }

        return operation
    }

    private def generateParameterFrom(Parameter reconstructedParameter) {
        val parameter = SERVICE_FACTORY.createParameter
        parameter.name = reconstructedParameter.name.toFirstLower
        if (parameter.name == "list") {
        	parameter.name = "dataList"
        }
        parameter.exchangePattern
            = deriveExchangePattern(reconstructedParameter.exchangePattern.toString())
        parameter.communicationType
            = deriveCommunicationType(reconstructedParameter.communicationType.toString())

        if (reconstructedParameter.primitiveType !== null) {
            parameter.primitiveType
                = Util.getPrimitiveFrom(reconstructedParameter.primitiveType.name)
        } else if (reconstructedParameter.complexType.classType === ClassType.UNSPECIFIED) {
            // A type the reconstruction has no source for. The technology
            // model may declare it; otherwise it stays unspecified, because a
            // reference the model cannot resolve is worse than a known gap.
            val technologyType = createTechnologyType(reconstructedParameter.complexType.name)
            if (technologyType !== null) {
                parameter.importedType = technologyType
            } else {
                parameter.primitiveType = DATA_FACTORY.createPrimitiveUnspecified
            }
        } else {
            parameter.importedType = deriveImportedType(reconstructedParameter.complexType) as ImportedType
        }

        return parameter
    }

    /**
     * Create the import of the technology model the services reference.
     */
    private def createTechnologyImport(String technologyFolder) {
        val ^import = SERVICE_FACTORY.createImport
        ^import.name = TECHNOLOGY_ALIAS
        ^import.importURI =
            '''..«File.separator»«technologyFolder»«File.separator»«TECHNOLOGY_MODEL»'''.toString
        ^import.importType = ImportType.TECHNOLOGY
        model.imports.add(^import)
        return ^import
    }

    /**
     * Create a reference to a type of the technology model, or null when the
     * model does not declare a type of that name.
     */
    private def createTechnologyType(String name) {
        if (technologyImport === null || name.nullOrEmpty) {
            return null
        }
        val kind = TechnologyTypes.declaredTypes(TECHNOLOGY_MODEL).get(name)
        if (kind === null) {
            return null
        }

        val type = switch (kind) {
            case PRIMITIVE: TECHNOLOGY_FACTORY.createTechnologySpecificPrimitiveType
            case COLLECTION: TECHNOLOGY_FACTORY.createTechnologySpecificCollectionType
            case STRUCTURE: TECHNOLOGY_FACTORY.createTechnologySpecificDataStructure
        }
        type.name = name

        val importedType = SERVICE_FACTORY.createImportedType
        importedType.^import = technologyImport
        importedType.type = type
        return importedType
    }

    private def deriveExchangePattern(String pattern) {
        return switch (pattern.toLowerCase) {
            case "in": ExchangePattern.IN
            case "out": ExchangePattern.OUT
            case "inout": ExchangePattern.INOUT
        }
    }


    private def deriveCommunicationType(String type) {
        return switch (type.toLowerCase) {
            case "synchronous": CommunicationType.SYNCHRONOUS
            case "asynchronous": CommunicationType.SYNCHRONOUS
        }
    }

    private def deriveImportedType(ComplexType complexType) {
        val importedType = SERVICE_FACTORY.createImportedType

        val import = getOrCreateImport(complexType)
        importedType.import = import

        // Create type for imported type
        val type = deriveType(complexType)
        val context = DATA_FACTORY.createContext
        context.name = Util.getContextNameFromQualifedName(complexType.qualifiedName)
        type.context = context
        importedType.type = type

        return importedType
    }

    private def getOrCreateImport(ComplexType complexType) {
        val contextName = Util.getContextNameFromQualifedName(complexType.qualifiedName)
        var import = model.imports.findFirst[it.name == contextName]

        if (import === null) {
            import = SERVICE_FACTORY.createImport

            import.name = contextName
            import.importURI = '''..«File.separator»domain«File.separator»«contextName».data'''
            import.importType = ImportType.DATATYPES
            model.imports.add(import)
            return import
        }
        return import
    }

    private def deriveType(ComplexType type) {
        return switch (type.classType) {
            case ClassType.COLLECTION: handleCollectionType(type)
            case ClassType.DATA_STRUCTURE: handleDataStructureType(type)
            case ClassType.ENUMERATION: handleEnumerationType(type)
            case ClassType.MAP: handleCollectionType(type)
            default: null
        }
    }

    private def handleCollectionType(ComplexType type) {
        val collection = DATA_FACTORY.createCollectionType
        collection.name = type.name.toFirstUpper
        return collection
    }

    private def handleDataStructureType(ComplexType type) {
        val structure = DATA_FACTORY.createDataStructure
        structure.name = type.name
        return structure
    }

    private def handleEnumerationType(ComplexType type) {
        val enum = DATA_FACTORY.createEnumeration
        enum.name = type.name
        return enum
    }


}