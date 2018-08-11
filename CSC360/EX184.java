
public class EX184 {

	public static void main(String[] args) {
		System.out.print(method(5));

	}
	public static double method(int i){
		if(i==1){
			return 1.0;
		}
		else{
			return 1.0/i + method(i-1);
		}
		
	}

}
