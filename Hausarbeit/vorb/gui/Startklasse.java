package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Startklasse extends Application {
	//test
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("ListView.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Erstellung Warenliste");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
