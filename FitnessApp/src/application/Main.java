package application;
/**
 * Main.java launches the Login.fxml view of a fitness application where the user can log in or create a new profile.
 * 
 * @author Ashley Nordquist (dbb246)
 * UTSA CS 3443 - Lab 5
 * Fall 2021
 * 
 * VERSION 2.0 - UPDATED 11/27/2021
 */
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		//Set up FXMLLoader
		try {			
			AnchorPane root = new AnchorPane();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation( Main.class.getResource("controller/Login.fxml") );
			root = (AnchorPane) loader.load();
			Scene scene = new Scene( root );
			primaryStage.setScene( scene );
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {	
		//Launch application
		launch(args);
	}
}