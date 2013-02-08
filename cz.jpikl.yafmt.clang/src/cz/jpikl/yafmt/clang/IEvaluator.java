package cz.jpikl.yafmt.clang;

import java.util.List;

import cz.jpikl.yafmt.model.fc.FeatureConfiguration;
import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.FeatureModel;

public interface IEvaluator {

    List<Feature> getAffectedFeatures(FeatureModel featureModel);
    
    IEvaluationResult evaluate(FeatureConfiguration featureConfig);
    
}