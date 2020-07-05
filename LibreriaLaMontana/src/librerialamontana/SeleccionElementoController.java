/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librerialamontana;

import Conexion.Conector;
import Modelo.Libro;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Aylinee
 */
public class SeleccionElementoController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private Conector c;
    @FXML private AnchorPane root;
    @FXML private Button botonModificar;
    @FXML private TableView<Libro> tabla;
    @FXML private TableColumn<Libro, String> tablaID;
    @FXML private TableColumn<Libro, String> tablNombre;
    @FXML private TableColumn<Libro, String> tablaStock;
    @FXML private TableColumn<Libro, String> tablaPrecio;
    
    static public int idSelectElement;
    private ObservableList<Libro> libros;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        c = new Conector();
        c.conect();
        this.libros = FXCollections.observableArrayList();
    }    
    
    @FXML    
    public void modificarProducto(ActionEvent event) throws IOException
    {
        
        idSelectElement = tabla.getSelectionModel().getSelectedItem().getId();
        Stage stage = (Stage) root.getScene().getWindow();
        Parent root = null;
        root = FXMLLoader.load(getClass().getResource("ModificarLibro.fxml"));
        Scene scene = new Scene(root);        
        stage.setScene(scene);
    }
}
