/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heatsystempso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import particles.HeatSystem;

/**
 *
 * @author Admin
 */
public class HeatConsumer {

    private HeatSystem heatSystem;
    private int xPos;
    private int yPos;
    private ArrayList<Double> distance;
    private HashMap disMap1;
    private HashMap disMap2;

    public HashMap getDisMap2() {
        return disMap2;
    }

    public void setDisMap2(HashMap disMap2) {
        this.disMap2 = disMap2;
    }

    public HeatConsumer() {
        this.distance = new ArrayList<>();
        disMap1 = new HashMap();
        disMap2 = new HashMap();
    }

    public HeatSystem getHeatSystem() {
        return heatSystem;
    }

    public void setHeatSystem(HeatSystem heatSystem) {
        this.heatSystem = heatSystem;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public ArrayList<Double> getDistance() {
        return distance;
    }

    public void setDistance(ArrayList<Double> distance) {
        this.distance = distance;
    }

    public HashMap getDisMap1() {
        return disMap1;
    }

    public void setDisMap1(HashMap disMap1) {
        this.disMap1 = disMap1;
    }


   
}
