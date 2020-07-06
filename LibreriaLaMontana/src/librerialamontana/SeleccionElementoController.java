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
import java.sql.Connection;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author tomas
 */
public class SeleccionElementoController implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML private TableView<Libro> tabla;
    @FXML private TableColumn<Libro, String> tablaID;
    @FXML private TableColumn<Libro, String> tablNombre;
    @FXML private TableColumn<Libro, String> tablaStock;
    @FXML private TableColumn<Libro, String> tablaPrecio;
    private ObservableList<Libro> libros;
    private Conector c;
    @FXML private Button modificar;
    Connection con=null;
    static public int idSelectElement;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        c = new Conector();
        c.conect();
        con=c.makeConnection();
        this.libros = FXCollections.observableArrayList();
        
    }    

    @FXML
    private void goBack(MouseEvent event) {
    }
    public void operarResultado(){
     //query que enviamos
        String query = "SELECT * FROM libro;";
        //creamos el arreglo de libros
        this.setLibros(c.ModificarLibro(query));
        //Si el resultado es nulo
       if (!this.libros.isEmpty()){
            this.populateTableView();
            this.tabla.setItems(libros);
        } else {
         //   this.tabla.setVisible(false);
        }
        
    }
    @FXML
    public void modificarElemento(ActionEvent event) throws IOException
    {

        idSelectElement = tabla.getSelectionModel().getSelectedItem().getId();
        System.out.println("SOY EL ID EN SEELLCION ELEM"+ idSelectElement);
        
        Stage stage = (Stage) root.getScene().getWindow();
        //Parent root = null;
        FXMLLoader fxmlLoader= new  FXMLLoader(getClass().getResource("ModificarLibro.fxml"));
        Parent root = (Parent)fxmlLoader.load();   
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
   
     public void setLibros(ObservableList<Libro> librosBD){
        this.libros = librosBD;
    }
     private void populateTableView(){
        this.tablaID.setCellValueFactory(new PropertyValueFactory("id"));
        this.tablNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.tablaStock.setCellValueFactory(new PropertyValueFactory("stock"));
        this.tablaPrecio.setCellValueFactory(new PropertyValueFactory("precio"));    
    }  
}
