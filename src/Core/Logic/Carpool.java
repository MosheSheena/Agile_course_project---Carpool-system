package Core.Logic;

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
	
	protected Carpool() {}
	
	public static Carpool getInstance() { 
		if (carpool == null) {
			carpool = new Carpool();
			carpool.plannedRides = new ArrayList<>();
			carpool.executedRides = new ArrayList<>();
		}
		return carpool;
	}
	
	public int getNumOfAvailableRides() { return plannedRides.size();}
	
	public boolean executeRide(Ride ride) throws NoCarAssignedException, NoRideDriverAssignedException {
		if (!plannedRides.contains(ride))
			return false;
		if(!ride.rideHasDriver())
			return false;
		if(ride.getNumOfHitchhikers() == 0)
			return false;
		executedRides.add(ride);
		plannedRides.remove(ride);
		ride.executeRide();

		// and more
		return true;
	}

	public void registerRide(Ride ride, Commuter creatorOfRide)  {
		try {
			ride.defaultRideAssignment(creatorOfRide);
		} catch (NoSeatAvailableInRideException e) {
			e.printStackTrace();
			System.out.println("we should not get here");
		}
		plannedRides.add(ride);
		// and more
	}
	
	public boolean assignCommuterToRide(Commuter commuter, Ride ride) throws NoSeatAvailableInRideException {
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
			// notify hitchhikers that a driver was removed from their ride
		} else {
			// notify driver removed from ride
		}
		return removedFromRide;
	}

	public boolean cancelRide(Ride ride) {
        int index = plannedRides.indexOf(ride);
	    if(index == -1) //not in planned rides
	        return false;
	    plannedRides.remove(index);
	    return true;
    }
	
	public List<Ride> history() {
		// do not allow outsiders to change history
		return new ArrayList<>(executedRides);
	}
	
	public List<Ride> getAvailableCarPools() {
		List<Ride> availablePool = new ArrayList<>();
		
		for (Ride carInRide : this.plannedRides ) {
			if (carInRide.hasRoom())
				// Available seats and the car ready for ride
				availablePool.add(carInRide);
		}
		return availablePool;
	}
	
}