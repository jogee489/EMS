/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ems;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import models.Emergency;
import models.Responder;
import org.joda.time.DateTime;

/**
 * All the setup of the database is here. Create the desired tables and rows.
 * @author dorkoj
 */
public class DatabaseSetup {
    public static Connection connection;
    /**
     * Connect to the sqlite database
     */
    public static void connectToDatabase() {
        String url = "jdbc:sqlite:ems";

        System.out.println("Connecting database...");
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);
        } catch (Exception e) {
            System.out.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("Connected to databse successfully");
    }
    
    /**
     * Drop the database tables
     */
    public static void dropTables() {
        try (Statement sqlStatement = connection.createStatement()) {
            String drop = "DROP TABLE IF EXISTS EMERGENCY";
            sqlStatement.execute(drop);
            System.out.println("Dropped table: Emergency" );
            drop = "DROP TABLE IF EXISTS RESPONDER";
            sqlStatement.execute(drop);
            System.out.println("Dropped table: Responder" ); 
        } catch (Exception e) {
            System.out.println("Unable to drop tables");
        }
    }
    
    /**
     * Create database tables
     */
    public static void createTables () {
        // Try to create the emergency table.
        try {
            Statement sqlStatement = connection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS EMERGENCY " +
                         "(ID INT PRIMARY KEY     NOT NULL, " +
                         " TYPE           INT     NOT NULL, " +
                         " CALLER_NAME    TEXT, " +
                         " CALLER_PHONE   TEXT, " +
                         " LOCATION       TEXT, " +
                         " RESOLVED       INT    NOT NULL, " +
                         " DATE_CREATED   TEXT, " +
                         " DATE_RESOLVED  TEXT, " +
                         " RESPONDER_ID   INT, " +
                         " FOREIGN KEY (RESPONDER_ID) REFERENCES RESPONDER)";
            sqlStatement.executeUpdate(sql);
            sqlStatement.close();
        } catch (Exception e){
            System.out.println("Unable to create EMERGENCY table");
            System.out.println(e.toString());
        }
        // Try to create RESPONDER database table.
        try { //TODO: add one-to-many relation to emergency.
            Statement sqlStatement = connection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS RESPONDER " +
                         "(ID INT PRIMARY KEY     NOT NULL, " +
                         " TYPE           TEXT    NOT NULL, " + 
                         " NAME           TEXT    NOT NULL, " +
                         " LOCATION       TEXT)";
            sqlStatement.executeUpdate(sql);
            sqlStatement.close();
        } catch (Exception e){
            System.out.println("Unable to create RESPONDER table");
        }
    }
    
    /**
     * Insert default responders into the database
     * @param responder responder to be inserted into the database.
     */
    public static void saveResponder (Responder responder) {
        // Try to insert responders.
        try {
            Statement sqlStatement = connection.createStatement();
            String sql = "INSERT INTO RESPONDER (ID,TYPE,NAME,LOCATION) " +
                  "VALUES (" + responder.insertString() + ");";
            sqlStatement.executeUpdate(sql);
            sqlStatement.close();
        } catch (Exception e) {
            System.out.println("Unable to insert " + responder.getName() + " into table");
        }
    }
    
    /**
     * Insert emergency into the database
     * @param emergency emergency to be inserted into the database.
     */
    public static void saveEmergency (Emergency emergency) {
        try {
            Statement sqlStatement = connection.createStatement();
            String sql = "INSERT INTO EMERGENCY (ID,TYPE,CALLER_NAME,CALLER_PHONE,LOCATION,"
                    + "RESOLVED,DATE_CREATED,DATE_RESOLVED, RESPONDER_ID) " +
                  "VALUES (" + emergency.insertString() + ");";
            sqlStatement.executeUpdate(sql);
            sqlStatement.close();
        } catch (Exception e) {
            System.out.println("Unable to insert emergency (" + emergency.getId() + ") into table");
            System.out.println(e);
        }
    }
    
    /**
     * Find a responder given the id.
     * @param id the id of the responder to find
     * @return the responder searched for. Null if the id doesn't exist.
     */
    public static Responder findResponderById (int id) {
        try {
            Statement sqlStatement = connection.createStatement();
            String sql = "SELECT * FROM RESPONDER WHERE RESPONDER.ID = " + id;
            ResultSet result = sqlStatement.executeQuery(sql);
            Responder responder = new Responder(result.getInt("id"),
                                                result.getString("type"),
                                                result.getString("name"),
                                                result.getString("location"));
            result.close();
            return responder;
        } catch (Exception e) {
            System.out.println("Unable to find responder with id: " + id);
            System.out.println(e);
            return null;
        }
    }
    
    /**
     * Query the database for responders of a specific type
     * @param type the type of responder to search for.
     * @return an ArrayList of the responders with the type.
     */
    public static ArrayList<Responder> findAllRespondersByType (String type) {
        ArrayList<Responder> responderList = new ArrayList<>();
        try {
            Statement sqlStatement = connection.createStatement();
            String sql = "SELECT * FROM RESPONDER WHERE RESPONDER.TYPE like '" + type + "';";
            ResultSet result = sqlStatement.executeQuery(sql);
            while (result.next()){
                Responder responder = new Responder(result.getInt("id"),
                                                    result.getString("type"),
                                                    result.getString("name"),
                                                    result.getString("location"));
                responderList.add(responder);
            }
            result.close();
            sqlStatement.close();
            return responderList;
        } catch (Exception e) {
            System.out.println("Unable to find any responder with type: " + type);
            System.out.println(e);
            return null;
        }
    }
    
    /**
     * Find an emergency given the id
     * @param id the id of the emergency to find
     * @return the emergency searched for. Null if the id doesn't exist.
     */
    public static Emergency findEmergencyById (int id) {
        try {
            Statement sqlStatement = connection.createStatement();
            String sql = "SELECT * FROM EMERGENCY WHERE EMERGENCY.ID = " + id;
            ResultSet result = sqlStatement.executeQuery(sql);
            if (result == null)
                System.out.println("No results found!");
            String dateResolvedString = result.getString("date_resolved");
            DateTime dateResolved;
            if (dateResolvedString.isEmpty()){
                dateResolved = null;
            } else {
                dateResolved = new DateTime(dateResolvedString);
            }
                    
            Emergency emergency = new Emergency(result.getInt("id"),
                                                result.getString("type"),
                                                result.getString("caller_name"),
                                                result.getString("caller_phone"),
                                                result.getString("location"),
                                                result.getInt("resolved"),
                                                new DateTime(result.getString("date_created")),
                                                dateResolved,
                                                result.getInt("responder_id"));
            result.close();
            sqlStatement.close();
            return emergency;
        } catch (Exception e) {
            System.out.println("Unable to find emergency with id: " + id);
            System.out.println(e);
            return null;
        }
    }
    
    /**
     * Query the database for all emergencies of a given type.
     * @param type the emergency type to query for.
     * @return a list of all the emergencies of the given type.
     */
    public static ArrayList<Emergency> findAllEmergenciesByType (String type) {
        ArrayList<Emergency> emergencyList = new ArrayList<>();
        try {
            Statement sqlStatement = connection.createStatement();
            String sql = "SELECT * FROM EMERGENCY WHERE EMERGENCY.Type like '" + type + "';";
            ResultSet result = sqlStatement.executeQuery(sql);
            while (result.next()){
                // Ensure the dateResolve will be valid
                String dateResolvedString = result.getString("date_resolved");
                DateTime dateResolved;
                if (dateResolvedString.isEmpty()){
                    dateResolved = null;
                } else {
                    dateResolved = new DateTime(dateResolvedString);
                }

                Emergency emergency = new Emergency(result.getInt("id"),
                                                    result.getString("type"),
                                                    result.getString("caller_name"),
                                                    result.getString("caller_phone"),
                                                    result.getString("location"),
                                                    result.getInt("resolved"),
                                                    new DateTime(result.getString("date_created")),
                                                    dateResolved,
                                                    result.getInt("responder_id"));
                emergencyList.add(emergency);
            }
            result.close();
            sqlStatement.close();
            return emergencyList;
        } catch (Exception e) {
            System.out.println("Unable to find emergency with type: " + type);
            System.out.println(e);
            return null;
        }
    }
    
    /**
     * Query the emergency table for all rows with the corresponding responder id.
     * @param responderId the id number of the responder to search for.
     * @return A list of emergencies for the given responder.
     */
    public static ArrayList<Emergency> findAllEmergenciesByResponder (int responderId) {
        ArrayList<Emergency> emergencyList = new ArrayList<>();
        try {
            Statement sqlStatement = connection.createStatement();
            String sql = "SELECT * FROM EMERGENCY WHERE EMERGENCY.RESPONDER_ID = " + responderId + ";";
            ResultSet result = sqlStatement.executeQuery(sql);
            while (result.next()){
                // Ensure the dateResolve will be valid
                String dateResolvedString = result.getString("date_resolved");
                DateTime dateResolved;
                if (dateResolvedString.isEmpty()){
                    dateResolved = null;
                } else {
                    dateResolved = new DateTime(dateResolvedString);
                }

                Emergency emergency = new Emergency(result.getInt("id"),
                                                    result.getString("type"),
                                                    result.getString("caller_name"),
                                                    result.getString("caller_phone"),
                                                    result.getString("location"),
                                                    result.getInt("resolved"),
                                                    new DateTime(result.getString("date_created")),
                                                    dateResolved,
                                                    result.getInt("responder_id"));
                emergencyList.add(emergency);
            }
            result.close();
            sqlStatement.close();
            return emergencyList;
        } catch (Exception e) {
            System.out.println("Unable to find any emergencies for the given responder");
            System.out.println(e);
            return null;
        }
    }
    
    /**
     * Find all emergencies in the database.
     * @return an ArrayList of all the emergencies.
     */
    public static ArrayList<Emergency> findAllEmergencies () {
        ArrayList<Emergency> emergencyList = new ArrayList<>();
        try {
            Statement sqlStatement = connection.createStatement();
            String sql = "SELECT * FROM EMERGENCY;";
            ResultSet result = sqlStatement.executeQuery(sql);
            while (result.next()){
                // Ensure the dateResolved is valid for the emergency
                String dateResolvedString = result.getString("date_resolved");
                DateTime dateResolved;
                if (dateResolvedString.isEmpty()){
                    dateResolved = null;
                } else {
                    dateResolved = new DateTime(dateResolvedString);
                }

                Emergency emergency = new Emergency(result.getInt("id"),
                                                    result.getString("type"),
                                                    result.getString("caller_name"),
                                                    result.getString("caller_phone"),
                                                    result.getString("location"),
                                                    result.getInt("resolved"),
                                                    new DateTime(result.getString("date_created")),
                                                    dateResolved,
                                                    result.getInt("responder_id"));
                emergencyList.add(emergency);
            }
            result.close();
            sqlStatement.close();
            return emergencyList;
        } catch (Exception e) {
            System.out.println("Unable to find emergencies");
            System.out.println(e);
            return null;
        }
    }
    
    public static int getHighestId(String tableName) {
        try {
            Statement sqlStatement = connection.createStatement();
            String sql = "SELECT MAX(ID) as id FROM " + tableName.toUpperCase() + ";";
            ResultSet result = sqlStatement.executeQuery(sql);
            return (result.getInt("id"));
        } catch (Exception e) {
            System.out.println("Unable to find index");
            System.out.println(e);
            return 0;
        }
    }
}
