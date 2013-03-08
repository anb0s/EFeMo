package cz.jpikl.yafmt.clang.ui;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

import cz.jpikl.yafmt.clang.ConstraintLanguagePlugin;

public class EditingSupportRegistry {

    private static final String EXTENSION_POINT_ID = "cz.jpikl.yafmt.clang.ui";

    private Map<String, EditingSupportDescriptor> registry = new HashMap<String, EditingSupportDescriptor>();

    public EditingSupportRegistry() {
        for(IConfigurationElement element: Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_POINT_ID)) {
            try {
                EditingSupportDescriptor descriptor = new EditingSupportDescriptor(element);
                registry.put(descriptor.getLanguageId(), descriptor);
            }
            catch(Exception ex) {
                ConstraintLanguagePlugin.getDefault().logError("Invalid " + EXTENSION_POINT_ID + " extension point element.", ex);
            }
        }
    }

    public EditingSupportDescriptor getDescriptor(String id) {
        return registry.get(id);
    }

    public IEditingSupport getEditingSupport(String id) {
        EditingSupportDescriptor descriptor = registry.get(id);
        return (descriptor == null) ? null : descriptor.getEditingSupport();
    }

}
