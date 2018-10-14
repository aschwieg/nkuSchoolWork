/*
  File Name: TestDynamicStack.cpp
  Author: Alex Schwiegeraht
  Course: CSC 402 (502 for MSCS stud1ents)
  date: 10/12/2018
*/

#include "DynamicStack.h"

int main() 
{
	DynamicStack d1(20);
	double arr[20] = { 0, 1, 1, 2, 3, 5, 8, 13, 21, 34 };

	for (int i = 1; i < 10; i++)
		d1.push(i*3.14);

	cout << "d1: " << d1 << endl;
	cout << "d1.peek(): " << d1.peek() << endl;
	cout << "d1.pop(): " << d1.pop() << endl;
	cout << "d1 after pop(): " << d1 << endl;
	cout << "d1[5]: " << d1[5] << endl;
	cout << "d1's capacity: " << d1.capacity() << endl;
	cout << "d1's size: " << d1.size() << endl;
	d1.clear();
	cout << "d1 is empty?: " << d1.empty() << endl << endl;

	DynamicStack d2(arr,10);
	cout << "d2: " << d2 << endl;
	cout << "d2.peek(): " << d2.peek() << endl;
	cout << "d2.pop(): " << d2.pop() << endl;
	cout << "d2 after pop(): " << d2 << endl;
	cout << "d2[5]: " << d2[5] << endl;
	cout << "d2's capacity: " << d2.capacity() << endl;
	cout << "d2's size: " << d2.size() << endl;
	d2.clear();
	cout << "d2 is empty?: " << d2.empty() << endl << endl;

	cout << "Testing Copy and move operations" << endl;

	DynamicStack d3(20);
	for (int i = 1; i < 10; i++)
		d3.push(i*3.14);
	DynamicStack d4(arr, 10);
	cout << "d3: " << d3 << endl << "d4: " << d4 << endl;
	d3 = d4;
	cout << "d3 after copying d4: " << d3 << endl;
	cout << "d4 after copying to d3: " << d4 << endl << endl;

	DynamicStack d5(20);
	for (int i = 1; i < 10; i++)
		d5.push(i*3.14);
	DynamicStack d6(arr, 10);
	cout << "d5: " << d5 << endl << "d6: " << d6 << endl;
	d5 = move(d6);
	cout << "d5 after moving d6: " << d5 << endl;
	cout << "d6 after moving to d5: " << d6 << endl << endl;

	//system("PAUSE");
}