package Core.Storage;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
import com.mongodb.event.ServerHeartbeatFailedEvent;
import com.mongodb.event.ServerHeartbeatStartedEvent;
import com.mongodb.event.ServerHeartbeatSucceededEvent;
import com.mongodb.event.ServerMonitorListener;

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
