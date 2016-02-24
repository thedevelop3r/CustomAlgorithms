package CustomAlgorithms;

/**
 * The CustomArrays class provides an API for searching, sorting, and
 * manipulating arrays of Comparable references
 * @author Robert James Meade
 * @version 0.3
 */
public class CustomArrays
{

	// Searches
	// --------------------------------------------------------------

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
	 * @param <T> Comparable type
	 * @param arr Array to search
	 * @param n Value to search for
	 * @param from starting index (inclusive)
	 * @param to ending index (exclusive)
	 * @return Index of element (-1 if not found)
	 */
	public static <T extends Comparable<? super T>> int sequentialSearch(Comparable<T>[] arr, int from, int to,
			Comparable<T> n)
	{
		for (int i = from; i < to; i++)
		{
			if (arr[i].compareTo((T) n) == 0)
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
	 * @param <T> Comparable type
	 * @param arr Array to search
	 * @param n Value to search for
	 * @param from starting value (inclusive)
	 * @param to ending value (exclusive)
	 * @return Index of element (-1 if not found)
	 */
	public static <T extends Comparable<? super T>> int binarySearch(Comparable<T>[] arr, int from, int to,
			Comparable<T> n)
	{
		to--;

		while (from <= to)
		{
			int middle = (from + to) / 2;

			if (arr[middle].compareTo((T) n) == 0)
				return middle;
			else if (n.compareTo((T) arr[middle]) > 0)
				from = middle + 1;
			else
				to = middle - 1;
		}
		return -1;
	}

	// Sorts
	// -----------------------------------------------------

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
	 * @param <T> Comparable type
	 * @param arr Array to sort
	 * @param from starting index (inclusive)
	 * @param to ending index (exclusive)
	 */
	public static <T extends Comparable<? super T>> void bubbleSort(Comparable<T>[] arr, int from, int to)
	{
		for (int i = from; i < to; i++)
		{
			for (int j = from + 1; j < to; j++)
			{
				// swap if in the wrong order
				if (arr[j].compareTo((T) arr[j - 1]) < 0)
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
	 * @param <T> Comparable type
	 * @param arr Array to sort
	 * @param from starting index (inclusive)
	 * @param to ending index (exclusive)
	 */
	public static <T extends Comparable<? super T>> void selectionSort(Comparable<T>[] arr, int from, int to)
	{
		int sortedIndex = from;

		while (sortedIndex < to)
		{
			int minIndex = sortedIndex;

			// find the min value
			for (int i = sortedIndex; i < to; i++)
			{
				if (arr[minIndex].compareTo((T) arr[i]) > 0)
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
	 * @param <T> Comparable type
	 * @param arr Array to sort
	 * @param from starting index (inclusive)
	 * @param to ending index (exclusive)
	 */
	public static <T extends Comparable<? super T>> void insertionSortListOptimized(Comparable<T>[] arr, int from, int to)
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
				if (arr[i].compareTo((T) arr[j]) < 0)
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
	public static <T extends Comparable<? super T>> void insertionSortArrayOptimized(Comparable<T>[] arr, int from, int to)
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

				if (arr[i].compareTo((T) arr[j]) < 0)
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
	 * @param <T> Comparable type
	 * @param arr Array to sort
	 * @param from starting index (inclusive)
	 * @param to ending index (exclusive)
	 */
	public static <T extends Comparable<? super T>> void mergeSort(Comparable<T>[] arr, int from, int to)
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
	 * @param <T> Comparable type
	 * @param arr Array to sort
	 * @param from starting index (inclusive)
	 * @param to ending index (exclusive)
	 */
	public static <T extends Comparable<? super T>> void quickSort(Comparable<T>[] arr, int from, int to)
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
				if (arr[left].compareTo((T) arr[pivot]) <= 0)
				{
					left++;
				}
				// sweep left to find value less than pivot
				else if (arr[right].compareTo((T) arr[pivot]) >= 0)
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
			if (arr[pivot].compareTo((T) arr[left]) < 0)
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
	 * The heapSort method implements heap Sort, An in place sorting algorithm
	 * invented by J. W. J. Williams in 1964. This implementation is not stable
	 * (the original ordering is not necessarily preserved). \nRunning time:
	 * <ul>
	 * <li>average: O(n log n)</li>
	 * <li>worst: O(n log n)</li>
	 * <li>best: O(n log n)</li>
	 * </ul>
	 * Memory Usage:
	 * <ul>
	 * <li>O(1)</li>
	 * </ul>
	 * @param <T> Comparable type
	 * @param arr Array to sort
	 * @param from starting index (inclusive)
	 * @param to ending index (exclusive)
	 */
	public static <T extends Comparable<? super T>> void heapSort(Comparable<T>[] arr, int from, int to)
	{
		maxHeapify(arr, from, to);
		for (int i = to - 1; i > from; i--)
		{
			swap(arr, from, i);
			siftDown(arr, from, i);
		}
	}

	// Helper methods
	// ------------------------------------------------------------------

	/**
	 * The isSorted method checks if an array is sorted ascending or descending.
	 * @param <T> Comparable type
	 * @param arr Array to check
	 * @param ascending Check ascending (true) or Check descending (false)
	 * @return is the array in the specified ordering
	 */
	public static <T extends Comparable<? super T>> boolean isSorted(Comparable<T>[] arr, boolean ascending)
	{
		for (int i = 0; i < arr.length - 1; i++)
		{
			if ((arr[i].compareTo((T) arr[i + 1]) > 0) == ascending)
			{
				return false;
			}
		}
		return true;
	}

	/**
	 * The swap method swaps elements in the two specified array indices.
	 * @param <T> Comparable type
	 * @param arr Array to swap elements of
	 * @param index1 first index to swap
	 * @param index2 second index to swap
	 */
	public static <T extends Comparable<? super T>> void swap(Comparable<T>[] arr, int index1, int index2)
	{
		Comparable<T> temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}

	/**
	 * The insert method shifts all elements 1 to the left of the specified
	 * index and inserts the given value at that index.
	 * @param <T> Comparable type
	 * @param arr Array to insert element in
	 * @param index Index to insert element at
	 * @param n Value to insert
	 */
	public static <T extends Comparable<? super T>> void insert(Comparable<T>[] arr, int index, Comparable<T> n)
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
	public static <T extends Comparable<? super T>> void partialInsert(Comparable<T>[] arr, int index1, int index2, Comparable<T> n)
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
	 * @param <T> Comparable type
	 * @param arr Array to merge sub-arrays in to
	 * @param from start index (inclusive in first half)
	 * @param middle middle index (inclusive in second half, exclusive in first
	 *        half)
	 * @param to end index (not inclusive)
	 */
	public static <T extends Comparable<? super T>> void merge(Comparable<T>[] arr, int from, int middle, int to)
	{
		// create temp array
		Comparable<T>[] tempArr = new Comparable[to - from];

		int i = from;
		int j = middle;

		// merge sorted array stacks in sorted order
		int k = 0;
		while (i < middle && j < to)
		{
			if (arr[i].compareTo((T) arr[j]) < 0)
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
	 * @param <T> Comparable type
	 * @param arr Array to heapify in max ordering
	 * @param from starting index (inclusive)
	 * @param to index to end heap data structure at (not inclusive)
	 */
	public static <T extends Comparable<? super T>> void maxHeapify(Comparable<T>[] arr, int from, int to)
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
	 * The siftUp method corrects the ordering in a portion of a max heap data
	 * structure iteratively.
	 * @param <T> Comparable type
	 * @param arr Array to correct ordering of max heap portion in
	 * @param from parent index (inclusive)
	 * @param to ending index for heapifying (not inclusive)
	 */
	public static <T extends Comparable<? super T>> void siftDown(Comparable<T>[] arr, int from, int to)
	{
		// get child nodes of from index
		int left = 2 * from + 1;
		int right = 2 * from + 2;

		// move the maximum element found out of the staring parent and its
		// child up the heap until it is its the proper place
		while (left < to && right < to)
		{
			if (arr[from].compareTo((T) arr[left]) < 0 && arr[left].compareTo((T) arr[right]) > 0)
			{
				swap(arr, from, left);
				from = left;
			}
			else if (arr[from].compareTo((T) arr[right]) < 0)
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
			if (arr[from].compareTo((T) arr[left]) < 0)
			{
				swap(arr, from, left);
			}
		}
	}

	// UI methods
	// ---------------------------------------------------------

	/**
	 * The printArray method prints an Comparable[] array in the format
	 * [a,b,c,...,n]
	 * @param <T> Comparable type
	 * @param arr Array to print
	 */
	public static <T extends Comparable<? super T>> void printArray(Comparable<T>[] arr)
	{
		String output = "[";
		for (Comparable<T> n : arr)
		{
			output += n + ",";
		}
		System.out.println(output.substring(0, output.length() - 1) + "]");
	}

	// Delegates
	// ---------------------------------------------------------------

	/**
	 * The bubbleSort method sorts an entire array using bubble sort.
	 * @param <T> Comparable type
	 * @param arr array to sort
	 */
	public static <T extends Comparable<? super T>> void bubbleSort(Comparable<T>[] arr)
	{
		bubbleSort(arr, 0, arr.length);
	}

	/**
	 * The selectionSort method sorts an entire array using a selection sort.
	 * @param <T> Comparable type
	 * @param arr array to sort
	 */
	public static <T extends Comparable<? super T>> void selectionSort(Comparable<T>[] arr)
	{
		selectionSort(arr, 0, arr.length);
	}

	/**
	 * The insertionSort method sorts an entire array using an insertion sort
	 * @param <T> Comparable type
	 * @param arr array to sort
	 */
	public static <T extends Comparable<? super T>> void insertionSortListOptimized(Comparable<T>[] arr)
	{
		insertionSortListOptimized(arr, 0, arr.length);
	}
	
	/**
	 * The insertionSort method sorts an entire array using an insertion sort
	 * @param <T> Comparable type
	 * @param arr array to sort
	 */
	public static <T extends Comparable<? super T>> void insertionSortArrayOptimized(Comparable<T>[] arr)
	{
		insertionSortArrayOptimized(arr, 0, arr.length);
	}

	/**
	 * The mergeSort method sorts an entire array using a merge sort
	 * @param <T> Comparable type
	 * @param arr array to sort
	 */
	public static <T extends Comparable<? super T>> void mergeSort(Comparable<T>[] arr)
	{
		mergeSort(arr, 0, arr.length);
	}

	/**
	 * The quickSort method sorts an entire array using a single pivot quick
	 * sort
	 * @param <T> Comparable type
	 * @param arr array to sort
	 */
	public static <T extends Comparable<? super T>> void quickSort(Comparable<T>[] arr)
	{
		quickSort(arr, 0, arr.length);
	}

	/**
	 * The heapSort method sorts an entire array using a max-heap based heap
	 * sort
	 * @param <T> Comparable type
	 * @param arr array to sort
	 */
	public static <T extends Comparable<? super T>> void heapSort(Comparable<T>[] arr)
	{
		heapSort(arr, 0, arr.length);
	}

	/**
	 * The binarySearchIterative method searches a pre-sorted array for a given
	 * value using an iterative implementation of the binary search algorithm.
	 * If the value is not found, it returns -1.
	 * @param <T> Comparable type
	 * @param arr Array to search
	 * @param n Value to search for
	 * @return Index of element (-1 if not found)
	 */
	public static <T extends Comparable<? super T>> int binarySearch(Comparable<T>[] arr, Comparable<T> n)
	{
		return binarySearch(arr, 0, arr.length, n);
	}

	/**
	 * The sequentialSearch method searches the given array from start to finish
	 * and returns the first index at which it finds the specified value. If the
	 * value is not found, it returns -1.
	 * @param <T> Comparable type
	 * @param arr array to search
	 * @param n value to find
	 * @return Index of element (-1 if not found)
	 */
	public static <T extends Comparable<? super T>> int sequentialSearch(Comparable<T>[] arr, Comparable<T> n)
	{
		return sequentialSearch(arr, 0, arr.length, n);
	}
}
