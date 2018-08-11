
public class Faculty extends Employee{
	private String hours;
	private String rank;
	
	public Faculty(String hours, String rank, String office, double salary, String hired, String name, String address, String phone, String email){
		super(office, salary, hired, name, address, phone, email);
		this.hours = hours;
		this.rank = rank;
	}
	
	public String toString(){
		return super.getName() + " in Faculty";
	}

}