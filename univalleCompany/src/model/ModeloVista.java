/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import Vista.ProcesoChatCliente;
import Vista.ProcesoChatServidor;

/**
 *
 * @author D4K4R
 */
public class ModeloVista {
    
    public ModeloVista(){
    
    }
    
public void btnChatAction() {                                        
       Thread hilo = new ProcesoChatServidor("proceso1");
       Thread hilo2 = new ProcesoChatCliente("proceso2");
       
       hilo.start();
       hilo2.start();
    }                                       

    
}
