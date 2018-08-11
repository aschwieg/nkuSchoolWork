//Alex Schwiegeraht
//CSC 362, 001, Programming assignment 4, 4/6/18

//The program finds how close a number is to being a perfect number. The user is prompted to enter a interger. 
//The factors of that integer, called input, are found and then summed up. The summation is then subtracted by the input. 
//The program then finds the absolute value of that difference and divides it by the input. The quotient is how close the input is to being a perfect number. 
//The input, summation of factors, and percentage is displayed before the user is prompted to input a new integer. 
//The program ends when the user enters an integer less than or equal to 1.


#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

void main() 
{
	int sum, input, percent;//sum is used for sum of factors, input is used for the user's input, and percent is the closeness of the input to being a perfect number

	printf("Enter an input: ");//prompts user for input
	scanf("%d",&input);//recieves integer and sets it to input

	while (input > 1) {//loops until user inputs 1 or less
				//enter assembler
		__asm {		
					mov		sum, 0 //initializes sum to 0
					mov		ebx, 1 //sets ebx to 1 to be used for division
					mov		ecx, input //sets ecx to be input
			top:	mov		eax, input //sets eax to input each loop
					inc		ebx	//increments the ebx
					div		ebx //divides the input by the ebx
					cmp		edx, 0 //checks for a remainder equal to 0
					jg		xelse //jumps to the xelse if remainder is greater than 0
					add		sum,eax //if the remainder is 0 then the quotient is a factor and added to the sum
			xelse:	mov		edx, 0 //reset edx to 0
					loop	top //jumps to top while ecx is greater than 0
					mov		eax, sum //set eax to the sum
					sub		eax, input //subtracts the input from the sum
					cmp		eax,0 //checks to see if the difference is greater than 0
					jge		yelse //jumps to yelse if the difference is greater than 0
					NEG		eax //negates the difference if its less than zero
			yelse:	mov		ebx,100 //sets ebx to 100
					mul		ebx //multiplys the difference by 100
					mov		ebx,input //sets ebx to the input
					div		ebx	//divides the difference by the input
					mov		edx, 0 //resets the edx to 0
					mov		percent,eax //stores the new difference in perecent
		}
		printf("Input: %d\nSum of Factors: %d\nPercentage: %d%%\n\nEnter next input: ", input, sum, percent); //prints the results and prompts user for new input
		scanf("%d", &input); //recieves integer and sets it to input
	}


}