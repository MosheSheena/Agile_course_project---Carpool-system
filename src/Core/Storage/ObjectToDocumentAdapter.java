package Core.Storage;

import org.bson.Document;

public abstract class ObjectToDocumentAdapter {

    private Object object;

    public ObjectToDocumentAdapter(Object o) {
        object = o;
    }

    public abstract Document adaptToDocument();
}
