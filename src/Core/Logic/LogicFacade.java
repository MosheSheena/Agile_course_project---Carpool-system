package Core.Logic;

import Core.Storage.*;
import org.bson.Document;

import java.util.Set;

public class LogicFacade {

    private static LogicFacade ourInstance = new LogicFacade();
    public static LogicFacade getInstance() {
        return ourInstance;
    }

    private static StorageFacade sf = StorageFacade.getInstance();

    private LogicFacade() {}

    public boolean checkIfUserExists(String username)
            throws DBConnectionDownException, DocumentNotFoundException {
        return sf.existsUser(username);
    }

    public void registerNewUser(User u) throws DBConnectionDownException {
        Document userDoc = new UserToDocumentAdapter(u).adaptToDocument();
        sf.registerNewUser(userDoc);
    }

    public Set<Ride> loadAllUnexecutedRides() {
        return null;
    }


}
