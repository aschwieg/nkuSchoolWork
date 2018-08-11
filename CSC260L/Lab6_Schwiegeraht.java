/*
 * Author: Alex Schwiegeraht
 * Course: CSC-260L-002
 * Date: 2/14/2017
 * Assignment: #6a
 * Instructor: Bo–Kyung Kirby
 */
import java.util.*;

public class Lab6_Schwiegeraht {

	public static void main(String[] args) {
		int sum = 0, odd = 0, count = 0, cTarget = 0, max = 0, target, value;
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a target value: "); //requests target
		target = input.nextInt();
		System.out.print("Enter an integer value (0 to quit): ");
		value = input.nextInt();
		while (value != 0){
			sum += value;
			System.out.print("Enter next value (0 to quit): ");
			value = input.nextInt();
			count++;
			if(value%2 == 1){odd++;} //Checks for odds
			if(value == target){cTarget++;} //Checks for target
			if(value > max){max = value;} //Checks for max value
		}
		
		//Displays information to the user
		if(count>0){
			double avg = sum/count;
			System.out.print("The sum of the entered values is "+ sum + 
					"\nThe number of inputs is " + count + 
					"\nThe average of inputs is " + avg + 
					"\nThe number of odd values input is " + odd + 
					"\nThe value " + target + " was input " + cTarget + " times" +
					"\nThe maximum vaule entered was " + max);
		}
		else{
			System.out.print("Error: no input");
		}
		
	}

}
