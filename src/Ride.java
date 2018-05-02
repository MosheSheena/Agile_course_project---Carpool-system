import java.util.ArrayList;
import java.util.List;

public class Ride {
	
	/*
	 * Describes a planned ride or an actual ride
	 */

	private String destination;
	private String source;
	private int pricePerHitchhiker;
	private Car theCar;
	private RideDriver rideDriver;
	private List<Hitchhiker> hitchhikers;
	private int moneySavedFromRide;
	private boolean executed;
	
	public Ride(String destination, String source, List<Hitchhiker> hitchhikers) {
		this.destination = destination;
		this.source = source;
		this.hitchhikers = hitchhikers;
		this.executed = false;
	}
	
	// constructor for a planned drive
	public Ride(String destination, String source, int pricePerHitchhiker) {
		this.destination = destination;
		this.source = source;
		this.pricePerHitchhiker = pricePerHitchhiker;
		this.executed = false;
	}

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

	public void setTheCar(Car theCar) {
		this.theCar = theCar;
	}

	public RideDriver getRideDriver() {
		return rideDriver;
	}

	public void setRideDriver(RideDriver carOwner, Car theCar) {
		this.rideDriver = carOwner;
		setTheCar(theCar);
	}

	public List<Hitchhiker> getHitchhikers() {
		return hitchhikers;
	}

	public void setHitchhikers(ArrayList<Hitchhiker> hitchhikers) {
		this.hitchhikers = hitchhikers;
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
	
	public boolean addHitchhikerToDrive(Hitchhiker h) {
		if (getNumOfHichhikers() >= theCar.getNumOfSeatsAvailable())
			return false;
		hitchhikers.add(h);
		return true;
	}
	
	public void assignDriver(RideDriver rd) {
		rideDriver = rd;
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
}
