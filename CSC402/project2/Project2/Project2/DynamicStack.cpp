/*
  File Name: DynamicStack.cpp
  Author: Alex Schwiegeraht
  Course: CSC 402 (502 for MSCS students)
  Date: 10/12/2018
*/

#include "DynamicStack.h"

DynamicStack::DynamicStack( double oldArray[], int length) 
	: stackCapacity { length }, stackSize { length }
	{
		stack = new double[length] {0};

		for (int i = 0; i < stackSize; i++) {
			stack[i] = oldArray[i];
		}
};

DynamicStack::DynamicStack(int c = 10)
	: stackCapacity{ c }
	{ 
		stackSize = 0;
		if (stackCapacity > 0) {
			stack = new double[stackCapacity] {0};
		}
		
};

DynamicStack::DynamicStack(const DynamicStack &ds)
	: stackCapacity{ ds.stackCapacity }, stackSize{ ds.stackSize }
	{
		if (this != &ds)
		{
			stack = new double[stackCapacity] {0};

			for (int i = 0; i < stackSize; i++) {
				stack[i] = ds.stack[i];
			}
		}
};

DynamicStack::DynamicStack(DynamicStack &&ds)
	: stackCapacity{ ds.capacity() }, stackSize{ ds.size() }
	{
		if (this != &ds)
		{
			stack = new double[stackCapacity] {0};

			for (int i = 0; i < stackSize; i++) {
				stack[i] = ds.stack[i];
			}

			ds.clear();
		}
};

DynamicStack& DynamicStack::operator=(const DynamicStack &ds)
{
	if (this != &ds)
	{
		stackCapacity = ds.stackCapacity;
		stackSize = ds.stackSize;
		stack = new double[stackCapacity] {0};

		for (int i = 0; i < stackSize; i++) {
			stack[i] = ds.stack[i];
		}
	}
	return *this;
};

DynamicStack& DynamicStack::operator=(DynamicStack &&ds)
{
	if (this != &ds)
	{
		stackCapacity = ds.capacity();
		stackSize = ds.size();
		stack = new double[stackCapacity] {0};

		for (int i = 0; i < stackSize; i++) {
			stack[i] = ds.stack[i];
		}

		ds.clear();
	}

	return *this;
};

double DynamicStack::operator[](int n) const throw (out_of_range)
{
	if (stackSize == 0)
		throw out_of_range("Too small");
	else if(n < 0) 
		throw out_of_range("Too small"); 
	else if( n > stackSize)
		throw out_of_range("Too large");
	else 
		return stack[n];
}

DynamicStack::~DynamicStack()
{
	delete stack;
};

double DynamicStack::peek() const { return stack[stackSize - 1]; };

bool DynamicStack::empty() const
{
	if (stack[0] == 0) {
		return true;
	}
	else {
		return false;
	}
}

void DynamicStack::push(double n)
{
	if (stackSize == stackCapacity) {
		if (stackCapacity > 0) {
			double *temp = new double[stackCapacity] {0};

			for (int i = 0; i < stackSize; i++) {
				temp[i] = stack[i];
			}

			stackCapacity = (int)(1 + (1.5*stackCapacity));
			stack = new double[stackCapacity] { 0 };

			for (int i = 0; i < stackSize; i++) {
				stack[i] = temp[i];
			}

			delete temp;
		}
		else {
			stackCapacity = (int)(1 + (1.5*stackCapacity));
			stack = new double[stackCapacity] { 0 };
		}
	}

	stack[stackSize] = n;
	stackSize++;
}

double DynamicStack::pop()
{
	if (this->empty()) {
		return 0;
	}
	else {
		double temp = stack[stackSize - 1];
		stack[stackSize - 1] = 0;
		stackSize--;
		return temp;
	}
	
}

void DynamicStack::clear()
{
	delete stack;
	stack = new double[10]{ 0 };
	stackSize = 0;
	stackCapacity = 10;
}

void DynamicStack::print(ostream & out) const
{
	for (int i = 0; i < stackSize; i++) {
		out << stack[i] << " ";
	}
	
}

ostream& operator<<(ostream &out, const DynamicStack & value)
{
	value.print(out);
	return out;
}
