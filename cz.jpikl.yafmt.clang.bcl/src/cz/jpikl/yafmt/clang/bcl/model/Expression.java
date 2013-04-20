/**
 */
package cz.jpikl.yafmt.clang.bcl.model;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import cz.jpikl.yafmt.model.fc.FeatureConfiguration;
import cz.jpikl.yafmt.model.fc.Selection;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see cz.jpikl.yafmt.clang.bcl.model.ModelPackage#getExpression()
 * @model abstract="true"
 * @generated
 */
public interface Expression extends EObject {
    
    void retrieveFeatureIds(Set<String> ids);
    
    boolean evaluate(FeatureConfiguration featureConfig, Selection context, Set<Selection> problemSelections, boolean expectTrue);

} // Expression