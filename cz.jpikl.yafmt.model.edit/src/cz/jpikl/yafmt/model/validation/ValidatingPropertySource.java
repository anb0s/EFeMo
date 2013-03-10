package cz.jpikl.yafmt.model.validation;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.ui.views.properties.IPropertyDescriptor;

public class ValidatingPropertySource extends UnwrappingPropertySource {

    protected IStructuralFeatureValidator validator;

    public ValidatingPropertySource(Object object, IItemPropertySource itemPropertySource, IStructuralFeatureValidator validator) {
        super(object, itemPropertySource);
        this.validator = validator;
    }

    @Override
    protected IPropertyDescriptor createPropertyDescriptor(IItemPropertyDescriptor itemPropertyDescriptor) {
        return new ValidatingPropertyDescriptor(object, itemPropertyDescriptor, validator);
    }

}
