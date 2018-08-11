/* Alex Schwiegeraht
 * Description:Test class that clones an Octagon object and then changes the originals value
 */
public class testOctagon {

	public static void main(String[] args) {
		Octagon oct1 = new Octagon(5);
		Octagon oct2 = (Octagon)oct1.clone();
		System.out.println("Oct1: " + oct1.toString());
		System.out.println("Oct2: " + oct2.toString());
		System.out.println("oct1.compareTo(oct2): " + oct1.compareTo(oct2));
		oct1.setSide(5.2);
		System.out.println("Oct1: " + oct1.toString());
		System.out.println("Oct2: " + oct2.toString());
		System.out.println("oct1.compareTo(oct2): " + oct1.compareTo(oct2));

	}

}
