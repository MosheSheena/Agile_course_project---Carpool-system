package Core.Storage;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.List;

public class CollectionLoader {

    private MongoDatabase db;
    private MongoCollection<Document> collection;

    public CollectionLoader(MongoDatabase db, String collectionName) {
        this.db = db;
        collection = db.getCollection(collectionName);
    }

    public Document loadDocument(int documentID) {
        return collection.find(Filters.eq
                ("_id", documentID)).first();
    }
}
