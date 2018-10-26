package elab.util;

import java.awt.*;

public class ProjectUtil {

    /**
     * 获取屏幕的宽和高
     */

    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension screenSize = kit.getScreenSize();
    int screenWidth = screenSize.width;
    int screenHeight = screenSize.height;

    public int getScreenWidth() {
        return  screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }
}
