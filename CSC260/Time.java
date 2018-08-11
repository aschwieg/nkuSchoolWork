import java.time.*;
public class Time {
	private int hour;
	private int minute;
	private int second;
	
	public Time(){
		second = (int)((System.currentTimeMillis()/1000)%60);
		minute =  (int)(((System.currentTimeMillis()/1000)/60)%60);
		hour = (int)((((System.currentTimeMillis()/1000)/60)/60)%24);
	}
	
	public Time(long a){
		second = (int)((a/1000)%60);
		minute =  (int)(((a/1000)/60)%60);
		hour = (int)((((a/1000)/60)/60)%24);

	}
	
	public int getSecond(){
		return second;
	}
	
	public int getMinute(){
		return minute;
	}
	
	public int getHour(){
		return hour;
	}
	
	public void setTime(long elapseTime){
		second = (int)(((System.currentTimeMillis()-elapseTime)/1000)%60);
		minute =  (int)((((System.currentTimeMillis()-elapseTime)/1000)/60)%60);
		hour = (int)(((((System.currentTimeMillis()-elapseTime)/1000)/60)/60)%24);
	}
	
	
	
}
