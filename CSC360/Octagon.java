/* Alex Schwiegeraht
 * Description: An object that represents an Octagon and is both cloneable and comparable
 */
public class Octagon extends GeometricObject implements Cloneable, Comparable<Octagon>{
	private double side;
	private boolean isClone = false;
	
	public Octagon(){
		side = 0;
	}
	
	public Octagon(double n){
		side=n;
	}
	
	public boolean getIsClone(){
		return isClone;
	}
	
	public double getSide(){
		return side;
	}
	
	//Overides getArea()
	public double getArea(){
		return  (2 + 4 / Math.sqrt(2)) * side * side;
	}
	
	//Overides getPerimeter()
	public double getPerimeter(){
		return 8*side;
	}

	@Override
	public int compareTo(Octagon o) {
		if(getArea() > o.getArea()){
			return 1;
		}
		else if(getArea() < o.getArea()){
			return -1;
		}
		else{
			return 0;
		}
	}
	
	public Object clone(){
		try {
			Octagon octagonClone = (Octagon)super.clone();
		    octagonClone.isClone = true;
		    return octagonClone;
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
	
	public String toString(){
		return "Octagon with side = " + getSide() + " perimeter = " + getPerimeter() + " area = " + getArea() + " isClone = " + getIsClone();
	}

	public void setSide(double d) {
		side = d;
		
	}
	
}
