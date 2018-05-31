package Core.Logic;

import Core.Storage.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mongodb.client.FindIterable;
import org.bson.Document;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class LogicFacade {

    private static LogicFacade ourInstance = new LogicFacade();
    public static LogicFacade getInstance() {
        return ourInstance;
    }

    private static StorageFacade sf;

    private LogicFacade() {
        sf = StorageFacade.getInstance();
        sf.provideCredentials("localhost", 27017, "agile");
    }

    public boolean checkIfUserExists(String username) {
        sf.openConnection();
        boolean res = sf.existsUser(username);
        sf.closeConnection();
        return res;
    }

    public void setServerCredentials(String hostname, int portnum, String dbname) {
        sf.provideCredentials(hostname, portnum, dbname);
    }

    public boolean registerNewUser(User u) {

        Document userDoc = Adapters.userToDocAdapter(u);
        if(checkIfUserExists(u.getUserName()))
            return false;

        sf.openConnection();
        sf.registerNewUser(userDoc);
        sf.closeConnection();
        return true;
    }

    public void registerNewRide(Ride r) {
        sf.openConnection();

        sf.saveNewRide(Adapters.rideToDocAdapter(r));

        sf.closeConnection();
    }

    public Set<Ride> loadAllUnexecutedRides() {
        sf.openConnection();
        Set<Ride> unexecutedRides = new HashSet<>();

        FindIterable<Document> unExecutedRidesDocs = sf.loadAllUnexecutedRides();

        for(Document d: unExecutedRidesDocs) {
            Ride r = Adapters.docToRideAdapter(d);
            if(!r.isExecuted())
                unexecutedRides.add(r);
        }

        sf.closeConnection();
        return unexecutedRides;
    }

    public Set<Ride> loadRideHistory() {
        sf.openConnection();
        Set<Ride> rideHistory = new HashSet<>();

        FindIterable<Document> allRidesDocs = sf.loadAllUnexecutedRides();

        for(Document d: allRidesDocs) {
            Ride r = Adapters.docToRideAdapter(d);
            if(r.isExecuted())
                rideHistory.add(r);
        }

        sf.closeConnection();
        return rideHistory;
    }

    public void changeRideStatusToExecuted(Ride r)
            throws NoRideDriverAssignedException, DocumentNotFoundException,
            NoCarAssignedException {

        sf.openConnection();

        sf.updateRideStatusToExecuted(r);

        sf.closeConnection();
    }

    public void updateRide(Ride currentRide, Ride newRide)
            throws DocumentNotFoundException {
        sf.openConnection();

        sf.updateRideDetails(currentRide, newRide);

        sf.closeConnection();
    }

    public User getLoggedUser(String username)
            throws UserNotFoundException, DocumentNotFoundException {
        if(!checkIfUserExists(username))
            throw new UserNotFoundException("No user with that name");

        sf.openConnection();

        FindIterable<Document> allUsers = sf.loadAllUsers();

        for(Document d: allUsers) {
            User u = Adapters.docToUserAdapter(d);
            if(u.getUserName().equals(username)) {
                return u;
            }
        }

        sf.closeConnection();

        return null;
    }
}
