import java.util.ArrayList;
import java.util.List;

public abstract class Commuter extends Person{
	
	private List<Car> carsOwned;
	private List<Ride> executedRides;
	private List<Ride> plannedRides;
	
	public Commuter(int id, String name, String address, int age, String city) {
		super(id, name, address, age, city);
		
		this.carsOwned = new ArrayList<>();
		this.executedRides = new ArrayList<>();
		this.plannedRides = new ArrayList<>();
	}
	
	/** begin of getters */

	public int getNumOfPlannedRides() {
		return plannedRides.size();
	}
	
	public int getNumOfExecutedRides() {
		return executedRides.size();
	}

	public List<Car> getCarsOwned() {
		return carsOwned;
	}
	
	public int getNumOfCars() {
		return carsOwned.size();
	}

	public List<Ride> getHistoryRides() {
		return executedRides;
	}
	
	public List<Ride> getPlannedRides() {
		return plannedRides;
	}
	
	/** end of getters */
	
	public void addCar(Car car) {
		carsOwned.add(car);
	}
	
	public void removeCar(Car car) {
		carsOwned.remove(car);
	}
	
	public void addRide(Ride ride) {
		plannedRides.add(ride);
	}
	
	public boolean executeRide(Ride ride) {
		plannedRides.remove(ride);
		return addRideToHistory(ride);
	}
	
	/** returns false if ride not executed */
	public boolean addRideToHistory(Ride ride) {
		if (!ride.isExecuted())
			return false;
		executedRides.add(ride);
		return true;
	}

	public Car getDefaultCar() {
		return carsOwned.get(0);
	}
	
}
