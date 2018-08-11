//Alex Schwiegeraht
//CSC 362, 001, Programming assignment 6, 4/27/18
//This program tests which size of hash table and which type of linked lists in the hash tables perform the best.
//Two arrays, one representing an ordered linked list method and the other representing an unordered linked list method, of list structs are made, 
//then an array of a 1000 randomly generated integers is created.Each array has the values generated inserted into the linked list at where they were hashed to. 
//Then each array is searched using the generated values except for every 3rd value where a new randomly generated value takes its place.
//The total number of nodes in each linked list within the array is compared to find the longest linked list and the shortest linked list.
//The total amount of operations for each array is outputed along with the longest and shortest linked list and length of the arrays.

//Conclusion: The trial with array size of 25 and unordered linked lists performed with the fewest operations.

#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>                  
#include <stdlib.h>
#include <time.h>   

struct node *unorderedInsert(struct node *, int, int *);//inserts a node into a linked list at the first position
struct node *orderedInsert(struct node *, int, int *);//inserts a node into a linked list so that it is the members of the linked list are in order
struct node *orderedSearch(struct node *, int, int *);//finds a node from a ordered linked list based on the value given
struct node *unorderedSearch(struct node *, int, int *);//finds a node from a ordered linked list based on the value given
void destroy(struct node *);//deallocates a linked list starting at the given node
void print(struct node *);//prints the elements of a linked list

//a struct which represents the node in the linked list which contains an int value and a pointer to the next node in the list
struct node 
{
	int data;
	struct node *next;
};

//a struct which represents the beginning of a linked list containing the size of the linked list as well as the pointer to the first node in a linked list
struct list 
{
	int size;
	struct node *front;
};
 
void main() 
{
	int values[1000];//array for random values to be inserted into the two arrays for hashing
	//arraySize is the size of the array used for hashing, hash is the value for where in the array a new node is inserted, 
	//random holds the random value for testing the search functions, the counters hold how many operations are being performed in ordered(1) vs unordered(2), longest and shortest list determine what the shortest and longest linked list is in the arrays, and i is used for loops
	int arraySize = 25, hash, random, counter1 = 0, counter2 = 0, longestList = 0, shortestList = 0,i;
	struct list list1[25];//array of list structs for hashing the ordered linked lists
	struct list list2[25];//array of list structs for hashing the unordered linked lists
	srand(time(NULL));//seeding the rand() function

	//loop sets all list structs to size 0 and pointing to null
	for (i = 0; i < arraySize; i++)
	{
		list1[i].size = 0;
		list1[i].front = NULL;
		list2[i].size = 0;
		list2[i].front = NULL;
	}

	//loop places 1000 randomly generated integers into the values array
	for (i = 0; i < 1000; i++) 
	{
		values[i] = rand() % 100000;
	}
	//loops through all the elements of the values array to insert them into each linked list
	for (i = 0; i < 1000; i++) 
	{
		hash = values[i] % arraySize;//formula for hashing
		list1[hash].front = orderedInsert(list1[hash].front, values[i], &counter1);//sets the new front of list struct at location of the hash equal to the front of the linked list after the insert occurs
		list1[hash].size++;//increases the size of the list struct at the location of the hash 
		list2[hash].front = unorderedInsert(list2[hash].front, values[i], &counter2);//sets the new front of list struct at location of the hash equal to the front of the linked list after the insert occurs
		list2[hash].size++;//increases the size of the list struct at the location of the hash 
	}
	//loops through the elements of the values array to search for the element in the lists except every third iteration a random value is generated and searched for in the arrays
	for (i = 0; i < 1000; i++) 
	{
		if (i % 3 == 0) //checks if it is the third iteration
		{
			random = rand() % 100000;//creates new random int
			hash = random % arraySize;//formula for hashing
			orderedSearch(list1[hash].front, random, &counter1);//searches the ordered linked list for the random int
			unorderedSearch(list2[hash].front, random, &counter2);//searches the unordered linked lists for the random int
		}
		else 
		{
			hash = values[i] % arraySize;//formula for hashing
			orderedSearch(list1[hash].front, values[i], &counter1);//searches the ordered linked lists for the value in the values array
			unorderedSearch(list2[hash].front, values[i], &counter2);//searches the unordered linked lists for the value in the values array
		}
	}
	//initializes shortestList to the first size of the first list struct in the array
	shortestList = list1[0].size;
	//loops through the array to find which list struct has the largest and smallest size as well as deallocates the linked lists
	for (i = 0; i < arraySize; i++)
	{
		if (list1[i].size > longestList) //checks if current element is the largest list
			longestList = list1[i].size;
		else if (list1[i].size < shortestList) //checks if current element is the smallest list
			shortestList = list1[i].size;
		destroy(list1[i].front);//deallocates the linked list at the current array location for the ordered linked lists
		destroy(list2[i].front);//deallocates the linked list at the current array location for the unordered linked lists
	}

	//output
	printf("For array size: %d\nNumber of Operations (ordered list):%d\nNumber of Operations (unordered list):%d\nLongest List:%d\nShortest List:%d\n", arraySize, counter1, counter2,longestList,shortestList);
	system("PAUSE");
}

//takes the front of a linked list, an int that is going to be inserted, and a counter for the total operations and places the int at the first location in the array
struct node *unorderedInsert(struct node *f, int x, int *counter)
{
	struct node *temp = (struct node *)malloc(sizeof(struct node));  //allocates the node temp
	*counter = *counter + 1;//adds to the operations counter
	temp->data = x; //the new nodes data is set to the passed int
	temp->next = f; //the new node points to the old front of the linked list
	return temp;//the new node is returned to be placed as the new front of the linked list
}
//takes the front of a linked list, an int that is going to be inserted, and a counter for the total operations and places the int at an ordered position in the array
struct node *orderedInsert(struct node *f, int x, int *counter)
{
	struct node *temp, *current, *previous;  
	temp = (struct node *)malloc(sizeof(struct node));//allocates a new node
	temp->data = x;//temp is set to the given int
	temp->next = NULL;//temp points to NULL          
	if (f == NULL) //if the linked list is empty
	{
		*counter = *counter + 1;//adds to the operations counter
		return temp;//temp is returned to be set as the new front of the linked list
	}
	else if (x <= f->data)//if the front of the linked list is the same or less than the given int          
	{
		*counter = *counter + 1;//adds to the operations counter
		temp->next = f;// the new node points to the old front of the linked list
		return temp;//temp is returned to be set as the new front of the linked list
	}
	else                       
	{
		current = f;//the front of the linked list becomes the current elemen       
		previous = NULL;
		while (current != NULL && current->data<x)//loops until the end of linked list or a node that has less than x is found
		{
			*counter = *counter + 1;//adds to the operations counter
			previous = current;//the previous node becomes the current
			current = current->next;//current is sent to the next node in the linked list  
		}
		previous->next = temp;//the previous node's pointer is set to the new node   
		temp->next = current;//the new nodes pointer is set to the current node in the linked list
		return f;//the front is return to remain the front of the linked list         
	}
}
//deallocates the linked list at the given node
void destroy(struct node *f)                
{
	struct node *temp = f;//a temp node is created and set to the given node         
	while (f != NULL)//loops until the end of linked list
	{
		f = f->next;// the given node is set to the next node in the linked list
		free(temp);//the temp node is deallocated           
		temp = f;//temp is set to the new node
	}
}
//takes the front of a linked list, an int that is going to be searched for, and a counter for the total operations and finds the node of the int or else returns NULL
struct node *orderedSearch(struct node *f, int x, int *counter)
{
	if (f == NULL)//if the linked list is empty then reurn NULL
		return NULL;
	else
	{
		while (f->next != NULL && f->data < x)//loops until the end of the linked list or until the data excedes the the searched for int
		{
			*counter = *counter + 1;//adds to the operations counter
			f = f->next;
		}
		return f;
	}
}
//takes the front of a linked list, an int that is going to be searched for, and a counter for the total operations and finds the node of the int or else returns NULL
struct node *unorderedSearch(struct node *f, int x, int *counter)
{
	while (f != NULL)//loops until the end of the linked list
	{
		if (f->data == x) //checks if the data is set to the searched for int 
		{
			*counter = *counter + 1;//adds to the operations counter
			return f;
		}
		*counter = *counter + 1;
		f = f->next;//f is set to the next element in the linked list
	}
	return NULL;//returns NULL if the searched for int isn't found
}
//prints the elements of a linked list
void print(struct node *f)                  
{
	while (f != NULL)                         
	{
		printf("%d\n", f->data);
		f = f->next;
	}
}