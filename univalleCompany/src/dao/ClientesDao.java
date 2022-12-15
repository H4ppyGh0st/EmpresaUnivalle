/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Cliente;
import servicios.Fachada;

/**
 *
 * @author usuario
 */
public class ClientesDao {
     public ClientesDao() {
    }
    
     
     /**
     * 
     * @param p Objeto de la clase Programa a grabar
     * @return rtdo resultado de la operación grbar
     */
    public int grabarCliente(Cliente clie){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "INSERT INTO cliente values (?,?,?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, clie.getNombre());
            pstm.setString(2, clie.getDireccion());
            pstm.setInt(3,clie.getId());
            pstm.setInt( 4, clie.getEdad());
            pstm.setInt(5, clie.getCantidadPedido());
            pstm.setString(6, clie.getTipoPago());
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"idCliente : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"idCliente : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
            }
        }
        return rtdo;
    }
    
    /**
     * 
     * @param p Objeto de la clase Programa a grabar
     * @return rtdo resultado de la operación modificar
     */
    public int modificarCliente(Cliente clie){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "UPDATE cliente " +
                         "SET nombre = ?, direccion = ?, edad = ? "
                    + " cantidadPedido = ?, tipoPago = ? "
                    +    "WHERE idCliente=?";
            pstm = con.prepareStatement(sql);            
            pstm.setString(1, clie.getNombre());
            pstm.setString(2, clie.getDireccion());
            pstm.setInt(3,clie.getId());
            pstm.setInt( 4, clie.getEdad());
            pstm.setInt(5, clie.getCantidadPedido());
            pstm.setString(6, clie.getTipoPago());
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"idCliente : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"idCliente : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
            }
        }
        return rtdo;
    }
    
     /**
     * 
     * @param codigo código del programa a borrar
     * @return rtdo resultado de la operación borrar
     */
    public int borrarCliente(String id){      
        Connection con = null;
        PreparedStatement pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "DELETE FROM cliente WHERE idCliente = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, id);
            rtdo = pstm.executeUpdate(); 
            return rtdo;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"idCliente : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        } 
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"idCliente : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
            }
        }
        return rtdo;
    }
     /**
     * 
     * @param codigo codigo del programa a listar, 0 se listaran todos
     * @return ArrayList, lista de objetos Programa
     */
    public ArrayList<Cliente> listadoCliente(String id){      
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Cliente> listado = new ArrayList<>();
        try{
            con = Fachada.getConnection();
            String sql="";
            if(id.equalsIgnoreCase("0")){
                sql = "SELECT * FROM cliente ORDER BY idCliente";            
            }else{
                sql = "SELECT * FROM cliente where idCliente = ? "
                    + "ORDER BY idCliente";      
            }                        
            pstm = con.prepareStatement(sql);
            
            if(id != "0"){
                pstm.setString(1, id);
            }
            
            rs = pstm.executeQuery();
                        
            Cliente cliente = null;
            while(rs.next()){
                cliente = new Cliente();
                cliente.setNombre(rs.getString("Nombre"));
                cliente.setDireccion(rs.getString("Direccion"));
                cliente.setId(rs.getInt("idCliente"));
                cliente.setEdad(rs.getInt("Edad")); ;
                cliente.setCantidadPedido(rs.getInt("cantidadPedido")); 
                cliente.setTipoPago(rs.getString("tipoPago"));
                listado.add(cliente);
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"idCliente : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        finally{
            try{
                if(rs!=null) rs.close();
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"idCliente : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
            }
        }
        return listado;
    }
    
    
}
