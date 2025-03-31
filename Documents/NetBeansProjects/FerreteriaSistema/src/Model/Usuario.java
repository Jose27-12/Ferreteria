/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author LUIS FANDIÑO
 */
public class Usuario {

    public static Object getUsuarioActivo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private String nombre;
    private String usuario;
    private String contraseña;
    private String cargo;
    private int id_Sede;

    
    public Usuario(String nombre, String usuario, String contraseña, String rol, int sede) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.cargo = cargo;
        this.id_Sede = id_Sede;
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getId_Sede() {
        return id_Sede;
    }

    public void setId_Sede(int id_Sede) {
        this.id_Sede = id_Sede;
    }

    

    // Metodo para verificar si el rol es administrador
    public boolean esAdministrador(){
        return "ADMIN".equalsIgnoreCase(this.cargo);
    }
    
      // Método para validar credenciales (esto podría trasladarse al controlador más adelante)
    public boolean validarCredenciales(String username, String password) {
        return this.usuario.equals(username) && this.contraseña.equals(password);
    }
}
