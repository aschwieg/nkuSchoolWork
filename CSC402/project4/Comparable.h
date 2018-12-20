/*
File Name: Comparable.h
Author: Alex Schwiegeraht
Course/Project: CSC 402 Project 4
Date: 11/13/2018
*/
#include <iostream>
#include <string>
using namespace std;

template <typename T>
class Comparable
{

	/* Assumptions:
	1) T is a primitive or a class for which the six basic relational operators have been implemented.
	2) The << operator is compatible with variables of type T as the right-hand operand. (See the print() function.)
	3) T itself has a default (no-arg) constructor, which includes C++ built-in primitive types.
	4) One T can be assigned to another; thus, if T is a class, it implements operator=, or one can just say that T adheres to primitive copy semantics.
	*/

public:


	/* TODO: Provide a combination default and single-arg constructor
	   that assumes that T has a default constructor.
	   The signature would expect a const T reference, but you have to
	   figure out how to default-construct an object of type T
   */

	Comparable(const T& initValue = T())
		: value(initValue)
	{}

	const Comparable<T>& operator= (const T& rhs) {
		value = rhs;
		return *this;
	}

	Comparable(const Comparable<T>& rhs)
		: value{ rhs.value } 
	{}


	// TODO: Implement the relational operators <, >, ==, !=, <=, and >= without using any other member function
	bool operator==  (const Comparable<T>& rhs) const {
		return (value == rhs.value);
	}

	bool operator< (const Comparable<T> &rhs) const {
		return (value < rhs.value);
	}

	bool operator> (const Comparable<T> & rhs) const {
		return (value > rhs.value);
	}

	bool operator!= (const Comparable<T> & rhs) const {
		return (value != rhs.value);
	}

	bool operator<= (const Comparable<T> & rhs) const {
		return (value <= rhs.value);
	}

	bool operator>= (const Comparable<T> & rhs) const {
		return (value >= rhs.value);
	}
	// print is again used to assist with the external << operator
	void print(ostream& out = cout) const
	{
		out << value;
	}

	~Comparable() {};

private:
	T value;
};

template <typename T>
ostream& operator<<(ostream& out, const Comparable<T>& i)
{
	i.print(out);
	return out;
}