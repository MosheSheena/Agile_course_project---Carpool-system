
package GUI;

import Core.Logic.*;
import Core.Storage.*;
import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.bson.Document;

import java.util.Arrays;
import java.util.Set;


public class MainGUI extends Application {

    public static void main(String[] args) {

//        User u1 = new User("u1", "1234",
//                new Person(1, "Avi", "address1",
//                        "city1", 25));
//
//        Ride r1 = new Ride("d1", "s1");
//        r1.assignRideDriver(new RideDriver(2, "name1", "a2", "c2", 36, new Car("model1", "black", 6, 5, "123")));
//        try {
//            r1.addHitchhiker(new Hitchhiker(1, "Avi", "a1", "c1", 35));
//        } catch (NoSeatAvailableInRideException e) {
//            e.printStackTrace();
//        }
//
//        LogicFacade lf = LogicFacade.getInstance();
//
//        try {
//            lf.registerNewUser(u1);
//            boolean res = lf.checkIfUserExists(u1.getUserName());
//            System.out.printf("res="+res);
//
//            lf.registerNewRide(r1);
//
//            Set<Ride> unexecutedRides = lf.loadAllUnexecutedRides();
//            System.out.println(unexecutedRides);
//
//        } catch (DocumentNotFoundException e) {
//            e.printStackTrace();
//        }


        
        launch(args);

    }

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
