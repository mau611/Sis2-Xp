package application;

import Codigo.DatosFactura;
import Codigo.verificacion1;
import java.net.URL;
import java.sql.ResultSet;
import java.time.LocalDate;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
//import application.ConectaDB;

public class RegistroNuevoClienteController implements Initializable{
        //ConectaDB conector=new ConectaDB();
	LocalDate fecha1;
	DatePicker fecha;
        @FXML private TextField txtNomcCliente;
        @FXML private TextField txtApeCliente;
        @FXML private TextField txtNitCi;
        @FXML private TextField txtNomProducto;
        @FXML private TextField txtCantPoducto;
        @FXML private TextField txtCstProducto;
        @FXML private DatePicker dateLLegada;
        @FXML private TextField txtCstPedido,fechaActual;
        @FXML private ComboBox comboProveedor=new ComboBox(llenarComboProveedor());
        @FXML private Button btnCancel,btnRegistroPedido, btnFactura;
        String tipoUsuario;
        int nit,cant,costoPro,costoPed;
        String nomPro;
        verificacion1 verificador=new verificacion1();
	@FXML public void btnRegistroPedidoAction(ActionEvent ev){
            boolean verificar=false;
            if(verificador.validarNombre(txtApeCliente.getText()) && verificador.validarNombre(txtNomcCliente.getText()) 
               && verificador.validarTelyCi(txtNitCi.getText()) && verificador.validarNombre(txtNomProducto.getText())
               && verificador.validarTelyCi(txtCantPoducto.getText()) && verificador.validarTelyCi(txtCstProducto.getText())
               && verificador.validarTelyCi(txtCstPedido.getText())){
                String apellidoCli = txtApeCliente.getText();
            String nombreCli = txtNomcCliente.getText();
            int carnetCli = Integer.parseInt(txtNitCi.getText());
            String nombreProducto=txtNomProducto.getText();
            String cantidadProducto=txtCantPoducto.getText();
            int productoCantidad=Integer.parseInt(cantidadProducto);
            String costoProducto=txtCstProducto.getText();
            int productoCosto=Integer.parseInt(costoProducto);
            String nombreProveedor=comboProveedor.getValue().toString();
            String fechaPedido=fechaActual.getText();
            String fechaLlegada=dateLLegada.getValue().toString();  
            String costoPedido=txtCstPedido.getText();
            int pedidoCosto=Integer.parseInt(costoPedido);
            ResultSet res;
            
            try {
                res=Main.conector.consultar("select registrarPedido('"+nombreCli+"','"+apellidoCli+"',"+carnetCli+",'"+nombreProducto+"',"+productoCantidad+","+productoCosto+",'"+nombreProveedor+"','"+fechaPedido+"','"+fechaLlegada+"',"+pedidoCosto+");");
                if (res.next()) {
                    int retorno=res.getInt("registrarPedido");
                    if (retorno>0) {
                        JOptionPane.showMessageDialog(null, " REGISTRADO ");
                        
                        //txtApeCliente;
                        nit = Integer.parseInt(txtNitCi.getText());
                        nomPro = txtNomProducto.getText();
                        cant = Integer.parseInt(txtCantPoducto.getText());
                        costoPro = Integer.parseInt(txtCstProducto.getText());
                        costoPed = Integer.parseInt(txtCstPedido.getText());
                        
                        txtNomcCliente.setText("");
                        txtApeCliente.setText("");
                        txtNitCi.setText("");
                        txtNomProducto.setText("");
                        txtCantPoducto.setText("");
                        txtCstProducto.setText("");
                        txtCstPedido.setText("");
                        
                        
                        
                    } else{
                        System.out.println(retorno);
                    }
                
                } else {
                    System.err.println("Error");
                }
            } catch (Exception e) {
                System.err.println("Error : "+e);
            }
            }else{
                JOptionPane.showMessageDialog(null, "NO REGISTRADO REVISE SI TIENE ERRORES");
            }
	}
        private ObservableList<String> llenarComboProveedor() { 

            ObservableList<String> items=FXCollections.observableArrayList();
            try {    
                ResultSet rs=null; 
                rs = Main.conector.consultar("SELECT proveedor.nombre_prov FROM proveedor");
                System.out.println("104");
                while (rs.next()) {
                    items.add(rs.getString(1));
                    System.err.println(rs.getString(1) +"**");
                }
        
            } catch(Exception err){err.printStackTrace();} 
            return items;
        }
        
        @FXML
        private void cancel(ActionEvent e){
        //JOptionPane.showMessageDialog(null, "Hola Mundo");
        try{
            Main.stage.close();
            Parent root = FXMLLoader.load(getClass().getResource("SeleccionUsuario.fxml"));
            Scene scene = new Scene(root);
	 
            Main.stage.setScene(scene);
            Main.stage.setTitle("Seleccion Usuario");
            Main.stage.show();
        }catch(Exception ess){
            System.err.println(ess);
        }
      }
        
    @FXML
    private void abrirFactura() {
        try
        {
            Stage facturaStage = new Stage();
            FXMLLoader loader= new FXMLLoader();
            AnchorPane root = (AnchorPane)loader.load(getClass().getResource("Factura.fxml").openStream());
            FacturaController facturaController=(FacturaController)loader.getController();
            facturaController.nit = ""+nit;
            facturaController.total = "" + costoPed;
            facturaController.anhadir(new DatosFactura(cant, nomPro, costoPro, costoPed));
            
            Scene scene = new Scene(root);
            facturaStage.setScene(scene);
            facturaStage.show();
        }
        catch(Exception e)
        {
            System.out.println("no se abrio nada");
        }
    }
        
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fechaActual.setText(verificador.fechaMostrar());
        fechaActual.setEditable(false);
        comboProveedor.setItems(llenarComboProveedor());
    } 
}
