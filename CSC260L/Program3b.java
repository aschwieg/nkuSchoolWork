import java.util.Scanner;
import java.text.DecimalFormat;

public class Program3b {

	public static void main(String[] args) {

//vars
		Scanner in = new Scanner(System.in);
		String name;
		double PRICE_PER_GALLON;
		double totalPaid;
		int iRead;
		int fRead;
		DecimalFormat df = new DecimalFormat("##.0");
		
//var value input	
		System.out.print("Enter your name: ");
		name = in.next();
		System.out.print("Enter price per gallon: ");
		PRICE_PER_GALLON = in.nextDouble();
		System.out.print("Enter total price to fill up: ");
		totalPaid = in.nextDouble();
		System.out.print("Enter intitial odometer value: ");
		iRead = in.nextInt();
		System.out.print("Enter final odometer value: ");
		fRead = in.nextInt();
		
//calculate output
		int miles = fRead-iRead;
		double gallons = (totalPaid/PRICE_PER_GALLON);
		double mpg = (miles/gallons);

//display output
		System.out.print(name + ", you drove " + miles + " miles using\n" + (int)Math.ceil(gallons) + " gallons with an mpg of " + df.format(mpg));
		
/*
Alex, you drove 135 miles using
8 gallons with an mpg of 18.9

frank, you drove 521 miles using
19 gallons with an mpg of 28.5

Ruth, you drove 75 miles using
7 gallons with an mpg of 12.3

Gail, you drove 311 miles using
10 gallons with an mpg of 31.1
 */
		
	}

}
