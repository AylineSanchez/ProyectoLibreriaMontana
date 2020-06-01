/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librerialamontana;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Aylinee
 */
public class LoginController implements Initializable {
    
    @FXML
    private AnchorPane root;
    
    @FXML
    private Button ingresar;
    
    @FXML
    private Button ingresarInvitado;
    
    @FXML
    private TextField usuario;
    
    @FXML
    private TextField contraseña;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
   @FXML 
    private void ingresarSistemaEmpAdm(ActionEvent event) throws IOException{
        Stage stage = (Stage) root.getScene().getWindow();
        Parent root=null;
        try {
            String nombre = usuario.getText();
            String contrasena = usuario.getText();
            if(Usuario.validacion(nombre, contrasena)){
                root = FXMLLoader.load(getClass().getResource("sistemaEmpleadoAdmi.fxml"));
            }
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Ingreso de usuario invalido");
                alert.setHeaderText("El usuario o la contraseña son invalidos, ingresar nuevamente");
                alert.showAndWait();
            }
        } catch (IOException ex) {
            System.out.println("No se puede cargar la vista ");
        }
        Scene scene = new Scene(root);        
        stage.setScene(scene);//
    }
    
    @FXML 
    private void ingresarSistemaInvitado(ActionEvent event) throws IOException{
        Stage stage = (Stage) root.getScene().getWindow();
        Parent root=null;
        try {
            root = FXMLLoader.load(getClass().getResource("sistemaInvitado.fxml"));
        } catch (IOException ex) {
            System.out.println("No se puede cargar la vista ");
        }
        Scene scene = new Scene(root);        
        stage.setScene(scene);//
    }
    
    @FXML
    private void cerrar(ActionEvent event) {
        Platform.exit();
    }
    
}
