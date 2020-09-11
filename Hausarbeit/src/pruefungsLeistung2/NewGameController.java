package pruefungsLeistung2;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewGameController {

	@FXML
	Label titleLabel;
	@FXML
	Label genreLabel;
	@FXML
	Label yearLabel;
	@FXML
	Label systemLabel;
	@FXML
	Label operatingSystemLabel;
	@FXML
	ComboBox genreComboBox;
	@FXML
	ComboBox operationSystemComboBox;
	@FXML
	TextField titleTextField;
	@FXML
	TextField yearTextField;
	@FXML
	RadioButton consoleGameRadioButton;
	@FXML
	RadioButton pcGameRadioButton;
	@FXML
	RadioButton mobileGameRadioButton;
	@FXML
	Button addNewGameButton;
	@FXML
	Button cancelButton;

	
	@FXML
	public void addNewGame(ActionEvent event) {
		
	}
	
	/**
	 * Szenenwechsel zur View "Meine Spiele"
	 * @param event
	 * @throws IOException 
	 */
	@FXML
	public void cancel(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) cancelButton.getScene().getWindow();
		stage.setScene(scene);
		
		stage.show();
		
	}

}
