/* Alex Schwiegeraht
 * Description: Takes a file and parses all the Integers into a Map then 
 * displays the most frequent entries.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CountIntegerMap {
	static int n=0;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter name of input file: ");
		String fileName = in.next();
		in.close();
		File f = new File(fileName);
		try{
			Scanner input = new Scanner(f);
			Map<Integer,Integer> map = new TreeMap<>();

			while(input.hasNext() == true){
				String line = input.nextLine();
				
				try{
					int key = Integer.parseInt(line);
					if(!map.containsKey(key)){
						map.put(key, 1);
					}
					else{
						int value = map.get(key);
						value++;
						map.put(key, value);
						if(value>n){
							n=value;
						}
					}
				}
				catch(NumberFormatException ex){
					System.out.println("Warning - unable to parse string as integer: " + line);
					
				}
				
			}
			input.close();
			System.out.println("Most Frequently occuring values: ");
			Set<Map.Entry<Integer,Integer>> entrySet = map.entrySet();

			entrySet.forEach(e -> {if(map.get(e.getKey())==n){
				System.out.println("Value: "+ e.getKey() + " Number of Occurances: " + n);
			}});
			

			System.out.print("Process completed.");
		}
		catch( FileNotFoundException ex){
			System.out.print("Could not find file: " + fileName);
			System.exit(1);
		}
		
		

	}
	

}
