package Core.Storage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StorageFacadeTest {

    @Before
    public void setUp() throws Exception {
        StorageFacade sf = StorageFacade.getInstance();
        MongoCredentials credentials = new MongoCredentials
                ("localhost", 27017, "Agile-CarPool");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void registerNewUser() {
    }

    @Test
    public void existsUser() {
    }

    @Test
    public void saveNewRide() {
    }

    @Test
    public void loadAllUnexecutedRides() {
    }

    @Test
    public void loadRideHistory() {
    }

    @Test
    public void updateRideStatusToExecuted() {
    }
}