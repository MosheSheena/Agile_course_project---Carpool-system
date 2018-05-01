import java.util.ArrayList;

public class Ride {
	
	/*
	 * Describes a planned ride or an actual ride
	 */

	private String destination;
	private String source;
	private int pricePerHitchhiker;
	private Car theCar;
	private RideDriver carOwner;
	private ArrayList<Hitchhiker> hitchhikers;
	private int moneySavedFromRide;
	private boolean executed;
	
	public Ride(String destination, String source, Car theCar, 
			RideDriver carOwner, ArrayList<Hitchhiker> hitchhikers) {
		this.destination = destination;
		this.source = source;
		this.theCar = theCar;
		this.carOwner = carOwner;
		this.hitchhikers = hitchhikers;
		this.executed = false;
	}
	
	
	// constructor for a planned drive
	public Ride(String destination, String source, int pricePerHitchhiker, Car theCar, RideDriver carOwner) {
		this.destination = destination;
		this.source = source;
		this.pricePerHitchhiker = pricePerHitchhiker;
		this.theCar = theCar;
		this.carOwner = carOwner;
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

	public RideDriver getCarOwner() {
		return carOwner;
	}

	public void setCarOwner(RideDriver carOwner) {
		this.carOwner = carOwner;
	}

	public ArrayList<Hitchhiker> getHitchhikers() {
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
	
	public boolean SetHitchhikerToDrive(Hitchhiker h) {
		if (getNumOfHichhikers() >= theCar.getNumOfSeatsAvailable())
			return false;
		hitchhikers.add(h);
		return true;
	}
	
	
}
