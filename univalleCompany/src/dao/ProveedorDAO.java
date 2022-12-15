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
import model.Proveedor;
import servicios.Fachada;

/**
 *
 * @author mavel
 */
public class ProveedorDAO {
    
      public ProveedorDAO() {
    }
    
        /**
     * 
     * @param p Objeto de la clase Programa a grabar
     * @return rtdo resultado de la operación grbar
     */
    public int grabarProveedor(Proveedor prov){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "INSERT INTO proveedor values (?,?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, prov.getNombre());
            pstm.setString(2, prov.getDireccion());
            pstm.setInt(3,prov.getId());
            pstm.setString(4, prov.getNombreInsumo());
            pstm.setInt(5, prov.getNumero_venta());
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"idproveedor : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"idproveedor : " + 
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
    public int modificarProveedor(Proveedor prov){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "UPDATE proveedor " +
                         "SET nombre = ?, direccion = ?,"
                    + " nombre_Insumo = ?, numero_venta = ? "
                    +    "WHERE idproveedor=?";
            pstm = con.prepareStatement(sql);            
            pstm.setString(1, prov.getNombre());
            pstm.setString(2, prov.getDireccion());
            pstm.setInt(3,prov.getId());
            pstm.setString(4, prov.getNombreInsumo());
            pstm.setInt(5, prov.getNumero_venta());
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"idproveedor : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"idproveedor : " + 
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
    public int borrarProveedor(String id){      
        Connection con = null;
        PreparedStatement pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "DELETE FROM proveedor WHERE idproveedor = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, id);
            rtdo = pstm.executeUpdate(); 
            return rtdo;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"idproveedor : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        } 
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"idproveedor : " + 
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
    public ArrayList<Proveedor> listadoProveedor(String id){      
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Proveedor> listado = new ArrayList<>();
        try{
            con = Fachada.getConnection();
            String sql="";
            if(id.equalsIgnoreCase("0")){
                sql = "SELECT * FROM proveedor ORDER BY idproveedor";            
            }else{
                sql = "SELECT * FROM proveedor where idproveedor = ? "
                    + "ORDER BY idproveedor";      
            }                        
            pstm = con.prepareStatement(sql);
            
            if(id != "0"){
                pstm.setString(1, id);
            }
            
            rs = pstm.executeQuery();
                        
            Proveedor proveedor = null;
            while(rs.next()){
                proveedor = new Proveedor();
                proveedor.setNombre(rs.getString("Nombre"));
                proveedor.setDireccion(rs.getString("Direccion"));
                proveedor.setId(rs.getInt("idproveedor"));
                proveedor.setNombreInsumo(rs.getString("nombre_Insumo"));
                proveedor.setNumero_venta(rs.getInt("numero_venta"));
                listado.add(proveedor);
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"idproveedor : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        finally{
            try{
                if(rs!=null) rs.close();
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"idproveedor : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
            }
        }
        return listado;
    }
    
    
      
}
