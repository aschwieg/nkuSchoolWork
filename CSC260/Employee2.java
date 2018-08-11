
public class Employee2 {
	private String name;
	private double salary;
	
	public Employee2(){
		name = "unknown";
		salary = 0.0;
	}
	
	public Employee2(String a, double b){
		name = a;
		salary = b;
	}
	
	public String getName(){
		return name;
	}
	
	public double computePay(){
		return salary/26*.7;
	}
}
