/*
 * generated by Xtext 2.16.0
 */
package de.fhdo.lemma.data.ui;

import com.google.inject.Injector;
import de.fhdo.lemma.data.datadsl.ui.internal.DatadslActivator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class DataDslExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return Platform.getBundle(DatadslActivator.PLUGIN_ID);
	}
	
	@Override
	protected Injector getInjector() {
		DatadslActivator activator = DatadslActivator.getInstance();
		return activator != null ? activator.getInjector(DatadslActivator.DE_FHDO_LEMMA_DATA_DATADSL) : null;
	}

}
