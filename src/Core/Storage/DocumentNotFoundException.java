package Core.Storage;

public class DocumentNotFoundException extends Exception {

    public DocumentNotFoundException() {
    }

    public DocumentNotFoundException(String message) {
        super(message);
    }
}
