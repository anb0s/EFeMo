package cz.zcu.yafmt.ui.editors.fm;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.PlatformUI;

import cz.zcu.yafmt.clang.ConstraintLanguageException;
import cz.zcu.yafmt.clang.ConstraintLanguagePlugin;
import cz.zcu.yafmt.clang.ConstraintLanguageRegistry;
import cz.zcu.yafmt.clang.IConstraintLanguage;
import cz.zcu.yafmt.clang.IEvaluator;
import cz.zcu.yafmt.clang.IValidationResult;
import cz.zcu.yafmt.clang.ui.EditingContext;
import cz.zcu.yafmt.clang.ui.EditingSupportRegistry;
import cz.zcu.yafmt.clang.ui.IEditingSupport;
import cz.zcu.yafmt.model.fm.Constraint;
import cz.zcu.yafmt.model.fm.FeatureModel;
import cz.zcu.yafmt.model.provider.util.CellEditorValidationMessageProvider;
import cz.zcu.yafmt.ui.editors.fm.commands.SetConstraintValueCommand;

public class ConstraintsEditorEditingSupport extends EditingSupport {

    private IStatusLineManager statusLineManager;
    private CommandStack commandStack;

    public ConstraintsEditorEditingSupport(ColumnViewer viewer, CommandStack commandStack) {
        super(viewer);
        this.commandStack = commandStack;
    }

    private Table getTable() {
        return ((TableViewer) getViewer()).getTable();
    }

    private FeatureModel getFeatureModel() {
        return (FeatureModel) getViewer().getInput();
    }

    private IStatusLineManager getStatusLineManager() {
        if(statusLineManager == null) {
            statusLineManager = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().
                    getActiveEditor().getEditorSite().getActionBars().getStatusLineManager();
        }
        return statusLineManager;
    }

    // ================================================================================
    //  EditingSupport
    // ================================================================================

    @Override
    protected CellEditor getCellEditor(Object element) {
        CellEditor cellEditor = null;

        String languageId = ((Constraint) element).getLanguage();
        ConstraintLanguageRegistry clRegistry = ConstraintLanguagePlugin.getDefault().getConstraintLanguageRegistry();
        EditingSupportRegistry esRegistry = ConstraintLanguagePlugin.getDefault().getEditingSupportRegistry();
        IConstraintLanguage language = clRegistry.getLanguage(languageId);
        IEditingSupport editingSupport = esRegistry.getEditingSupport(languageId);

        // Use custom editor from extension point if possible.
        if(editingSupport != null) {
            EditingContext context = new EditingContext(getFeatureModel());
            cellEditor = editingSupport.createCellEditor(getTable(), context);
        }
        else {
            cellEditor = new TextCellEditor(getTable());
        }

        if(cellEditor != null)
            cellEditor.addListener(new ValidationMessageProvider(cellEditor, language));
        
        return cellEditor;
    }

    @Override
    protected boolean canEdit(Object element) {
        return element instanceof Constraint;
    }

    @Override
    protected Object getValue(Object element) {
        return ((Constraint) element).getValue();
    }

    @Override
    protected void setValue(Object element, Object value) {
        Constraint constraint = (Constraint) element;
        if(constraint.getValue().equals(value))
            return;

        Command command = new SetConstraintValueCommand(constraint, (String) value);
        commandStack.execute(command);
    }

    // ================================================================================
    //  Input validator
    // ================================================================================

    private class ValidationMessageProvider extends CellEditorValidationMessageProvider {

        private IConstraintLanguage language;

        public ValidationMessageProvider(CellEditor cellEditor, IConstraintLanguage language) {
            super(cellEditor);
            this.language = language;
        }
        
        @Override
        public void applyEditorValue() {
            super.applyEditorValue();
            getStatusLineManager().setErrorMessage(null);
        }
        
        @Override
        public void cancelEditor() {
            super.cancelEditor();
            getStatusLineManager().setErrorMessage(null);
        }
        
        @Override
        public void editorValueChanged(boolean oldValidState, boolean newValidState) {
            super.editorValueChanged(oldValidState, newValidState);
            getStatusLineManager().setErrorMessage(cellEditor.getErrorMessage());
        }
        
        @Override
        protected String getErrorMessage(Object value) {
            if(language == null)
                return null;

            try {
                IEvaluator evaluator = language.createEvaluator((String) value);
                IValidationResult result = evaluator.validate(getFeatureModel());
                return result.isSuccess() ? null : result.getErrorMessage();
            }
            catch(ConstraintLanguageException ex) {
                return ex.getMessage();
            }
        }
        
    }

}
