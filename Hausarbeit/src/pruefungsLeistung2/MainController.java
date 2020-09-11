package pruefungsLeistung2;

import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.event.ActionEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.Button;

public class MainController {

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

	@FXML
	public void saveGames(ActionEvent event) {
	}

	@FXML
	public void deleteAllGames(ActionEvent event) {
	}

	@FXML
	public void createNewGame(ActionEvent event) {
	}

	@FXML
	public void deleteSelectedGame(ActionEvent event) {
	}

}
