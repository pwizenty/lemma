package de.fhdo.lemma.reconstruction.ui

import de.fhdo.lemma.data.DataModel
import de.fhdo.lemma.reconstruction.io.ReconstructionModelWriter
import de.fhdo.lemma.reconstruction.MongoDbRepository
import de.fhdo.lemma.reconstruction.domain.Context
import de.fhdo.lemma.reconstruction.domain.LemmaDomainGenerator
import java.io.File
import java.util.List
import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.jface.dialogs.MessageDialog
import org.eclipse.swt.SWT
import org.eclipse.swt.widgets.DirectoryDialog
import org.eclipse.ui.PlatformUI
import de.fhdo.lemma.reconstruction.service.Microservice
import de.fhdo.lemma.service.ServiceModel
import de.fhdo.lemma.reconstruction.service.LemmaServiceGenerator
import de.fhdo.lemma.reconstruction.operation.LemmaOperationGenerator
import de.fhdo.lemma.reconstruction.operation.OperationNode
import de.fhdo.lemma.operation.OperationModel

/**
 * Handler for orchestrating the reconstruction process of LEMMA models
 * from a MongoDB based on recovered architecture information from the
 * Microservice Reconstruction Framework. 
 * 
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class LemmaReconstructionHandler extends AbstractHandler {
    /**
     * Current shell
     */
    static val SHELL = PlatformUI.workbench.activeWorkbenchWindow.shell
   	String mongoDbHostname
    String mongoDbPort

    List<Context> initialContexts
    List<Context> selectedContexts
    
    List<Microservice> initialMicroservices = newLinkedList
    List<Microservice> selectedMicroservices = newLinkedList

    String reconstructionPath

    List<DataModel> domainDataModels
    List<ServiceModel> serviceModels = newLinkedList

    List<OperationNode> operationNodes = newLinkedList
    List<OperationNode> selectedOperationNodes = newLinkedList

    boolean copyTechnologyModels = true
    String technologyFolder
    List<String> copiedTechnologyModels = newLinkedList
    List<OperationModel> operationModels = newLinkedList

	/**
	 * Executing the model generation process
	 */
    override execute(ExecutionEvent event) throws ExecutionException {
    	init
        receiveMongoDbEndpoints
        loadContextInformationFromMongoDb
        loadMicroservicesFromMongoDB
        loadOperationNodesFromMongoDb

        displayReconstructionInforation
        selectTargetFolderForModelGeneration
        copyTechnologyModelsToTargetFolder
        generateModels
	        writeModelsToFolder
        showReconstructionInformationMessage

        resetDialogHandler
        return null
    }

	/**
	 * Initialize the content for the model creation
	 */
    private def init() {
    	initialContexts = newLinkedList
    	selectedContexts = newLinkedList
    	domainDataModels = newLinkedList
    }
	
	/**
	 * Load MongoDB configuration from the UI dialog
	 */
    private def receiveMongoDbEndpoints() {
        val dialog = new LemmaReconstructionDialog(SHELL)
        dialog.create
        dialog.open
        mongoDbHostname = dialog.mongoDbHostname
        mongoDbPort = dialog.mongoDbPort
    }

	/** 
	 * Display the reconstructed architecture information, loaded from the database 
	 */
    private def displayReconstructionInforation() {
        val dialog = new LemmaReconstructionResultsDialog(SHELL, initialContexts,
            initialMicroservices, operationNodes)
        dialog.create
        dialog.open
        selectedContexts = dialog.selectedContexts
        selectedMicroservices = dialog.selectedMicroservices
        selectedOperationNodes = dialog.selectedOperationNodes
        copyTechnologyModels = dialog.copyTechnologyModels
        technologyFolder = dialog.technologyFolder
    }

	/** 
	 * Load reconstructed domain information from the MongoDB database 
	 */
    private def loadContextInformationFromMongoDb() {
        val repository = new MongoDbRepository(mongoDbHostname, Integer::parseInt(mongoDbPort))
        initialContexts.addAll(repository.getReconstructedContexts)
    }
    
    /** 
	 * Load reconstructed operation information from the MongoDB database 
	 */
    private def loadOperationNodesFromMongoDb() {
        val repository = new MongoDbRepository(mongoDbHostname, Integer::parseInt(mongoDbPort))
        operationNodes.addAll(repository.reconstructedOperationNodes)
    }

    /** 
	 * Load reconstructed microservice information from the MongoDB database 
	 */
    private def loadMicroservicesFromMongoDB() {
        val repository = new MongoDbRepository(mongoDbHostname, Integer::parseInt(mongoDbPort))
        initialMicroservices.addAll(repository.reconstructedMicroservices)
    }

	/**
	 * UI dialog for selecting folder to save the generated LEMMA model in
	 */
    private def selectTargetFolderForModelGeneration() {
        val fileDialog = new DirectoryDialog( SHELL, SWT.OPEN );
        reconstructionPath = fileDialog.open
    }

	/**
	 * Copy the technology models next to the models about to be generated, so
	 * that the import an operation model carries resolves
	 */
    private def copyTechnologyModelsToTargetFolder() {
        if (!copyTechnologyModels || reconstructionPath.nullOrEmpty) {
            return
        }
        copiedTechnologyModels = ReconstructionModelWriter.copyTechnologyModels(
            reconstructionPath, technologyFolder)
        if (copiedTechnologyModels.empty)
            MessageDialog.openWarning(SHELL, "Reconstruction Information Message",
                '''
                No technology model was copied, so the import of the generated operation
                model will not resolve until one is placed in "«technologyFolder»".

                Looked for them in:
                «ReconstructionModelWriter.lastLookupLocation»
                '''.toString)
    }

	/**
	 * Generate the models based on the previous selection
	 */
    private def generateModels() {
    	if (!selectedContexts.nullOrEmpty)
        	generateDomainModels
        	generateServiceModels
        	generateOperationModels
    }

	/**
	 * Generate LEMMA domain models
	 */
    private def generateDomainModels() {
        val generator = new LemmaDomainGenerator
        selectedContexts.forEach[
            domainDataModels.addAll(generator.generateDataModel(it))
        ]
    }
    
    /**
	 * Generate LEMMA service models
	 */
    private def generateServiceModels() {
        selectedMicroservices.forEach[
            // A generator collects its microservices in one service model, so
            // every microservice needs its own generator to end up in its own
            // model and therefore in its own file.
            val model = new LemmaServiceGenerator().generateModelFrom(it,
                technologyFolder)
            serviceModels.add(model)
        ]
    }

    /**
	 * Generate LEMMA operation models. All nodes go into one model, because a
	 * node refers to the nodes it depends on by name, and a reference across
	 * models would need an import of the other model.
	 */
    private def generateOperationModels() {
        if (selectedOperationNodes.nullOrEmpty || selectedMicroservices.nullOrEmpty) {
            return
        }
        val serviceModelName = selectedMicroservices.get(0).name.split("\\W").lastOrNull
        val model = new LemmaOperationGenerator().generateModelFrom(selectedOperationNodes,
            serviceModelName, technologyFolder)
        operationModels.add(model)
    }

	/**
	 * Write LEMMA models to the selected folder
	 */
    private def writeModelsToFolder() {
        domainDataModels.forEach[
            writeDomainDataModel(it)
        ]
        serviceModels.forEach[
        	writeServiceModel(it)
        ]
        operationModels.forEach[
        	writeOperationModel(it)
        ]
    }

	/** 
	 * Configuration and specific execution to write LEMMA domain models to the selected folder 
	 */
    private def writeDomainDataModel(DataModel model) {
        ReconstructionModelWriter.writeDataModel(model, reconstructionPath)
    }

	/** 
	 * Configuration and specific execution to write LEMMA service models to the selected folder 
	 */
	private def writeServiceModel(ServiceModel model) {
        ReconstructionModelWriter.writeServiceModel(model, reconstructionPath)
    }

	/** 
	 * Configuration and specific execution to write LEMMA operation models to the selected folder 
	 */
	private def writeOperationModel(OperationModel model) {
        val fileName = selectedMicroservices.get(0).name.split("\\W").lastOrNull
        ReconstructionModelWriter.writeOperationModel(model, fileName, reconstructionPath)
    }

	/**
	 * Display the information about the generated LEMMA models
	 */
    private def showReconstructionInformationMessage() {
        val title = "Reconstruction Information Message"
        val generatedLemmaModels = <String>newLinkedList

        domainDataModels.forEach[ models |
            models.contexts.forEach[context |
                generatedLemmaModels.add('''«context.name».data''')
            ]
        ]
        
        selectedMicroservices.forEach[
            generatedLemmaModels.add('''«it.name.split("\\W").lastOrNull».services''')
        ]

        if (!operationModels.nullOrEmpty && !selectedMicroservices.nullOrEmpty)
            generatedLemmaModels.add(
                '''«selectedMicroservices.get(0).name.split("\\W").lastOrNull».operation''')

        copiedTechnologyModels.forEach[
            generatedLemmaModels.add('''«technologyFolder»«File.separator»«it» (copied)''')
        ]

        val messageText = "Generated Models:"
        val messageModels = messageText + "\n\t- " + generatedLemmaModels.join("\n\t- ") + "\n\n"
        showInfoDialogMessage(title, messageModels)
    }

	/**
	 * Handle dialog about the generated models
	 */
    private def showInfoDialogMessage(String title, String message) {
        MessageDialog.openInformation(SHELL, title, message)
    }

	/** 
	 * Reset model all model creation dialogs
	 */
    private def resetDialogHandler() {
        initialContexts.clear
        selectedContexts.clear
        domainDataModels.clear
        
        initialMicroservices.clear
        selectedMicroservices.clear
        serviceModels.clear
        operationNodes.clear
        selectedOperationNodes.clear
        technologyFolder = null
        copiedTechnologyModels.clear
        operationModels.clear
    }
}