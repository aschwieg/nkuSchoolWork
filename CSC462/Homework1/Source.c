#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h> 

double solve(double, double);

void main()
{
	double k, f, solution;

	f = .2;
	k = 2;
	printf("\n---------------- F increasing by .1 ------------------------\n");
	while (f <= .9) {
		solution = solve(k, f);
		printf("F:%.2f = %.2f\n", f, solution);
		f += .1;
	}

	f = .4;
	k = 7;
	printf("\n---------------- K increasing by 2 ------------------------\n");
	while (k <= 21) {
		solution = solve(k, f);
		printf("K:%.2f = %.2f\n", k, solution);
		k += 2;
	}

	f = .75;
	k = 1.4;
	printf("\n---------------- K increasing by .2 ------------------------\n");
	while (k <= 3) {
		solution = solve(k, f);
		printf("K:%.2f = %.2f\n", k,solution);
		k += .2;
	}


	scanf("%f",k);
}

double solve(double k, double f) {
	return 1 / (1 - f + (f / k));
}