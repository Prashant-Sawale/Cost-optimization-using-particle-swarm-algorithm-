/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package particles;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class HeatSystemCatalog {

    private ArrayList<HeatSystem> systemList;

    public HeatSystemCatalog (){
    systemList= new ArrayList<>();
    }


    public ArrayList<HeatSystem> getSystemList() {
        return systemList;
    }

    public void setSystemList(ArrayList<HeatSystem> systemList) {
        this.systemList = systemList;
    }

    

   

}
