package controllers;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;

import views.DispatchView;
import views.ResponderView;

import models.Emergency;

/**
 *
 * @author dorkoj
 */
public class EmergencyController {
    private Emergency emergencyInstance;
    
    private ArrayList<Emergency> emergencyList = new ArrayList<Emergency>();
    private int idCounter = 0;

    // dispatch
    private DispatchView dispatch;
    private ResponderView responder;
    
    public Emergency createEmergency(String type, String callerName, String callerPhone, String location) {
        emergencyInstance = new Emergency(type, callerName, callerPhone, location);
        addEmergency(emergencyInstance);
        dispatch.updateCurrentEmergenciesList(emergencyList);
        responder.updateCurrentEmergenciesList(emergencyList);
        return emergencyInstance;
    }
    
    
    
    public void addEmergency(Emergency emergency) {
    	emergencyList.add(emergency);
    }
    
    public List<Emergency> getEmergencies() {
        return emergencyList;
    }
    
    public void setDispatch(DispatchView dispatch) {
    	this.dispatch = dispatch;
    }
    
    public void setResponder(ResponderView responder) {
    	this.responder = responder;
    }	
    	
    /**
     * Retrieve a list of all the emergencies that haven't been resolved.
     * @return List of all the active emergencies.
     */
    public List<Emergency> getActiveEmergencies() {
        ArrayList<Emergency> activeEmergencies = new ArrayList<>();
        for (Emergency emergency : emergencyList) {
            if (!emergency.isResolved()){
                activeEmergencies.add(emergency);
            }
        }
        return activeEmergencies;
    }
    
}
