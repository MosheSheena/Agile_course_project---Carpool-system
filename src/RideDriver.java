import java.util.ArrayList;

public class RideDriver extends Commuter{

	/**
	 * Describes the driver in the planned drive
	 */
	private int numOfRidesAsDriver;
	private int totalMoneySaved;
	
	public RideDriver(int numOfCars, ArrayList<Car> carsOwned, String name, String address, int age, String city,
			int numOfRides) {
		super(numOfCars, carsOwned, name, address, age, city, numOfRides);

		this.numOfRidesAsDriver = 0;
		this.totalMoneySaved = 0;
	}

	public int getNumOfRidesAsDriver() {
		return numOfRidesAsDriver;
	}

	public void setNumOfRidesAsDriver(int numOfRidesAsDriver) {
		this.numOfRidesAsDriver = numOfRidesAsDriver;
	}

	public int getTotalMoneySaved() {
		return totalMoneySaved;
	}

	public void setTotalMoneySaved(int totalMoneySaved) {
		this.totalMoneySaved = totalMoneySaved;
	}
	
	
	
}
