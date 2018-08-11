/*
 * Author: Alex Schwiegeraht
 * Course: CSC-260L-002
 * Date: 4/4/2017
 * Assignment: #12
 * Instructor: Bo–Kyung Kirby
 */

import java.text.DecimalFormat;

public class userClass {

	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("##.00");
		RightTriangle t1 = new RightTriangle(5,20);
		RightTriangle t2 = new RightTriangle(3,4);
		RightTriangle t3 = new RightTriangle();
		RightTriangle t4 = new RightTriangle(16.3,4.889);
		
		System.out.println(df.format(t1.getPerimeter()));
		System.out.println(df.format(t1.getAngleA()));
		System.out.println(df.format(t1.getAngleB()));
		System.out.println(df.format(t2.getArea()));
		t3.changeSideA(10.1);
		t3.changeSideB(12.4);
		System.out.println(df.format(t3.getAngleA()));
		System.out.println(df.format(t3.getAngleB()));
		System.out.println(t4.toString());
		t4.changeSideA(-6);
		System.out.println(t4.toString());
		t2.changeSideA(5.0);
		System.out.println(t2.toString());
		
	}

}
/*
45.62
75.96
14.04
6.00
50.84
39.16
Side A: 16.3
Side B: 4.889
Hypotenuse: 17.02
Perimeter: 38.21
Area: 39.85
Side A: 16.3
Side B: 4.889
Hypotenuse: 17.02
Perimeter: 38.21
Area: 39.85
Side A: 5.0
Side B: 4.0
Hypotenuse: 6.40
Perimeter: 15.40
Area: 10.00
 */