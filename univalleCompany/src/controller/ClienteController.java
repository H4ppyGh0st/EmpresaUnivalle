/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Vista.ClienteIG;
import dao.ClientesDAO;
import model.Cliente;


/**
 *
 * @author mavel
 */
public class ClienteController {
    
    private ClienteIG vista;
    private ClientesDAO modelo;
    
    
    public ClienteController(ClienteIG vista, ClientesDAO modelo) {
        this.vista = vista;
        this.modelo = modelo;
        
        this.vista.addListenerBtnNuevo(new ClienteListener());
        this.vista.addListenerBtnModificar(new ClienteListener());        
        this.vista.addListenerBtnBorrar(new ClienteListener());
        this.vista.addListenerBtnCerrar(new ClienteListener());
        
        ArrayList<Cliente> listadoCliente;
        listadoCliente = this.modelo.listadoCliente("0");
        this.vista.cargarClientes(listadoCliente); }
    
    
    class ClienteListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            if(e.getActionCommand().equalsIgnoreCase("nuevo")){
                vista.nuevoAction();
            }else if(e.getActionCommand().equalsIgnoreCase("cancelar")){
                vista.nuevoAction();
            }else if(e.getActionCommand().equalsIgnoreCase("modificar")){
                vista.modificarAction();
            }else if(e.getActionCommand().equalsIgnoreCase("salir")){
                vista.cerrarAction();
            }else if(e.getActionCommand().equalsIgnoreCase("grabar")){     
                registrar();
            }else if(e.getActionCommand().equalsIgnoreCase("borrar")){
                borrar();
            }else if(e.getActionCommand().equalsIgnoreCase("actualizar")){
                actualizar();
            }
        }
      private void registrar(){
            if(vista.getId() == 0){
                vista.gestionMensajes("Ingrese el código",
                        "Error de Entrada", JOptionPane.ERROR_MESSAGE);                        
            }else{
                Cliente cliente = new Cliente();
                cliente.setId(vista.getId());
                cliente.setNombre(vista.getNombre());
                cliente.setEdad(vista.getEdad());
                cliente.setDireccion(vista.getDireccion());

                int tamaño;
                tamaño = modelo.listadoCliente(cliente.getNombre()).size();

                if(tamaño == 0){
                    int resultado = 0;
                    resultado = modelo.grabarCliente(cliente);
                    if(resultado == 1){
                        vista.gestionMensajes("Registro Grabado con éxito", 
                                "Confirmación",JOptionPane.INFORMATION_MESSAGE); 
                        
                        ArrayList<Cliente> listadoProgramas;
                        listadoProgramas = modelo.listadoCliente("0");
                        vista.cargarClientes(listadoProgramas);

                        vista.activarControles(false); 
                        vista.nuevoAction();
                    }
                    else{
                        vista.gestionMensajes("Error al grabar",
                                "Confirmación",JOptionPane.ERROR_MESSAGE);                                                 
                    }
                }else{
                    vista.gestionMensajes("Codigo ya está registrado",
                            "Confirmación",
                            JOptionPane.ERROR_MESSAGE);                                      
                }
            }                                               
        }
        
       private void borrar(){
            String iD = "";
            iD  = vista.getNombre().trim();
            
            if(iD.isEmpty()){
                 vista.gestionMensajes(
                         "Por favor seleccione un programa de la tabla",
                         "Mensaje de Advertencia ", 
                    JOptionPane.ERROR_MESSAGE);
            }else{
                int respuesta = JOptionPane.showConfirmDialog(null,
                        "¿Desea Eliminar el programa de codigo : " +
                        iD + " ?", 
                        "Confirmación de Acción", JOptionPane.YES_NO_OPTION);
                
                if(respuesta == JOptionPane.YES_OPTION){                    

                    if(modelo.borrarCliente(iD) ==  1){
                        JOptionPane.showMessageDialog(null, 
                                "Registro Borrado con éxtio", 
                                "Confirmación de acción", 
                                JOptionPane.INFORMATION_MESSAGE);                    
                       
                        ArrayList<Cliente> listadoCliente; 
                        listadoCliente = modelo.listadoCliente("0");
                        vista.cargarClientes(listadoCliente);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, 
                                "Error al borrar",
                                "Confirmación de acción", 
                                JOptionPane.ERROR_MESSAGE);                    
                    }
                }
            }
        }  
        
        private void actualizar(){
             
            Cliente cliente = new Cliente();
             

            cliente.setId(vista.getId());
                cliente.setNombre(vista.getNombre());
                cliente.setEdad(vista.getEdad());
                cliente.setDireccion(vista.getDireccion());     
                         
            if(modelo.modificarCliente(cliente) == 1){
                vista.gestionMensajes(
                        "Actualización exitosa",
                        "Confirmación ", 
                        JOptionPane.INFORMATION_MESSAGE);
                                        
                vista.activarControles(false); 
                vista.nuevoAction();
                ArrayList<Cliente> listadoProgramas; 
                listadoProgramas = modelo.listadoCliente("0");
                vista.cargarClientes(listadoProgramas);           
            } else {
                vista.gestionMensajes(
                        "Actualización Falida",
                        "Confirmación ", 
                        JOptionPane.ERROR_MESSAGE);                 
            }              
        } 
    }
        
    
}
