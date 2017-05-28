/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 *
 * @author henry hace tarea
 */
public class RegistroEmpleadoController {
    //CAMPOS DE TEXTO
    @FXML
    private TextField tfNombre,tfCi,tfTelefono,tfUsername,tfPass;
    String nombre,usuario,password;
    int carnet, telefono;
    @FXML private void btnAtras(ActionEvent e) throws IOException{
        Main.stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("OpcionesAdministrador.fxml"));
        Scene scene = new Scene(root);
        Main.stage.setTitle("");
        Main.stage.setScene(scene);
        Main.stage.show();
    }
    @FXML
    private void registrar(ActionEvent e){
        JOptionPane.showMessageDialog(null, "REGISTRADO");
    }
}