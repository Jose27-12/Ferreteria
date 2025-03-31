/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import Model.Producto;
import Utils.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    
 
 
 public List<Producto> obtenerTodosLosProductos() {
    List<Producto> productos = new ArrayList<>();
    String sql = "SELECT * FROM producto"; // No se filtra por sede

    try (Connection conn = Conexion.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            Producto producto = new Producto();
            producto.setId_Producto(rs.getInt("id_Producto"));
            producto.setNombre(rs.getString("nombre"));
            producto.setPrecio(rs.getDouble("precio"));
            producto.setStock(rs.getInt("Stock"));
            producto.setId_Sede(rs.getInt("id_sede"));
            productos.add(producto);
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Para depurar el error en consola
    }

    return productos;
}

 public List<Producto> obtenerProductosPorSede(int id_sede) {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT id_Producto, nombre, Precio, Stock, id_Sede FROM producto WHERE id_Sede = ?";
        
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, id_sede);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Producto producto = new Producto();
                producto.setId_Producto(rs.getInt("id_Producto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setStock(rs.getInt("Stock"));
                producto.setId_Sede(rs.getInt("id_sede"));
                productos.add(producto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productos;
 }
 
public List<Producto> obtenerProductosPorNombre(String nombreProducto) {
    List<Producto> productos = new ArrayList<>();
    String sql;

    if ("admin".equalsIgnoreCase(SesionActual.getRol())) {
        // Si el rol es admin, muestra todos los productos
        sql = "SELECT id_Producto, nombre, Precio, Stock, id_Sede FROM producto WHERE nombre LIKE ?";
    } else {
        // Si es empleado, solo muestra los productos de su sede
        sql = "SELECT id_Producto, nombre, Precio, Stock, id_Sede FROM producto WHERE nombre LIKE ? AND id_Sede = ?";
    }

    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, "%" + nombreProducto + "%");

        if (!"admin".equalsIgnoreCase(SesionActual.getRol())) {
            ps.setInt(2, SesionActual.getSede());
        }

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Producto producto = new Producto();
            producto.setId_Producto(rs.getInt("id_Producto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setStock(rs.getInt("Stock"));
                producto.setId_Sede(rs.getInt("id_sede"));
                productos.add(producto);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return productos;
}


    
}
