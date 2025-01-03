package authentication_pages;

import java.io.IOException;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginPage extends Application {
	public static void main(String[] args) throws SQLException {
		Application.launch();
	}

	public void start(Stage baseStage) throws IOException {
		//Created a stage were frontend window will be shown
		Stage stage = new Stage();
		stage.setTitle("Login Page");

		// Parent class is used instead of Group class because of AnchorPane method is
		// in Parent class
		// Data will be loaded for the given class and resource by getClass() and
		// getResource() method and filename is mandatory
		Parent actorGroup = FXMLLoader.load(getClass().getResource("/LoginMain.fxml"));
		
		//Setting scene and added actorGroup in that scene
		Scene scene = new Scene(actorGroup, 600, 400);
		stage.setScene(scene);

		//Showing frontend window by show method which is present inside the Stage class
		stage.show();
	}
}
