package cz.jpikl.yafmt.ui.editors.fm.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.FeatureModelPackage;
import cz.jpikl.yafmt.model.fm.Group;
import cz.jpikl.yafmt.ui.editors.fm.figures.GroupFigure;
import cz.jpikl.yafmt.ui.editors.fm.figures.MiddlePointAnchor;
import cz.jpikl.yafmt.ui.editors.fm.layout.LayoutData;
import cz.jpikl.yafmt.ui.editors.fm.model.Connection;

public class GroupEditPart extends AbstractGraphicalEditPart implements NodeEditPart {
    
    private Group group;
    private Adapter groupAdapter;
    private LayoutData layoutData;
        
    public GroupEditPart(Group group, LayoutData layoutData) {
        this.group = group;
        this.groupAdapter = new GroupAdapter();
        this.layoutData = layoutData;
        setModel(group);
    }
    
    @Override
    public void activate() {
        super.activate();
        group.eAdapters().add(groupAdapter);
        loadModelLayout();
    }
    
    @Override
    public void deactivate() {
        group.eAdapters().remove(groupAdapter);
        super.deactivate();
    }
    
    @Override
    protected IFigure createFigure() {
        return new GroupFigure(layoutData, group);
    }
                
    private void loadModelLayout() {
        Rectangle bounds = layoutData.getMapping().get(group);
        if(bounds == null) {
            Rectangle parentBounds = layoutData.getMapping().get(group.getParent());
            int x, y, w, h;
            if(parentBounds == null) {
                x = y = 0;
                w = h = GroupFigure.SIZE;
            }
            else {
                x = parentBounds.x + (parentBounds.width - GroupFigure.SIZE) / 2;
                y = parentBounds.y + parentBounds.height - (GroupFigure.SIZE / 2);
                w = h = GroupFigure.SIZE;
            }
            bounds = new Rectangle(x, y, w, h);
        }
        layoutData.getMapping().put(group, bounds);
    }

    @Override
    protected List<Object> getModelTargetConnections() {
        if(group.getFeatures().isEmpty())
            return null;
        
        List<Object> connections = new ArrayList<Object>();
        for(Feature child: group.getFeatures())
            connections.add(new Connection(group, child));
        return connections;
    }
    
    @Override
    public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection) {
        return new MiddlePointAnchor(getFigure());
    }

    @Override
    public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connection) {
        return new MiddlePointAnchor(getFigure());
    }

    @Override
    public ConnectionAnchor getSourceConnectionAnchor(Request request) {
        return new MiddlePointAnchor(getFigure());
    }

    @Override
    public ConnectionAnchor getTargetConnectionAnchor(Request request) {
        return new MiddlePointAnchor(getFigure());
    }

    @Override
    protected void createEditPolicies() {
    }

    class GroupAdapter extends AdapterImpl {
        
        @Override
        public void notifyChanged(Notification notification) {
            switch(notification.getEventType()) {
                case Notification.ADD:
                case Notification.ADD_MANY:
                case Notification.REMOVE:
                case Notification.REMOVE_MANY:
                    refreshTargetConnections();
                    break;
                    
                case Notification.SET:
                    switch(notification.getFeatureID(Group.class)) {
                        case FeatureModelPackage.GROUP__LOWER:
                        case FeatureModelPackage.GROUP__UPPER:
                            ((GroupFigure) getFigure()).updateState();
                            break;
                    }
                    break;
            }
        }
        
    }
    
}
