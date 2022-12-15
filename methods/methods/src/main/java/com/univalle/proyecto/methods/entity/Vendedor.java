/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.univalle.proyecto.methods.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author mavel
 */
@Entity
@Table(name = "vendedor")
public class Vendedor extends Usuario implements Serializable{

    private static final long serialVersionUID = 1876458704136728687L;
    
    private int cantidadProductos;
    private int numeroVenta;

    public Vendedor(int cantidadProductos, int numeroVenta, String nombre, String direccion, int id) {
        super(nombre, direccion, id);
        this.cantidadProductos = cantidadProductos;
        this.numeroVenta = numeroVenta;
    }

   

    public Vendedor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getCantidadProductos() {
        return cantidadProductos;
    }

    public void setCantidadProductos(int cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    public int getNumeroVenta() {
        return numeroVenta;
    }

    public void setNumeroVenta(int numeroVenta) {
        this.numeroVenta = numeroVenta;
    }
    
    public void totalVenta(){
    
    
    }
    
   public void comision(){
   
   
   }
    
}
