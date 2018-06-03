package GUI;

import Core.Logic.LogicFacade;
import Core.Logic.Ride;
import Core.Logic.RideStatusObserver;
import com.jfoenix.controls.*;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

public class CarpoolController implements Initializable, RideStatusObserver {

    @FXML
    private BorderPane borderPane;

    @FXML
    private JFXListView<Ride> jfxListView;

    @FXML
    private JFXRadioButton plannedRadioButton;

    @FXML
    private JFXRadioButton historyRadioButton;

    @FXML
    private ToggleGroup rideToggleGroup;

    @FXML
    private JFXButton addRideButton;

    @FXML
    private MenuItem signOutMenuItem;

    @FXML
    private MenuBar mainMenuBar;

    private ObservableList<Ride> plannedRides = FXCollections.observableArrayList();

    private ObservableList<Ride> historyRides = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        LogicFacade logicFacade = LogicFacade.getInstance();

        Set<Ride> plannedRidesDB = logicFacade.loadAllUnexecutedRides();
        Set<Ride> historyDB = logicFacade.loadRideHistory();
        plannedRides.addAll(plannedRidesDB);
        historyRides.addAll(historyDB);

       /* Ride ride = new Ride("afeka", "modiin");
        Ride ride2 = new Ride("holland", "israel");
        Car testCar = new Car("mazda", "red", 3, 18.0, "1234-5");
        RideDriver rideDriver = new RideDriver(1224, "moshe", "boten", "rosh aiin", 13, testCar);
        ride.assignRideDriver(rideDriver);
        ride2.assignRideDriver(rideDriver);
        plannedRides.add(ride);
        plannedRides.add(ride2);*/

        jfxListView.setItems(plannedRides);

        plannedRadioButton.setSelectedColor(Color.web("2196F3"));
        historyRadioButton.setSelectedColor(Color.web("2196F3"));

        //assign listener for the list
        jfxListView.getSelectionModel().selectedItemProperty().addListener((ChangeListener<Ride>) (observable, oldValue, newValue) -> {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("RideDetails.fxml"));
            Parent root = null;
            try {
                root = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            RideDetailsController rideDetailsController = loader.getController();
            // if list is empty we might have null value in newValue
            if(newValue != null) {
                rideDetailsController.setRideDetails(newValue.getSource(), newValue.getDestination(), newValue.getPricePerHitchhiker(),
                        newValue.getRideDriver().getName(), newValue.getNumOfHitchhikers());
                rideDetailsController.initButtons(newValue);

                borderPane.setCenter(root);
            }

        });

        //assign listener for the radio buttons
        rideToggleGroup.selectedToggleProperty().addListener((ChangeListener<Toggle>) (observableValue, oldToggle, newToggle) -> {
            if(newToggle == plannedRadioButton) {
                jfxListView.setItems(plannedRides);
                jfxListView.refresh();
            }
            if(newToggle == historyRadioButton) {
                jfxListView.setItems(historyRides);
                jfxListView.refresh();
            }
        });
    }

    @FXML
    public void addRidePressed(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddRideScreen.fxml"));

        Parent root = loader.load();
        Scene scene = new Scene(root);

        Stage window;
        window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.setTitle("Add Ride");
        window.show();
    }

    @FXML
    public void signOut(ActionEvent event) throws IOException {
        FXMLLoader loader;
        loader = new FXMLLoader(getClass().getResource("LoginScreen.fxml"));

        Parent root = loader.load();
        Scene scene = new Scene(root);

        Stage window = (Stage)mainMenuBar.getScene().getWindow();
        window.setScene(scene);
        window.setTitle("Sign up");
        window.show();
    }

    @FXML
    public void about(ActionEvent event) {
        StackPane stackPane = new StackPane();
        Node previousNode = borderPane.getCenter();
        borderPane.setCenter(stackPane);

        JFXDialogLayout jfxDialogLayout = new JFXDialogLayout();
        jfxDialogLayout.setHeading(new Text("About"));
        jfxDialogLayout.setBody(new Text("Created by:\nAmit Levy, Moshe Sheena, Itay Ta'asiri, Tomer Spivak"));

        JFXDialog jfxDialog = new JFXDialog(stackPane, jfxDialogLayout, JFXDialog.DialogTransition.CENTER);

        JFXButton closeDialogButton = new JFXButton("Okay");

        closeDialogButton.setOnAction((EventHandler<ActionEvent>) event1 -> {
            jfxDialog.close();
            borderPane.setCenter(previousNode);
        });

        jfxDialogLayout.setActions(closeDialogButton);

        jfxDialog.show();

    }

    @Override
    public void onJoinRideAction() {

    }

    @Override
    public void onLeaveRideAction() {

    }

    @Override
    public void onCancelRideAction() {

    }

    @Override
    public void onExecuteRideAction() {

    }
}
