/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application; 

import java.net.InetAddress;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

public class LoginController implements Initializable {
  
    @FXML private TextField txtUsername;
    @FXML private PasswordField txtPassword;
 
    @FXML
    private void btnIniciarAction(ActionEvent event){
        String usuario=txtUsername.getText();
        String passwd=txtPassword.getText();
        String ip=dameIP();
        ResultSet res;
        
        try {
            res=Main.conector.consultar("Select autentificacionUser('"+usuario+"','"+passwd+"','"+ip+"');");
            if (res.next()) {
                String retorno=res.getString("autentificacionUser");
                if (retorno.equals("correcto")) {
                    Main.stage.close();
                    Parent root = FXMLLoader.load(getClass().getResource("SeleccionUsuario.fxml"));
                    Scene scene = new Scene(root);
                    Main.stage.setTitle("");
                    Main.stage.setScene(scene);
                    Main.stage.show();
                                            
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrectos...", "Error login", 0);
                    txtUsername.setText("");
                    txtPassword.setText("");
                    txtUsername.focusedProperty();
                }
                
            } else {
                System.err.println("Datos Incorrecto");
            }
        } catch (Exception e) {
            System.err.println("Error : "+e);
        }  
    }
    private String dameIP(){
        String res="";
        try{
            InetAddress loc = InetAddress.getLocalHost();
            res = loc.getHostAddress();
            System.out.println(res);
        }catch(Exception e){
               System.err.println(e + " asd");
        }
        return res;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
