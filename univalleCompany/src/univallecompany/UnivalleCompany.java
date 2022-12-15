/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package univallecompany;


import Vista.Vista;
import controller.VistaController;
import model.ModeloVista;


/**
 *
 * @author D4K4R
 */
public class UnivalleCompany {

    

    public static void main(String[] args) throws InterruptedException {
        
      
        
        //Inicializador de la vista principal
        
        Vista pestaña  = new Vista();
        ModeloVista elModeloVista = new ModeloVista();
        VistaController contraladorVista = new VistaController(pestaña,elModeloVista);
        pestaña.setVisible(true);
        pestaña.setSize(700,500);
        

                

    }
    
}
