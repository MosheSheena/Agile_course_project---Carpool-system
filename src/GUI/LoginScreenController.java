package GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginScreenController implements Initializable {

  
    @FXML
    private AnchorPane anchorPane;

    @FXML
    private JFXTextField username;

    @FXML
    private JFXPasswordField pass;

    @FXML
    private JFXButton login;

    @FXML
    void makeLogin(ActionEvent event) throws IOException {
        //authentication logic

        //Assume login is good, we show the carpool window

        FXMLLoader loader = new FXMLLoader(getClass().getResource("CarpoolScreen.fxml"));

        Parent root = loader.load();
        Scene scene = new Scene(root);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.setTitle("Carpool");
        window.show();

    }

    @FXML
    void makeSignUp(ActionEvent event) {
        // TODO: 19/05/18 write new user to database
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO: 19/05/18 load database settings
    }

}
