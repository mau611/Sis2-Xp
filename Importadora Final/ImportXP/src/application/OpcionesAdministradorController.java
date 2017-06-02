/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mauricio
 */
public class OpcionesAdministradorController implements Initializable {
    
    @FXML private void AgregarEmpleado(ActionEvent e) throws IOException{
        Main.stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("RegistroEmpleado.fxml"));
        Scene scene = new Scene(root);
        Main.stage.setTitle("");
        Main.stage.setScene(scene);
        Main.stage.show();
    }
    @FXML private void GanarseElPan(ActionEvent e) throws IOException{
        Main.stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("SeleccionUsuario.fxml"));
        Scene scene = new Scene(root);
        Main.stage.setTitle("");
        Main.stage.setScene(scene);
        Main.stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    
}
