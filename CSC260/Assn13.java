
public class Assn13 {

	public static void main(String[] args) {
		int celsius = 0;
		while(celsius<=30){
			celToFar(celsius);
			celsius = celsius + 5;
		}
	}
	public static double celToFar(double celsius){
		long fahrenheit = Math.round((1.8*celsius)+32);
		System.out.println("Celsius: " + celsius + "	" + "Fahrenheit: " + fahrenheit);
		return celsius;
	}
}
