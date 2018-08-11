
public class ProBasketballPlayer extends BasketballPlayer{
	private int yearsInLeague;
	private String role;
	
	ProBasketballPlayer(){
		super();
		yearsInLeague = 0;
		role = "bench";
	}
	
	ProBasketballPlayer(String a, String b, String c){
		super(a,b,c);
		yearsInLeague = 0;
		role = "bench";
	}
	
	ProBasketballPlayer(String a, String b, String c, int d, int e, int f, int g, int h, int j, String i){
		super(a,b,c,d,e,f,g,h);
		yearsInLeague = j;
		role = i;
	}
	
	public int newContractValue(){
		int value = 0;
		if(role.equals("starter")){
			if(yearsInLeague>=10){
				if(getValue()>8){
					value = 12000000;
				}
				else if(getValue()>5){
					value = 6000000;
				}
			}
			else if(yearsInLeague>=8){
				if(getValue()>7){
					value = 10000000;
				}
			}
			else if(yearsInLeague>=5){
				if(getValue()>7){
					value = 8000000;
				}
				else{
					value = 2000000;
				}
			}
			else{
				value = 1000000;
			}
		}
		else if(role.equalsIgnoreCase("bench")){
			if(yearsInLeague>=10){
				if(getValue()>8){
					value = 7500000;
				}
				else if(getValue()>5){
					value = 4500000;
				}
			}
			else if(yearsInLeague>=8){
				if(getValue()>7){
					value = 5000000;
				}
			}
			else if(yearsInLeague>=7){
				value = 2000000;
			}
			else{
				value = 500000;
			}
		}
		else{
			value = 0;
		}
		return value;
	}
	
	public String toString(){
		return super.toString() + "\nRole: " + role + "\nYears in League: :" + yearsInLeague;
	}
	
}
