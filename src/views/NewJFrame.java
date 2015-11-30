/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.EmergencyController;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListModel;
import models.Emergency;

/**
 *
 * @author dorkoj
 */
public class NewJFrame extends javax.swing.JFrame {

    EmergencyController emergencyController = new EmergencyController();
    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        emergencyDetails = new javax.swing.JPanel();
        emergencyLocationDetailLabel = new javax.swing.JLabel();
        emergencyTypeDetail = new javax.swing.JComboBox();
        callerNameDetail = new javax.swing.JTextField();
        callerNameDetailLabel = new javax.swing.JLabel();
        callerPhoneDetailLabel = new javax.swing.JLabel();
        emergencyTypeDetailLabel = new javax.swing.JLabel();
        callerPhoneDetail = new javax.swing.JTextField();
        emergencyLocationDetail = new javax.swing.JTextField();
        emergencyFormPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        emergencyType = new javax.swing.JComboBox();
        callerName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        callerPhone = new javax.swing.JTextField();
        emergencyLocation = new javax.swing.JTextField();
        reportEmergencyButton1 = new javax.swing.JButton();
        emergencyList = new javax.swing.JPanel();
        emergencyListPane = new javax.swing.JScrollPane();
        activeEmergencyList = new javax.swing.JList<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        viewMenu = new javax.swing.JMenu();
        dispatchViewMenuItem = new javax.swing.JMenuItem();
        responderViewMenuItem = new javax.swing.JMenuItem();
        adminViewMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        emergencyDetails.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        emergencyLocationDetailLabel.setText("Emergency Location");

        emergencyTypeDetail.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Fire", "Criminal", "Medical", "Other" }));

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, activeEmergencyList, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.callerName}"), callerNameDetail, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

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
                .addGroup(emergencyDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(emergencyLocationDetail, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                    .addComponent(callerPhoneDetail, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                    .addComponent(callerNameDetail, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                    .addComponent(emergencyTypeDetail, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        emergencyFormPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel5.setText("Emergency Location");

        emergencyType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Fire", "Criminal", "Medical", "Other" }));

        jLabel6.setText("Caller Name");

        jLabel7.setText("Caller Phone #");

        jLabel8.setText("Emergency Type");

        reportEmergencyButton1.setText("Report An Emergency");
        reportEmergencyButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reportEmergencyButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout emergencyFormPanelLayout = new javax.swing.GroupLayout(emergencyFormPanel);
        emergencyFormPanel.setLayout(emergencyFormPanelLayout);
        emergencyFormPanelLayout.setHorizontalGroup(
            emergencyFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(emergencyFormPanelLayout.createSequentialGroup()
                .addGroup(emergencyFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(emergencyFormPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(emergencyFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(emergencyFormPanelLayout.createSequentialGroup()
                                .addGroup(emergencyFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(42, 42, 42))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, emergencyFormPanelLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)))
                        .addGroup(emergencyFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(emergencyLocation, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(callerPhone, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(callerName, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(emergencyType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(emergencyFormPanelLayout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(reportEmergencyButton1)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        emergencyFormPanelLayout.setVerticalGroup(
            emergencyFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(emergencyFormPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(emergencyFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(callerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(emergencyFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(callerPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(emergencyFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emergencyType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(emergencyFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emergencyLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(reportEmergencyButton1)
                .addContainerGap())
        );

        emergencyList.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        activeEmergencyList.setModel(listModel);
        activeEmergencyList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                emergencyListSelected(evt);
            }
        });
        emergencyListPane.setViewportView(activeEmergencyList);

        javax.swing.GroupLayout emergencyListLayout = new javax.swing.GroupLayout(emergencyList);
        emergencyList.setLayout(emergencyListLayout);
        emergencyListLayout.setHorizontalGroup(
            emergencyListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(emergencyListPane)
        );
        emergencyListLayout.setVerticalGroup(
            emergencyListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(emergencyListPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
        );

        viewMenu.setText("Views");

        dispatchViewMenuItem.setText("Dispatch View");
        dispatchViewMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dispatchViewMenuItemActionPerformed(evt);
            }
        });
        viewMenu.add(dispatchViewMenuItem);

        responderViewMenuItem.setText("Responder View");
        responderViewMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                responderViewMenuItemActionPerformed(evt);
            }
        });
        viewMenu.add(responderViewMenuItem);

        adminViewMenuItem.setText("Admin View");
        viewMenu.add(adminViewMenuItem);

        jMenuBar1.add(viewMenu);

        editMenu.setText("Edit");
        jMenuBar1.add(editMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(emergencyFormPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(emergencyList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(emergencyDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(emergencyFormPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(emergencyList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emergencyDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void reportEmergencyButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportEmergencyButton1MouseClicked
        // TODO add your handling code here:
        String name = callerName.getText();
        String phone = callerPhone.getText();
        String type = emergencyType.getSelectedItem().toString();
        String location = emergencyLocation.getText();
        Emergency emergency = emergencyController.createEmergency(type, name, phone, location);
        // TODO pop up to state emergency created
        // TODO update EmergencyList
        listModel.add(index++, emergency);
        //activeEmergencyList = new JList(model);
        //activeEmergencyList.repaint();
        
        // Reset the text fields.
        callerName.setText(null);
        callerPhone.setText(null);
        emergencyLocation.setText(null);
    }//GEN-LAST:event_reportEmergencyButton1MouseClicked

    private void emergencyListSelected(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_emergencyListSelected
        // TODO add your handling code here:
        Emergency emergencyInstance = (Emergency)activeEmergencyList.getSelectedValue();
        callerNameDetail.setText(emergencyInstance.getCallerName());
        callerPhoneDetail.setText(emergencyInstance.getCallerPhone());
        emergencyTypeDetail.setSelectedItem(emergencyInstance.getType());
        emergencyLocationDetail.setText(emergencyInstance.getLocation());
        
    }//GEN-LAST:event_emergencyListSelected

    private void responderViewMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_responderViewMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_responderViewMenuItemActionPerformed

    private void dispatchViewMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dispatchViewMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dispatchViewMenuItemActionPerformed

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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }
 
    private DefaultListModel<Emergency> listModel = new DefaultListModel<>();
    private int index = 0;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList activeEmergencyList;
    private javax.swing.JMenuItem adminViewMenuItem;
    private javax.swing.JTextField callerName;
    private javax.swing.JTextField callerNameDetail;
    private javax.swing.JLabel callerNameDetailLabel;
    private javax.swing.JTextField callerPhone;
    private javax.swing.JTextField callerPhoneDetail;
    private javax.swing.JLabel callerPhoneDetailLabel;
    private javax.swing.JMenuItem dispatchViewMenuItem;
    private javax.swing.JMenu editMenu;
    private javax.swing.JPanel emergencyDetails;
    private javax.swing.JPanel emergencyFormPanel;
    private javax.swing.JPanel emergencyList;
    private javax.swing.JScrollPane emergencyListPane;
    private javax.swing.JTextField emergencyLocation;
    private javax.swing.JTextField emergencyLocationDetail;
    private javax.swing.JLabel emergencyLocationDetailLabel;
    private javax.swing.JComboBox emergencyType;
    private javax.swing.JComboBox emergencyTypeDetail;
    private javax.swing.JLabel emergencyTypeDetailLabel;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JButton reportEmergencyButton1;
    private javax.swing.JMenuItem responderViewMenuItem;
    private javax.swing.JMenu viewMenu;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
