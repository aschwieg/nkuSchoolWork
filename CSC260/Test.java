
public class Test {

	public static void main(String[] args) {
		// Test case for Person
			Person person =  new Person("Jeff", "123 Baker Street", "111-1111","jeff@bakerstreet.com");
			System.out.println(person.toString());
			Student student = new Student("freshman", "Jane", "Callahan", "222-2222", "jane@nku.edu");
			System.out.println(student.toString());
			Employee employee = new Employee("GH314", 20000, "January 1, 2017", "John", "Cincinnati", "333-3333", "john@nku.edu");
			System.out.println(employee.toString());
			Faculty faculty = new Faculty("TR2-3", "Professor", "GH510", 100.00, "1/1/2000", "CF", "NKU", "444-4444", "frank@nku.edu");
			System.out.println(faculty.toString());
		// Test case for Staff
			Staff staff = new Staff("President", "Upper", 100000.0, "1/2/2011", "Bob", "West Minster", "555-5555", "bob@farmersonly.com");
			System.out.println(staff.toString());
		
		}

	}

