package de.fhdo.lemma.reconstruction.io

import de.fhdo.lemma.ServiceDslStandaloneSetup
import de.fhdo.lemma.data.DataDslStandaloneSetup
import de.fhdo.lemma.operation.OperationModel
import de.fhdo.lemma.operation.OperationPackage
import de.fhdo.lemma.operationdsl.OperationDslStandaloneSetup
import de.fhdo.lemma.operationdsl.extractor.OperationDslExtractor
import de.fhdo.lemma.data.DataModel
import de.fhdo.lemma.data.DataPackage
import de.fhdo.lemma.data.datadsl.extractor.DataDslExtractor
import de.fhdo.lemma.reconstruction.util.Util
import de.fhdo.lemma.service.ServiceModel
import de.fhdo.lemma.service.ServicePackage
import de.fhdo.lemma.servicedsl.extractor.ServiceDslExtractor
import de.fhdo.lemma.utils.LemmaUtils
import java.io.File
import java.io.FileInputStream
import java.nio.charset.Charset
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EPackage
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.validation.CheckMode

/**
 * Writing of generated LEMMA models into a target folder.
 *
 * Extracting a model to its textual representation, writing it to disk and
 * masking the parts the validation rejects belong together: the file that ends
 * up in the target folder is the masked one, not the extractor's output. The
 * reconstruction wizard and the regression test therefore share this class so
 * that both observe the same result.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class ReconstructionModelWriter {
    /**
     * Write a LEMMA domain model to the "domain" sub folder of the given
     * target folder and return the path of the written file.
     */
    def static String writeDataModel(DataModel model, String targetFolder) {
        val extractedModel = new DataDslExtractor().extractToString(model)
        val fileName = model.contexts.get(0).name
        val folder = '''«targetFolder»«File.separator»domain'''
        val filePath = '''«folder»«File.separator»«fileName».data'''

        Files.createDirectories(Paths.get(folder))
        Files.write(Paths.get(filePath), extractedModel.bytes)

        EPackage.Registry.INSTANCE.put(DataPackage.eNS_URI, DataPackage.eINSTANCE)
        val injector = new DataDslStandaloneSetup().createInjectorAndDoEMFRegistration
        maskIssues(filePath, injector.getInstance(XtextResourceSet))

        return filePath
    }

    /**
     * Write a LEMMA service model to the "service" sub folder of the given
     * target folder and return the path of the written file.
     */
    def static String writeServiceModel(ServiceModel model, String targetFolder) {
        val extractedModel = new ServiceDslExtractor().extractToString(model)
        val fileName = model.microservices.get(0).qualifiedNameParts.lastOrNull
        val folder = '''«targetFolder»«File.separator»service'''
        val filePath = '''«folder»«File.separator»«fileName».services'''

        Files.createDirectories(Paths.get(folder))
        Files.write(Paths.get(filePath), extractedModel.bytes)

        EPackage.Registry.INSTANCE.put(ServicePackage.eNS_URI, ServicePackage.eINSTANCE)
        val injector = new ServiceDslStandaloneSetup().createInjectorAndDoEMFRegistration
        maskIssues(filePath, injector.getInstance(XtextResourceSet))

        return filePath
    }

    /**
     * Write a LEMMA operation model to the "operation" sub folder of the given
     * target folder and return the path of the written file.
     */
    def static String writeOperationModel(OperationModel model, String fileName,
        String targetFolder) {
        val extractedModel = new OperationDslExtractor().extractToString(model)
        val folder = '''«targetFolder»«File.separator»operation'''
        val filePath = '''«folder»«File.separator»«fileName».operation'''

        Files.createDirectories(Paths.get(folder))
        Files.write(Paths.get(filePath), extractedModel.bytes)

        EPackage.Registry.INSTANCE.put(OperationPackage.eNS_URI, OperationPackage.eINSTANCE)
        val injector = new OperationDslStandaloneSetup().createInjectorAndDoEMFRegistration
        maskIssues(filePath, injector.getInstance(XtextResourceSet))

        return filePath
    }

    /**
     * Load a written model, validate it and mask the parts the validation
     * rejects.
     */
    private def static maskIssues(String path, XtextResourceSet resourceSet) {
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
}
