/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javafx.scene.image.ImageView;

/**
 *
 * @author Luciano
 */
public class Libro {
    private int id;
    private String nombre;
    private String autor;
    private String descripcion;
    private int precio;
    private int stock;
    private String editorial;
    private String lengua;
    private int paginas;
    private int refCategoria;
    private int refSubCategoria;
    private ImageView imagen;

    public Libro() {
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

    public ImageView getImagen() {
        return imagen;
    }

    public void setImagen(ImageView imagen) {
        this.imagen = imagen;
    }

    public int getRefCategoria() {
        return refCategoria;
    }

    public void setRefCategoria(int refCategoria) {
        this.refCategoria = refCategoria;
    }
    
    public int getRefSubCategoria() {
        return refSubCategoria;
    }

    public void setSubRefCategoria(int refSubCategoria) {
        this.refSubCategoria = refSubCategoria;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
    
}
