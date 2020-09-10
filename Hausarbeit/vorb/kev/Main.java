package kev;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("Start.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Autohaus");
		primaryStage.setScene(scene);
		primaryStage.setHeight(500);
		primaryStage.setWidth(750);
		primaryStage.show();
	}
}