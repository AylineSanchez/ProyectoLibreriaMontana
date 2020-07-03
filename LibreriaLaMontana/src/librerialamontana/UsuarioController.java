/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librerialamontana;

import Conexion.Conector;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author tomas
 */
public class UsuarioController implements Initializable {
    private Conector c;
    PreparedStatement ps;
    String Permiso;   
    Connection con;
    
    @FXML
    private TextField busqueda;
    @FXML
    private Button btnBuscar;
    @FXML
    private TextField AliasText;
    @FXML
    private TextField NombreText;
    @FXML
    private TextField ApellidoText;
    @FXML
    private TextField ContraseniaText;
    @FXML
    private Button btnUsuarioP;
    @FXML
     private Button btnEmpleadoP;
    @FXML
    private Button btnAdminP;
    @FXML
    private Button btnCrearUsuario;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        c = new Conector();
        c.conect();
        System.out.println("CONECTADO A LA BASE DE DATOS");
    }
    @FXML
    private void buscar(ActionEvent event)
    {
        System.out.println("busqueda");
    }
    @FXML
    private void usuarioPermiso(ActionEvent event)
    {
        Permiso= "usuario";
        System.out.println("se dio permiso Usuario");  
    }
     @FXML
    private void empleadoPermiso(ActionEvent event)
    {
        Permiso= "empleado";
        System.out.println("Se dio permiso empleado");
    }
    @FXML
    private void adminPermiso(ActionEvent event)
    {
        Permiso= "admin";
        System.out.println("Se dio permiso ADMIN");
    }
    @FXML
    private void crearUsuario(ActionEvent event)
    {
      /*
        Alias = AliasText.getText();
        Nombre = NombreText.getText();
        Apellido = ApellidoText.getText();
        Contrasena= ContraseniaText.getText(); 
        System.out.println("LOS DATOS DEL NUEVO USUARIO SON; --->"+Alias +Nombre+ Apellido+ Contrasena+ Permiso);
      */
        try
        {  
            ps = con.prepareStatement("INSERT INTO usuario (alias,nombre,apellido,contrasena,tipo) VALUES(?,?,?,?,?)");
            System.out.println("estou yaqwasdfgfnhfdrsfgd");
            ps.setString(1, AliasText.getText());
            ps.setString(2, NombreText.getText());
            ps.setString(3, ApellidoText.getText());
            ps.setString(4, ContraseniaText.getText());
            ps.setString(5, Permiso);
            ps.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Se agregó un usuario");
            alert.setHeaderText("el Nuevo usuario se agrego Correctamente");
            alert.showAndWait();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("SE CREA USUARIOOO");
    }
}
