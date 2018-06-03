package GUI;


import Core.Logic.*;
import Core.Storage.DocumentNotFoundException;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RideDetailsController implements Initializable{

    @FXML
    public BorderPane borderPane;

    @FXML
    public JFXButton leaveRide;

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
        leaveRide.setDisable(true);
        CurrentUserDetail currentUserDetail = CurrentUserDetail.getInstance();
        if (!(currentUserDetail.getUserRole() instanceof RideDriver))
           cancelRide.setDisable(true);
        if(!ride.hasRoom())
            joinRide.setDisable(true);
        //if(!ride.canBeExecuted() || !(currentUserDetail.getUserRole() instanceof RideDriver))
          //  executeRide.setDisable(true);
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
            showDialog("Successfully joined!", "You joined the Ride " + chosenRide.toString());
            joinRide.setDisable(true);
            leaveRide.setDisable(false);
        } catch (NoSeatAvailableInRideException e) {
            showDialog("Out of seats", "No more room in Ride");
        }

    }

    private void showDialog(String title, String body) {
        StackPane stackPane;
        stackPane = new StackPane();
        Node beforeChange = borderPane.getLeft();
        borderPane.setLeft(stackPane);

        JFXDialogLayout jfxDialogLayout = new JFXDialogLayout();
        jfxDialogLayout.setHeading(new Text(title));
        jfxDialogLayout.setBody(new Text(body));

        JFXDialog jfxDialog = new JFXDialog(stackPane, jfxDialogLayout, JFXDialog.DialogTransition.CENTER);

        JFXButton closeDialogButton = new JFXButton("Okay");

        closeDialogButton.setOnAction((EventHandler<ActionEvent>) event1 -> {
            jfxDialog.close();
            borderPane.setLeft(beforeChange);
        });

        jfxDialogLayout.setActions(closeDialogButton);

        jfxDialog.show();
    }

    @FXML
    public void leavePressed(ActionEvent event) {
        Carpool carpool = Carpool.getInstance();
        CurrentUserDetail currentUserDetail = CurrentUserDetail.getInstance();
        carpool.removeCommuterFromRide(currentUserDetail.getUserRole(), chosenRide);

        showDialog("Successfully Leaved", "You have left the Ride " + chosenRide.toString());
        leaveRide.setDisable(true);
        joinRide.setDisable(false);
        executeRide.setDisable(true);
        cancelRide.setDisable(true);
    }

    @FXML
    public void executePressed(ActionEvent event) throws NoCarAssignedException, NoRideDriverAssignedException {
        Carpool carpool = Carpool.getInstance();
        boolean isExecuted = carpool.executeRide(chosenRide);

        //if (isExecuted) {
            showDialog("Ride executed!", "Ride " + chosenRide.toString() + "has set off!\nDrive safe ! :)");
            leaveRide.setDisable(true);
            joinRide.setDisable(true);
            executeRide.setDisable(true);
            cancelRide.setDisable(true);

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CarpoolScreen.fxml"));
            Parent root = fxmlLoader.load();
            CarpoolController carpoolController = fxmlLoader.getController();
            carpoolController.removeRideFromList(chosenRide);
            LogicFacade logicFacade = LogicFacade.getInstance();
            logicFacade.changeRideStatusToExecuted(chosenRide);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentNotFoundException e) {
            e.printStackTrace();
        }

        //}
        //else {
          //  showDialog("Failed to execute", "Ride " + chosenRide.toString() + "cannot be executed");
       // }
    }

    @FXML
    public void cancelPressed(ActionEvent event) {
        Carpool carpool = Carpool.getInstance();
        carpool.cancelRide(chosenRide);

        showDialog("Successfully canceled", "You have canceled the Ride " + chosenRide.toString());

    }

}

