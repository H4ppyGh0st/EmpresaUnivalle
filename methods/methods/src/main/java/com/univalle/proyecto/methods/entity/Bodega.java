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
@Table(name = "bodega")
public class Bodega implements Serializable{

    private static final long serialVersionUID = 1876458704736728687L;

    @Id
    private int id;
    
    private int idproductoBod;
    private String nombreproductoBod;
    private double precioBod;
    private int cantidad;
    public int getIdproductoBod() {
        return idproductoBod;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public void setIdproductoBod(int idproductoBod) {
        this.idproductoBod = idproductoBod;
    }
    public String getNombreproductoBod() {
        return nombreproductoBod;
    }
    public void setNombreproductoBod(String nombreproductoBod) {
        this.nombreproductoBod = nombreproductoBod;
    }
    public double getPrecioBod() {
        return precioBod;
    }
    public void setPrecioBod(double precioBod) {
        this.precioBod = precioBod;
    }
    
}
