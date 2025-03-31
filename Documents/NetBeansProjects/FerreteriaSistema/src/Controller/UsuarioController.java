package Controller;


import Model.SesionActual;
import Utils.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioController {

    public boolean login(String usuario, String contrasena) {
        String sql = "SELECT Cargo, id_Sede FROM usuario WHERE usuario = ? AND Contraseña = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, usuario);
            ps.setString(2, contrasena);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String cargo = rs.getString("cargo");
                int id_Sede = rs.getInt("id_Sede");

                // ✅ Guarda el estado de la sesión
                SesionActual.iniciarSesion(cargo, id_Sede);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void logout() {
        SesionActual.cerrarSesion();
    }

    public String getRolActual() {
        return SesionActual.getRol();
    }

    public int getSedeActual() {
        return SesionActual.getSede();
    }
}
