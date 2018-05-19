package GUI;

import Core.Logic.Car;
import Core.Logic.Ride;
import Core.Logic.RideDriver;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXRadioButton;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CarpoolController implements Initializable {

    @FXML
    private BorderPane borderPane;

    @FXML
    private JFXListView<Ride> jfxListView;

    @FXML
    private JFXRadioButton planned;

    @FXML
    private JFXRadioButton history;

    @FXML
    private ToggleGroup rideToggleGroup;

    @FXML
    private Label sourceInput;

    @FXML
    private Label destinationInput;

    @FXML
    private Label hitchhikerPriceInput;

    @FXML
    private Label driverInput;

    @FXML
    private Label numHitchhikerInput;

    private ObservableList<Ride> rides = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // TODO: 19/05/18 load rides list with rides from database
        Ride ride = new Ride("afeka", "modiin");
        Ride ride2 = new Ride("holland", "israel");
        Car testCar = new Car("mazda", "red", 3, 18.0, "1234-5");
        RideDriver rideDriver = new RideDriver(1224, "moshe", "boten", "rosh aiin", 13, testCar);
        ride.assignRideDriver(rideDriver);
        ride2.assignRideDriver(rideDriver);
        rides.add(ride);
        rides.add(ride2);
        jfxListView.setItems(rides);

        //assign listener for the list
        jfxListView.getSelectionModel().selectedItemProperty().addListener((ChangeListener<Ride>) (observable, oldValue, newValue) -> {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("RideDetails.fxml"));
            Parent root = null;
            try {
                root = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            borderPane.setCenter(root);

            RideDetailsController rideDetailsController = loader.getController();
            rideDetailsController.setRideDetails(newValue.getSource(), newValue.getDestination(), newValue.getPricePerHitchhiker(),
                    newValue.getRideDriver().getName(), newValue.getNumOfHichhikers());

        });
    }
}
