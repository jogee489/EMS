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
        
        Window window = new Window();
        
        try { 
            DatabaseSetup.connection.close();
        } catch (Exception e) {
            System.out.println("Unable to close connection");
        }
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
}
