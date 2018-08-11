
public class TestTime {

	public static void main(String[] args) {
		Time t1 = new Time();
		Time t2 = new Time(55550000);
		
		System.out.println((t1.getHour()-4) + ":" + t1.getMinute() + ":" + t1.getSecond() + " EDT");
		System.out.println(t2.getHour() + ":" + t2.getMinute() + ":" + t2.getSecond() + " EDT");
	}

}
