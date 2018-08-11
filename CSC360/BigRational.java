/* Alex Schwiegeraht
 * Description: A rational number class that uses BigInteger
 */
import java.math.BigInteger;

public class BigRational extends Number implements Comparable<BigRational>{
	private static final long serialVersionUID = 747594659068733876L;
	
	// Data fields for numerator and denominator
	  private BigInteger numerator = BigInteger.valueOf(0);
	  private BigInteger denominator = BigInteger.valueOf(1);

	  /** Construct a rational with default properties */
	  public BigRational() {
	  
	  }
	  /** Construct a rational with specified numerator and denominator */
	  public BigRational(BigInteger numerator, BigInteger denominator) {
		if (denominator.equals(0))
		  throw new ArithmeticException("Rational number with denominator zero");
		BigInteger gcd = numerator.gcd(denominator);
	    this.numerator = (BigInteger.valueOf((denominator.compareTo(BigInteger.valueOf(0)) > 0) ? 1 : -1)).multiply(numerator.divide(gcd)) ;
	    this.denominator = (denominator.abs()).divide(gcd);
	  }

	  /** Return numerator */
	  public BigInteger getNumerator() {
	    return numerator;
	  }

	  /** Return denominator */
	  public BigInteger getDenominator() {
	    return denominator;
	  }

	  /** Add a rational number to this rational */
	  public BigRational add(BigRational secondRational) {
	    BigInteger n = numerator.multiply(secondRational.getDenominator()).add(
	      denominator.multiply(secondRational.getNumerator()));
	    BigInteger d = denominator.multiply(secondRational.getDenominator());
	    return new BigRational(n, d);
	  }

	  /** Subtract a rational number from this rational */
	  public BigRational subtract(BigRational secondRational) {
		BigInteger n = numerator.multiply(secondRational.getDenominator()).subtract(
	      denominator.multiply(secondRational.getNumerator()));
		BigInteger d = denominator.multiply(secondRational.getDenominator());
	    return new BigRational(n, d);
	  }

	  /** Multiply a rational number to this rational */
	  public BigRational multiply(BigRational secondRational) {
		BigInteger n = numerator.multiply(secondRational.getNumerator());
		BigInteger d = denominator.multiply(secondRational.getDenominator());
	    return new BigRational(n, d);
	  }

	  /** Divide a rational number from this rational */
	  public BigRational divide(BigRational secondRational) {
		BigInteger n = numerator.multiply(secondRational.getDenominator());
		BigInteger d = denominator.multiply(secondRational.numerator);
	    return new BigRational(n, d);
	  }

	  @Override  
	  public String toString() {
	    if (denominator.equals(1))
	      return numerator + "";
	    else
	      return numerator + "/" + denominator;
	  }

	  @Override // Override the equals method in the Object class 
	  public boolean equals(Object other) {
	    if ((this.subtract((BigRational)(other))).getNumerator().equals(0))
	      return true;
	    else
	      return false;
	  }

	  @Override // Implement the abstract intValue method in Number 
	  public int intValue() {
	    return (int)doubleValue();
	  }

	  @Override // Implement the abstract floatValue method in Number 
	  public float floatValue() {
	    return (float)doubleValue();
	  }

	  @Override // Implement the doubleValue method in Number 
	  public double doubleValue() {
	    return (numerator.doubleValue())*1.0/denominator.doubleValue();
	  }

	  @Override // Implement the abstract longValue method in Number
	  public long longValue() {
	    return (long)doubleValue();
	  }

	  @Override // Implement the compareTo method in Comparable
	  public int compareTo(BigRational o) {
	    if (this.subtract(o).getNumerator().compareTo(BigInteger.valueOf(0)) > 0)
	      return 1;
	    else if (this.subtract(o).getNumerator().compareTo(BigInteger.valueOf(0)) < 0)
	      return -1;
	    else
	      return 0;
	  }
}
