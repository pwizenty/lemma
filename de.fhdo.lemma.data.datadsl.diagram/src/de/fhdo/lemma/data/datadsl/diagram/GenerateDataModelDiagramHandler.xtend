package de.fhdo.lemma.data.datadsl.diagram

import de.fhdo.lemma.data.DataDslStandaloneSetup
import de.fhdo.lemma.data.DataModel
import de.fhdo.lemma.data.DataPackage
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Paths
import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IResource
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EPackage
import org.eclipse.jface.dialogs.MessageDialog
import org.eclipse.ui.handlers.HandlerUtil
import org.eclipse.xtext.resource.XtextResourceSet

/**
 * Generate the diagram of the selected data models.
 *
 * A thin shell around [[DataModelDiagramGenerator]]: it finds the selected
 * files, loads each as a data model, and writes the generated PlantUML beside
 * it. Everything that decides what the diagram looks like is in the generator,
 * which needs no Eclipse and can therefore be checked without one.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class GenerateDataModelDiagramHandler extends AbstractHandler {
    static val DATA_EXTENSION = "data"
    static val DIAGRAM_EXTENSION = "puml"
    static val TITLE = "LEMMA Data Model Diagram"

    override execute(ExecutionEvent event) throws ExecutionException {
        val shell = HandlerUtil.getActiveShell(event)
        val files = HandlerUtil.getCurrentStructuredSelection(event).toList
            .filter(IFile)
            .filter[DATA_EXTENSION == fileExtension]
            .toList

        if (files.empty) {
            MessageDialog.openInformation(shell, TITLE,
                '''Select one or more .«DATA_EXTENSION» files to generate a diagram from.''')
            return null
        }

        val generator = new DataModelDiagramGenerator
        val resourceSet = createResourceSet
        val written = <String>newLinkedList
        val failed = <String>newLinkedList

        for (file : files) {
            try {
                written.add(generate(file, generator, resourceSet))
            } catch (Exception exception) {
                // One unreadable model must not stop the others, and what went
                // wrong is more useful than that something did.
                failed.add('''«file.name»: «exception.message»''')
            }
        }

        report(shell, written, failed)
        return null
    }

    /**
     * Generate the diagram of one file and write it beside the model.
     */
    private def String generate(IFile file, DataModelDiagramGenerator generator,
        XtextResourceSet resourceSet) {
        val location = file.location.toFile
        val resource = resourceSet.createResource(
            URI.createFileURI(location.absolutePath))
        resource.load(resourceSet.loadOptions)

        if (resource.contents.empty) {
            throw new IllegalStateException("the file holds no data model")
        }
        val model = resource.contents.head
        if (!(model instanceof DataModel)) {
            throw new IllegalStateException("the file holds no data model")
        }

        val diagram = generator.generate(model as DataModel)
        val target = Paths.get(
            location.parent, '''«baseName(file.name)».«DIAGRAM_EXTENSION»'''.toString)
        Files.write(target, diagram.getBytes(StandardCharsets.UTF_8))

        // The file is written outside the workspace's knowledge, so the folder
        // is refreshed for it to appear.
        file.parent.refreshLocal(IResource.DEPTH_ONE, new NullProgressMonitor)
        return target.fileName.toString
    }

    /**
     * A resource set that can read a data model.
     *
     * The same standalone setup the reconstruction's writer uses, which works
     * inside a running Eclipse as well.
     */
    private def XtextResourceSet createResourceSet() {
        EPackage.Registry.INSTANCE.put(DataPackage.eNS_URI, DataPackage.eINSTANCE)
        val injector = new DataDslStandaloneSetup().createInjectorAndDoEMFRegistration
        return injector.getInstance(XtextResourceSet)
    }

    private def String baseName(String fileName) {
        val separator = fileName.lastIndexOf(".")
        return if (separator > 0) fileName.substring(0, separator) else fileName
    }

    /**
     * Say what was written and what was not.
     */
    private def report(org.eclipse.swt.widgets.Shell shell, Iterable<String> written,
        Iterable<String> failed) {
        if (failed.empty) {
            MessageDialog.openInformation(shell, TITLE,
                '''
                Generated «written.size» diagram(s):

                «written.join("\n")»
                '''.toString)
            return
        }

        MessageDialog.openWarning(shell, TITLE,
            '''
            Generated «written.size» diagram(s)«IF !written.empty»:

            «written.join("\n")»«ENDIF»

            «failed.size» could not be read:

            «failed.join("\n")»
            '''.toString)
    }
}
