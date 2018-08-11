/*
 * Author: Alex Schwiegeraht
 * Course: CSC-260L-002
 * Date: 2/23/2017
 * Assignment: #7
 * Instructor: Bo–Kyung Kirby
 */
import java.text.DecimalFormat;
import java.util.*;
public class Lab7_Schwiegeraht {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String color;
		int height, width, length, numCans;
		double cost;
		height = getSize("height",input);	
		length = getSize("length",input);
		width = getSize("width",input);
		color = getColor(input);
		numCans = computeNumberOfCans(height,width,length);
		cost = computeCost(numCans, color);
		output(height,length,width,color,numCans,cost);

	}
	public static int getSize( String caption, Scanner input){
		System.out.print("Enter the " + caption + " of the room: ");
		int value = input.nextInt();
		return value; 
	}
	public static String getColor(Scanner input){
		System.out.print("Enter the color of the paint: ");
		String color = input.next().toLowerCase();
		return color;
	}
	public static int computeNumberOfCans(int height, int width, int length){
		int squareFootage = (2*width*height)+(2*length*height)+(length*width);
		double x = squareFootage/365.0;
		x = Math.ceil(x);
		int totalCans = (int)x;
		return totalCans;
	}
	public static double computeCost(int numCans, String color){
		double colCost,cost;
		if(color.equals("green")){colCost = 3.68;}
		else if(color.equals("orange") || color.equals("eggshell")){colCost = 4.25;}
		else if(color.equals("mauve")){colCost = 3.69;}
		else if(color.equals("white")){colCost = 3.25;}
		else{colCost = 6.00;}
		
		if(numCans > 10){cost = colCost*numCans*.9;}
		else if(numCans > 5 && color.equals("white")|| color.equals("eggshell")){cost = colCost*numCans*.94;}
		else if(numCans > 5){cost = colCost*numCans*.96;}
		else{cost = colCost*numCans;}
		
		return cost;
		}
	
	public static void output(int height, int width, int length, String color, int numCans, double cost){
		DecimalFormat df=new DecimalFormat("$##.00");
		System.out.print("Height: " + height + "\nWidth: " + width + "\nLength: " + length
				+ "\nColor: " + color + "\nNumber of Cans: " + numCans + "\nCost: " + df.format(cost));
	}
}
/*Enter the height of the room: 18
Enter the length of the room: 20
Enter the width of the room: 25
Enter the color of the paint: Green
Height: 18
Width: 20
Length: 25
Color: green
Number of Cans: 6
Cost: $21.20
 * 
 * Enter the height of the room: 12
Enter the length of the room: 16
Enter the width of the room: 14
Enter the color of the paint: Mauve
Height: 12
Width: 16
Length: 14
Color: mauve
Number of Cans: 3
Cost: $11.07
*
*Enter the height of the room: 12
Enter the length of the room: 22
Enter the width of the room: 20
Enter the color of the paint: White
Height: 12
Width: 22
Length: 20
Color: white
Number of Cans: 4
Cost: $13.00
*
*Enter the height of the room: 30
Enter the length of the room: 85
Enter the width of the room: 40
Enter the color of the paint: Eggshell
Height: 30
Width: 85
Length: 40
Color: eggshell
Number of Cans: 30
Cost: $114.75
*
*Enter the height of the room: 10
Enter the length of the room: 19
Enter the width of the room: 33
Enter the color of the paint: Mauve
Height: 10
Width: 19
Length: 33
Color: mauve
Number of Cans: 5
Cost: $18.45
*
*Enter the height of the room: 9
Enter the length of the room: 66
Enter the width of the room: 56
Enter the color of the paint: blue
Height: 9
Width: 66
Length: 56
Color: blue
Number of Cans: 17
Cost: $91.80
*
*Enter the height of the room: 16
Enter the length of the room: 28
Enter the width of the room: 22
Enter the color of the paint: white
Height: 16
Width: 28
Length: 22
Color: white
Number of Cans: 7
Cost: $21.38
*
*Enter the height of the room: 24
Enter the length of the room: 35
Enter the width of the room: 20
Enter the color of the paint: black
Height: 24
Width: 35
Length: 20
Color: black
Number of Cans: 10
Cost: $57.60
 */

