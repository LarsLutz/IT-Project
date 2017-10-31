package application;

public class Model {
	
	private int value;
	
	public Model(int value){
		this.value = value;
	}
	
	//getter
	public int getValue(){
		return this.value;
	}
	
	//erhöhungsmethode
	public int increment(){
		value++;
		return value;
	}
	
	

}
