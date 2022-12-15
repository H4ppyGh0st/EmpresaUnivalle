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
import model.Vendedor;
import servicios.Fachada;

/**
 *
 * @author mavel
 */
public class VendedorDAO {
     public VendedorDAO() {
    }
     
     /**
     * 
     * @param p Objeto de la clase Programa a grabar
     * @return rtdo resultado de la operación grbar
     */
    public int grabarVendedor(Vendedor vend){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "INSERT INTO vendedor values (?,?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, vend.getNombre());
            pstm.setString(2, vend.getDireccion());
            pstm.setInt(3,vend.getId());
            pstm.setInt(4, vend.getTipo_producto());
            pstm.setInt(5, vend.getNumeroVenta());
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"idvendedor : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"idvendedor : " + 
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
    public int modificarVendedor(Vendedor vend){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "UPDATE vendedor " +
                         "SET nombre = ?, direccion = ?,"
                    + " cantidad_Productos = ?, numero_Venta = ? "
                    +    "WHERE idvendedor=?";
            pstm = con.prepareStatement(sql);            
            pstm.setString(1, vend.getNombre());
            pstm.setString(2, vend.getDireccion());
            pstm.setInt(3,vend.getId());
            pstm.setInt(4, vend.getTipo_producto());
            pstm.setInt(5, vend.getNumeroVenta());
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"idvendedor : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"idvendedor : " + 
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
    public int borrarVendedor(String id){      
        Connection con = null;
        PreparedStatement pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "DELETE FROM vendedor WHERE idvendedor = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, id);
            rtdo = pstm.executeUpdate(); 
            return rtdo;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"idvendedor : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        } 
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"idvendedor : " + 
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
    public ArrayList<Vendedor> listadoVendedor(String id){      
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Vendedor> listado = new ArrayList<>();
        try{
            con = Fachada.getConnection();
            String sql="";
            if(id.equalsIgnoreCase("0")){
                sql = "SELECT * FROM vendedor ORDER BY idvendedor";            
            }else{
                sql = "SELECT * FROM vendedor where idvendedor = ? "
                    + "ORDER BY idvendedor";      
            }                        
            pstm = con.prepareStatement(sql);
            
            if(id != "0"){
                pstm.setString(1, id);
            }
            
            rs = pstm.executeQuery();
                        
            Vendedor vendedor = null;
            while(rs.next()){
                vendedor = new Vendedor();
                vendedor.setNombre(rs.getString("Nombre"));
                vendedor.setDireccion(rs.getString("Direccion"));
                vendedor.setId(rs.getInt("idvendedor"));
                vendedor.setTipo_producto(rs.getInt("tipo_producto"));
                vendedor.setNumeroVenta(rs.getInt("numero_Venta"));
                listado.add(vendedor);
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"idvendedor : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        finally{
            try{
                if(rs!=null) rs.close();
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"idvendedor : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
            }
        }
        return listado;
    }

    
    
    
    
    
}
