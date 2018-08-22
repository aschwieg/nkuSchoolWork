import java.util.Scanner;
public class grantExample {

	public static void main(String[] args) {
		
		int x, y, age;
		String name;
		char sex;
		Scanner input = new Scanner(System.in);
		
		name = "Grant";
		
		sex = 'm';
		
		x = 10;
		y = 2;
		
		System.out.println("Enter your age: ");
		age = input.nextInt();
		
		System.out.println(name);
		System.out.println(sex);
		System.out.println(age);
		
		input.close();
	}

}
