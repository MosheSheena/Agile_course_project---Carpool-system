import java.util.HashSet;
import java.util.Set;

public class Ride {
	
	/*
	 * Describes a planned ride or an actual ride
	 */

	private String destination;
	private String source;
	private int pricePerHitchhiker;
	private Car theCar;
	private RideDriver rideDriver;
	private Set<Hitchhiker> hitchhikers;
	private int moneySavedFromRide;
	private boolean executed;
	
	public Ride(String destination, String source) {
		this.destination = destination;
		this.source = source;
		this.hitchhikers = new HashSet<>();
		this.pricePerHitchhiker = calcPriceOfRide();
		this.executed = false;
	}
	
	/** begin of getters / setters */

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Car getTheCar() {
		return theCar;
	}

	private void setTheCar(Car theCar) {
		this.theCar = theCar;
	}

	public RideDriver getRideDriver() {
		return rideDriver;
	}

	public Set<Hitchhiker> getHitchhikers() {
		return hitchhikers;
	}
	
	public int getNumOfHichhikers() {
		return hitchhikers.size();
	}

	public int getPricePerHitchhiker() {
		return pricePerHitchhiker;
	}

	public int getMoneySavedFromRide() {
		return moneySavedFromRide;
	}
	
	public boolean isExecuted() {
		return executed;
	}

	/** end of getters / setters*/

	public boolean addHitchhiker(Hitchhiker hitchhiker) {
		if (getNumOfHichhikers() >= theCar.getNumOfSeatsAvailable())
			return false;
		hitchhikers.add(hitchhiker);
		return true;
	}
	
	public void assignRideDriver(RideDriver carOwner, Car theCar) {
		this.rideDriver = carOwner;
		setTheCar(theCar);
	}
	
	// smart assignment to ride
	public void defaultRideAssignment(Ride ride, Commuter commuter) {
		if (commuter instanceof RideDriver)
			ride.assignRideDriver((RideDriver)commuter, commuter.getDefaultCar());
		else {// commuter is hitchhiker
			ride.addHitchhiker((Hitchhiker)commuter);
		}
	}
	
	public boolean rideHasDriver() {
		return rideDriver != null;
	}
	
	public boolean executeRide() {
		if (rideDriver == null)
			return false;
		if (theCar == null)
			return false;
		executed = true;
		return true;
	}
	
	private int calcPriceOfRide() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		return "Ride [destination=" + destination + ", source=" + source + ", pricePerHitchhiker=" + pricePerHitchhiker
				+ ", theCar=" + theCar + ", rideDriver=" + rideDriver + ", hitchhikers=" + hitchhikers
				+ ", moneySavedFromRide=" + moneySavedFromRide + ", executed=" + executed + "]";
	}
	
	
}
