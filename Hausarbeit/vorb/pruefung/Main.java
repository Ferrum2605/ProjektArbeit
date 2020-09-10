package pruefung;

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
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("View.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Prüfungsleistung 2");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
