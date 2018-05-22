package GUI;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class AddRideScreenController implements Initializable {

    @FXML
    public ImageView returnCarpoolScreen;
    @FXML
    public JFXTextField idInputField;
    @FXML
    public JFXTextField nameInputField;
    @FXML
    public JFXTextField addressInputField;
    @FXML
    public JFXTextField cityInputField;
    @FXML
    public JFXTextField ageInputField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void returnCarpoolPressed(MouseEvent mouseEvent) {

    }

    @FXML
    public void addPressed(ActionEvent event) {
    }
}
