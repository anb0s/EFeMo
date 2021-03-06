package cz.zcu.yafmt.ui.views.fm.figures;

import org.eclipse.draw2d.ColorConstants;

import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.ui.util.DrawUtil;

public class FeatureFigure extends DecoratableNodeFigure {

    public FeatureFigure(Feature feature) {
        setBackgroundColor(ColorConstants.white);
        setForegroundColor(DrawUtil.FEATURE_COLOR);
        setHightlightColor(DrawUtil.FEATURE_LIGHTER_COLOR);
        setText(feature.getName());
        setToolTipText(createToolTipText(feature));
    }

    private String createToolTipText(Feature feature) {
        String description = feature.getDescription();
        String comment = feature.getComment();
        return "[" + feature.getId() + "]\n" + feature.getName() + "\n" + (((description != null) && !description.isEmpty()) ? description : "") + "\n" + (((comment != null) && !comment.isEmpty()) ? comment : "");
    }

}
