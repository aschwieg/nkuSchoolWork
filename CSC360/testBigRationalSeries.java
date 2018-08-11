/* Alex Schwiegeraht
 * Description: A rational number test class that uses BigRational to go through a series of nationals and add them together
 */
import java.math.BigInteger;

public class testBigRationalSeries {

	public static void main(String[] args) {
		BigRational ratSum = new BigRational();
		for(int i = 1;i<100;i++){
			BigRational ratAdd = new BigRational(BigInteger.valueOf(i),BigInteger.valueOf(i+1));
			ratSum = ratSum.add(ratAdd);
		}
		System.out.println("Series Sum: " + ratSum.toString());
		System.out.println("Series Sum: " + ratSum.doubleValue());

	}


}
