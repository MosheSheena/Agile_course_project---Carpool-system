package Core.Storage;

import Core.Logic.Ride;
import org.bson.Document;

public class StorageFacade {

    private MongoConnection connection;
    private boolean connectionActive;

    private final String USERS_COLLECTION = "users";

    private static StorageFacade ourInstance = new StorageFacade();
    public static StorageFacade getInstance() {
        return ourInstance;
    }

    private StorageFacade() {}

    public void openConnection(MongoCredentials credentials) {
        connection = new MongoConnection(credentials);
        connectionActive = true;
    }

    public boolean isConnectionLive() {
        return connectionActive;
    }

    public void closeConnection() {
        if(isConnectionLive()) {
            connection.closeConnection();
            connectionActive = false;
        }
    }

    public void registerNewUser(Document newUser)
            throws DBConnectionDownException {
        testDBConnectivity();

        CollectionWriter cw = new CollectionWriter
                (connection.getMongoDatabase(), USERS_COLLECTION);
        cw.writeDocument(newUser);
    }

    public boolean existsUser(User user) throws DBConnectionDownException,
            DocumentNotFoundException {
        testDBConnectivity();

        CollectionLoader cl = new CollectionLoader
                (connection.getMongoDatabase(), USERS_COLLECTION);

        int userHashedID = user.hashCode();
        Document doc = cl.loadDocument(userHashedID);
        if(doc == null)
            throw new DocumentNotFoundException("User doesn't exist in DB");

        return true;
    }

    public void saveNewRide(Document newRide, boolean isExecuted) {
    }

    public void updateRideStatus(Ride r) {
    }

    public void testDBConnectivity() throws DBConnectionDownException {
        if(!connectionActive)
            throw new DBConnectionDownException("Connection to DB is closed");
    }
}
