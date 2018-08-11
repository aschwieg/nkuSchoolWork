import java.text.DecimalFormat;
import java.util.Scanner;

/*
 * Author: Alex Schwiegeraht
 * Course: CSC-260L-002
 * Date: 2/28/2017
 * Assignment: #8
 * Instructor: Bo–Kyung Kirby
 */

public class Lab8_Schwiegeraht {

	public static void main(String[] args) {
		DecimalFormat df=new DecimalFormat("##.00");
		Scanner input = new Scanner(System.in);
		
		//Declare variables
		int[] array = new int[100];
		int n,lessThan;
		double avg,stddev;
		boolean order;
		System.out.print("n: ");
		n = input.nextInt();
		if(n>100 || n < 1){System.out.print("Error"); return;}
		
		//Retrieves data
		array = inputValues(input,n);
		avg = avg(array,n);
		stddev = getSD(array, n, avg);
		lessThan = getItemsLessThanAvg(array, n, avg);
		order = checkOrder(array, n);
		
		//Outputs results
		System.out.print("Average:\t" + df.format(avg) + "\nStd Dev:\t" + 
		df.format(stddev) + "\nLess Than Avg:\t" + lessThan + "\n");
		if(order = false){System.out.print("Array is in sorted order");}
		else{System.out.print("Array is not in sorted order");}
	}
	//Gets array
	public static int[] inputValues(Scanner input, int n){
		int[] newValue = new int[n];
		for(int i=0;i<n;i++){
			System.out.print("Next Value: ");
			newValue[i]=input.nextInt();
		}
		return newValue;
	}
	//Average
	public static double avg(int[] array, int n){
		double avgTotal = 0, avg;
		for(int i=0;i<n;i++){
			avgTotal += array[i];
		}
		avg = avgTotal/n;
		return avg;
	}
	//Stddev
	public static double getSD(int[] array, int n, double avg){
		if(n < 2){return -1000;} 
		double numTotal = 0,stddev;
		for(int i=0;i<n;i++){
			numTotal += Math.pow(array[i]-avg,2);
		}
		stddev = Math.pow(numTotal/(n-1), .5);
		return stddev;
	}
	//Items less than Average
	public static int getItemsLessThanAvg(int[] array, int n, double avg){
		int total=0;
		for(int i=0;i<n;i++){
			if(array[i]<avg){
				total++;
			}
		}
		return total;
	}
	//Is array ordered
	public static boolean checkOrder(int[] array, int n){
		boolean ordered = true;
		for(int i=0;i<n-1;i++){
			if(array[i]>array[i+1]){ordered = false;}
		}
		return ordered;
	}
}

/*Average:	45.20
Std Dev:	32.41
Less Than Avg:	3
Array is not in sorted order
 * 
 *Average:	1554.50
Std Dev:	417.93
Less Than Avg:	4
Array is not in sorted order
*
*Average:	1000.00
Std Dev:	-1000.00
Less Than Avg:	0
Array is not in sorted order
*
*Average:	6.70
Std Dev:	4.47
Less Than Avg:	5
Array is not in sorted order
*
*Error
*
*Average:	20.05
Std Dev:	15.10
Less Than Avg:	12
Array is not in sorted order
*
*Average:	7.80
Std Dev:	.79
Less Than Avg:	4
Array is not in sorted order
 */