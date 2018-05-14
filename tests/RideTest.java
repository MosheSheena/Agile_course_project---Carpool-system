import Hitchhiker.side.*;
import org.junit.*;

import static org.junit.Assert.*;


public class RideTest {

    private Ride ride;
    private RideDriver rideDriver;

    @Before
    public void setUp() throws Exception {
        ride = new Ride("Afeka", "Modi'in");
        rideDriver = new RideDriver(123, "moshe", "Modi'in", 25, "modiin");
        Car car = new Car("mazada", "grey", 2, 18.0, "1234-5678");
        rideDriver.addCar(car);
        ride.assignRideDriver(rideDriver, car);
    }

    @After
    public void tearDown() throws Exception {
        ride = null;
    }

    @Test(expected = NoSeatAvailableInRideException.class)
    public void addTooManyHitchhikers() throws Exception{

        Hitchhiker hitchhiker = new Hitchhiker(12434, "amit", "karlivah", 23, "tlv");
        Hitchhiker hitchhiker2 = new Hitchhiker(123434, "itay", "hasmonaim", 23, "modiin");

        ride.addHitchhiker(hitchhiker);
        ride.addHitchhiker(hitchhiker2);
        assertEquals(ride.getNumOfHichhikers(), 1);
    }


    @Test
    public void executeRideWithoutDriver() {
        ride.removeRideDriver(rideDriver);
        try {
            ride.executeRide();
        } catch (Exception e) {
            assert(e instanceof NoRideDriverAssignedException || e instanceof NoCarAssignedException);
        }
    }

    @Test
    public void rideHasDriver() {
        assertTrue(ride.rideHasDriver());
    }

    @Test
    public void executeRide() {
        try {
            ride.executeRide();
            assertTrue(ride.isExecuted());
        } catch (NoRideDriverAssignedException noRideDriverAssigned) {
            noRideDriverAssigned.printStackTrace();
        } catch (NoCarAssignedException noCarAssignedException) {
            noCarAssignedException.printStackTrace();
        }
    }

    @Test
    public void hasCommuter() {

        assertTrue(ride.hasCommuter(rideDriver));
        Commuter c = new Hitchhiker(4334, "amit", "hello", 24, "nowhere");
        assertFalse(ride.hasCommuter(c));
        try {
            ride.addHitchhiker((Hitchhiker)c);
        } catch (NoSeatAvailableInRideException noSeatAvailableInRideException) {
            noSeatAvailableInRideException.printStackTrace();
        }
        assertTrue(ride.hasCommuter(c));

    }

    @Test
    public void removeCommuter() {
        ride.removeRideDriver(rideDriver);
        assertFalse(ride.rideHasDriver());

    }
}