import java.util.ArrayList;
import java.util.Scanner;

public class removeDuplicate {

	public static void main(String[] args) {
		ArrayList<Integer> array = new ArrayList<>();
		Scanner in = new Scanner(System.in);
		System.out.print("Enter 10 Intergers: ");
		for(int i=0; i<10;i++){
			array.add(in.nextInt());
		}
		
		removeDuplicate(array);
		
		for(int i=0; i<array.size();i++){
			System.out.println(array.get(i) + " ");
		}
	}
	
	public static void removeDuplicate(ArrayList<Integer> array){
		for(int i=0; i<array.size();i++){
			for(int j=0; j<array.size();j++){
				if(array.get(i) == array.get(j) && i != j){
					array.remove(j);
				}
				
			}
		}
	}

}
