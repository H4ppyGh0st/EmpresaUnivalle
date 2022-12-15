/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author mavel
 */
public class Cliente extends Usuario{
    
    private int edad;
    private int cantidadPedido;
    private String tipoPago;

    public Cliente(int edad, int cantidadPedido, String tipoPago, String nombre, String direccion, int id) {
        super(nombre, direccion, id);
        this.edad = edad;
        this.cantidadPedido = cantidadPedido;
        this.tipoPago = tipoPago;
    }

  

    public Cliente() {
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getCantidadPedido() {
        return cantidadPedido;
    }

    public void setCantidadPedido(int cantidadPedido) {
        this.cantidadPedido = cantidadPedido;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    
    
    
    
    
}
