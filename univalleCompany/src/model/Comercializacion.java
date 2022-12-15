/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author mavel
 */
public class Comercializacion {
    
    private int idCliente_Com;
    private double precio_Com;
    private String vendedor;
    private int cantidad_Com;
    private int numeroFactura;
    private String direccionVenta;
    private int comision_venta;
    private int id_producto_com;

    public Comercializacion(int idCliente_Com, double precio_Com, String vendedor, int cantidad_Com, int numeroFactura, String direccionVenta, int comision_venta, int id_producto_com) {
        this.idCliente_Com = idCliente_Com;
        this.precio_Com = precio_Com;
        this.vendedor = vendedor;
        this.cantidad_Com = cantidad_Com;
        this.numeroFactura = numeroFactura;
        this.direccionVenta = direccionVenta;
        this.comision_venta = comision_venta;
        this.id_producto_com = id_producto_com;
    }

    

    public Comercializacion() {
    }
    
    

    public int getIdCliente_Com() {
        return idCliente_Com;
    }

    public void setIdCliente_Com(int idCliente_Com) {
        this.idCliente_Com = idCliente_Com;
    }

    public int getComision_venta() {
        return comision_venta;
    }

    public void setComision_venta(int comision_venta) {
        this.comision_venta = comision_venta;
    }

    public int getId_producto_com() {
        return id_producto_com;
    }

    public void setId_producto_com(int id_producto_com) {
        this.id_producto_com = id_producto_com;
    }

   

    public double getPrecio_Com() {
        return precio_Com;
    }

    public void setPrecio_Com(double precio_Com) {
        this.precio_Com = precio_Com;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public int getCantidad_Com() {
        return cantidad_Com;
    }

    public void setCantidad_Com(int cantidad_Com) {
        this.cantidad_Com = cantidad_Com;
    }

    

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getDireccionVenta() {
        return direccionVenta;
    }

    public void setDireccionVenta(String direccionVenta) {
        this.direccionVenta = direccionVenta;
    }
    
    
    
    
}
