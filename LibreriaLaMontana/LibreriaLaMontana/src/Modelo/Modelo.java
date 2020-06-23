/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Luciano
 */
public class Modelo {
    ArrayList<Articulo> articulos = new ArrayList<Articulo>();
    ArrayList<Categoria> categorias = new ArrayList<Categoria>();
    ArrayList<Libro> libros = new ArrayList<Libro>();
    ArrayList<SubCategoria> subCategorias = new ArrayList<SubCategoria>();
    ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    
    public void agregarArticulo(Articulo articulo)
    {
        articulos.add(articulo);
        return;
    }
    
    public void eliminarArticulo(int id)
    {
        for(int i = 0; i<articulos.size(); i++)
        {
            if (articulos.get(i).getId() == id)
            {
                articulos.remove(i);
                return;
            }
        }
        System.out.println("No se encontró un arituclo con ese ID");
        return;
    }
    
    public Articulo obtenerArticulo(int id)
    {
        for(int i = 0; i<articulos.size(); i++)
        {
            if (articulos.get(i).getId() == id)
            {
                return articulos.get(i);
            }
        }
        System.out.println("No se encontró un arituclo con ese ID");
        return null;
    }
    
    public void agregarCategoria(Categoria categoria)
    {
        categorias.add(categoria);
        return;
    }
    
    public void eliminarCategoria(int id)
    {
        for (int i=0; i<categorias.size(); i++)
        {
            if (categorias.get(i).getCodigo()==id)
            {
                categorias.remove(i);
                return;
            }
        }
        System.out.println("No se encontró una categoría con ese ID");
        return;
    }
    
    public Categoria obtenerCategoria(int id)
    {
        for (int i=0; i<categorias.size(); i++)
        {
            if (categorias.get(i).getCodigo()==id)
            {
               return categorias.get(i);
            }
        }
        System.out.println("No se encontró una categoría con ese ID");
        return null;        
    }
    
    public void agregarLibro(Libro libro)
    {
        libros.add(libro);
    }
    
    public void eliminarLibro(int id)
    {
        for (int i=0; i<libros.size(); i++)
        {
            if (libros.get(i).getId()==id)
            {
                libros.remove(i);
                return;
            }
        }
         System.out.println("No se encontró un libro con ese ID");
        return;     
    }
    
     public Libro obtenerLibro(int id)
    {
        for (int i=0; i<libros.size(); i++)
        {
            if (libros.get(i).getId()==id)
            {
               return libros.get(i);
            }
        }
         System.out.println("No se encontró un libro con ese ID");
        return null;        
    }
     
    public void agregarSubCategoria(SubCategoria subCategoria)
    {
        subCategorias.add(subCategoria);
    }
    
    public void eliminarSubCategoria(int id)
    {
        for (int i=0; i<subCategorias.size(); i++)
        {
            if (subCategorias.get(i).getCodigo()==id)
            {
                subCategorias.remove(i);
                return;
            }
        }
         System.out.println("No se encontró una sub-categoría con ese ID");
        return;     
    }
    
     public SubCategoria obtenerSubCategoria(int id)
    {
        for (int i=0; i<subCategorias.size(); i++)
        {
            if (subCategorias.get(i).getCodigo()==id)
            {
               return  subCategorias.get(i);
            }
        }
        System.out.println("No se encontró una categoría con ese ID");
        return null;        
    }
     
    public void agregarUsuario(Usuario usuario)
    {
        usuarios.add(usuario);
    }
    
    public void eliminarUsuario(String id)
    {
        for (int i=0; i<usuarios.size(); i++)
        {
            if (usuarios.get(i).getAlias()==id)
            {
                usuarios.remove(i);
                return;
            }
        }
         System.out.println("No se encontró un usuario con ese alias");
        return;     
    }
    
     public Usuario obtenerUsuario(String id)
    {
        for (int i=0; i<usuarios.size(); i++)
        {
            if (usuarios.get(i).getAlias()==id)
            {
               return usuarios.get(i);
            }
        }
         System.out.println("No se encontró un usuario con ese ID");
        return null;        
    }
}
