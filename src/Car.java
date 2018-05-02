
public class Car {

	private String model;
	private String color;
	private int numOfSeatsAvailable; //this excludes the driver's seat
	private double gasolineConsumptionPerKM;
	private String registrationPlate;
	
	public Car(String model, String color, int numOfSeatsAvailable, double gasolineConsumptionPerKM,
			String registrationPlate) {
		this.model = model;
		this.color = color;
		this.numOfSeatsAvailable = numOfSeatsAvailable;
		this.gasolineConsumptionPerKM = gasolineConsumptionPerKM;
		this.registrationPlate = registrationPlate;
	}
	
	/** begin of getters / setters */
	
	public String getColor() {return color;}
	
	public void setColor(String color) {this.color = color;}
	
	public double getGasolineConsumptionPerKM() {return gasolineConsumptionPerKM;}
	
	public void setGasolineConsumptionPerKM(double gasolineConsumptionPerKM) {this.gasolineConsumptionPerKM = gasolineConsumptionPerKM;}
	
	public String getModel() {return model;}
	
	public int getNumOfSeatsAvailable() {return numOfSeatsAvailable;}
	
	public String getRegistrationPlate() {return registrationPlate;}
	
	/** end of getters / setters */
	
	@Override
	public String toString() {
		return "Car [model=" + model + ", color=" + color + ", numOfSeatsAvailable=" + numOfSeatsAvailable
				+ ", gasolineConsumptionPerKM=" + gasolineConsumptionPerKM + ", registrationPlate=" + registrationPlate
				+ "]";
	}
}
