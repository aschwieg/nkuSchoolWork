/*
 * Author: Alex Schwiegeraht
 * Course: CSC-260L-002
 * Date: 4/4/2017
 * Assignment: #12
 * Instructor: Bo–Kyung Kirby
 */
import java.text.DecimalFormat;

public class RightTriangle {
	private double sideA, sideB;
	DecimalFormat df = new DecimalFormat("##.00");
	
	public RightTriangle(){
		sideA = 0.0;
		sideB = 0.0;
	}
	
	public RightTriangle(double a, double b){
		sideA = a;
		sideB = b;
	}
	
	public double getHypotenuse(){
		return Math.hypot(sideA, sideB);
	}
	
	public double getAngleA(){
		return Math.toDegrees(Math.asin(sideB/getHypotenuse()));
	}
	
	public double getAngleB(){
		return Math.toDegrees(Math.asin(sideA/getHypotenuse()));
	}
	
	public double getPerimeter(){
		return sideA+sideB+getHypotenuse();
	}
	
	public double getArea(){
		return .5*sideA*sideB;
	}
	
	public String toString(){
		return "Side A: " + sideA + "\nSide B: " + sideB + "\nHypotenuse: " + df.format(getHypotenuse()) + "\nPerimeter: " + df.format(getPerimeter()) + "\nArea: " + df.format(getArea());
	}
	
	public void changeSideA(double n){
		if(n>0){sideA = n;}
	}
	
	public void changeSideB(double n){
		if(n>0){sideB = n;}
	}
}
