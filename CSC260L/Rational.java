/*
 * Author: Alex Schwiegeraht
 * Course: CSC-260L-002
 * Date: 4/11/2017
 * Assignment: #13
 * Instructor: Bo–Kyung Kirby
 */

public class Rational {
	private int numerator;
	private int denominator;
	//creates blank rational
	Rational(){
		numerator = 0;
		denominator = 1;
	}
	//creates rational with user's input
	Rational(int a, int b){
		if(b<0){
			b=b*-1;
			a=a*-1;
		}
		else if(b==0){
			a = 0;
			b = 1;
		}
		numerator = a;
		denominator = b;
		reduce();
	}
	
	public int getNumerator(){
		return numerator;
	}
	
	public int getDenominator(){
		return denominator;
	}
	
	public void setNumerator(int a){
		numerator = a;
		reduce();
	}
	
	public void setDenominator(int b){
		if(b<0){
			b=b*-1;
			numerator = numerator*-1;
		}
		else if(b==0){
			numerator = 0;
			b = 1;
		}
		denominator = b;
		reduce();
	}
	//Puts data to string
	public String toString(){
		return numerator + "/" + denominator;
	}
	//Compares the rational to a new rational to see which is biggest
	public int comparesTo(Rational other){
		int p1 = numerator*other.getDenominator();
		int p2 = denominator*other.getNumerator();
		
		if(p1>p2){
			return 1;
		}
		else if(p1==p2){
			return 0;
		}
		else{
			return -1;
		}
	}
	//adds the rational to a new rational
	public Rational add(Rational other){
		int num1 = numerator;
		int num2 = other.getNumerator();
		int den1 = denominator;
		int den2 = other.getDenominator();
		int num3 = (num1 * den2 + num2 * den1);
		int den3 = den1 * den2;
		Rational r1 = new Rational(num3, den3);
		return r1;

	}
	//subtracts the rational by a new rational
	public Rational subtract(Rational other){
		int num1 = numerator;
		int num2 = other.getNumerator();
		int den1 = denominator;
		int den2 = other.getDenominator();
		int num3 = (num1 * den2) - (num2 * den1);
		int den3 = den1 * den2;
		Rational r1 = new Rational(num3, den3);
		return r1;
		
	}
	//multiplies the rational by a new rational
	public Rational multiply(Rational other){
		int num1 = numerator;
		int num2 = other.getNumerator();
		int den1 = denominator;
		int den2 = other.getDenominator();
		int num3 = num1 * num2;
		int den3 = den1 * den2;
		Rational r1 = new Rational(num3, den3);
		return r1;
		
	}
	//divides the rational by a new rational
	public Rational divide(Rational other){
		int num1 = numerator;
		int num2 = other.getNumerator();
		int den1 = denominator;
		int den2 = other.getDenominator();
		int num3 = num1 * den2;
		int den3 = num2 * den1;
		Rational r1 = new Rational(num3, den3);
		return r1;
		
	}
	//reduces the fraction
	private void reduce(){
		int divisor = 2;
		while(divisor <= numerator && divisor <= denominator){
			if(numerator%denominator == 0 && denominator%divisor == 0){
				numerator = numerator/divisor;
				denominator = denominator/divisor;
			}
			else{
				divisor++;
			}
		}
	}
}
