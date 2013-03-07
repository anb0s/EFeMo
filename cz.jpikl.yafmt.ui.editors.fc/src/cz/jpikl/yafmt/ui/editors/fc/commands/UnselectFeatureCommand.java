package cz.jpikl.yafmt.ui.editors.fc.commands;

import java.util.Arrays;
import java.util.List;

import cz.jpikl.yafmt.model.fc.Selection;
import cz.jpikl.yafmt.ui.commands.RecordingCommand;
import cz.jpikl.yafmt.ui.editors.fc.FeatureConfigurationManager;

public class UnselectFeatureCommand extends RecordingCommand {

    private FeatureConfigurationManager featureConfigManager;
    private List<Selection> selections;
    
    public UnselectFeatureCommand(FeatureConfigurationManager featureConfigManager, List<Selection> selections) {
        this.featureConfigManager = featureConfigManager;
        this.selections = selections;
        setLabel("Select Features");
    }
    
    public UnselectFeatureCommand(FeatureConfigurationManager featureConfigManager, Selection selection) {
        this(featureConfigManager, Arrays.asList(new Selection[] { selection }));
    }
    
    @Override
    public boolean canExecute() {
        for(int i = 0; i < selections.size(); i++) {
            if(featureConfigManager.canUnselectFeature(selections.get(i)))
                return true;
        }
        return false;
    }
    
    @Override
    protected void initializeRecording() {
        for(int i = 0; i < selections.size(); i++)
            addRecordedObject(featureConfigManager.getParentSelection(selections.get(i)));
    }

    @Override
    protected void performRecording() {
        selections = featureConfigManager.unselectFeatures(selections);
    }
    
    @Override
    public void undo() {
        super.undo();
        featureConfigManager.featuresSelected(selections); // We have to notify FC manager manually.
    }
    
    @Override
    public void redo() {
        super.redo();
        featureConfigManager.featuresUnselected(selections); // We have to notify FC manager manually.
    }

}
