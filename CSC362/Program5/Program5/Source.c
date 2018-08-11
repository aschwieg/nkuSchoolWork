//Alex Schwiegeraht
//CSC 362, 001, Programming assignment 5, 4/6/18

//The program takes an array and puts it into a sorted order. It uses insertion sort to achieve this.
//A for loop checks every element in an array if the element after it is larger than it. If it is larger, then 
//it swaps the two elements and checks if the element after its new location is larger. It does this until the element after is not larger.
//The for loop then increments and checks the next element in the array until it has reached the length of the array. The program then prints out the sorted array.

#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

void main()
{
	int a[] = {123456, 342100, 87539, 606006, 443322, 198371, 99109, 88018, 707007}; //Array for Run #2
	int n = 9, temp, location, i; //n is the number of ints in the array, temp holds an the int while it is being sorted, location is used for traversing the array, and i is used for a for loop during output

	__asm {		
				mov		ecx, n //moves n(length) into the counter 
				mov		ebx, 0 //sets the ebx to start at 0, ebx will be used to go through each array element to check if its sorted
				mov		eax, a[ebx] //the first array element is loaded into the eax
	forloop:	mov		temp, eax //the element that was at ebx in the array is put in temp
				mov		eax, ebx 
				sub		eax, 4	//eax is 4 less than than ebx so that it can represent the element previous in the array
				mov		location, eax //the eax is stored in location
	whileloop:	cmp		eax, 0 //compares eax(location) to 0
				jl		next //if the location is less than 0 (out of the array) then it jumps out of the whileloop
				mov		edx, a[eax] //the value at location in the array is put into edx
				mov		eax, temp	
				cmp		edx, eax //temp is compared to the value at location in the array
				mov		eax, location
				jle		next //if the value is less than or equal to temp then it jumps out of the whileloop
				mov		a[eax + 4], edx //the value at the postion after location is set to the value at location
				sub		eax, 4	//location is decreased by one position in the array
				mov		location, eax //location is stored
				jmp		whileloop //loops until one of the two jump conditions are met
	next:		mov		edx, temp
				mov		a[eax + 4], edx //the value at the postion after location is set to the value in temp
				add		ebx, 4 //the ebx is moved to the next postion in the array
				mov		eax, a[ebx] //eax becomes the value at ebx
				loop	forloop //loops for the length of the array
	}


	//Output of Array
	printf("Run #2:\n");
	for (i = 0; i < n; i++) //iterates through array
	{
		printf("%d, ", a[i]); //prints the int at each array location
	}
	scanf("%d", &i);
}