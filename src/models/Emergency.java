/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import ems.DatabaseSetup;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
/**
 *
 * @author dorkoj
 */
public class Emergency {
    public final static DateTimeFormatter dtf = DateTimeFormat.forPattern("MM/dd/yyyy");
    public static int index = 0;
    private int id;
    private String type;
    private String callerName;
    private String callerPhone;
    private String location;
    private boolean resolved;
    DateTime dateCreated;
    DateTime dateResolved;
    Responder responder;
    
    // Blank Constructor
    public Emergency(){}
    
    /**
     * Constructor for the Emergency object.
     * @param type Type of the emergency
     * @param callerName Name of the person who called in the emergency.
     * @param callerPhone Phone number of the caller.
     * @param location Location of the emergency.
     */
    public Emergency(String type, String callerName, String callerPhone, String location) {
        this.type = type;
        this.callerName = callerName;
        this.callerPhone = callerPhone;
        this.location = location;       
        this.resolved = false;
        dateCreated = DateTime.now();
    }
    
    /**
     * Full constructor for the Emergency object.
     * @param id Identification number.
     * @param type Type of the emergency.
     * @param callerName Name of the person who called in the emergency.
     * @param callerPhone Phone number of the caller.
     * @param location Location of the emergency.
     * @param resolved whether or not the emergency has been resolved.
     * @param dateCreated the date the emergency was created.
     * @param dateResolved the date the emergency was resolved.
     * @param responderId the id number for the responder.
     */
    public Emergency(int id, String type, String callerName, String callerPhone, String location,
                     int resolved, DateTime dateCreated, DateTime dateResolved, int responderId) {
        this.id = id;
        this.type = type;
        this.callerName = callerName;
        this.callerPhone = callerPhone;
        this.location = location;
        this.resolved = (resolved == 1);
        this.dateCreated = dateCreated;
        this.dateResolved = dateResolved;
        this.responder = DatabaseSetup.findResponderById(responderId);
    }
    
    public static void initializeIndex(){
        DatabaseSetup.getHighestId("Emergency");
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
        dateResolved = DateTime.now();
        save();
    }
    
    public DateTime getDateCreated() {
        return dateCreated;
    }
    
    public DateTime getDateResolved() {
        return dateResolved;
    }
    
    public void assignResponder(Responder responder) {
        this.responder = responder;
    }
    
    @Override
    public String toString() {
        return ("#" + id + "\t" + type + "\t" + callerName + " ("
                + callerPhone + ")\t" + location);
    }

    public String insertString() {
        String responderText = "0";
        if(responder != null)
            responderText = "" + responder.getId();
        return id + ", '" + type + "', '" + callerName + "', '" + callerPhone + "', '" + location + "', " +
               (resolved? 1 : 0) + ", '" + dateCreated.toString() + "', '" +
               ((dateResolved != null)? dateResolved.toString() : "") + "', " + responderText;
    }
    
    public String reportString() {
        String dateCreatedString = dtf.print(dateCreated);
        String dateResolvedString;
        if (dateResolved != null){
            dateResolvedString = dtf.print(dateResolved);
        } else {
            dateResolvedString = "N/A";
        }
        return id + ", " + type + ", " + callerName + ", " + callerPhone + ", " + location + ", " +
               (resolved? "yes" : "no") + ", " + dateCreatedString + ", " + dateResolvedString +
               ", " + responder == null? "" : responder.getName();
    }
    
    public void save() {
        if(id == 0) id = ++index;
        DatabaseSetup.saveEmergency(this);
        System.out.println("Emergency " + id + " created");
    }
   
}
