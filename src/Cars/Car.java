package Cars;

public class Car {
	private Integer capacity;
	
	public Car(Integer capacity){
		this.capacity = capacity;
	}
	
	public Integer getCapacity(){
		return capacity;
	}
	
	public String toString(){
		return "Samoch�d o pojemno��i: " + capacity;
	}
}
