package pruefungsLeistung2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.RadioButton;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

public class EditGameController implements Initializable{
	
	/**
	 * View funktioniert leider nicht aufgrund zeitlicher Probleme
	 */

	@FXML
	Label titleLabel;
	@FXML
	Label genreLabel;
	@FXML
	Label yearLabel;
	@FXML
	Label systemLabel;
	@FXML
	Label consoleSystemLabel;
	@FXML
	Label playedThroughLabel;
	@FXML
	CheckBox playedThroughCheckBox;
	@FXML
	ComboBox genreComboBox;
	@FXML
	ComboBox consoleSystemComboBox;
	@FXML
	TextField titleTextField;
	@FXML
	TextField yearTextField;
	@FXML
	RadioButton consoleGameRadioRadioButton;
	@FXML
	RadioButton pcGameRadioRadioButton;
	@FXML
	RadioButton mobileGameRadioRadioButton;
	@FXML
	Button saveChangesButton;
	@FXML
	Button cancelButton;

	
	/**
	 * Speichert die Änderungen
	 * @param event
	 */
	@FXML
	public void saveChanges(ActionEvent event) {
		//Coding funktioniert nicht - so war es gedacht
//		Model model = Model.getInstance();
//		model.getTableView();
//
//		ObservableList selectedItems = TableView.getSelectionModel().getSelectedItems();
//
//		Game g = (Game) selectedItems.get(0);
//		
//		model.removeGameFromGameList(g);
//
//		TableView.getItems().clear();
//		TableView.getItems().addAll(model.getGameList().getGameArrayList());
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		
		
	}

}