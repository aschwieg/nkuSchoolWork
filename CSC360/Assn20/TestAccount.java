import java.util.*;

public class TestAccount {
	public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	Account[] account = new Account[10];
	for(int i = 0; i<account.length; i++){
		account[i] = new Account(i,100.00);
	}

	for(int i =0;i != -1;i++){
		
		System.out.print("Enter an id: ");
		int id = in.nextInt();
		int c = 0;
		while(c != 4){
			System.out.println("Main Menu");
			System.out.println("1: Check Balance");
			System.out.println("2: Withdraw");
			System.out.println("3: Deposit");
			System.out.println("4: Exit");
			System.out.print("Enter your choice: ");
			c = in.nextInt();
		
			if(c == 1){
				System.out.println("Balance: " + account[id].getBalance());
			}
			if(c == 2){
				System.out.println("Enter the amount to withdraw: ");
				account[id].withdraw(in.nextDouble());
			}
			if(c == 3){
				System.out.println("Enter the amount to deposit: ");
				account[id].deposit(in.nextDouble());
			}
		}
		}
	}
}
