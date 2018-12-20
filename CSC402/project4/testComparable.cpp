/*
File Name: testComparable.cpp
Author: Tim McCord
Course/Project: CSC 402/502 Project 4 Test Driver
Date: 01/01/1970
*/

#include <string>
#include <iostream>
#include <vector>
#include <ctime>
#include <algorithm>     
#include "Comparable.h"
#include "IComparable.h" 

#define SIZE 10

// Uncomment this preprocessor directive for the CSC 502 extra requirement  
#define CSC502

using namespace std;

// forward declarations
template <typename T> void print(const vector<T> & v);
template <typename T> bool isSorted(const vector<T> & v);
template <typename T> void sort(vector<T> & v);

int main()
{
	srand((unsigned int)(time(NULL)));
	const string SEPARATOR = "=========================================";

	// Note the use of boolalpha in the output stream. 
	// Once enabled, it stays on until noboolalpha appears
	cout << boolalpha;

	cout << endl << "Comparable<int> constructor, =, and << tests:" << endl << SEPARATOR << endl;

	Comparable<int> i0 = 10;

	// default and single-arg constructor tests
	Comparable<int> i1;

	// use print() directly if you need to verify construction prior to implementing operator<<
	cout << "i1 = ";
	i1.print();
	cout << endl;

	// using the operator<< is much more streamlined
	cout << "i1 = " << i1 << endl;

	Comparable<int> i2(10);
	cout << "i2 = " << i2 << endl;

	// Copy constructor
	Comparable<int> i3 = i2;
	cout << "i3 = " << i3 << endl;

	// = operator
	Comparable<int> i4;
	i4 = i3;
	cout << "i4 = " << i4 << endl;

	cout << endl << " Comparable<int> relational operator tests:" << endl << SEPARATOR << endl;
	//(i0 == i1) ? cout << "i0 == i1 is " << (i0 == i1) << endl : cout << "ERROR: i0 == i1 should be true" << endl;
	(i1 < i2) ? cout << "i1 <  i2 is " << (i1 < i2) << endl : cout << "ERROR: i1 <  i2 should be true" << endl;
	(i1 != i2) ? cout << "i1 != i2 is " << (i1 != i2) << endl : cout << "ERROR: i1 != i2 should be true" << endl;
	(i1 <= i2) ? cout << "i1 <= i2 is " << (i1 <= i2) << endl : cout << "ERROR: i1 <= i2 should be true" << endl;
	(i1 == i1) ? cout << "i1 == i1 is " << (i1 == i1) << endl : cout << "ERROR: i1 == i1 should be true" << endl;
	(i2 > i1) ? cout << "i2 >  i1 is " << (i2 > i1) << endl : cout << "ERROR: i2 >  i1 should be true" << endl;
	(i2 == i3) ? cout << "i2 == i3 is " << (i2 == i3) << endl : cout << "ERROR: i2 == i3 should be true" << endl;
	(i2 >= i1) ? cout << "i2 >= i1 is " << (i2 >= i1) << endl : cout << "ERROR: i2 >= i1 should be true" << endl;
	(i3 >= i3) ? cout << "i3 >= i3 is " << (i3 >= i3) << endl : cout << "ERROR: i3 >= i3 should be true" << endl;
	(i4 == i3) ? cout << "i4 == i3 is " << (i4 == i3) << endl : cout << "ERROR: i4 == i3 should be true" << endl;
	cout << endl;

	cout << endl << "Comparable<char> limited tests:" << endl << SEPARATOR << endl;
	Comparable<char> c0;  //default construction
	cout << "c0 = " << c0 << endl;   // char default construction yields '' 

	Comparable<char> c1{ 'a' };
	cout << "c1 = " << c1 << endl;
	Comparable<char> c2{ 'z' };
	cout << "c2 = " << c2 << endl;
	(c1 < c2) ? cout << "c1 < c2 = " << (c1 < c2) << endl : cout << "ERROR: c1 < c2 should be true" << endl;
	(c2 > c1) ? cout << "c2 > c1 = " << (c2 > c1) << endl : cout << "ERROR: c2 > c1 should be true" << endl;
	cout << endl;

	vector< Comparable<int> > intVector;
	// initialize vector of Comparable<int> objects
	for (unsigned int i = 0; i < SIZE; i++)
		intVector.push_back(Comparable<int>(rand()));

	cout << endl << "vector< Comparable<int> > tests:" << endl << SEPARATOR << endl;
	cout << endl << "intVector before sorting:" << endl;
	print(intVector);
	cout << "isSorted(intVector): " << isSorted(intVector) << endl;
	cout << endl << "Using local sort" << endl;
	sort(intVector);
	cout << endl << "intVector after sorting:" << endl;
	print(intVector);
	cout << "isSorted(intVector): " << isSorted(intVector) << endl;

#ifdef CSC502
	cout << "CSC502: Using std::sort" << endl;
	intVector.clear();
	for (unsigned int i = 0; i < SIZE; i++)
		intVector.push_back(Comparable<int>(rand()));

	std::sort(intVector.begin(), intVector.end());
	cout << endl << "intVector after std::sort:" << endl;
	print(intVector);
	cout << "isSorted(intVector): " << isSorted(intVector) << endl;
#endif

	cout << endl << "vector< Comparable<char> > tests:" << endl << SEPARATOR << endl;
	vector< Comparable<char> > charVector;
	// initialize with ASCII characters in the range 65 - 123 only
	for (int i = 0; i < SIZE; i++)
		charVector.push_back(Comparable<char>(rand() % 59 + 65));

	cout << endl << "charVector before sorting:" << endl;
	print(charVector);
	cout << "isSorted(charVector): " << isSorted(charVector) << endl;
	cout << endl << "Using local sort" << endl;
	sort(charVector);
	cout << endl << "charVector after sorting:" << endl;
	print(charVector);
	cout << "isSorted(charVector): " << isSorted(charVector) << endl;

#ifdef CSC502
	charVector.clear();
	for (int i = 0; i < SIZE; i++)
		charVector.push_back(Comparable<char>(rand() % 59 + 65));
	cout << endl << "Using std::sort" << endl;
	std::sort(charVector.begin(), charVector.end());
	cout << endl << "charVector after std::sort:" << endl;
	print(charVector);
	cout << "isSorted(charVector): " << isSorted(charVector) << endl;
#endif

	cout << endl << "Additional tests with various built-in types:" << endl << SEPARATOR << endl;
	cout << endl << "Comparable<double> limited tests:" << endl << endl;
	Comparable<double> d1{ 9.12 };
	cout << "d1 = " << d1 << endl;
	Comparable<double> d2{ 10.47 };
	cout << "d2 = " << d2 << endl;
	cout << "d1 < d2 = " << (d1 < d2) << endl;
	cout << "d2 > d1 = " << (d2 < d1) << endl;
	cout << "d2 == d1 = " << (d2 == d1) << endl;
	cout << endl;

	/* Here are some interesting effects of explicit construction for Comparables.

	Without the explicit modifier on the Comparable single-arg constructor, one could
	use the alternate form of construction that does automatic type conversion, as in:
	Comparable<int> ci = 10;

	With the explicit modifier, we have to use legacy constructor syntax or initializer syntax:
	Comparable<int> ci(10);
	Comparable<int> ci{ 10 };

	While we might think that implicit conversion makes sense, compilers have been inconsistent in
	what they allow.
	For instance, it would be natural to construct a Comparable<string> from the literal
	"Hello", which is a const char[6] (stack-allocated primitive C string) with null terminator).
	Comparable<string> cs = "Hello";

	Note that the string class itself supports implicit conversion using = during construction:
	string s = "Hello";  // const char[6] used to construct a string object

	But implicit conversion of a const char[6] directly into a Comparable<string> by way of first
	converting const char[6] to a string object was "a bridge too far."

	The GNU g++ compiler has not supported that for some time, but VS 2017 did at one point.
	More recent versions of VS 2017 strive to be closer to the standard, and it is no longer allowed.
	To make VS 2017 more strict, MS supported a compiler option /permissive- (turn off permissiveness...)

	Keep in the mind that, without the explicit modifier, VS still allows implicit conversion
	of an int literal, even though it drew the line at strings.
	That would be due to there being no intermediate conversion.
	10 is an int, and that's all it can be.
	Comparable<int> ci = 10;  // fine in VS without explicit modifier

	At any rate, all C++11 compilers support contruction using traditional ()'s or initializers { }.
	With { } we get added safety, so that's what we should try to get in the habit of using.

	Comparable<string> cs{ "Hello" };  // construct the string implicitly, then construct the Comparable<string>

	A more verbose form actually calls the string constructor, then passes that object to the Comparable constructor
	Comparable<string> cs{ string("Hello") };

	If Integer, Character, and Double had also been declared explicit, the only way to construct a Comparable<>
	using one of those types would be to first explicitly construct the enclosed type:

	Comparable<Integer> { Integer(10) };

	Finally, what about these two? Should they work or not?  See below.
	Comparable<Integer> test1{ 'a' };
	Comparable<Character> test2{ 65 };

	*/
	cout << endl << "Comparable<string> limited tests:" << endl << endl;
	Comparable<string> s1{ "Hello" };
	cout << "s1 = " << s1 << endl;

	Comparable<string> s2{ string("World") };

	cout << "s2 = " << s2 << endl;
	cout << "s1 < s2 is " << (s1 < s2) << endl;


	cout << endl << "Tests with Project 3 IComparables:" << endl << SEPARATOR << endl;

	Comparable<Integer> test1{ 'a' };     //  test1 = 97 (ASCII 97 is the letter a)
	Comparable<Character> test2{ 65 };  	//  test2 = A (ASCII 65)

	cout << "test1 = " << test1 << endl;
	cout << "test2 = " << test2 << endl;

	Comparable<Integer> ci1;
	cout << "ci1 = " << ci1 << endl;

	Comparable<Integer> ci2{ Integer(10) };
	cout << "ci2 = " << ci2 << endl;
	cout << "ciI < ci2 is " << (ci1 < ci2) << endl;
	cout << endl;

	Comparable<Character> cc1{ 'A' };
	cout << "cc1 = " << cc1 << endl;

	Character _cc2('Z');
	Comparable<Character> cc2{ _cc2 };

	cout << "cc2 = " << cc2 << endl;
	cout << "cc1 < cc2 is " << (cc1 < cc2) << endl;

	vector<Comparable<Integer>> vci;
	for (unsigned int i = 0; i < SIZE; i++)
		vci.push_back(Comparable<Integer>(rand()));
	sort(vci.begin(), vci.end());
	cout << endl << "vci after sort:" << endl;
	print(vci);
	cout << "isSorted(vci): " << isSorted(vci) << endl;

	cout << endl << "Hit any key to end the program..." << endl;
	cin.get();
	return 0;

}

template <typename T>
void print(const vector<T>  & v)
{
	// if the vector is larger than 100 print only the first
	// ten elements and the last ten
	int size = v.size();
	if (size > 100) {
		for (int i = 0; i < 10; i++)
			cout << v[i] << "\t";
		cout << " ... " << endl;
		for (int i = 0; i < 10; i++)
			cout << v[size - (i + 1)] << "\t";
		cout << endl;
	}
	else {
		for (auto item : v)
			cout << item << "\t";
		cout << endl;
	}
}

template <typename T>
bool isSorted(const vector<T> & v) {
	bool sorted = true;
	for (unsigned int i = 1; i < v.size(); i++)
		if (v[i] < v[i - 1]) {
			sorted = false;
			break;
		}
	return sorted;
}

template <typename T>
void sort(vector<T> & v) {
	unsigned int i, j, min;
	T tmp;  // taking advantage of T default construction

	// selection sort for simplicity... not efficiency 
	for (j = 0; j < v.size(); j++) {
		min = j;
		for (i = j + 1; i < v.size(); i++) {
			if (v[i] < v[min]) {
				min = i;
			}
		}

		if (min != j) {
			tmp = v[j];
			v[j] = v[min];
			v[min] = tmp;
		}
	}
}