import java.util.ArrayList;

public class Commuter extends Person{
	
	private int numOfRides;
	private int numOfCars;
	private ArrayList<Car> carsOwned;
	private ArrayList<Ride> historyRides;
	
	public Commuter(int numOfCars, ArrayList<Car> carsOwned, String name, String address, int age, String city, int numOfRides) {
		super(name, address, age, city);
		this.numOfRides = numOfRides;
		this.numOfCars = numOfCars;
		this.carsOwned = carsOwned;
		
		this.numOfRides = 0;
		this.historyRides = new ArrayList<>();
	}

	public int getNumOfRides() {
		return numOfRides;
	}

	public void setNumOfRides(int numOfRides) {
		this.numOfRides = numOfRides;
	}

	
	public ArrayList<Car> getCarsOwned() {
		return carsOwned;
	}

	public void setCarsOwned(ArrayList<Car> carsOwned) {
		this.carsOwned = carsOwned;
	}

	public int getNumOfCars() {
		return numOfCars;
	}

	public ArrayList<Ride> getHistoryRides() {
		return historyRides;
	}
	
	

}
