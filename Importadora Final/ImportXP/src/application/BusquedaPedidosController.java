/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import Codigo.validacionesBusquedas;
import application.ConectorBD.ConectaDB;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;


/**
 *
 * @author Henry
 */
public class BusquedaPedidosController implements Initializable {
    /**
     * Este atributo idPedidoUP se actualiza cada vez que se selecciona una fila, para llenar o cambiar el estado de un pedido por Leider
     */
    private int idPedidoUP;
    @FXML
    private RadioButton rbCod,rbCliente,rbEstadoP,rbFechaI,rbFechaE, aux;
    @FXML
    private TextField tcod, tcliente; 
    @FXML
    private ComboBox estadoP;
    @FXML
    private Label l1,l2;
    @FXML
    private DatePicker f1,f2;
    @FXML 
    private TableView <ContenedorBusquedaPedido> tabla;
    private validacionesBusquedas validacion=new validacionesBusquedas();
    /**
     * referenciamos al combo pedido
     */
    @FXML 
    private ComboBox comboPedido=new ComboBox(llenarComboPedido());
    @FXML 
    private Button btnCambiar;
    
    @FXML
    private TableColumn <ContenedorBusquedaPedido,String> codPedido,ciVendedor, ciCliente, proveedor, fechaPed, fechaEstim, pagoTot,
            nomPro, cantidad;
    
     ObservableList <ContenedorBusquedaPedido> listaPedidos = FXCollections.observableArrayList();
 @FXML
 private void merbCodigo(ActionEvent a){
     if (aux!=null){
         aux.setSelected(false);
     }
     rbCod.setSelected(true);
     aux = rbCod;
     tcod.setVisible(true);
     tcod.clear();
     tcliente.setVisible(false);
     estadoP.setVisible(false);
     l1.setVisible(false);
     l2.setVisible(false);
     f1.setVisible(false);
     f2.setVisible(false);
     
    
 }
 @FXML
 private void merbCliente(ActionEvent a){
    if (aux!=null){
         aux.setSelected(false);
     }
    rbCliente.setSelected(true);
    aux=rbCliente;
    tcliente.setVisible(true);
    tcliente.clear();
    tcod.setVisible(false);
     estadoP.setVisible(false);
     l1.setVisible(false);
     l2.setVisible(false);
     f1.setVisible(false);
     f2.setVisible(false);
     
 }
 @FXML
 private void merbEstado(ActionEvent a){
     if (aux!=null){
         aux.setSelected(false);
     }
     rbEstadoP.setSelected(true);
     aux=rbEstadoP;
    estadoP.setVisible(true);
    //estadoP.setItems(FXCollections.observableArrayList("Sin Entregar", "Entregado", "Cancelado"));
    estadoP.setFocusTraversable(false);
 
    
    tcliente.setVisible(false);
    tcod.setVisible(false);
     l1.setVisible(false);
     l2.setVisible(false);
     f1.setVisible(false);
     f2.setVisible(false);
 }
 @FXML
 private void merbFechaI(ActionEvent a){
     if (aux!=null){
         aux.setSelected(false);
     }
     rbFechaI.setSelected(true);
    aux=rbFechaI;
    tcliente.setVisible(false);
    tcod.setVisible(false);
     estadoP.setVisible(false);
     l1.setVisible(true);
     l2.setVisible(true);
     f1.setVisible(true);
     f2.setVisible(true);
 }
 @FXML
 private void merbFechaE(ActionEvent a){
     if (aux!=null){
         aux.setSelected(false);
     }
     rbFechaE.setSelected(true);
    aux=rbFechaE;
    tcliente.setVisible(false);
    tcod.setVisible(false);
     estadoP.setVisible(false);
     l1.setVisible(true);
     l2.setVisible(true);
     f1.setVisible(true);
     f2.setVisible(true);
 }
    private String getConsulta(){
        String sqlBuscar = "SELECT p.id_pedido, "
                        + "p.id_usuario, "
                        + "p.id_cliente, "
                        + "pr.nombre_prov, "
                        + "p.fecha_pedido, "
                        + "p.fecha_llegada, "
                        + "p.costo_pedido, "
                        + "pro.nombre_pro, "
                        + "pp.cantidad_producto "
                        + "FROM pedido AS p, "
                        + "proveedor AS pr, "
                        + "producto_pedido AS pp, "
                        + "producto AS pro, "
                        + "estado_pedido AS ep "
                        + "WHERE p.id_pedido=pp.id_pedido AND "
                        + "pro.id_producto=pp.id_producto AND "
                        + "pr.id_proveedor=p.id_proveedor AND "
                        + "p.id_est=ep.id_est AND ";
        
        return sqlBuscar;
     }
    private void getLista(String condiciones){
        //codPedido,ciVendedor, ciCliente, proveedor, fechaPed, fechaEstim, pagoTot,nomPro, cantidad;
        try{
                String condicion=getConsulta() +condiciones;
                ResultSet rs =ConectaDB.consultar(condicion);
    
                while(rs.next()){
                   
                    ContenedorBusquedaPedido cont;
                    cont  = new ContenedorBusquedaPedido();
                    cont.codPedido=new SimpleStringProperty(""+rs.getInt("id_pedido"));
                    cont.ciCliente=new SimpleStringProperty(""+rs.getInt("id_cliente"));
                    cont.proveedor=new SimpleStringProperty(""+rs.getString("nombre_prov"));
                    cont.fechaP= new SimpleStringProperty(""+rs.getDate("fecha_pedido"));
                    cont.fechaE=new SimpleStringProperty(""+rs.getDate("fecha_llegada"));
                    cont.pago=new SimpleStringProperty(""+rs.getInt("costo_pedido"));
                    cont.ciVendedor=new SimpleStringProperty(""+rs.getInt("id_usuario"));
                    cont.producto=new SimpleStringProperty(""+rs.getString("nombre_pro"));
                    cont.cantidad=new SimpleStringProperty(""+rs.getInt("cantidad_producto"));
                    
                    listaPedidos.add(cont);
                }
              rs.close();
        }catch(Exception e){
            System.err.println("Error :" + e);
            JOptionPane.showMessageDialog(null, "Ingrese datos válidos");
        }
    }
    @FXML
    private void buscar(){
        if(aux==null){
            JOptionPane.showMessageDialog(null, "Seleccione alguna opción");
        }
        try{
            tabla.getItems().clear();
            if (aux==rbCod){
                if(validacion.validarTelyCi(tcod.getText())==true){
                    getLista( "p.id_pedido="+tcod.getText());
                }else{
                     JOptionPane.showMessageDialog(null, "El código contiene solo números");
                 } 
            }
            if(aux==rbCliente){  
                if(validacion.validarTelyCi(tcliente.getText())==true){
                    getLista("p.id_cliente="+tcliente.getText());
                }else{
                    JOptionPane.showMessageDialog(null, "CI no válido ");
                }       
            }
            if(aux==rbEstadoP){
               if (estadoP.getValue()!=null){
                   getLista("p.id_est=ep.id_est AND ep.descripcion_est="+"'"+estadoP.getValue()+ "'" );
               }else {
                   JOptionPane.showMessageDialog(null, "Elija una opción");
               } 
               
               
            }
            if(aux==rbFechaI){
                if(validacion.fechaValida(f1.getValue().toString(), f2.getValue().toString())==true){
                     getLista("p.fecha_pedido BETWEEN "+"'"+f1.getValue()+"' AND "+"'"+f2.getValue()+"'");
                }else{
                    JOptionPane.showMessageDialog(null, "La fecha introducida no es válida");
                 }
                
            }
            if(aux==rbFechaE){
                if(validacion.fechaValida(f1.getValue().toString(), f2.getValue().toString())==true){
                    getLista("p.fecha_llegada BETWEEN "+"'"+f1.getValue()+"' AND "+"'"+f2.getValue()+"'");
                }else{
                    JOptionPane.showMessageDialog(null, "La fecha introducida no es válida");
                }  
            }
            
        }catch(Exception e){
            System.err.println("ERROR " +e);
            JOptionPane.showMessageDialog(null, "Ingrese datos válidos");
        }
        tabla.setItems(listaPedidos);
    }
    /**
     * Funcion que hace esu de una funcion almacenada para cambiar de estado a un pedido
     * @param event 
     */
    @FXML
    private void btnCambiarAction(ActionEvent event){
        String estPedido=comboPedido.getValue().toString();
        try {
            ResultSet rs;
            rs=ConectaDB.consultar("SELECT cambiarEstadoPedido("+idPedidoUP+",'"+estPedido+"')");
            if (rs.next()) {
                   String retorno=rs.getString("cambiarEstadoPedido");
                 if (retorno.equals("correcto")) {
                     /**
                      * Mensaje de confirmacion por Leider
                      */
                       System.out.print("Se actualizo estado");
                       Alert dialogoAlert=new Alert(AlertType.INFORMATION);
                       dialogoAlert.setTitle("Mensaje de Confirmacion");
                       dialogoAlert.setHeaderText(null);
                       dialogoAlert.setContentText("Se cambio es estado del pedido!!");
                       dialogoAlert.initStyle(StageStyle.UTILITY);
                       dialogoAlert.showAndWait();
                 } else {
                         System.err.println("error: no se encontro el estado");
                         /**
                          * Mensaje de error por Leider
                          */
                        Alert dialogoAlert=new Alert(AlertType.ERROR);
                       dialogoAlert.setTitle("Mensaje de Error");
                       dialogoAlert.setHeaderText(null);
                       dialogoAlert.setContentText("No se pudo cambiar el estado del pedido!!");
                       dialogoAlert.initStyle(StageStyle.UTILITY);
                       dialogoAlert.showAndWait();
                 }
            } else {
                System.err.println("Error mas");
            }
            
        } catch (Exception e) {
            System.err.println("Error al cosultar funcion almacenada para cambiar estado pedido: "+e);
        }
    
        
    }
    /**
     * Funcion que llena el combo estado por leider
     * @return 
     */
    private ObservableList<String> llenarComboPedido() { 

     ObservableList<String> items=FXCollections.observableArrayList();
    try {    
        ResultSet rs=null; 
        rs = ConectaDB.consultar("SELECT descripcion_est FROM estado_pedido");
            //System.out.println("104");
                while (rs.next()) {
                    items.add(rs.getString(1));
                    System.err.println(rs.getString(1) +"**");
            
        }
        
                } catch(Exception err){err.printStackTrace();} 
     return items;
}
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /**
         * Desbilitamos el combo estado y el boton cambiar inicialmente
         */
        btnCambiar.setDisable(true);
        comboPedido.setDisable(true);
        /**
         * llenamos el combo estado pese a que este no estese habilitado
         */
          comboPedido.setItems(llenarComboPedido());
          codPedido.setCellValueFactory(cellData -> cellData.getValue().codPedido);
          ciVendedor.setCellValueFactory(cellData -> cellData.getValue().ciVendedor);
          ciCliente.setCellValueFactory(cellData -> cellData.getValue().ciCliente);
                proveedor.setCellValueFactory(cellData -> cellData.getValue().proveedor);
                fechaPed.setCellValueFactory(cellData -> cellData.getValue().fechaP);
                fechaEstim.setCellValueFactory(cellData -> cellData.getValue().fechaE);
                pagoTot.setCellValueFactory(cellData -> cellData.getValue().pago);
                nomPro.setCellValueFactory(cellData -> cellData.getValue().producto);
                cantidad.setCellValueFactory(cellData -> cellData.getValue().cantidad);
          
          codPedido.setStyle("-fx-alignment: CENTER;");
          ciVendedor.setStyle("-fx-alignment: CENTER;");
          ciCliente.setStyle("-fx-alignment: CENTER;");
          proveedor.setStyle("-fx-alignment: CENTER;");
          fechaPed.setStyle("-fx-alignment: CENTER;");
          fechaEstim.setStyle("-fx-alignment: CENTER;");
          pagoTot.setStyle("-fx-alignment: CENTER;");
          nomPro.setStyle("-fx-alignment: CENTER;");
          cantidad.setStyle("-fx-alignment: CENTER;");
          tabla.placeholderProperty().setValue(new Label(""));
          
          
       try{
            /**
             * Esto esta demas ....Quien lo puso -_- ????
             */
            String sqlEstado = "SELECT descripcion_est FROM estado_pedido";
            ResultSet resultadoCategoria = ConectaDB.consultar(sqlEstado);
            while(resultadoCategoria.next()) {
                estadoP.getItems().add(resultadoCategoria.getString("descripcion_est"));
            }
        }catch(Exception e){
            System.err.println(e);
        }
                    
        
         
         //tabla.setItems(FXCollections.observableList(listaPedidos));
    }
     @FXML
    private void click(MouseEvent e) throws IOException{
        if (e.getClickCount() == 2) //Checking double click
    {
        System.out.println(tabla.getSelectionModel().getSelectedItem().cantidad);
        System.out.println(tabla.getSelectionModel().getSelectedItem().ciCliente);
        String v=tabla.getSelectionModel().getSelectedItem().codPedido.toString();
        
        System.out.println(v+" "+v.length()+" "+v.substring(23,v.length()-1));
        String idParcial=v.substring(23,v.length()-1);
        int idPedido=Integer.parseInt(idParcial);
        activar();
        cargarDatos(idPedido);
        /**
         * idPedidoUp es para actualizar el estado del pedido;
         */
        idPedidoUP=idPedido;
       
    }
    }
    /**
     * ActivarComboBox y boton para cambiar de estado
     */
    public void activar(){
        btnCambiar.setDisable(false);
        comboPedido.setDisable(false);
    }
    /**
     * Apuntar al estado actual  del pedido en el comboEstado
     * @param idPedido 
     */
    public void cargarDatos(int idPedido){
        try {
            ResultSet rs;
            String sql="SELECT estado_pedido.descripcion_est\n" +
                                "FROM (SELECT pedido.id_est\n" +
                                "              FROM pedido\n" +
                                "              WHERE pedido.id_pedido="+idPedido+")uno,estado_pedido\n" +
                                "WHERE uno.id_est=estado_pedido.id_est";
            rs=ConectaDB.consultar(sql);
            if (rs.next()) {
                comboPedido.setValue(rs.getString("descripcion_est"));
            } else {
                System.err.println("Sin Estado");
            }
        } catch (SQLException ex) {
            System.err.println("Error al consultar : "+ex);
        }
        
    }
    @FXML 
    private void retornarAinicio(){
        try{
                Main.stage.close();
                Parent root = FXMLLoader.load(getClass().getResource("SeleccionUsuario.fxml"));
                Scene scene = new Scene(root);
                    //scene.getStylesheets().add(getClass().getResource("/pkgEstilo/principal.css").toExternalForm());
	 
                Main.stage.setScene(scene);
                Main.stage.setTitle("INICIO");
                Main.stage.show();
            
        }catch(Exception e){
            System.err.println(e);
        }
    }
    public TextField retTcod(){
        return tcod;
    }
    public TextField retTclient(){
        return tcliente;
    }
    public DatePicker retf1(){
        return f1;
    }
    public DatePicker retf2(){
        return f2;
    }
}
