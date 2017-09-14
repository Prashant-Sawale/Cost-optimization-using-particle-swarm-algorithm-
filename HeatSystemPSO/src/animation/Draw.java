/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animation;

import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;
import particles.HeatSystem;

/**
 *
 * @author Admin
 */
public class Draw extends JPanel {

    private ArrayList<HeatSystem> hsList;

    public void drawing(ArrayList<HeatSystem> list) {
        hsList = list;
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);

        g.fillOval(400, 300, 10, 10);
        g.setColor(Color.RED);
        for (HeatSystem h : hsList) {
            g.fillOval((int) h.getX(), (int) h.getY(), 5, 5);
        }

    }
}
