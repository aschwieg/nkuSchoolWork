import java.util.Scanner;

public class Ass18 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double[][] array = new double [3][4];
		for(int i=0;i<3;i++){
			for(int j=0;j<4;j++){
				System.out.print("Next Value for row " + i + ": ");
				array[i][j]=input.nextDouble();
			}
			
		}
		for(int i=0;i<3;i++){
			for(int j=0;j<4;j++){
				System.out.print(array[i][j] + "\t");
			}
			System.out.println();
		}
		for(int i=0;i<4;i++){
			System.out.print(sumColumn(array,i) + "\t");
			
		}

	}
	public static double sumColumn(double[][] m, int columnIndex){
		double total = 0;
		for(int i=0;i<3;i++){
			total = m[i][columnIndex] + total;
		}
		return total;
	}
}
