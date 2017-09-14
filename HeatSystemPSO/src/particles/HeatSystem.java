/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package particles;

import heatsystempso.HeatConsumer;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Admin
 */
public class HeatSystem {

    private double x;
    private double y;
    private double fixedCost = 50;
    private double pBestx;
    private double pBesty;
    private double vx;
    private double vy;
    private  double cost;
    private double fitnessVal;

    public HeatSystem() {
        
    }

    public double getVx() {
        return vx;
    }

    public void setVx(double vx) {
        this.vx = vx;
    }

    public double getVy() {
        return vy;
    }

    public void setVy(double vy) {
        this.vy = vy;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getFixedCost() {
        return fixedCost;
    }

    public void setFixedCost(double fixedCost) {
        this.fixedCost = fixedCost;
    }

    public double getpBestx() {
        return pBestx;
    }

    public void setpBestx(double pBestx) {
        this.pBestx = pBestx;
    }

    public double getpBesty() {
        return pBesty;
    }

    public void setpBesty(double pBesty) {
        this.pBesty = pBesty;
    }


    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getFitnessVal() {
        return fitnessVal;
    }

    public void setFitnessVal(double fitnessVal) {
        this.fitnessVal = fitnessVal;
    }


    

}
