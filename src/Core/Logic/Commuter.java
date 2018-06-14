package Core.Logic;

import java.util.ArrayList;
import java.util.List;

public class Commuter extends Person{
	
	private List<Car> carsOwned;

	
	public Commuter(int id, String name, String address, String city, int age) {
		super(id, name, address, city, age);
		
		this.carsOwned = new ArrayList<>();

	}

	public Commuter(Person p) {
	    super(p.getId(), p.getName(), p.getAddress(), p.getCity(), p.getAge());
    }
	
	/** begin of getters */


	public List<Car> getCarsOwned() {return carsOwned;}
	
	public int getNumOfCars() {return carsOwned.size();}
	
	/** end of getters */
	
	public void addCar(Car car) {carsOwned.add(car);}
	
	public void removeCar(Car car) {carsOwned.remove(car);}


	public Car getDefaultCar() {return carsOwned.get(0);}

	@Override
	public String toString() {
		return super.toString() + "\nCommuter: \ncarsOwned " + carsOwned.toString();
	}
	
}
