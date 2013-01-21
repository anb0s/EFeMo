/**
 */
package cz.jpikl.yafmt.model.fm;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cz.jpikl.yafmt.model.fm.Feature#getId <em>Id</em>}</li>
 *   <li>{@link cz.jpikl.yafmt.model.fm.Feature#getName <em>Name</em>}</li>
 *   <li>{@link cz.jpikl.yafmt.model.fm.Feature#getDescription <em>Description</em>}</li>
 *   <li>{@link cz.jpikl.yafmt.model.fm.Feature#getLower <em>Lower</em>}</li>
 *   <li>{@link cz.jpikl.yafmt.model.fm.Feature#getUpper <em>Upper</em>}</li>
 *   <li>{@link cz.jpikl.yafmt.model.fm.Feature#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link cz.jpikl.yafmt.model.fm.Feature#getParent <em>Parent</em>}</li>
 *   <li>{@link cz.jpikl.yafmt.model.fm.Feature#getFeatures <em>Features</em>}</li>
 *   <li>{@link cz.jpikl.yafmt.model.fm.Feature#getGroups <em>Groups</em>}</li>
 * </ul>
 * </p>
 *
 * @see cz.jpikl.yafmt.model.fm.FeatureModelPackage#getFeature()
 * @model
 * @generated
 */
public interface Feature extends EObject {
    /**
     * Returns the value of the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Id</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Id</em>' attribute.
     * @see #setId(String)
     * @see cz.jpikl.yafmt.model.fm.FeatureModelPackage#getFeature_Id()
     * @model id="true" required="true"
     * @generated
     */
    String getId();

    /**
     * Sets the value of the '{@link cz.jpikl.yafmt.model.fm.Feature#getId <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */
    void setId(String value);

    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see cz.jpikl.yafmt.model.fm.FeatureModelPackage#getFeature_Name()
     * @model required="true"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link cz.jpikl.yafmt.model.fm.Feature#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Description</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Description</em>' attribute.
     * @see #setDescription(String)
     * @see cz.jpikl.yafmt.model.fm.FeatureModelPackage#getFeature_Description()
     * @model
     * @generated
     */
    String getDescription();

    /**
     * Sets the value of the '{@link cz.jpikl.yafmt.model.fm.Feature#getDescription <em>Description</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Description</em>' attribute.
     * @see #getDescription()
     * @generated
     */
    void setDescription(String value);

    /**
     * Returns the value of the '<em><b>Lower</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Lower</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Lower</em>' attribute.
     * @see #setLower(int)
     * @see cz.jpikl.yafmt.model.fm.FeatureModelPackage#getFeature_Lower()
     * @model required="true"
     * @generated
     */
    int getLower();

    /**
     * Sets the value of the '{@link cz.jpikl.yafmt.model.fm.Feature#getLower <em>Lower</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Lower</em>' attribute.
     * @see #getLower()
     * @generated
     */
    void setLower(int value);

    /**
     * Returns the value of the '<em><b>Upper</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Upper</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Upper</em>' attribute.
     * @see #setUpper(int)
     * @see cz.jpikl.yafmt.model.fm.FeatureModelPackage#getFeature_Upper()
     * @model required="true"
     * @generated
     */
    int getUpper();

    /**
     * Sets the value of the '{@link cz.jpikl.yafmt.model.fm.Feature#getUpper <em>Upper</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Upper</em>' attribute.
     * @see #getUpper()
     * @generated
     */
    void setUpper(int value);

    /**
     * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
     * The list contents are of type {@link cz.jpikl.yafmt.model.fm.Attribute}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Attributes</em>' containment reference list.
     * @see cz.jpikl.yafmt.model.fm.FeatureModelPackage#getFeature_Attributes()
     * @model containment="true"
     * @generated
     */
    EList<Attribute> getAttributes();

    /**
     * Returns the value of the '<em><b>Parent</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parent</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Parent</em>' reference.
     * @see cz.jpikl.yafmt.model.fm.FeatureModelPackage#getFeature_Parent()
     * @model transient="true" changeable="false" volatile="true" derived="true"
     * @generated
     */
    EObject getParent();

    /**
     * Returns the value of the '<em><b>Features</b></em>' containment reference list.
     * The list contents are of type {@link cz.jpikl.yafmt.model.fm.Feature}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Features</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Features</em>' containment reference list.
     * @see cz.jpikl.yafmt.model.fm.FeatureModelPackage#getFeature_Features()
     * @model containment="true"
     * @generated
     */
    EList<Feature> getFeatures();

    /**
     * Returns the value of the '<em><b>Groups</b></em>' containment reference list.
     * The list contents are of type {@link cz.jpikl.yafmt.model.fm.Group}.
     * It is bidirectional and its opposite is '{@link cz.jpikl.yafmt.model.fm.Group#getParent <em>Parent</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Groups</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Groups</em>' containment reference list.
     * @see cz.jpikl.yafmt.model.fm.FeatureModelPackage#getFeature_Groups()
     * @see cz.jpikl.yafmt.model.fm.Group#getParent
     * @model opposite="parent" containment="true"
     * @generated
     */
    EList<Group> getGroups();

} // Feature