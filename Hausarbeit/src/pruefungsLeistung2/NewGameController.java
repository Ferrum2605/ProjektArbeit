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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
	ConsoleSystem cs;
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
		consoleSystemComboBox.getItems().addAll(ConsoleSystem.values());

	}
/**
 * neues SPiel wird hinzugefügt
 * @param event
 */
	@FXML
	public void addNewGame(ActionEvent event) {
		
		Model model = Model.getInstance();
		
		/**
		* Abhängig vom RadioButton werden hier die entsprechenden die entsprechenden Objekte erzeugt und in die txt geschrieben
		* @param event
		*/
		
		if (consoleGameRadioButton.isSelected()) {
			try {
				String title = titleTextField.getText();
				Genre genre = (Genre) genreComboBox.getValue();
				int year = Integer.valueOf(yearTextField.getText());
				ConsoleSystem cs = (ConsoleSystem) consoleSystemComboBox.getValue();
				model.generateConsoleGame(title, genre, year, false, cs);
				//System.out.println(year);
			} catch (NumberFormatException e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText("ERROR");
				alert.setContentText("Fehlerhafte Eingabe, bitte Eingaben überprüfen!");
				alert.showAndWait();
			}
		}
		
		
		
		if (pcGameRadioButton.isSelected()) {
			try {
			String title = titleTextField.getText();
			Genre genre = (Genre) genreComboBox.getValue();
			int year = Integer.valueOf(yearTextField.getText());
			OperatingSystem os = (OperatingSystem) consoleSystemComboBox.getValue();
			String systemRequirements = systemRequirementsTextField.getText();
			model.generatePCGame(title, genre, year, false, os, systemRequirements);
			} catch (NumberFormatException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("ERROR");
			alert.setContentText("Fehlerhafte Eingabe, bitte Eingaben überprüfen!");
			alert.showAndWait();
			}
			}
			if (mobileGameRadioButton.isSelected()) {
			try {
			String title = titleTextField.getText();
			Genre genre = (Genre) genreComboBox.getValue();
			int year = Integer.valueOf(yearTextField.getText());
			OperatingSystem os = (OperatingSystem) consoleSystemComboBox.getValue();
			model.generateMobileGame(title, genre, year, false, os);
			} catch (NumberFormatException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("ERROR");
			alert.setContentText("Fehlerhafte Eingabe, bitte Eingaben überprüfen!");
			alert.showAndWait();
			}
			}
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
		
		Model model = Model.getInstance();
		
		model.checkFile();

		//MainController con = new MainController();
		//con.getTableView().getItems().addAll(model.getGameList().getGameArrayList());
		
		stage.show();

	}
	/**
	 * Je nachdem ob PC, Konsole oder Mobile Games ausgewählt wird, werden die entsprechenden Optionen erlaubt oder
	 * nicht
	 * @param event
	 */
	@FXML
	public void radioSelect(ActionEvent event) {
		if (pcGameRadioButton.isSelected()) {
			consoleSystemComboBox.setDisable(true);
			operationSystemComboBox.setDisable(false);
			systemRequirementsTextField.setDisable(false);
			consoleGameRadioButton.setSelected(false);
			mobileGameRadioButton.setSelected(false);
		} else if (consoleGameRadioButton.isSelected()) {
			operationSystemComboBox.setDisable(true);
			systemRequirementsTextField.setDisable(true);
			consoleSystemComboBox.setDisable(false);
			pcGameRadioButton.setSelected(false);
			mobileGameRadioButton.setSelected(false);
		} else if (mobileGameRadioButton.isSelected()) {
			operationSystemComboBox.setDisable(false);
			consoleSystemComboBox.setDisable(true);
			systemRequirementsTextField.setDisable(true);
			pcGameRadioButton.setSelected(false);
			consoleGameRadioButton.setSelected(false);
		}
	}

}
