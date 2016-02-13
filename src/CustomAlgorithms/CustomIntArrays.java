package CustomAlgorithms;

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
	 * value is not found, it returns -1. Running time:
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
	 * @param n Value to search for
	 * @return Index of element (-1 if not found)
	 */
	public static int sequentialSearch(int[] arr, int n)
	{
		for (int i = 0; i < arr.length; i++)
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
	 * @return Index of element (-1 if not found)
	 */
	public static int binarySearchIterative(int[] arr, int n)
	{
		int to = arr.length - 1;
		int from = 0;

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

	/**
	 * The binarySearchRecursive method searches a pre-sorted array for a given
	 * value using an recursive implementation of the binary search algorithm.
	 * If the value is not found, it returns -1. Running time:
	 * <ul>
	 * <li>average: O(n log n)</li>
	 * <li>worst O(n log n)</li>
	 * <li>best O(1)</li>
	 * </ul>
	 * Memory Usage:
	 * <ul>
	 * <li>O(1)</li>
	 * </ul>
	 * @param arr Array to search
	 * @param n Value to search for
	 * @return Index of element (-1 if not found)
	 */
	public static int binarySearchRecursive(int[] arr, int n)
	{
		return binarySearchRecursive(arr, 0, arr.length - 1, n);
	}

	/**
	 * The binarySearchRecursive method searches a pre-sorted array for a given
	 * value using an recursive implementation of the binary search algorithm.
	 * If the value is not found, it returns -1. Running time:
	 * <ul>
	 * <li>average: O(n log n)</li>
	 * <li>worst O(n log n)</li>
	 * <li>best O(1)t</li>
	 * </ul>
	 * Memory Usage:
	 * <ul>
	 * <li>O(1)</li>
	 * </ul>
	 * @param arr Array to search
	 * @param n Value to search for
	 * @param from starting index (inclusive)
	 * @param to ending index (inclusive)
	 * @return Index of element (-1 if not found)
	 */
	public static int binarySearchRecursive(int[] arr, int from, int to, int n)
	{
		int middle = (to + from) / 2;

		if (arr[middle] == n)
			return middle;
		else if (from > to)
			return -1;
		else if (n > arr[middle])
			return binarySearchRecursive(arr, middle + 1, to, n);
		else
			return binarySearchRecursive(arr, from, middle - 1, n);
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
	 */
	public static void bubbleSort(int[] arr)
	{
		for (int i = 0; i < arr.length; i++)
		{
			for (int j = 1; j < arr.length; j++)
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
	 */
	public static void selectionSort(int[] arr)
	{
		int sortedIndex = 0;

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
	 */
	public static void insertionSort(int[] arr)
	{
		int sortedIndex = 0;
		int i = arr.length - 1;

		// build sorted portion
		while (sortedIndex < arr.length)
		{
			boolean inserted = false;

			// grab last element and insert
			int j = 0;
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
	 * The mergeSort method implements Merge Sort, A recursive, in place sorting
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
	 * The mergeSort method implements Merge Sort, A recursive, in place sorting
	 * algorithm invented by C.A.R Hoare in 1960. This implementation is not
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
	 */
	public static void heapSort(int[] arr)
	{
		int i = arr.length - 1;
		for (i = arr.length - 1; i > 0; i--)
		{
			maxHeapify(arr, i + 1);
			swap(arr, 0, i);
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

		for (int i = 0; i < tempArr.length; i++)
			tempArr[i] = arr[from + i];

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
	 * @param to index to end heap data structure at (not inclusive)
	 */
	public static void maxHeapify(int[] arr, int to)
	{
		// build a max heap for the given portion of the array by maxHeapifying
		// the sub-heaps beginning on the lowest layer (starting at index to /
		// 2) of sub-heaps in the portion with children nodes
		// and working backwards up the array
		for (int i = to / 2; i >= 0; i--)
		{
			siftUp(arr, i, to);
		}
	}

	/**
	 * The siftUp method corrects the ordering in a portion of a max heap data
	 * structure iteratively.
	 * @param arr Array to correct ordering of max heap portion in
	 * @param from parent index (inclusive)
	 * @param to ending index for heapifying (not inclusive)
	 */
	public static void siftUp(int[] arr, int from, int to)
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
}
