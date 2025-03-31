/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author LUIS FANDIÑO
 */
public class SesionActual {
    private static int id_Sede;
    private static String cargo;

    public static void iniciarSesion(String rolUsuario, int sedeUsuario) {
        cargo = rolUsuario;
        id_Sede = sedeUsuario;
    }

    public static int getSede() {
        return id_Sede;
    }

    public static String getRol() {
        return cargo;
    }

    public static void cerrarSesion() {
        cargo = null;
        id_Sede = 0;
    }
}

