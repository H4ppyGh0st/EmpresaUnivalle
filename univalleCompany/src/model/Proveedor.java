/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author mavel
 */
public class Proveedor extends Usuario {
    
    private String nombreInsumo;
    private int numero_venta;

    public Proveedor(String nombreInsumo, int numero_venta, String nombre, String direccion, int id) {
        super(nombre, direccion, id);
        this.nombreInsumo = nombreInsumo;
        this.numero_venta = numero_venta;
    }

    public Proveedor(String nombreInsumo, int numero_venta) {
        this.nombreInsumo = nombreInsumo;
        this.numero_venta = numero_venta;
    }

    public Proveedor() {
    }



    public String getNombreInsumo() {
        return nombreInsumo;
    }

    public void setNombreInsumo(String nombreInsumo) {
        this.nombreInsumo = nombreInsumo;
    }

    public int getNumero_venta() {
        return numero_venta;
    }

    public void setNumero_venta(int numero_venta) {
        this.numero_venta = numero_venta;
    }

   
    
    
    
}
