import java.util.*;

public class quadraticEquation {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a, b, c: ");
		double a = input.nextDouble();
		double b = input.nextDouble();
		double c = input.nextDouble();
		double discriminant = Math.pow(b, 2)-4*a*c;
		double answer1 = (-b + Math.pow(discriminant, .5))/(2*a);
		double answer2 = (-b - Math.pow(discriminant, .5))/(2*a);
		double answer3 = -b/(2*a);
		
		if(discriminant < 0){
			System.out.print("The equation has no real roots");
		}
		else if(discriminant == 0){
			System.out.println("Root: " + answer3);
			}
		else{
			System.out.print("Root 1: " + answer1 + "\nRoot 2: " + answer2);
		}
	}

}
