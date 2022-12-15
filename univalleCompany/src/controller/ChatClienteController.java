/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Vista.FrameChatCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.ModeloChatCliente;

/**
 *
 * @author D4K4R
 */
public class ChatClienteController implements ActionListener{
    
    public FrameChatCliente elFrameCliente = new FrameChatCliente();
    public ModeloChatCliente elModeloCliente = new ModeloChatCliente(this.elFrameCliente.msg_area, this.elFrameCliente.msg_text);
    
    public ChatClienteController(FrameChatCliente elFrameCliente, ModeloChatCliente elModeloCliente ){
        
        this.elFrameCliente = elFrameCliente;
        this.elModeloCliente = elModeloCliente;
        this.elFrameCliente.msg_send.addActionListener(this);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        
        elModeloCliente.msg_sendAction();
      
    }
    
    
    public void iniciar(){
        
         elModeloCliente.accion();
    }
    
}
