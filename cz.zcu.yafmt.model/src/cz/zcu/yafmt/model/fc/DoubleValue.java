/**
 */
package cz.zcu.yafmt.model.fc;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Double Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cz.zcu.yafmt.model.fc.DoubleValue#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see cz.zcu.yafmt.model.fc.FeatureConfigurationPackage#getDoubleValue()
 * @model
 * @generated
 */
public interface DoubleValue extends AttributeValue {
    /**
     * Returns the value of the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Value</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Value</em>' attribute.
     * @see #setValue(double)
     * @see cz.zcu.yafmt.model.fc.FeatureConfigurationPackage#getDoubleValue_Value()
     * @model required="true"
     * @generated
     */
    double getValue();

    /**
     * Sets the value of the '{@link cz.zcu.yafmt.model.fc.DoubleValue#getValue <em>Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Value</em>' attribute.
     * @see #getValue()
     * @generated
     */
    void setValue(double value);

} // DoubleValue
