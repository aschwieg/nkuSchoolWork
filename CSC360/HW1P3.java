/* Alex Schwiegeraht
 * Description: Takes integers from a text file and finds their average
 */

import java.io.*;
import java.util.*;

public class HW1P3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter name of input file: ");
		String fileName = in.next();
		in.close();
		File f = new File(fileName);
		try{
			Scanner input = new Scanner(f);
			double total = 0;
			double n = 0;
			double e = 0;
			while(input.hasNext() == true){
				
				String line = input.nextLine();
				try{
					total = total + Integer.parseInt(line);
					n++;
				}
				catch(NumberFormatException ex){
					System.out.println("Cannot parse " + line + " as an integer.");
					e++;
				}
				
			}
			input.close();
			double avg = total / n;
			System.out.println("Average value: " + avg);
			System.out.println("Number of unparsable lines: " + e);
		}
		catch( FileNotFoundException ex){
			System.out.print("Could not find file: " + fileName);
			System.exit(1);
		}
		
		

	}
	

}
