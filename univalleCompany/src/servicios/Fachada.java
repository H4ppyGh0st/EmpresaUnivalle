/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import java.sql.*;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;

/**
 *
 * @author mavel
 */
public class Fachada {
     private static Connection con = null;
    
    public static Connection getConnection(){
        try
        {
            if(con == null){
                //Determina cuando se termina el programa
                Runtime.getRuntime().addShutdownHook(new MiShDwnHook());
                //Recupera los parámetros de conexión del archivo 
                //jdbc.properties
                ResourceBundle rb = ResourceBundle.getBundle("servicios.jdbc");
                String driver = rb.getString("driver");
                String url = rb.getString("url");
                String pwd = rb.getString("pwd");
                String usr = rb.getString("usr");
                
                Class.forName(driver);
                con = DriverManager.getConnection(url, usr, pwd);
            }
                         
        }
        catch(ClassNotFoundException | SQLException ex){
            JOptionPane.showMessageDialog(null,"Error  : " + 
                    ex.getMessage());
        }
        return con;
    }
    
    static class MiShDwnHook extends Thread{
        //Justo antes de finaliza el programa la JVM invocará
        //este método donde podemos cerra la conexión
        @Override
        public void run(){
            try{
                Connection con = Fachada.getConnection();
                con.close();                     
            }
            catch (SQLException ex){
                JOptionPane.showMessageDialog(null,"Error : " + 
                        ex.getMessage());
            }
        }
    }
}
