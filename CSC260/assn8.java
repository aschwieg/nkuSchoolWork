import java.util.*;

public class assn8 {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the date: ");
		String date = input.nextLine();
		int s = date.length();
		int k = date.indexOf(' ');
		int i = date.indexOf(',');
		String month = date.substring(0,k);
		String number = date.substring(k,i);
		String year = date.substring(i+1);
		System.out.print(year + " " + month + " " + number);
		
	}

}
