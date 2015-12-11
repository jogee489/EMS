//package views;
//
//import java.awt.Color;
//
//import javax.swing.JPanel;
//
//public class ResponderView extends JPanel {
//	
//	public ResponderView() {
//		setBackground(Color.BLUE);
//	}
//}
 
package views;

import models.Emergency;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.MaskFormatter;
import java.awt.Color;
import java.text.ParseException;
import java.util.ArrayList;

/**
 * @author dorkoj
 * @author toni
 */
public class ResponderView extends JPanel {
	
	private int windowWidth = Window.WINDOW_WIDTH;
	
	// current emergencies
	private JScrollPane currentEmergenciesScrollPanel = new JScrollPane();
	private DefaultListModel<Emergency> emergencyListModel = new DefaultListModel<Emergency>();
 	private JList<Emergency> currentEmergenciesList = new JList<Emergency>(emergencyListModel);

	// formats
	private static final String PHONE_NUMBER_FORMAT = "(###) ###-####";

	// strings
	private static final String[] DETAILS_LABELS = {"Caller Name", "Caller Phone Number", "Emergency Location", "Emergency Type"};
	private static final String[] EMERGENCY_TYPES = {"Crime", "Fire", "Medical", "Other"};

	// emergency details

	// labels, used on details
	private JLabel callerNameDetailLabel = new JLabel(DETAILS_LABELS[0]);
	private JLabel callerPhoneDetailLabel = new JLabel(DETAILS_LABELS[1]);
	private JLabel emergencyLocationDetailLabel = new JLabel(DETAILS_LABELS[2]);
	private JLabel emergencyTypeDetailLabel = new JLabel(DETAILS_LABELS[3]);

	// details fields, filled in by listener
	// TODO: remove text, this is just for testing
	private JTextField callerNameDetail = new JTextField();
	private JTextField callerPhoneDetail = new JTextField();
	private JTextField emergencyLocationDetail = new JTextField();
	// report button
	private JTextField emergencyTypeDetail = new JTextField();

    public ResponderView() {
        initComponents();
    }

    private void initComponents() {
        
    	JPanel emergencyListPanel = createEmergencyListPanel();
        JPanel emergencyDetailsPanel = createEmergencyDetailsPanel();
        JPanel mapPanel = createMapPanel();
        
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mapPanel, javax.swing.GroupLayout.PREFERRED_SIZE, windowWidth / 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(emergencyListPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(emergencyDetailsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(emergencyListPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(emergencyDetailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(mapPanel, javax.swing.GroupLayout.DEFAULT_SIZE, windowWidth / 2, Short.MAX_VALUE))
                .addContainerGap())
        );

    }
    
    /****************
     * PANEL BUILDING
     ****************/
    
	/*
	 * returns the lower-right panel that shows details about the selected emergency
	 */
	public JPanel createEmergencyDetailsPanel() {
		JPanel emergencyDetailsPanel = new JPanel();
		
		emergencyDetailsPanel.setBorder(new LineBorder(Color.BLACK, 1, true));
		
		// layout
        GroupLayout emergencyDetailsLayout = new GroupLayout(emergencyDetailsPanel);
        emergencyDetailsPanel.setLayout(emergencyDetailsLayout);
        
        emergencyDetailsLayout.setHorizontalGroup(
            emergencyDetailsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(emergencyDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(emergencyDetailsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(emergencyDetailsLayout.createSequentialGroup()
                        .addGroup(emergencyDetailsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(callerNameDetailLabel)
                            .addComponent(callerPhoneDetailLabel)
                            .addComponent(emergencyTypeDetailLabel))
                        .addGap(42, 42, 42))
                    .addGroup(GroupLayout.Alignment.LEADING, emergencyDetailsLayout.createSequentialGroup()
                        .addComponent(emergencyLocationDetailLabel)
                        .addGap(18, 18, 18)))
                .addGroup(emergencyDetailsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(emergencyLocationDetail, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
                    .addComponent(callerPhoneDetail, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
                    .addComponent(callerNameDetail, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
                    .addComponent(emergencyTypeDetail, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        emergencyDetailsLayout.setVerticalGroup(
            emergencyDetailsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(emergencyDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(emergencyDetailsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(callerNameDetail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(callerNameDetailLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(emergencyDetailsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(callerPhoneDetail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(callerPhoneDetailLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(emergencyDetailsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(emergencyTypeDetail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(emergencyTypeDetailLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(emergencyDetailsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(emergencyLocationDetail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(emergencyLocationDetailLabel))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        
		return emergencyDetailsPanel;
	} 
	
	public JPanel createMapPanel() {
		JPanel mapPanel = new JPanel();
		// TODO: google maps
		mapPanel.add(new JLabel("map"));
		return mapPanel;
	}
	
	/*
	 * returns the upper-right panel containing the list of active emergencies
	 */    
	public JPanel createEmergencyListPanel() {
		JPanel emergencyListPanel = new JPanel();
		currentEmergenciesScrollPanel.setViewportView(currentEmergenciesList);
		
        currentEmergenciesList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                emergencyListItemSelected(evt);
            }
        });
        
        GroupLayout emergencyListLayout = new GroupLayout(emergencyListPanel);
        emergencyListPanel.setLayout(emergencyListLayout);
        
        emergencyListLayout.setHorizontalGroup(
            emergencyListLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(currentEmergenciesScrollPanel, GroupLayout.Alignment.TRAILING)
        );
        emergencyListLayout.setVerticalGroup(
            emergencyListLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, emergencyListLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(currentEmergenciesScrollPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
		
		return emergencyListPanel;
	}
	
	/*
	 * Utility method to return MaskFormatter using the given string
	 */
	private MaskFormatter createFormatter(String format) {
		MaskFormatter formatter;
		try {
			formatter = new MaskFormatter(format);
			formatter.setAllowsInvalid(false);
		} catch (ParseException e) {
			return null;
		}
		return formatter;
	}
	
        /**********
 	 * SETTERS
 	 *********/
 	
 	public void updateCurrentEmergenciesList(ArrayList<Emergency> newlist) {
 		emergencyListModel.removeAllElements();
 		int index = 0;
 		for(Emergency e : newlist) {
 			emergencyListModel.add(index, e);
			index++;
 		}
 	}

	/************
	 * LISTENERS
	 ***********/
	
    private void emergencyListItemSelected(ListSelectionEvent evt) {
        Emergency emergencyInstance = (Emergency) currentEmergenciesList.getSelectedValue();
        callerNameDetail.setText(emergencyInstance.getCallerName());
        callerPhoneDetail.setText(emergencyInstance.getCallerPhone());
        emergencyTypeDetail.setText(emergencyInstance.getType());
        emergencyLocationDetail.setText(emergencyInstance.getLocation());   
    }
    
    private void resolveButtonClicked() {
 		
    }
 
   /*
    * END CLASS
    */
}
