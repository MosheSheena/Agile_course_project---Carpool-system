package GUI;

import Core.Logic.Carpool;
import Core.Logic.LogicFacade;
import Core.Logic.Ride;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddRideScreenController implements Initializable {

    @FXML
    public ImageView returnCarpoolScreen;
    @FXML
    public JFXTextField destinationInputField;
    @FXML
    public JFXTextField sourceInputField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void returnCarpoolPressed(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CarpoolScreen.fxml"));

        Parent root = loader.load();
        Scene scene = new Scene(root);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.setTitle("Carpool");
        window.show();

    }

    @FXML
    public void addPressed(ActionEvent event) throws IOException {
        // TODO: 22-05-18 get user
        Carpool carpool = Carpool.getInstance();
        Ride r = new Ride(destinationInputField.getText(), sourceInputField.getText());
        //carpool.registerRide(r, getUser());

        LogicFacade logicFacade = LogicFacade.getInstance();
        logicFacade.registerNewRide(r);


        FXMLLoader loader = new FXMLLoader(getClass().getResource("CarpoolScreen.fxml"));

        Parent root = loader.load();
        Scene scene = new Scene(root);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.setTitle("Carpool");
        window.show();
    }
}
