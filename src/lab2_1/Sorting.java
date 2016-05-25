/*
 * SCHOOL: UNIVERSITY OF THE PEOPLE
 * COURSE: CS1103 - PROGRAMMING 2
 * PROF: MARC BUENO
 * ASSIGNMENT: LAB2 PART 1 - BENCHMARKING SORTING ALGORITHMS
 * STUDENT: ANONYMOUS
 */

package lab2_1;

import java.util.Arrays;

/**
 * <!-- View this comment in the "Javadoc" tab for better
 * reading. -->
 * <style>
 * 	body { font-size: 16px; }
 *   li {
 *     list-style-type: none;
 *   } 
 * </style>
 * <h1>Description</h1>
 * This program fills 2 arrays with identically random 
 * integers and records the difference in
 * time needed to sort them.
 * The first algorithm used is the insertion sort.
 * The second sorting method is the built-in Arrays.sort()
 * 
 * <h2>The results of this program at different array lengths:</h2>
 * <hr>
 * <h3>When SIZE equals 100</h3>
 * <ul>
 *   <li>Insertion sort = 0.0s</li>
 *   <li>Arrays.sort() = 0.001s</li>
 *   <li>Conclusion of results:<br>
 *       Insertion sort performs slightly better than Arrays.sort()</li>
 * </ul>
 * <hr>
 * <h3>When SIZE equals 1,000</h3>
 * <ul>
 *   <li>Insertion sort = 0.01s</li>
 *   <li>Arrays.sort() = 0.002s</li>
 *   <li>Conclusion of results:<br>
 *       Arrays.sort() begins to perform better than Insertion Sort</li>
 * </ul>
 * <hr>
 * <h3>When SIZE equals 10,000</h3>
 * <ul>
 *   <li>Insertion sort = 0.16s</li>
 *   <li>Arrays.sort() = 0.011s</li>
 *   <li>Conclusion of results:<br>
 *       Arrays.sort() performs better than 
 *       Insertion Sort</li>
 * </ul>
 * <hr>
 * <h3>When SIZE equals 100,000</h3>
 * <ul>
 *   <li>Insertion sort = 14.129s</li>
 *   <li>Arrays.sort() = 0.042s</li>
 *   <li>Conclusion of results:<br>
 *       Arrays.sort() performs significantly better 
 *       than insertion sort.</li>
 * </ul>
 * <hr> 
 * <h1>Conclusion of tests:</h1>
 * <p>It seems insertion sort actually has a slight, but un-noticable advantage over Arrays.sort() when
 * dealing with small quantities of data. However the time it takes for insertion sort to handle large
 * quantities of data seems to increase exponentially - 
 * specifically <em><strong>O(n<sup>2</sup>)</strong></em>. Whereas Arrays.sort()
 * Handles large quantities quite efficiently (less than 1 second to sort 100,000 items).</p>
 * @author anonymous for evaluation
 *
 */
public class Sorting {
	
	// constant used for the size of arr1 and arr2
	private static final int SIZE = 100000; 
	private static int[] arr1 = new int[SIZE];
	private static int[] arr2 = new int[SIZE];
	
	public static void main(String args[]) {

		// populates the arrays with random integers
		populate();
		
		/* 
		 * uncomment the following lines for testing (ctl + '/')
		 * only print the contents of the arrays to the console when working with 
		 * small numbers Example: 10 or less. 
		 */
//		printArr("Printing arr1: ", arr1);
//		printArr("Printing arr2: ", arr2);
		
		/* use insertion sort from our text book on arr1
		 * and record the time in milliseconds
		 */
		long startTime = System.currentTimeMillis();
		insertionSort(arr1);
		long runTime = System.currentTimeMillis() - startTime;
		System.out.println("Run time for insertion sort: " + runTime/1000.0);
		
		// testing only -- don't print the contents when working with high numbers.
//		printArr("Printing arr1: ", arr1);
		
		
		/* use built-in Arrays.sort on arr2
		 * and record the time in milliseconds
		 */
		startTime = System.currentTimeMillis();
		Arrays.sort(arr2);
		runTime = System.currentTimeMillis() - startTime;
		System.out.println("Run time for Arrays.sort(): " + runTime/1000.0);
		
		
		
	}
	
	/** 
	 * Used for logging the contents of the static members to the console.
	 * Use this function to manually determine the correctness
	 * of the insertion sort algorithm.
	 * @param message
	 * @param A
	 */
	private static void printArr(String message, int[] A) {
		System.out.println(message);
		for(int i : A) {
			System.out.println(i);
		}
	}
	
	/**
	 * Insertion sort algorithm taken from: 
	 * Introduction to Programming Using Java Version 7.0
	 * @param A
	 */
	private static void insertionSort(int[] A) { 
		
		int itemsSorted; // Number of items that have been sorted so far.
		
		for (itemsSorted = 1; itemsSorted < A.length; itemsSorted++) { 
			// Assume that items A[0], A[1], ... A[itemsSorted-1] 
			// have already been sorted. Insert A[itemsSorted] 
			// into the sorted part of the list.
			
			int temp = A[itemsSorted]; // The item to be inserted. 
			int loc = itemsSorted - 1; // Start at end of list.
			
			while (loc >= 0 && A[loc] > temp) { 
				A[loc + 1] = A[loc]; // Bump item from A[loc] up to loc+1. 
				loc = loc - 1;       // Go on to next location. 
			}
			A[loc + 1] = temp; // Put temp in last vacated space.
		}
	}
	
	/** 
	 * Populates the static arrays with random integers. Use 
	 * Integer.MAX_VALUE as long as the contents are not being printed to
	 * the screen. 
	 * <p><strong>Note:</strong> if you're testing the code 
	 * to see if the custom insertion
	 * sort works, use a smaller number like '10' so it's easier to see
	 * the console logs.</p>
	 */
	private static void populate() {
		for (int i = 0; i < SIZE; i++) {
			arr1[i] = (int)(Integer.MAX_VALUE * Math.random());
			arr2[i] = arr1[i];
		}
	}
}
