/*
 * Author: Alex Schwiegeraht
 * Course: CSC-260L-002
 * Date: 2/14/2017
 * Assignment: #6b
 * Instructor: Bo–Kyung Kirby
 */
import java.util.Scanner;

public class Lab6b_Schwiegeraht {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Choose an integer: ");
		int n = input.nextInt();
		System.out.println("n\tn^2\tn^3\tn^4");//labels the columns

		//calculates and displays results
		for(int x = 1; x<=n; x++ ){
		System.out.println((int)x + "\t" + (int)Math.pow(x,2) + 
		"\t" + (int)Math.pow(x,3) + "\t" + (int)Math.pow(x,4));}
	}
}
