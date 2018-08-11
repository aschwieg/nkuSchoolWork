
public class Student extends Person{
	private String status;
	
	public Student (String status, String name, String address, String phone, String email){
		super(name, address, phone, email);
		this.status = status;

	}
	
	public String toString(){
		return super.getName() + " in Student";
	}

}