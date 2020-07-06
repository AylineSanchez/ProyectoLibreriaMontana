/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librerialamontana;

import Conexion.Conector;
import Modelo.Articulo;
import Modelo.Libro;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Aylinee
 */
public class ModificarArticuloController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private AnchorPane root;
    
    @FXML
    private TextField nombre;
    
    @FXML
    private TextField descripcion;
    
    @FXML
    private TextField precio;
    
    @FXML
    private ImageView imagen;
    @FXML
    private Button cambiar;
    @FXML
    private Button cancelar;
    @FXML
    private Button guardar;

    private Conector c;
    private ObservableList<Articulo> articulos;
    @Override
    
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        c = new Conector();
        c.conect();
        this.articulos = c.ModificarArticulo("SELECT * FROM articulo;");
        //int id = SeleccionElementoController.idSelectElement;
    }    
    
    @FXML 
    private void guardarCambios(ActionEvent event) throws IOException{
        modificarArticulo(nombre.getText(),descripcion.getText(),precio.getText());
        Stage stage = (Stage) root.getScene().getWindow();
        //Parent root = null;
        FXMLLoader fxmlLoader= new  FXMLLoader(getClass().getResource("sistemaEmpleadoAdmi.fxml"));
        Parent root = (Parent)fxmlLoader.load();   
        Scene scene = new Scene(root);
        stage.setScene(scene);  
    }
    
    private void modificarArticulo(String nombre, String descripcion, String precio){
        
        String query="UPDATE Articulo SET nombre='"+nombre+"' , descripcion='"
                    +descripcion+"' , precio='"+precio+"' WHERE id='"+SeleccionElementoController.idSelectElement+"';";
        c.ModificarArticulo(query);
        
        
    }
    @FXML 
    private void cancelar(ActionEvent event) throws IOException{
        Stage stage = (Stage) root.getScene().getWindow();
        Parent root=null;
        try {
                root = FXMLLoader.load(getClass().getResource("sistemaEmpleadoAdmi.fxml"));
            
        } catch (IOException ex) {
            System.out.println("No se puede cargar la vista ");
        }
        Scene scene = new Scene(root);        
        stage.setScene(scene);//
    }
    
    @FXML 
    private void cambiarImagen(ActionEvent event) throws IOException{
        Stage stage = (Stage) root.getScene().getWindow();
        Parent root=null;
        try {
                root = FXMLLoader.load(getClass().getResource("CambiarImagen.fxml"));
            
        } catch (IOException ex) {
            System.out.println("No se puede cargar la vista ");
        }
        Scene scene = new Scene(root);        
        stage.setScene(scene);//
    }
}
