/*
  File Name: IComparable.h
  Author: Alex Schwiegeraht
  Course: CSC 402
  Date: 11/1/2018
*/


class IComparable
{
public:

	// the key to being "comparable" is this pure virtual function
	virtual int compare(const IComparable& icmp) const = 0;

	// Using the compare function, implement the == operator in the base class
	virtual bool operator==  (const IComparable& rhs) const {
		return (compare(rhs) == 0);
	}

	// (<, >, !=, <=, and >=)  similarly within the IComparable class
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

	// Given the pure virtual funcion below, you will need two operator= 
	// member functions in each concrete derived class--one that 
	// provides an implementation with this exact signature and one that provides a 
	// concrete implementation for derived classes with a signature such as: 
	// const Integer& operator= (const Integer& rhs) 
	virtual const IComparable& operator= (const IComparable & rhs) = 0;


	// TODO:  Implement a 'proper' destructor for an abstract class

};

class Integer : public IComparable
{
public:

	// default and single-arg constructor is trivial 
	Integer(const int i = 0) : value{ i } { }

	// copy constructor for stack-based Integers is trivial and 
	// actually may be left out if you prefer.
	// Test it with the compiler-generated default to see if you need it.
	Integer(const Integer& rhs) : value{ rhs.value } { }


	// copy assignment operator for stack-based Integers
	const Integer& operator= (const Integer& rhs) {  /* TODO */
	}


	// copy constructor for IComparable references
	// Note the strange syntax 
	Integer(const IComparable& rhs)
		: value{ dynamic_cast<const Integer&>(rhs).value } {   }

	// copy assignment operator for IComparable references
	const IComparable& operator= (const IComparable& rhs) { /* TODO */
	}

	// As per the contract, compare must accept an IComparable reference 
	// return -1 if this object < icmp, 0 if this ojbect == icmp, 1 if icmp > 
	// this object (see hints below)
	int compare(const IComparable& rhs) const {
		if (value < dynamic_cast<const Integer&>(rhs).value)
			return -1;
		else if (value > dynamic_cast<const Integer&>(rhs).value)
			return 1;
		else
			return 0;
	}

	// print is likewise trivial
	void print(ostream& out = cout) const { out << value; }

private:
	int value;
};

class Double : public IComparable
{
public:

	Double(const double i = 0) : value{ i } { }

	Double(const Double& rhs) : value{ rhs.value } { }

	const Double& operator= (const Double& rhs) {  /* TODO */
	}

	Double(const IComparable& rhs)
		: value{ dynamic_cast<const Double&>(rhs).value } {   }

	const IComparable& operator= (const IComparable& rhs) { /* TODO */
	}

	int compare(const IComparable& rhs) const {
		if (value < dynamic_cast<const Double&>(rhs).value)
			return -1;
		else if (value > dynamic_cast<const Double&>(rhs).value)
			return 1;
		else
			return 0;
	}

	void print(ostream& out = cout) const { out << value; }

private:
	double value;
};

class Character : public IComparable
{
public:

	Character(const char i = " ") : value{ i } { }

	Character(const Character& rhs) : value{ rhs.value } { }

	const Character& operator= (const Character& rhs) {  /* TODO */
	}

	Character(const IComparable& rhs)
		: value{ dynamic_cast<const Character&>(rhs).value } {   }

	const IComparable& operator= (const IComparable& rhs) { /* TODO */
	}

	int compare(const IComparable& rhs) const {
		if (value < dynamic_cast<const Character&>(rhs).value)
			return -1;
		else if (value > dynamic_cast<const Character&>(rhs).value)
			return 1;
		else
			return 0;
	}

	void print(ostream& out = cout) const { out << value; }

private:
	char value;
};
