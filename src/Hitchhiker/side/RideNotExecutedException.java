package Hitchhiker.side;

/**
 * Hitchhiker.side.RideNotExecutedException
 */
public class RideNotExecutedException extends Exception{

    private static final long serialVersionUID = 1L;
    
    public RideNotExecutedException(String msg) {
        super(msg);
    }
}