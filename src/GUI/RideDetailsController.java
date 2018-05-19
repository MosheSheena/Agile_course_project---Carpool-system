package GUI;


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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setRideDetails(String source, String destination, Integer pricePerHitchhiker, String driverName, Integer numHitchhiker) {
        sourceInput.setText(source);
        destinationInput.setText(destination);
        hitchhikerPriceInput.setText(pricePerHitchhiker.toString());
        driverInput.setText(driverName);
        numHitchhikerInput.setText(numHitchhiker.toString());
    }
}

