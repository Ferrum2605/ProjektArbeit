package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxTableCell;
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
	Button addOptionButton;

	public void initialize(URL location, ResourceBundle resources) {
		// Spalte "ausgewählt": Aussehen/Art der Zelle (Kontrollkästchen)
		isSelectedColumn.setCellFactory(new Callback<TableColumn<Option, Boolean>, TableCell<Option, Boolean>>() {
			public TableCell<Option, Boolean> call(TableColumn<Option, Boolean> param) {
				CheckBoxTableCell<Option, Boolean> cell = new CheckBoxTableCell<>();
				return cell;
			}
		});
		// Spalte "ausgewählt": Inhalt der Zelle (boolscher Wahrheitswert)
		isSelectedColumn.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<Option, Boolean>, ObservableValue<Boolean>>() {
					public ObservableValue<Boolean> call(CellDataFeatures<Option, Boolean> param) {
						SimpleBooleanProperty booleanProperty = new SimpleBooleanProperty(
								param.getValue().isSelected());
						return booleanProperty;
					}
				});

	}

	public void addOption(ActionEvent event) {
		int id = Integer.valueOf(idTextField.getText());
		String sign = signTextField.getText();
		String description = descriptionTextField.getText();
		boolean isSelected = isSelectedCheckBox.isSelected();
		Option option = new Option(id, sign, description, isSelected);
		optionsTableView.getItems().add(option);
	}

}
