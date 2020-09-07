package klausurvorbereitung;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class LoginController implements Initializable {

    private Model model;

    @FXML
    private TextField userInputTextField;

    @FXML
    private PasswordField passwordInputTextField;

    @FXML
    private Label errorLabel;

    @FXML
    private Button loginButton;

    public void initialize(URL location, ResourceBundle resources) {
        model = Model.getInstance();
        errorLabel.setTextFill(Color.RED);
        loginButton.setTextFill(Color.BLUE);
        userInputTextField.textProperty().bindBidirectional(model.getUserProperty());
        System.out.println("Initialized.");
    }

    @FXML
    public void login(ActionEvent event) throws IOException {
        String email = userInputTextField.getText();
        String password = passwordInputTextField.getText();
        String message = model.login(email, password);
        errorLabel.setText(message);

        if(message.equals("Login successful.")) {
            Scene oldScene = loginButton.getScene();
            Stage stage = (Stage) oldScene.getWindow();

            Parent root = FXMLLoader.load(getClass().getResource("LandingView.fxml"));
            Scene newScene = new Scene(root);
            stage.setTitle("Landingscreen");
            stage.setScene(newScene);
            stage.show();
        }
    }


}
