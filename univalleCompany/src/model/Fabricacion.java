/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author mavel
 */
public class Fabricacion {
        private  int idProducto_Fab;
    private String materiaPrima;
    private String producto;
    private int cantidad;
    private int id;

    public Fabricacion(int idProducto_Fab, String materiaPrima, String producto, int cantidad, int id) {
        this.idProducto_Fab = idProducto_Fab;
        this.materiaPrima = materiaPrima;
        this.producto = producto;
        this.cantidad = cantidad;
        this.id = id;
    }
    
    

    
    public Fabricacion() {
    }
    

    public String getMateriaPrima() {
        return materiaPrima;
    }

    public void setMateriaPrima(String materiaPrima) {
        this.materiaPrima = materiaPrima;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    

    public int getIdProducto_Fab() {
        return idProducto_Fab;
    }

    public void setIdProducto_Fab(int idProducto_Fab) {
        this.idProducto_Fab = idProducto_Fab;
    }
    
    
    
}
