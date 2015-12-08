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
    private int id;
    private String type;
    private String name;
    private String location;
    private ArrayList<Emergency> emergencyList;
    
    //Blank Constructor
    public Responder(){}
    
    /**
     * Full constructor for a new Responder object
     * 
     * @param id idnumber of the responder.
     * @param name name of the responder.
     * @param location the address of the responder.
     * @param type the type of emergencies the responder can resolve.
     */
    public Responder(int id, String type, String name, String location) {
        this.id = id;
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
    /**
     * Generate a string to be used to insert the responder into the database.
     * @return a string used by sql to create the responder.
     */
    public String insertString() {
        String data = id + ", '" +
                      type + "', '" +
                      name + "', '" +
                      location + "'";
                
        return data;
    }
    @Override
    public String toString() {
        return "#" + id + "\t" + type + "\t" + name + "\t" + location;
    }
}
