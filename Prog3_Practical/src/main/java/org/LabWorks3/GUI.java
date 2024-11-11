package org.LabWorks3;

import javax.swing.*;
import java.awt.*;

public class GUI {

    private static final int FRAME_WIDTH = 800;
    private static final int FRAME_HEIGHT = 800;
    private JFrame frame;
    private JPanel panel;

    public GUI() {
        frame = new JFrame("Calculating...");
        panel = new JPanel();
        frame.add(panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        /*panel.paintComponents();*/
        frame.setVisible(true);
    }

    public void drawPoint(float x, float y, Color color) {
        /*Everything is a float, since, for example, when we will be guessing we will be betweeen (x,y) i.e. -1 and 1*/

        Graphics2D gfx = (Graphics2D) panel.getGraphics();
        gfx.setColor(color);

        /*gfx.draw...*/

        /*Would draw anything between 1 and -1*/
        int translatedX = (int) ((FRAME_WIDTH/2) * x + (FRAME_WIDTH/2));
        int translatedY = (int) ((FRAME_HEIGHT/2) * y + (FRAME_HEIGHT/2));
        gfx.fillOval(translatedX, translatedY, 10, 10);
    }

    public void close() {
        frame.dispose();
    }

}
