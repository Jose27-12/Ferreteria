package controller;

import Model.ProductoDAO;
import Model.Producto;

import java.util.List;

public class ProductoController {

    private ProductoDAO productoDAO;

    public ProductoController() {
        this.productoDAO = new ProductoDAO();
    }

    // Método para obtener productos filtrados por nombre y sede
    public List<Producto> obtenerProductos(String nombre) {
        return productoDAO.obtenerProductosPorNombre(nombre);
    }
}
