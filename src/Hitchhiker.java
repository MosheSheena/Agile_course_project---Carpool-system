import java.util.ArrayList;

public class Hitchhiker extends Commuter{

	private int totalMoneySpent;
	private int numRidesAsHitchhiker;
	
	public Hitchhiker(int numOfCars, ArrayList<Car> carsOwned, String name, String address, int age, String city,
			int numOfRides) {
		super(numOfCars, carsOwned, name, address, age, city, numOfRides);
		this.totalMoneySpent = 0;
		this.numRidesAsHitchhiker = 0;
	}

	public int getTotalMoneySpent() {
		return totalMoneySpent;
	}

	public void setTotalMoneySpent(int totalMoneySpent) {
		this.totalMoneySpent = totalMoneySpent;
	}

	public int getNumRidesAsHitchhiker() {
		return numRidesAsHitchhiker;
	}

	public void setNumRidesAsHitchhiker(int numRidesAsHitchhiker) {
		this.numRidesAsHitchhiker = numRidesAsHitchhiker;
	}
	
	
	
}
