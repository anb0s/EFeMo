/**
 */
package cz.jpikl.yafmt.clang.scl.model;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import cz.jpikl.yafmt.model.fc.FeatureConfiguration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see cz.jpikl.yafmt.clang.scl.model.ModelPackage#getExpression()
 * @model
 * @generated
 */
public interface Expression extends EObject {
    
    void retrieveFeatureIds(Set<String> ids);
    
    boolean evaluate(FeatureConfiguration featureConfig, String context);

} // Expression