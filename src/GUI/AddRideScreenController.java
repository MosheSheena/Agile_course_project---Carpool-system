package GUI;

import Core.Logic.*;
import Core.Storage.User;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
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
import java.util.List;
import java.util.ResourceBundle;

public class AddRideScreenController implements Initializable {

    @FXML
    public ImageView returnCarpoolScreen;
    @FXML
    public JFXTextField destinationInputField;
    @FXML
    public JFXTextField sourceInputField;
    @FXML
    public JFXButton addRideButton;
    @FXML
    public JFXComboBox<Car> chooseCarCB;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        CurrentUserDetail currentUserDetail = CurrentUserDetail.getInstance();

        List<Car> carsOwned = currentUserDetail.getUserRole().getCarsOwned();
        chooseCarCB.getItems().addAll(carsOwned);
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
        Carpool carpool = Carpool.getInstance();
        Ride r = new Ride(destinationInputField.getText(), sourceInputField.getText());

        LogicFacade logicFacade = LogicFacade.getInstance();


        CurrentUserDetail currentUserDetail = CurrentUserDetail.getInstance();
        Commuter c = currentUserDetail.getUserRole();
        RideDriver rideDriver = new RideDriver(c.getId(), c.getName(), c.getAddress(), c.getCity(), c.getAge(), chooseCarCB.getSelectionModel().getSelectedItem());
        carpool.registerRide(r, rideDriver);

        logicFacade.registerNewRide(r);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("CarpoolScreen.fxml"));

        Parent root = loader.load();
        Scene scene = new Scene(root);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.setTitle("Carpool");
        window.show();
    }

    public void choosedCar(ActionEvent event) {
        Car c = chooseCarCB.getSelectionModel().getSelectedItem();

    }
}
