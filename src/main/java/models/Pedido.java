/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author david
 */
public class Pedido {
    
    private int id;
    private int producto_id;
    private String nombre;
    private double precio;

    public Pedido() {
    }

    public Pedido(int id, int producto_id, String nombre, double precio) {
        this.id = id;
        this.producto_id = producto_id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }
    
    public int getProductoId() {
        return producto_id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
}
