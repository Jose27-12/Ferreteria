/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LUIS FANDIÑO
 */
public class Inventario {
    private List<Producto> productos;

    public Inventario() {
        this.productos = new ArrayList<>();
    }
    
    //Metodo para agregar producto
    public void agregarProducto(Producto producto){
        productos.add(producto);
    }
    //Metodo para eliminar productos por ID
    public void eliminarProducto(int id){
        productos.removeIf(Producto -> Producto.getId_Producto()== id);
    }
    
    // Metodo Para buscar producto por nombre
    public Producto buscarProducto (String nombre){
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        return null;
    }
    
    //Metodo para mostrar todos los productos
    public List<Producto> listarProductos(){
        return productos;
    }
  
}
