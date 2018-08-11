/*
 * Author: Alex Schwiegeraht
 * Course: CSC-260L-002
 * Date: 2/14/2017
 * Assignment: #6c
 * Instructor: Bo–Kyung Kirby
 */
import java.util.Scanner;
public class Lab6c_Schwiegeraht {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int sum = 0;
		System.out.print("Which loop would you like to use: 1 or 2?");
		int choice = input.nextInt();
		if(choice != 1 && choice != 2){System.out.print("Error: Select 1 or 2");return;}
		if(choice == 1){
			for(int i = 1; i <= 10;i++){
				sum += i;
				System.out.println(sum);
			}//for loop1
		}//if
		else{
			for(int i =1; sum < 100; i++){
				sum += i;
				System.out.println(sum);
			}//for loop2
		}
	}

}
