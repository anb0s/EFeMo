package cz.jpikl.yafmt.ui.editors.fc.actions;

import java.util.List;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.ui.parts.GraphicalEditor;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.actions.LabelRetargetAction;
import org.eclipse.ui.actions.RetargetAction;

import cz.jpikl.yafmt.model.fc.Selection;
import cz.jpikl.yafmt.ui.editors.fc.FeatureConfigurationEditorPlugin;
import cz.jpikl.yafmt.ui.editors.fc.FeatureConfigurationManager;
import cz.jpikl.yafmt.ui.editors.fc.commands.SelectFeatureCommand;

public class SelectFeaturesAction extends FeatureSelectionAction {

    public static final String ID = "cz.jpikl.yafmt.ui.editors.fc.actions.SelectFeaturesAction";

    public static RetargetAction createRetargetAction() {
        return (RetargetAction) initAction(new LabelRetargetAction(null, null));
    }

    private static IAction initAction(IAction action) {
        action.setId(ID);
        action.setText("Select Features");
        action.setImageDescriptor(FeatureConfigurationEditorPlugin.getImageDescriptor("icons/select.png"));
        return action;
    }

    public SelectFeaturesAction(GraphicalEditor editor, FeatureConfigurationManager featureConfigManager) {
        super(editor, featureConfigManager);
        initAction(this);
    }

    protected Command getCommand() {
        List<Selection> featuresToSelect = getSelectedFeatures();
        if(featuresToSelect == null)
            return null;
        return new SelectFeatureCommand(getFeatureConfigManager(), featuresToSelect);
    }

}
