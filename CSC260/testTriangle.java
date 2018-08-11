import java.util.Scanner;

public class testTriangle {

	public static void main(String[] args) {
		Triangle t1 = new Triangle(3,4,5);
		t1.setColor("Red");
		t1.setFilled(true);
		System.out.println("Area: " +  t1.getArea());
		System.out.println("Perimeter: " + t1.getPerimeter());
		System.out.println(t1.toString());
		
	}

}
