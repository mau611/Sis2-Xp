/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

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
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author Mauricio
 */
public class InicioController implements Initializable {
    @FXML ComboBox<String> usuario;
    ObservableList<String> opciones = FXCollections.observableArrayList("ADMINISTRADOR","EMPLEADO");
    
    @FXML private void ingresar(ActionEvent e) throws IOException{
        if(usuario.getValue().equals("ADMINISTRADOR")){
            Main.stage.close();
            Parent root = FXMLLoader.load(getClass().getResource("OpcionesAdministrador.fxml"));
            Scene scene = new Scene(root);
            Main.stage.setTitle("");
            Main.stage.setScene(scene);
            Main.stage.show();
        }else{
            Main.stage.close();
            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
            Scene scene = new Scene(root);
            Main.stage.setTitle("");
            Main.stage.setScene(scene);
            Main.stage.show();
        }
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       usuario.setItems(opciones);
        usuario.setValue(usuario.getItems().get(1));
    }    
    
}
