// Alex Schwiegeraht
// 11/13/2018

#include <stdio.h>
#include <stdlib.h>

/* The maximum possible value for argv[1] (aka frames) */
#define MAX_FRAMES 32

int fifo_faults(int frames, int prs[], int len)
{
	int faults = 0, lc = 0, i, j;
	int pt[frames];
	int inTable;
	for(i = 0; i < frames; i++)
		pt[i] = -1;

	for (i = 0; i < len; i++)
	{
		inTable = 0;
		for (j = 0; j < frames; j++)
		{
			//check if it is in the page table
			if (pt[j] == prs[i])
				inTable = 1;
		}

		if (inTable == 0) {
			pt[lc] = prs[i];
			faults++;
			lc = (lc + 1) % frames;
		}
	}
	return faults;
}

int lru_faults(int frames, int prs[], int len)
{
	int faults = 0, i, j, leastRecentlyUsed = 0;
	int pt[frames];
	int ptTimers[frames];
	int inTable;
	for(i = 0; i < frames; i++)
	{
		pt[i] = -1;
		ptTimers[i] = 0;
	}
	

	for (i = 0; i < len; i++)
	{
		inTable = 0;
		for (j = 0; j < frames; j++)
		{
			//check if it is in the page table
			if (pt[j] == prs[i]) {
				inTable = 1;
				ptTimers[j] = 0;
			}			
		}

		if (inTable == 0) {
			for (j = 0; j < frames; j++) 
			{
				if (ptTimers[leastRecentlyUsed] < ptTimers[j]) {
					leastRecentlyUsed = j;
				}
			}
			ptTimers[leastRecentlyUsed] = 0;
			pt[leastRecentlyUsed] = prs[i];
			faults++;
		}
		
		for (j = 0; j < frames; j++)
			ptTimers[j] = ptTimers[j] + 1;
	}
	return faults;
}

int opt_faults(int frames, int prs[], int len)
{
	int faults = 0, i, j, k, furthest, chosen;
	int pt[frames];
	int inTable;

	for(i = 0; i < frames; i++)
		pt[i] = -1;

	for (i = 0; i < len; i++)
	{
		inTable = 0;
		for (j = 0; j < frames; j++)
		{
			if (pt[j] == prs[i])
				inTable = 1;
		}

		if (inTable == 0) {
			furthest = 0;
			chosen = 0;
			for (j = 0; j < frames; j++)
			{
				k = i + 1;
				while ( k < len && prs[k] != pt[j])
				{
					k++;
				}
				if (k > furthest) {
					furthest = k;
					chosen = j;
				}
			}

			pt[chosen] = prs[i];
			faults++;
		}
	}
	
	return faults;
}

int main(int argc, char *argv[])
{
	int i; /* Loop counter */
	int *prs; /* This will hold the page reference string. (*prs and prs[] are the same thing) */
	int frames;  /* Int variable to hold first argument */
	int len=argc-2;

	/* Error check on argc */
	if (argc<2)
	{
		printf("Usage: ./a.out frames page_reference_list\n");
		exit(1);
	}

	/* Error check on argv[1] (aka frames) */
	frames = atoi(argv[1]);
	if (frames < 1 || frames > MAX_FRAMES)
	{
		printf("Usage: ./a.out frames page_reference_list\n");
		printf("       frames must be an integer between 1 and %d\n", MAX_FRAMES);
		exit(1);
	}
	
	/* Convert page_referenced_list into an array of ints */
	prs = malloc(sizeof(int)*(len));
	for (i=0; i<len; ++i) *(prs+(i))=atoi(argv[i+2]);

	/* Test the three functions */
	printf("FIFO faults: %d\n", fifo_faults(frames, prs, len));
	printf("LRU faults: %d\n", lru_faults(frames, prs, len));
	printf("OPT faults: %d\n", opt_faults(frames, prs, len));
}
