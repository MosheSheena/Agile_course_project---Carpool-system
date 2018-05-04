
public class RideDriver extends Commuter{

	/**
	 * Describes the driver in the planned drive
	 */
	private int numOfRidesAsDriver;
	private int totalMoneySaved;
	
	public RideDriver(int id, String name, String address, int age, String city) {
		super(id, name, address, age, city);

		this.numOfRidesAsDriver = 0;
		this.totalMoneySaved = 0;
	}

	public int getNumOfRidesAsDriver() {return numOfRidesAsDriver;}

	public void setNumOfRidesAsDriver(int numOfRidesAsDriver) {this.numOfRidesAsDriver = numOfRidesAsDriver;}

	public int getTotalMoneySaved() {return totalMoneySaved;}

	public void setTotalMoneySaved(int totalMoneySaved) {this.totalMoneySaved = totalMoneySaved;}

	@Override
	public String toString() {
		return super.toString() + "\nRideDriver: \nnumOfRidesAsDriver " + numOfRidesAsDriver + ", \ntotalMoneySaved " + totalMoneySaved;
	}
	
	
}
