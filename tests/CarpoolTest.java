import Core.Logic.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarpoolTest {

    private Carpool carpool;
    private RideDriver testDriver;
    private Car testCar;
    private Hitchhiker testHitchhiker;

    @Before
    public void setUp() {

        carpool = Carpool.getInstance();
        testCar = new Car("jaguar", "red", 3, 25.5, "1324-a");
        testDriver = new RideDriver(245, "yochay", "gavitaim", "givatim", 27, testCar);
        testHitchhiker = new Hitchhiker(43, "dudi", "ramat-gan", "ramat-gan", 28);
    }

    @After
    public void tearDown() {
        carpool = null;
    }

    @Test
    public void executeRide() throws NoCarAssignedException, NoRideDriverAssignedException {

        Ride ride = new Ride("hi", "bye");
        try {
            carpool.registerRide(ride, testDriver);
            carpool.assignCommuterToRide(testHitchhiker, ride);
        } catch (NoSeatAvailableInRideException noSeatAvailableInRideException) {
            noSeatAvailableInRideException.printStackTrace();
        }
        assertTrue(carpool.executeRide(ride));
    }

    @Test
    public void executeRideWithNoDriver() throws NoCarAssignedException, NoRideDriverAssignedException {
        Ride ride = new Ride("hi", "bye");
        assertFalse(carpool.executeRide(ride));

        carpool.registerRide(ride, testDriver);

        assertFalse(carpool.executeRide(ride));
        ride.assignRideDriver(testDriver);
        assertFalse(carpool.executeRide(ride));
    }

    @Test
    public void executeRideWithNoHitchhikers() throws NoCarAssignedException, NoRideDriverAssignedException {
        Ride ride = new Ride("hi", "bye");
        assertFalse(carpool.executeRide(ride));
    }


    @Test
    public void registerRide() throws NoSeatAvailableInRideException, NoCarAssignedException, NoRideDriverAssignedException {
        Ride ride = new Ride("hi", "bye");
        carpool.registerRide(ride, testDriver);
        carpool.assignCommuterToRide(testHitchhiker, ride);
        assertTrue(carpool.executeRide(ride));

    }
}