/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ems;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author dorkoj
 */
public class EMS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String url = "jdbc:sqlite:ems";
        //String username = "user";
        //String password = "password";

        System.out.println("Connecting database...");
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = (Connection) DriverManager.getConnection(url);
            System.out.println("Database connected!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        } catch (Exception e) {
            System.out.println("Class error has occured: " + e);
        }
    }
    
}
