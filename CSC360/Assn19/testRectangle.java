import java.util.*;
public class testRectangle {

	public static void main(String[] args) {
		Rectangle rect1 = new Rectangle(4,40);
		Rectangle rect2 = new Rectangle(3.5,25.9);
		
		System.out.printf("Rectangle 1\nWidth: %.2f\nHeight: %.2f\nArea: %.2f\nPerimeter: %.2f\n\n", rect1.width,rect1.height,rect1.getArea(),rect1.getPerimeter());
		System.out.printf("Rectangle 2\nWidth: %.2f\nHeight: %.2f\nArea: %.2f\nPerimeter: %.2f", rect2.width,rect2.height,rect2.getArea(),rect2.getPerimeter());
	}

}
