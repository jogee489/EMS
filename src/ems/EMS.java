/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ems;

import controllers.ReportController;
import java.util.ArrayList;
import models.Emergency;
import models.Responder;
import org.joda.time.DateTime;

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
        // Setup the database.
        DatabaseSetup.connectToDatabase();
        DatabaseSetup.dropTables();
        DatabaseSetup.createTables();
        for (Responder responder : responderList) {
            responder.save();
        }
        System.out.println("Creating Emergencies");
        ArrayList<Emergency> emergencyList = new ArrayList<>();
        Emergency instance1 = new Emergency("Fire", "Bob Dole", "555-555-5555",
                                            "5133 Truemper way Fort Wayne IN 46835");
        Emergency instance2 = new Emergency("Fire", "Bob Dole", "555-555-5555",
                                            "5133 Truemper way Fort Wayne IN 46835");
        Emergency instance3 = new Emergency("Crime", "Bob Dole", "555-555-5555",
                                            "5133 Truemper way Fort Wayne IN 46835");
        Emergency instance4 = new Emergency("Fire", "Bob Dole", "555-555-5555",
                                            "5133 Truemper way Fort Wayne IN 46835");
        Emergency instance5 = new Emergency("Medical", "Bob Dole", "555-555-5555",
                                            "5133 Truemper way Fort Wayne IN 46835");
        Emergency instance6 = new Emergency(6, "Medical", "Bob Dole", "555-555-5555",
                                            "5133 Truemper way Fort Wayne IN 46835", 1,
                                            Emergency.dtf.parseDateTime("04/02/2011"),
                                            Emergency.dtf.parseDateTime("04/03/2011"),
                                            4);
        Emergency instance7 = new Emergency("Medical", "Bob Dole", "555-555-5555",
                                            "5133 Truemper way Fort Wayne IN 46835");
        instance1.assignResponder(responder1);
        instance2.assignResponder(responder1);
        instance3.assignResponder(responder2);
        instance4.assignResponder(responder1);
        instance5.assignResponder(responder3);
        instance7.assignResponder(responder3);
        System.out.println("Adding Emergencies...");
        emergencyList.add(instance1);
        emergencyList.add(instance2);
        emergencyList.add(instance3);
        emergencyList.add(instance4);
        emergencyList.add(instance5);
        emergencyList.add(instance6);
        emergencyList.add(instance7);
        for (Emergency emergency : emergencyList) {
            //System.out.println(emergency);
            emergency.save();
        }
//        emergencyList = DatabaseSetup.findAllEmergencies();
//        for (Emergency instance : emergencyList) {
//            System.out.println(instance);
//        }
        System.out.println("Generating report...");
        ReportController.reportByEmergencyDateRange(DateTime.now().minusDays(1), DateTime.now().plusDays(1));
        
        
        try { 
            DatabaseSetup.connection.close();
        } catch (Exception e) {
            System.out.println("Unable to close connection");
        }
    }
    
}
