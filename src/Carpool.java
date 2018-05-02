import java.util.ArrayList;
import java.util.List;

public class Carpool {
	
	/*
	 * Singleton class - contains all rides including history
	 * All rides should be executed via this class
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
		}
		return carpool;
	}
	
	public int getNumOfAvailableRides() { return plannedRides.size();}
	
	public boolean executeRide(Ride r) {
		executedRides.add(r);
		plannedRides.remove(r);
		return true;
	}
	
	public void addRide(Ride r) {
		plannedRides.add(r);
	}
	
	public List<Ride> history() {
		// do not allow outsiders to change history
		return new ArrayList<Ride>(executedRides);
	}
	
}