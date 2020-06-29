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
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Felipe Fuenzalida
 */
public class ResultadosBusquedaController implements Initializable {

    private String busqueda;
    
    private Conector c;
    
    @FXML
    private ImageView back;
    
    @FXML
    private AnchorPane root;

    @FXML
    private ComboBox categoria;
    
    @FXML
    private TextField busquedaTextField;
    
    @FXML
    private Button btnBuscar;
    
    @FXML
    private Text mensajeVacio;
    
    @FXML
    private ImageView photo;
    
    @FXML    
    private TableView<Libro> tablaBusqueda;
    
    @FXML private TableColumn<Libro, String> imagenTV;
    @FXML private TableColumn<Libro, String> nombreTV;
    @FXML private TableColumn<Libro, String> lenguaTV;
    @FXML private TableColumn<Libro, Integer> paginasTV;
    @FXML private TableColumn<Libro, String> editorialTV;
    @FXML private TableColumn<Libro, Integer> precioTV;
    
    private ObservableList<Libro> libros;
    
    ObservableList<String> list = FXCollections.observableArrayList("Generalidades","Filosofía/Psicología","Religión","Ciencias Sociales","Lenguas","Matemáticas","Tecnología","Las artes","Literatura","Geografía/Historia");
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        categoria.setItems(list);
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
        String query = "SELECT * FROM libro WHERE nombre LIKE '"+busqueda+"%';";
        //creamos el arreglo de libros
        this.setLibros(c.busquedaLibros(query));
        
        //Si el resultado es nulo
        if (!this.libros.isEmpty()){
            this.mensajeVacio.setVisible(false);
            this.populateTableView();
            this.tablaBusqueda.setItems(libros);
        } else {
            this.tablaBusqueda.setVisible(false);
        }
        
    }
    
    private void populateTableView(){
    
            this.imagenTV.setCellValueFactory(new PropertyValueFactory("imagen"));
            this.nombreTV.setCellValueFactory(new PropertyValueFactory("nombre"));
            this.lenguaTV.setCellValueFactory(new PropertyValueFactory("lengua"));
            this.paginasTV.setCellValueFactory(new PropertyValueFactory("paginas"));
            this.editorialTV.setCellValueFactory(new PropertyValueFactory("editorial"));
            this.precioTV.setCellValueFactory(new PropertyValueFactory("precio"));            
     
    }
    
    @FXML
    private void display(ActionEvent event) throws IOException {
        
        Stage stage = (Stage) root.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ResultadosBusqueda.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        ResultadosBusquedaController controllerSearch = fxmlLoader.<ResultadosBusquedaController>getController();
        controllerSearch.setBusqueda(this.busquedaTextField.getText());
        controllerSearch.operarResultado();
        Scene scene = new Scene(root);
        scene.getStylesheets().add("CSS/estilosTV.css");

        stage.setScene(scene);
        
    }
    
    public void resultadoVacio(){
        
    }
    
    public void imprimirB(String b){
        System.out.println(this.busqueda);
    }
    
    public void setBusqueda(String busq){
        this.busqueda = busq;
    }
    
    public String getBusqueda(){
        return this.busqueda;
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