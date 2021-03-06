package Core.Logic;

public class RideDriver extends Commuter{

	/**
	 * Describes the driver in the planned drive
	 */
	private int numOfRidesAsDriver;
	private int totalMoneySaved;
	
	public RideDriver(int id, String name, String address, String city, int age, Car mainCar) {
		super(id, name, address, city, age);

        addCar(mainCar);
		this.numOfRidesAsDriver = 0;
		this.totalMoneySaved = 0;
	}

	public RideDriver(Person person) {
		super(person.getId(), person.getName(), person.getAddress(), person.getCity(), person.getAge());
		this.numOfRidesAsDriver = 0;
		this.totalMoneySaved = 0;
	}

	/**start of getters / setters */

	public int getNumOfRidesAsDriver() {return numOfRidesAsDriver;}

	public void setNumOfRidesAsDriver(int numOfRidesAsDriver) {this.numOfRidesAsDriver = numOfRidesAsDriver;}

	public int getTotalMoneySaved() {return totalMoneySaved;}

	public void setTotalMoneySaved(int totalMoneySaved) {this.totalMoneySaved = totalMoneySaved;}

	/**end of getters / setters */

	@Override
	public String toString() {
		return super.toString() + "\nRideDriver: \nnumOfRidesAsDriver " + numOfRidesAsDriver + ", \ntotalMoneySaved " + totalMoneySaved;
	}
	
	
}
