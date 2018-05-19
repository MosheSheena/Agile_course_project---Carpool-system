package Core.Logic;

/**
 * NoSeatAvailableInRideException
 */
public class NoSeatAvailableInRideException extends Exception {

    private static final long serialVersionUID = 1L;

	public NoSeatAvailableInRideException(String msg) {
        super(msg);
    }
}