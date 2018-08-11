//Alex Schwiegeraht
//CSC 362, 001, Programming assignment 3, 3/14/18

//This program uses pointers to simulate a race between a tortiose and a hare along a predefined path.
//Each animal "moves" on the path as a turn until one of them reaches the end of the path.
//Each turn the path is printed with the animal's location on it as well as certian events that can happen each turn.

#define _CRT_SECURE_NO_WARNINGS
#define MAX 60
#include <stdio.h>
#include <time.h>
#include <stdlib.h>

char *moveTort(char *, char *, int *); //Moves the tortiose a random amount and checks if it collided with the hare
char *moveHare(char *, char *, int *, int *);//Moves the hare a random amount with conditions as well if it napped or collided with the tortiose
void printPath(char *, char *, char *, int, int *, int *);//Prints the turn number, the path with the location of the hare and tortiose, and any event that occurred

void main() 
{

	int turn = 0, collision = 0, nap = 0; //Creates a turn counter, a collision flag, and a nap flag
	char path[] = " R  R  R  SSSSS   R  R CCCC  R   R   CCCCCCCCCC  R  SSSS  R ";//Creates path for the race using an array of chars
	char *hare = path, *tort = path; //Creates two pointers to represent each animal
	srand(time(NULL)); //Generates seed for random numbers

	while (hare < path + MAX && tort < path + MAX)//Loops until there is a winner
	{
		if (tort < path + MAX)//Checks to make sure the tortoise doesn't attempt to move after exceding the path
		{
			tort = moveTort(tort, hare, &collision);//Moves the tortoise
		}
		if (hare < path + MAX)//Checks to make sure the hare doesn't attempt to move after exceding the path
		{
			hare = moveHare(tort, hare, &collision, &nap);//Moves the hare
		}
		turn++;//Records that a turn occurred
		printPath(tort, hare, path, turn, &collision, &nap);//Prints the standings of the race at each turn as well as any events that may have occurred
	}

	//Statement checks which animal has won
	//If they both excede the array when the while loop exits then their distance is compared to decide a winner. Otherwise the winner will always be the furthest when the while loop exits.
	if (hare > tort)
	{
		printf("Hare Wins\n");
	}
	else
	{
		printf("Tortoise Wins\n");
	}
	system("PAUSE");
}

//Moves the tortiose to a new postition in the array and returns it
char *moveTort(char *tort, char *hare, int *collisionCheck)
{
	int move = (rand() % 3) + 1;//Generates a number between 1 and 3 to move the tortiose.
	tort = tort + move;//The tortiose pointer is raised by the move amount for its new position in the array

	//Checks if a collision has occurred
	if (tort == hare)
	{
		*collisionCheck = 1;//Sets a flag that a collision has occurred
		tort--;//Moves the tortiose back one position in the array
	}
	//Returns the tortiose's new location in the array
	return tort;
}

//Moves the hare to a new position in the array and returns it
char *moveHare(char *tort, char *hare, int *collisionCheck, int *nap)
{
	int napCheck = (rand() % 3) + 1;//Generates a random number between 1 and 3 to be used to check if the hare sleeps
	int move = (rand() % 8) + 1;//Generates a random number between 1 and 8 to move the hare in the array
	//Checks if the hare takes a nap for the turn
	if (napCheck > 1) 
	{
		//Checks if the hare is on a carrot
		if (*hare == 'C')
		{
			*hare = ' ';//The hare "eats" the carrot by changing the carrots location in the array to a blank space.
			return hare;//The hare does not move so it returns its current position
		}

		hare = hare + move;//The hare moves to a new position in the array
		//Checks if a collision occurs 
		if (hare == tort)
		{
			*collisionCheck = 1;//Sets a flag that a collision has occurred
			hare--;//Moves the hare back one position in the array
		}
		//Checks to see if the hare is on a rock
		if (*hare == 'R')
		{
			hare--;//Moves the hare back one position in the array
		}
		//Checks to see if the hare is in a stream
		if (*hare == 'S')
		{
			while (*hare == 'S')//If the hare is still on a stream then it is moved back
			{
				hare--;
			}
		}
		//Checks to see if a collision has occurred after the hare may have been moved
		if (hare == tort)
		{
			*collisionCheck = 1;
			hare--;
		}
		//Returns the hare's new location in the array
		return hare;
	}
	else
	{
		*nap = 1;//Flags that a nap has occurred
		return hare;//Since the hare napped, it did not move so its current position is returned
	}
	
}
//Prints out the path with the location of the hare and tortiose as well as any events that may have occurred
void printPath(char *tort, char *hare, char *path, int turn, int *collision, int *nap)
{
	char *i = path;//Creates a pointer at the beginning of the array
	printf("Turn\t%d:\t", turn);//Prints the current Turn
	while (*i != '\0')//loops over every char until the end of the array is reached
	{
		//Checks to see if the current char is where the tortiose is located
		if (i == tort)
		{
			printf("T");//Prints T at the location of the tortiose
			i++;//Iterates the pointer
		}
		//Checks to see if the current char is where the hare is located
		else if (i == hare)
		{
			printf("H");//Prints H at the location of the hare
			i++;//Iterates the pointer
		}
		else
		{
			printf("%c",*i);//Prints the current char at its location on the path
			i++;//Iterates the pointer
		}
	}
	//If the a collision has been flagged then it is printed and then reset
	if (*collision == 1) 
	{
		printf("\t-Collision-");
		*collision = 0;
	}
	//If the a hare napping has been flagged then it is printed and then reset
	if (*nap == 1)
	{
		printf("\t-Hare Napping-");
		*nap = 0;
	}
	printf("\n");
}