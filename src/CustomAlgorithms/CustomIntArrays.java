package CustomAlgorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * The CustomIntArrays class provides an API for searching, sorting, and
 * manipulating arrays of primitive ints.
 * @author Robert James Meade
 * @version 0.3
 */
public class CustomIntArrays
{
	/**
	 * The sequentialSearch method searches the given array from start to finish
	 * and returns the first index at which it finds the specified value. If the
	 * value is not found, it returns -1.\nRunning Time:
	 * <ul>
	 * <li>average: O(n)</li>
	 * <li>worst O(n)</li>
	 * <li>best O(1)</li>
	 * </ul>
	 * Memory Usage:
	 * <ul>
	 * <li>O(1)</li>
	 * </ul>
	 * @param arr Array to search
	 * @param from starting index (inclusive)
	 * @param to ending index (exclusive)
	 * @param n Value to search for
	 * @return Index of element (-1 if not found)
	 */
	public static int sequentialSearch(int[] arr, int from, int to, int n)
	{
		for (int i = from; i < to; i++)
		{
			if (arr[i] == n)
			{
				return i;
			}
		}
		return -1;
	}

	/**
	 * The binarySearchIterative method searches a pre-sorted array for a given
	 * value using an iterative implementation of the binary search algorithm.
	 * If the value is not found, it returns -1. This is not a stable search
	 * (the original ordering of elements is not necessarily preserved). Running
	 * time:
	 * <ul>
	 * <li>average: O(log n)</li>
	 * <li>worst O(log n)</li>
	 * <li>best O(1)</li>
	 * </ul>
	 * Memory Usage:
	 * <ul>
	 * <li>O(1)</li>
	 * </ul>
	 * @param arr Array to search
	 * @param n Value to search for
	 * @param from starting index (inclusive)
	 * @param to ending index (exclusive)
	 * @return Index of element (-1 if not found)
	 */
	public static int binarySearch(int[] arr, int from, int to, int n)
	{
		to--;

		while (from <= to)
		{
			int middle = (from + to) / 2;

			if (arr[middle] == n)
				return middle;
			else if (n > arr[middle])
				from = middle + 1;
			else
				to = middle - 1;
		}
		return -1;
	}

	// Sorts
	// ----------------------------------------------------------

	/**
	 * The bubbleSort method implements Bubble Sort, an in place iterative
	 * sorting algorithm. This implementation is stable (the original ordering
	 * is preserved). \nRunning time:
	 * <ul>
	 * <li>average: O(n^2)</li>
	 * <li>worst: O(n^2)</li>
	 * <li>best: O(n)</li>
	 * </ul>
	 * Memory Usage:
	 * <ul>
	 * <li>O(1)</li>
	 * </ul>
	 * @param arr Array to sort
	 * @param from starting index (inclusive)
	 * @param to ending index (exclusive)
	 */
	public static void bubbleSort(int[] arr, int from, int to)
	{
		for (int i = from; i < to; i++)
		{
			for (int j = from + 1; j < to; j++)
			{
				// swap if in the wrong order
				if (arr[j] < arr[j - 1])
				{
					swap(arr, j, j - 1);
				}
			}
		}
	}

	/**
	 * The selectionSort method implements Selection Sort, an in place iterative
	 * sorting algorithm. This implementation is not stable (the original
	 * ordering is not necessarily preserved). \nRunning time:
	 * <ul>
	 * <li>average: O(n^2)</li>
	 * <li>worst: O(n^2)</li>
	 * <li>best: O(n^2)</li>
	 * </ul>
	 * Memory Usage:
	 * <ul>
	 * <li>O(1)</li>
	 * </ul>
	 * @param arr Array to sort
	 * @param from starting index (inclusive)
	 * @param to ending index (not inclusive)
	 */
	public static void selectionSort(int[] arr, int from, int to)
	{
		int sortedIndex = from;

		while (sortedIndex < arr.length)
		{
			int minIndex = sortedIndex;

			// find the min value
			for (int i = sortedIndex; i < arr.length; i++)
			{
				if (arr[minIndex] > arr[i])
				{
					minIndex = i;
				}
			}

			swap(arr, minIndex, sortedIndex);

			sortedIndex++;
		}
	}

	/**
	 * The insertionSort method implements Insertion Sort, a stable and in place
	 * sorting algorithm. This implementation is stable (the original ordering
	 * is preserved). \nRunning time:
	 * <ul>
	 * <li>average: O(n^2)</li>
	 * <li>worst: O(n^2)</li>
	 * <li>best: O(n)</li>
	 * </ul>
	 * Memory Usage:
	 * <ul>
	 * <li>O(1)</li>
	 * </ul>
	 * @param arr Array to sort
	 * @param from starting index (inclusive)
	 * @param to ending index (not inclusive)
	 */
	public static void insertionSortListOptimized(int[] arr, int from, int to)
	{
		int sortedIndex = from;
		int i = to - 1;

		// build sorted portion
		while (sortedIndex < to)
		{
			boolean inserted = false;

			// grab last element and insert
			int j = from;
			while (!inserted && j < sortedIndex)
			{
				if (arr[i] < arr[j])
				{
					insert(arr, j, arr[i]);
					inserted = true;
				}
				else if (j == sortedIndex - 1)
				{
					insert(arr, sortedIndex, arr[i]);
					inserted = true;
				}

				j++;
			}
			sortedIndex++;
		}
	}
	
	/**
	 * The insertionSortArrayOptimized method implements Insertion Sort, a
	 * stable and in place sorting algorithm. This implementation is stable (the
	 * original ordering is preserved). \nRunning time:
	 * <ul>
	 * <li>average: O(n^2)</li>
	 * <li>worst: O(n^2)</li>
	 * <li>best: O(n)</li>
	 * </ul>
	 * Memory Usage:
	 * <ul>
	 * <li>O(1)</li>
	 * </ul>
	 * @param arr Array to sort
	 * @param from starting index (inclusive)
	 * @param to ending index (exclusive)
	 */
	public static void insertionSortArrayOptimized(int[] arr, int from, int to)
	{
		// declare sorted index
		int i = from;

		// build sorted portion
		while (i < to)
		{
			boolean inserted = false;
			// grab next element and absorb into sorted portion (insert when
			// place is found)
			int j = 0;
			while (!inserted && j < to)
			{

				if (arr[i] < arr[j])
				{
					partialInsert(arr, j, i, arr[i]);
					inserted = true;
				}
				else if (j == i - 1)
				{
					partialInsert(arr, i, i, arr[i]);
					inserted = true;
				}

				j++;
			}

			i++;
		}
	}

	/**
	 * The mergeSort method implements Merge Sort, A recursive sorting algorithm
	 * invented by John von Neumann in 1945. This implementation is not stable
	 * (the original ordering is not necessarily preserved). \nRunning time:
	 * <ul>
	 * <li>average: O(n log n)</li>
	 * <li>worst: O(n log n)</li>
	 * <li>best: O(n log n)</li>
	 * </ul>
	 * Memory Usage:
	 * <ul>
	 * <li>O(n)</li>
	 * </ul>
	 * @param arr Array to sort
	 * @param from starting index (inclusive)
	 * @param to ending index (exclusive)
	 */
	public static void mergeSort(int[] arr, int from, int to)
	{
		if (to - from > 1)
		{
			mergeSort(arr, from, (from + to) / 2);
			mergeSort(arr, (from + to) / 2, to);
		}
		merge(arr, from, (from + to) / 2, to);
	}

	/**
	 * The quickSort method implements quick Sort, A recursive, in place sorting
	 * algorithm invented by C.A.R Hoare in 1962. This implementation is not
	 * stable (the original ordering is not necessarily preserved). \nRunning
	 * time:
	 * <ul>
	 * <li>average: O(n log n)</li>
	 * <li>worst: O(n^2)</li>
	 * <li>best: O(n log n)</li>
	 * </ul>
	 * Memory Usage:
	 * <ul>
	 * <li>O(1)</li>
	 * </ul>
	 * @param arr Array to sort
	 * @param from starting index (inclusive)
	 * @param to ending index (exclusive)
	 */
	public static void quickSort(int[] arr, int from, int to)
	{
		if (to - from > 1)
		{
			int pivot = from;
			int left = from + 1;
			int right = to - 1;

			// sweep inward until left and right indices are 1 apart
			while (left < right)
			{
				// sweep right to find value greater than pivot
				if (arr[left] <= arr[pivot])
				{
					left++;
				}
				// sweep left to find value less than pivot
				else if (arr[right] >= arr[pivot])
				{
					right--;
				}
				else
				{
					swap(arr, right, left);
					left++;
					right--;
				}
			}

			// place pivot in correct position
			// place pivot 1 less than left index if less than left index value
			if (arr[pivot] < arr[left])
			{
				swap(arr, pivot, left - 1);
				pivot = left - 1;
			}
			// plase pivot at left index if greater than or equal to left index
			// value
			else
			{
				swap(arr, pivot, left);
				pivot = left;
			}

			// recursively sort remaining partitions
			quickSort(arr, from, pivot);
			quickSort(arr, pivot + 1, to);
		}
	}

	/**
	 * The heapSort method implements heap Sort, An in place sorting
	 * algorithm invented by J. W. J. Williams in 1964. This implementation is not
	 * stable (the original ordering is not necessarily preserved). \nRunning
	 * time:
	 * <ul>
	 * <li>average: O(n log n)</li>
	 * <li>worst: O(n log n)</li>
	 * <li>best: O(n log n)</li>
	 * </ul>
	 * Memory Usage:
	 * <ul>
	 * <li>O(1)</li>
	 * </ul>
	 * @param arr Array to sort
	 * @param from starting index (inclusive)
	 * @param to ending index (not inclusive)
	 */
	public static void heapSort(int[] arr, int from, int to)
	{
		maxHeapify(arr, from, to);
		for (int i = to -1; i > from; i--)
		{
			swap(arr, from, i);
			siftDown(arr, from, i);
		}
	}
	
	/**
	 * The binaryMSDRadixSort method implements binary quicksort. It divides the
	 * array into 2 buckets, left and right and enacts an in place MSD radix
	 * sort. This is not a stable sort.
	 * <ul>
	 * <li>average: O(w n)</li>
	 * <li>worst: O(w n)</li>
	 * <li>best: O( w n)</li>
	 * </ul>
	 * Memory Usage:
	 * <ul>
	 * <li>O(1)</li>
	 * </ul>
	 * @param arr array to sort
	 * @param from starting index (inclusive)
	 * @param to ending index (exclusive)
	 * @param depth starting depth (should start at 0)
	 * @param maxDepth maxDepth (start at -1 for online calc)
	 */
	public static void binaryMSDRadixSort(int[] arr, int from, int to, int depth, int maxDepth)
	{
		// compute max depth required for MSD in place binary radix sort
		if (maxDepth == -1)
		{
			int max = arr[0];
			for (int i = 1; i < arr.length; i++)
			{
				max = Math.max(max, arr[i]);
			}
			maxDepth = (int) Math.round((Math.log(max) / Math.log(2)));
		}

		// setup bucket indices and bit for comparison
		int left = from;
		int right = to - 1;
		int bit = (int) Math.pow(2, maxDepth - depth);

		// separate elements into left and right buckets
		int i = from;
		while (left < right)
		{
			if ((arr[i] & bit) == bit)
			{
				swap(arr, right, i);
				right--;
			}
			else
			{
				left++;
				i++;
			}
		}

		// sort left and right buckets
		if (depth < maxDepth && i < arr.length)
		{
			if ((arr[i] & bit) == bit)
			{
				binaryMSDRadixSort(arr, from, i, depth + 1, maxDepth);
				binaryMSDRadixSort(arr, i, to, depth + 1, maxDepth);
			}
			else
			{
				binaryMSDRadixSort(arr, from, i + 1, depth + 1, maxDepth);
				binaryMSDRadixSort(arr, i + 1, to, depth + 1, maxDepth);
			}
		}
	}

	/**
	 * The decimalLSDRadisSort method sorts and array using an LSD radix sort
	 * and 10 buckets. This is a stable sort.
	 * <ul>
	 * <li>average: O(w n)</li>
	 * <li>worst: O(w n)</li>
	 * <li>best: O( w n)</li>
	 * </ul>
	 * Memory Usage:
	 * <ul>
	 * <li>O(n)</li>
	 * </ul>
	 * @param arr array to sort
	 * @param from starting index (inclusive)
	 * @param to ending index (not inclusive)
	 */
	public static void decimalLSDRadixSort(int[] arr, int from, int to)
	{
		int depth = 0;
		// compute max depth required
		int max = arr[from];
		for (int i = from + 1; i < to; i++)
		{
			max = Math.max(max, arr[i]);
		}

		int maxDepth = (int) Math.round((Math.log(max) / Math.log(10))) + 1;

		// cannot create generic arrays of queues -> must use collection
		ArrayList<Queue<Integer>> buckets = new ArrayList<Queue<Integer>>(10);
		for (int i = 0; i < 10; i++)
		{
			buckets.add(new LinkedList<Integer>());
		}

		// sort by each LSD until none remain
		while (depth < maxDepth)
		{
			int mod = (int) Math.pow(10, depth + 1);
			int div = (int) Math.pow(10, depth);
			
			// throw values into buckets
			for (int i = from; i < to; i++)
			{
				// get the desired 10's place and throw it in the correct bucket
				buckets.get(arr[i] % mod / div).add(arr[i]);
			}

			// get values back from buckets
			int i = 0;
			for (Queue<Integer> q : buckets)
			{
				while (q.peek() != null)
				{
					arr[i] = q.remove();
					i++;
				}
			}
			

			// sort next LSD
			depth++;
		}
	}

	/**
	 * The hexadecimalLSDRadisSort method sorts and array using an LSD radix
	 * sort and 16 buckets. This is a stable sort.
	 * <ul>
	 * <li>average: O(w n)</li>
	 * <li>worst: O(w n)</li>
	 * <li>best: O( w n)</li>
	 * </ul>
	 * Memory Usage:
	 * <ul>
	 * <li>O(n)</li>
	 * </ul>
	 * @param arr array to sort
	 * @param from starting index (inclusive)
	 * @param to ending index (not inclusive)
	 */
	public static void hexadecimalLSDRadixSort(int[] arr, int from, int to)
	{
		int depth = 0;
		// compute max depth required
		int max = arr[from];
		for (int i = from + 1; i < to; i++)
		{
			max = Math.max(max, arr[i]);
		}

		int maxDepth = (int) Math.round((Math.log(max) / Math.log(0xF))) + 1;

		// cannot create generic arrays of queues -> must use collection
		ArrayList<Queue<Integer>> buckets = new ArrayList<Queue<Integer>>(0xF);
		for (int i = 0; i < 0xF; i++)
		{
			buckets.add(new LinkedList<Integer>());
		}

		// sort by each LSD until none remain
		while (depth < maxDepth)
		{
			int mod =  (int) Math.pow(0xF, depth + 1);
			int div = (int) Math.pow(0xF, depth);
			// throw values into buckets
			for (int i = from; i < to; i++)
			{
				// get the desired 16's place and throw it in the correct bucket
				buckets.get(arr[i] % mod / div).add(arr[i]);
			}

			// get values back from buckets
			int i = from;
			for (Queue<Integer> q : buckets)
			{
				while (q.peek() != null)
				{
					arr[i] = q.remove();
					i++;
				}
			}

			// sort next LSD
			depth++;
		}
	}

	/**
	 * The definedBucketslLSDRadisSort method sorts an array using an LSD radix sort
	 * with n buckets. This is a stable sort.
	 * <ul>
	 * <li>average: O(w n)</li>
	 * <li>worst: O(w n)</li>
	 * <li>best: O( w n)</li>
	 * </ul>
	 * Memory Usage:
	 * <ul>
	 * <li>O(n)</li>
	 * </ul>
	 * @param arr array to sort
	 * @param from starting index (inclusive)
	 * @param to ending index (not inclusive)
	 * @param numBuckets the number of buckets to use for the sort (the base in
	 *        which to treat the numbers)
	 */
	public static void definedBucketsLSDRadixSort(int[] arr, int from, int to, int numBuckets)
	{
		int depth = 0;
		// compute max depth required
		int max = arr[from];
		for (int i = from + 1; i < to; i++)
		{
			max = Math.max(max, arr[i]);
		}

		int maxDepth = (int) Math.round((Math.log(max) / Math.log(numBuckets))) + 1;

		// cannot create generic arrays of queues -> must use collection
		ArrayList<Queue<Integer>> buckets = new ArrayList<Queue<Integer>>(numBuckets);
		for (int i = 0; i < numBuckets; i++)
		{
			buckets.add(new LinkedList<Integer>());
		}

		// sort by each LSD until none remain
		while (depth < maxDepth)
		{
			int mod = (int) Math.pow(numBuckets, depth + 1);
			int div = (int) Math.pow(numBuckets, depth);
			
			// throw values into buckets
			for (int i = from; i < to; i++)
			{
				// get the desired 16's place and throw it in the correct bucket
				buckets.get(arr[i] % mod / div)
						.add(arr[i]);
			}

			// get values back from buckets
			int i = from;
			for (Queue<Integer> q : buckets)
			{
				while (q.peek() != null)
				{
					arr[i] = q.remove();
					i++;
				}
			}

			// sort next LSD
			depth++;
		}
	}

	// Helper methods
	// ------------------------------------------------------------------

	/**
	 * The isSorted method checks if an array is sorted ascending or descending.
	 * @param arr Array to check
	 * @param ascending Check ascending (true) or Check descending (false)
	 * @return is the array in the specified ordering
	 */
	public static boolean isSorted(int[] arr, boolean ascending)
	{
		for (int i = 0; i < arr.length - 1; i++)
		{
			if (arr[i] > arr[i + 1] == ascending)
			{
				return false;
			}
		}
		return true;
	}

	/**
	 * The swap method swaps elements in the two specified array indices.
	 * @param arr Array to swap elements of
	 * @param index1 first index to swap
	 * @param index2 second index to swap
	 */
	public static void swap(int[] arr, int index1, int index2)
	{
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}

	/**
	 * The insert method shifts all elements 1 to the left of the specified
	 * index and inserts the given value at that index.
	 * @param arr Array to insert element in
	 * @param index Index to insert element at
	 * @param n Value to insert
	 */
	public static void insert(int[] arr, int index, int n)
	{
		// shift elements 1 to the right
		for (int i = arr.length - 1; i > index; i--)
		{
			arr[i] = arr[i - 1];
		}
		arr[index] = n;
	}

	/**
	 * The partialInsert method shifts all elements 1 to the left of the
	 * specified index until the second index is reached and inserts the given
	 * value at that index.
	 * @param arr Array to insert element in
	 * @param index Index to insert element at (inclusive)
	 * @param index2 ending index of insertion (inclusive)
	 * @param n Value to insert
	 */
	public static void partialInsert(int[] arr, int index1, int index2, int n)
	{
		// shift elements 1 to the right
		for (int i = index2; i > index1; i--)
		{
			arr[i] = arr[i - 1];
		}
		arr[index1] = n;
	}

	
	/**
	 * The merge method merges two sorted sub-arrays contained in a given array
	 * back into that given array. The sub-arrays are defined by the specified
	 * indices.
	 * @param arr Array to merge sub-arrays in to
	 * @param from start index (inclusive in first half)
	 * @param middle middle index (inclusive in second half, exclusive in first
	 *        half)
	 * @param to end index (not inclusive)
	 */
	public static void merge(int[] arr, int from, int middle, int to)
	{
		// create temp array
		int[] tempArr = new int[to - from];

		int i = from;
		int j = middle;

		// merge sorted array stacks in sorted order
		int k = 0;
		while (i < middle && j < to)
		{
			if (arr[i] < arr[j])
			{
				tempArr[k] = arr[i];
				i++;
			}
			else
			{
				tempArr[k] = arr[j];
				j++;
			}

			k++;
		}

		// finish merging left stack
		while (i < middle)
		{
			tempArr[k] = arr[i];
			i++;
			k++;
		}

		// finish merging right stack
		while (j < to)
		{
			tempArr[k] = arr[j];
			j++;
			k++;
		}

		// put temp back into main arr
		for (i = 0; i < tempArr.length; i++)
		{
			arr[from + i] = tempArr[i];
		}
	}

	/**
	 * The maxHeapify method creates a max heap data structure out of a given
	 * array.
	 * @param arr Array to heapify in max ordering
	 * @param from starting index (inclusive)
	 * @param to index to end heap data structure at (not inclusive)
	 */
	public static void maxHeapify(int[] arr, int from, int to)
	{
		// build a max heap for the given portion of the array by maxHeapifying
		// the sub-heaps beginning on the lowest layer (starting at index to /
		// 2) of sub-heaps in the portion with children nodes
		// and working backwards up the array
		for (int i = to / 2; i >= from; i--)
		{
			siftDown(arr, i, to);
		}
	}

	/**
	 * The siftDown method corrects the ordering in a portion of a max heap data
	 * structure iteratively.
	 * @param arr Array to correct ordering of max heap portion in
	 * @param from parent index (inclusive)
	 * @param to ending index for heapifying (not inclusive)
	 */
	public static void siftDown(int[] arr, int from, int to)
	{
		// get child nodes of from index
		int left = 2 * from + 1;
		int right = 2 * from + 2;

		// move the maximum element found out of the staring parent and its
		// child up the heap until it is its the proper place
		while (left < to && right < to)
		{
			if (arr[from] < arr[left] && arr[left] > arr[right])
			{
				swap(arr, from, left);
				from = left;
			}
			else if (arr[from] < arr[right])
			{
				swap(arr, from, right);
				from = right;
			}
			// portion already a max heap -> early return
			else
			{
				return;
			}
			left = 2 * from + 1;
			right = 2 * from + 2;
		}
		// catch single child case
		if (left < to)
		{
			if (arr[from] < arr[left])
			{
				swap(arr, from, left);
			}
		}
	}

	// UI Methods
	// -----------------------------------------------
	
	/**
	 * The printArray method prints an int[] array in the format [a,b,c,...,n]
	 * @param arr Array to print
	 */
	public static void printArray(int[] arr)
	{
		String output = "[";
		for (int n : arr)
		{
			output += n + ",";
		}
		System.out.println(output.substring(0, output.length() - 1) + "]");
	}
	
	/**
	 * The printArray method prints an int[] array in the format [a,b,c,...,n], showing binary values
	 * @param arr Array to print
	 */
	public static void printIntegerArrayBinary(int[] arr)
	{
		String output = "[";
		for(int n : arr)
		{
			output += Integer.toString(n, 2) + ",";
		}
		System.out.println(output.substring(0, output.length() - 1) + "]");
	}
	
	/**
	 * The printArray method prints an int[] array in the format [a,b,c,...,n], showing binary values
	 * @param arr Array to print
	 * @param from starting index inclusive
	 * @param to ending index exclusive
	 */
	public static void printPartialArrayBinary(int[] arr, int from, int to)
	{
		String output = "[";
		for(int i = from ; i < to; i++)
			output += Integer.toString(arr[i], 2) + ",";
		System.out.println(output.substring(0, output.length() - 1) + "]");
	}
	
	/**
	 * The printArray method prints an int[] array in the format [a,b,c,...,n]
	 * @param arr Array to print
	 * @param from starting index (inclusive)
	 * @param to ending index (exclusive)
	 */
	public static void printPartialArray(int[] arr, int from, int to)
	{
		String output = "[";
		for(int i = from ; i < to; i++)
			output += arr[i] + ",";
		System.out.println(output.substring(0, output.length() - 1) + "]");
	}
	
	/**
	 * The printArray method prints an int[] array in the format [a,b,c,...,n], showing base b values
	 * @param arr Array to print
	 * @param from starting index inclusive
	 * @param to ending index exclusive
	 * @param b base to display
	 */
	public static void printPartialArrayBase(int[] arr, int from, int to, int b)
	{
		String output = "[";
		for(int i = from ; i < to; i++)
			output += Integer.toString(arr[i], b) + ",";
		System.out.println(output.substring(0, output.length() - 1) + "]");
	}
	
	/**
	 * The printArray method prints an int[] array in the format [a,b,c,...,n], showing base b values
	 * @param arr Array to print
	 * 	@param from starting index (inclusive)
	 * @param to ending index (exclusive)
	 * @param b base to display
	 */
	public static void printArrayBase(int[] arr, int from, int to, int b)
	{
		String output = "[";
		for(int i = from ; i < to; i++)
			output +=  Integer.toString(arr[i], b) + ",";
		System.out.println(output.substring(0, output.length() - 1) + "]");
	}
	
	// Delegates
	// -----------------------------------------------
	

	/**
	 * The bubbleSort method sorts an entire array using bubble sort.
	 * @param arr array to sort
	 */
	public static void bubbleSort(int[] arr)
	{
		bubbleSort(arr, 0, arr.length);
	}

	/**
	 * The selectionSort method sorts an entire array using a selection sort.
	 * @param arr array to sort
	 */
	public static void selectionSort(int[] arr)
	{
		selectionSort(arr, 0, arr.length);
	}

	/**
	 * The insertionSort method sorts an entire array using an insertion sort
	 * @param arr array to sort
	 */
	public static void insertionSort(int[] arr)
	{
		insertionSortListOptimized(arr, 0, arr.length);
	}

	/**
	 * The mergeSort method sorts an entire array using a merge sort
	 * @param arr array to sort
	 */
	public static void mergeSort(int[] arr)
	{
		mergeSort(arr, 0, arr.length);
	}

	/**
	 * The quickSort method sorts an entire array using a single pivot quick
	 * sort
	 * @param arr array to sort
	 */
	public static void quickSort(int[] arr)
	{
		quickSort(arr, 0, arr.length);
	}

	/**
	 * The heapSort method sorts an entire array using a max-heap based heap
	 * sort
	 * @param arr array to sort
	 */
	public static void heapSort(int[] arr)
	{
		heapSort(arr, 0, arr.length);
	}

	/**
	 * The binaryMSDRadixSort method sorts an entire array using binary quick
	 * sort
	 * @param arr array to sort
	 */
	public static void binaryMSDRadixSort(int[] arr)
	{
		binaryMSDRadixSort(arr, 0, arr.length, 0, -1);
	}

	/**
	 * The binaryMSDRadixSort method sorts an entire array using binary quick
	 * sort limited to a MSD
	 * @param arr array to sort
	 * @param maxDepth maximum depth of recursion (defined MSD in binary)
	 */
	public static void binaryMSDRadixSort(int[] arr, int maxDepth)
	{
		binaryMSDRadixSort(arr, 0, arr.length, 0, maxDepth);
	}

	/**
	 * The decimalLSDRadix sort method sorts an entire array using a radix sort
	 * with 10 buckets.
	 * @param arr array to sort
	 */
	public static void decimalLSDRadixSort(int[] arr)
	{
		decimalLSDRadixSort(arr, 0, arr.length);
	}

	/**
	 * The hexadecimalLSDRadixSort method sorts an entire array using a radix
	 * sort with 16 buckets
	 * @param arr array to sort
	 */
	public static void hexadecimalLSDRadixSort(int[] arr)
	{
		hexadecimalLSDRadixSort(arr, 0, arr.length);
	}

	/**
	 * The definedBucketsLSDRadixSort method sorts an entire array using a radix sort
	 * with n buckets
	 * @param arr array to sort
	 * @param numBuckets number of buckets to use (base to sort in)
	 */
	public static void definedBucketsLSDRadixSort(int[] arr, int numBuckets)
	{
		definedBucketsLSDRadixSort(arr, 0, arr.length, numBuckets);
	}

	/**
	 * The binarySearchIterative method searches a pre-sorted array for a given
	 * value using an iterative implementation of the binary search algorithm.
	 * If the value is not found, it returns -1.
	 * @param arr Array to search
	 * @param n Value to search for
	 * @return Index of element (-1 if not found)
	 */
	public static int binarySearch(int[] arr, int n)
	{
		return binarySearch(arr, 0, arr.length, n);
	}
	
	/**
	 * The sequentialSearch method searches the given array from start to finish
	 * and returns the first index at which it finds the specified value. If the
	 * value is not found, it returns -1.
	 * @param arr array to search
	 * @param n value to find
	 * @return Index of element (-1 if not found)
	 */
	public static int sequentialSearch(int[] arr, int n)
	{
		return sequentialSearch(arr, 0, arr.length, n);
	}
	
}
