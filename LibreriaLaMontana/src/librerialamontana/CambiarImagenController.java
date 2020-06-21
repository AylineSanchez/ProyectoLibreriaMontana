/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librerialamontana;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
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
public class CambiarImagenController implements Initializable {

    /**
     * Initializes the controller class.
     */
    public static String URL;
    
    @FXML
    private AnchorPane root;
    
    @FXML
    private Button listo;
    
    @FXML
    private Button cancelar;
    
    @FXML
    private TextField url;
    
    Connection con;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML 
    private void cancelar(ActionEvent event) throws IOException{
        Stage stage = (Stage) root.getScene().getWindow();
        Parent root=null;
        try {
                root = FXMLLoader.load(getClass().getResource("ModificarLibro.fxml"));
        } catch (IOException ex) {
            System.out.println("No se puede cargar la vista ");
        }
        Scene scene = new Scene(root);        
        stage.setScene(scene);//
    }
    
    @FXML 
    private void cambiarUrl(ActionEvent event) throws IOException{
        //encontrar id a modificar
        String id= "";
        String tipo="";
        try {
            Statement stmt = con.createStatement();
            //test existence of tables
            ResultSet rs;
            rs = stmt.executeQuery("UPDATE "+tipo+" SET imagen='"+url.getText()+"' WHERE id='"+id+"';");
            rs.close();
            stmt.close();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Modificacion exitosa");
            alert.setHeaderText("Se ha realizado una modificacion exitosa");
            alert.showAndWait();
            Stage stage = (Stage) root.getScene().getWindow();
            Parent root=null;
            try {
                    root = FXMLLoader.load(getClass().getResource("ModificarLibro.fxml"));
            } catch (IOException ex) {
                System.out.println("No se puede cargar la vista ");
            }
            Scene scene = new Scene(root);        
            stage.setScene(scene);//
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Modificacion fallida");
            alert.setHeaderText("Ha ocurrido un problema con la base de datos, contactar al técnico");
            alert.showAndWait();
        }
    }
}
