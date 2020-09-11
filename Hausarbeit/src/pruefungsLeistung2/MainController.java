package pruefungsLeistung2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.stage.Stage;
import javafx.util.Callback;

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
	@FXML ContextMenu contextMenu;
	@FXML MenuItem newGameMenuItem;
	@FXML MenuItem deleteGameMenuItem;
	@FXML MenuItem changeGameMenuItem;

	/**
	 * Aussehen/Art der Zelle "playedThroughColumn" wird mit CheckBox versehen Der
	 * Inhalt der Checkbox wird mit einem Boolean-Wert versehen
	 * Fügt Objekte der ArrayList in die Tabelle ein
	 */
	public void initialize(URL location, ResourceBundle resources) {

		Model model = Model.getInstance();

		playedThroughColumn.setCellFactory(new Callback<TableColumn<Game, Boolean>, TableCell<Game, Boolean>>() {
			public TableCell<Game, Boolean> call(TableColumn<Game, Boolean> param) {
				CheckBoxTableCell<Game, Boolean> cell = new CheckBoxTableCell<>();
				return cell;
			}
		});
		playedThroughColumn.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<Game, Boolean>, ObservableValue<Boolean>>() {
					public ObservableValue<Boolean> call(CellDataFeatures<Game, Boolean> param) {
						SimpleBooleanProperty booleanProperty = new SimpleBooleanProperty(
								param.getValue().isPlayedThrough());
						return booleanProperty;
					}
				});

		try {
			model.checkFile();
				
			
			TableView.getItems().addAll(model.getGameList().getGameArrayList());
			
			
			/*System.out.println(model.getGameList().getGameArrayList().get(0).getPublishingYear());
			 * Bis hier hin hat er das Jahr, schreibt es nur nicht in TAbleView rein ...
			 */

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public TableView getTableView() {
		return TableView;
	}

	public void setTableView(TableView tableView) {
		TableView = tableView;
	}

	/**
	 * Objekte werden in txt gespeichert
	 * @param event
	 * @throws FileNotFoundException
	 */
	@FXML
	public void saveGames(ActionEvent event) throws FileNotFoundException {

		Model model = Model.getInstance();
		model.checkFile();

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Gespeichert!");
		alert.setHeaderText("Speichern erfolgreich");
		// alert.setContentText("Speichern erfolgreich!!");
		alert.showAndWait();
	}
/**
 * Alle Spiele werden gelöscht
 * @param event
 * @throws FileNotFoundException
 */
	@FXML
	public void deleteAllGames(ActionEvent event) throws FileNotFoundException {

		Model model = Model.getInstance();
		model.purgeGameListData();

		TableView.getItems().clear();
		TableView.getItems().addAll(model.getGameList().getGameArrayList());
	}

	/**
	 * Szenenwechsel zur View "Neues Spiel anlegen"
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void createNewGame(ActionEvent event) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("NewGameView.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) createNewGameButton.getScene().getWindow();
		stage.setScene(scene);
		stage.setTitle("Neues Spiel anlegen");
		stage.setHeight(500);
		stage.setWidth(600);
		stage.show();

	}
/**
 * Entsprechendes ausgewähltes Spiel wird gelöscht
 * @param event
 */
	@FXML
	public void deleteSelectedGame(ActionEvent event) {

		Model model = Model.getInstance();

		ObservableList selectedItems = TableView.getSelectionModel().getSelectedItems();

		Game g = (Game) selectedItems.get(0);
		TableView.getSelectionModel().getSelectedIndex();
		model.removeGameFromGameList(g);

		TableView.getItems().clear();
		TableView.getItems().addAll(model.getGameList().getGameArrayList());

	}
/*
 * Szenenwechsel um neues Spiel erstellen zu können
 */
	@FXML
	public void newGame(ActionEvent event) throws IOException {
		
		Parent root = FXMLLoader.load(getClass().getResource("NewGameView.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) createNewGameButton.getScene().getWindow();
		stage.setScene(scene);
		stage.setTitle("Neues Spiel anlegen");
		stage.setHeight(500);
		stage.setWidth(600);
		stage.show();
	}
/**
 * Szenenwechsel zur Bearbeitungsansicht - Bearbeitung ist leider nicht möglich
 * @param event
 * @throws IOException
 */
	@FXML
	public void changeGame(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("EditGameView.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) createNewGameButton.getScene().getWindow();
		stage.setScene(scene);
		stage.setHeight(500);
		stage.setWidth(600);
		stage.setTitle("Spiel bearbeiten");
		stage.show();
		
	}
/*
 * Ausgewähltes Spiel wird gelöscht
 */
	@FXML
	public void deleteGame(ActionEvent event) {
		
		Model model = Model.getInstance();

		ObservableList selectedItems = TableView.getSelectionModel().getSelectedItems();

		Game g = (Game) selectedItems.get(0);
		TableView.getSelectionModel().getSelectedIndex();
		model.removeGameFromGameList(g);

		TableView.getItems().clear();
		TableView.getItems().addAll(model.getGameList().getGameArrayList());

	}

}
