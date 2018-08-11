
public class Assignment_10 {

	public static void main(String[] args) {
		int celsius = 0;
		long fahrenheit;
		while(celsius<=30){
			fahrenheit = Math.round((1.8*celsius)+32);
			System.out.println("Celsius: " + celsius + "	" + "Fahrenheit: " + fahrenheit);
			celsius = celsius + 5;
		}
	}
}
