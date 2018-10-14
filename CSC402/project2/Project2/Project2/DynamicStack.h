/*
  File Name: DynamicStack.h
  Author: Alex Schwiegeraht
  Course: CSC 402 (502 for MSCS students)
  Date: 10/12/2018
*/
#include <iostream>
#include <string>
using namespace std;

#pragma once
class DynamicStack 
{
private:
	int stackCapacity, stackSize;
	double *stack;

public:
	DynamicStack(double[], int);

	explicit DynamicStack(int);

	DynamicStack(const DynamicStack&);

	DynamicStack(DynamicStack&&);

	DynamicStack& operator=(const DynamicStack&);

	DynamicStack& operator=(DynamicStack&&);

	double operator[](int) const throw (out_of_range);

	~DynamicStack();

	int size() const { return stackSize; };

	int capacity() const { return stackCapacity; };

	bool empty() const;

	double peek() const;

	void push(double);

	double pop();

	void clear();

	void print(ostream & out) const;
};

ostream& operator<<(ostream&, const DynamicStack&);