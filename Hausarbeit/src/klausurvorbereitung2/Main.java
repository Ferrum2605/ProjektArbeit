package klausurvorbereitung2;

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
        Parent root = FXMLLoader.load(getClass().getResource("RollTheDiceView.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Project 2");
        primaryStage.setScene(scene);
        primaryStage.setHeight(250);
        primaryStage.setWidth(500);
        primaryStage.show();
    }

}
