/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import ems.DatabaseSetup;
import java.io.FileWriter;
import java.util.ArrayList;
import models.Emergency;
import org.joda.time.DateTime;
import org.joda.time.Interval;

/**
 *
 * @author dorkoj
 */
public class ReportController {
    /**
     * Generate report including all the emergencies for a given responder.
     * @param responderId the id number of the responder.
     */
    public static void reportByResponder(int responderId) {
        ArrayList<Emergency> emergencyList = DatabaseSetup.findAllEmergenciesByResponder(responderId);
        generateEmergencyCsvFile(emergencyList);
    }
    
    /**
     * Generate a report for all emergencies belonging to given responder within a date interval.
     * @param responderId the id number of the responder.
     * @param start the start date of the interval.
     * @param end the end date of the interval.
     */
    public static void reportByResponderAndDate(int responderId, DateTime start, DateTime end) {
        ArrayList<Emergency> initialList = DatabaseSetup.findAllEmergenciesByResponder(responderId);
        ArrayList<Emergency> emergencyList = findBetweenDates(initialList, start, end);
        generateEmergencyCsvFile(emergencyList);
    }
    /**
     * Generate csv file reporting all emergencies with the given type
     * @param type the type of emergency to report
     */
    public static void reportByEmergencyType(String type) {
        ArrayList<Emergency> emergencyList = DatabaseSetup.findAllEmergenciesByType(type);
        generateEmergencyCsvFile(emergencyList);
    }
    
    /**
     * Generate a report containing all emergencies of a given type within a date interval.
     * @param type the type of emergency to search.
     * @param start the start date for the interval
     * @param end the end date for the interval
     */
    public static void reportByEmergencyTypeAndDateRange(String type, DateTime start, DateTime end) {
        ArrayList<Emergency> initialList = DatabaseSetup.findAllEmergenciesByType(type);
        ArrayList<Emergency> emergencyList = findBetweenDates(initialList, start, end);
        generateEmergencyCsvFile(emergencyList);
    }
    
    /**
     * Generate a report containing all the emergencies within a given data interval.
     * @param start the start date of the interval.
     * @param end the end date of the interval.
     */
    public static void reportByEmergencyDateRange(DateTime start, DateTime end) {
        ArrayList<Emergency> initialList = DatabaseSetup.findAllEmergencies();
        ArrayList<Emergency> emergencyList = findBetweenDates(initialList, start, end);
        generateEmergencyCsvFile(emergencyList);
    }
    
    /**
     * Convert a list of emergencies to a csv file and export it.
     * @param emergencyList list of emergencies to export to csv.
     */
    private static void generateEmergencyCsvFile(ArrayList<Emergency> emergencyList) {
        try {
            String filename = "report.csv";
            FileWriter writer = new FileWriter(filename);
            // header of the csv file
            writer.append("ID, Type, Caller Name, Caller Phone, Location, Resolved, " +
                          "Date Created, Date Resolved, Responder Name");
            for (Emergency instance : emergencyList) {
                writer.append('\n');
                writer.append(instance.reportString());
            }
            writer.flush();
            writer.close();
            System.out.println("Created report: " + filename);
            
        } catch (Exception e) {
            System.out.println("Unable to create csv: " + e);
        }
    }
    
    /**
     * Find all emergencies in a list that are within the given date range.
     * @param initialList list of emergencies to search through.
     * @param start start date of the interval.
     * @param end the end date of the interval.
     * @return 
     */
    private static ArrayList<Emergency> findBetweenDates(ArrayList<Emergency> initialList, DateTime start, DateTime end) {
        ArrayList<Emergency> emergencyList = new ArrayList<>();
        Interval interval = new Interval(start, end);
        for (Emergency instance : initialList) {
            if (interval.contains(instance.getDateCreated())){
                emergencyList.add(instance);
            }
        }
        return emergencyList;
    }
}
