/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.EmergencyController;
import models.Emergency;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author dorkoj
 * @author toni
 * 
 */
public class DispatchView extends JPanel {

	// current emergencies
	private JScrollPane currentEmergenciesScrollPanel = new JScrollPane();
	private DefaultListModel<Emergency> emergencyListModel = new DefaultListModel<Emergency>();
	private JList<Emergency> currentEmergenciesList = new JList<Emergency>(emergencyListModel);
	int index;

	// formats
	private static final String PHONE_NUMBER_FORMAT = "(###) ###-####";

	// strings
	private static final String[] DETAILS_LABELS = {"Caller Name", "Caller Phone Number", "Emergency Location", "Emergency Type"};
	private static final String[] EMERGENCY_TYPES = {"Crime", "Fire", "Medical", "Other"};

	// emergency details

	// labels, used on reporting
	private JLabel callerNameLabel = new JLabel(DETAILS_LABELS[0]);
	private JLabel callerPhoneLabel = new JLabel(DETAILS_LABELS[1]);
	private JLabel emergencyLocationLabel = new JLabel(DETAILS_LABELS[2]);
	private JLabel emergencyTypeLabel = new JLabel(DETAILS_LABELS[3]);
	
	// labels, used on details
	private JLabel callerNameDetailLabel = new JLabel(DETAILS_LABELS[0]);
	private JLabel callerPhoneDetailLabel = new JLabel(DETAILS_LABELS[1]);
	private JLabel emergencyLocationDetailLabel = new JLabel(DETAILS_LABELS[2]);
	private JLabel emergencyTypeDetailLabel = new JLabel(DETAILS_LABELS[3]);

	// reporting input, filled in by user
	private JTextField callerNameInput = new JTextField();
	private JTextField callerPhoneInput = new JFormattedTextField(createFormatter(PHONE_NUMBER_FORMAT));
	private JTextField emergencyLocationInput = new JTextField();
	private JComboBox<String> emergencyTypeInput = new JComboBox<String>(EMERGENCY_TYPES);
	private JButton reportEmergencyButton = new JButton("Report Emergency");

	// details fields, filled in by listener
	// TODO: remove text, this is just for testing
	private JTextField callerNameDetail = new JTextField();
	private JTextField callerPhoneDetail = new JTextField();
	private JTextField emergencyLocationDetail = new JTextField();
	// report button
	private JTextField emergencyTypeDetail = new JTextField();

	// controller
	static final EmergencyController emergencyController = new EmergencyController();

	/****************
	 * PANEL BUILDING
	 ****************/

	/*
	 * Creates new form DispatchView
	 */
	public DispatchView() {
		initComponents();
	}
	
	private void initComponents() {
		
		JPanel emergencyForm = createReportEmergencyPanel();
		JPanel emergencyList = createEmergencyListPanel();
		JPanel emergencyDetails = createEmergencyDetailsPanel();
				
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(emergencyForm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(emergencyList, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(emergencyDetails, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(emergencyList, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(emergencyDetails, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addComponent(emergencyForm, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
	}

	/*
	 * returns the left-side panel containing the reporting form
	 */
	public JPanel createReportEmergencyPanel() {
		JPanel emergencyForm = new JPanel();
		
		emergencyForm.setBorder(new LineBorder(Color.BLACK, 1, true));

		// button
		reportEmergencyButton.addActionListener(new reportEmergencyButtonListener());

		// layout
		GroupLayout layout = new GroupLayout(emergencyForm);
		emergencyForm.setLayout(layout);
		
		GroupLayout emergencyFormLayout = new GroupLayout(emergencyForm);
        emergencyForm.setLayout(emergencyFormLayout);

        emergencyFormLayout.setHorizontalGroup(
            emergencyFormLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(emergencyFormLayout.createSequentialGroup()
                .addGroup(emergencyFormLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(emergencyFormLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(emergencyFormLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(emergencyFormLayout.createSequentialGroup()
                                .addGroup(emergencyFormLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(callerNameLabel)
                                    .addComponent(callerPhoneLabel)
                                    .addComponent(emergencyTypeLabel))
                                .addGap(42, 42, 42))
                            .addGroup(GroupLayout.Alignment.LEADING, emergencyFormLayout.createSequentialGroup()
                                .addComponent(emergencyLocationLabel)
                                .addGap(18, 18, 18)))
                        .addGroup(emergencyFormLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(emergencyLocationInput, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(callerPhoneInput, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(callerNameInput, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(emergencyTypeInput, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(emergencyFormLayout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(reportEmergencyButton)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        emergencyFormLayout.setVerticalGroup(
            emergencyFormLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(emergencyFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(emergencyFormLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(callerNameInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(callerNameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(emergencyFormLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(callerPhoneInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(callerPhoneLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(emergencyFormLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(emergencyTypeInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(emergencyTypeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(emergencyFormLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(emergencyLocationInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(emergencyLocationLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(reportEmergencyButton)
                .addContainerGap())
        );
        
		return emergencyForm;
	}

	/*
	 * returns the upper-right panel containing the list of active emergencies
	 */    
	public JPanel createEmergencyListPanel() {
		JPanel emergencyListPanel = new JPanel();
		currentEmergenciesScrollPanel.setViewportView(currentEmergenciesList);
		
       currentEmergenciesList.addListSelectionListener(new ListSelectionListener() {  
    	   public void valueChanged(javax.swing.event.ListSelectionEvent e) {
                emergencyListItemSelected(e);
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

	/***********
	 * LISTENERS
	 ***********/
	
	/*
	 * fills fields when an emergency in the active list is selected
	 */
    private void emergencyListItemSelected(ListSelectionEvent e) {
        Emergency emergencyInstance = (Emergency) currentEmergenciesList.getSelectedValue();
        callerNameDetail.setText(emergencyInstance.getCallerName());
        callerPhoneDetail.setText(emergencyInstance.getCallerPhone());
        emergencyTypeDetail.setText(emergencyInstance.getType());
        emergencyLocationDetail.setText(emergencyInstance.getLocation());   
    }

	/*
	 * Listener for the report emergency button. 
	 * Pulls data from the fields and calls the emergency controller to create a new emergency
	 */
	private class reportEmergencyButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String callerName = callerNameInput.getText();
			String callerPhone = callerPhoneInput.getText(); 
			String emergencyLocation = emergencyLocationInput.getText(); 
			String emergencyType = (String) emergencyTypeInput.getSelectedItem(); 
			System.out.println(callerName + " " + callerPhone + " " + emergencyLocation + " " + emergencyType);

			// send emergency to the controller
			Emergency emergency = Window.EMERGENCY_CONTROLLER.createEmergency(emergencyType, callerName, callerPhone, emergencyLocation);

			// clear fields
			callerNameInput.setText("");
			callerPhoneInput.setText("");
			emergencyLocationInput.setText("");
			emergencyTypeInput.setSelectedIndex(0);
		} 
	}

	/***********
	 * END CLASS
	 ***********/
}
