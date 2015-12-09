
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
    public void dropTables() {
        DatabaseSetup.dropTables();
        DatabaseSetup.closeConnection();
    }
    
    @Test
    public void connectToDatabaseTest() {
        DatabaseSetup.connectToDatabase();
        assertNotNull(DatabaseSetup.connection);
    }
    
    @Test
    public void createTablesTest() {
        DatabaseSetup.connectToDatabase();
        DatabaseSetup.createTables();
        try {
             sqlStatement = connection.createStatement();
             sql = "SELECT COUNT(*) as count FROM sqlite_master WHERE TYPE='TABLE' AND NAME='TABLENAME'";
             sqlStatement.executeQuery(sql);
             result = sqlStatement.executeQuery(sql);
             assertEquals(result.getInt("count"), 2);
        } catch (Exception e) {
            assert(false);
        }
        
    }
    
    @Test
    public void dropTablesTest() {
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
        DatabaseSetup.connectToDatabase();
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
    public void saveResponderInvalidTest() {
        DatabaseSetup.connectToDatabase();
        DatabaseSetup.createTables();
        Responder responder = new Responder();
        DatabaseSetup.saveResponder(responder);
        try {
             sqlStatement = connection.createStatement();
             sql = "SELECT COUNT(*) as count FROM RESPONDER;";
             sqlStatement.executeQuery(sql);
             result = sqlStatement.executeQuery(sql);
             assertEquals(result.getInt("count"), 0);
        } catch (Exception e) {
            assert(false);
        }
    }
    
    @Test
    public void saveEmergencyValidTest() {
        DatabaseSetup.connectToDatabase();
        DatabaseSetup.createTables();
        Emergency emergency = new Emergency("Fire", "Bob Dole", "555-555-5555",
                                            "5133 Truemper way Fort Wayne IN 46835");
        DatabaseSetup.saveEmergency(emergency);
        try {
             sqlStatement = connection.createStatement();
             sql = "SELECT COUNT(*) as count FROM EMERGENCY;";
             sqlStatement.executeQuery(sql);
             result = sqlStatement.executeQuery(sql);
             assertEquals(result.getInt("count"), 1);
        } catch (Exception e) {
            assert(false);
        }
    }
    
    @Test
    public void saveEmergencyInvalidTest() {
        DatabaseSetup.connectToDatabase();
        DatabaseSetup.createTables();
        Emergency emergency = new Emergency();
        DatabaseSetup.saveEmergency(emergency);
        try {
             sqlStatement = connection.createStatement();
             sql = "SELECT COUNT(*) as count FROM EMERGENCY;";
             sqlStatement.executeQuery(sql);
             result = sqlStatement.executeQuery(sql);
             assertEquals(result.getInt("count"), 0);
        } catch (Exception e) {
            assert(false);
        }
    }
    
    @Test
    public void findResponderByIdInDatabaseTest() {
        DatabaseSetup.connectToDatabase();
        DatabaseSetup.createTables();
        Responder responder = new Responder("Fire", "FW Fire Department", "453 Main St. Fort Wayne IN 46818");
        DatabaseSetup.saveResponder(responder);
        Responder responderResult = DatabaseSetup.findResponderById(responder.getId());
        assertNotNull(responderResult);
    }
    
    @Test
    public void findResponderByIdNotInDatabaseTest() {
        DatabaseSetup.connectToDatabase();
        DatabaseSetup.createTables();
        Responder responderResult = DatabaseSetup.findResponderById(4);
        assertNull(responderResult);
    }
    
    @Test
    public void findAllResponderByTypeTest() {
        DatabaseSetup.connectToDatabase();
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
        DatabaseSetup.connectToDatabase();
        DatabaseSetup.createTables();
        Emergency emergency = new Emergency("Fire", "Bob Dole", "555-555-5555",
                                            "5133 Truemper way Fort Wayne IN 46835");
        DatabaseSetup.saveEmergency(emergency);
        Emergency emergencyResult = DatabaseSetup.findEmergencyById(emergency.getId());
        assertNotNull(emergencyResult);
    }
    
    @Test
    public void findEmergencyByIdNotInDatabaseTest() {
        DatabaseSetup.connectToDatabase();
        DatabaseSetup.createTables();
        Emergency emergencyResult = DatabaseSetup.findEmergencyById(4);
        assertNull(emergencyResult);
    }
    
    @Test
    public void findAllEmergenciesByTypeTest() {
        DatabaseSetup.connectToDatabase();
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
        DatabaseSetup.connectToDatabase();
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
        DatabaseSetup.connectToDatabase();
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
        DatabaseSetup.connectToDatabase();
        DatabaseSetup.createTables();
        int index = DatabaseSetup.getHighestId("Emergency");
        assertEquals(0, index);
    }
    
    @Test
    public void getHighestIndexWithRowsInTableTest() {
        DatabaseSetup.connectToDatabase();
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
