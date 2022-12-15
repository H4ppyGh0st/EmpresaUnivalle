/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author mavel
 */
public class Producto {
    
    private int idProductos;
    private String nombreProd;
    private double precio;
    private String descripcion;
    private double porcentaje_comision;

    public Producto(int idProductos, String nombreProd, double precio, String descripcion, double porcentaje_comision) {
        this.idProductos = idProductos;
        this.nombreProd = nombreProd;
        this.precio = precio;
        this.descripcion = descripcion;
        this.porcentaje_comision = porcentaje_comision;
    }

    public Producto() {
    }

   
   
    public int getIdProductos() {
        return idProductos;
    }

    public void setIdProductos(int idProductos) {
        this.idProductos = idProductos;
    }

    public String getNombreProd() {
        return nombreProd;
    }

    public void setNombreProd(String nombreProd) {
        this.nombreProd = nombreProd;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPorcentaje_comision() {
        return porcentaje_comision;
    }

    public void setPorcentaje_comision(double porcentaje_comision) {
        this.porcentaje_comision = porcentaje_comision;
    }

    
    
    
}
