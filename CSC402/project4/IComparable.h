/*
  File Name: IComparable.h
  Author: Alex Schwiegeraht
  Course: CSC 402
  Date: 11/1/2018
*/
#include <iostream>
#include <string>
using namespace std;


class IComparable
{
public:

	// the key to being "comparable" is this pure virtual function
	virtual int compare(const IComparable& icmp) const = 0;

	// Overloads for ==, <, >, !=, <=, and >=
	virtual bool operator==  (const IComparable& rhs) const {
		return (compare(rhs) == 0);
	}

	virtual bool operator< (const IComparable & rhs) const {
		return (compare(rhs) < 0);
	}

	virtual bool operator> (const IComparable & rhs) const {
		return (compare(rhs) > 0);
	}

	virtual bool operator!= (const IComparable & rhs) const {
		return (compare(rhs) != 0);
	}

	virtual bool operator<= (const IComparable & rhs) const {
		return (compare(rhs) <= 0);
	}

	virtual bool operator>= (const IComparable & rhs) const {
		return (compare(rhs) >= 0);
	}

	// Accessor to facilitate implementation of the << operator; also pure virtual
	virtual void print(ostream & out = cout) const = 0;

	// Pure virtual copy assignment
	virtual const IComparable& operator= (const IComparable & rhs) = 0;


	// Destructor
	virtual ~IComparable() {};
};

class Integer : public IComparable
{
public:

	// constructor
	Integer(const int i = 0) : value{ i } { }

	// copy constructor for stack-based Integers 
	Integer(const Integer& rhs) : value{ rhs.value } { }

	// copy assignment operator for stack-based Integers
	const Integer& operator= (const Integer& rhs) {  /* TODO */
		value = rhs.value;
		return *this;
	}

	// copy constructor for IComparable references
	Integer(const IComparable& rhs)
		: value{ dynamic_cast<const Integer&>(rhs).value } {   }

	// copy assignment operator for IComparable references
	const IComparable& operator= (const IComparable& rhs) {
		value = dynamic_cast<const Integer&>(rhs).value;
		return *this;
	}

	// Takes an IComparable object, casts it, and returns values depending the object compared to this
	int compare(const IComparable& rhs) const {
		if (value < dynamic_cast<const Integer&>(rhs).value)
			return -1;
		else if (value > dynamic_cast<const Integer&>(rhs).value)
			return 1;
		else
			return 0;
	}

	// Accessor to facilitate implementation of the << operator
	void print(ostream& out = cout) const { out << value; }

	// Destructor
	~Integer() {};

private:
	int value;
};

class Double : public IComparable
{
public:

	// constructor
	Double(const double i = 1.1) : value{ i } { }

	// copy constructor for stack-based Doubles 
	Double(const Double& rhs) : value{ rhs.value } { }

	// copy assignment operator for stack-based Doubles
	const Double& operator= (const Double& rhs) {
		value = rhs.value;
		return *this;
	}

	// copy constructor for IComparable references
	Double(const IComparable& rhs)
		: value{ dynamic_cast<const Double&>(rhs).value } {   }

	// copy assignment operator for IComparable references
	const IComparable& operator= (const IComparable& rhs) {
		value = dynamic_cast<const Double&>(rhs).value;
		return *this;
	}

	// Takes an IComparable object, casts it, and returns values depending the object compared to this
	int compare(const IComparable& rhs) const {
		if (value < dynamic_cast<const Double&>(rhs).value)
			return -1;
		else if (value > dynamic_cast<const Double&>(rhs).value)
			return 1;
		else
			return 0;
	}

	// Accessor to facilitate implementation of the << operator
	void print(ostream& out = cout) const { out << value; }

	// Destructor
	~Double() {};

private:
	double value;
};

class Character : public IComparable
{
public:

	// constructor
	Character(const char i = '?') : value{ i } { }

	// copy constructor for stack-based characters
	Character(const Character& rhs) : value{ rhs.value } { }

	// copy assignment operator for stack-based characters
	const Character& operator= (const Character& rhs) {
		value = rhs.value;
		return *this;
	}

	// copy constructor for IComparable references
	Character(const IComparable& rhs)
		: value{ dynamic_cast<const Character&>(rhs).value } {   }

	// copy assignment operator for IComparable references
	const IComparable& operator= (const IComparable& rhs) {
		value = dynamic_cast<const Character&>(rhs).value;
		return *this;
	}

	// Takes an IComparable object, casts it, and returns values depending the object compared to this
	int compare(const IComparable& rhs) const {
		if (value < dynamic_cast<const Character&>(rhs).value)
			return -1;
		else if (value > dynamic_cast<const Character&>(rhs).value)
			return 1;
		else
			return 0;
	}

	// Accessor to facilitate implementation of the << operator
	void print(ostream& out = cout) const { out << value; }

	// Destructor
	~Character() {};

private:
	char value;
};

// << overload
ostream& operator<<(ostream &out, const IComparable & value)
{
	value.print(out);
	return out;
}