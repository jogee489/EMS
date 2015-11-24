/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;
import org.joda.time.DateTime;
/**
 *
 * @author dorkoj
 */
public class Emergency {
    
    DateTime dateCreated;
    DateTime dateResolved;
    private final int id;
    private String type;
    private String callerName;
    private String callerPhone;
    private String location;
    private boolean resolved;
    
    /**
     * Constructor for the Emergency method.
     * @param id Identification number
     * @param type Type of the emergency
     * @param callerName Name of the person who called in the emergency.
     * @param callerPhone Phone number of the caller.
     * @param location Location of the emergency.
     */
    public Emergency(int id, String type, String callerName, String callerPhone, String location) {
        this.id = id;
        this.type = type;
        this.callerName = callerName;
        this.callerPhone = callerPhone;
        this.location = location;
        
        this.resolved = false;
        dateCreated = DateTime.now();
        
        System.out.println("Emergency #" + id + " created");
        System.out.println(this);
    }
    
    public String getType() {
        return type;
    }
    
    public String getCallerName() {
        return callerName;
    }
    
    public String getCallerPhone() {
        return callerPhone;
    }
    
    public String getLocation() {
        return location;
    }
    
    public Boolean isResolved() {
        return resolved;
    }
    
    @Override
    public String toString() {
        return ("#" + id + ", Type: " + type + ", Reported: " + callerName + " "
                + callerPhone + ", Location: " + location);
    }
   
}
