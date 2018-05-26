//package Core.Storage;
//
//import Core.Logic.Hitchhiker;
//import Core.Logic.Person;
//import Core.Logic.Ride;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//
//public class StorageFacadeTest {
//
//    private StorageFacade sf;
//    private MongoCredentials credentials = new MongoCredentials
//            ("localhost", 27017, "Agile-CarPool");
//    private User u1;
//    private User u2;
//    private User u3;
//    private User u4;
//    private Ride r1;
//    private Ride r2;
//    private Ride r3;
//    private Ride r4;
//
//    @Before
//    public void setUp() throws Exception {
//        sf = StorageFacade.getInstance();
//        sf.openConnection(credentials);
//
//        u1 = new User("u1", "1234",
//                new Person(1, "Avi", "address1",
//                        "city1", 25));
//        u2 = new User("u2", "12345",
//                new Person(2, "Chaim", "address2",
//                        "city2", 26));
//        u3 = new User("u3", "123456",
//                new Person(3, "Moshe", "address3",
//                        "city3", 25));
//        u4 = new User("u4", "123498",
//                new Person(4, "koko", "address4",
//                        "city4", 46));
//
//        r1 = new Ride("d1", "d2");
//        r2 = new Ride("d1", "d2");
//        r3 = new Ride("d1", "d2");
//        r4 = new Ride("d1", "d2");
//    }
//
//    @After
//    public void tearDown() throws Exception {
//        sf.closeConnection();
//    }
//
//    @Test
//    public void registerNewUser() {
//        try {
//            sf.registerNewUser(new UserToDocumentAdapter(u1).adaptToDocument());
//        } catch (DBConnectionDownException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    public void existsUser() {
//    }
//
//    @Test
//    public void saveNewRide() {
//    }
//
//    @Test
//    public void loadAllUnexecutedRides() {
//    }
//
//    @Test
//    public void loadRideHistory() {
//    }
//
//    @Test
//    public void updateRideStatusToExecuted() {
//    }
//}