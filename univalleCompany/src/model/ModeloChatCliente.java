/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 *
 * @author D4K4R
 */
public class ModeloChatCliente {
    
    static Socket s;
    static DataInputStream din;
    static DataOutputStream dout;
    public javax.swing.JTextArea msg_area;
    public javax.swing.JTextField msg_text;
    
    public ModeloChatCliente(javax.swing.JTextArea msg_area, javax.swing.JTextField msg_text){
        
        this.msg_area = msg_area;
        this.msg_text = msg_text;
    }
    
    //sobrecarga paara el hilo
    public ModeloChatCliente(){
    
    }
    
    
    public void accion(){
     
        
        //el bucle solo se romperá cuando el servidor este activo
        boolean confirmacion = false;
        while(confirmacion  == false){
        try{
        String msgin = "";
        
        //uso de la ip local y puerto 1201 para la conexion de el cliente
        InetAddress miDireccionLocal = InetAddress.getLocalHost();
        String miIp = miDireccionLocal.getHostAddress();
        System.out.println(miIp);
        s = new Socket(miIp,1201);
        din = new DataInputStream(s.getInputStream());
        dout = new DataOutputStream(s.getOutputStream());
        
        confirmacion = true;
        System.out.print("cliente conectado");
        
        
        while(!msgin.equals("exit")){
            msgin = din.readUTF();
            msg_area.setText(msg_area.getText().trim()+"\nServidor: " + msgin );
            
            
        }
        
        
        
        
        
        }catch(Exception e){
            System.out.print(e);
        }
        }
    
        
        
    }
    
    public void msg_sendAction() {                                         
        try{
            
         //obtener el texto de el campo de texto y enviarlo
          String msgout = "";
          msgout = msg_text.getText().trim();
          dout.writeUTF(msgout);
          System.out.println("se Envio");
          msg_area.setText(msg_area.getText().trim()+"\nCliente: " + msgout );
          this.almacenarChat();
          msg_text.setText("");
          
          
        }catch(Exception i){
            System.out.print("estoy en el boton cliente");
        }
    }
    
    
    public void almacenarChat(){
        
        
          try {
            String ruta = "registro.txt";
            String contenido = "Cliente: " + msg_text.getText();
            File archivo = new File(ruta);
            
            if (!archivo.exists()) {
                archivo.createNewFile();
            }
        
            FileWriter escribirArchivo = new FileWriter(archivo,true);
            BufferedWriter buffer = new BufferedWriter(escribirArchivo);
            buffer.write(contenido);
            buffer.newLine();
            buffer.close();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}

