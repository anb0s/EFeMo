package cz.jpikl.yafmt.ui.util;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Display;

public class DrawConstantans {

    public static final Font DEFAULT_FONT = getDefaultFont();
    public static final Font BOLD_FONT = getModifiedFont(DEFAULT_FONT, SWT.DEFAULT, SWT.BOLD);
    public static final Font ITALIC_FONT = getModifiedFont(DEFAULT_FONT, SWT.DEFAULT, SWT.ITALIC);
    public static final Font TINY_FONT = getModifiedFont(DEFAULT_FONT, 7, SWT.DEFAULT);

    public static final Color FEATURE_GRADIENT_COLOR = getColor(175, 201, 235);
    public static final Color ERROR_GRADIENT_COLOR = getColor(255, 192, 192);

    public static final Color FEATURE_COLOR = getColor(0, 0, 127);
    public static final Color FEATURE_HL_COLOR = getColor(128, 128, 255);
    public static final Color CONSTRAINT_COLOR = getColor(204, 49, 1);
    public static final Color CONSTRAINT_HL_COLOR = getColor(255, 158, 128);
    public static final Color GROUP_COLOR = getColor(30, 92, 52);
    public static final Color GROUP_HL_COLOR = getColor(102, 204, 138);

    public static final float[] LINE_DASH = { 2, 2 };

    public static void dispose() {
        BOLD_FONT.dispose();
        ITALIC_FONT.dispose();
        CONSTRAINT_COLOR.dispose();
        FEATURE_GRADIENT_COLOR.dispose();
        ERROR_GRADIENT_COLOR.dispose();
        ERROR_GRADIENT_COLOR.dispose();
        CONSTRAINT_COLOR.dispose();
        CONSTRAINT_HL_COLOR.dispose();
        GROUP_COLOR.dispose();
        GROUP_HL_COLOR.dispose();
    }

    public static Font getDefaultFont() {
        return Display.getDefault().getSystemFont();
    }

    public static Font getModifiedFont(Font originalFont, int height, int style) {
        FontData[] fontData = originalFont.getFontData();
        for(FontData data: fontData) {
            if(height != SWT.DEFAULT)
                data.setHeight(height);
            if(style != SWT.DEFAULT)
                data.setStyle(style);
        }
        return new Font(Display.getDefault(), fontData);
    }

    public static Color getColor(int r, int g, int b) {
        return new Color(Display.getDefault(), r, g, b);
    }

    public static Color getModifiedColor(Color color, float change) {
        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();

        r += (int) (255 * change);
        g += (int) (255 * change);
        b += (int) (255 * change);

        r = (r > 255) ? 255 : ((r < 0) ? 0 : r);
        g = (g > 255) ? 255 : ((g < 0) ? 0 : r);
        b = (b > 255) ? 255 : ((b < 0) ? 0 : r);

        return getColor(r, g, b);
    }

}
