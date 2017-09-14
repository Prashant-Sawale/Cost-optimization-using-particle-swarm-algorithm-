/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heatsystempso;

import animation.Draw;
import javax.swing.JFrame;
import pso.PSO;
import particles.HeatSystemCatalog;

/**
 *
 * @author Admin
 */
public class HeatSystemPSO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("in main");
        PSO pso = new PSO();
//        pso.initHeatConsummers();
//        pso.initHeatSystems();
        pso.intialSoln();
        //pso.getBests();
        System.out.println("main is done");

//        JFrame frame = new JFrame();
//
//        frame.setVisible(true);
//        frame.setSize(400, 200);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        Draw d = new Draw();
//        frame.add(d);
//
//        d.drawing();

    }

}
