package cz.jpikl.yafmt.ui.views.fm.figures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

import cz.jpikl.yafmt.ui.views.fm.decorations.IDecoration;
import cz.jpikl.yafmt.ui.views.fm.graph.DecoratableGraphViewer;

public class DecoratableNodeFigure extends NodeFigure {
    
    private List<IDecoration> decorations = new ArrayList<IDecoration>();
    private int decorationSpace = 2;
     
    public void setDecorationSpace(int decorationSpace) {
        this.decorationSpace = decorationSpace;
    }
    
    public int getDecorationSpace() {
        return decorationSpace;
    }
    
    public List<IDecoration> getDecorations() {
        return Collections.unmodifiableList(decorations);
    }
    
    public void addDecoration(IDecoration decoration) {
        decorations.add(decoration);
        if(!decoration.isAutoPositioned())
            decoration.setBounds(decoration.computeNewPosition(bounds));
        addDecorationToLayer(decoration);
    }
        
    public void removeDecoration(IDecoration decoration) {
        decorations.remove(decoration);
        removeDecorationFromLayer(decoration);  
    }
    
    private void addDecorationToLayer(IDecoration decoration) {
        if(getParent() != null)
            getDecorationLayer(decoration).add(decoration);        
    }
        
    private void removeDecorationFromLayer(IDecoration decoration) {
        if(getParent() != null)
            getDecorationLayer(decoration).remove(decoration);
    }
    
    public void moveDecorations() {
        IFigure parent = getParent();
        if(parent == null)
            return;
        
        Rectangle rect = (Rectangle) parent.getLayoutManager().getConstraint(this);
        if(rect == null)
            return;
        
        Point bottomLeft = rect.getBottomLeft();
        int x = -1;
        int y = bottomLeft.y;
        
        for(IDecoration decoration: decorations) {   
            IFigure layer = getDecorationLayer(decoration);
            if(decoration.isAutoPositioned()) {
                if(x == -1)
                    x = bottomLeft.x - decoration.getSize().width / 2;
                Dimension size = decoration.getSize();
                Point position = new Point(x, y - size.height / 4);
                layer.setConstraint(decoration, new Rectangle(position, size));
                x += size.width + decorationSpace;
            }
            else {
                layer.setConstraint(decoration, decoration.computeNewPosition(rect));
            }
        }
    }
    
    public IFigure getDecorationLayer(IDecoration decoration) {
        int index = decoration.isOnTop() ? DecoratableGraphViewer.FRONT_DECORATION_LAYER_INDEX : DecoratableGraphViewer.BACK_DECORATION_LAYER_INDEX;
        return (IFigure) getParent().getParent().getChildren().get(index);
    }
    
    @Override
    public void setAlpha(int alpha) {
        super.setAlpha(alpha);
        for(IDecoration decoration: decorations) {
            if(decoration instanceof IFigureWithAlpha)
                ((IFigureWithAlpha) decoration).setAlpha(alpha);
        }
    }
        
    @Override
    public void addNotify() {
        super.addNotify();
        for(IDecoration decoration: decorations)
            addDecorationToLayer(decoration);
    }
    
    @Override
    public void removeNotify() {
        for(IDecoration decoration: decorations)
            removeDecorationFromLayer(decoration);
        super.removeNotify();
    }
    
    @Override
    protected void fireFigureMoved() {
        super.fireFigureMoved();
        moveDecorations();
    }
        
}
