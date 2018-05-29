package Core.Logic;

public class Hitchhiker extends Commuter{

	private int totalMoneySpent;
	private int numRidesAsHitchhiker;
	
	public Hitchhiker(int id, String name, String address, String city, int age) {
		super(id, name, address, city, age);
		this.totalMoneySpent = 0;
		this.numRidesAsHitchhiker = 0;

	}

	public Hitchhiker(Person person) {
		super(person.getId(), person.getName(), person.getAddress(), person.getCity(), person.getAge());
		this.totalMoneySpent = 0;
		this.numRidesAsHitchhiker = 0;
	}

	public int getTotalMoneySpent() {return totalMoneySpent;}

	public void setTotalMoneySpent(int totalMoneySpent) {this.totalMoneySpent = totalMoneySpent;}

	public int getNumRidesAsHitchhiker() {return numRidesAsHitchhiker;}

	public void setNumRidesAsHitchhiker(int numRidesAsHitchhiker) {this.numRidesAsHitchhiker = numRidesAsHitchhiker;}
	
	public void pay(int amount) {totalMoneySpent += amount;}

	@Override
	public String toString() {
		return super.toString() + "\nHitchhiker: \ntotalMoneySpent " + totalMoneySpent + ", \nnumRidesAsHitchhiker " + numRidesAsHitchhiker;
	}	
	
	
}
