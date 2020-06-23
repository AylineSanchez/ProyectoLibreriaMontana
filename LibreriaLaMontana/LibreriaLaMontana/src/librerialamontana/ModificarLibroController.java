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
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Aylinee
 */
public class ModificarLibroController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private AnchorPane root;
    
    @FXML
    private TextField titulo;
    
    @FXML
    private TextField autor;
    
    @FXML
    private TextField descripcion;
    
    @FXML
    private TextField precio;
    
    @FXML
    private Button guardar;
    
    @FXML
    private Button cancelar;
    
    @FXML
    private Button cambiarImagen;
    
    @FXML
    private ImageView imagen;
    
    Connection con;
    //TENGO QUE TOMAR EL OBJETO
    int id=2;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        String nombreLibro="ksjksjdsa";
        String autorLibro="ksjdks";
        String descripcionLibro="sksadskdmskdsfdsf";
        String precioLibro="400";
        //imagen.setImage("");
        titulo.setText(nombreLibro);
        autor.setText(autorLibro);
        descripcion.setText(descripcionLibro);
        precio.setText(precioLibro);
    }    
    
    @FXML 
    private void guardarCambios(ActionEvent event) throws IOException{
        modificarLibro(titulo.getText(),autor.getText(),descripcion.getText(),precio.getText());
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
    
    private void modificarLibro(String titulo, String autor, String descripcion, String precio){
        try {
            Statement stmt = con.createStatement();
            //test existence of tables
            ResultSet rs;
            rs = stmt.executeQuery("UPDATE Libro SET nombre='"+titulo+"' , autor='"+autor+"' , descripcion='"
                    +descripcion+"' , precio='"+precio+"' WHERE id='"+id+"';");
            rs.close();
            stmt.close();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Modificacion exitosa");
            alert.setHeaderText("Se ha realizado una modificacion exitosa");
            alert.showAndWait();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Modificacion fallida");
            alert.setHeaderText("Ha ocurrido un problema con la base de datos, contactar al técnico");
            alert.showAndWait();
        }
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
