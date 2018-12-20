// Alex Schwiegeraht
// 10/27/2018
// Banker's Algorithm

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <math.h>
#include <string.h>

#define NUMBER_OF_CUSTOMERS 5
#define NUMBER_OF_RESOURCES 3
#define BUFSIZE 80

int available[NUMBER_OF_RESOURCES];

int maximum[NUMBER_OF_CUSTOMERS][NUMBER_OF_RESOURCES];
int allocation[NUMBER_OF_CUSTOMERS][NUMBER_OF_RESOURCES];
int need[NUMBER_OF_CUSTOMERS][NUMBER_OF_RESOURCES];

bool is_safe();

/* Set initial values for all arrays using the following:
Customer	Allocation	Need		Maximum	
0			0 0 0 		7 1 3 		7 1 3 
1			0 0 0 		4 3 5 		4 3 5 		
2			0 0 0 		6 2 1 		6 2 1 		
3			0 0 0 		5 3 3 		5 3 3 		
4			0 0 0 		1 3 4 		1 3 4 		
*/
/* The above initial values only work when NUMBER_OF_CUSTOMERS is 3 */
void *initialize_resource_arrays(char* argv[])
{
	/* Loop control variables */
	int c,r;

	/* Initialize available resources to command-line parameters */
	for (r=0; r<NUMBER_OF_RESOURCES; ++r) available[r]=atoi(argv[r+1]);

	maximum[0][0]=7;
	maximum[0][1]=1;
	maximum[0][2]=3;

	maximum[1][0]=4;
	maximum[1][1]=3;
	maximum[1][2]=5;

	maximum[2][0]=6;
	maximum[2][1]=2;
	maximum[2][2]=1;

	maximum[3][0]=5;
	maximum[3][1]=3;
	maximum[3][2]=3;

	maximum[4][0]=1;
	maximum[4][1]=3;
	maximum[4][2]=4;

	/* Initialize need and allocation */
	for (c=0; c<NUMBER_OF_CUSTOMERS; ++c)
		for (r=0; r<NUMBER_OF_RESOURCES; ++r)
		{
			/* Initialize need = maximum */
			need[c][r]=maximum[c][r];

			/* Nothing is allocated */
			allocation[c][r]=0;
		}
}

/* Output the current state */
/* Only use this for debugging purposes. */
/* Do not call this function in your submitted solution. */
// Added the ability to throw any arrays into it so that I could test during the a safety algorithm with copied structures
print_state(int allocation[][NUMBER_OF_RESOURCES], int need[][NUMBER_OF_RESOURCES], int maximum[][NUMBER_OF_RESOURCES], int available[])
{
	int c,r;
	printf("\n");
	printf("Customer\tAllocation\tNeed\t\tMaximum\t\tAvailable\n");
	for (c=0; c<NUMBER_OF_CUSTOMERS; ++c)
	{
		printf("%d\t\t",c);
		for (r=0; r<NUMBER_OF_RESOURCES; ++r) printf("%d ",allocation[c][r]);
		printf("\t\t");
		for (r=0; r<NUMBER_OF_RESOURCES; ++r) printf("%d ",need[c][r]);
		printf("\t\t");
		for (r=0; r<NUMBER_OF_RESOURCES; ++r) printf("%d ",maximum[c][r]);
		printf("\t\t");
		if (c==0)
			for (r=0; r<NUMBER_OF_RESOURCES; ++r) printf("%d ",available[r]);
		printf("\n");
	}
	//Commented out safety check as I was testing within is_safe().
	// if (is_safe())
	// 	printf("SAFE!\n");
	// else
	// 	printf("UNSAFE!\n");
	// printf("\n");
}

/* Function makes copies of required data structures then runs through the safety algorithm */
bool is_safe()
{
	int i,j,r; //loop variables
	bool resourcesUnavailable; //flag for checking resource needs
	bool finished[NUMBER_OF_CUSTOMERS]; //flags for if each customer has finished
	int tempAvailable[NUMBER_OF_RESOURCES];
	int tempAllocation[NUMBER_OF_CUSTOMERS][NUMBER_OF_RESOURCES];
	int tempNeed[NUMBER_OF_CUSTOMERS][NUMBER_OF_RESOURCES];

	//Creates copies of data structures for safety algorithm
	for (i = 0; i < NUMBER_OF_CUSTOMERS; i++)
	{
		finished[i] = false;
		for (r = 0; r < NUMBER_OF_RESOURCES; r++) 
		{
			tempAllocation[i][r] = allocation[i][r];
			tempNeed[i][r] = need[i][r];
		}
	}
	for (r = 0; r < NUMBER_OF_RESOURCES; r++) 
	{
		tempAvailable[r] = available[r];
	}

	//Safety algorithm using a flag to mark if customer could finish
	for (j = 0; j < NUMBER_OF_CUSTOMERS; j++) 
	{
		for (i = 0; i < NUMBER_OF_CUSTOMERS; i++) 
		{
			resourcesUnavailable = false;
			if (!finished[i]) {
				for (r = 0; r < NUMBER_OF_RESOURCES; r++)
				{
					if (tempNeed[i][r] > tempAvailable[r]) 
					{
						resourcesUnavailable = true;
					}
				}
				
				if (!resourcesUnavailable) 
				{
					finished[i] = true;
					for (r = 0; r < NUMBER_OF_RESOURCES; r++)
					{
						tempAvailable[r] = tempAvailable[r] + tempAllocation[i][r]; 
					}
				}
			}
		}
	}
	
	for (i = 0; i < NUMBER_OF_CUSTOMERS; i++){
		if (!finished[i]) 
		{
			return false;
		}
	}

	return true;
}

/* First checks if the resources are available. If they are, they are given to the customer and is_safe() is run. If it is safe, it gets to keep
   the resources else it has to return them */
int request_resources(int c, int request[])
{
	int r;
	for (r = 0; r < NUMBER_OF_RESOURCES; r++) 
	{
		if (available[r] < request[r]) {
			printf("UNAVAILABLE\n");
			return 0;
		}
	}

	for (r = 0; r < NUMBER_OF_RESOURCES; r++) {
		available[r] = available[r] - request[r];
		allocation[c][r] = allocation[c][r] + request[r];
		need[c][r] = maximum[c][r] - allocation[c][r];
	}

	if (is_safe()) {
		printf("ACCEPTED\n");
		return 0;
	}
	else {
		for (r = 0; r < NUMBER_OF_RESOURCES; r++) {
			available[r] = available[r] + request[r];
			allocation[c][r] = allocation[c][r] - request[r];
			need[c][r] = need[c][r] - allocation[c][r];
		}
		printf("UNSAFE\n");
		return 0;
	}
}

/* Removes the resources from the customer and updates the available, need, and allocation of the customer */
int release_resources(int c, int release[])
{
	int r;
	for (r = 0; r < NUMBER_OF_RESOURCES; r++) 
	{
		available[r] = available[r] + release[r];
		allocation[c][r] = allocation[c][r] - release[r];
		need[c][r] = maximum[c][r] - allocation[c][r];
	}
	printf("\n");
	return 0;
}

int main(int argc, char *argv[])
{
	char str[BUFSIZE];	// Input buffer
	char *pch;		// This is for use by strtok
	int custnum;		// This is for holding the customer number
	char reqresp;  		// This is for holding the + or the -
	int i;			// Loop variable
	int rarray[NUMBER_OF_RESOURCES];  // For requests or releases

	/* Initialize resource arrays */
	initialize_resource_arrays(argv);

	/* Parse input and call appropriate function */
	while (fgets(str, BUFSIZE, stdin))
	{
		pch = strtok (str," ");
		custnum = atoi(pch);
		pch = strtok (NULL," ");
		reqresp=*pch;
		printf("%d %c ", custnum, reqresp);
		for (i=0; i<NUMBER_OF_RESOURCES; ++i)
		{
			rarray[i]=atoi(strtok (NULL, " "));
			printf("%d ", rarray[i]);
		}
			
		if (reqresp == '+')
			request_resources(custnum, rarray);
		else
			release_resources(custnum, rarray);

	}
}
