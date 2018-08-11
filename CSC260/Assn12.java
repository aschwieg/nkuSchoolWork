import java.util.Scanner;

public class Assn12 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Amount: ");
		double amount = input.nextDouble();
		System.out.println("Enter annual yield: ");
		double yield = input.nextDouble();
		System.out.print("Enter months: ");
		int months = input.nextInt();
		System.out.print("Month\tCD Value\n");
		for(int i = 1; i <= months; i++){
			amount = amount+amount*yield/1200;
			System.out.printf("%2d\t%.2f\n",i , amount);
		}
	}

}
