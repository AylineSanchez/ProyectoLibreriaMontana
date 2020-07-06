/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librerialamontana;


        
import Conexion.Conector;
import Modelo.Categoria;
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
public class ModificarCategoriaController implements Initializable {

    private Conector c;
    
    @FXML private AnchorPane root;
    @FXML private ImageView back;
    @FXML private TableView<Categoria> tabla;
    @FXML private TableColumn<Categoria, Integer> tablaID;
    @FXML private TableColumn<Categoria, String> tablaNombre;
    @FXML private Button botonModificar;
    @FXML private TextField campoDeTexto;
    

    private int idSelect;
    private ObservableList<Categoria> categorias;

     /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Conexión con la BD
        c = new Conector();
        c.conect();
        this.categorias = FXCollections.observableArrayList();
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
        String query = "SELECT * FROM categoria;";
        //creamos el arreglo de categorias
        this.setCategorias(c.modificarCategoria(query));
        //Si el resultado es nulo
       if (!this.categorias.isEmpty()){
            this.populateTableView();
            this.tabla.setItems(categorias);
        } else {
         //   this.tabla.setVisible(false);
        }
        
    }
    
    @FXML    
    public void modificarCategoria(ActionEvent event)
    {
        if(!tabla.getSelectionModel().isEmpty())
        {
            idSelect = tabla.getSelectionModel().getSelectedItem().getCodigo();
            String query = "UPDATE public.categoria SET nombre='"+campoDeTexto.getText()+"' WHERE codigo='"+idSelect+"';" ;
            c.eliminarLibro(query);
            operarResultado();
        }
        else
            System.out.println("Seleccione una categoría");
            
            
    }
    
    private void populateTableView(){
    
            this.tablaID.setCellValueFactory(new PropertyValueFactory("codigo"));
            this.tablaNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
     
    }
    
    @FXML
    private void display(ActionEvent event) throws IOException {
        
        
        Stage stage = (Stage) root.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ModificarCategoria.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        ModificarCategoriaController controllerSearch = fxmlLoader.<ModificarCategoriaController>getController();
        controllerSearch.operarResultado();
        Scene scene = new Scene(root);
        scene.getStylesheets().add("CSS/estilosTV.css");

        stage.setScene(scene);
        
    }
    
    
    public void setCategorias(ObservableList<Categoria> categoriasBD){
        this.categorias = categoriasBD;
    }
    
    public void imprimirCategorias(){
        for(int i = 0; i < categorias.size(); i++){
            System.out.println(categorias.get(i).getNombre());
        }
    }
    
}