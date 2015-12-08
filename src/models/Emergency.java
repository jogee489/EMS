/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import ems.DatabaseSetup;
import org.joda.time.DateTime;
/**
 *
 * @author dorkoj
 */
public class Emergency {
    
    private int id;
    private String type;
    private String callerName;
    private String callerPhone;
    private String location;
    private boolean resolved;
    DateTime dateCreated;
    DateTime dateResolved;
    
    // Blank Constructor
    public Emergency(){}
    
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
    }
    
    /**
     * Constructor for the Emergency method.
     * @param id Identification number.
     * @param type Type of the emergency.
     * @param callerName Name of the person who called in the emergency.
     * @param callerPhone Phone number of the caller.
     * @param location Location of the emergency.
     * @param resolved whether or not the emergency has been resolved.
     * @param dateCreated the date the emergency was created.
     * @param dateResolved the date the emergency was resolved.
     */
    public Emergency(int id, String type, String callerName, String callerPhone, String location,
                     int resolved, DateTime dateCreated, DateTime dateResolved) {
        this.id = id;
        this.type = type;
        this.callerName = callerName;
        this.callerPhone = callerPhone;
        this.location = location;
        this.resolved = (resolved == 1);
        this.dateCreated = dateCreated;
        this.dateResolved = dateResolved;
    }
    
    public int getId() {
        return id;
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
    
    public void resolved() {
        resolved = true;
        // save object to database
    }
    
    @Override
    public String toString() {
        return ("#" + id + "\t" + type + "\t" + callerName + " ("
                + callerPhone + ")\t" + location);
    }

    public String insertString() {
        return id + ", '" + type + "', '" + callerName + "', '" + callerPhone + "', '" + location + "', " +
               (resolved? 1 : 0) + ", '" + dateCreated.toString() + "', '" +
               ((dateResolved != null)? dateResolved.toString() : "") + "'";
    }
    
    public void save() {
        DatabaseSetup.saveEmergency(this);
    }
   
}
