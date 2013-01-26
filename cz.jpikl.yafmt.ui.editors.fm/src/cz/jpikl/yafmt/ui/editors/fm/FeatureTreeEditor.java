package cz.jpikl.yafmt.ui.editors.fm;

import java.io.IOException;
import java.util.EventObject;
import java.util.Iterator;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.dnd.TemplateTransferDragSourceListener;
import org.eclipse.gef.dnd.TemplateTransferDropTargetListener;
import org.eclipse.gef.editparts.FreeformGraphicalRootEditPart;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.gef.ui.palette.PaletteViewer;
import org.eclipse.gef.ui.parts.GraphicalEditorWithPalette;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.PropertySheet;
import org.eclipse.ui.views.properties.PropertySheetPage;

import cz.jpikl.yafmt.model.fm.FeatureModel;
import cz.jpikl.yafmt.ui.editors.fm.actions.AddAttributeAction;
import cz.jpikl.yafmt.ui.editors.fm.actions.RemoveAttributeAction;
import cz.jpikl.yafmt.ui.editors.fm.layout.ModelLayout;
import cz.jpikl.yafmt.ui.editors.fm.layout.ModelLayoutFactory;
import cz.jpikl.yafmt.ui.editors.fm.layout.ModelLayoutPackage;
import cz.jpikl.yafmt.ui.editors.fm.operations.ResourceSaveOperation;
import cz.jpikl.yafmt.ui.editors.fm.parts.FeatureModelEditPartFactory;
import cz.jpikl.yafmt.ui.editors.fm.util.SelectionConverter;
import cz.jpikl.yafmt.ui.editors.fm.util.UnwrappingSelectionProvider;

public class FeatureTreeEditor extends GraphicalEditorWithPalette implements ISelectionListener {

    private MultiPageEditorPart parentEditor;
    private FeatureModel featureModel;
    private ModelLayout modelLayout;
    private PropertySheetPage propertySheetPage;
    private SelectionConverter selectionConverter;
    
    public FeatureTreeEditor(MultiPageEditorPart parentEditor, FeatureModel featureModel) {
        if(featureModel == null)
            throw new IllegalArgumentException("Feature model cannot be null");
        
        this.parentEditor = parentEditor;
        this.featureModel = featureModel;
        setEditDomain(new DefaultEditDomain(this));
    }
    
    @Override
    public void init(IEditorSite site, IEditorInput input) throws PartInitException {
        super.init(site, input);
        doLoad();
    }
        
    @Override
    @SuppressWarnings("unchecked")
    protected void createActions() {
        super.createActions();
        
        ActionRegistry registry = getActionRegistry();
        IAction action; 
        
        action = new AddAttributeAction(this);
        registry.registerAction(action);
        getSelectionActions().add(action.getId());
        
        action = new RemoveAttributeAction(this);
        registry.registerAction(action);
        getSelectionActions().add(action.getId());
    }
    
    @Override
    @SuppressWarnings("unchecked")
    protected void configureGraphicalViewer() {
        super.configureGraphicalViewer();
        
        GraphicalViewer viewer = getGraphicalViewer();
        viewer.setEditPartFactory(new FeatureModelEditPartFactory(modelLayout));
        viewer.setRootEditPart(new FreeformGraphicalRootEditPart());
        viewer.addDropTargetListener(new TemplateTransferDropTargetListener(viewer));
        viewer.setContextMenu(new FeatureTreeEditorContextMenuProvider(viewer, getActionRegistry()));
        
        // Actions need original selection provider.
        for(Iterator<IAction> it = getActionRegistry().getActions(); it.hasNext(); ) {
            IAction action = it.next();
            if(action instanceof SelectionAction)
                ((SelectionAction) action).setSelectionProvider(viewer);
        }
        
        selectionConverter = new SelectionConverter(viewer.getEditPartRegistry());
    }
    
    @Override
    protected void hookGraphicalViewer() {
        super.hookGraphicalViewer();
        // Provide unwrapped selections for rest of the world.
        getSite().setSelectionProvider(new UnwrappingSelectionProvider(getGraphicalViewer()));
    }
    
    @Override
    protected void initializeGraphicalViewer() {
        getGraphicalViewer().setContents(featureModel);
    }
    
    @Override
    protected void configurePaletteViewer() {
        super.configurePaletteViewer();
        PaletteViewer palleteViewer = getPaletteViewer();
        palleteViewer.addDragSourceListener(new TemplateTransferDragSourceListener(palleteViewer));
    }
    
    @Override
    protected PaletteRoot getPaletteRoot() {
        return new FeatureTreeEditorPaletteRoot();
    }
    
    @Override
    public void commandStackChanged(EventObject event) {
        super.commandStackChanged(event);
        firePropertyChange(PROP_DIRTY);
    }
        
    @SuppressWarnings("unused")
    private void doLoad() {
        ModelLayoutPackage pkg = ModelLayoutPackage.eINSTANCE; // For package registration.
        ResourceSet resourceSet = featureModel.eResource().getResourceSet();
        String path = featureModel.eResource().getURI().toPlatformString(true) + ".layout";
        Resource resource = resourceSet.createResource(URI.createPlatformResourceURI(path, true));
        
        try {
            resource.load(null);
            modelLayout = (ModelLayout) resource.getContents().get(0);
        }
        catch(IOException ex) {
            modelLayout = ModelLayoutFactory.eINSTANCE.createModelLayout();
            resource.getContents().add(modelLayout);
        }
    }
    
    @Override
    public void doSave(IProgressMonitor monitor) {
        try {
            getSite().getWorkbenchWindow().run(true, false, new ResourceSaveOperation(modelLayout.eResource()));
        }
        catch(Exception ex) {
            FeatureModelEditorPlugin.getDefault().getLog().log(new Status(Status.ERROR, 
                    FeatureModelEditorPlugin.PLUGIN_ID, ex.getMessage(), ex));
        }
        
        getEditDomain().getCommandStack().markSaveLocation();
    }
    
    public void prepareToSaveAs(IEditorInput input) {
        setInput(input);
        String path = featureModel.eResource().getURI().toPlatformString(true) + ".layout";
        modelLayout.eResource().setURI(URI.createPlatformResourceURI(path, true));
    }
    
    @Override
    public void selectionChanged(IWorkbenchPart part, ISelection selection) {        
        // Check if this is the active editor.
        if((parentEditor != getSite().getPage().getActiveEditor()) || (parentEditor.getSelectedPage() != this))
            return;
        
        // Ignore invalid selections.
        if((part != getSite().getPage().getActivePart()) || (part instanceof PropertySheet))
            return;
                
        // Handle selection change.
        if(part == parentEditor)
            handleSelectionFromItself(selection);
        else
            handleSelectionFromOthers(selection);       
    }
    
    private void handleSelectionFromItself(ISelection selection) {
        // Update all actions which state depends on selection.
        updateActions(getSelectionActions());
    }
    
    private void handleSelectionFromOthers(ISelection selection) {
        // Apply selection to the editor.
        selection = selectionConverter.wrapSelection(selection);
        getGraphicalViewer().setSelection(selection);
        if(selection.isEmpty())
            return;
        
        // Center viewport to last selected object.
        if(selection instanceof IStructuredSelection) {
            Object[] objects = ((IStructuredSelection) selection).toArray();
            for(int i = objects.length - 1; i >= 0; i--) {
                if(objects[i] instanceof GraphicalEditPart) {
                    centerViewportToEditPart((GraphicalEditPart) objects[i]);
                    break;
                }
            }
        }
    }
    
    private void centerViewportToEditPart(GraphicalEditPart editPart) {
        FreeformGraphicalRootEditPart rootEditPart = (FreeformGraphicalRootEditPart) getGraphicalViewer().getRootEditPart();
        Viewport viewport = (Viewport) rootEditPart.getFigure();
        Point point = editPart.getFigure().getBounds().getCenter();
        int x = point.x - viewport.getSize().width / 2;
        int y = point.y - viewport.getSize().height / 2;
        viewport.setViewLocation(x, y);
    }
            
    @Override
    @SuppressWarnings("rawtypes")
    public Object getAdapter(Class type) {
        if(type == IPropertySheetPage.class) {
            if(propertySheetPage == null) {
                IAction undoAction = getActionRegistry().getAction(ActionFactory.UNDO.getId());
                IAction redoAction = getActionRegistry().getAction(ActionFactory.REDO.getId());
                propertySheetPage = new FeatureModelPropertySheetPage(getCommandStack(), undoAction, redoAction);
            }
            return propertySheetPage;
        }
        return super.getAdapter(type);
    }
    
}