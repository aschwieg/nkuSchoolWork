package project1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;

// Java 8 time library
import java.time.temporal.ChronoUnit;
import java.time.Instant;

public class project1 {
	// For convenience, define RAND_MAX to mimic C++ std::rand() method
	static final int RAND_MAX = 32767;

	public static void main(String[] args) {

		// declare a primitive array to facilitate test runs of various sizes; 
		// uncomment the last two for your final test run(s)
		int[] sizes = { 10, 1000, 10000, 100000  , 500000};

		// declare variables that are initialized/reinitialized later
		int[] intArray;
		ArrayList<Integer> integerArrayList;

		// java.time.Instant is a (potentially) higher-precision timestamp than
		// System.currentTimeMillis();
		Instant start, finish;
		long elapsedTime;

		// main for loop drives the number of time trials
		for (int sz : sizes) {

			System.out.println("Time trial for primitve array and ArrayList of size " + sz);
			System.out.println("=================================================================");

			System.out.println("intArray initialization");
			start = Instant.now();
			intArray = new int[sz];
			init(intArray, sz);
			finish = Instant.now();
			elapsedTime = ChronoUnit.MICROS.between(start, finish);
			System.out.println(
					"Elapsed time for intializing a primitive array of " + sz + " elements: " + elapsedTime + "\n");

			System.out.println("intArray before sorting");
			print(intArray);
			System.out.println("intArray isSorted: " + isSorted(intArray));

			// primitive int array sort test
			start = Instant.now();
			sort(intArray);
			finish = Instant.now();
			elapsedTime = ChronoUnit.MICROS.between(start, finish);

			System.out.println();
			System.out.println("intArray after sorting");
			print(intArray);
			System.out.println("intArray isSorted: " + isSorted(intArray));

			elapsedTime = ChronoUnit.MICROS.between(start, finish);
			System.out.println(
					"Elapsed time for sorting a primitive array of " + sz + " elements: " + elapsedTime + "\n");

			System.out.println("integerArrayList initialization");
			start = Instant.now();
			integerArrayList = new ArrayList<Integer>(sz);
			init(integerArrayList, sz);
			finish = Instant.now();
			elapsedTime = ChronoUnit.MICROS.between(start, finish);
			System.out.println(
					"Elapsed time for intializing an ArrayList<Integer> of " + sz + " elements: " + elapsedTime + "\n");

			System.out.println("integerArrayList before sorting");
			print(integerArrayList);
			System.out.println("integerArrayList isSorted: " + isSorted(integerArrayList));
			System.out.println();

			start = Instant.now();
			sort(integerArrayList);
			finish = Instant.now();
			elapsedTime = ChronoUnit.MICROS.between(start, finish);

			System.out.println("integerArrayList after sorting");
			print(integerArrayList);
			System.out.println("integerArrayList isSorted: " + isSorted(integerArrayList));

			System.out.println(
					"Elapsed time for sorting an ArrayList<Integer> of " + sz + " elements: " + elapsedTime + "\n");

			System.out.println("Built-in sort tests ");
			System.out.println("-----------------------------------");
			// reinitialize to prep for built-in sort test
			init(intArray, sz);

			System.out.println("intArray before sorting");
			print(intArray);
			System.out.println("intArray isSorted: " + isSorted(intArray));
			System.out.println();

			start = Instant.now();
			Arrays.sort(intArray);
			finish = Instant.now();
			elapsedTime = ChronoUnit.MICROS.between(start, finish);

			System.out.println("intArray after sorting");
			print(intArray);
			System.out.println("intArray isSorted: " + isSorted(intArray));

			System.out.println("Elapsed time for built-in sort of a primitive array of " + sz + " elements: "
					+ elapsedTime + "\n");

			// reinitialize ArrayList to prep for built-in sort
			integerArrayList.clear();
			init(integerArrayList, sz);

			System.out.println("integerArrayList before sorting");
			print(integerArrayList);
			System.out.println("integerArrayList isSorted: " + isSorted(integerArrayList));
			System.out.println();

			start = Instant.now();
			integerArrayList.sort(null);
			finish = Instant.now();
			elapsedTime = ChronoUnit.MICROS.between(start, finish);

			System.out.println("integerArrayList after sorting");
			print(integerArrayList);
			System.out.println("integerArrayList isSorted: " + isSorted(integerArrayList));

			System.out.println("Elapsed time for built-in sort with an ArrayList<Integer> of " + sz + " elements: "
					+ elapsedTime + "\n");

			System.out.println();

		} // end of for loop

	} // end of main method

	
	// auxiliary method definitions 
	
	public static void init(int[] arr, int size) {
		Random r = new Random(System.currentTimeMillis());
		for (int i = 0; i < size; ++i)
			arr[i] = r.nextInt(RAND_MAX); // range 0-32767
	}

	public static void init(ArrayList<Integer> arrList, int size) {
		Random r = new Random(System.currentTimeMillis());
		for (int i = 0; i < size; ++i)
			arrList.add(new Integer(r.nextInt(RAND_MAX)));
	}

	public static void sort(int[] arr) {
		// selection sort, which looks virtually identical in Java and C/C++
		int i, j, min, tmp;
		for (j = 0; j < arr.length; j++) {
			/* assume the min is the first element */
			min = j;
			/* test against elements after j to find the smallest */
			for (i = j + 1; i < arr.length; i++) {
				/* if this element is less, then it is the new minimum */
				if (arr[i] < arr[min]) {
					min = i;
				}
			}
			// swap if we have a new min
			if (min != j) {
				tmp = arr[j];
				arr[j] = arr[min];
				arr[min] = tmp;
			}
		}

	} // end of sort( int[] arr ) method

	public static void sort(ArrayList<Integer> arrList) {
		int i, j, min;
		Integer tmp;
		for (j = 0; j < arrList.size(); j++) {
			// assume the min is the first element
			min = j;
			// test against elements after j to find the smallest
			for (i = j + 1; i < arrList.size(); i++) {

				// if this element is less, then it is the new minimum
				if (arrList.get(i) < arrList.get(min)) {
					min = i;
				}
			}

			// swap if there is a new min
			if (min != j) {
				tmp = arrList.get(j);
				arrList.set(j, arrList.get(min));
				arrList.set(min, tmp);
			}
		}
	}

	public static boolean isSorted(int[] arr) {
		for (int i = 0; i < arr.length - 1; ++i) {
			if (arr[i] > arr[i + 1])
				return false;
		}
		// fall-through case
		return true;
	} // end of isSorted(int[] arr)

	public static boolean isSorted(ArrayList<Integer> arrList) {
		for (int i = 0; i < arrList.size() - 1; ++i) {
			if (arrList.get(i) > arrList.get(i + 1))
				return false;
		}
		// fall-through case
		return true;
	} // end of isSorted(ArrayList<Integer> arrList)

	public static void print(int[] arr) {
		int size = arr.length;
		if (size > 10) {
			System.out.print(arr[0] + ", " + arr[1] + ", " + arr[2] + " ... ");
			System.out.println(arr[size - 3] + ", " + arr[size - 2] + ", " + arr[size - 1]);
		} else {
			for (int i = 0; i < size; i++)
				System.out.print(arr[i] + "\t");
			System.out.println();
		}
	}

	public static void print(ArrayList<Integer> arrList) {
		int size = arrList.size();
		if (size > 10) {
			System.out.print(arrList.get(0) + ", " + arrList.get(1) + ", " + arrList.get(2) + " ... ");
			System.out.println(arrList.get(size - 3) + ", " + arrList.get(size - 2) + ", " + arrList.get(size - 1));
		} else {
			for (int i = 0; i < size; i++)
				System.out.print(arrList.get(i) + "\t");
			System.out.println();
		}
	}

}
