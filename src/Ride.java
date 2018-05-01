import java.util.ArrayList;

public class Ride {
	
	/*
	 * Describes an actual ride
	 */

	private String destination;
	private String source;
	private int pricePerHitchhiker;
	private Car theCar;
	private CarOwner carOwner;
	private ArrayList<Hitchhiker> hitchhikers;
	private int numOfActualHichhikers;
	private int moneySavedFromRide;
	
	public Ride(String destination, String source, Car theCar, CarOwner carOwner, ArrayList<Hitchhiker> hitchhikers,
			int numOfActualHichhikers) {
		this.destination = destination;
		this.source = source;
		this.theCar = theCar;
		this.carOwner = carOwner;
		this.hitchhikers = hitchhikers;
		this.numOfActualHichhikers = numOfActualHichhikers;
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

	public CarOwner getCarOwner() {
		return carOwner;
	}

	public void setCarOwner(CarOwner carOwner) {
		this.carOwner = carOwner;
	}

	public ArrayList<Hitchhiker> getHitchhikers() {
		return hitchhikers;
	}

	public void setHitchhikers(ArrayList<Hitchhiker> hitchhikers) {
		this.hitchhikers = hitchhikers;
	}

	public int getNumOfActualHichhikers() {
		return numOfActualHichhikers;
	}

	public void setNumOfActualHichhikers(int numOfActualHichhikers) {
		this.numOfActualHichhikers = numOfActualHichhikers;
	}

	public int getPricePerHitchhiker() {
		return pricePerHitchhiker;
	}

	public int getMoneySavedFromRide() {
		return moneySavedFromRide;
	}
	
	
}
