/*
 * generated by Xtext
 */
package cz.jpikl.yafmt.clang.scl.ui;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

import cz.jpikl.yafmt.clang.scl.ui.internal.SimpleConstraintLanguageActivator;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class SimpleConstraintLanguageExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return SimpleConstraintLanguageActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return SimpleConstraintLanguageActivator.getInstance().getInjector(SimpleConstraintLanguageActivator.CZ_JPIKL_YAFMT_CLANG_SCL_SIMPLECONSTRAINTLANGUAGE);
	}
	
}