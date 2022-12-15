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
@Table(name = "comercializacion")
public class Comercializacion implements Serializable{

    private static final long serialVersionUID = 1876458704736728627L;
    
    private int idclienteCom;
    private int idProductoCom;
    private int comisionVenta;
    private double precioCom;
    private int vendedor;
    private int cantidadCom;

    @Id
    private int numerofactura;

    
    private String direccionventa;
    

    public int getVendedor() {
        return vendedor;
    }

    public void setVendedor(int vendedor) {
        this.vendedor = vendedor;
    }

    public int getNumeroFactura() {
        return numerofactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numerofactura = numeroFactura;
    }

    public String getDireccionVenta() {
        return direccionventa;
    }

    public void setDireccionVenta(String direccionVenta) {
        this.direccionventa = direccionVenta;
    }

    public int getIdclienteCom() {
        return idclienteCom;
    }

    public void setIdclienteCom(int idclienteCom) {
        this.idclienteCom = idclienteCom;
    }

    public int getIdProductoCom() {
        return idProductoCom;
    }

    public void setIdProductoCom(int idProductoCom) {
        this.idProductoCom = idProductoCom;
    }

    public int getComisionVenta() {
        return comisionVenta;
    }

    public void setComisionVenta(int comisionVenta) {
        this.comisionVenta = comisionVenta;
    }

    public double getPrecioCom() {
        return precioCom;
    }

    public void setPrecioCom(double precioCom) {
        this.precioCom = precioCom;
    }

    public int getCantidadCom() {
        return cantidadCom;
    }

    public void setCantidadCom(int cantidadCom) {
        this.cantidadCom = cantidadCom;
    }
    
    
    
    
}
