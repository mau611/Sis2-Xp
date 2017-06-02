/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Usuario
 */
public class ContenedorBusquedaPedido {
    SimpleStringProperty codPedido,ciVendedor,ciCliente,proveedor,fechaP,fechaE,pago,producto,cantidad;
   
   public ContenedorBusquedaPedido(){
       
   }
   public void aString(){
       System.out.println(codPedido+", "+ ciVendedor+ ", "+ ciCliente+", "+ proveedor+ ", "+ fechaP+", "+ fechaE+", "
       +pago+", "+ producto+", "+ cantidad);
   }
}
