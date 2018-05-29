package GUI;


import Core.Logic.*;
import Core.Storage.User;
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

    private Ride chosenRide;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }

    public void initButtons(Ride ride) {
        // check for permissions - and show pressable buttons accordingly
        // if user is the ride driver - allow to cancel drive
        // if ride has room - allow to join
        // if ride is allowed to be executed - allow execute
        chosenRide = ride;
       CurrentUserDetail currentUserDetail = CurrentUserDetail.getInstance();
       if (!(currentUserDetail.getUserRole() instanceof RideDriver))
           cancelRide.setDisable(true);
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
        CurrentUserDetail currentUserDetail = CurrentUserDetail.getInstance();
        Commuter commuter = currentUserDetail.getUserRole();
        try {
            carpool.assignCommuterToRide(commuter, chosenRide);
        } catch (NoSeatAvailableInRideException e) {
            showNoSeatAvailableDialog();
        }
        // TODO: 23-05-18 bind to listener so we can know if ride status had change and notify accordingly
    }

    private void showNoSeatAvailableDialog() {
        // TODO: 29-05-18 show no seat dialog
    }

    @FXML
    public void leavePressed(ActionEvent event) {
        Carpool carpool = Carpool.getInstance();
        CurrentUserDetail currentUserDetail = CurrentUserDetail.getInstance();
        carpool.removeCommuterFromRide(currentUserDetail.getUserRole(), chosenRide);
        // TODO: 22-05-18 notify ride drive or hitchhikers
    }

    @FXML
    public void executePressed(ActionEvent event) throws NoCarAssignedException, NoRideDriverAssignedException {
        Carpool carpool = Carpool.getInstance();
        carpool.executeRide(chosenRide);
    }

    @FXML
    public void cancelPressed(ActionEvent event) {
        Carpool carpool = Carpool.getInstance();
        carpool.cancelRide(chosenRide);
        // TODO: 22-05-18 notify all commuters
    }
}

