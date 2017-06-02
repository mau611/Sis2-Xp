package application;
	
import application.ConectorBD.ConectaDB;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
        public static Stage stage;
         static ConectaDB conector;
	@Override
	public void start(Stage primaryStage) {
                conector = new ConectaDB();
                stage = primaryStage;
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Inicio.fxml"));
			Scene scene = new Scene(root,400,200);
			//Scene scene = new Scene(root);
                        //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
//                        stage.setTitle("LOGIN");
			stage.show();
			stage.setResizable(false);
		} catch(Exception e) {
			System.err.println("ERROR "+e);
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
