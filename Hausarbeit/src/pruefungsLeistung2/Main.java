package pruefungsLeistung2;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Meine Spiele");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}
