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
@Table(name = "fabricacion")
public class Fabricacion implements Serializable{

    private static final long serialVersionUID = 1876458704736738687L;

    @Id
    private int id;

    
    private  int idproductoFab;
    private String materiaPrima;
    private String producto;
    private int cantidad;


    public int getIdproductoFab() {
        return idproductoFab;
    }

    public void setIdproductoFab(int idproductoFab) {
        this.idproductoFab = idproductoFab;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
    
    
    
}
