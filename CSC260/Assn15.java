import java.util.Scanner;

public class Assn15 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int userInt = 1,n=0;
		int[] list = new int[100];
		System.out.print("Enter the integers between 1 and 100: ");
		for(int i=0; userInt != 0;i++){
			userInt = input.nextInt();
			list[userInt]++;
		}
		for(int i=0; i<100 ;i++){
			if(list[i] != 0){
				System.out.println(i + " occurs " + list[i] + " times.");}
		}
	}
}

