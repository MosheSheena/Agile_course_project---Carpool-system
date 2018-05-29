package GUI;

import Core.Logic.CurrentUserDetail;
import Core.Logic.LogicFacade;
import Core.Logic.UserNotFoundException;
import Core.Storage.DocumentNotFoundException;
import Core.Storage.User;
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
import javafx.stage.Stage;

public class LoginScreenController implements Initializable {


    @FXML
    private JFXTextField username;

    @FXML
    private JFXPasswordField pass;

    @FXML
    private JFXButton login;

    @FXML
    private JFXButton signUp;

    @FXML
    void makeLogin(ActionEvent event) throws IOException {
        String usernameInput = username.getText();
        String passInput = pass.getText();

        LogicFacade logicFacade = LogicFacade.getInstance();
        boolean userExists = logicFacade.checkIfUserExists(usernameInput);

        if (userExists) {
            try {
                User user = logicFacade.getLoggedUser(usernameInput);
                CurrentUserDetail currentUserDetail = CurrentUserDetail.getInstance();
                currentUserDetail.setUsername(usernameInput);
                currentUserDetail.setPassword(passInput);
                currentUserDetail.setPerson(user.getPerson());
            } catch (UserNotFoundException e) {
                showNoUserFoundDialog();
            } catch (DocumentNotFoundException e) {
                e.printStackTrace();
            }


            //Assume login is good, we show the carpool window

            FXMLLoader loader = new FXMLLoader(getClass().getResource("CarpoolScreen.fxml"));

            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.setTitle("Carpool");
            window.show();
        }
        else {
            showNoUserFoundDialog();
        }

    }

    private void showNoUserFoundDialog() {
        // TODO: 29-05-18 show dialog that no user was found
    }

    @FXML
    void makeSignUp(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("SignUpScreen.fxml"));

        Parent root = loader.load();
        Scene scene = new Scene(root);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.setTitle("Sign up");
        window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO: 19/05/18 load database settings
    }

}
