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
import model.Producto;
import servicios.Fachada;

/**
 *
 * @author mavel
 */
public class ProductoDAO {
     public ProductoDAO() {
    }
    
    /**
     * 
     * @param p Objeto de la clase Programa a grabar
     * @return rtdo resultado de la operación grbar
     */
    public int grabarProducto(Producto prod){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "INSERT INTO producto values (?,?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, prod.getIdProductos());
            pstm.setString(2, prod.getNombreProd());
            pstm.setDouble(3,prod.getPrecio());
            pstm.setString(4, prod.getDescripcion());
            pstm.setDouble(5, prod.getPorcentaje_comision());
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"idproductos : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"idproductos : " + 
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
    public int modificarProducto(Producto prod){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "UPDATE producto " +
                         "SET nombreproducto = ?, precio = ?, descripcion = ? "
                    + " porcentaje_comision = ? "
                    +    "WHERE idproductos=?";
            pstm = con.prepareStatement(sql);            
            pstm.setInt(1, prod.getIdProductos());
            pstm.setString(2, prod.getNombreProd());
            pstm.setDouble(3,prod.getPrecio());
            pstm.setString(4, prod.getDescripcion());
            pstm.setDouble(5, prod.getPorcentaje_comision());
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"idproductos : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"idproductos : " + 
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
    public int borrarProducto(String id){      
        Connection con = null;
        PreparedStatement pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "DELETE FROM producto WHERE idproductos = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, id);
            rtdo = pstm.executeUpdate(); 
            return rtdo;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"idproductos : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        } 
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"idproductos : " + 
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
    public ArrayList<Producto> listadoProducto(String id){      
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Producto> listado = new ArrayList<>();
        try{
            con = Fachada.getConnection();
            String sql="";
            if(id.equalsIgnoreCase("0")){
                sql = "SELECT * FROM producto ORDER BY idproductos";            
            }else{
                sql = "SELECT * FROM producto where idproductos = ? "
                    + "ORDER BY idproductos";      
            }                        
            pstm = con.prepareStatement(sql);
            
            if(id != "0"){
                pstm.setString(1, id);
            }
            
            rs = pstm.executeQuery();
                        
            Producto producto = null;
            while(rs.next()){
                producto = new Producto();
                producto.setIdProductos(rs.getInt("idproductos"));
                producto.setNombreProd(rs.getString("nombreproducto"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setDescripcion(rs.getString("descripcion")); 
                producto.setPorcentaje_comision(rs.getInt("porcentaje_comision")); 
                listado.add(producto);
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"idproductos : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        finally{
            try{
                if(rs!=null) rs.close();
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"idproductos : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
            }
        }
        return listado;
    }
    
     
     
     
}
