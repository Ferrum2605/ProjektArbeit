package pruefungsLeistung2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableCell;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.stage.Stage;
import javafx.util.Callback;
import tabelle.Option;
import javafx.scene.control.TableColumn;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class MainController implements Initializable {

	@FXML
	MenuBar menuBar;
	@FXML
	Menu fileMenu;
	@FXML
	MenuItem saveMenuItem;
	@FXML
	MenuItem deleteAllMenuItem;
	@FXML
	TableView TableView;
	@FXML
	TableColumn titleColumn;
	@FXML
	TableColumn genreColumn;
	@FXML
	TableColumn yearColumn;
	@FXML
	TableColumn systemColumn;
	@FXML
	TableColumn playedThroughColumn;
	@FXML
	Button createNewGameButton;
	@FXML
	Button deleteSelectedGameButton;

	
	/**
	 * Aussehen/Art der Zelle "playedThroughColumn" wird mit CheckBox versehen
	 * Der Inhalt der Checkbox wird mit einem Boolean-Wert versehen
	 */
	public void initialize(URL location, ResourceBundle resources) {
		
		playedThroughColumn.setCellFactory(new Callback<TableColumn<Game, Boolean>, TableCell<Game, Boolean>>() {
			public TableCell<Game, Boolean> call(TableColumn<Game, Boolean> param) {
				CheckBoxTableCell<Game, Boolean> cell = new CheckBoxTableCell<>();
				return cell;
			}
		});
		playedThroughColumn.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<Game, Boolean>, ObservableValue<Boolean>>() {
					public ObservableValue<Boolean> call(CellDataFeatures<Game, Boolean> param) {
						SimpleBooleanProperty booleanProperty = new SimpleBooleanProperty();
								param.getValue().isPlayedThrough();
						return booleanProperty;
					}
				});	
	}

	@FXML
	public void saveGames(ActionEvent event) {
	}

	@FXML
	public void deleteAllGames(ActionEvent event) {
	}

	/**
	 * Szenenwechsel zur View "Neues Spiel anlegen"
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void createNewGame(ActionEvent event) throws IOException {
		
		Parent root = FXMLLoader.load(getClass().getResource("Output.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) createNewGameButton.getScene().getWindow();
		stage.setScene(scene);
		stage.show();

		
	}

	@FXML
	public void deleteSelectedGame(ActionEvent event) {
	}

	
}
