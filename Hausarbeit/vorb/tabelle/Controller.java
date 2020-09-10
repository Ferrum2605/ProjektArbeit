package tabelle;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Window;
import javafx.util.Callback;

public class Controller implements Initializable {

	@FXML
	TableView<Option> optionsTableView;
	@FXML
	TableColumn<Option, Integer> idColumn;
	@FXML
	TableColumn<Option, String> signColumn;
	@FXML
	TableColumn<Option, String> descriptionColumn;
	@FXML
	TableColumn<Option, Boolean> isSelectedColumn;
	@FXML
	TextField idTextField;
	@FXML
	TextField signTextField;
	@FXML
	TextField descriptionTextField;
	@FXML
	CheckBox isSelectedCheckBox;
	@FXML
	Button addButton;
	@FXML
	MenuBar menuBar;
	@FXML
	Menu fileMenu;
	@FXML
	MenuItem saveFileAsMenuItem;
	File file;
	FileChooser fileChooser;
	@FXML
	MenuItem openFileMenuItem;

	public void initialize(URL location, ResourceBundle resources) {
		// Spalte "ausgewählt": Aussehen/Art der Zelle (CheckBox)
		isSelectedColumn.setCellFactory(new Callback<TableColumn<Option, Boolean>, TableCell<Option, Boolean>>() {
			public TableCell<Option, Boolean> call(TableColumn<Option, Boolean> param) {
				CheckBoxTableCell<Option, Boolean> cell = new CheckBoxTableCell<>();
				return cell;
			}
		});
		// Spalte ausgewählt: Inhalt der Zelle (boolean)
		isSelectedColumn.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<Option, Boolean>, ObservableValue<Boolean>>() {
					public ObservableValue<Boolean> call(CellDataFeatures<Option, Boolean> param) {
						SimpleBooleanProperty booleanProperty = new SimpleBooleanProperty(
								param.getValue().isSelected());
						return booleanProperty;
					}
				});
		fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().add(new ExtensionFilter("Textdateien", "*.txt"));
	}

	@FXML
	public void add(ActionEvent event) {
		Model model = Model.getInstance();

		try {
			int id = Integer.valueOf(idTextField.getText());
			String sign = signTextField.getText();
			String description = descriptionTextField.getText();
			Boolean isSelected = isSelectedCheckBox.isSelected();
			model.createOption(id, sign, description, isSelected);
		} catch (NumberFormatException e) {
			System.out.println("Bitte Angaben auf Korrektheit und Vollständigkeit überprüfen");
			return;
		}
		optionsTableView.getItems().add(model.getOption());

	}

	@FXML
	public void saveFileAs(ActionEvent event) {
		Model model = Model.getInstance();
		String input = "";
		Window window = menuBar.getScene().getWindow();
		file = fileChooser.showSaveDialog(window);
		// Als Text ausgeben
//		try (FileWriter fileWriter = new FileWriter(file);
//				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
//			for (Option o : optionsTableView.getItems()) {
//				input += o.getOptionAttribute() + "\n";
//			}
//			bufferedWriter.write(input);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

		// Serialisierung
		try (FileOutputStream fos = new FileOutputStream(file); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(model.getOptions());

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@FXML
	public void openFile(ActionEvent event) {
	}
}
