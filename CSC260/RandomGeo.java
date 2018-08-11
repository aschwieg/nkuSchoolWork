import java.util.Random;

public class RandomGeo {

	public static void main(String[] args) {
		Random rand= new Random();
		rand.nextBoolean();
		rand.nextDouble();
		SimpleGeometricObject[] array = new SimpleGeometricObject[10];
		for(int i = 0; i<array.length; i++){
			if(rand.nextInt(2) == 0){
				array[i]= new Triangle(rand.nextInt(10),rand.nextInt(10),rand.nextInt(10));
			}
			else{
				array[i]= new Circle(rand.nextInt(10));
			}
		}

	}

}
