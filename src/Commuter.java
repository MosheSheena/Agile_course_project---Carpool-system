import java.util.ArrayList;
import java.util.List;

public class Commuter extends Person{
	
	private int numOfRides;
	private int numOfCars;
	private List<Car> carsOwned;
	private List<Ride> historyRides;
	private List<Ride> plannedRides;
	
	public Commuter(int numOfCars, List<Car> carsOwned, String name, String address, int age, String city) {
		super(name, address, age, city);
		this.numOfCars = numOfCars;
		this.carsOwned = carsOwned;
		
		this.numOfRides = 0;
		this.historyRides = new ArrayList<>();
		this.plannedRides = new ArrayList<>();
	}

	public int getNumOfRides() {
		return numOfRides;
	}

	public void setNumOfRides(int numOfRides) {
		this.numOfRides = numOfRides;
	}

	public List<Car> getCarsOwned() {
		return carsOwned;
	}

	public void setCarsOwned(ArrayList<Car> carsOwned) {
		this.carsOwned = carsOwned;
	}

	public int getNumOfCars() {
		return numOfCars;
	}

	public List<Ride> getHistoryRides() {
		return historyRides;
	}
	
	public List<Ride> getPlannedRides() {
		return plannedRides;
	}
	
	public int getNumPlannedDrivers() {
		return plannedRides.size();
	}

	public void createRide() {
		
	}
	
	/** returns false if ride not executed */
	public boolean addRideToHistory(Ride r) {
		if (!r.isExecuted())
			return false;
		historyRides.add(r);
		return true;
	}
	
	

}
