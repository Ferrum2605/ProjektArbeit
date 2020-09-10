package game;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class RollTheDiceController implements Initializable {

	private Model model;

	@FXML
	private TextField playerNameOne;

	@FXML
	private TextField playerNameTwo;

	@FXML
	private Label errorLabel;

	@FXML
	private Button rollTheDiceButton;

	public void initialize(URL location, ResourceBundle resources) {
		model = Model.getInstance();
		playerNameOne.setText(model.getPlayerOneName());
		playerNameTwo.setText(model.getPlayerTwoName());
		errorLabel.setTextFill(Color.RED);
		rollTheDiceButton.setTextFill(Color.BLUE);
		System.out.println("Initialized.");
	}

	@FXML
	public void rollTheDice(ActionEvent event) throws IOException {
		model.createGame(playerNameOne.getText(), playerNameTwo.getText());

		try {
			if (!playerNameOne.getText().equals("") && !playerNameTwo.getText().equals("")) {
				Scene oldScene = rollTheDiceButton.getScene();
				Stage stage = (Stage) oldScene.getWindow();
				
				Parent root = FXMLLoader.load(getClass().getResource("LandingView.fxml"));
				Scene newScene = new Scene(root);
				stage.setTitle("Landingscreen");
				stage.setScene(newScene);
				stage.show();
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

	}

}