/* Alex Schwiegeraht
 * Description: A rational number test class that uses FastRational to go through a series of nationals and add them together
 */

public class testFastRationalSeries {

	public static void main(String[] args) {
		FastRational ratSum = new FastRational();
		for(int i = 1;i<100;i++){
			FastRational ratAdd = new FastRational(i,i+1);
			ratSum = ratSum.add(ratAdd);
		}
		System.out.println("Series Sum: " + ratSum.toString());
		System.out.println("Series Sum: " + ratSum.doubleValue());

	}

}
