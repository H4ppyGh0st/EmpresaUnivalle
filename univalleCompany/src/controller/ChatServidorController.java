/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Vista.FrameChatServidor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.ModeloChatServidor;

/**
 *
 * @author D4K4R
 */
public class ChatServidorController implements ActionListener{
    
    public FrameChatServidor elFrameServidor = new FrameChatServidor();
    public ModeloChatServidor elModeloServidor = new ModeloChatServidor(this.elFrameServidor.msg_area, this.elFrameServidor.msg_text);
    
    public ChatServidorController(FrameChatServidor elFrameServidor, ModeloChatServidor elModeloServidor ){
        
        this.elFrameServidor = elFrameServidor;
        this.elModeloServidor = elModeloServidor;
        this.elFrameServidor.msg_send.addActionListener(this);
     
        
        
    }
    
    
    public void actionPerformed(ActionEvent ae) {
        
        Object evt = ae.getSource();

        if (evt.equals(this.elFrameServidor.msg_send)) {
            elModeloServidor.msg_sendActionPerformed();

        }

    }
    
    public void iniciar(){
        elModeloServidor.accion();
    }
    
}
