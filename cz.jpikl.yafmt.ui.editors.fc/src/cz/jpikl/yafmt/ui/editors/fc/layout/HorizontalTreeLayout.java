package cz.jpikl.yafmt.ui.editors.fc.layout;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;

import cz.jpikl.yafmt.ui.figures.MiddleSideAnchor;

public class HorizontalTreeLayout extends TreeLayout {

    private static final int HORIZONTAL_SPACE = 50;
    private static final int VERTICAL_SPACE = 10;

    public HorizontalTreeLayout(Helper helper) {
        super(helper);
    }

    @Override
    public String getName() {
        return "Horizontal Tree";
    }

    @Override
    protected void doLayout(IFigure root) {
        Map<IFigure, Integer> subTreeHeight = new HashMap<IFigure, Integer>();
        calculateSubTreeHeight(subTreeHeight, root);
        layoutTree(subTreeHeight, root, VERTICAL_SPACE, VERTICAL_SPACE);
        setupConnectionAnchors();
    }

    private int calculateSubTreeHeight(Map<IFigure, Integer> subTreeHeight, IFigure figure) {
        int height = 0;
        for(IFigure child: helper.getTreeChildrenFigures(figure))
            height += calculateSubTreeHeight(subTreeHeight, child);
        if(height == 0)
            height = computeFigurePreferedSize(figure).height + VERTICAL_SPACE;
        subTreeHeight.put(figure, height);
        return height;
    }

    private void layoutTree(Map<IFigure, Integer> subTreeHeight, IFigure figure, int xOffset, int yOffset) {
        Dimension size = computeFigurePreferedSize(figure);
        int y = yOffset + (subTreeHeight.get(figure) - size.height) / 2;
        figure.setBounds(new Rectangle(new Point(xOffset, y), size));

        xOffset += size.width + HORIZONTAL_SPACE;
        for(IFigure child: helper.getTreeChildrenFigures(figure)) {
            layoutTree(subTreeHeight, child, xOffset, yOffset);
            yOffset += subTreeHeight.get(child);
        }
    }

    private void setupConnectionAnchors() {
        for(Connection connection: helper.getConnectionFigures()) {
            ((MiddleSideAnchor) connection.getSourceAnchor()).setStyle(SWT.LEFT);
            ((MiddleSideAnchor) connection.getTargetAnchor()).setStyle(SWT.RIGHT);
        }
    }

}
