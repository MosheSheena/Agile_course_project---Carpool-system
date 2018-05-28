package GUI;

import Core.Logic.Person;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
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

import de.jensd.fx.glyphs.GlyphsBuilder;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignUpScreenController implements Initializable {

    private static final String EM1 = "1em";
    private static final String ERROR = "error";


    @FXML
    private JFXTextField ageInputField;

    @FXML
    private JFXTextField cityInputField;

    @FXML
    private JFXTextField nameInputField;

    @FXML
    private JFXTextField addressInputField;

    @FXML
    private JFXTextField idInputField;

    @FXML
    private ImageView signUpReturnLoginButton;

    @FXML
    private JFXButton signUpInfoNext;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setValidators();
    }

    @FXML
    public void returnLoginPressed(MouseEvent event) throws IOException {


        FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginScreen.fxml"));

        Parent root = loader.load();
        Scene scene = new Scene(root);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.setTitle("Sign up");
        window.show();
    }

    @FXML
    public void nextPressed(ActionEvent event) throws IOException {
        //check for fields
        boolean allFilled = true;

        if (!idInputField.validate())
            allFilled = false;
        if (!nameInputField.validate())
            allFilled = false;
        if (!addressInputField.validate())
            allFilled = false;
        if (!cityInputField.validate())
            allFilled = false;
        if (!ageInputField.validate())
            allFilled = false;

        if (allFilled) {

            // TODO: 20/05/18 find a better way to force people to enter int and not string by mistake
            Person p = new Person(Integer.parseInt(idInputField.getText()),
                    nameInputField.getText(),
                    addressInputField.getText(),
                    cityInputField.getText(),
                    Integer.parseInt(ageInputField.getText()));

            FXMLLoader loader = new FXMLLoader(getClass().getResource("SignUpCarDetails.fxml"));

            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.setTitle("Carpool");
            window.show();
        }
    }

    private void setValidators() {
        RequiredFieldValidator validator = new RequiredFieldValidator();
        validator.setMessage("Input Required");
        validator.setIcon(GlyphsBuilder.create(FontAwesomeIconView.class)
                .glyph(FontAwesomeIcon.WARNING)
                .size(EM1)
                .styleClass(ERROR)
                .build());
        idInputField.getValidators().add(validator);
        idInputField.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                idInputField.validate();
            }
        });
        nameInputField.getValidators().add(validator);
        nameInputField.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                nameInputField.validate();
            }
        });
        addressInputField.getValidators().add(validator);
        addressInputField.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                addressInputField.validate();
            }
        });
        cityInputField.getValidators().add(validator);
        cityInputField.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                cityInputField.validate();
            }
        });
        ageInputField.getValidators().add(validator);
        ageInputField.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                ageInputField.validate();
            }
        });
    }
}
