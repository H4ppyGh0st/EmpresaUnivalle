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
@Table(name = "proveedor")
public class Proveedor implements Serializable{

    private static final long serialVersionUID = 1876458704736728686L;
    
    private String nombreInsumo;
    private int cantidadInsumo;
    private String nombre;
    private String direccion;

    @Id
    private int idproveedor;

    public String getNombreInsumo() {
        return nombreInsumo;
    }

    public void setNombreInsumo(String nombreInsumo) {
        this.nombreInsumo = nombreInsumo;
    }

    public int getCantidadInsumo() {
        return cantidadInsumo;
    }

    public void setCantidadInsumo(int cantidadInsumo) {
        this.cantidadInsumo = cantidadInsumo;
    }

    

    public int getIdproveedor() {
        return idproveedor;
    }



    public void setIdproveedor(int idproveedor) {
        this.idproveedor = idproveedor;
    }



    public String getNombre() {
        return nombre;
    }



    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public String getDireccion() {
        return direccion;
    }



    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
    
}
