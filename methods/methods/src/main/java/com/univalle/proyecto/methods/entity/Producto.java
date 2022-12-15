/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.univalle.proyecto.methods.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author mavel
 */
@Entity
@Table(name = "producto")
public class Producto implements Serializable{

    private static final long serialVersionUID = 1876158704736728687L;
    
    @Id
    private int idProductos;
    
    private String nombreProd;
    private double precioUnitario;
    private String Descripcion;
    private int cantidadProd;

    public Producto(int idProductos, String nombreProd, double precioUnitario, String Descripcion, int cantidadProd) {
        this.idProductos = idProductos;
        this.nombreProd = nombreProd;
        this.precioUnitario = precioUnitario;
        this.Descripcion = Descripcion;
        this.cantidadProd = cantidadProd;
    }

    public Producto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getCantidadProd() {
        return cantidadProd;
    }

    public void setCantidadProd(int cantidadProd) {
        this.cantidadProd = cantidadProd;
    }
    
    public void crearProducto(){
    
    
    }
    
    
}
