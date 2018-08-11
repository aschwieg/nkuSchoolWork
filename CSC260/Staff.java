
public class Staff extends Employee{
	private String title;
	
	public Staff(String title, String office, double salary, String hired, String name, String address, String phone, String email){
		super(office,salary,hired,name,  address,  phone,  email);
		title = title;
	}
	
	public String toString(){
		return super.getName() + " in Staff";
	}
}
