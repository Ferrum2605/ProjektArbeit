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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

public class StartPageController implements Initializable {
	
	@FXML
	RadioButton newCar;
	
	@FXML
	RadioButton usedCar;
	
	@FXML
	ComboBox<String> comboBoxMakers;
	
	@FXML
	TableView<Car> showCarsTableView;
	@FXML
	TableColumn<Car, String> typeColumn;
	@FXML
	TableColumn<Car, String> colorColumn;
	@FXML
	TableColumn<Car, Integer> hpColumn;
	@FXML
	TableColumn<Car, Character> fuelColumn;
	@FXML
	TableColumn<Car, Double> priceColumn;
	@FXML
	TableColumn<Car, Integer> previousOwnerColumn;
	@FXML
	TableColumn<Car, Integer> kmColumn;
	@FXML
	TableColumn<Car, Integer> registeredColumn;
	@FXML
	TableColumn<Car, Integer> warrantyColumn;
	@FXML
	Button createCarButton;
	
	private Model model;
	
	private ArrayList<Car> cars = new ArrayList<>();
	
	private ArrayList<String> brands = new ArrayList<>();

	public StartPageController() {
		
	}

	//Diese Methode wird beim Aufruf der Start View ausgeführt
	public void initialize(URL location, ResourceBundle resources) {
		
		//Radio-Button "Neuwagen" standardmäßig auswählen
		newCar.setSelected(true);
		
		//getModel
		model = Model.getInstance();
		
		//Mögliche Automarken über das Model aus der makers.txt auslesen
		try {
			brands = model.getMakers();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//Mögliche Automarken der Combobox hinzufügen und "Bitte auswählen" auswählen
		comboBoxMakers.getItems().add("Bitte auswählen"); 
		comboBoxMakers.getItems().addAll(FXCollections.observableArrayList(brands));
		comboBoxMakers.getSelectionModel().selectFirst();
				
		//Alle Autos aus der cars.txt Datei über das Model auslesen und speichern
		cars = model.getCarList().getCarList();
		
		//Autos zur Tabelle hinzufügen
		addFilteredCars();		
	}	
	
	//Bei klicken des Buttons "neues Auto anlegen" zur CreateCar View wechseln
	public void createCar(ActionEvent event) throws IOException{
		Scene oldScene = createCarButton.getScene();
		Stage stage = (Stage) oldScene.getWindow();

		Parent root = FXMLLoader.load(getClass().getResource("CreateCar.fxml"));
		Scene newScene = new Scene(root);
		stage.setTitle("Eingabe");
		stage.setScene(newScene);
		stage.show();
	}
	
	//Wenn der Button "ok" geklickt wird wird der Filter angewendet
	public void carSelectionOk(ActionEvent event) {
		showCarsTableView.getItems().clear();
		addFilteredCars();		
	}
	
	//Den Filter auf die Tabelle anwenden
	public void addFilteredCars() {
		for(Car c : cars) {
			if(comboBoxMakers.getValue().toString().equals("Bitte auswählen")) {
				if(c.isUsed() == usedCar.isSelected()) {
					showCarsTableView.getItems().add(c);
				}
			}
			else {
				if(c.getBrand().equals(comboBoxMakers.getValue().toString()) &&  c.isUsed() == usedCar.isSelected()) {
				showCarsTableView.getItems().add(c);
			}
			}
			
		}
	}
	
	//Genau 1 RadioButton muss ausgewählt sein
	public void newCarIsSelected(ActionEvent event) {
		if(usedCar.isSelected()) {
			usedCar.setSelected(false);
		}
		else {usedCar.setSelected(true);}
		
	}
	
	//Genau 1 RadioButton muss ausgewählt sein
	public void usedCarIsSelected(ActionEvent event) {
		if(newCar.isSelected()) {
			newCar.setSelected(false);
		}
		else {newCar.setSelected(true);}
	}
}
//
