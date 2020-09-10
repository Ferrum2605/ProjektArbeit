package kev;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

public class CreateCarController implements Initializable{
	
	
	@FXML
	RadioButton isNewRadioButton; //d
	@FXML 
	Label chooseCarLabel; //d
	@FXML
	RadioButton isUsedRadioButton; //d
	@FXML
	Label headlineLabel;//d
	@FXML Button deleteButton; //d
	@FXML Label brandLabel; //d
	@FXML ComboBox<String> brandComboBox; //d
	@FXML Button addBrandButton; 
	@FXML Label typeLabel; //d
	@FXML TextField typeTextField; //d
	@FXML Label colorLabel; //d
	@FXML TextField colorTextField; //d
	@FXML Label hpLabel; //d
	@FXML TextField hpTextField; //d
	@FXML Label fuelLabel; //d
	@FXML ComboBox<Character> fuelComboBox; //d
	@FXML Label priceLabel; //d
	@FXML TextField priceTextField; //d
	@FXML Label warrantyLabel; //d
	@FXML TextField warrantyTextField; //d
	@FXML Label isUsedLabel; //d
	@FXML TextField isUsedTextField; //d
	@FXML Label kmLabel; //d
	@FXML TextField kmTextField; //D
	@FXML Label registeredLabel; //d
	@FXML TextField registeredTextField; //d
	@FXML Button saveButton; 
	
	
	String brand;
	String type;
	String color;
	int hp;
	Character fuel;
	int price;
	int warranty;
	boolean isUsed;
	int km;
	int registered;
	int previousOwner;
	Model model;
	ArrayList<String> brands;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		isNewRadioButton.setSelected(true);
		 model = Model.getInstance();
		 
			/*
			 * Auslesen der ComboBox Fuel und speichern in der variable fuel
			 */
			ObservableList<Character> options2 = FXCollections.observableArrayList('d', 'b');
			fuelComboBox.getItems().addAll(options2);
			fuelComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
				fuel = newValue;
			});
		 								
			
			//Mögliche Automarken über das Model aus der makers.txt auslesen
			try {
				brands = model.getMakers();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			//Mögliche Automarken der Combobox hinzufügen und "Bitte auswählen" auswählen
			brandComboBox.getItems().add("Bitte auswählen"); 
			brandComboBox.getItems().addAll(FXCollections.observableArrayList(brands));
			brandComboBox.getSelectionModel().selectFirst();
	}
	
	@FXML
	public void deleteCars(ActionEvent event) throws IOException{
		model.purgeCarListData();;
	}
	
	
	
//	public void goToStartButton(ActionEvent event) throws IOException{
//		Node node = (Node) event.getSource();
//		Scene oldScene = node.getScene();
//		Stage stage = (Stage) oldScene.getWindow();
//		
//		
//
//		Parent root = FXMLLoader.load(getClass().getResource("Start.fxml"));
//		Scene newScene = new Scene(root);
//		stage.setTitle("Start");
//		stage.setScene(newScene);
//		stage.show();
//	}
	
	@FXML
	public void saveNewCar(ActionEvent event)throws IOException{
		
		
		
		/*
		 * auslesen und übergeben der textfelder
		 */
		
		type = typeTextField.getText();
		color = colorTextField.getText();
		hp = Integer.valueOf(hpTextField.getText());
		price = Integer.valueOf(priceTextField.getText());
		warranty = Integer.valueOf(warrantyTextField.getText());
		previousOwner =  Integer.valueOf(isUsedTextField.getText());
		km = Integer.valueOf(kmTextField.getText());
		registered = Integer.valueOf(registeredTextField.getText());
		
		
		Car c = new Car(brand, type, color, isUsed, hp, fuel, price, previousOwner, km, registered, warranty);
		
		model.addCarToCarList(c);
		
		/*
		 * Szene wechseln
		 */
		
		Node node = (Node) event.getSource();
		Scene oldScene = node.getScene();
		Stage stage = (Stage) oldScene.getWindow();
		
		

		Parent root = FXMLLoader.load(getClass().getResource("Start.fxml"));
		Scene newScene = new Scene(root);
		stage.setTitle("Start");
		stage.setScene(newScene);
		stage.show();
	}

	@FXML public void addBrand(ActionEvent event) {}{

	}

	public void isold(ActionEvent event){
	        if(isNewRadioButton.isSelected()) {
	        	isNewRadioButton.setSelected(false);
	        	isUsed = true;
	        }
	        else {isNewRadioButton.setSelected(true);
	        isUsed = false;
	        }

	    }

	    public void isnew(ActionEvent event) {
	        if(isUsedRadioButton.isSelected()) {
	            isUsedRadioButton.setSelected(false);
	            isUsed = false;
	        }
	        else {isUsedRadioButton.setSelected(true);
	        isUsed = true;}
	    }
	}
	
	//igoeuh

	


