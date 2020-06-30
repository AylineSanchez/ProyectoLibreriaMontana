/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librerialamontana;


        
import Conexion.Conector;
import Modelo.Libro;
import java.io.File;
import javafx.scene.image.Image;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author Luciano
 */
public class EliminarProductoController implements Initializable {

    private Conector c;
    @FXML private AnchorPane root;
    @FXML private Button botonEliminar;
    @FXML private TableView<Libro> tabla;
    @FXML private TableColumn<Libro, String> tablaID;
    @FXML private TableColumn<Libro, String> tablNombre;
    @FXML private TableColumn<Libro, String> tablaStock;
    @FXML private TableColumn<Libro, String> tablaPrecio;
    @FXML void guardarCambios(ActionEvent event) {
    }
    

    private int idSelect;
    private ObservableList<Libro> libros;

     /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Conexión con la BD
        c = new Conector();
        c.conect();
        this.libros = FXCollections.observableArrayList();
    }    
    
    //Retrocede al home
    public void goBack() throws IOException{
        
        Stage stage = (Stage) root.getScene().getWindow();
        Parent root = null;
        root = FXMLLoader.load(getClass().getResource("sistemaEmpleadoAdmi.fxml"));
        Scene scene = new Scene(root);        
        stage.setScene(scene);
        
    }
    
    public void operarResultado(){
        
        //query que enviamos
        String query = "SELECT * FROM libro;";
        //creamos el arreglo de libros
        this.setLibros(c.eliminarLibro(query));
        //Si el resultado es nulo
       if (!this.libros.isEmpty()){
            this.populateTableView();
            this.tabla.setItems(libros);
        } else {
         //   this.tabla.setVisible(false);
        }
        
    }
    
    @FXML    
    public void eliminarProducto(ActionEvent event)
    {
        
        idSelect = tabla.getSelectionModel().getSelectedItem().getId();
        String query = "UPDATE public.libro SET stock=0 WHERE id='"+idSelect+"';" ;
        c.eliminarLibro(query);
        operarResultado();
    }
    
    private void populateTableView(){
    
            this.tablaID.setCellValueFactory(new PropertyValueFactory("id"));
            this.tablNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
            this.tablaStock.setCellValueFactory(new PropertyValueFactory("stock"));
            this.tablaPrecio.setCellValueFactory(new PropertyValueFactory("precio"));    
     
    }
    
    @FXML
    private void display(ActionEvent event) throws IOException {
        
        
        Stage stage = (Stage) root.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EliminarProducto.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        EliminarProductoController controllerSearch = fxmlLoader.<EliminarProductoController>getController();
        controllerSearch.operarResultado();
        Scene scene = new Scene(root);
        scene.getStylesheets().add("CSS/estilosTV.css");

        stage.setScene(scene);
        
    }
    
    public void resultadoVacio(){
        
    }
    
    public void setLibros(ObservableList<Libro> librosBD){
        this.libros = librosBD;
    }
    
    public void imprimirLibros(){
        for(int i = 0; i < libros.size(); i++){
            System.out.println(libros.get(i).getNombre());
        }
    }
    
}