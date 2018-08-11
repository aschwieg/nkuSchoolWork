//Alex Schwiegeraht
//CSC 362, 001, Programming assignment 1, 1/26/18

//Takes a file provided by the user to that is then gone through
//char by char and put into a file labeled "output.txt" based on certian
//conditions. Those conditions are that for a char to outputed, it must go
//in the pattern of uppercase char then the next char that is lower case then
//the next char that is uppercase and so on. Pattern resets at the beginning of each sentence
//by first looking for the first uppercase char. A list of stats is then displayed about the file.


#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <ctype.h>

void main()
{
	int inputChars = 0, outputChars = 0;						//Creates two ints that count the total Chars inputs and outpus
	float percentOutput = 0;									//Float that later calculates the ratio of inputed chars to outputed chars
	char filename[30]; 											//Creates a string to store the file name 
	char currentChar, prevCharCase = '.';						//Creates a char to hold the current Char in the file and a char that is used to identify what is next needed next to output

	FILE *fp1, *fp2;											//Creates to files

	printf("Enter the filename to be scanned:  ");				//Gets the user's choice of file
	scanf("%s",filename);

	fp1 = fopen(filename, "r");									//Sets the user's chosen file to be read from
	fp2 = fopen("output.txt", "w");								//Sets an output file to write into

	while ((currentChar = getc(fp1)) != EOF)					//loop that goes through the user's file and sets the currentChar to the next char in the file
	{
		inputChars++;											//Adds one to the total inputed chars
		if (prevCharCase == '.')								//Checks if the last input was the end of a sentence and finds first char of the new sentence
		{
			if (isupper(currentChar) != 0 && prevCharCase == '.')	//Checks if the current char is the first upper case in a new sentence
			{
				prevCharCase = currentChar;						//Sets the previous char case to the case of the current char to be compared later
				outputChars++;									//Adds one to the total outputed chars 
				putc(currentChar, fp2);							//puts the char in the output file
			}
			else if (currentChar == ' ' || currentChar == '\n' || currentChar == ',')	//checks if the current char is a special character that doesn't affect the case 
			{
				outputChars++;
				putc(currentChar, fp2);
			}
		}
		else {																			//moves to next checks after finding the start of a new sentence
			if (currentChar == ' ' || currentChar == '\n' || currentChar == ',')		//checks if the current char is a special character that doesn't affect the case
			{
				outputChars++;	
				putc(currentChar, fp2);
			}
			else if (currentChar == '.')												//checks if the current char is the end of a sentence
			{
				outputChars++;
				putc(currentChar, fp2);
				prevCharCase = currentChar;
			}
			else if (isupper(currentChar) != 0 && isupper(prevCharCase) == 0)			//checks if current char is upper cased and if the next char should be upper case
			{
				outputChars++;
				prevCharCase = currentChar;
				putc(tolower(currentChar), fp2);
			}
			else if (islower(currentChar) != 0 && islower(prevCharCase) == 0)			//checks if current char is lower cased and if the next char should be lower case
			{
				outputChars++;
				prevCharCase = currentChar;
				putc(currentChar, fp2);
			}
			
		}
		
	}

	fclose(fp1);											//closes both files
	fclose(fp2);

	percentOutput = (float) outputChars/inputChars*100;		//calculates the ratio of input to output chars to be displayed in precent

	//displays information about the program
	printf("\nInput file: %s\nOutput file: Output.txt\nNumber of input characters: %d\nNumber of output characters: %d\nPercent reduction in output: %.2f%%\n", filename, inputChars, outputChars, percentOutput);

	system("PAUSE");
}