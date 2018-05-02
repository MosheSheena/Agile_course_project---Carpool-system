import java.util.ArrayList;
import java.util.List;

public class Carpool {
	
	/*
	 * Singleton class - contains all rides including history
	 * All rides should be managed via this class
	 * Maybe the logic of how much money the driver save and how many
	 * each hitchhiker pay
	 */

	private List<Ride> plannedRides;
	private List<Ride> executedRides;
	
	private static Carpool carpool = null;
	
	protected Carpool() {};
	
	public static Carpool getInstance() { 
		if (carpool == null) {
			carpool = new Carpool();
			carpool.plannedRides = new ArrayList<>();
			carpool.executedRides = new ArrayList<>();
		}
		return carpool;
	}
	
	public int getNumOfAvailableRides() { return plannedRides.size();}
	
	public boolean executeRide(Ride ride) {
		executedRides.add(ride);
		plannedRides.remove(ride);
		// and more
		return true;
	}
	
	public void registerRide(Ride ride, Commuter commuter) {
		ride.defaultRideAssignment(ride, commuter);
		commuter.addRide(ride);
		plannedRides.add(ride);
		// and more
	}
	
	public boolean assignCommuterToRide(Commuter commuter, Ride ride) {
		int foundOrNot = plannedRides.indexOf(ride);
		if (foundOrNot == -1)
			return false;
		Ride aRide = plannedRides.get(foundOrNot);
		aRide.defaultRideAssignment(ride, commuter);
		return true;
	}
	
	public List<Ride> history() {
		// do not allow outsiders to change history
		return new ArrayList<Ride>(executedRides);
	}
	
}