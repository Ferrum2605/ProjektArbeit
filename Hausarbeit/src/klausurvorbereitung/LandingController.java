package klausurvorbereitung;

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
import java.util.ResourceBundle;

public class LandingController implements Initializable {

    private Model model = Model.getInstance();

    @FXML
    private Label greetingLabel;

    @FXML
    private TextField userInputTextField;

    @FXML
    private PasswordField passwordInputTextField;

    @FXML
    private Button createUser;

    @FXML
    private Button deleteUser;

    @FXML
    private Button logoutButton;

    public void initialize(URL location, ResourceBundle resources) {

        greetingLabel.textProperty().bind(model.getUserProperty());
        // greetingLabel.setText("Hi " + model.getUserName());
        System.out.println("Initialized.");
    }

    public void createUser() {
        try {
            model.createUser(userInputTextField.getText(), passwordInputTextField.getText());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public void deleteUser() {
        try {
            model.deleteUser(userInputTextField.getText(), passwordInputTextField.getText());
        } catch (IOException e) {
            System.out.println("Error while deleting user.");
            e.printStackTrace();
        }
    }

    public void logout(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Scene oldScene = node.getScene();
        Stage stage = (Stage) oldScene.getWindow();
        greetingLabel.setText("");

        Parent root = FXMLLoader.load(getClass().getResource("LoginView.fxml"));
        Scene newScene = new Scene(root);
        stage.setTitle("Projekt 1");
        stage.setScene(newScene);
        stage.show();
    }


}

