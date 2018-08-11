/* Alex Schwiegeraht
 * Description: Converts hex values to decimal.
 */

import java.util.Scanner;

public class HW1P2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a hex number: ");
		String hex = input.nextLine();
		try{
			System.out.println("The decimal value for hex number " + hex + " is " + hexToDecimal(hex.toUpperCase()));
		}
		catch(HexFormatException ex){
			System.out.print("That input is not a valid hexidecimal number.");
		}
		

	}
	public static int hexToDecimal(String hex) throws HexFormatException{
		int decimalValue = 0;
		if(hex.length() == 0){
			throw new HexFormatException(hex);
		}
		for (int i = 0; i<hex.length(); i++){
			if(!((hex.charAt(i) >= '0' && hex.charAt(i)<='9')||(hex.charAt(i)>='A' && hex.charAt(i) <= 'F'))){
				throw new HexFormatException(hex);
			}
			char hexChar = hex.charAt(i);
			decimalValue = decimalValue * 16 + hexCharToDecimal(hexChar);
		}
		return decimalValue;
	}
	
	public static int hexCharToDecimal(char ch){
		if (ch >= 'A' && ch <= 'F'){
			return 10 + ch - 'A';
		}
		else{
			return ch - '0';
		}
	}
}
