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
    
    
    @FXML
    private Button btnUsuario;
    @FXML
    private Button btnProducto;
    @FXML
    private Button btnModificarar;
    @FXML
    private Button btnModificarpro;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    @FXML 
    private void displayBusqueda(ActionEvent event) throws IOException{

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
    @FXML 
    private void usuario (ActionEvent event) throws IOException
    {
        Stage stage = (Stage) root.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Usuario.fxml"));
        Parent root = (Parent)fxmlLoader.load();
        
        //ResultadosBusquedaController controller = fxmlLoader.<ResultadosBusquedaController>getController();
        //controller.setBusqueda(this.busquedaString);
        //controller.operarResultado();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
    
    @FXML
    private void agregarProducto (ActionEvent event) throws IOException
    {
         //se agrega un nuevo elemento
        System.out.println("producto");
    }
    @FXML
    private void modificarArticulo(ActionEvent event) throws IOException
    {
        
        Stage stage = (Stage) root.getScene().getWindow();
        FXMLLoader fxmlLoader= new  FXMLLoader(getClass().getResource("SeleccionElemento.fxml"));
        Parent root = (Parent)fxmlLoader.load();   
        SeleccionElementoController controllerSearch = fxmlLoader.<SeleccionElementoController>getController();
        controllerSearch.operarResultado();
        
        Scene scene = new Scene(root);        
        stage.setScene(scene);
        
        
        System.out.println("holahoaoh");
    } 
    @FXML
    private void modificarProducto(ActionEvent event) throws IOException
    {
        Stage stage = (Stage) root.getScene().getWindow();
        Parent root=null;
        try {
                root = FXMLLoader.load(getClass().getResource("SeleccionElemento.fxml"));
            
        } catch (IOException ex) {
            System.out.println("No se puede cargar la vista ");
        }
        Scene scene = new Scene(root);        
        scene.getStylesheets().add("CSS/estilosTV.css");
        stage.setScene(scene);
    }
    
    public void setBusquedaString(String busq){
        this.busquedaString = busq;
    }
    
}