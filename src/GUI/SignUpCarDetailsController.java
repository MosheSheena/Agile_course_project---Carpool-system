package GUI;

import Core.Logic.Car;
import Core.Logic.CurrentUserDetail;
import Core.Logic.Hitchhiker;
import Core.Logic.RideDriver;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import de.jensd.fx.glyphs.GlyphsBuilder;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
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

public class SignUpCarDetailsController implements Initializable {

    private static final String EM1 = "1em";
    private static final String ERROR = "error";

    @FXML
    private JFXTextField regPlateInputField;

    @FXML
    private JFXButton signUpInfoNextButton;

    @FXML
    private JFXTextField modelInputField;

    @FXML
    private JFXTextField gasPerKMInput;

    @FXML
    private JFXButton signUpInfoSkipButton;

    @FXML
    private ImageView signUpReturnBasicInfoButton;

    @FXML
    private JFXTextField seatsInputField;

    @FXML
    private JFXTextField colorInputField;

    @FXML
    public void skipPressed(ActionEvent event) throws IOException {
        CurrentUserDetail currentUserDetail = CurrentUserDetail.getInstance();
        Hitchhiker hitchhiker = new Hitchhiker(currentUserDetail.getPerson());
        currentUserDetail.setUserRole(hitchhiker);
        goToUserPassScreen(event);
    }

    private void goToUserPassScreen(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SignUpUserPass.fxml"));

        Parent root = loader.load();
        Scene scene = new Scene(root);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.setTitle("Carpool");
        window.show();
    }

    @FXML
    public void nextPressed(ActionEvent event) throws IOException {
        //check for fields
        boolean allFilled = true;

        if (!modelInputField.validate())
            allFilled = false;
        if (!colorInputField.validate())
            allFilled = false;
        if (!seatsInputField.validate())
            allFilled = false;
        if (!gasPerKMInput.validate())
            allFilled = false;
        if (!regPlateInputField.validate())
            allFilled = false;


        if (allFilled) {
            Car c = new Car(modelInputField.getText(), colorInputField.getText(),
                    Integer.parseInt(seatsInputField.getText()),
                    Double.parseDouble(gasPerKMInput.getText()),
                    regPlateInputField.getText());
            CurrentUserDetail currentUserDetail = CurrentUserDetail.getInstance();
            RideDriver rideDriver = new RideDriver(currentUserDetail.getPerson());
            rideDriver.addCar(c);
            currentUserDetail.setUserRole(rideDriver);
            goToUserPassScreen(event);
        }
    }

    @FXML
    public void returnToBasicInfo(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SignUpScreen.fxml"));

        Parent root = loader.load();
        Scene scene = new Scene(root);

        Stage window;
        window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.setTitle("Sign up");
        window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setValidators();
    }

    private void setValidators() {
        RequiredFieldValidator validator;
        validator = new RequiredFieldValidator();
        validator.setMessage("Input Required");
        validator.setIcon(GlyphsBuilder.create(FontAwesomeIconView.class)
                .glyph(FontAwesomeIcon.WARNING)
                .size(EM1)
                .styleClass(ERROR)
                .build());
        modelInputField.getValidators().add(validator);
        modelInputField.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                modelInputField.validate();
            }
        });
        colorInputField.getValidators().add(validator);
        colorInputField.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                colorInputField.validate();
            }
        });
        seatsInputField.getValidators().add(validator);
        seatsInputField.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                seatsInputField.validate();
            }
        });
        gasPerKMInput.getValidators().add(validator);
        gasPerKMInput.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                gasPerKMInput.validate();
            }
        });
        regPlateInputField.getValidators().add(validator);
        regPlateInputField.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                regPlateInputField.validate();
            }
        });
    }
}
