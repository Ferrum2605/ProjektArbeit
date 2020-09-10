package game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;

import javax.xml.soap.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class LandingController implements Initializable {

	private Model model = Model.getInstance();

	private ArrayList<Game> games = model.showAllGames();

	@FXML
	private Label playerOneLabel;

	@FXML
	private Label playerTwoLabel;

	@FXML
	private Label playerOneValue;

	@FXML
	private Label playerTwoValue;

	@FXML
	private TextArea showGamesTextField;

	@FXML
	private Button playAgainButton;

	@FXML
	private Button showGamesButton;

	public void initialize(URL location, ResourceBundle resources) {
		Game game = model.getGame();

		playerOneLabel.setText(game.getPlayer1());
		playerTwoLabel.setText(game.getPlayer2());
		playerOneValue.setText("" + game.getPlayer1points());
		playerTwoValue.setText("" + game.getPlayer2points());
	}

	public void playAgain(ActionEvent event) throws IOException {
		Node node = (Node) event.getSource();
		Scene oldScene = node.getScene();
		Stage stage = (Stage) oldScene.getWindow();

		Parent root = FXMLLoader.load(getClass().getResource("RollTheDiceView.fxml"));
		Scene newScene = new Scene(root);
		stage.setTitle("Projekt 2");
		stage.setScene(newScene);
		stage.show();
	}

	public void showGames() {
		int i = 1;
		
		for (Game game : games) {
			String gameNumber = "Game #" + i + ":\n";
			String gameData = game.getGame() + "\n\n";

			showGamesTextField.appendText(gameNumber);
			showGamesTextField.appendText(gameData);
			System.out.println("Game #" + i + ":\n");
			System.out.println(game.getGame() + "\n\n");
			i++;
		}

	}

}
