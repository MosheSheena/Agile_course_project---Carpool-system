import Core.Logic.*;
import org.junit.*;

import static org.junit.Assert.*;


public class RideTest {

    private Ride ride;
    private RideDriver rideDriver;

    @Before
    public void setUp() {
        ride = new Ride("Afeka", "Modi'in");
        Car car = new Car("mazada", "grey", 2, 18.0, "1234-5678");
        rideDriver = new RideDriver(123, "moshe", "Modi'in", "modiin", 25, car);
        ride.assignRideDriver(rideDriver);
    }

    @After
    public void tearDown() {
        ride = null;
    }

    @Test(expected = NoSeatAvailableInRideException.class)
    public void addTooManyHitchhikers() throws Exception{

        Car otherCar = new Car("mazada", "grey", 1, 18.0, "1234-5678");
        RideDriver otherRideDriver = new RideDriver(123, "moshe", "Modi'in", "modiin", 25, otherCar);
        ride.assignRideDriver(otherRideDriver);

        Hitchhiker hitchhiker = new Hitchhiker(12434, "amit", "karlivah", "tlv", 23);
        Hitchhiker hitchhiker2 = new Hitchhiker(123434, "itay", "hasmonaim", "modiin", 23);

        ride.addHitchhiker(hitchhiker);
        ride.addHitchhiker(hitchhiker2);
        assertEquals(ride.getNumOfHitchhikers(), 1);
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
        }
    }

    @Test
    public void hasCommuter() {

        assertTrue(ride.hasCommuter(rideDriver));
        Commuter c = new Hitchhiker(4334, "amit", "hello", "nowhere", 24);
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