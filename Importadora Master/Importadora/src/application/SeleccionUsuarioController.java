/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;


/**
 *
 * @author Usuario
 */

public class SeleccionUsuarioController {

    @FXML
    private void usuarioRegistrado(ActionEvent a){
        try{
            Main.stage.close();
            Parent root = FXMLLoader.load(getClass().getResource("clienteExistente.fxml"));
            Scene scene = new Scene(root);
                    //scene.getStylesheets().add(getClass().getResource("/pkgEstilo/principal.css").toExternalForm());
	 
            Main.stage.setScene(scene);
            Main.stage.setTitle("REGISTRO PEDIDOS");
            Main.stage.show();
        }catch(Exception e){
            System.err.println(e);
        }
    }
    @FXML
    private void usuarioNoRegistrado(ActionEvent a){
        try{
            Main.stage.close();
            Parent root = FXMLLoader.load(getClass().getResource("RegistroNuevoCliente.fxml"));
            Scene scene = new Scene(root);
                    //scene.getStylesheets().add(getClass().getResource("/pkgEstilo/principal.css").toExternalForm());
	 
            Main.stage.setScene(scene);
            Main.stage.setTitle("REGISTRO PEDIDOS");
            Main.stage.show();
        }catch(Exception e){
            System.err.println(e);
        }
    }
    @FXML
    private void cerrarSesion(ActionEvent a){
        try{
            
                Main.stage.close();
                Parent root = FXMLLoader.load(getClass().getResource("Inicio.fxml"));
                Scene scene = new Scene(root);
                    //scene.getStylesheets().add(getClass().getResource("/pkgEstilo/principal.css").toExternalForm());
	 
                Main.stage.setScene(scene);
                Main.stage.setTitle("INICIO");
                Main.stage.show();
            
        }catch(Exception e){
            System.err.println(e);
        }
    }
}