import java.util.Scanner;

public class Assn16 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double[] array = new double [10];
		for(int i=0;i<10;i++){
			System.out.print("Next Value: ");
			array[i]=input.nextDouble();
		}
		double smallest = min(array);
		System.out.print(smallest); 
	}
	public static double min(double[] array){
		double smallest = array[0];
		for(int i=1;i<10;i++){
			if(array[i]<smallest){smallest=array[i];}
		}
		return smallest;
	}
}
