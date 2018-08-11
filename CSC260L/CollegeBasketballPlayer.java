
public class CollegeBasketballPlayer extends BasketballPlayer{
	private int eligibilityRemaining;
	private String role;
	
	CollegeBasketballPlayer(){
		super(); 
		eligibilityRemaining = 4;
		role = "bench";
	}
	
	CollegeBasketballPlayer(String a, String b, String c){
		super(a,b,c);
		eligibilityRemaining = 4;
		role = "bench";
	}
	
	CollegeBasketballPlayer(String a, String b, String c, int d, int e, int f, int g, int h, int j,String i){
		super(a,b,c,d,e,f,g,h);
		eligibilityRemaining = j;
		role = i;
	}
	
	public void setEligibilityRemaining(int a){
		eligibilityRemaining = a;
	}
	
	public void setRole(String a){
		role = a;
	}
	
	public int getEligibilityRemaining(){
		return eligibilityRemaining;
	}
	
	public String getRole(){
		return role;
	}
	
	public boolean draftable(){
		if((role.equals("starter") && super.getValue() > 4) || (role.equals("bench") && super.getValue() >= 8)){
			return true;
		}
		else{
			return false;
		}
	}
	
	public String toString(){
		return super.toString() + "\nRole:" + role;
	}
	
}
