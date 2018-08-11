//Alex Schwiegeraht
//Description: The user inputs a file to be read in. The projects from the file are then read in and
//then the most profitable set of projects is outputed to a file based on the number of weeks given by the user.

import java.io.*;
import java.util.*;

public class KnapsackProblem {

	public static void main(String[] args) throws FileNotFoundException{
		
		/*Stings for I/O file names, Integers for counters and totals, 
		 *and ArrayLists to store both input and output of the different projects 
		 */
		String inputFileName, outputFileName;
		int totalWeeks, counter, weeksLeft, totalProjects = 0, maxProfit = 0;
		ArrayList<String> names = new ArrayList<>();	
		ArrayList<Integer> weeks = new ArrayList<>();
		ArrayList<Integer> profit = new ArrayList<>();
		ArrayList<String> selectedProjects = new ArrayList<>();
		ArrayList<Integer> selectedWeeks = new ArrayList<>();
		ArrayList<Integer> selectedProfit = new ArrayList<>();
		
		
		//User input
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the number of available employee work weeks: ");
		totalWeeks = in.nextInt();
		System.out.print("Enter the name of input file: ");
		inputFileName = in.next();
		System.out.print("Enter the name of output file: ");
		outputFileName = in.next();
		in.close();
		
		//Selected file input
		Scanner dataFile = new Scanner(new File(inputFileName));
		while (dataFile.hasNextLine())
		{
			String line = dataFile.nextLine();
			String[] split = line.split(" ");
			names.add(split[0]);
			weeks.add(Integer.parseInt(split[1]));
			profit.add(Integer.parseInt(split[2]));
		}
		dataFile.close();
		
		totalProjects = names.size();
		counter = totalProjects;
		weeksLeft = totalWeeks;
		int[][] projects = new int[totalWeeks + 1][totalProjects + 1];
		
		//Dynamically gets the best profit and places it in a 2D array
		for(int j = 0; j <= totalProjects; j++){
			for(int w = 0; w <= totalWeeks; w++){
				if(j == 0 || w == 0){
					projects[w][j] = 0;
				}
				else if(weeks.get(j-1) > w){
					projects[w][j] = projects[w][j - 1];
				}
				else{
					projects[w][j] = max(projects[w - weeks.get(j-1)][j - 1] + profit.get(j-1), projects[w][j - 1]);
				}
				maxProfit = projects[w][j];
						
			}
			
		}
		
		//places projects into array lists to be used in results
		for(int i = totalProjects; i >= 1; i--){
			if(projects[weeksLeft][i] != projects[weeksLeft][i-1]){
				
				selectedProjects.add(names.get(i-1));
				selectedWeeks.add(weeks.get(i-1));
				selectedProfit.add(profit.get(i-1));
				
				weeksLeft -= selectedWeeks.get(totalProjects-counter);
				counter--;
			}
			
		}
		
		//prints results to an output file
		PrintWriter outputFile = new PrintWriter(outputFileName);
		outputFile.println("Number of projects available: " + totalProjects);
		outputFile.println("Available employee work weeks: " + totalWeeks);
		outputFile.println("Number of projects chosen: " + selectedProjects.size());
		outputFile.println("Total profit: " + maxProfit);
		for(int i = 0; i < selectedProjects.size(); i++){
			outputFile.println(selectedProjects.get(i) + " " + selectedWeeks.get(i) + " " + selectedProfit.get(i));
		}
		outputFile.close();
	}
	
	
	//a method to get the maximum of two values
	static int max(int x, int y){
		return (x > y)? x : y;
	}

}
