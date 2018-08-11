#include "Header.h"

//takes a file and puts the data from each line to be put into variables
int getInput(FILE *fp1, char *cit, int *pop, int *squ, int *pol, int *crime, int *expense, int *num)
{
	return fscanf(fp1, "%s %d %d %d %d %d %d", cit, pop, squ, pol, crime, expense, num);
}


//prints the name, the population density, and livability to the console
void outputCityResults(char *name, double popDen, double livability)
{
	printf("%-10s\t\t%-10.2f\t\t%-10.2f\n", name, popDen, livability);
}