package application;

import Codigo.DatosFactura;
import Codigo.GenerarFactura;
import java.io.FileNotFoundException;

import com.itextpdf.text.DocumentException;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class FacturaController {
	@FXML
	private Label numeroFactura;
	@FXML
	private TextField campoNombre,campoNit,campoTotal;
	@FXML
	private DatePicker fecha;
	@FXML
	private Button generar,imprimir;
	@FXML
	private TableView<DatosFactura> tabla = new TableView<>();
	@FXML
	private TableColumn columnaCantidad,columnaProducto,columnaPrecio,columnaTotal;
	ObservableList<DatosFactura> lista;
        String nit;
        String total;
        DatosFactura datos2;
	GenerarFactura pdf = new GenerarFactura();
        public void anhadir(DatosFactura datos){
            lista = FXCollections.observableArrayList(datos);
            datos2=datos;
        }
	@FXML
	public void llenar(ActionEvent e) throws FileNotFoundException/*, DocumentException*/{
		columnaCantidad.setCellValueFactory(new PropertyValueFactory<DatosFactura, Integer>("cantidad"));
		columnaProducto.setCellValueFactory(new PropertyValueFactory<DatosFactura, String>("producto"));
		columnaPrecio.setCellValueFactory(new PropertyValueFactory<DatosFactura, Integer>("precioUnitario"));
		columnaTotal.setCellValueFactory(new PropertyValueFactory<DatosFactura, Integer>("total"));
		
		tabla.setItems(lista);
                campoNit.setText(nit);
                campoTotal.setText(total);
	}
        @FXML
        public void imprimirFactura() throws FileNotFoundException, DocumentException{
            pdf.crearPdf(campoNombre.getText()+campoNit.getText(), numeroFactura.getText(), campoNombre.getText(), campoNit.getText(),datos2.getCantidad(),datos2.getProducto(),datos2.getPrecioUnitario(),datos2.getTotal());
        }
}
