
public class BasketballPlayer {
	protected String name, position, team;
	protected int height, weight, agility, speed, ballHandling;
	
	public BasketballPlayer(){
		name = "unknown";
		position = "unknown";
		team = "unknown";
		height = 0;
		weight = 0;
		agility = 0;
		speed = 0;
		ballHandling = 0;
	}
	
	public BasketballPlayer(String a, String b, String c){
		name = a;
		position = b;
		team = c;
		height = 0;
		weight = 0;
		agility = 0;
		speed = 0;
		ballHandling = 0;
	}
	
	public BasketballPlayer(String a, String b, String c, int d, int e, int f, int g, int h){
		name = a;
		position = b;
		team = c;
		height = d;
		weight = e;
		agility = f;
		speed = g;
		ballHandling = h;
	}
	
	public int getValue(){
		int value = 0;
		
		if(position.equals("Center")){
			if(height >= 82 && weight>220 && weight<250 && ballHandling > 5){
				value=10;
			}
			else if(height >= 80 && weight>210 && weight<260 && ballHandling > 5){
				value = 8;
			}
			else if(height >= 80 && ballHandling > 4){
				value = 6;
			}
			else if(height >= 78 && agility > 7){
				value = 5;
			}
			else if(height >= 78){
				value = 4;
			}
			else if(height >= 76 && agility > 5){
				value = 2;
			}
			else{
				value = 0;
			}
		}
		else if(position.equals("Forward")){
			if(height >= 80 && (agility > 8 || speed > 7)){
				value=10;
			}
			else if(height >= 78 && agility > 6 && speed > 5){
				value = 8;
			}
			else if(height >= 77 && agility > 5){
				value = 6;
			}
			else if(height >= 76 && speed > 4){
				value = 5;
			}
			else if(height >= 75 && (agility > 3 || speed > 3)){
				value = 3;
			}
			else if(height >= 74){
				value = 1;
			}
			else{
				value = 0;
			}
		}
		else{
			if(height >= 78 && ballHandling > 7 && (agility > 7 || speed > 7)){
				value=10;
			}
			else if(height >= 76 &&  ballHandling > 7 && agility > 6 && speed > 6){
				value = 8;
			}
			else if(height >= 74 && ballHandling > 5 && agility > 5 && speed > 6){
				value = 6;
			}
			else if( ballHandling > 6 && agility > 6 && speed > 5){
				value = 4;
			}
			else if( ballHandling > 4 && agility > 5 ){
				value = 2;
			}
			else{
				value = 0;
			}
		}
		
		return value;
	}
	
	public String getName(){
		return name;
	}
	
	public String getPosition(){
		return position;
	}
	
	public String getTeam(){
		return team;
	}
	
	public int getHeight(){
		return height;
	}
	
	public int getWeight(){
		return weight;
	}
	
	public int getAgility(){
		return agility;
	}
	
	public int getSpeed(){
		return speed;
	}
	
	public int getBallHandling(){
		return ballHandling;
	}
	
	public void setName(String a){
		name = a;
	}
	
	public void setPosition(String a){
		position = a;
	}
	
	public void setTeam(String a){
		team = a;
	}
	
	public void setHeight(int a){
		height = a;
	}
	
	public void setWeight(int a){
		weight = a;
	}
	
	public void setAgility(int a){
		agility = a;
	}
	
	public void setSpeed(int a){
		speed = a;
	}
	
	public void setBallHandling(int a){
		ballHandling = a;
	}
	
	public String toString(){
		return "Name: " + name + "\nPosition: " + position + "\nTeam: " + team + "\nValue: " + getValue();
	}

	
}
