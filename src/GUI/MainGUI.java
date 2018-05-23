
package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class MainGUI extends Application {

    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.getIcons().add(new Image("icon.png"));
        stage.setTitle("Welcome to Carpool");
        stage.show();

        //load available carpools from database
        loadCarpoolFromDatabase();
    }

    private void loadCarpoolFromDatabase() {
        // TODO: 19/05/18
        //load data from database into a static class so that it can be accessible via all classes
    }


}
