package com.osframework.appclient.ui.controls;

import com.osframework.framework.logging.Debug;

import javax.swing.*;
import java.awt.*;

public class UIJFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JFrame thisFrame = this;

    public UIJFrame() {
        try {

        } catch (Exception ex) {
            Debug.LogException(this, ex);
        }
    }

    public void centerDisplay() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) (dim.getWidth() - this.getWidth()) / 2;
        int y = (int) (dim.getHeight() - this.getHeight()) / 2;
        this.setLocation(x, y);
    }
}
