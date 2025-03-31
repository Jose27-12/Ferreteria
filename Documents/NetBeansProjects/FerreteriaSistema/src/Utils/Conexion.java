/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author LUIS FANDIÑO
 */
public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/facturacion";
    private static final String USER = "root"; // Tu usuario de MySQL
    private static final String PASSWORD = "271299"; // Tu contraseña de MySQL
    
    public static Connection getConnection() {
        Connection conexion = null;
         try {
            conexion = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Conexión exitosa a la base de datos");
        } catch (SQLException e) {
            System.out.println("❌ Error al conectar a la base de datos");
            e.printStackTrace();
        }
        return conexion;
    }
    
}
