/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author mavel
 */
public class Bodega {
    
    private int idproducto_bod;
    private String nombreproducto_bod;
    private int cantidad;
    private int id;

    public Bodega(int idproducto_bod, String nombreproducto_bod, int cantidad, int id) {
        this.idproducto_bod = idproducto_bod;
        this.nombreproducto_bod = nombreproducto_bod;
        this.cantidad = cantidad;
        this.id = id;
    }

    public Bodega() {
    }
    

    public int getIdproducto_bod() {
        return idproducto_bod;
    }

    public void setIdproducto_bod(int idproducto_bod) {
        this.idproducto_bod = idproducto_bod;
    }

    public String getNombreproducto_bod() {
        return nombreproducto_bod;
    }

    public void setNombreproducto_bod(String nombreproducto_bod) {
        this.nombreproducto_bod = nombreproducto_bod;
    }

    public double getCantidad() {
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

    
    
}
