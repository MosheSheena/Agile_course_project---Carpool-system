package Core.Logic;

public class Person {

	private int id;
	private String name;
	private String address;
	private String city;
	private int age;
	
	public Person(int id, String name, String address, String city, int age) {
		
		this.id = id;
		this.name = name;
		this.address = address;
		this.age = age;
		this.city = city;
	}
	
	/** begin of getters / setters */
	
	public int getId() {return id;}
	
	public String getName() {return name;}
	
	public void setName(String name) {this.name = name;}
	
	public String getAddress() {return address;}
	
	public void setAddress(String address) {this.address = address;}
	
	public int getAge() {return age;}
	
	public void setAge(int age) {this.age = age;}
	
	public String getCity() {return city;}

	public void setCity(String city) {this.city = city;}
	
	/** end of getters / setters */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + age;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return this.id == other.id;
	}

	@Override
	public String toString() {
		return "Person: \nid " + id + ", \nname " + name + " \naddress " + address + ", \ncity " + city + ", \nage " + age;
	}
	
	
}
