/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class DatosFactura {
	private final SimpleIntegerProperty cantidad;
	private final SimpleStringProperty producto;
	private final SimpleIntegerProperty precioUnitario;
	private final SimpleIntegerProperty total;
	public DatosFactura(int cantidad, String producto, int precioUnitario,int total){
		this.cantidad = new SimpleIntegerProperty(cantidad);
		this.producto = new SimpleStringProperty(producto);
		this.precioUnitario = new SimpleIntegerProperty(precioUnitario);
		this.total = new SimpleIntegerProperty(total);
	}
	
	public Integer getCantidad(){
		return cantidad.get();
	}
	public String getProducto(){
		return producto.get();
	}
	public Integer getPrecioUnitario(){
		return precioUnitario.get();
	}
	public Integer getTotal(){
		return total.get();
	}
}
