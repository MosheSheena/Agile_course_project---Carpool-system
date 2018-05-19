package GUI;

import Core.Logic.Ride;
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

    private ObservableList<Ride> rides = FXCollections.observableArrayList(new Ride("afeka", "modiin"), new Ride("holland", "israel"));


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // TODO: 19/05/18 load rides list with rides from database
        jfxListView.setItems(rides);

        //assign listener for the list
        jfxListView.getSelectionModel().selectedItemProperty().addListener((ChangeListener<Ride>) (observable, oldValue, newValue) -> {
            // Your action here
            System.out.println("Selected item: " + newValue);
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
