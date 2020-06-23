/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librerialamontana;

import Conexion.Conector;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Felipe Fuenzalida
 */
public class ResultadosBusquedaController implements Initializable {

    private String busqueda;
    
    private Conector c;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        c = new Conector();
        c.conect();
    }    
    
    public void operarResultado(){
        String query = "SELECT * FROM libro WHERE nombre LIKE '"+busqueda+"%';";
        c.busquedaLA(query);
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
    
}
