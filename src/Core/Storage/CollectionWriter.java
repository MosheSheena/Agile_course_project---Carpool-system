package Core.Storage;

import Core.Logic.Car;
import Core.Logic.Person;
import Core.Logic.Ride;
import Core.Logic.RideDriver;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class CollectionWriter {

    private MongoDatabase db;
    private MongoCollection<Document> collection;

    public CollectionWriter(MongoDatabase db, String collectionName) {
        this.db = db;
        collection = db.getCollection(collectionName);
    }

    public void writeDocument(Document doc) {
        collection.insertOne(doc);
    }

}
