/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;


import controller.ChatServidorController;
import model.ModeloChatServidor;
/**
 *
 * @author D4K4R
 */


public class ProcesoChatServidor extends Thread {
    
    
    
  
    
    public ProcesoChatServidor(String msg){
     super(msg); 
    }
    
    public void run(){
     
 
          FrameChatServidor elFrameServidor = new FrameChatServidor();
          ModeloChatServidor elModeloChatServer = new ModeloChatServidor(elFrameServidor.msg_area, elFrameServidor.msg_text);
          ChatServidorController controladorServer = new ChatServidorController(elFrameServidor,elModeloChatServer);
          elFrameServidor.setVisible(true);
          controladorServer.iniciar();
        

        

    
    }
    
    
}

