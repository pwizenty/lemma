package de.fhdo.lemma.reconstruction.operation

import de.fhdo.lemma.operation.OperationModel
import de.fhdo.lemma.operation.OperationFactory
import de.fhdo.lemma.service.ImportType
import de.fhdo.lemma.service.ServiceFactory
import de.fhdo.lemma.technology.TechnologyFactory
import java.io.File
import java.util.List

/**
 * Generator of a LEMMA operation model from reconstructed operation nodes.
 *
 * The deployment technology and the technology annotations are not
 * reconstructed. They are references into a technology model, which is written
 * by hand and lives in the models folder of this bundle, so they are chosen
 * here. See ADR-0008 of the reconstruction framework.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class LemmaOperationGenerator {
    static val OPERATION_FACTORY = OperationFactory.eINSTANCE
    static val SERVICE_FACTORY = ServiceFactory.eINSTANCE
    static val TECHNOLOGY_FACTORY = TechnologyFactory.eINSTANCE

    /**
     * Alias and location of the technology model the generated nodes
     * reference. The relaxed model is used because a reconstructed container
     * carries no values for the service properties of its microservices yet,
     * and the strict model marks two of them as mandatory.
     */
    static val TECHNOLOGY_ALIAS = "deploymentBase"
    static val TECHNOLOGY_IMPORT_URI =
        '''..«File.separator»technology«File.separator»deployment_base_relaxed.technology'''
    static val DEPLOYMENT_TECHNOLOGY = "Kubernetes"

    /**
     * Name of the infrastructure technology an infrastructure node is assigned
     * to. Reconstructing which technology a node actually runs is future work,
     * see the follow-ups of ADR-0008.
     */
    static val INFRASTRUCTURE_TECHNOLOGY = "SpringBootAdmin"

    val model = OPERATION_FACTORY.createOperationModel

    /**
     * Generate an operation model from the reconstructed nodes of a system.
     *
     * All nodes of a system go into one model: they refer to each other by
     * name, and a reference to a node of another model would need an import of
     * that model rather than a plain name.
     */
    def OperationModel generateModelFrom(List<OperationNode> reconstructedNodes,
        String serviceModelName) {
        val technologyImport = createImport(TECHNOLOGY_ALIAS,
            TECHNOLOGY_IMPORT_URI.toString, ImportType.TECHNOLOGY)
        model.imports.add(technologyImport)

        val serviceImport = createImport(serviceModelName,
            '''..«File.separator»service«File.separator»«serviceModelName».services'''.toString,
            ImportType.MICROSERVICES)
        model.imports.add(serviceImport)

        reconstructedNodes.forEach[
            if (nodeType === NodeType.INFRASTRUCTURE)
                model.infrastructureNodes.add(
                    generateInfrastructureNodeFrom(it, technologyImport))
            else
                model.containers.add(
                    generateContainerFrom(it, technologyImport, serviceImport))
        ]

        // A node is referenced by name, so the nodes it depends on can only be
        // resolved once all of them exist.
        reconstructedNodes.forEach[ reconstructedNode |
            val node = model.findNode(reconstructedNode.name)
            if (node !== null) {
                reconstructedNode.dependsOn.forEach[ dependency |
                    val dependsOn = model.findNode(dependency)
                    if (dependsOn !== null) {
                        val reference = OPERATION_FACTORY
                            .createPossiblyImportedOperationNode
                        reference.node = dependsOn
                        node.dependsOnNodes.add(reference)
                    }
                ]
            }
        ]

        return model
    }

    /**
     * Generate a container, which deploys the microservices of the
     * reconstructed node.
     */
    private def generateContainerFrom(OperationNode reconstructedNode,
        de.fhdo.lemma.service.Import technologyImport,
        de.fhdo.lemma.service.Import serviceImport) {
        val container = OPERATION_FACTORY.createContainer
        container.name = reconstructedNode.name
        container.technologies.add(technologyImport)

        val deploymentTechnology = TECHNOLOGY_FACTORY.createDeploymentTechnology
        deploymentTechnology.name = DEPLOYMENT_TECHNOLOGY
        val reference = OPERATION_FACTORY.createDeploymentTechnologyReference
        reference.^import = technologyImport
        reference.deploymentTechnology = deploymentTechnology
        container.deploymentTechnology = reference

        container.operationEnvironment =
            createOperationEnvironment(reconstructedNode.operationEnvironment)

        reconstructedNode.deployedServices.forEach[
            val importedMicroservice = OPERATION_FACTORY.createImportedMicroservice
            importedMicroservice.^import = serviceImport
            importedMicroservice.microservice = createMicroservice(qualifiedName)
            container.deployedServices.add(importedMicroservice)
        ]

        return container
    }

    /**
     * Generate an infrastructure node.
     */
    private def generateInfrastructureNodeFrom(OperationNode reconstructedNode,
        de.fhdo.lemma.service.Import technologyImport) {
        val node = OPERATION_FACTORY.createInfrastructureNode
        node.name = reconstructedNode.name
        node.technologies.add(technologyImport)

        val infrastructureTechnology = TECHNOLOGY_FACTORY
            .createInfrastructureTechnology
        infrastructureTechnology.name = INFRASTRUCTURE_TECHNOLOGY
        val reference = OPERATION_FACTORY.createInfrastructureTechnologyReference
        reference.^import = technologyImport
        reference.infrastructureTechnology = infrastructureTechnology
        node.infrastructureTechnology = reference

        node.operationEnvironment =
            createOperationEnvironment(reconstructedNode.operationEnvironment)

        return node
    }

    /**
     * Create the operation environment of a node. A node without a Dockerfile
     * has none, and the clause is optional, so null is a valid result.
     */
    private def createOperationEnvironment(String environmentName) {
        if (environmentName.nullOrEmpty)
            return null
        val environment = TECHNOLOGY_FACTORY.createOperationEnvironment
        environment.environmentName = environmentName
        return environment
    }

    /**
     * Create the microservice a container deploys. Only its name is needed:
     * the microservice itself is defined in the imported service model.
     */
    private def createMicroservice(String qualifiedName) {
        val microservice = SERVICE_FACTORY.createMicroservice
        microservice.name = qualifiedName
        return microservice
    }

    private def createImport(String name, String importUri, ImportType type) {
        val ^import = SERVICE_FACTORY.createImport
        ^import.name = name
        ^import.importURI = importUri
        ^import.importType = type
        return ^import
    }

    private def findNode(OperationModel operationModel, String name) {
        val container = operationModel.containers.findFirst[it.name == name]
        if (container !== null)
            return container as de.fhdo.lemma.operation.OperationNode
        return operationModel.infrastructureNodes.findFirst[it.name == name]
            as de.fhdo.lemma.operation.OperationNode
    }
}
