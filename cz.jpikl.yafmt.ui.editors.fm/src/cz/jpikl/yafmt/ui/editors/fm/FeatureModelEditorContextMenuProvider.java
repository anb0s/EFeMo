package cz.jpikl.yafmt.ui.editors.fm;

import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.gef.ui.parts.GraphicalEditor;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.actions.ActionFactory;

import cz.jpikl.yafmt.ui.actions.ExportGraphicalEditorAsImageAction;
import cz.jpikl.yafmt.ui.editors.fm.actions.AutoLayoutAction;
import cz.jpikl.yafmt.ui.editors.fm.actions.GroupFeaturesAction;
import cz.jpikl.yafmt.ui.editors.fm.actions.SetFeatureCardinalityAction;
import cz.jpikl.yafmt.ui.editors.fm.actions.UngroupFeaturesAction;
import cz.jpikl.yafmt.ui.providers.GraphicalEditorContextMenuProvider;

public class FeatureModelEditorContextMenuProvider extends GraphicalEditorContextMenuProvider {

    public FeatureModelEditorContextMenuProvider(GraphicalEditor editor) {
        super(editor);
    }

    @Override
    public void buildContextMenu(IMenuManager menu) {
        super.buildContextMenu(menu);
        
        addActionToMenu(menu, GEFActionConstants.GROUP_UNDO, ActionFactory.UNDO.getId());
        addActionToMenu(menu, GEFActionConstants.GROUP_UNDO, ActionFactory.REDO.getId());
        addActionToMenu(menu, GEFActionConstants.GROUP_EDIT, ActionFactory.DELETE.getId());
        addActionToMenu(menu, GEFActionConstants.GROUP_REST, SetFeatureCardinalityAction.ID_OPTIONAL);
        addActionToMenu(menu, GEFActionConstants.GROUP_REST, SetFeatureCardinalityAction.ID_MANDATORY);
        addActionToMenu(menu, GEFActionConstants.GROUP_REST, GroupFeaturesAction.ID_XOR);
        addActionToMenu(menu, GEFActionConstants.GROUP_REST, GroupFeaturesAction.ID_OR);
        addActionToMenu(menu, GEFActionConstants.GROUP_REST, UngroupFeaturesAction.ID);
        addActionToMenu(menu, GEFActionConstants.GROUP_SAVE, AutoLayoutAction.ID);
        addActionToMenu(menu, GEFActionConstants.GROUP_SAVE, ExportGraphicalEditorAsImageAction.ID);
    }
    
}
