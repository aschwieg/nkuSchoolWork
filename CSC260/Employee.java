
public class Employee extends Person{
	private String office, hired;
	private double salary;
	
	
	public Employee(String office, double salary, String hired, String name, String address, String phone, String email){
		super(name,  address,  phone,  email);
		office = office;
		salary = salary;
		office = office;
	}
	
	public String toString(){
		return super.getName() + " in Employee";
	}

}
