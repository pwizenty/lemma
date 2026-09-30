package de.fhdo.lemma.reconstruction.util

import java.io.File
import java.nio.file.Files
import java.util.LinkedHashMap
import java.util.Map
import java.util.regex.Pattern
import org.eclipse.core.runtime.FileLocator
import org.osgi.framework.FrameworkUtil

/**
 * The types a hand-written technology model of this bundle declares.
 *
 * The reconstruction finds types it has no source for, such as Spring's
 * Authentication or HttpServletRequest. They cannot become data structures,
 * but a technology model may declare them, and a service model can then refer
 * to them instead of leaving the parameter unspecified.
 *
 * Only a type the model declares can be referred to, so the generator asks
 * here before it emits a reference. Reading the model is a scan of its
 * declarations rather than a parse: the Technology DSL is not on the classpath
 * of this bundle, and the declarations are what is needed.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class TechnologyTypes {
    /**
     * Kind of a declared type, which decides what a reference to it is.
     */
    enum Kind {
        PRIMITIVE,
        COLLECTION,
        STRUCTURE
    }

    static val TECHNOLOGY_MODEL_FOLDER = "models/technology"

    static val DECLARATION = Pattern.compile(
        "(primitive|collection|structure)\\s+type\\s+(\\w+)")

    static val cache = new LinkedHashMap<String, Map<String, Kind>>

    /**
     * Read the types a technology model declares, by name.
     *
     * @param modelFileName file name of the model inside this bundle
     * @return the declared types, empty when the model cannot be read
     */
    def static Map<String, Kind> declaredTypes(String modelFileName) {
        if (cache.containsKey(modelFileName)) {
            return cache.get(modelFileName)
        }

        val types = new LinkedHashMap<String, Kind>
        val model = readModel(modelFileName)
        if (model !== null) {
            val matcher = DECLARATION.matcher(model)
            while (matcher.find) {
                val kind = switch (matcher.group(1)) {
                    case "primitive": Kind.PRIMITIVE
                    case "collection": Kind.COLLECTION
                    default: Kind.STRUCTURE
                }
                types.put(matcher.group(2), kind)
            }
        }

        cache.put(modelFileName, types)
        return types
    }

    /**
     * Read a technology model of this bundle, or null when it is not there.
     */
    private def static String readModel(String modelFileName) {
        val bundle = FrameworkUtil.getBundle(TechnologyTypes)
        if (bundle === null) {
            return null
        }

        val entry = bundle.getEntry('''«TECHNOLOGY_MODEL_FOLDER»/«modelFileName»'''.toString)
        if (entry !== null) {
            val stream = entry.openStream
            try {
                return new String(stream.readAllBytes)
            } finally {
                stream.close
            }
        }

        // A launched workbench does not necessarily expose a plain folder of a
        // bundle as an entry, so its file system is read as well.
        val file = new File(FileLocator.getBundleFile(bundle),
            '''«TECHNOLOGY_MODEL_FOLDER»/«modelFileName»'''.toString)
        if (file.file) {
            return new String(Files.readAllBytes(file.toPath))
        }
        return null
    }
}
