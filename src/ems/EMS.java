/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ems;

import java.util.ArrayList;
import models.Emergency;
import models.Responder;
import views.Window;

/**
 *
 * @author dorkoj
 */
public class EMS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // initialize indexes
        Emergency.initializeIndex();
        Responder.initializeIndex();
        System.out.println("Emergency: " + Emergency.index + "\tResponder: " + Responder.index);
        
        // Setup the database.
        DatabaseSetup.connectToDatabase();
        DatabaseSetup.dropTables();
        DatabaseSetup.createTables();
        initializeResponders();
        initializeEmergencies();
        
        Window window = new Window();
        
    }
    public static void initializeResponders() {
        // Create the initial list of responders.
        ArrayList<Responder> responderList = new ArrayList<>();
        Responder responder1 = new Responder("Fire", "FW Fire Department", "453 Main St. Fort Wayne IN 46818");
        Responder responder2 = new Responder("Crime", "FW Police Department", "420 Main St. Fort Wayne IN 46818");
        Responder responder3 = new Responder("Medical", "Dupont Hospital", "690 Main St. Fort Wayne IN 46818");
        Responder responder4 = new Responder("Medical", "Parkview Hospital", "692 Main St. Fort Wayne IN 46818");
        responderList.add(responder1);
        responderList.add(responder2);
        responderList.add(responder3);
        responderList.add(responder4);
        
        for (Responder responder : responderList) {
            responder.save();
        }
    }
    
    public static void initializeEmergencies() {
        ArrayList<Emergency> emergencyList = new ArrayList<>();
        emergencyList.add(new Emergency("Fire", "Bob Dole", "555-555-5555",
                                            "5133 Truemper way Fort Wayne IN 46835"));
        emergencyList.add(new Emergency("Crime", "Bob Dole", "555-555-5555",
                                            "5133 Truemper way Fort Wayne IN 46835"));
        emergencyList.add(new Emergency("Fire", "Bob Dole", "555-555-5555",
                                            "5133 Truemper way Fort Wayne IN 46835"));
        emergencyList.add(new Emergency(6, "Medical", "Bob Dole", "555-555-5555",
                                            "5133 Truemper way Fort Wayne IN 46835", 1,
                                            Emergency.dtf.parseDateTime("04/02/2011"),
                                            Emergency.dtf.parseDateTime("04/03/2011"),
                                            1));
        for (Emergency emergency : emergencyList){
            emergency.save();
        }
    }
}
