package Core.Storage;

public class DBConnectionDownException extends Exception {

    public DBConnectionDownException() {
    }

    public DBConnectionDownException(String message) {
        super(message);
    }
}
