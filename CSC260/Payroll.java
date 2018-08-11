import java.util.Scanner;

public class Payroll {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n;
		System.out.print("Enter number of emplyees: ");
		n = in.nextInt();
		Employee2[] emp = new Employee2[n];
		for(int i = 0; i<n; i++){
			double p; 
			String name;
			System.out.print("Enter name: ");
			name = in.next();
			System.out.print("Enter salary: ");
			p = in.nextDouble();
			
			emp[i] = new Employee2(name,p);
		}
		System.out.print("Employee\tPay\n");
		for(int i=0;i<n;i++){
			System.out.printf(emp[i].getName() + "\t$%.2f\n",emp[i].computePay());
		}

	}

}
