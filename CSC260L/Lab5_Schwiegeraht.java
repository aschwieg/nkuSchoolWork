/*
 * Author: Alex Schwiegeraht
 * Course: CSC-260L-002
 * Date: 2/7/2017
 * Assignment: #5
 * Instructor: Bo–Kyung Kirby
 */
import java.text.DecimalFormat;
import java.util.*;

public class Lab5_Schwiegeraht {

	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("$##.00");
		Scanner input = new Scanner(System.in);
		
//Obtains type and minute data
		System.out.println("Type either R for residential or C for commercial or E for educational or P for preferred: ");
		char type = input.next().toLowerCase().charAt(0);
		if(!(type =='r' || type == 'c' || type =='e' || type == 'p')){System.out.print("Invalid client type");return;}
		System.out.println("What is your total number of minutes: ");
		int minutes = input.nextInt();
		if(minutes < 0 || minutes > 10080){System.out.print("Invalid number of minutes");return;}
		
//gives the client the price
		double price;
		if( type=='r'){//residential
			price = 5.00;
			if( minutes <= 60 ){
				}
			else{
				price = price + ((minutes-60) * .1);
		}
			}
		else if(type=='e'){//educational
			price = minutes*.18;
		}
		else if(type=='p'){//preferred
			if(minutes<500){
				price = 10+(minutes*.06);
			}
			else{
				price = 10+(minutes*.04);
			}
		}
		else{//commercial			
			if(minutes <= 300){
				price = minutes * .2;
			}
			else{//bonus
				System.out.println("Bonus? y/n:");
				char bonus = input.next().toLowerCase().charAt(0);
				if(!(bonus =='y' || bonus == 'n')){System.out.print("Invalid response");return;}
				if(bonus == 'y'){
					price = ((300 * .2)+(minutes-300)*.15)*.7;
				}
				else{
					price = (300 * .2)+((minutes-300)*.15);
				}
			}
		}
		System.out.print(df.format(price));
	}

}
/*$30.00
 *$48.78
 *$.00
 *Invalid number of minutes
 *$28.90
 *$5.00
 *$41.30
 *$42.10
 *Invalid client type
 *$41.00
 *$97.65
 *$35.04
 *Invalid number of minutes
 *$12.70
 *$829.10
 *$147.15
 *Invalid client type
 *$46.52
 */

