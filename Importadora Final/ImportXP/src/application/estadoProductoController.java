package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class estadoProductoController {
	@FXML
	private TextField campoId;
	@FXML
	private ComboBox<String> estado;
	@FXML
	private Button boton;
	
	ObservableList<String> estados = FXCollections.observableArrayList("Entregado","SinObservaciones","Danhado","En Deposito");
	
	@FXML
	private void inicializar(){
		estado.setItems(estados);
	}
}
