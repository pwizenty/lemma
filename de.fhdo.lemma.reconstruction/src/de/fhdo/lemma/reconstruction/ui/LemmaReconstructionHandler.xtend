package de.fhdo.lemma.reconstruction.ui

import de.fhdo.lemma.data.DataDslStandaloneSetup
import de.fhdo.lemma.data.DataModel
import de.fhdo.lemma.data.DataPackage
import de.fhdo.lemma.data.datadsl.extractor.DataDslExtractor
import de.fhdo.lemma.reconstruction.MongoDbRepository
import de.fhdo.lemma.reconstruction.domain.Context
import de.fhdo.lemma.reconstruction.domain.LemmaDomainGenerator
import de.fhdo.lemma.reconstruction.util.Util
import de.fhdo.lemma.utils.LemmaUtils
import java.io.File
import java.io.FileInputStream
import java.nio.charset.Charset
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.util.List
import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EPackage
import org.eclipse.jface.dialogs.MessageDialog
import org.eclipse.swt.SWT
import org.eclipse.swt.widgets.DirectoryDialog
import org.eclipse.ui.PlatformUI
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.validation.CheckMode
import de.fhdo.lemma.reconstruction.service.Microservice
import de.fhdo.lemma.service.ServiceModel
import de.fhdo.lemma.reconstruction.service.LemmaServiceGenerator
import de.fhdo.lemma.servicedsl.extractor.ServiceDslExtractor
import de.fhdo.lemma.service.ServicePackage
import de.fhdo.lemma.ServiceDslStandaloneSetup

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

	/**
	 * Executing the model generation process
	 */
    override execute(ExecutionEvent event) throws ExecutionException {
    	init
        receiveMongoDbEndpoints
        loadContextInformationFromMongoDb
        loadMicroservicesFromMongoDB

        displayReconstructionInforation
        selectTargetFolderForModelGeneration
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
        val dialog = new LemmaReconstructionResultsDialog(SHELL, initialContexts, initialMicroservices)
        dialog.create
        dialog.open
        selectedContexts = dialog.selectedContexts
        selectedMicroservices = dialog.selectedMicroservices
    }

	/** 
	 * Load reconstructed domain information from the MongoDB database 
	 */
    private def loadContextInformationFromMongoDb() {
        val repository = new MongoDbRepository(mongoDbHostname, Integer::parseInt(mongoDbPort))
        initialContexts.addAll(repository.getReconstructedContexts)
    }
    
    /** 
	 * Load reconstructed domain information from the MongoDB database 
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
	 * Generate the models based on the previous selection
	 */
    private def generateModels() {
    	if (!selectedContexts.nullOrEmpty)
        	generateDomainModels
        	generateServiceModels
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
        val generator = new LemmaServiceGenerator
        selectedMicroservices.forEach[
            val model = generator.generateModelFrom(it)
            serviceModels.add(model)
        ]
    }

	/**
	 * Write LEMMA models to the selected folder
	 */
    private def writeModelsToFolder() {
        domainDataModels.forEach[
            writeDomainDataModel(it)
        ]
    }

	/** 
	 * Configuration and specific execution to write LEMMA domain models to the selected folder 
	 */
    private def writeDomainDataModel(DataModel model) {
        val dataModel = new DataDslExtractor().extractToString(model)
        val fileName = model.contexts.get(0).name
        val filePath
            = '''«reconstructionPath»«File.separator»domain«File.separator»«fileName».data'''

        Files.createDirectories(Paths.get('''«reconstructionPath»«File.separator»domain'''))
        Files.write(Paths.get(filePath), dataModel.bytes)
        validateDataModel(filePath)
    }

	/**
	 * Validated the created LEMMA domain model and adjust potential issues
	 */
   	private def validateDataModel(String path) {
   		EPackage.Registry.INSTANCE.put(DataPackage.eNS_URI, DataPackage.eINSTANCE)
   		val setup = new DataDslStandaloneSetup
   		val injector = setup.createInjectorAndDoEMFRegistration
   		val resourceSet = injector.getInstance(XtextResourceSet)
   		val uri = LemmaUtils.convertToAbsoluteFileUri(URI.createURI(path).toString, path)
   		val resource = resourceSet.createResource(URI.createURI(uri)) as XtextResource
   		resource.load(new FileInputStream(path), resourceSet.getLoadOptions())
   		val validator = resource.getResourceServiceProvider().getResourceValidator()
   		val issues = validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl)

   		if (!issues.nullOrEmpty) {
   			val maskedModel = Util.maskModel(path, issues)
   			Files.write(Path.of(path), maskedModel, Charset.defaultCharset)
   		}
   	}
   		/** 
	 * Configuration and specific execution to write LEMMA service models to the selected folder 
	 */
	private def writeServiceModel(ServiceModel model) {
        val serviceModel = new ServiceDslExtractor().extractToString(model)
        val fileName = model.microservices.get(0).qualifiedNameParts.lastOrNull
        val filePath
            = '''«reconstructionPath»«File.separator»service«File.separator»«fileName».services'''
        Files.createDirectories(Paths.get('''«reconstructionPath»«File.separator»service'''))
        Files.write(Paths.get(filePath), serviceModel.bytes)
        validateServiceModel(filePath)
    }
    
    /**
	 * Validated the created LEMMA service model and adjust potential issues
	 */
    private def validateServiceModel(String path) {
    	EPackage.Registry.INSTANCE.put(ServicePackage.eNS_URI, DataPackage.eINSTANCE)
    	val setup = new ServiceDslStandaloneSetup
    	val injector = setup.createInjectorAndDoEMFRegistration
   		val resourceSet = injector.getInstance(XtextResourceSet)
   		val resource = resourceSet.createResource(URI.createURI(path)) as XtextResource
   		resource.load(new FileInputStream(path), resourceSet.getLoadOptions())
   		val validator = resource.getResourceServiceProvider().getResourceValidator()
   		val issues = validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl)
   		
   		if (!issues.nullOrEmpty) {
   			val maskedModel = Util.maskModel(path, issues)
   			Files.write(Path.of(path), maskedModel, Charset.defaultCharset)
   		}
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
    }
}