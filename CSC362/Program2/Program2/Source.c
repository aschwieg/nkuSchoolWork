//Alex Schwiegeraht
//CSC 362, 001, Programming assignment 2, 2/21/18

//This program uses functions to test and compare a individual city's livability score.
//This is done by taking certian statistics about the city and using certian formulas to
//get to the livability score for the city. The city's scores are displayed individually and then 
// the best score, best city,  number of cities, and average of all cities are displayed as well.

#include "Header.h"

void main()
{	
	char filename[30], cityName[30], topCityName[30];//Three strings used for holding the filename and two city names
	int population, squareMileage, pollutionAmount, crime, expense, numOfHighways, numOfCities = 0;//Ints that hold statistics from each city as well as the number of cities
	double populationDensity, pollutionRating, trafficRating, crimePerCapita, expensePerCapita, livability, sumOfRatings = 0, averageRating, topCityRating = 0;//Doubles for statistics after a formula is applied to them used to calculate livability Double for livability of current city as well as the top city's rating and the average
									
	FILE *fp1;//File to read from

	printf("Enter the filename to be scanned:  ");//Gets user selected file
	scanf("%s", filename);

	fp1 = fopen(filename, "r");//Opens file to be read
	printf("\nCity\t\tPopulation Dens\t\tLivability Score\n");//Prints the name of each column

	while(getInput(fp1, cityName, &population, &squareMileage, &pollutionAmount, &crime, &expense, &numOfHighways) != EOF)//gets the input from the a line in the file and will continue till there are no longer any lines
	{
		populationDensity = popDensity(population, squareMileage);//gets the population density of the current city
		getRatings(&pollutionRating, &trafficRating, &crimePerCapita, &expensePerCapita, populationDensity, pollutionAmount, numOfHighways, crime, expense);//gets the statistics for the livability score	
		livability = getLivability(pollutionRating, trafficRating, crimePerCapita, expensePerCapita);//gets the livability score
		isBest(&numOfCities, livability, &sumOfRatings, &topCityRating, cityName, topCityName, &averageRating);//checks if the current city has the bes livability score as well as calculating the average livability score																					
		outputCityResults(cityName, populationDensity, livability);//outputs the city results to the console
	}

	fclose(fp1);//closes the file

	printf("\nOf the %d cities with an average of %.2f, the most liveable was %s with a score of %.2f", numOfCities, averageRating, topCityName, topCityRating);//prints the number of cities, average livability, the best livability score, and the name of city that has the best score
	printf("\n");
	
	system("PAUSE");
}