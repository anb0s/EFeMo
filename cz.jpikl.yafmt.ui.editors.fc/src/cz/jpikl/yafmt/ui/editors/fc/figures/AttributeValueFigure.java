package cz.jpikl.yafmt.ui.editors.fc.figures;

import static cz.jpikl.yafmt.model.fc.FeatureConfigurationPackage.BOOLEAN_VALUE;
import static cz.jpikl.yafmt.model.fc.FeatureConfigurationPackage.DOUBLE_VALUE;
import static cz.jpikl.yafmt.model.fc.FeatureConfigurationPackage.INTEGER_VALUE;
import static cz.jpikl.yafmt.model.fc.FeatureConfigurationPackage.STRING_VALUE;

import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;

import cz.jpikl.yafmt.model.fc.AttributeValue;
import cz.jpikl.yafmt.model.fc.BooleanValue;
import cz.jpikl.yafmt.model.fc.DoubleValue;
import cz.jpikl.yafmt.model.fc.IntegerValue;
import cz.jpikl.yafmt.model.fc.StringValue;
import cz.jpikl.yafmt.ui.figures.ErrorMarker;


public class AttributeValueFigure extends Label {

    private AttributeValue attributeValue;
    private ErrorMarker errorMarker;

    public AttributeValueFigure(AttributeValue attributeValue) {
        this.attributeValue = attributeValue;
        initialize();
        refresh();
    }

    // ==================================================================
    //  Initialization
    // ==================================================================
    
    private void initialize() {
        setForegroundColor(ColorConstants.black);
        add(createErrorMarker());
    }
    
    private IFigure createErrorMarker() {
        errorMarker = new ErrorMarker();
        return errorMarker;
    }

    // ==================================================================
    //  Properties
    // ==================================================================
    
    public void setErrors(List<String> messages) {
        errorMarker.setErrors(messages);
    }
    
    public void refresh() {
        setNameAndValue(attributeValue.getName(), getValue(attributeValue));
    }

    public void setValue(Object value) {
        setNameAndValue(attributeValue.getName(), value);
    }

    private void setNameAndValue(String name, Object value) {
        setText(name + " = " + valueToString(value));
    }
    
    private Object getValue(AttributeValue attributeValue) {
        switch(attributeValue.eClass().getClassifierID()) {
            case BOOLEAN_VALUE:
                return ((BooleanValue) attributeValue).isValue();
                
            case INTEGER_VALUE:
                return ((IntegerValue) attributeValue).getValue();
                
            case DOUBLE_VALUE:
                return ((DoubleValue) attributeValue).getValue();
                
            case STRING_VALUE:
                return ((StringValue) attributeValue).getValue();
                
            default:
                return null;
        }
    }
    
    private String valueToString(Object value) {
        return (value != null) ? value.toString() : "null";
    }
    
}
