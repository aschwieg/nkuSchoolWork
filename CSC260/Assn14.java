
public class Assn14 {

	public static void main(String[] args) {
		int roll1,roll2, total, goal;
		boolean win = false;
		boolean lose = false;
		roll1 = diceRoll();
		roll2 = diceRoll();
		total = roll1 + roll2;
		System.out.println("Your total is " + total);
		if(total == 7 || total == 11){
			win = true;
		}
		else if(total == 2 || total == 3 || total == 12){
			lose = true;
		}
		else{
			goal = total;
			System.out.println("Your goal is " + goal);
			do{
				roll1 = diceRoll();
				roll2 = diceRoll();
				total = roll1 + roll2;
				if(total==goal){win=true;}
				if(total==7){lose=true;}
				System.out.println("Your total is " + total);
			}while((win == false) && (lose == false));
		}
		if(win == true){
			System.out.print("You win!");
		}
		if(lose == true){
			System.out.print("You lose!");
		}
		

	}

	public static int diceRoll(){
		return (int)(6*Math.random()+1);
	}
}
