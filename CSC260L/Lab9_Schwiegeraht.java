import java.util.Scanner;

/*
 * Author: Alex Schwiegeraht
 * Course: CSC-260L-002
 * Date: 3/14/2017
 * Assignment: #9
 * Instructor: Bo–Kyung Kirby
 */

public class Lab9_Schwiegeraht {

	//uses a list from the user to provide median, average step increase, and mode.
	public static void main(String[] args) {
		int number;
		int[] array = new int[19];
		array = inputArray(array);
		number = getArray(array);
		sort(array,number);
		output(array,number);
		
	}
	//retrieves input from the user for the array
	public static int[] inputArray(int[] array){
		Scanner in = new Scanner(System.in);
		int temp, n = 0;
		System.out.print("Enter up to 20 values: ");
		temp = in.nextInt();
		while(temp > 0 && n < 19){
			array[n] = temp;
			n++;
			System.out.print("Enter next value: ");
			temp = in.nextInt();
		}
		return array;
	}
	//checks length of array
	public static int getArray(int[] array){
		int n = 0;
		for(int i = 0 ;  array[i] != 0 && n < 18; i++){
			n++;
		}
		return n;
	}
	//gets a median of an array
	public static int getMedian(int[] array, int n){
		return array[n/2];
		}
	//gets the average step count of an array
	public static double getStepAvg(int[] array, int n){
		double total = 0.0;
		for(int i = 0; i<=n-2; i++){
			total += array[i+1]-array[i];
		}
		return total/(n-1);
	}
	//gets mode of an arra
	public static int getCommon(int[] array, int n){
		int currentValue = array[0], currentCount = 1, maxCount = 0, maxValue = 0;
		for(int i = 1; i<n; i++){		
			if(array[i] == currentValue){
				currentCount++;
				}
			else{
				if(currentCount>maxCount){
					maxCount=currentCount;
					maxValue=currentValue;
					}
				currentCount = 1;
				currentValue = array[i];
			}	
		}
		return maxValue;
	}
	//outputs the results to the user
	public static void output(int[] a, int n){
		System.out.print("Median:\t" + getMedian(a,n)
		+ "\nStep Count Average:\t" + getStepAvg(a,n)
		+ "\nMost Common Value:\t" + getCommon(a,n));
	}
	//sorts the array
	public static int[] sort(int[ ] array, int n){
		int temp;
		for(int i=0;i<n-1;i++){
			for(int j=0;j<n-1;j++){
				if(array[j]>array[j+1]){
					temp=array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
				}
			}
		}
		return array;
	}
}

//Median:	153
//Step Count Average:	28.933333333333334
//Most Common Value:	153

//Median:	55
//Step Count Average:	1.8888888888888888
//Most Common Value:	66

//Median:	11
//Step Count Average:	0.9411764705882353
//Most Common Value:	15