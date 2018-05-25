package Core.Storage;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoConnection {

    private MongoClient mongoClient;
    private MongoDatabase mongoDatabase;

    public MongoConnection(String hostName, Integer port, String dbName) {
        mongoClient = new MongoClient(hostName, port);
        mongoDatabase = mongoClient.getDatabase(dbName);
    }

    public MongoConnection(MongoCredentials credentials) {
        mongoClient = new MongoClient
                (credentials.getHostName(), credentials.getPortNum());
        mongoDatabase = mongoClient.getDatabase(credentials.getDbName());
    }

    public MongoDatabase getMongoDatabase() {
        return mongoDatabase;
    }

    public void closeConnection() {
        mongoClient.close();
    }
}
