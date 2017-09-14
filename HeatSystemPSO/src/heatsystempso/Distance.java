/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heatsystempso;

import particles.HeatSystem;

/**
 *
 * @author Admin
 */
public class Distance {
 private double distance;
 private HeatSystem heatSystem;
 private HeatConsumer consumer;

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public HeatSystem getHeatSystem() {
        return heatSystem;
    }

    public void setHeatSystem(HeatSystem heatSystem) {
        this.heatSystem = heatSystem;
    }

    public HeatConsumer getConsumer() {
        return consumer;
    }

    public void setConsumer(HeatConsumer consumer) {
        this.consumer = consumer;
    }
 
}
