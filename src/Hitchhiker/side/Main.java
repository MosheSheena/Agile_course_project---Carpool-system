package Hitchhiker.side;

public class Main {

	public static void main(String[] args) {
		
		Carpool carpool = Carpool.getInstance();
		
		Commuter c1 = new RideDriver(12345, "Amit", "Kipodan 15", 24, "Modi'in");
		c1.addCar(new Car("Mazda", "blue", 4, 18.0, "1234-234-12"));
		
		Commuter c2 = new Hitchhiker(43547, "Moshe", "Sheena 18", 25, "Rosh Aain");
		
		Ride rideToAdd = new Ride("Modi'in", "Afeka");
		try {
			carpool.registerRide(rideToAdd, c1);
			carpool.assignCommuterToRide(c1, rideToAdd);
			carpool.assignCommuterToRide(c2, rideToAdd);
		} catch (NoSeatAvailableInRideException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(rideToAdd);

		carpool.removeCommuterFromRide(c2, rideToAdd);
		System.out.println("\n\n" +rideToAdd);
	}

}