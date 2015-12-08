/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ems;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Emergency;
import models.Responder;

/**
 *
 * @author dorkoj
 */
public class EMS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create the initial list of responders.
        ArrayList<Responder> responderList = new ArrayList<>();
        responderList.add(new Responder(1, "Fire", "FW Fire Department", "453 Main St. Fort Wayne IN 46818"));
        responderList.add(new Responder(2, "Crime", "FW Police Department", "420 Main St. Fort Wayne IN 46818"));
        responderList.add(new Responder(3, "Medical", "Dupont Hostpital", "690 Main St. Fort Wayne IN 46818"));
        responderList.add(new Responder(4, "Medical", "Parkview Hostpital", "692 Main St. Fort Wayne IN 46818"));
        // Setup the database.
        DatabaseSetup.connectToDatabase();
        DatabaseSetup.createTables();
        /*for (Responder responder : responderList) {
            DatabaseSetup.initializeResponders(responder);
        }*/
        Emergency emergency = new Emergency(1, "Fire", "Bob Dole", "555-555-5555",
                                            "5133 Truemper way Fort Wayne IN 46835");
        DatabaseSetup.saveEmergency(emergency);
        emergency = new Emergency(2, "Fire", "Bob Dole", "555-555-5555",
                                            "5133 Truemper way Fort Wayne IN 46835");
        DatabaseSetup.saveEmergency(emergency);
        emergency = new Emergency(3, "Crime", "Bob Dole", "555-555-5555",
                                            "5133 Truemper way Fort Wayne IN 46835");
        DatabaseSetup.saveEmergency(emergency);
        emergency = new Emergency(4, "Fire", "Bob Dole", "555-555-5555",
                                            "5133 Truemper way Fort Wayne IN 46835");
        DatabaseSetup.saveEmergency(emergency);
        emergency = new Emergency(5, "Medical", "Bob Dole", "555-555-5555",
                                            "5133 Truemper way Fort Wayne IN 46835");
        DatabaseSetup.saveEmergency(emergency);
        
        //Responder responder = DatabaseSetup.findResponderById(1);
        //Emergency em = DatabaseSetup.findEmergencyById(1);
        //System.out.println(responder);
        //System.out.println(em);
        responderList = DatabaseSetup.findAllResponderByType("Medical");
        for (Responder instance : responderList) {
            System.out.println(instance);
        }
        ArrayList<Emergency> emergencyList = DatabaseSetup.findAllEmergencyByType("Fire");
        for (Emergency instance : emergencyList) {
            System.out.println(instance);
        }
        
        try { 
            DatabaseSetup.connection.close();
        } catch (Exception e) {
            System.out.println("Unable to close connection");
        }
    }
    
}
