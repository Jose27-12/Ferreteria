/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author LUIS FANDIÑO
 */
public class Producto {
    private int id_Producto;
    private String nombre;
    private double precio;
     private int stock;
    private int id_Sede;

    
    public Producto() {}
    //constructor

    public Producto(int id, String nombre, double precio, int stock, int sede) {
        this.id_Producto = id_Producto;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.id_Sede = id_Sede;
    }

    public int getId_Producto() {
        return id_Producto;
    }

    public void setId_Producto(int id) {
        this.id_Producto = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getId_Sede() {
        return id_Sede;
    }

    public void setId_Sede(int id_Sede) {
        this.id_Sede = id_Sede;
    }

    
      // Método para mostrar información del producto
    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id_Producto +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", cantidad=" + stock +
                ", sede='" + id_Sede + '\'' +
                '}';
    }
}
