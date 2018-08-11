#include "Header.h"


//takes the population value and the square mileage value and returns population density
double popDensity(int pop, int squ)
{
	return 1.0 * pop / squ;
}

//calculates the pollution, traffic, crime per capita, and expense per capita ratings and puts them into variables to be used for later 
void getRatings(double *pollution, double *trafficRating, double *crimePerCapita, double *expensePerCapita, double popDen, int pol, int numOfHighways, int crime, int expense)
{
	*pollution = pol * popDen / 1000;
	*trafficRating = popDen * TRAC / numOfHighways;
	*crimePerCapita = crime * popDen / CRIC;
	*expensePerCapita = expense * popDen / EXPC;
}

//calculates the livability score based on the ratings of each city
double getLivability(double pollutionRating, double trafficRating, double crimePerCapita, double expensePerCapita)
{
	return 100 - (pollutionRating + trafficRating + crimePerCapita + expensePerCapita) / LIVC;
}

//checks if the current city has the best score as well as calculates the average livability
void isBest(int *numOfCities, double livability, double *sumOfRatings, double *topCityRating, char *cityName, char *topCityName, double *averageRating)
{
	*sumOfRatings = *sumOfRatings + livability;
	*numOfCities = *numOfCities + 1;
	*averageRating = *sumOfRatings / *numOfCities;

	if (livability > *topCityRating)
	{
		*topCityRating = livability;
		strcpy(topCityName, cityName);
	}
}