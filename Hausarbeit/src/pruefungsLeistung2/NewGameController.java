package pruefungsLeistung2;

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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewGameController implements Initializable {

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
	Genre genre;
	OperatingSystem os;
	@FXML
	Button cancelButton;
	@FXML
	TextField systemRequirementsTextField;
	@FXML
	Label systemRequirementsLabel;
	@FXML
	Label consoleSystemLabel;
	@FXML
	ComboBox consoleSystemComboBox;

	/**
	 * ComboBoxen werden mit den entsprechenden Werten versehen
	 */
	public void initialize(URL location, ResourceBundle resources) {
		genreComboBox.getItems().addAll(Genre.values());
		operationSystemComboBox.getItems().addAll(OperatingSystem.values());

	}

	@FXML
	public void addNewGame(ActionEvent event) {

	}

	/**
	 * Szenenwechsel zur View "Meine Spiele"
	 * 
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

	@FXML
	public void radioSelect(ActionEvent event) {
		if (pcGameRadioButton.isSelected()) {
			operatingSystemLabel.setOpacity(1);
			operationSystemComboBox.setOpacity(1);
			systemRequirementsLabel.setOpacity(1);
			consoleSystemLabel.setOpacity(0);
			consoleSystemComboBox.setOpacity(0);
			systemRequirementsTextField.setOpacity(1);
			consoleGameRadioButton.setSelected(false);
			mobileGameRadioButton.setSelected(false);
		} else if (consoleGameRadioButton.isSelected()) {
			operatingSystemLabel.setOpacity(0);
			operationSystemComboBox.setOpacity(0);
			systemRequirementsLabel.setOpacity(0);
			consoleSystemLabel.setOpacity(1);
			consoleSystemComboBox.setOpacity(1);
			systemRequirementsTextField.setOpacity(0);
			pcGameRadioButton.setSelected(false);
			mobileGameRadioButton.setSelected(false);
		} else if (mobileGameRadioButton.isSelected()) {
			operatingSystemLabel.setOpacity(1);
			operationSystemComboBox.setOpacity(1);
			systemRequirementsLabel.setOpacity(0);
			consoleSystemLabel.setOpacity(0);
			consoleSystemComboBox.setOpacity(0);
			systemRequirementsTextField.setOpacity(0);
			pcGameRadioButton.setSelected(false);
			consoleGameRadioButton.setSelected(false);
		}
	}

}
