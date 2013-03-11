package cz.jpikl.yafmt.model.validation.fc;

import static cz.jpikl.yafmt.model.fc.FeatureConfigurationPackage.DOUBLE_VALUE;
import static cz.jpikl.yafmt.model.fc.FeatureConfigurationPackage.DOUBLE_VALUE__VALUE;
import static cz.jpikl.yafmt.model.fc.FeatureConfigurationPackage.FEATURE_CONFIGURATION;
import static cz.jpikl.yafmt.model.fc.FeatureConfigurationPackage.FEATURE_CONFIGURATION__NAME;
import static cz.jpikl.yafmt.model.fc.FeatureConfigurationPackage.INTEGER_VALUE;
import static cz.jpikl.yafmt.model.fc.FeatureConfigurationPackage.INTEGER_VALUE__VALUE;
import static cz.jpikl.yafmt.model.validation.Localization.getMessage;
import static cz.jpikl.yafmt.model.validation.ValidationUtil.checkEmptyValue;
import static cz.jpikl.yafmt.model.validation.ValidationUtil.printIds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import cz.jpikl.yafmt.clang.ConstraintLanguageException;
import cz.jpikl.yafmt.clang.ConstraintLanguagePlugin;
import cz.jpikl.yafmt.clang.ConstraintLanguageRegistry;
import cz.jpikl.yafmt.clang.IConstraintLanguage;
import cz.jpikl.yafmt.clang.IEvaluationResult;
import cz.jpikl.yafmt.clang.IEvaluator;
import cz.jpikl.yafmt.model.fc.DoubleValue;
import cz.jpikl.yafmt.model.fc.FeatureConfiguration;
import cz.jpikl.yafmt.model.fc.FeatureConfigurationPackage.Literals;
import cz.jpikl.yafmt.model.fc.IntegerValue;
import cz.jpikl.yafmt.model.fc.Selection;
import cz.jpikl.yafmt.model.fm.Constraint;
import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.FeatureModel;
import cz.jpikl.yafmt.model.fm.Group;
import cz.jpikl.yafmt.model.validation.BasicValidator;

public class FeatureConfigurationValidator extends BasicValidator {
    
    public static final FeatureConfigurationValidator INSTANCE = new FeatureConfigurationValidator();
    
    private EStructuralFeature[] FEATURE_CONFIGURATION_STRUCTURAL_FEATURES = { Literals.FEATURE_CONFIGURATION__NAME };

    // ===========================================================================
    //  Object validation
    // ===========================================================================
    
    @Override
    public boolean validate(EObject object, DiagnosticChain diagnostics) {
        switch(object.eClass().getClassifierID()) {
            case FEATURE_CONFIGURATION:
                // We have to check it since there are also classes from a different package (FeatureModelPackage).
                if(object instanceof FeatureConfiguration)
                    return validateFeatureConfiguration((FeatureConfiguration) object, diagnostics);
        }
        return false;
    }

    private boolean validateFeatureConfiguration(FeatureConfiguration featureConfiguration, DiagnosticChain diagnostics) {
        boolean result = validateStructuralFeatures(featureConfiguration, FEATURE_CONFIGURATION_STRUCTURAL_FEATURES, diagnostics);
        result &= validateAllContents(featureConfiguration, diagnostics);
        result &= validateLocalConstraints(featureConfiguration, diagnostics);
        result &= validateGlobalConstraints(featureConfiguration, diagnostics);
        return result;
    }
        
    public boolean validateLocalConstraints(FeatureConfiguration featureConfiguration, DiagnosticChain diagnostics) {
        TreeIterator<EObject> it = featureConfiguration.getFeatureModelCopy().eAllContents();
        boolean result = true;
        
        while(it.hasNext()) {
            EObject object = it.next();
            if(object instanceof Group)
                result &= validateLocalConstraint(featureConfiguration, (Group) object, diagnostics);
        }
        
        return result;
    }

    private boolean validateLocalConstraint(FeatureConfiguration featureConfiguration, Group group, DiagnosticChain diagnostics) {
        List<Selection> selections = featureConfiguration.getSelectionsById(group.getParent().getId());
        if(selections == null)
            return true;

        // Collect children IDs.
        Set<String> groupFeaturesIds = new HashSet<String>();
        for(Feature childFeature: group.getFeatures())
            groupFeaturesIds.add(childFeature.getId());

        // Local constraints.
        int lower = group.getLower();
        int upper = group.getUpper();
        boolean result = true;

        // Validate number of grouped selected features in each group.
        for(Selection selection: selections) {
            int groupSize = 0;

            for(Selection childSelection: selection.getSelections()) {
                if(groupFeaturesIds.contains(childSelection.getId()))
                    groupSize++;
            }

            if(groupSize < lower) {
                addError(diagnostics, getMessage("Errors_LocalConstraintMinimum", lower, printIds(groupFeaturesIds)), selection);
                result = false;
            }
            if((upper != -1) && (groupSize > upper)) {
                addError(diagnostics, getMessage("Errors_LocalConstraintMaximum", upper, printIds(groupFeaturesIds)), selection);
                result = false;
            }
        }
        
        return result;
    }
    
    public boolean validateGlobalConstraints(FeatureConfiguration featureConfiguration, DiagnosticChain diagnostics) {
        FeatureModel featureModel = featureConfiguration.getFeatureModelCopy();
        ConstraintLanguageRegistry registry = ConstraintLanguagePlugin.getDefault().getConstraintLanguageRegistry();
        
        List<Constraint> constraints = featureModel.getConstraints();
        List<IEvaluator> evaluators = new ArrayList<IEvaluator>(constraints.size());
        
        for(Constraint constraint: constraints) {
            try {
                // Add evaluators only for valid constraints.
                IConstraintLanguage language = registry.getLanguage(constraint.getLanguage());
                if(language == null)
                    continue;
                IEvaluator evaluator = language.createEvaluator(constraint.getValue());
                if(evaluator.validate(featureModel).isSuccess())
                    evaluators.add(evaluator);
            }
            catch(ConstraintLanguageException ex) {
                // Ignore it.
            }
        }
        
        return validateGlobalConstraints(featureConfiguration, evaluators, diagnostics);
    }
    
    public boolean validateGlobalConstraints(FeatureConfiguration featureConfiguration, List<IEvaluator> evaluators, DiagnosticChain diagnostics) {
        boolean result = true;
        for(IEvaluator evaluator: evaluators)
            result &= validateGlobalContraint(featureConfiguration, evaluator, diagnostics);
        return result;
    }

    private boolean validateGlobalContraint(FeatureConfiguration featureConfiguration, IEvaluator evaluator, DiagnosticChain diagnostics) {
        IEvaluationResult result = evaluator.evaluate(featureConfiguration);
        if(result.isSuccess())
            return true;

        String message = result.getErrorMessage();
        if((message == null) || (message.isEmpty()))
            message = "Global constraint is violated";
        
        List<Selection> selections = result.getProblemSelections();
        if(selections == null)
            selections = Collections.emptyList();
        
        addError(diagnostics, message, selections.toArray(new Selection[selections.size()]));
        return false;
    }
    
    // ===========================================================================
    //  Structural feature validation
    // ===========================================================================

    @Override
    protected void checkStructuralFeature(EObject object, EStructuralFeature structuralFeature, Object value) throws Exception {
        switch(object.eClass().getClassifierID()) {
            case FEATURE_CONFIGURATION:
                checkFeatureConfigurationStructuralFeature((FeatureConfiguration) object, structuralFeature, value);
                break;
                
            case INTEGER_VALUE:
                checkIntegerValueStructuralFeature((IntegerValue) object, structuralFeature, value);
                break;
                
            case DOUBLE_VALUE:
                checkDoubleValueStructuralFeature((DoubleValue) object, structuralFeature, value);
                break;
        }
    }

    private void checkFeatureConfigurationStructuralFeature(FeatureConfiguration featureConfiguration, EStructuralFeature structuralFeature, Object value) throws Exception {
        switch(structuralFeature.getFeatureID()) {
            case FEATURE_CONFIGURATION__NAME:
                checkEmptyValue(getMessage("FeatureConfiguration_Name"), (String) value);
                break;
        }
    }

    private void checkIntegerValueStructuralFeature(IntegerValue integerValue, EStructuralFeature structuralFeature, Object value) {
        switch(structuralFeature.getFeatureID()) {
            case INTEGER_VALUE__VALUE:
                if(value instanceof String)
                    Integer.parseInt((String) value);
                break;
        }
        
        
    }

    private void checkDoubleValueStructuralFeature(DoubleValue doubleValue, EStructuralFeature structuralFeature, Object value) {
        switch(structuralFeature.getFeatureID()) {
            case DOUBLE_VALUE__VALUE:
                if(value instanceof String)
                    Double.parseDouble((String) value);
                break;
        }
    }

}