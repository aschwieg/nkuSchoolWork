/*
 * Author: Alex Schwiegeraht
 * Course: CSC-260L-002
 * Date: 4/11/2017
 * Assignment: #13
 * Instructor: Bo–Kyung Kirby
 */

public class testRational {

	public static void main(String[] args) {
		Rational r1 = new Rational(1, 6);
		Rational r2 = new Rational(-5, -7);
		Rational r3 = new Rational(4, 2);
		Rational r4 = new Rational(3, -2);
		Rational r5 = r1.add(r3);
		Rational r6 = r5.multiply(r4);
		Rational r7 = r2.subtract(r3);
		r1.setDenominator(0);
		r2.setNumerator(42);
		r3 = r4.divide(r3);
		System.out.println(r4.comparesTo(r5));
		System.out.println(r1.comparesTo(new Rational(3, -7) ) );
		System.out.println(r1.toString());
		System.out.println(r2.toString());
		System.out.println(r3.toString());
		System.out.println(r4.toString());
		System.out.println(r5.toString());
		System.out.println(r6.toString());
		System.out.println(r7.toString());


	}

}

/*
-1
1
0/1
6/1
-3/4
-3/2
13/6
-39/12
-9/7
 */
