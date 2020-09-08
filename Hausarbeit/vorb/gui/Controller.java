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
	TableView<Goods> optionsTableView;
	@FXML
	TableColumn<Goods, Integer> idColumn;
	@FXML
	TableColumn<Goods, String> descriptionColumn;
	@FXML TableColumn<Goods, String> classOfGoodsColumn;
	@FXML TableColumn<Goods, String> unitColumn;
	@FXML TableColumn<Goods, Double> priceColumn;
	@FXML TableColumn<Goods, String> currencyColumn;
	
	@FXML
	TextField idTextField;
	@FXML
	TextField descriptionTextField;
	
	@FXML TextField classOfGoodsTextField;
	@FXML TextField priceTextField;
	@FXML TextField currencyTextField;
	@FXML TextField unitTextField;
	@FXML Button addOptionButton;
	

	public void initialize(URL location, ResourceBundle resources) {
		
		Model model = Model.getInstance();

	}

	public void addOption(ActionEvent event) {
		int id = Integer.valueOf(idTextField.getText());
		String description = descriptionTextField.getText();
		String classOfGoods = classOfGoodsTextField.getText();
		String unit = unitTextField.getText();
		double price = Double.valueOf(priceTextField.getText());
		String currency = currencyTextField.getText();
	
		Goods option = new Goods(id, description, classOfGoods, unit, price, currency );
		optionsTableView.getItems().add(option);
	}

}
