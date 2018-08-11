import java.util.Date;
public class Account {
	private int id = 0;
	private double balance = 0; 
	private Date dateCreated;
	private double AnnualInterestRate = 0;
	
	Account(){
		
	}
	
	Account(int myId, double myBalance){
		id = myId;
		balance = myBalance;
		dateCreated = new Date();
		//AnnualInterestRate = myInterestRate;
	}
	public double getBalance(){
		return balance;
	}
	public int getId(){
		return id;
	}
	public String getDateCreated(){
		return dateCreated.toString();
	}
	public void withdraw(double amt){
		balance -= amt;
	}
	public void deposit(double amt){
		balance += amt;
	}
	public double getMonthlyInterestRate(){
		return AnnualInterestRate/12;
	}
	public double getMonthlyInterest(){
		return balance*.01*getMonthlyInterestRate();
	}
}
