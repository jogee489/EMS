/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.EmergencyController;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.*;
import javax.swing.border.LineBorder;
import models.Emergency;

/**
 *
 * @author dorkoj
 */
public class DispatchView extends javax.swing.JFrame {
    
    // Variables declaration  
    private DefaultListModel<Emergency> listModel = new DefaultListModel<>();
    private int index = 0;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    private JList activeEmergencyList;
    // New emergency form
    private JTextField callerName = new JTextField();
    private JTextField callerPhone = new JTextField();
    
    
    // Emergency details.
    private JTextField callerNameDetail = new JTextField();
    private JTextField callerPhoneDetail = new JTextField();
    private JLabel callerNameDetailLabel = new JLabel();
    private JLabel callerPhoneDetailLabel = new JLabel();
    private JButton editButton;
    private JPanel emergencyDetails;
    private JPanel emergencyForm;
    private JPanel emergencyList;
    private JTextField emergencyLocation = new JTextField();
    private JTextField emergencyLocationDetail = new JTextField();
    private JLabel emergencyLocationDetailLabel = new JLabel();
    private JComboBox emergencyType;
    private JComboBox emergencyTypeDetail;
    private JLabel emergencyTypeDetailLabel = new JLabel();
    private JLabel jLabel5 = new JLabel();
    private JLabel jLabel6 = new JLabel();
    private JLabel jLabel7 = new JLabel();
    private JLabel jLabel8 = new JLabel();
    private JScrollPane jScrollPane1;
    private JButton reportEmergencyButton1;
    private JButton viewButton;
    // End of variables declaration  

    EmergencyController emergencyController = new EmergencyController();
    /**
     * Creates new form DispatchView
     */
    public DispatchView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
        
        editButton = new JButton();
        viewButton = new JButton();
        
        emergencyDetails = new JPanel();
        emergencyLocationDetailLabel = new JLabel();
        emergencyTypeDetail = new JComboBox();
        callerNameDetail = new JTextField();
        callerNameDetailLabel = new JLabel();
        callerPhoneDetailLabel = new JLabel();
        emergencyTypeDetailLabel = new JLabel();
        callerPhoneDetail = new JTextField();
        emergencyLocationDetail = new JTextField();
        emergencyForm = new JPanel();
        jLabel5 = new JLabel();
        emergencyType = new JComboBox();
        callerName = new JTextField();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        callerPhone = new JTextField();
        emergencyLocation = new JTextField();
        reportEmergencyButton1 = new JButton();
        emergencyList = new JPanel();
        jScrollPane1 = new JScrollPane();
        activeEmergencyList = new JList();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        editButton.setText("Edit");

        viewButton.setText("View");

        emergencyDetails.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        emergencyLocationDetailLabel.setText("Emergency Location");
        // TODO: this needs to be changed
        emergencyTypeDetail.setModel(new DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        callerNameDetailLabel.setText("Caller Name");
        callerPhoneDetailLabel.setText("Caller Phone #");
        emergencyTypeDetailLabel.setText("Emergency Type");

        javax.swing.GroupLayout emergencyDetailsLayout = new javax.swing.GroupLayout(emergencyDetails);
        emergencyDetails.setLayout(emergencyDetailsLayout);
        emergencyDetailsLayout.setHorizontalGroup(
            emergencyDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(emergencyDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(emergencyDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(emergencyDetailsLayout.createSequentialGroup()
                        .addGroup(emergencyDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(callerNameDetailLabel)
                            .addComponent(callerPhoneDetailLabel)
                            .addComponent(emergencyTypeDetailLabel))
                        .addGap(42, 42, 42))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, emergencyDetailsLayout.createSequentialGroup()
                        .addComponent(emergencyLocationDetailLabel)
                        .addGap(18, 18, 18)))
                .addGroup(emergencyDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(emergencyLocationDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(callerPhoneDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(callerNameDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emergencyTypeDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        emergencyDetailsLayout.setVerticalGroup(
            emergencyDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(emergencyDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(emergencyDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(callerNameDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(callerNameDetailLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(emergencyDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(callerPhoneDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(callerPhoneDetailLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(emergencyDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emergencyTypeDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emergencyTypeDetailLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(emergencyDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emergencyLocationDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emergencyLocationDetailLabel))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        emergencyForm.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel5.setText("Emergency Location");

        emergencyType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Fire", "Violence", "Medical", "Other" }));

        jLabel6.setText("Caller Name");

        jLabel7.setText("Caller Phone #");

        jLabel8.setText("Emergency Type");

        reportEmergencyButton1.setText("Report An Emergency");
        reportEmergencyButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reportEmergencyButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout emergencyFormLayout = new javax.swing.GroupLayout(emergencyForm);
        emergencyForm.setLayout(emergencyFormLayout);
        emergencyFormLayout.setHorizontalGroup(
            emergencyFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(emergencyFormLayout.createSequentialGroup()
                .addGroup(emergencyFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(emergencyFormLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(emergencyFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(emergencyFormLayout.createSequentialGroup()
                                .addGroup(emergencyFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(42, 42, 42))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, emergencyFormLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)))
                        .addGroup(emergencyFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(emergencyLocation, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(callerPhone, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(callerName, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(emergencyType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(emergencyFormLayout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(reportEmergencyButton1)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        emergencyFormLayout.setVerticalGroup(
            emergencyFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(emergencyFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(emergencyFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(callerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(emergencyFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(callerPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(emergencyFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emergencyType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(emergencyFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emergencyLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(reportEmergencyButton1)
                .addContainerGap())
        );

        emergencyList.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        /*activeEmergencyList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });*/
        //activeEmergencyList = new JList(emergencyController.getActiveEmergencies().toArray());
        JList<Emergency> list = new JList<>(listModel);
        jScrollPane1.setViewportView(list);

        javax.swing.GroupLayout emergencyListLayout = new javax.swing.GroupLayout(emergencyList);
        emergencyList.setLayout(emergencyListLayout);
        emergencyListLayout.setHorizontalGroup(
            emergencyListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        emergencyListLayout.setVerticalGroup(
            emergencyListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, emergencyListLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(emergencyForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(editButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(viewButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(emergencyList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(emergencyDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editButton)
                    .addComponent(viewButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(emergencyList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(emergencyDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(emergencyForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void reportEmergencyButton1MouseClicked(java.awt.event.MouseEvent evt) {                                                    
        // TODO add your handling code here:
        String name = callerName.getText();
        String phone = callerPhone.getText();
        String type = emergencyType.getSelectedItem().toString();
        String location = emergencyLocation.getText();
        Emergency emergency = emergencyController.createEmergency(type, name, phone, location);
        // TODO pop up to state emergency created
        // TODO update EmergencyList
        listModel.add(index++, emergency);
        
        // Reset the text fields.
        callerName.setText(null);
        callerPhone.setText(null);
        emergencyLocation.setText(null);
    }                                                   

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DispatchView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DispatchView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DispatchView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DispatchView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DispatchView().setVisible(true);
            }
        });
    }

}
