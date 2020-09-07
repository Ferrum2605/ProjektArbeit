package klausurvorbereitung2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;

import javax.xml.soap.Text;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class LandingController implements Initializable {

    private Model model = Model.getInstance();

    @FXML
    private Label playerOneLabel;
    
    @FXML
    private Label playerTwoLabel;
    
    @FXML
    private Label playerOneValue;
    
    @FXML
    private Label playerTwoValue;

    @FXML
    private Button playAgainButton;

    public void initialize(URL location, ResourceBundle resources) {
    	playerOneLabel.setText(model.getPlayerOneName());
    	playerTwoLabel.setText(model.getPlayerTwoName());
    	
    	Random rd = new Random();
    	int valueOne = rd.nextInt(6)+1;
    	int valueTwo = rd.nextInt(6)+1;
    	
    	playerOneValue.setText(""+valueOne);
    	playerTwoValue.setText(""+valueTwo);
    }

    public void playAgain(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Scene oldScene = node.getScene();
        Stage stage = (Stage) oldScene.getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("RollTheDiceView.fxml"));
        Scene newScene = new Scene(root);
        stage.setTitle("Projekt 2");
        stage.setScene(newScene);
        stage.show();
    }


}
