/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Vista.ClienteIG;
import Vista.Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.ModeloVista;

/**
 *
 * @author D4K4R
 */
public class VistaController implements ActionListener{

    public Vista laVista = new Vista();
    public ModeloVista elModeloVista = new ModeloVista();
    
    public VistaController(Vista laVista, ModeloVista elModeloVista){
        this.laVista = laVista;
        this.elModeloVista = elModeloVista;
        this.laVista.btnChat.addActionListener(this);
        this.laVista.jMenuItem1.addActionListener(this);
        
    }
    
   
    public void actionPerformed(ActionEvent ae) {
      
        Object evt = ae.getSource();

        if(evt.equals(this.laVista.btnChat)){
            
            elModeloVista.btnChatAction();
        
        }
        else if(evt.equals(this.laVista.jMenuItem1)) {
            
            System.out.println("Yaii");
            
            ClienteIG ventanaCliente = new ClienteIG();
            ventanaCliente.setVisible(true);
        }
          
    
    }}
    


