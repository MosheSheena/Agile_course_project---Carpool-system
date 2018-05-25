package Core.Storage;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;

public class CollectionHandler {
    private MongoDatabase db;
    private MongoCollection<Document> collection;

    public CollectionHandler(MongoDatabase db, String collectionName) {
        this.db = db;
        collection = db.getCollection(collectionName);
    }

    public void writeDocument(Document doc) {
        collection.insertOne(doc);
    }

    public <T> Document loadDocument(String fieldName, T queryValue) {
        return collection.find(Filters.eq
                (fieldName, queryValue)).first();
    }

    public <T> FindIterable<Document> loadDocuments
            (String fieldName, T queryValue) {
        return collection.find(Filters.eq(fieldName, queryValue));
    }

    public <T> void updateDocument
            (String fieldName, T oldValue, T newValue) {
        collection.updateOne(Filters.eq
                (fieldName, oldValue),Updates.set(fieldName, newValue));
    }
}
