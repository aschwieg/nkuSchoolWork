import java.util.*;

public class ComputeBMI {

	public static void main(String[] args) {
		
		double CONVERT_TO_KILO = .45359237;
		double CONVERT_TO_METER = .0254;
		Scanner input = new Scanner(System.in);
		
		System.out.print("Put in your weight in pounds: ");
		double weightInPounds = input.nextDouble();
		
		System.out.print("Put in your height in inches: ");
		double heightInInches = input.nextDouble();
		
		double BMI = (weightInPounds*CONVERT_TO_KILO)/Math.pow(heightInInches*CONVERT_TO_METER,2);
		
		System.out.println("Your BMI is " + BMI);
		if(BMI < 18.5){
			System.out.print("Underweight");
		}
		else if(18.5 <= BMI && BMI < 25.0){
			System.out.print("Normal");
		}
		else if(BMI >=25.0 && BMI < 30.0){
			System.out.print("Overweight");
		}
		else{
			System.out.print("Obese");
		}
	}

}
