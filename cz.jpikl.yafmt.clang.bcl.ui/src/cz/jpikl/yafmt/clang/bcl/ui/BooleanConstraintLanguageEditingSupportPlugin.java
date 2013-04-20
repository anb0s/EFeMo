package cz.jpikl.yafmt.clang.bcl.ui;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;

import cz.jpikl.yafmt.clang.bcl.ui.internal.BooleanConstraintLanguageActivator;

public class BooleanConstraintLanguageEditingSupportPlugin extends BooleanConstraintLanguageActivator {

    private static final String PLUGIN_ID = "cz.jpikl.yafmt.clang.bcl.ui";

    public static ImageDescriptor getImageDescriptor(String path) {
        return imageDescriptorFromPlugin(PLUGIN_ID, "icons/" + path);
    }

    private void registerImage(ImageRegistry registry, String name) {
        registry.put(name, getImageDescriptor(name).createImage());
    }
    
    @Override
    protected void initializeImageRegistry(ImageRegistry registry) {
        registerImage(registry, "id.png");
    }

}