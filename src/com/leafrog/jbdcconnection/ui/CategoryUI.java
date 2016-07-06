/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leafrog.jbdcconnection.ui;

import com.leafrog.jbdcconnection.dao.CategoryDAO;
import com.leafrog.jbdcconnection.dao.impl.CategoryDAOImpl;
import com.leafrog.jbdcconnection.entity.Category;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author sony
 */
public class CategoryUI extends javax.swing.JFrame {
    private CategoryDAO categoryDAO=new CategoryDAOImpl();

    /**
     * Creates new form CategoryUI
     */
    public CategoryUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtName = new javax.swing.JTextField();
        chkStatus = new javax.swing.JCheckBox();
        btnSave = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        chkStatus.setText("Status");

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnupdate.setText("Update");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btndelete.setText("Delete");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(chkStatus))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(btnSave)
                        .addGap(18, 18, 18)
                        .addComponent(btnupdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btndelete)))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(chkStatus)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnupdate)
                    .addComponent(btndelete))
                .addContainerGap(160, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try{
        
        int result=categoryDAO.insert(new Category(1, txtName.getText(), chkStatus.isSelected()));
        if(result>0){
        JOptionPane.showMessageDialog(null,"Insert Sucessfully");
        }
        }catch (ClassNotFoundException | SQLException ce) {
            System.out.println(ce.getMessage());
            JOptionPane.showMessageDialog(null, ce.getMessage());
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
       try{
        
        int result=categoryDAO.Update(new Category(1, txtName.getText(), chkStatus.isSelected()));
        if(result>0){
        JOptionPane.showMessageDialog(null,"Update Sucessfully");
        }
        }catch (ClassNotFoundException | SQLException ce) {
            System.out.println(ce.getMessage());
            JOptionPane.showMessageDialog(null, ce.getMessage());
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
       try{
        
        int result=categoryDAO.Delete(new Category(1,txtName.getText(), chkStatus.isSelected()));
        
        if(result>0){
        JOptionPane.showMessageDialog(null,"DELETE Sucessfully");
        }
        }catch ( SQLException ce) {
            System.out.println(ce.getMessage());
            JOptionPane.showMessageDialog(null, ce.getMessage());
        }
    }//GEN-LAST:event_btndeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnupdate;
    private javax.swing.JCheckBox chkStatus;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
