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
public class Libro {
    int id;
    String nombre;
    String autor;
    String descripcion;
    int precio;
    int stock;
    String editorial;
    String lengua;
    int paginas;
    String imagen;
    int refCategoria;

    public Libro(int id, String nombre, String autor, String descripcion, int precio, int stock, String editorial, String lengua, int paginas, String imagen, int refCategoria) {
        this.id = id;
        this.nombre = nombre;
        this.autor=autor;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.editorial = editorial;
        this.lengua = lengua;
        this.paginas = paginas;
        this.imagen = imagen;
        this.refCategoria = refCategoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getLengua() {
        return lengua;
    }

    public void setLengua(String lengua) {
        this.lengua = lengua;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getRefCategoria() {
        return refCategoria;
    }

    public void setRefCategoria(int refCategoria) {
        this.refCategoria = refCategoria;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
    
}
