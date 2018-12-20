#include <stdio.h>
#include <stdlib.h>

/* Assume no more than 1000 requests in the input file */
#define BUFSIZE 1000

/* Assume 5000 cylinders */
#define CYL 5000

/* Assume no requests will be longer than 80 characterse */
#define LINELEN 80

//Algorithm simply goes through the list measuring the distance between itself and the last request, then adding that to the total
int fcfs(int initpos, int requests[], int nmemb)
{
	int i, headMove;

	headMove = abs(requests[0] - initpos);
	for (i = 1; i < nmemb; i++)
	{
		headMove += abs(requests[i] - requests[i-1]);
	}
	return headMove;
}

//Algorithm finds the request with the shortest distance from the current position then goes to it
int sstf(int initpos, int requests[], int nmemb)
{
	int i, headMove = 0, smallIndex, prevSmallIndex, flag = 1, smallestDis, prevLocation;
	int fulfilled[nmemb];

	for (i = 0; i < nmemb; i++)
		fulfilled[i] = 0;

	prevSmallIndex = -1;
	prevLocation = initpos;

	//keeps going till all requests have been fulfilled
	while (flag)
	{
		smallestDis = CYL;
		smallIndex = 0;
		for (i = 0; i < nmemb; i++)
		{
			if (abs(prevLocation - requests[i]) < smallestDis && fulfilled[i] != 1) 
			{
				smallestDis = abs(prevLocation - requests[i]);
				smallIndex = i;
			}	
		}
		headMove += smallestDis;
		prevSmallIndex = smallIndex;
		prevLocation = requests[prevSmallIndex];
		if(prevSmallIndex != -1)
			fulfilled[prevSmallIndex] = 1;

		flag = 0;
		for (i = 0; i < nmemb; i++)
		{
			if(fulfilled[i] == 0)
				flag = 1;
		}
	}
		
	return headMove;
}

//Algorithm goes up and down the disk fulfilling requests as is to goes switching directions at each end
int scan(int initpos, int requests[], int nmemb)
{
	int i, j, headMove = -1, currentPos = initpos, direction = -1, flag = 1, nextReq, nextReqDis, nextReqIndex, requestFound = 0;
	int fulfilled[nmemb];

	for (i = 0; i < nmemb; i++)
		fulfilled[i] = 0;

	//keeps going till all requests have been fulfilled
	while (flag)
	{
		for (i = 0; i < nmemb; i++)
		{
			if (currentPos == requests[i] && fulfilled[i] == 0)
			{
				fulfilled[i] = 1;
				flag = 0;
				for (j = 0; j < nmemb; j++)
				{
					if(fulfilled[j] == 0)
						flag = 1;
				}
			} 
		}
		headMove++;
		currentPos += direction; 
		if (currentPos == 0 || currentPos == CYL)
			direction *= -1;
	}

	return headMove;
}

//Algorithm goes up the disk fulfilling requests as is to goes returning to the first position after reaching the end
int cscan(int initpos, int requests[], int nmemb)
{
	int i, j, headMove = -1, currentPos = initpos, flag = 1;
	int fulfilled[nmemb];

	for (i = 0; i < nmemb; i++)
		fulfilled[i] = 0;

	//keeps going till all requests have been fulfilled
	while (flag)
	{
		for (i = 0; i < nmemb; i++)
		{
			if (currentPos == requests[i] && fulfilled[i] == 0)
			{
				fulfilled[i] = 1;
				flag = 0;
				for (j = 0; j < nmemb; j++)
				{
					if(fulfilled[j] == 0)
						flag = 1;
				}
			} 
		}
		headMove++;
		currentPos++; 
		if (currentPos > CYL)
		{
			currentPos = 0;
			headMove += CYL - 1;
		}
	}

	return headMove;
}

//Algorithm goes up and down the disk fulfilling requests as is to goes switching directions at the earliest and latest requests
int look(int initpos, int requests[], int nmemb)
{
	int i, j, headMove = -1, currentPos = initpos, direction = -1, flag = 1, largest = 0, smallest = CYL;
	int fulfilled[nmemb];

	//finds the earliest and latest requests
	for (i = 0; i < nmemb; i++)
	{
		fulfilled[i] = 0;
		if (requests[i] < smallest)
			smallest = requests[i];
		else if (requests[i] > largest)
			largest = requests[i];
	}

	//keeps going till all requests have been fulfilled	
	while (flag)
	{
		for (i = 0; i < nmemb; i++)
		{
			if (currentPos == requests[i] && fulfilled[i] == 0)
			{
				fulfilled[i] = 1;
				flag = 0;
				for (j = 0; j < nmemb; j++)
				{
					if(fulfilled[j] == 0)
						flag = 1;
				}
			} 
		}
		headMove++;
		currentPos += direction; 
		if (currentPos == smallest || currentPos == largest)
		{
			for (i = 0; i < nmemb; i++)
			{
				if (requests[i] < smallest && fulfilled[i] == 0)
					smallest = requests[i];
				else if (requests[i] > largest && fulfilled[i] == 0)
					largest = requests[i];
			}
			direction *= -1;
		}
	}

	return headMove;
}

//Algorithm goes up the disk fulfilling requests as is to goes returning to the earliest request after reaching the latest request at the time
int clook(int initpos, int requests[], int nmemb)
{
	int i, j, headMove = -1, currentPos = initpos, flag = 1, smallest = CYL, largest = 0;
	int fulfilled[nmemb];

	//finds the earliest and latest requests
	for (i = 0; i < nmemb; i++)
	{
		fulfilled[i] = 0;
		if (requests[i] < smallest)
			smallest = requests[i];
		else if (requests[i] > largest)
			largest = requests[i];
	}

	//keeps going till all requests have been fulfilled
	while (flag)
	{
		for (i = 0; i < nmemb; i++)
		{
			if (currentPos == requests[i] && fulfilled[i] == 0)
			{
				fulfilled[i] = 1;
				flag = 0;
				for (j = 0; j < nmemb; j++)
				{
					if(fulfilled[j] == 0)
						flag = 1;
				}
			} 
		}
		headMove++;
		currentPos++; 
		if (currentPos > largest)
		{
			currentPos = smallest;
			headMove += largest - smallest - 1;
			for (i = 0; i < nmemb; i++)
			{
				if (requests[i] < smallest && fulfilled[i] == 0)
					smallest = requests[i];
				else if (requests[i] > largest && fulfilled[i] == 0)
					largest = requests[i];
			}
		}
	}

	return headMove;
}

main(int argc, char* argv[])
{
	char s[LINELEN];
	int requests[BUFSIZE];
	int count;
	int initpos;

	if (argc < 2)
	{
		printf("Usage: ./a.out initpos\n");
		exit(1);
	}

	initpos = atoi(argv[1]);

	count=0;
	while (fgets(s, LINELEN, stdin))
		requests[count++]=atoi(s);

	printf("FCFS: %d\n", fcfs(initpos, requests, count));
	printf("SSTF: %d\n", sstf(initpos, requests, count));
	printf("SCAN: %d\n", scan(initpos, requests, count));
	printf("C-SCAN: %d\n", cscan(initpos, requests, count));
	printf("LOOK: %d\n", look(initpos, requests, count));
	printf("C-LOOK: %d\n", clook(initpos, requests, count));

}
		
		
