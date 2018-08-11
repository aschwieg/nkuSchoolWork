import java.util.Scanner;

/*
 * Author: Alex Schwiegeraht
 * Course: CSC-260
 * Assignment: #17
 */

public class Assn17 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double[] array = new double [10];
		for(int i=0;i<10;i++){
			System.out.print("Next Value: ");
			array[i]=input.nextDouble();
		}
		maxSort(array);
		for(int i=0;i<10;i++){
			System.out.print(array[i]+ ", ");
		}
	}
	 public static void maxSort(double[] array) {
		 for (int i = array.length-1; i > 0; i--) {
			  double currentMax = array[i];
			  int currentMaxIndex = i;
			  	for (int j = 0; j < i; j++) {
			  		if (currentMax < array[j]) {
			  			currentMax = array[j];
			  			currentMaxIndex = j;
			  		}
			  	}
			  	if (currentMaxIndex != i) {
			  		array[currentMaxIndex] = array[i];
			  		array[i] = currentMax;
			  	}
		 }
	}

}
