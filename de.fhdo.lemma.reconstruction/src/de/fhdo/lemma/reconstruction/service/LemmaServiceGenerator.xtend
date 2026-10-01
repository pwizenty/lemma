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
import java.math.BigDecimal
import de.fhdo.lemma.service.ImportType
import de.fhdo.lemma.data.DataFactory
import de.fhdo.lemma.data.PrimitiveUnspecified
import de.fhdo.lemma.reconstruction.domain.ClassType
import de.fhdo.lemma.service.ImportedType
import de.fhdo.lemma.technology.TechnologyFactory
import de.fhdo.lemma.reconstruction.util.TechnologyAspects
import de.fhdo.lemma.reconstruction.util.TechnologyTypes
import de.fhdo.lemma.reconstruction.domain.MetaData
import de.fhdo.lemma.service.Endpoint
import de.fhdo.lemma.service.ImportedServiceAspect
import de.fhdo.lemma.technology.Technology
import java.util.List

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

    /**
     * Protocol the endpoints of a reconstructed interface are declared for. The
     * reconstruction reads the REST interfaces of a system, so every address it
     * finds is a REST address.
     */
    static val PROTOCOL = "rest"

    /**
     * Meta-data name under which the reconstruction reports an endpoint, and
     * the key its address is held under.
     *
     * An endpoint is no annotation, so it is reported under a name of its own.
     * Its address is relative to the element above it, in the reconstruction as
     * in LEMMA, so it is carried over unchanged.
     */
    static val ENDPOINT = "Endpoint"
    static val ENDPOINT_ADDRESS = "address"

    /**
     * Join points of the Technology DSL, under which a technology model
     * declares which of its service aspects may be assigned where.
     */
    static val MICROSERVICES = "microservices"
    static val INTERFACES = "interfaces"
    static val OPERATIONS = "operations"
    static val PARAMETERS = "parameters"

    val model = SERVICE_FACTORY.createServiceModel

    var de.fhdo.lemma.service.Import technologyImport

    /**
     * The technology the generated references belong to.
     *
     * A reference to a protocol or to an aspect is extracted with the name of
     * its technology in front of it, so the technology has to exist even though
     * the generated model refers to it through the import. Both names are the
     * same string here, because the import is created under the name of the
     * technology it imports.
     */
    var Technology technology

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

        assignAspects(microservice.aspects, reconstructedMicroservice.metaData,
            MICROSERVICES)

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

    private def generateInterfaceFrom(Interface reconstructedInterface) {
        val interfaze = SERVICE_FACTORY.createInterface
        interfaze.name = reconstructedInterface.name.split("\\W").lastOrNull
        interfaze.version = reconstructedInterface.version
        interfaze.visibility = deriveLemmaVisibility(reconstructedInterface.visibility)

        // The path of the controller the interface was reconstructed from. The
        // addresses of its operations are read below it.
        assignEndpoint(interfaze.endpoints, reconstructedInterface.metaData)
        assignAspects(interfaze.aspects, reconstructedInterface.metaData, INTERFACES)

        // forEach rather than forall: the latter is a predicate that stops at
        // the first element it is false for, and it only worked here because
        // adding to a list happens to return true.
        reconstructedInterface.operations.forEach[
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

        assignEndpoint(operation.endpoints, reconstructedOperation.metaData)
        assignAspects(operation.aspects, reconstructedOperation.metaData, OPERATIONS)

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

        assignAspects(parameter.aspects, reconstructedParameter.metaData, PARAMETERS)

        return parameter
    }

    /**
     * Assign the endpoint the reconstruction reported for an element.
     *
     * Spring writes the path of a controller or of a method into its mapping
     * annotation, and LEMMA writes it as the address of an endpoint. Both read
     * an address relative to the element above it, so the address is carried
     * over unchanged: "/customers" on the interface and "/{customerId}" on the
     * operation together address "/customers/{customerId}".
     */
    private def assignEndpoint(List<Endpoint> endpoints, List<MetaData> metaData) {
        if (technologyImport === null || metaData.nullOrEmpty) {
            return
        }
        val reconstructedEndpoint = metaData.findFirst[name == ENDPOINT]
        if (reconstructedEndpoint === null || reconstructedEndpoint.values === null) {
            return
        }
        val address = reconstructedEndpoint.values.get(ENDPOINT_ADDRESS)
        if (address.nullOrEmpty) {
            return
        }

        val protocol = TECHNOLOGY_FACTORY.createProtocol
        protocol.name = PROTOCOL
        protocol.technology = getOrCreateTechnology

        val importedProtocol = SERVICE_FACTORY.createImportedProtocolAndDataFormat
        importedProtocol.^import = technologyImport
        importedProtocol.importedProtocol = protocol

        val endpoint = SERVICE_FACTORY.createEndpoint
        endpoint.protocols.add(importedProtocol)
        endpoint.addresses.add(address)
        endpoints.add(endpoint)
    }

    /**
     * Assign the service aspects the reconstruction reported for an element.
     *
     * The reconstruction reports the annotations it found under their own
     * names, and the technology model is the vocabulary that decides which of
     * them can be expressed: an annotation it declares no aspect for, such as
     * the OpenAPI annotations of Lakeside Mutual's controllers, is left out,
     * and so is one it declares for another join point. A reference the model
     * cannot resolve would be worse than a visible gap.
     */
    private def assignAspects(List<ImportedServiceAspect> aspects, List<MetaData> metaData,
        String joinPoint) {
        if (technologyImport === null || metaData.nullOrEmpty) {
            return
        }

        metaData.forEach[ reconstructedAspect |
            val declared = TechnologyAspects.declaredAspect(TECHNOLOGY_MODEL,
                reconstructedAspect.name, joinPoint)
            if (declared !== null) {
                aspects.add(createAspect(reconstructedAspect, declared))
            }
        ]
    }

    /**
     * Create the reference to a declared service aspect, with the values the
     * aspect declares a property for.
     */
    private def createAspect(MetaData reconstructedAspect, TechnologyAspects.Aspect declared) {
        val aspect = TECHNOLOGY_FACTORY.createServiceAspect
        aspect.name = reconstructedAspect.name
        aspect.technology = getOrCreateTechnology

        val importedAspect = SERVICE_FACTORY.createImportedServiceAspect
        importedAspect.^import = technologyImport
        importedAspect.importedAspect = aspect

        TechnologyAspects.assignableProperties(declared, reconstructedAspect.values).forEach[
            propertyName |
            val property = TECHNOLOGY_FACTORY.createTechnologySpecificProperty
            property.name = propertyName
            val assignment = TECHNOLOGY_FACTORY.createTechnologySpecificPropertyValueAssignment
            assignment.property = property
            assignment.value = createValue(reconstructedAspect.values.get(propertyName),
                declared, propertyName)
            importedAspect.values.add(assignment)
        ]

        return importedAspect
    }

    /**
     * Create the value of an aspect property, in the shape its declared type
     * asks for.
     *
     * The reconstruction reads the element of an annotation as text, and the
     * technology model declares what that text means: a value assigned to an
     * int is written as a number and one assigned to a boolean as itself, or
     * the generated model states a value of the wrong type. Every property the
     * REST annotations of Spring fill is declared as a string today, so this
     * follows the model rather than that observation.
     */
    private def createValue(String value, TechnologyAspects.Aspect declared,
        String propertyName) {
        val primitiveValue = DATA_FACTORY.createPrimitiveValue
        if (TechnologyAspects.isNumeric(declared, propertyName)) {
            try {
                primitiveValue.numericValue = new BigDecimal(value)
                return primitiveValue
            } catch (NumberFormatException e) {
                // The source does not state a number where the model expects
                // one. Writing the text keeps what was found, and the editor
                // names the mismatch.
            }
        } else if (TechnologyAspects.isBoolean(declared, propertyName)
            && #{"true", "false"}.contains(value)) {
            // Boolean.valueOf would turn anything else into false and hide that
            // the source does not state a boolean where the model expects one.
            primitiveValue.booleanValue = Boolean.valueOf(value)
            return primitiveValue
        }
        primitiveValue.stringValue = value
        return primitiveValue
    }

    /**
     * The technology the generated references belong to, created on first use.
     */
    private def getOrCreateTechnology() {
        if (technology === null) {
            technology = TECHNOLOGY_FACTORY.createTechnology
            technology.name = TECHNOLOGY_ALIAS
        }
        return technology
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

        val importedType = SERVICE_FACTORY.createImportedType
        importedType.^import = technologyImport

        // The name is set in each branch on purpose: the three types share
        // only de.fhdo.lemma.data.Type, which carries no name, so a common
        // variable for them could not be named.
        switch (kind) {
            case PRIMITIVE: {
                val type = TECHNOLOGY_FACTORY.createTechnologySpecificPrimitiveType
                type.name = name
                importedType.type = type
            }
            case COLLECTION: {
                val type = TECHNOLOGY_FACTORY.createTechnologySpecificCollectionType
                type.name = name
                importedType.type = type
            }
            case STRUCTURE: {
                val type = TECHNOLOGY_FACTORY.createTechnologySpecificDataStructure
                type.name = name
                importedType.type = type
            }
        }

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