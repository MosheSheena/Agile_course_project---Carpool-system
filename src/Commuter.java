
public class Commuter extends Person{
	
	private int numOfRides;
	private int numOfCars;
	private Car[] carsOwned;
	private Ride[] historyRides;
	
	public Commuter(int numOfCars, Car[] carsOwned, String name, String address, int age, String city, int numOfRides) {
		super(name, address, age, city);
		this.numOfRides = numOfRides;
		this.numOfCars = numOfCars;
		this.carsOwned = carsOwned;
		
		this.numOfRides = 0;
	}

}
