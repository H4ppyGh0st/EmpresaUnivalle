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
import model.Comercializacion;
import servicios.Fachada;

/**
 *
 * @author mavel
 */
public class ComercializacionDAO {
    
     public ComercializacionDAO() {
    }
    
     /**
     * 
     * @param p Objeto de la clase Programa a grabar
     * @return rtdo resultado de la operación grabar
     */
    public int grabarComercializacion(Comercializacion comerc){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "INSERT INTO comercializacion values (?,?,?,?,?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, comerc.getIdCliente_Com());
            pstm.setDouble(2,comerc.getPrecio_Com());
            pstm.setString(3, comerc.getVendedor());
            pstm.setInt(4, comerc.getCantidad_Com());
            pstm.setInt(5, comerc.getNumeroFactura());
            pstm.setString(6, comerc.getDireccionVenta());
            pstm.setInt(7, comerc.getComision_venta());
            pstm.setInt(8, comerc.getId_producto_com());




            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"numerofactura : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"numerofactura : " + 
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
    public int modificarComercializacion(Comercializacion comerc){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "UPDATE comercializacion " +
                         "SET idcliente_com = ?, precio_com = ?,vendedor=? "
                    + " cantidad_com= ?, direccionventa = ?,"
                    + "comision_venta=? , id_producto_com=? "
                    +    "WHERE numerofactura=?";
            pstm = con.prepareStatement(sql);            
            pstm.setInt(1, comerc.getIdCliente_Com());
            pstm.setDouble(2,comerc.getPrecio_Com());
            pstm.setString(3, comerc.getVendedor());
            pstm.setInt(4, comerc.getCantidad_Com());
            pstm.setInt(5, comerc.getNumeroFactura());
            pstm.setString(6, comerc.getDireccionVenta());
            pstm.setInt(7, comerc.getComision_venta());
            pstm.setInt(8, comerc.getId_producto_com());
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"numerofactura : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"numerofactura : " + 
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
    public int borrarComercializacion(String id){      
        Connection con = null;
        PreparedStatement pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "DELETE FROM Comercializacion WHERE numerofactura = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, id);
            rtdo = pstm.executeUpdate(); 
            return rtdo;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"numerofactura : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        } 
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"numerofactura : " + 
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
    public ArrayList<Comercializacion> listadoComercializacion(String id){      
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Comercializacion> listado = new ArrayList<>();
        try{
            con = Fachada.getConnection();
            String sql="";
            if(id.equalsIgnoreCase("0")){
                sql = "SELECT * FROM comercializacion ORDER BY numerofactura";            
            }else{
                sql = "SELECT * FROM comercializacion where numerofactura = ? "
                    + "ORDER BY numerofactura";      
            }                        
            pstm = con.prepareStatement(sql);
            
            if(id != "0"){
                pstm.setString(1, id);
            }
            
            rs = pstm.executeQuery();
                        
            Comercializacion comercializacion = null;
            while(rs.next()){
                comercializacion = new Comercializacion();
                comercializacion.setIdCliente_Com(rs.getInt("idcliente_com"));
                comercializacion.setPrecio_Com(rs.getDouble("precio_com"));
                comercializacion.setVendedor(rs.getString("vendedor"));
                comercializacion.setNumeroFactura(rs.getInt("numerofactura"));
                comercializacion.setCantidad_Com(rs.getInt("cantidad_com")); 
                comercializacion.setDireccionVenta(rs.getString("direccionventa"));
                comercializacion.setComision_venta(rs.getInt("comision_venta"));
                comercializacion.setId_producto_com(rs.getInt("id_producto_com"));


                listado.add(comercializacion);
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"numerofactura : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        finally{
            try{
                if(rs!=null) rs.close();
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"numerofactura : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
            }
        }
        return listado;
    }

     
     
}
