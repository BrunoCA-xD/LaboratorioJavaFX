package application;
	
import java.io.File;
import java.net.URL;
import java.util.Calendar;
import java.util.Locale;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = null;
			URL url = new File(getClass().getResource("dinamicConstruction.fxml").getPath()).toURI().toURL();
			root = FXMLLoader.load(url);
			Scene scene = new Scene(root);
			
			scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
