package GUI;


import Core.Logic.*;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class RideDetailsController implements Initializable {

    @FXML
    private Label sourceInput;

    @FXML
    private Label numHitchhikerInput;

    @FXML
    private Label destinationInput;

    @FXML
    private Label hitchhikerPriceInput;

    @FXML
    private Label driverInput;

    @FXML
    private JFXButton joinRide;

    @FXML
    private JFXButton cancelRide;

    @FXML
    private JFXButton executeRide;

    private Ride choosenRide;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void initButtons(Ride ride) {
        // check for permissions - and show pressable buttons accordingly
        // if user is the ride driver - allow to cancel drive
        // if ride has room - allow to join
        // if ride is allowed to be executed - allow execute
        choosenRide = ride;
        // TODO: 20/05/18 see if the logged in user is the ride driver
        if(!ride.hasRoom())
            joinRide.setDisable(true);
        if(!ride.canBeExecuted())
            executeRide.setDisable(true);
    }

    public void setRideDetails(String source, String destination, Integer pricePerHitchhiker, String driverName, Integer numHitchhiker) {
        sourceInput.setText(source);
        destinationInput.setText(destination);
        hitchhikerPriceInput.setText(pricePerHitchhiker.toString());
        driverInput.setText(driverName);
        numHitchhikerInput.setText(numHitchhiker.toString());
    }

    @FXML
    public void joinPressed(ActionEvent event) {
        Carpool carpool = Carpool.getInstance();
        // TODO: 20/05/18 assign current user
        //carpool.assignCommuterToRide('current user', choosenRide);
    }

    @FXML
    public void leavePressed(ActionEvent event) {
        Carpool carpool = Carpool.getInstance();
        // TODO: 20/05/18 remove current user
        //carpool.removeCommuterFromRide('current user', choosenRide);
    }

    @FXML
    public void executePressed(ActionEvent event) throws NoCarAssignedException, NoRideDriverAssignedException {
        Carpool carpool = Carpool.getInstance();
        carpool.executeRide(choosenRide);
    }

    @FXML
    public void cancelPressed(ActionEvent event) {
        Carpool carpool = Carpool.getInstance();
        carpool.cancelRide(choosenRide);
    }
}

