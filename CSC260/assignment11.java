import java.util.*;

public class assignment11 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double income = 0,bill = 0,in;
		do{
			System.out.print("Enter bill or income (0 to quit):");
			in = input.nextDouble();
			if(in<0){bill=bill+in;}
			else{income=income+in;}
		}while(in!=0);
		System.out.printf("Income: $%.2f\nBill: $%.2f",income,(-1*bill));
	}

}
