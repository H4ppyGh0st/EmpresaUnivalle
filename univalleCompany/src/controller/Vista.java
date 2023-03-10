/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import javax.swing.JOptionPane;
import Vista.ClienteIG;
import dao.ClientesDAO;
import controller.ClienteController;




/**
 *
 * @author D4K4R
 */
public class Vista extends javax.swing.JFrame   {

    
   

    
    public Vista() {
        
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

        panelPrincipal = new javax.swing.JPanel();
        jToolBar2 = new javax.swing.JToolBar();
        btnInicio = new javax.swing.JButton();
        btnChat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelPrincipal.setLayout(new java.awt.BorderLayout());
        getContentPane().add(panelPrincipal, java.awt.BorderLayout.CENTER);

        jToolBar2.setRollover(true);

        btnInicio.setText("Inicio");
        btnInicio.setFocusable(false);
        btnInicio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnInicio.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });
        jToolBar2.add(btnInicio);

        btnChat.setText("chat");
        btnChat.setFocusable(false);
        btnChat.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnChat.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnChat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChatActionPerformed(evt);
            }
        });
        jToolBar2.add(btnChat);

        getContentPane().add(jToolBar2, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChatActionPerformed
    
    }//GEN-LAST:event_btnChatActionPerformed

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        // TODO add your handling code here:
        
        ClienteIG clienteView = new ClienteIG();
        ClientesDAO clienteModel = new ClientesDAO();
        
        ClienteController clienteController = 
                new ClienteController(clienteView, clienteModel);
        
        int x = (panelPrincipal.getWidth() / 2) - clienteView.getWidth() /2;
        int y = (panelPrincipal.getHeight() / 2) - clienteView.getHeight() /2;

        if (clienteView.isShowing()){
            clienteView.setLocation(x,y);
        }
        else{
            panelPrincipal.add(clienteView);
            clienteView.setLocation(x,y);
            clienteView.setVisible(true);
        }
    }//GEN-LAST:event_btnInicioActionPerformed

     
        
        
        
        
    
    
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnChat;
    public javax.swing.JButton btnInicio;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables


}
