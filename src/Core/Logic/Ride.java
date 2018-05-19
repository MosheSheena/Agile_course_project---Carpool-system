package Core.Logic;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Ride {
	
	/*
	 * Describes a planned ride or an actual ride
	 */

	private int rideID;
	private static int idGenerator = 0;
	private String destination;
	private String source;
	private int pricePerHitchhiker;
	private Car theCar;
	private RideDriver rideDriver;
	private Set<Hitchhiker> hitchhikers;
	private int moneySavedFromRide;
	private boolean executed;
	
	public Ride(String destination, String source) {
	    rideID = ++idGenerator;
		this.destination = destination;
		this.source = source;
		this.hitchhikers = new HashSet<>();
		this.pricePerHitchhiker = calcPriceOfRide();
		this.executed = false;
	}

    /** begin of getters / setters */

    public int getRideID() {return rideID;}

	public String getDestination() {return destination;}

	public void setDestination(String destination) {this.destination = destination;}

	public String getSource() {return source;}

	public void setSource(String source) {this.source = source;}

	public Car getTheCar() {return theCar;}

	private void setTheCar(Car theCar) {this.theCar = theCar;}

	public RideDriver getRideDriver() {return rideDriver;}

	public Set<Hitchhiker> getHitchhikers() {return hitchhikers;}
	
	public int getNumOfHichhikers() {return hitchhikers.size();}

	public int getPricePerHitchhiker() {return pricePerHitchhiker;}

	public int getMoneySavedFromRide() {return moneySavedFromRide;}
	
	public boolean isExecuted() {return executed;}

	/* end of getters / setters
	 @throws NoSeatAvailableInRideException*/

	public void addHitchhiker(Hitchhiker hitchhiker) throws NoSeatAvailableInRideException {
		if (getNumOfHichhikers() >= theCar.getNumOfSeatsAvailable())
			throw new NoSeatAvailableInRideException("no room in ride " + this + " cannot add " + hitchhiker);
		hitchhikers.add(hitchhiker);
	}
	
	public void assignRideDriver(RideDriver carOwner, Car theCar) {
		this.rideDriver = carOwner;
		setTheCar(theCar);
	}

	public void removeRideDriver(RideDriver rideDriver) {
		this.rideDriver = null;
		setTheCar(null); //remove car
	}
	
	// smart assignment to ride
	public void defaultRideAssignment(Commuter commuter) throws NoSeatAvailableInRideException {
		if (commuter instanceof RideDriver) {
			assignRideDriver((RideDriver)commuter, commuter.getDefaultCar());
		}
		else {// commuter is hitchhiker
			addHitchhiker((Hitchhiker)commuter);
		}
	}
	
	public boolean rideHasDriver() {
		return rideDriver != null;
	}
	
	public void executeRide() throws NoRideDriverAssignedException, NoCarAssignedException {
		if (rideDriver == null)
			throw new NoRideDriverAssignedException("cannot execute ride, no driver assign");
		if (theCar == null)
			throw new NoCarAssignedException("cannot execute ride, no car assign");
		executed = true;
	}
	
	private int calcPriceOfRide() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		return "Ride #" + rideID;
	}

	public boolean hasCommuter(Commuter commuter) {
		if(commuter instanceof RideDriver) 
			return rideDriver == (RideDriver) commuter;

		return hitchhikers.contains(commuter);
	}

	public boolean removeCommuter(Commuter commuter) {
		if(!hasCommuter(commuter))
			return false;
		if(commuter instanceof RideDriver) {
			if(rideDriver == (RideDriver)commuter) {
				removeRideDriver((RideDriver)commuter);
				return true;
			}
		}
		return hitchhikers.remove(commuter);
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ride ride = (Ride) o;
        return rideID == ride.rideID;
    }

    @Override
    public int hashCode() {

        return Objects.hash(rideID);
    }

    public boolean hasRoom() {
		return getNumOfHichhikers() < theCar.getNumOfSeatsAvailable();
	}
}
