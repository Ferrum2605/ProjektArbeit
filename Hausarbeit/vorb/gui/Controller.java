package gui;

import java.io.IOException;
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
import supermarkt.ClassOfGoods;
import supermarkt.Currency;

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
	@FXML Button saveButton;
	

	public void initialize(URL location, ResourceBundle resources) {
		
		Model model = Model.getInstance();
		Goods good;
		try{
			while(model.checkArrayList())
			{

				good = null;

				good = model.zurueck();
				optionsTableView.getItems().add(good);
				good.displayProduct();

				System.out.println("TEst");
				if(good!=null)
				{
					break;
				}
				

			}
		
			
		}
		catch (Exception e) {
	        // Gib die Fehlermeldung aus die aufgetreten ist
	        System.out.println("Konnte die Datei "+
	             " nicht erstellen:\n"+e.getMessage());
	    }

	}

	public void addOption(ActionEvent event) {
		Model model = Model.getInstance();
		
		int id = Integer.valueOf(idTextField.getText());
		String description = descriptionTextField.getText();
		String classOfGoods = classOfGoodsTextField.getText();
		String unit = unitTextField.getText();
		double price = Double.valueOf(priceTextField.getText());
		String currency = currencyTextField.getText();
		 
		optionsTableView.getItems().add(model.addGoods(id, description, classOfGoods, unit, price, currency ));
	}

	@FXML public void save(ActionEvent event) {
		Model model = Model.getInstance();
		model.sp();
	}

}
