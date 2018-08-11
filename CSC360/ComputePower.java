/* Alex Schwiegeraht
 * Description: Displays multiple ways of finding a number to the power of its exponent using recursion and iteration
 */

import java.util.Scanner;

public class ComputePower {
	private static int multiplication;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a decimal number: ");
		Double base = in.nextDouble();
		System.out.print("Enter a non-negative interger exponent: ");
		int n = in.nextInt();
		
		multiplication=0;
		System.out.println("Computing "+base+" to the power "+n+": \n"
				+ "Math.pow(" + base + ", " + n + ") = " + Math.pow(base,n));

		
		multiplication=0;
		System.out.println("\npower1(" + base + ", " + n + ") = " + power1(base,n));
		System.out.println("Multiplications = " + multiplication);
		
		multiplication=0;
		System.out.println("\npower2(" + base + ", " + n + ") = " + power2(base,n));
		System.out.println("Multiplications = " + multiplication);
		
		multiplication=0;
		System.out.println("\npower3(" + base + ", " + n + ") = " + power3(base,n));
		System.out.println("Multiplications = " + multiplication);
		
		multiplication=0;
		System.out.println("\npower4(" + base + ", " + n + ") = " + power4(base,n));
		System.out.println("Multiplications = " + multiplication);
		
		multiplication=0;
		System.out.println("\npower5(" + base + ", " + n + ") = " + power5(base,n));
		System.out.println("Multiplications = " + multiplication);
	}
	public static double power1(double b, int n){
		double a=1;
		for(int i=0;i<n;i++){
			a*=b;
			multiplication++;
		}
		return a;
	}
	public static double power2(double b, int n){
		multiplication++;
		if(n==0){
			return 1;
		}
		else{
			return b*power2(b,n-1);
		}
	}
	public static double power3(double b, int n){
		double subresult;
		if(n==0){
			return 1;
		}
		else if(n%2==0){
			multiplication++;
			subresult=power3(b,n/2);
			subresult*=subresult;
			return subresult;
		}
		else{
			multiplication++;
			subresult=power3(b,n/2);
			multiplication++;
			return subresult*subresult*b;
			
		}
	}
	private static double multPow(double a, double b, int n){
		if(n==0){
			return a;
		}
		else if(n%2==0){
			multiplication++;
			a=multPow(a,b*b,n/2);
		}
		else{
			multiplication++;
			multiplication++;
			a=multPow(a*b,b*b,n/2);
		}
		return a;
	}
	public static double power4(double b, int n){
		return multPow(1,b,n);
	
	}
	public static double power5(double b, int n){
		double a = 1;
		while(n>0){
			if(n%2==0){
				b*=b;
				multiplication++;
				
			}
			else{
				a=a*b;
				b*=b;
				multiplication++;
				multiplication++;
			}
			n=n/2;
		}
		return a;
	}
}
