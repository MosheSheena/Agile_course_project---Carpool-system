
public class Hitchhiker extends Commuter{

	private int totalMoneySpent;
	private int numRidesAsHitchhiker;
	
	public Hitchhiker(int id, String name, String address, int age, String city) {
		super(id, name, address, age, city);
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
	
	public void pay(int amount) {
		totalMoneySpent += amount;
	}

	@Override
	public String toString() {
		return "Hitchhiker [totalMoneySpent=" + totalMoneySpent + ", numRidesAsHitchhiker=" + numRidesAsHitchhiker
				+ "]";
	}	
	
	
}
