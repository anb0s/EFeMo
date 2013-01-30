package cz.jpikl.yafmt.ui.editors.fm.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import cz.jpikl.yafmt.model.fm.Attribute;
import cz.jpikl.yafmt.model.fm.FeatureModelPackage;
import cz.jpikl.yafmt.ui.editors.fm.figures.AttributeFigure;
import cz.jpikl.yafmt.ui.editors.fm.policies.AttributeEditPolicy;

public class AttributeEditPart extends AbstractGraphicalEditPart {

    private Attribute attribute;
    private Adapter attributeAdapter;
    
    public AttributeEditPart(Attribute attribute) {
        this.attribute = attribute;
        this.attributeAdapter = new AttributeAdapter();
        setModel(attribute);
    }
    
    @Override
    public void activate() {
        super.activate();
        attribute.eAdapters().add(attributeAdapter);
    }
    
    @Override
    public void deactivate() {
        attribute.eAdapters().remove(attributeAdapter);
        super.deactivate();
    }
    
    @Override
    protected IFigure createFigure() {
        return new AttributeFigure(attribute);
    }

    @Override
    protected void createEditPolicies() {
        installEditPolicy(EditPolicy.COMPONENT_ROLE, new AttributeEditPolicy());
    }
    
    private class AttributeAdapter extends AdapterImpl {
        
        @Override
        public void notifyChanged(Notification notification) {
            switch(notification.getFeatureID(Attribute.class)) {
                case FeatureModelPackage.ATTRIBUTE__NAME:
                case FeatureModelPackage.ATTRIBUTE__TYPE:
                    ((AttributeFigure) getFigure()).updateLabel(attribute);
            }
        }
        
    }

}