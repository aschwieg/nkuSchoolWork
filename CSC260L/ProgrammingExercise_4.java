import java.util.Scanner;
import java.text.DecimalFormat;

public class ProgrammingExercise_4 {

	public static void main(String[] args) {
		double ticketPrice = 40.00;
		DecimalFormat df = new DecimalFormat("$##.00");
		Scanner in = new Scanner(System.in);
		System.out.print("Age: ");
		int age = in.nextInt();
		System.out.print("County: ");
		String county = in.next();
		if(age <= 0){
			System.out.print("Error");
		}
		else if(age >= 65 && county.equalsIgnoreCase("campbell")){
			double cost = ticketPrice*.425;
			System.out.print(df.format(cost));
		}
		else if(age >= 65 && county.equalsIgnoreCase("warren")){
			double cost = ticketPrice*.75*.5;
			System.out.print(df.format(cost));
		}
		else if(age >= 65){
			double cost = ticketPrice*.5;
			System.out.print(df.format(cost));
		}
		else if(age < 5){
			double cost = ticketPrice*0;
			System.out.print(df.format(cost));
		}
		else if(5 <= age && age < 14 && county.equalsIgnoreCase("clermont")){
			double cost = ticketPrice*.82;
			System.out.print(df.format(cost));
		}
		else if(county.equalsIgnoreCase("warren")){
			double cost = ticketPrice*.75;
			System.out.print(df.format(cost));
		}
		else{
			double cost = ticketPrice;
			System.out.print(df.format(cost));
		}

	}

}
/*
 * $40.00
 * $20.00
 * $.00
 * Error
 * $40.00
 * $.00
 * $30.00
 * $17.00
 * $32.80
 * $40.00
 * Error
 * $40.00
*/
