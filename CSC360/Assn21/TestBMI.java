import java.util.Scanner;

public class TestBMI {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Weight:");
		int weight = input.nextInt();
		System.out.print("Height:");
		int height = input.nextInt();
		
		BMI myBMI = new BMI(height,weight);
		System.out.printf("BMI = %.2f\n",myBMI.getBMI());
		System.out.println("Get maximum ideal weight is " + myBMI.getMaxWeight());
		System.out.println("What is the goal for your weight? ");
		int w = input.nextInt();
		System.out.printf("Your BMI will be %.2f",myBMI.setWeight(w));

	}

}
