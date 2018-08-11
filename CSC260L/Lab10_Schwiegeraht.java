import java.util.Scanner;

/*
 * Author: Alex Schwiegeraht
 * Course: CSC-260L-002
 * Date: 3/21/2017
 * Assignment: #10
 * Instructor: Bo–Kyung Kirby
 */

public class Lab10_Schwiegeraht {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] list = new int[5];
		int num = 0;
		
		while(num<5){
			System.out.print("Enter: ");
			list[num] = input.nextInt();
			num++;
		}
		int max = list[0];
		for(int i = 0; i < num; i++){
			if(list[i] > max){max = list[i];}
		}
		System.out.print("Max: " + max);
	}

}
