/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Felipe Fuenzalida
 */
public class Conector {
    
    String driver = "org.postgresql.Driver";
    String connectString = "";
    String user = "";
    String password = "";
    Connection con;
    
    public Conector() {
        //constructor vacío
    }
    
    public void conect() {
        this.readFiles();
        this.makeConnection();
        this.testConnection();
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
    
    public void makeConnection() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(connectString, user, password);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
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
        
    public boolean testConnection() {
        System.out.println("Probando conexión con la base de datos");
        try {
            Statement stmt = con.createStatement();
            //test existence of tables
            ResultSet rs;
            rs = stmt.executeQuery("SELECT * FROM categoria limit 1;");
            rs.close();
            stmt.close();
            System.out.println("OK");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error: No hay conexión con la base de datos");
            return false;
        }
        return true;
    }
    
}
