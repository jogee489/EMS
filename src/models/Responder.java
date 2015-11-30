/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dorkoj
 */
public class Responder {
    private String name;
    private String location;
    private String type;
    private ArrayList<Emergency> emergencyList;
    
    public Responder(String name, String location, String type) {
        this.name = name;
        this.location = location;
        this.type = type;
    }
    
    public String getName() {
        return name;
    }
    
    public String getLocation() {
        return location;
    }
    
    public String getType() {
        return type;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public void addEmergency(Emergency emergency) {
        emergencyList.add(emergency);
    }
    
    public List<Emergency> getEmergencies() {
        return emergencyList;
    }
    
    public List<Emergency> getActiveEmergencies() {
        ArrayList<Emergency> activeEmergencies = new ArrayList<>();
        for(Emergency instance : emergencyList) {
            if (!instance.isResolved()) {
                activeEmergencies.add(instance);
            }
        }
        return activeEmergencies;
    }
}
