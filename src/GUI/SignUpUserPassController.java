package GUI;

import Core.Logic.Commuter;
import Core.Logic.CurrentUserDetail;
import Core.Logic.LogicFacade;
import Core.Storage.User;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
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

public class SignUpUserPassController implements Initializable {

    private static final String EM1 = "1em";
    private static final String ERROR = "error";

    @FXML
    private ImageView signUpReturnCarDetailButton;

    @FXML
    private JFXButton signUpNextButton;

    @FXML
    private JFXTextField signUpUsernameInput;

    @FXML
    private JFXPasswordField signUpPasswordInput;

    @FXML
    void nextPressed(ActionEvent event) throws IOException {

        boolean allFilled = true;

        if (!signUpUsernameInput.validate())
            allFilled = false;
        if (!signUpPasswordInput.validate())
            allFilled = false;


        if (allFilled) {

            CurrentUserDetail currentUserDetail = CurrentUserDetail.getInstance();

            LogicFacade logicFacade = LogicFacade.getInstance();
            Commuter commuter = currentUserDetail.getUserRole();
            logicFacade.registerNewUser(new User(signUpUsernameInput.getText(), signUpPasswordInput.getText(), commuter));

            currentUserDetail.setUsername(signUpUsernameInput.getText());
            currentUserDetail.setPassword(signUpPasswordInput.getText());

            FXMLLoader loader;
            loader = new FXMLLoader(getClass().getResource("CarpoolScreen.fxml"));

            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.setTitle("Carpool");
            window.show();
        }
    }

    @FXML
    public void returnCarDetail(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SignUpCarDetails.fxml"));

        Parent root = loader.load();
        Scene scene = new Scene(root);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
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
        signUpUsernameInput.getValidators().add(validator);
        signUpUsernameInput.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                signUpUsernameInput.validate();
            }
        });
        signUpPasswordInput.getValidators().add(validator);
        signUpPasswordInput.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                signUpPasswordInput.validate();
            }
        });
    }
}
