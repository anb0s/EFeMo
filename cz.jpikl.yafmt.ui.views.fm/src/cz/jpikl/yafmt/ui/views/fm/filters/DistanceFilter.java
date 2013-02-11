package cz.jpikl.yafmt.ui.views.fm.filters;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import cz.jpikl.yafmt.clang.ConstraintLanguageException;
import cz.jpikl.yafmt.clang.ConstraintLanguagePlugin;
import cz.jpikl.yafmt.clang.ConstraintLanguageRegistry;
import cz.jpikl.yafmt.clang.IConstraintLanguage;
import cz.jpikl.yafmt.clang.IEvaluator;
import cz.jpikl.yafmt.model.fm.Constraint;
import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.FeatureModel;
import cz.jpikl.yafmt.model.fm.Group;

public class DistanceFilter extends ViewerFilter {

    public static final int INFINITE_DISTACE = -1;
    
    private Set<Feature> visibleFeatures = new HashSet<Feature>();
    private int distance = INFINITE_DISTACE;
    
    public DistanceFilter(int distance) {
        setDistance(distance);
    }
    
    public void setDistance(int distance) {
        this.distance = distance;
    }
    
    public int getDistance() {
        return distance;
    }
    
    public void update(ISelection selection, FeatureModel featureModel) {
        visibleFeatures.clear();
        
        if((distance == INFINITE_DISTACE) || !(selection instanceof IStructuredSelection))
            return;
        
        for(Object element: ((IStructuredSelection) selection).toArray()) {
            if(element instanceof Feature)
                processFeature((Feature) element, 0, true);
            else if(element instanceof Group)            
                processGroup((Group) element, 0);
            else if(element instanceof Constraint)
                processConstraint((Constraint) element);
        }
        
        if(visibleFeatures.isEmpty() && (featureModel != null))
            processFeature(featureModel.getRoot(), 0, true);
            
    }
        
    private void processFeature(Feature feature, int level, boolean forceAdd) {
        if((level > distance) || (visibleFeatures.contains(feature) && !forceAdd))
            return;
        
        visibleFeatures.add(feature);
        
        EObject parent = feature.getParent();
        if(parent instanceof Feature)
            processFeature((Feature) parent, level + 1, false);
        else if(parent instanceof Group)
            processFeature(((Group) parent).getParent(), level + 1, false);
            
        for(Feature child: feature.getFeatures())
            processFeature(child, level + 1, false);
        for(Group group: feature.getGroups())
            processGroup(group, level + 1);
    }
    
    private void processGroup(Group group, int level) {
        for(Feature feature: group.getFeatures())
            processFeature(feature, level, false);
    }
    
    private void processConstraint(Constraint constraint) {
        ConstraintLanguageRegistry registry = ConstraintLanguagePlugin.getDefault().getConstraintLanguageRegistry();
        IConstraintLanguage language = registry.getLanguage(constraint.getLanguage());
        if(language == null)
            return;
        
        try {
            // Process all features affected by the selected constraint.
            IEvaluator evaluator = language.createEvaluator(constraint.getValue());
            for(Feature feature: evaluator.getAffectedFeatures(constraint.getFeatureModel()))
                processFeature(feature, 0, false);
        }
        catch(ConstraintLanguageException ex) {
            // Just ignore problematic constraint.
        }
    }
    
    @Override
    public boolean select(Viewer viewer, Object parentElement, Object element) {
        if((distance == INFINITE_DISTACE) || !(element instanceof Feature))
            return true;
        return visibleFeatures.contains(element);
    }

}
