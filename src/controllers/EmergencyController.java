/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.ArrayList;
import java.util.List;
import models.Emergency;

/**
 *
 * @author dorkoj
 */
public class EmergencyController {
    private Emergency emergencyInstance;
    private ArrayList<Emergency> emergencyList = new ArrayList<>();
    private int idCounter = 0;
    
    
    public Emergency createEmergency(String type, String callerName, String callerPhone, String location) {
        emergencyInstance = new Emergency(type, callerName, callerPhone, location);
        emergencyList.add(emergencyInstance);
        return emergencyInstance;
    }
    
    public List<Emergency> getEmergencies() {
        return emergencyList;
    }
    
    /**
     * Retrieve a list of all the emergencies that haven't been resolved.
     * @return List of all the active emergencies.
     */
    public List<Emergency> getActiveEmergencies() {
        ArrayList<Emergency> activeEmergencies = new ArrayList<>();
        for (Emergency emergency : emergencyList) {
            if (!emergency.isResolved()){
                activeEmergencies.add(emergency);
            }
        }
        return activeEmergencies;
    }
}
