package Business.Tests;

import Business.Logic.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;

class DriverAPITest {

    private DriverAPI api = DriverAPI.getInstance();
    private Location d1Src;
    private Location d1Dst;
    private Location d2Src;
    private Location d2Dst;
    private Car c1;
    private Car c2;
    private Driver d1;
    private Driver d2;
    private Ride r1;
    private Ride r2;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        d1Src = new Location("Chaim Weitzman 1", false);
        d1Dst = new Location("Aba Hillel 12", true);
        c1 = new Car(5915134, "Fiat", "Blue", 4, 1200.0f);
        d1 = new Driver("Bob", "18.11.1992", true, c1);
        r1 = new Ride(d1Src, d1Dst);
        r2 = new Ride(d1Src, d1Dst);
    }

    @AfterAll
    void tearDown() {
    }

    @Test
    void testOfferNewRide() {
        assertTrue(api.offerNewRide(d1, d1Src, d1Dst, "11:00"));
        // After ride has been added should deny re-adding it
        assertFalse(api.offerNewRide(d1, d1Src, d1Dst, "11:00"));
    }

    @Test
    void testCancelRide() {
        assertTrue(api.cancelRide(r1, "No reason"));
        assertFalse(api.cancelRide(r1, "Because"));
        assertFalse(api.cancelRide(r2, ""));
    }
}