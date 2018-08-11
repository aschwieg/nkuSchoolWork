/* Alex Schwiegeraht
 * Description: Checks two ints and gets their sum.
 */

import java.util.*;

public class HW1P1 {

	public static void main(String[] args) {
		int n1 = intCheck("first");
		int n2 = intCheck("second");
		System.out.print("The sum is " + (n1+n2));
	}
	
	public static int intCheck(String n){
		Scanner in = new Scanner(System.in);
		boolean continueExecution = true;
		int i = 1;
		do{
			System.out.print("Enter " + n + " integer: "); 	
			try{
				i = in.nextInt();			
				continueExecution = false;	
		 	}
			catch (InputMismatchException ex){
				System.out.print("Try again. (Incorrect input: an integer is required)");
				in.nextLine();
				System.out.println();
			}
			
		}while(continueExecution == true);
		return i;
	}

}
