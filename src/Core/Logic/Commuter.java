package Core.Logic;

import java.util.ArrayList;
import java.util.List;

public class Commuter extends Person{
	
	private List<Car> carsOwned;
	private List<Ride> executedRides;
	private List<Ride> plannedRides;
	
	public Commuter(int id, String name, String address, String city, int age) {
		super(id, name, address, city, age);
		
		this.carsOwned = new ArrayList<>();
		this.executedRides = new ArrayList<>();
		this.plannedRides = new ArrayList<>();
	}

	public Commuter(Person p) {
	    super(p.getId(), p.getName(), p.getAddress(), p.getCity(), p.getAge());
    }
	
	/** begin of getters */

	public int getNumOfPlannedRides() {return plannedRides.size();}
	
	public int getNumOfExecutedRides() {return executedRides.size();}

	public List<Car> getCarsOwned() {return carsOwned;}
	
	public int getNumOfCars() {return carsOwned.size();}

	public List<Ride> getHistoryRides() {return executedRides;}
	
	public List<Ride> getPlannedRides() {return plannedRides;}
	
	/** end of getters */
	
	public void addCar(Car car) {carsOwned.add(car);}
	
	public void removeCar(Car car) {carsOwned.remove(car);}
	
	public void addRide(Ride ride) {plannedRides.add(ride);}

	public boolean removeRide(Ride ride) {return plannedRides.remove(ride);}

	public Car getDefaultCar() {return carsOwned.get(0);}
	
	public void executeRide(Ride ride) throws RideNotExecutedException {
		plannedRides.remove(ride);
		addRideToHistory(ride);
	}
	
	/** returns false if ride not executed */
	private void addRideToHistory(Ride ride) throws RideNotExecutedException{
		if (!ride.isExecuted())
			throw new RideNotExecutedException("Try to add ride " + ride + " to history but ride not executed");
		executedRides.add(ride);
	}

	@Override
	public String toString() {
		return super.toString() + "\nCommuter: \ncarsOwned " + carsOwned.toString() + " \nnumOfPlannedRides " + plannedRides.size() +
		 " \nnumOfExecutedRides " + executedRides.size();
	}
	
}
