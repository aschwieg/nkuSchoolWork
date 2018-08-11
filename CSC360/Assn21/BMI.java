
public class BMI {
	private int height = 0;
	private int weight = 0;
	private double CONVERT_TO_KILO = .45359237;
	private double CONVERT_TO_POUND = 2.20462;
	private double CONVERT_TO_METER = .0254;
	
	BMI(){
		
	}

	BMI(int myHeight, int myWeight){
		height = myHeight;
		weight = myWeight;
	}
	
	double getBMI(){
		return (weight*CONVERT_TO_KILO)/Math.pow(height*CONVERT_TO_METER,2);
	}
	
	long getMaxWeight(){		
		return Math.round(((25)*Math.pow(height*CONVERT_TO_METER,2))*CONVERT_TO_POUND);
	}
	
	double setWeight(int w){
		return (w*CONVERT_TO_KILO)/Math.pow(height*CONVERT_TO_METER,2);
	}
}
