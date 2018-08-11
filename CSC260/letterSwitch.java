import java.util.*;

public class letterSwitch {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a letter: ");
		char ch = input.next().charAt(0);
		
		switch(ch){
			case 'A': case 'E': case 'I': case 'O': case 'U':;
				System.out.print(ch + " is a vowel!");
				break;
				default:System.out.print(ch + " is a constant!");
			}
	}

}
