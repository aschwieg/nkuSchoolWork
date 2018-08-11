
public class Rectangle {
	double width = 1;
	double height = 1;
	
	Rectangle(){
		
	}
	
	Rectangle(double myWidth, double myHeight){
		width = myWidth;
		height = myHeight;
	}
	
	double getArea(){
		return width*height;
	}
	 
	double getPerimeter(){
		return (2*height)+(2*width);
	}
}
