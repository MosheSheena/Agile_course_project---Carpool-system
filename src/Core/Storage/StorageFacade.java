package Core.Storage;

import Core.Logic.Ride;
import com.mongodb.client.FindIterable;
import org.bson.Document;

public class StorageFacade {

    private MongoConnection connection;

    private final String USERS_COLLECTION = "users";
    private final String RIDES_COLLECTION = "rides";

    private static StorageFacade ourInstance = new StorageFacade();
    public static StorageFacade getInstance() {
        return ourInstance;
    }

    private StorageFacade() {}

    /**
     * open a connection to a database
     * @param credentials the credentials for the wanted database
     */
    public void openConnection(MongoCredentials credentials) {
        connection = new MongoConnection(credentials);
    }

    /**
     * Check if the connection to the database is active
     * @return true if the connection is active
     */
    public boolean isConnectionLive() {
        return connection.getConnectionStatus().equals(ConnectionStatus.LIVE);
    }


    public void closeConnection() {
        if(isConnectionLive())
            connection.closeConnection();
    }

    /**
     * Register a new END-user of the system in the database
     * @param newUser the user to register
     * @throws DBConnectionDownException
     */
    public void registerNewUser(Document newUser)
            throws DBConnectionDownException {
        testDBConnectivity();

        CollectionHandler ch = new CollectionHandler
                (connection.getMongoDatabase(), USERS_COLLECTION);
        ch.writeDocument(newUser);
    }

    /**
     * Check if a user is registered to the database
     * @param username the user to check if registered
     * @return true if the user is found in the database
     * @throws DBConnectionDownException
     * @throws DocumentNotFoundException
     */
    public boolean existsUser(String username)
            throws DBConnectionDownException, DocumentNotFoundException {
        testDBConnectivity();

        CollectionHandler ch = new CollectionHandler 
                (connection.getMongoDatabase(), USERS_COLLECTION);

        Document doc = ch.loadDocument("username", username);
        if(doc == null)
            throw new DocumentNotFoundException("User doesn't exist in DB");

        return true;
    }

    public void saveNewRide(Document newRide)
            throws DBConnectionDownException {
        testDBConnectivity();

        CollectionHandler ch = new CollectionHandler
                (connection.getMongoDatabase(), RIDES_COLLECTION);
        ch.writeDocument(newRide);
    }

    public FindIterable<Document> loadAllUnexecutedRides() {
        CollectionHandler ch = new CollectionHandler
                (connection.getMongoDatabase(), RIDES_COLLECTION);
        return ch.loadDocuments("executed", false);
    }

    public FindIterable<Document> loadRideHistory() {
        CollectionHandler ch = new CollectionHandler
                (connection.getMongoDatabase(), RIDES_COLLECTION);
        return ch.loadDocuments("executed", true);
    }

    public void updateRideStatusToExecuted(Ride r)
            throws DBConnectionDownException {
        testDBConnectivity();

        CollectionHandler ch = new CollectionHandler
                (connection.getMongoDatabase(), USERS_COLLECTION);
        ch.updateDocument("executed", false, true);
    }

    public void testDBConnectivity() throws DBConnectionDownException {
        if(!connection.getConnectionStatus().equals(ConnectionStatus.LIVE))
            throw new DBConnectionDownException("Connection to DB is closed");
    }
}
