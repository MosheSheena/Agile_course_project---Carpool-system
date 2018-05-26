package Core.Storage;

import Core.Logic.NoCarAssignedException;
import Core.Logic.NoRideDriverAssignedException;
import Core.Logic.Ride;
import com.google.gson.Gson;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

public class StorageFacade {

    private MongoConnection connection;

    private final String USERS_COLLECTION = "users";
    private final String RIDES_COLLECTION = "rides";

    private static StorageFacade ourInstance = new StorageFacade();
    public static StorageFacade getInstance() {
        return ourInstance;
    }

    private StorageFacade() {}

    public void openConnection() {
        //connection = new MongoConnection(credentials);
        connection = new MongoConnection("localhost", 27017, "agile");
    }

    public void closeConnection() {
        connection.closeConnection();
    }

    public void registerNewUser(Document newUser) {
        testDBConnectivity();

        CollectionHandler ch = new CollectionHandler
                (connection.getMongoDatabase(), USERS_COLLECTION);
        ch.writeDocument(newUser);
    }


    public boolean existsUser(String username)
            throws DocumentNotFoundException {
        testDBConnectivity();

        CollectionHandler ch = new CollectionHandler 
                (connection.getMongoDatabase(), USERS_COLLECTION);

        FindIterable<Document> allUserDocs = ch.loadAllDocuments();
        Gson gs = new Gson();

        for(Document d: allUserDocs) {
            User u = Adapters.docToUserAdapter(d);
            if(u.getUserName().equals(username))
                return true;
        }

        return false;
    }

    public void saveNewRide(Document newRide) {
        testDBConnectivity();

        CollectionHandler ch = new CollectionHandler
                (connection.getMongoDatabase(), RIDES_COLLECTION);
        ch.writeDocument(newRide);
    }

    public FindIterable<Document> loadAllUnexecutedRides() {
        CollectionHandler ch = new CollectionHandler
                (connection.getMongoDatabase(), RIDES_COLLECTION);
        return ch.loadAllDocuments();
    }

    public FindIterable<Document> loadRideHistory() {
        CollectionHandler ch = new CollectionHandler
                (connection.getMongoDatabase(), RIDES_COLLECTION);
        return ch.loadDocuments("executed", true);
    }

    public void updateRideStatusToExecuted(Ride r)
            throws DocumentNotFoundException, NoCarAssignedException,
            NoRideDriverAssignedException {

        CollectionHandler ch = new CollectionHandler
                (connection.getMongoDatabase(), RIDES_COLLECTION);

        FindIterable<Document> allRides = ch.loadAllDocuments();

        for (Document d: allRides) {
            Ride ride = Adapters.docToRideAdapter(d);
            if(r.equals(ride)) {
                String oldVal = (String) d.get("ride");
                ride.executeRide();
                ch.updateDocument("ride", oldVal,
                        Adapters.rideToJsonAdapter(ride));
                return;
            }
        }
        throw new DocumentNotFoundException("No such ride in DB");
    }

    public void updateRideDetails(Ride old, Ride updated) throws DocumentNotFoundException {
        CollectionHandler ch = new CollectionHandler
                (connection.getMongoDatabase(), RIDES_COLLECTION);

        FindIterable<Document> allRides = ch.loadAllDocuments();

        for (Document d: allRides) {
            Ride ride = Adapters.docToRideAdapter(d);
            if(ride.equals(old)) {
                String oldVal = (String) d.get("ride");
                ch.updateDocument("ride", oldVal,
                        Adapters.rideToJsonAdapter(updated));
                return;
            }
        }
        throw new DocumentNotFoundException("No such ride in DB");
    }

    public void testDBConnectivity() {}
}
