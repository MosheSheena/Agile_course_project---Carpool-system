package Core.Storage;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
import com.mongodb.event.ServerHeartbeatFailedEvent;
import com.mongodb.event.ServerHeartbeatStartedEvent;
import com.mongodb.event.ServerHeartbeatSucceededEvent;
import com.mongodb.event.ServerMonitorListener;

public class MongoConnection  implements ServerMonitorListener {

    private MongoClient mongoClient;
    private MongoDatabase mongoDatabase;
    private ConnectionStatus connectionStatus = ConnectionStatus.DEAD;

    public MongoConnection(String hostName, Integer port, String dbName) {
        mongoClient = new MongoClient(hostName, port);
        mongoDatabase = mongoClient.getDatabase(dbName);

        try {
            MongoClientOptions clientOptions = new MongoClientOptions.Builder()
                    .addServerMonitorListener(this)
                    .build();

            mongoClient = new MongoClient
                    (new ServerAddress(hostName, port), clientOptions);
        } catch (Exception ex) {}
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
        connectionStatus = ConnectionStatus.DEAD;
    }

    public ConnectionStatus getConnectionStatus() {
        return connectionStatus;
    }

    @Override
    public void serverHearbeatStarted(ServerHeartbeatStartedEvent serverHeartbeatStartedEvent) {
        connectionStatus = ConnectionStatus.INITIALIZING;
    }

    @Override
    public void serverHeartbeatSucceeded(ServerHeartbeatSucceededEvent serverHeartbeatSucceededEvent) {
        connectionStatus = ConnectionStatus.LIVE;
    }

    @Override
    public void serverHeartbeatFailed(ServerHeartbeatFailedEvent serverHeartbeatFailedEvent) {
        connectionStatus = ConnectionStatus.FAILED;
    }
}
