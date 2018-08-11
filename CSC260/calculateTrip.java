import java.text.DecimalFormat;
import java.util.Scanner;

public class calculateTrip {

	public static void main(String[] args) {
		DecimalFormat df=new DecimalFormat("##.00");
		Scanner input = new Scanner(System.in);
		
		//Variables
		double total, perPersonCost, foodCost, supplyCost, campgroundCost, gasCost, gasPrice, pricePerNight;
		int totalPeople, days, distance, mpg;
		
		System.out.print("Enter amount of people: ");
		totalPeople = input.nextInt();
		System.out.print("Enter amount of nights: ");
		days = input.nextInt();
		System.out.print("Enter amount of distance in miles: ");
		distance = input.nextInt();
		System.out.print("Enter the average amount of mpg you get in the car/cars: ");
		mpg = input.nextInt();
		System.out.print("Enter gas price: ");
		gasPrice = input.nextDouble();
		System.out.print("Enter campground price per night: ");
		pricePerNight = input.nextDouble();
		
		foodCost = totalPeople*days*10;
		supplyCost = totalPeople*5;
		campgroundCost = pricePerNight*days;
		
		//Gas Cost
		if(totalPeople <= 4){gasCost = (distance/mpg)*gasPrice;}
		else if(totalPeople <= 8){gasCost = (distance/mpg)*gasPrice*2;}
		else{gasCost = (distance/mpg)*gasPrice*3;}
		
		total = foodCost+supplyCost+campgroundCost+gasCost;
		perPersonCost = total/days;
		
		System.out.print("Total: " + df.format(total) + "\nCost per person: " + df.format(perPersonCost));
	}

}
