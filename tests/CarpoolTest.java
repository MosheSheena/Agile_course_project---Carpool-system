import Hitchhiker.side.*;
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
    public void setUp() throws Exception {

        carpool = Carpool.getInstance();
        testDriver = new RideDriver(245, "yochay", "gavitaim", 27, "givatim");
        testCar = new Car("jaguar", "red", 3, 25.5, "1324-a");
        testHitchhiker = new Hitchhiker(43, "dudi", "ramat-gan", 28, "ramat-gan");
        testDriver.addCar(testCar);
    }

    @After
    public void tearDown() throws Exception {
        carpool = null;
    }

    @Test
    public void executeRide() {

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
    public void executeRideWithNoDriver() {
        Ride ride = new Ride("hi", "bye");
        assertFalse(carpool.executeRide(ride));
        try {
            carpool.registerRide(ride, testDriver);
        } catch (NoSeatAvailableInRideException noSeatAvailableInRideException) {
            noSeatAvailableInRideException.printStackTrace();
        }
        assertFalse(carpool.executeRide(ride));
        ride.assignRideDriver(testDriver, testCar);
        assertFalse(carpool.executeRide(ride));
    }

    @Test
    public void executeRideWithNoHitchhikers() {
        Ride ride = new Ride("hi", "bye");
        assertFalse(carpool.executeRide(ride));
    }


    @Test
    public void registerRide() throws NoSeatAvailableInRideException {
        Ride ride = new Ride("hi", "bye");
        carpool.registerRide(ride, testDriver);
        carpool.assignCommuterToRide(testHitchhiker, ride);
        assertTrue(carpool.executeRide(ride));

    }
}