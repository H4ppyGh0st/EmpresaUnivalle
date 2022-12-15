/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;


import controller.ChatClienteController;
import model.ModeloChatCliente;

/**
 *
 * @author D4K4R
 */
public class ProcesoChatCliente extends Thread {
    
  
    public ProcesoChatCliente(String msg){
     super(msg); 
    }
    
    public void run(){
        
      
        
        FrameChatCliente unFrameChatCliente = new FrameChatCliente();
        ModeloChatCliente elModeloChatCliente = new ModeloChatCliente(unFrameChatCliente.msg_area, unFrameChatCliente.msg_text);
        ChatClienteController controladorCliente = new ChatClienteController(unFrameChatCliente,elModeloChatCliente);
        unFrameChatCliente.setVisible(true);
        controladorCliente.iniciar();
        

    
    }
    
    
    
    
}
 