#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <ctype.h>

#define TRAC 1.7																		//constant for traffic rating
#define CRIC 872.6																		//constant for crime rating
#define EXPC 1217.1																		//constant for expense rating
#define LIVC 13.81																		//constant for livability rating

double popDensity(int, int);															//returns the population density
double getLivability(double, double, double, double);									//returns the livability score

void isBest(int *, double, double *, double *, char *, char *, double *);				//checks if the city has the best livability and computes the average
void outputCityResults(char *, double, double);											//prints results
void getRatings(double *, double *, double *, double *, double, int, int, int, int);	//gets statistics for computing livability

int getInput(FILE *, char *, int *, int *, int *, int *, int *, int *);					//takes a line of data from the input file and puts them into variables and returns 0 if it reaches the end of the file