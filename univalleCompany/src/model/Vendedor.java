/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author mavel
 */
public class Vendedor extends Usuario {
    
    private int tipo_producto;
    private int numeroVenta;

    public Vendedor(int tipo_producto, int numeroVenta, String nombre, String direccion, int id) {
        super(nombre, direccion, id);
        this.tipo_producto = tipo_producto;
        this.numeroVenta = numeroVenta;
    }

 
   

    public Vendedor() {
    }

   

    

    public int getTipo_producto() {
        return tipo_producto;
    }

    public void setTipo_producto(int tipo_producto) {
        this.tipo_producto = tipo_producto;
    }

   
    public int getNumeroVenta() {
        return numeroVenta;
    }

    public void setNumeroVenta(int numeroVenta) {
        this.numeroVenta = numeroVenta;
    }
    
    
    
}
