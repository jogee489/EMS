
import ems.DatabaseSetup;
import static ems.DatabaseSetup.connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import models.Emergency;
import models.Responder;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Test;

/**
 *
 * @author dorkoj
 */
public class DatabaseSetupTest {
    Statement sqlStatement;
    String sql;
    ResultSet result;
    
    @After
    public void resetData() {
        DatabaseSetup.closeConnection();
        System.out.println("*************************************");
    }
    
    @Test
    public void connectToDatabaseTest() {
        System.out.println("connectToDatabaseTest");
        DatabaseSetup.connectToDatabase();
        assertNotNull(DatabaseSetup.connection);
    }
    
    @Test
    public void createTablesTest() {
        System.out.println("createTablesTest");
        DatabaseSetup.connectToDatabase();
        DatabaseSetup.createTables();
        try {
             sqlStatement = connection.createStatement();
             sql = "SELECT COUNT(*) as count FROM sqlite_master WHERE TYPE like 'TABLE'";
             sqlStatement.executeQuery(sql);
             result = sqlStatement.executeQuery(sql);
             assertEquals(2,result.getInt("count"));
        } catch (Exception e) {
            assert(false);
        }
        
    }
    
    @Test
    public void dropTablesTest() {
        System.out.println("createTablesTest");
        DatabaseSetup.connectToDatabase();
        DatabaseSetup.createTables();
        DatabaseSetup.dropTables();
        try {
             sqlStatement = connection.createStatement();
             sql = "SELECT COUNT(*) as count FROM sqlite_master WHERE TYPE='TABLE' AND NAME='TABLENAME'";
             sqlStatement.executeQuery(sql);
             result = sqlStatement.executeQuery(sql);
             assertEquals(result.getInt("count"), 0);
        } catch (Exception e) {
            assert(false);
        }
    }
    
    @Test
    public void saveResponderValidTest() {
        System.out.println("saveResponderValidTest");
        DatabaseSetup.connectToDatabase();
        DatabaseSetup.dropTables();
        DatabaseSetup.createTables();
        Responder responder = new Responder("Fire", "FW Fire Department", "453 Main St. Fort Wayne IN 46818");
        DatabaseSetup.saveResponder(responder);
        try {
             sqlStatement = connection.createStatement();
             sql = "SELECT COUNT(*) as count FROM RESPONDER;";
             sqlStatement.executeQuery(sql);
             result = sqlStatement.executeQuery(sql);
             assertEquals(result.getInt("count"), 1);
        } catch (Exception e) {
            assert(false);
        } 
    }
    
    @Test
    public void saveEmergencyValidTest() {
        System.out.println("saveEmergencyValidTest");
        DatabaseSetup.connectToDatabase();
        DatabaseSetup.dropTables();
        DatabaseSetup.createTables();
        Emergency emergency = new Emergency("Fire", "Bob Dole", "555-555-5555",
                                            "5133 Truemper way Fort Wayne IN 46835");
        DatabaseSetup.saveEmergency(emergency);
        try {
             sqlStatement = connection.createStatement();
             sql = "SELECT COUNT(*) as count FROM EMERGENCY;";
             sqlStatement.executeQuery(sql);
             result = sqlStatement.executeQuery(sql);
             assertEquals(1, result.getInt("count"));
        } catch (Exception e) {
            assert(false);
        }
    }
    
    @Test
    public void saveEmergencyInvalidTest() {
        System.out.println("saveEmergencyInvalidTest");
        DatabaseSetup.connectToDatabase();
        DatabaseSetup.dropTables();
        DatabaseSetup.createTables();
        Emergency emergency = new Emergency();
        DatabaseSetup.saveEmergency(emergency);
        try {
             sqlStatement = connection.createStatement();
             sql = "SELECT COUNT(*) as count FROM EMERGENCY;";
             sqlStatement.executeQuery(sql);
             result = sqlStatement.executeQuery(sql);
             assertEquals(0, result.getInt("count"));
        } catch (Exception e) {
            assert(false);
        }
    }
    
    @Test
    public void findResponderByIdInDatabaseTest() {
        System.out.println("findResponderByIdInDatabaseTest");
        DatabaseSetup.connectToDatabase();
        DatabaseSetup.dropTables();
        DatabaseSetup.createTables();
        Responder responder = new Responder("Fire", "FW Fire Department", "453 Main St. Fort Wayne IN 46818");
        DatabaseSetup.saveResponder(responder);
        Responder responderResult = DatabaseSetup.findResponderById(responder.getId());
        assertNotNull(responderResult);
    }
    
    @Test
    public void findResponderByIdNotInDatabaseTest() {
        System.out.println("findResponderByIdNotInDatabaseTest");
        DatabaseSetup.connectToDatabase();
        DatabaseSetup.dropTables();
        DatabaseSetup.createTables();
        Responder responderResult = DatabaseSetup.findResponderById(4);
        assertNull(responderResult);
    }
    
    @Test
    public void findAllResponderByTypeTest() {
        System.out.println("findAllResponderByTypeTest");
        DatabaseSetup.connectToDatabase();
        DatabaseSetup.dropTables();
        DatabaseSetup.createTables();
        ArrayList<Responder> responderList = new ArrayList<>();
        responderList.add(new Responder("Fire", "FW Fire Department", "453 Main St. Fort Wayne IN 46818"));
        responderList.add(new Responder("Crime", "FW Police Department", "420 Main St. Fort Wayne IN 46818"));
        responderList.add(new Responder("Medical", "Dupont Hospital", "690 Main St. Fort Wayne IN 46818"));
        responderList.add(new Responder("Medical", "Parkview Hospital", "692 Main St. Fort Wayne IN 46818"));
        for (Responder responder : responderList){
            responder.save();
        }
        ArrayList<Responder> responderResult = DatabaseSetup.findAllRespondersByType("Medical");
        assertEquals(2, responderResult.size());
    }
    
    @Test
    public void findEmergencyByIdInDatabaseTest() {
        System.out.println("findEmergencyByIdInDatabaseTest");
        DatabaseSetup.connectToDatabase();
        DatabaseSetup.dropTables();
        DatabaseSetup.createTables();
        Responder responder = new Responder("Fire", "FW Fire Department", "453 Main St. Fort Wayne IN 46818");
        Emergency emergency = new Emergency("Fire", "Bob Dole", "555-555-5555",
                                            "5133 Truemper way Fort Wayne IN 46835");
        emergency.assignResponder(responder);
        DatabaseSetup.saveEmergency(emergency);
        Emergency emergencyResult = DatabaseSetup.findEmergencyById(emergency.getId());
        assertNotNull(emergencyResult);
    }
    
    @Test
    public void findEmergencyByIdNotInDatabaseTest() {
        System.out.println("findEmergencyByIdNotInDatabaseTest");
        DatabaseSetup.connectToDatabase();
        DatabaseSetup.dropTables();
        DatabaseSetup.createTables();
        Emergency emergencyResult = DatabaseSetup.findEmergencyById(4);
        System.out.println(emergencyResult);
        assertNull(emergencyResult);
    }
    
    @Test
    public void findAllEmergenciesByTypeTest() {
        System.out.println("findAllEmergenciesByTypeTest");
        DatabaseSetup.connectToDatabase();
        DatabaseSetup.dropTables();
        DatabaseSetup.createTables();
        ArrayList<Emergency> emergencyList = new ArrayList<>();
        emergencyList.add(new Emergency("Fire", "Bob Dole", "555-555-5555",
                                            "5133 Truemper way Fort Wayne IN 46835"));
        emergencyList.add(new Emergency("Crime", "Bob Dole", "555-555-5555",
                                            "5133 Truemper way Fort Wayne IN 46835"));
        emergencyList.add(new Emergency("Fire", "Bob Dole", "555-555-5555",
                                            "5133 Truemper way Fort Wayne IN 46835"));
        emergencyList.add(new Emergency("Medical", "Bob Dole", "555-555-5555",
                                            "5133 Truemper way Fort Wayne IN 46835"));
        for (Emergency emergency : emergencyList){
            emergency.save();
        }
        ArrayList<Emergency> emergencyResult = DatabaseSetup.findAllEmergenciesByType("Fire");
        assertEquals(2, emergencyResult.size());
    }
    
    @Test
    public void findAllEmergencyByResponderTest() {
        System.out.println("findAllEmergencyByResponderTest");
        DatabaseSetup.connectToDatabase();
        DatabaseSetup.dropTables();
        DatabaseSetup.createTables();
        Responder responder = new Responder("Fire", "FW Fire Department", "453 Main St. Fort Wayne IN 46818");
        responder.save();
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
                                            responder.getId()));
        for (Emergency emergency : emergencyList){
            emergency.save();
        }
        ArrayList<Emergency> emergencyResult = DatabaseSetup.findAllEmergenciesByResponder(1);
        assertEquals(1, emergencyResult.size());
    }
    
    @Test
    public void findAllEmergenciesTest() {
        System.out.println("findAllEmergenciesTest");
        DatabaseSetup.connectToDatabase();
        DatabaseSetup.dropTables();
        DatabaseSetup.createTables();
        ArrayList<Emergency> emergencyList = new ArrayList<>();
        emergencyList.add(new Emergency("Fire", "Bob Dole", "555-555-5555",
                                            "5133 Truemper way Fort Wayne IN 46835"));
        emergencyList.add(new Emergency("Crime", "Bob Dole", "555-555-5555",
                                            "5133 Truemper way Fort Wayne IN 46835"));
        emergencyList.add(new Emergency("Fire", "Bob Dole", "555-555-5555",
                                            "5133 Truemper way Fort Wayne IN 46835"));
        emergencyList.add(new Emergency("Medical", "Bob Dole", "555-555-5555",
                                            "5133 Truemper way Fort Wayne IN 46835"));
        for (Emergency emergency : emergencyList){
            emergency.save();
        }
        ArrayList<Emergency> emergencyResult = DatabaseSetup.findAllEmergencies();
        assertEquals(4, emergencyResult.size());
    }
    
    @Test
    public void getHighestIndexNoRowsInTableTest() {
        System.out.println("getHighestIndexNoRowsInTableTest");
        DatabaseSetup.connectToDatabase();
        DatabaseSetup.dropTables();
        DatabaseSetup.createTables();
        int index = DatabaseSetup.getHighestId("Responder");
        assertEquals(0, index);
    }
    
    @Test
    public void getHighestIndexWithRowsInTableTest() {
        System.out.println("getHighestIndexWithRowsInTableTest");
        DatabaseSetup.connectToDatabase();
        DatabaseSetup.dropTables();
        DatabaseSetup.createTables();
        ArrayList<Emergency> emergencyList = new ArrayList<>();
        emergencyList.add(new Emergency("Fire", "Bob Dole", "555-555-5555",
                                            "5133 Truemper way Fort Wayne IN 46835"));
        emergencyList.add(new Emergency("Crime", "Bob Dole", "555-555-5555",
                                            "5133 Truemper way Fort Wayne IN 46835"));
        emergencyList.add(new Emergency("Fire", "Bob Dole", "555-555-5555",
                                            "5133 Truemper way Fort Wayne IN 46835"));
        emergencyList.add(new Emergency("Medical", "Bob Dole", "555-555-5555",
                                            "5133 Truemper way Fort Wayne IN 46835"));
        for (Emergency emergency : emergencyList){
            emergency.save();
        }
        int index = DatabaseSetup.getHighestId("Emergency");
        assertEquals(4, index);
    }
    
}
