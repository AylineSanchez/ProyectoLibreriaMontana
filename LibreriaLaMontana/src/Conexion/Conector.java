/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;
import Modelo.Libro;
import javafx.scene.image.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.ImageView;

/**
 *
 * @author Felipe Fuenzalida
 */
public class Conector {
    
    private ResultSet rs;
    
    private Statement stmt;
    
    private String driver = "org.postgresql.Driver";
    
    private String connectString = "";
    
    private String user = "";
    
    private String password = "";
    
    private Connection con;
    
    public Conector(){
        //constructor vacío
        
    }
    
    public void conect() {
        this.readFiles();
        this.makeConnection();
    }    
    
    public boolean readFiles() {
        BufferedReader reader;
        try {
            // leer archivo con info de conexion a la BD
            reader = new BufferedReader(new FileReader("conexion.txt"));
            connectString = reader.readLine();
            user = reader.readLine();
            password = reader.readLine();
            reader.close();
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Error: No se pudieron leer los archivos de inicialización");
            return false;
        }
    }
    
    public Connection makeConnection() {
        readFiles();
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(connectString, user, password);
            return con;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
    
        public void closeConnection() {
        try {
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
        
    public boolean validarLogin(String contrasena, String query) {
        System.out.println("Probando conexión con la base de datos");
        boolean confirmacion = false;
        try {
            stmt = con.createStatement();
            //test existence of tables
            rs = stmt.executeQuery(query);
            //rs = stmt.executeQuery("SELECT usuario.contrasena FROM usuario WHERE usuario.alias = 'admin';");
            while(rs.next()){
                if (contrasena.equals(rs.getString(1))){
                    confirmacion = true;
                } else {
                    confirmacion = false;
                }
            }
            rs.close();
            stmt.close();
            
            System.out.println("OK");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error: No hay conexión con la base de datos");
            return false;
        }
        if (confirmacion){
            return true;
        } else {
            return false;
        }
    }
    
    public ObservableList<Libro> busquedaLibros(String query){
        
        
        
        //Lista de libros
        ObservableList<Libro> libros = FXCollections.observableArrayList();
        
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);   
            
            while (rs.next()) {
                    
                    Libro libro = new Libro();
                    libro.setId(rs.getInt("id"));
                    libro.setNombre(rs.getString("nombre"));
                    libro.setDescripcion(rs.getString("descripcion"));
                    libro.setPrecio(rs.getInt("precio"));
                    libro.setStock(rs.getInt("stock"));
                    libro.setEditorial(rs.getString("editorial"));
                    libro.setLengua(rs.getString("lengua"));
                    libro.setPaginas(rs.getInt("paginas"));
                    libro.setRefCategoria(rs.getInt("refCategoria"));
                    libro.setSubRefCategoria(rs.getInt("refSubCategoria"));
                    ImageView iv = new ImageView(new Image(this.getClass().getResourceAsStream("1N.jpg")));                    
                    libro.setImagen(iv);
                    //ImageView imagen = new ImageView(new Image(this.getClass().getResourceAsStream("/src/ImagenesLibro/"+rs.getInt("id")+".jpg")));                                    
                    libros.add(libro);
            }
                        
            rs.close();
            stmt.close();            

        } catch (Exception e) {

        }
        
        return libros;
        
    }
    
     public ObservableList<Libro> eliminarLibro(String query){
        
        
        
        //Lista de libros
        ObservableList<Libro> libros = FXCollections.observableArrayList();
        
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);   
            
            while (rs.next() && rs.getInt("stock")!=0) {
                    
                    Libro libro = new Libro();
                    libro.setId(rs.getInt("id"));
                    libro.setNombre(rs.getString("nombre"));
                    libro.setDescripcion(rs.getString("descripcion"));
                    libro.setPrecio(rs.getInt("precio"));
                    libro.setStock(rs.getInt("stock"));
                    libro.setEditorial(rs.getString("editorial"));
                    libro.setLengua(rs.getString("lengua"));
                    libro.setPaginas(rs.getInt("paginas"));
                    libro.setRefCategoria(rs.getInt("refCategoria"));
                    libro.setSubRefCategoria(rs.getInt("refSubCategoria"));
                    ImageView iv = new ImageView(new Image(this.getClass().getResourceAsStream("1N.jpg")));                    
                    libro.setImagen(iv);
                    //ImageView imagen = new ImageView(new Image(this.getClass().getResourceAsStream("/src/ImagenesLibro/"+rs.getInt("id")+".jpg")));                                    
                    libros.add(libro);
            }
                        
            rs.close();
            stmt.close();            

        } catch (Exception e) {

        }
        
        return libros;
        
    }
    
    
    public ResultSet enviarQuery(ResultSet rsCopia, String query){
        try {
            ResultSet rsE;
            Statement stmtE;
            stmtE = con.createStatement();
            rsE = stmtE.executeQuery(query);
            rsCopia = rsE;
            stmtE.close();
            rsE.close();
            return rsCopia;
        } catch (SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }    
    }

    public ResultSet getRs() {
        return rs;
    }

    public Statement getStmt() {
        return stmt;
    }

    public String getDriver() {
        return driver;
    }

    public String getConnectString() {
        return connectString;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public Connection getCon() {
        return con;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public void setStmt(Statement stmt) {
        this.stmt = stmt;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public void setConnectString(String connectString) {
        this.connectString = connectString;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    
}