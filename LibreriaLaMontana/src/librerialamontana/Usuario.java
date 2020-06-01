/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librerialamontana;

/**
 *
 * @author Aylinee
 */
public class Usuario {
    public String nombre;
    public String contrasena;
    public boolean admin;

    public Usuario(String nombre, String contrasena, boolean admin) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.admin = admin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    
    public static boolean validacion(String nombre, String contrasena){
        for(int i=0; i<LibreriaLaMontana.usuarios.size(); i++){
            if(LibreriaLaMontana.usuarios.get(i).getNombre()== nombre && 
                    LibreriaLaMontana.usuarios.get(i).getContrasena() == contrasena){
                return true;
            }
        }
        return false;
    }
    
    
}
