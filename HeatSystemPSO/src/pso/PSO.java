/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pso;

import animation.Draw;
import heatsystempso.Distance;
import heatsystempso.HeatConsumer;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import particles.HeatSystem;
import particles.HeatSystemCatalog;
import javax.swing.JFrame;

/**
 *
 * @author Admin
 */
public class PSO {

    private HeatSystemCatalog heatSystemsCatalog;
    private HeatConsumer consumer;
    double gBestx;
    double gBesty;
    Random r = new Random();
    double c1 = 1;
    double c2 = 1;
    double gBestDist;
    double rand1;
    double rand2;
    double er = 0.1;
    private Draw draw;

    public void getAnimation() {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(draw);
        frame.setBackground(Color.WHITE);
        //d.drawing();
    }

    public PSO() {
        heatSystemsCatalog = new HeatSystemCatalog();
        draw = new Draw();
        getAnimation();
    }

    public HeatSystemCatalog getHeatSystemsCatalog() {
        return heatSystemsCatalog;
    }

    public void setHeatSystemsCatalog(HeatSystemCatalog heatSystemsCatalog) {
        this.heatSystemsCatalog = heatSystemsCatalog;
    }

    /*
    Initilise 25 Consumers with fixed position in space
     */
    public void initHeatConsummers() {
        consumer = new HeatConsumer();
        consumer.setxPos(400);
        consumer.setyPos(300);
    }

    /*
        method to generate random numbers
     */
    private static int getRandomNumber(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    /*
    Initilise 30 partcles in the swarm
     */
    public void initHeatSystems() {

        for (int i = 0; i < 10; i++) {
            HeatSystem heatSystem = new HeatSystem();
            double x = getRandomNumber(0, 600);
            double y = getRandomNumber(0, 600);
            double vx = getRandomNumber(0, 1);
            double vy = getRandomNumber(1, 2);
            heatSystem.setX(x);
            heatSystem.setY(y);
            heatSystem.setVx(vx);
            heatSystem.setVy(vy);
            heatSystem.setpBestx(x);
            heatSystem.setpBesty(y);
            heatSystemsCatalog.getSystemList().add(heatSystem);
        }

    }

    public void intialSoln() {
        initHeatSystems();
        initHeatConsummers();
        double counter = 9999;
        double cx = consumer.getxPos();
        double cy = consumer.getyPos();

        /*
        Initial solution 
         */
        for (HeatSystem s : heatSystemsCatalog.getSystemList()) {
            double px = s.getX();
            double py = s.getY();
            double distance = calculateDistance(cx, cy, px, py);
            s.setFitnessVal(distance);
            consumer.getDisMap1().put(s, distance);
            consumer.getDistance().add(distance);
        }

        double gbestMin = consumer.getDistance().get(0);
        for (double d : consumer.getDistance()) {
            if (gbestMin > d) {
                gbestMin = d;
            }
        }

        //update gbest
        HeatSystem optimalHS = findHS(gbestMin);
        gBestx = optimalHS.getX();
        gBesty = optimalHS.getY();

        draw.drawing(heatSystemsCatalog.getSystemList());//pass Hs list
        try {
            Thread.sleep(100);
            /*
            Improved PSO
             */
        } catch (InterruptedException ex) {
            Logger.getLogger(PSO.class.getName()).log(Level.SEVERE, null, ex);
        }
        //calculate inertia
        double inertia;
        int i = 0;
        //i < 40
        while (i < 100 || counter>er) {
                if(counter>er){
                    System.out.println("counter>er");
                }
            //update pbest
            for (HeatSystem hs : heatSystemsCatalog.getSystemList()) {
                double fitness = calculateDistance(cx, cy, hs.getX(), hs.getY());
                if (fitness < hs.getFitnessVal()) {
                    hs.setFitnessVal(fitness);
                    hs.setpBestx(hs.getX());
                    hs.setpBesty(hs.getY());
                }
            }

            inertia = 1 - (((double) i) / 500);
            System.out.println("************************");
            consumer.getDistance().removeAll(consumer.getDistance());

            for (HeatSystem s : heatSystemsCatalog.getSystemList()) {
                rand1 = r.nextDouble();
                rand2 = r.nextDouble();
                // System.out.println("before x: " + s.getY() + "  y: " + s.getY());
                double v1 = (inertia * s.getVx()) + (rand1 * c1) * (s.getpBestx() - s.getX()) + (rand2 * c2) * (gBestx - s.getX());

                double v2 = (inertia * s.getVy()) + (rand1 * c1) * (s.getpBesty() - s.getY()) + (rand2 * c2) * (gBesty - s.getY());

                //update velocity
                s.setVx(v1);
                s.setVy(v2);

                //update location
                double posx = s.getX() + v1;
                double posy = s.getY() + v2;
                s.setX(posx);
                s.setY(posy);

            }

            draw.drawing(heatSystemsCatalog.getSystemList());//pass Hs list
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(PSO.class.getName()).log(Level.SEVERE, null, ex);
            }
            //update gbest
            double f1 = heatSystemsCatalog.getSystemList().get(0).getFitnessVal();
            for (HeatSystem system : heatSystemsCatalog.getSystemList()) {
                if (f1 > system.getFitnessVal()) {
                    f1 = system.getFitnessVal();
                }
                else{
              //      System.out.println("less found");
                }
            }
            HeatSystem h = findHS(f1);
            gBestx = h.getX();
            gBesty = h.getY();

            counter = calculateDistance(cx, cy, gBestx, gBesty);
            // System.out.println("x: " + gBestx + " y: " + gBesty+"  Dist"+gBestDist);
            //System.out.println(" counter " + counter);
            i++;
        }

    }

    private void calculateVarCost(HeatConsumer c, double d, double min) {

        HeatSystem system = findHS(d);
        double x = 1;
        double y = 1;
        double z = d - min;
        double varcost = ((x + (x * z)) + (y + (y * z)));
        if (system == null) {
            return;
        }
        double cost = system.getFixedCost() + varcost;

        system.setCost(cost);
    }

    /*
    calculates the distence between heat system and heat consumer
     */
    private double calculateDistance(double cx, double cy, double px, double py) {
        double distence = Math.sqrt(Math.pow((px - cx), 2) + Math.pow((py - cy), 2));
        return distence;
    }

    private HeatSystem findHS(double min) {

        for (HeatSystem hs : heatSystemsCatalog.getSystemList()) {
            if (hs.getFitnessVal() == min) {
                return hs;
            }
        }
        return null;
    }

}
