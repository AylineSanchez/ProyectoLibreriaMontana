/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Luciano
 */
public class SubCategoria {
    int codigo;
    String nombre;
    int referenciaCategoria;

    public SubCategoria(int codigo, String nombre, int referenciaCategoria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.referenciaCategoria = referenciaCategoria;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getReferenciaCategoria() {
        return referenciaCategoria;
    }

    public void setReferenciaCategoria(int referenciaCategoria) {
        this.referenciaCategoria = referenciaCategoria;
    }
    
}
