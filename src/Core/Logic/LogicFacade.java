package Core.Logic;

import Core.Storage.*;
import com.google.gson.Gson;
import com.mongodb.client.FindIterable;
import org.bson.Document;

import java.util.HashSet;
import java.util.Set;

public class LogicFacade {

    private static LogicFacade ourInstance = new LogicFacade();
    public static LogicFacade getInstance() {
        return ourInstance;
    }

    private static StorageFacade sf = StorageFacade.getInstance();

    private LogicFacade() {}

    public boolean checkIfUserExists(String username)
            throws DBConnectionDownException, DocumentNotFoundException {
        return sf.existsUser(username);
    }

    public void registerNewUser(User u) throws DBConnectionDownException {
        Document userDoc = new UserToDocumentAdapter(u).adaptToDocument();
        sf.registerNewUser(userDoc);
    }

    public Set<Ride> loadAllUnexecutedRides() {
        FindIterable<Document> unexecutedRides = sf.loadAllUnexecutedRides();

        Set<Ride> returnValue = new HashSet<>();
        Gson gs = new Gson();

        for (Document d: unexecutedRides) {
            Ride r = gs.fromJson(d.toJson(), Ride.class);
            returnValue.add(r);
        }
        return returnValue;
    }

    public Set<Ride> loadRideHistory() {
        FindIterable<Document> unexecutedRides = sf.loadRideHistory();

        Set<Ride> returnValue = new HashSet<>();
        Gson gs = new Gson();

        for (Document d: unexecutedRides) {
            Ride r = gs.fromJson(d.toJson(), Ride.class);
            returnValue.add(r);
        }
        return returnValue;
    }
}
