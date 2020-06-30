/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librerialamontana;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Aylinee
 */
public class SistemaEmpleadoAdmiController implements Initializable {

    private String busquedaString;
    
    /**
     * Initializes the controller class.
     */
    @FXML
    Button inventario;
    
    @FXML
    private TextField busqueda;
    
    @FXML
    private AnchorPane root;
    
    @FXML
    private Button btnBuscar;
   
    @FXML
    private Button botonFuncionEliminar;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    @FXML 
    private void display(ActionEvent event) throws IOException{

        busquedaString = busqueda.getText();
        System.out.println(busquedaString);

    Stage stage = (Stage) root.getScene().getWindow();

    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ResultadosBusqueda.fxml"));
        
    Parent root = (Parent)fxmlLoader.load();
    ResultadosBusquedaController controllerSearch = fxmlLoader.<ResultadosBusquedaController>getController();
    controllerSearch.setBusqueda(this.busquedaString);
    controllerSearch.operarResultado();
    Scene scene = new Scene(root);
    scene.getStylesheets().add("CSS/estilosTV.css");
    stage.setScene(scene);
    
    }
    
    @FXML 
    private void displayEliminarProducto(ActionEvent event) throws IOException{

    busquedaString = busqueda.getText();
    System.out.println(busquedaString);

    Stage stage = (Stage) root.getScene().getWindow();

    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EliminarProducto.fxml"));
        
    Parent root = (Parent)fxmlLoader.load();
    EliminarProductoController controllerSearch = fxmlLoader.<EliminarProductoController>getController();
    controllerSearch.operarResultado();
    Scene scene = new Scene(root);
    scene.getStylesheets().add("CSS/estilosTV.css");
    stage.setScene(scene);
    
    }
    
    public void setBusquedaString(String busq){
        this.busquedaString = busq;
    }
    
}