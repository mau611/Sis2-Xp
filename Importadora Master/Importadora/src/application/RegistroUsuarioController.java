package application;


import java.time.LocalDate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;

public class RegistroUsuarioController {
	LocalDate fecha1;
	@FXML
	DatePicker fecha;
	public void a(ActionEvent e){
		//fecha1.get
		//fecha1 = fecha.getValue();
		System.out.println(fecha.getValue());
		System.out.println(fecha.getValue().getYear());
		System.out.println(fecha.getValue().getMonth());
		System.out.println(fecha.getValue().getDayOfMonth());
	}
}
