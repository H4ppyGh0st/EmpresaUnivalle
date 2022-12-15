/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author mavel
 */
public class Conexion {
    //String de conexion
        
        //url: programa:// conexion local: puerto / nombre de la base de datos en postgres
        String dbUrl = "jdbc:postgresql://localhost:5432/EmpresaUnivalle"; 
        String user = "postgres"; //Usuario
        String pass = "--";//contraseña
        
       public static Statement stmt, stmt1;
        Connection con = null; // establecer una conexion
 
        public static ResultSet result,result1;

        
        public void connectDatabase(String database,
            String user, String pass) {
        try {
      
            Connection connection = null;
            // Se conecta con la base de datos
            connection = DriverManager.getConnection(dbUrl, user, pass);
 
            
            boolean valid = connection.isValid(50000);
            System.out.println(valid ? "TEST OK" : "TEST FAIL");
            stmt=con.createStatement(result.TYPE_SCROLL_SENSITIVE,result.CONCUR_UPDATABLE);

            
            
        } catch (java.sql.SQLException sqle) {
            System.out.println("Error: " + sqle);
        }
    }
        
        
        // public static ResultSet consulta(String sql)throws SQLException{

        //stmt1 = (Statement) con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        //result1 = stmt1.executeQuery(sql);//aqui hago consultas y devuelvo los resultados
       // return result1;
        
        
//}
}
