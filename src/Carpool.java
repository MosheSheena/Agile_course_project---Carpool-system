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
		ride.defaultRideAssignment(commuter);
		commuter.addRide(ride);
		plannedRides.add(ride);
		// and more
	}
	
	public boolean assignCommuterToRide(Commuter commuter, Ride ride) {
		int foundOrNot = plannedRides.indexOf(ride);
		if (foundOrNot == -1)
			return false;
		Ride aRide = plannedRides.get(foundOrNot);
		aRide.defaultRideAssignment(commuter);
		if(commuter instanceof RideDriver) {
			// notify hitchhikers that a driver was assigned to their ride
		} else {
			// ask driver's confirmation about the hitchhiker and send the response to the hitchhiker
		}
		return true;
	}

	public boolean removeCommuterFromRide(Commuter commuter, Ride ride) {
		if(!plannedRides.contains(ride))
			return false;
		boolean removedFromRide = ride.removeCommuter(commuter);
		if (!removedFromRide)
			return false;
		if(commuter instanceof RideDriver) {
			// notify hitchhikers that a driver was assigned to their ride
		} else {
			// ask driver's confirmation about the hitchhiker and send the response to the hitchhiker
		}
		return commuter.removeRide(ride);
	}
	
	public List<Ride> history() {
		// do not allow outsiders to change history
		return new ArrayList<Ride>(executedRides);
	}
	
	public List<Ride> getAvaCarPools() {
		List<Ride> avaPool = new ArrayList<Ride>(executedRides);
		
		for (Ride carInRide : this.plannedRides ) {
			if (carInRide.getNumOfHichhikers() <= carInRide.getTheCar().getNumOfSeatsAvailable())
				// Available seats and the car ready for ride
				avaPool.add(carInRide);	
		}
		return avaPool;
	}
	
}