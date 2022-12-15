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
import model.Fabricacion;
import servicios.Fachada;

/**
 *
 * @author mavel
 */
public class FabricacionDAO {
     public FabricacionDAO() {
    }
    
     
     /**
     * 
     * @param p Objeto de la clase Programa a grabar
     * @return rtdo resultado de la operación grabar
     */
    public int grabarFabricacion(Fabricacion fabri){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "INSERT INTO Fabricacion values (?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, fabri.getIdProducto_Fab());
            pstm.setString(2, fabri.getMateriaPrima());
            pstm.setString(3, fabri.getProducto());
            pstm.setInt(4, fabri.getCantidad());
            pstm.setInt(5, fabri.getId());

            rtdo = pstm.executeUpdate();  
            
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"id : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"id : " + 
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
    public int modificarFabricacion(Fabricacion fabri){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "UPDATE Fabricacion " +
                         "SET idproducto_fab = ?, materia_prima = ?, producto = ?, "
                    + "cantidad = ? "
                    +    "WHERE id=?";
            pstm = con.prepareStatement(sql);            
            pstm.setInt(1, fabri.getIdProducto_Fab());
            pstm.setString(2, fabri.getMateriaPrima());
            pstm.setString(3, fabri.getProducto());
            pstm.setInt(4, fabri.getCantidad());
            pstm.setInt(5, fabri.getId());
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"id : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"id : " + 
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
    public int borrarFabricacion(String id){      
        Connection con = null;
        PreparedStatement pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "DELETE FROM fabricacion WHERE id = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, id);
            rtdo = pstm.executeUpdate(); 
            return rtdo;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"id : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        } 
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"id : " + 
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
    public ArrayList<Fabricacion> listadoFabricacion(String id){      
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Fabricacion> listado = new ArrayList<>();
        try{
            con = Fachada.getConnection();
            String sql="";
            if(id.equalsIgnoreCase("0")){
                sql = "SELECT * FROM fabricacion ORDER BY id";            
            }else{
                sql = "SELECT * FROM fabricacion where id = ? "
                    + "ORDER BY id";      
            }                        
            pstm = con.prepareStatement(sql);
            
            if(id != "0"){
                pstm.setString(1, id);
            }
            
            rs = pstm.executeQuery();
                        
            Fabricacion fabricacion = null;
            while(rs.next()){
                fabricacion = new Fabricacion();
                fabricacion.setIdProducto_Fab(rs.getInt("idproducto_fab"));
                fabricacion.setMateriaPrima(rs.getString("materiaPrima"));
                fabricacion.setProducto(rs.getString("producto"));
                fabricacion.setCantidad(rs.getInt("cantidad"));
                fabricacion.setId(rs.getInt("id"));
                listado.add(fabricacion);
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"id : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        finally{
            try{
                if(rs!=null) rs.close();
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"id : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
            }
        }
        return listado;
    }
    
    
     
}
