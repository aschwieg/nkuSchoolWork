// TestMyLinkedListForHW.java
// This program tests the following methods --
// In the MyLinkedList class:
//    boolean contains(E e)
//    E get(int index)
//    int indexOf(E e)
//    int lastIndexOf(E e)
//    E set(int index, E d)
// In the MyLinkedListIterator class:
//     void remove()
// -Jeff Ward

import java.util.*;

public class TestMyLinkedListForHW {
  public static void main(String[] args) {
  	MyLinkedList<String> stringList = new MyLinkedList<String>();
  	stringList.add("Alabama");
	stringList.add("Alaska");
	stringList.add("Arizona");
	stringList.add("Arkansas");
	stringList.add(4, "California");
	stringList.set(1, "Arkansas");
	if (stringList.toString().equals("[Alabama, Arkansas, Arizona, Arkansas, California]"))
		System.out.println("Test 1 successful");
	else {
		System.out.println("Test 1 failed");
		System.out.println(stringList);
		System.exit(1);
	}
	if (stringList.contains("Arizona"))
		System.out.println("Test 2 successful");
	else {
		System.out.println("Test 2 failed");
		System.out.println(stringList);
		System.exit(1);
	}
	if (!stringList.contains("Alaska"))
		System.out.println("Test 3 successful");
	else {
		System.out.println("Test 3 failed");
		System.out.println(stringList);
		System.exit(1);
	}
	if (stringList.get(2).equals("Arizona"))
		System.out.println("Test 4 successful");
	else {
		System.out.println("Test 4 failed");
		System.out.println(stringList);
		System.exit(1);
	}
	if (stringList.indexOf("Arkansas") == 1)
		System.out.println("Test 5 successful");
	else {
		System.out.println("Test 5 failed");
		System.out.println(stringList);
		System.exit(1);
	}
	if (stringList.lastIndexOf("Arkansas") == 3)
		System.out.println("Test 6 successful");
	else {
		System.out.println("Test 6 failed");
		System.out.println(stringList);
		System.exit(1);
	}
	if (stringList.set(2, null).equals("Arizona"))
		System.out.println("Test 7 successful");
	else {
		System.out.println("Test 7 failed");
		System.out.println(stringList);
		System.exit(1);
	}
	if (stringList.get(2) == null)
		System.out.println("Test 8 successful");
	else {
		System.out.println("Test 8 failed");
		System.out.println(stringList);
		System.exit(1);
	}
	if (stringList.contains(null))
		System.out.println("Test 9 successful");
	else {
		System.out.println("Test 9 failed");
		System.out.println(stringList);
		System.exit(1);
	}
	if (stringList.indexOf(null) == 2)
		System.out.println("Test 10 successful");
	else {
		System.out.println("Test 10 failed");
		System.out.println(stringList);
		System.exit(1);
	}
	if (stringList.lastIndexOf(null) == 2)
		System.out.println("Test 11 successful");
	else {
		System.out.println("Test 11 failed");
		System.out.println(stringList);
		System.exit(1);
	}
	if (stringList.indexOf("California") == 4)
		System.out.println("Test 12 successful");
	else {
		System.out.println("Test 12 failed");
		System.out.println(stringList);
		System.exit(1);
	}
	if (stringList.lastIndexOf("Alabama") == 0)
		System.out.println("Test 13 successful");
	else {
		System.out.println("Test 13 failed");
		System.out.println(stringList);
		System.exit(1);
	}
	if (stringList.lastIndexOf("Kentucky") == -1)
		System.out.println("Test 14 successful");
	else {
		System.out.println("Test 14 failed");
		System.out.println(stringList);
		System.exit(1);
	}
	try {
		stringList.get(-1);
		System.out.println("Test 15 failed");
		System.exit(1);
	}
	catch (IndexOutOfBoundsException ex) {
		System.out.println("Test 15 successful");
	}
	try {
		stringList.get(5);
		System.out.println("Test 16 failed");
		System.exit(1);
	}
	catch (IndexOutOfBoundsException ex) {
		System.out.println("Test 16 successful");
	}
	try {
		stringList.set(-1, "Colorado");
		System.out.println("Test 17 failed");
		System.exit(1);
	}
	catch (IndexOutOfBoundsException ex) {
		System.out.println("Test 17 successful");
	}
	try {
		stringList.set(5, "Conneticut");
		System.out.println("Test 18 failed");
		System.exit(1);
	}
	catch (IndexOutOfBoundsException ex) {
		System.out.println("Test 18 successful");
	}

    MyLinkedList<Object> objectList = new MyLinkedList<Object>();
    objectList.add(1);
    objectList.add(2);
    objectList.add(3);
    objectList.add(4);
    objectList.add(0, "James");
    objectList.add(0, "Jake");
    objectList.add(3, "Jill");
    objectList.add(3, "Jane");
    objectList.add(6, "Joel");
    objectList.add(9, "John");
    objectList.addLast("Jonathan");
    if (objectList.toString().equals("[Jake, James, 1, Jane, Jill, 2, Joel, 3, 4, John, Jonathan]"))
		System.out.println("Test 19 successful");
	else {
		System.out.println("Test 19 failed");
		System.out.println(objectList);
		System.exit(1);
	}
    
    // The following tests the iterator code.
    Iterator<Object> iter = objectList.iterator();
    while (iter.hasNext()) {
      Object elt = iter.next();
      if (elt instanceof String)
        iter.remove();
    }
    if (objectList.toString().equals("[1, 2, 3, 4]"))
		System.out.println("Test 20 successful");
	else {
		System.out.println("Test 20 failed");
		System.out.println(objectList);
		System.exit(1);
	}
    
    iter = objectList.iterator();
    int counter = 0;
    while (iter.hasNext()) {
      if (!iter.next().equals(++counter)) {
    	  System.out.println("Test 21 failed");
    	  System.exit(1);
      }
    }
    if (counter == 4)
    	System.out.println("Test 21 successful");
    else {
    	System.out.println("Test 21 failed");
    	System.exit(1);
    }
    
    objectList = new MyLinkedList<Object>();
    iter = objectList.iterator();
    try {
    	iter.next();
    	System.out.println("Failed Test 22");
    	System.exit(1);
    }
    catch (NoSuchElementException ex) {
    	System.out.println("Test 22 successful");
    }
    objectList.add(1);
    objectList.add(2);
    objectList.add(3);
    objectList.add(4);
    iter = objectList.iterator();
    iter.next();
    iter.remove();
    try {
    	iter.remove();
    	System.out.println("Failed Test 23");
    	System.exit(1);
    }
    catch (IllegalStateException ex) {
    	System.out.println("Test 23 successful");
    }
    iter.next();
    iter.next();
    iter.next();
    try {
    	iter.next();
    	System.out.println("Failed Test 24");
    	System.exit(1);
    }
    catch (NoSuchElementException ex) {
    	System.out.println("Test 24 successful");
    }
    if (objectList.toString().equals("[2, 3, 4]"))
		System.out.println("Test 25 successful");
	else {
		System.out.println("Test 25 failed");
		System.out.println(objectList);
		System.exit(1);
	}
    iter = objectList.iterator();
    counter = 2;
    while (iter.hasNext()) {
      if (!iter.next().equals(counter++)) {
    	  System.out.println("Test 26 failed");
    	  System.exit(1);
      }
      else
    	  iter.remove();
    }
    if (counter == 5 && objectList.isEmpty())
    	System.out.println("Test 26 successful");
    else {
    	System.out.println("Test 26 failed");
  	    System.exit(1);
    }
    
    objectList.add("A");
    objectList.add("B");
    objectList.add("C");
    if (objectList.toString().equals("[A, B, C]"))
		System.out.println("Test 27 successful");
	else {
		System.out.println("Test 27 failed");
		System.out.println(stringList);
		System.exit(1);
	}
    
    System.out.println("Tests completed");
  }
}