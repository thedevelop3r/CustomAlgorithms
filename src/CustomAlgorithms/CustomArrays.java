package CustomAlgorithms;
/**
 * The CustomArrays class provides an API for managing arrays via a collection
 * of static methods.
 * @author Robert James Meade
 * @version 0.1
 */
public class CustomArrays
{

	// Searching methods
	// ---------------------------------------------------------------------------------------------------------------------

	/**
	 * The sequentialSearch method searches an array for the first index of a
	 * value starting from index 0 and ending when the value if found. If the
	 * value is not found, it returns -1.
	 * @param myArray Array to search
	 * @param myValue Value to find
	 * @return First index of value
	 */
	public static int sequentialSearch(int[] myArray, int myValue)
	{
		for (int i = 0; i < myArray.length; i++)
		{
			if (myArray[i] == myValue)
			{
				return i;
			}
		}
		return -1;
	}

	/**
	 * The binarySearch method searches a sorted Array for the first index of a
	 * value by splitting the array until its length is 1. If the array is not
	 * sorted and/or the value is not in the array, -1 is returned.
	 * @param myArray Array to search
	 * @param myValue Value to find
	 * @return Index of Value
	 */
	public static int binarySearch(int[] myArray, int myValue)
	{
		if (isSorted(myArray))
		{
			// split the sorted array until the length is 1
			int startIndex = 0;
			int endIndex = myArray.length;
			while (startIndex < endIndex - 1)
			{
				int middle = (startIndex + endIndex) / 2;
				if (myValue >= myArray[middle])
				{
					startIndex = middle;
				}
				else
				{
					endIndex = middle;
				}
			}
			// if the value was found return it
			if (myArray[startIndex] == myValue)
			{
				return startIndex;
			}
			else
			{
				return -1;
			}
		}
		// if array is not sorted return -1
		else
		{
			return -1;
		}
	}

	// Sequential Sorting Methods
	// --------------------------------------------------------------------------------------------------------------------

	/**
	 * The isSorted method checks if an array's values are in order from least
	 * to greatest/
	 * @param myArray Array to verify is sorted
	 * @return Is the array sorted?
	 */
	public static boolean isSorted(int[] myArray)
	{
		for (int i = 0; i < myArray.length - 1; i++)
		{
			if (!(myArray[i] <= myArray[i + 1]))
			{
				return false;
			}
		}
		return true;
	}

	/**
	 * The bubbleSort method sorts an array by iterating through its length
	 * times (length^2 iterations) and switches elements that are in the wrong
	 * order each time to sort the array.
	 * @param myArray Array to sort.
	 */
	public static void bubbleSort(int[] myArray)
	{
		int temp;
		for (int i = 0; i < myArray.length; i++)
		{
			for (int j = 0; j < myArray.length - 1; j++)
			{
				if (myArray[j] > myArray[j + 1])
				{
					temp = myArray[j];
					myArray[j] = myArray[j + 1];
					myArray[j + 1] = temp;
				}
			}
		}
	}

	/**
	 * The selection sort pulls objects out of an array in descending order,
	 * population a new sorted array, and then sets the original array to the
	 * sorted array.
	 * @param myArray Array to sort.
	 */
	public static void selectionSort(int[] myArray)
	{
		int maxValue = -Integer.MAX_VALUE;
		int previousMaxValue = Integer.MAX_VALUE;

		// build working array
		int[] myTempArray = new int[myArray.length];
		for (int i = 0; i < myArray.length; i++)
		{
			myTempArray[i] = myArray[i];
		}

		// insert next largest value into myArray from working array
		int j = myTempArray.length - 1;
		while (j >= 0)
		{
			for (int i = 0; i < myTempArray.length; i++)
			{
				if (myTempArray[i] > maxValue && myTempArray[i] < previousMaxValue)
				{
					maxValue = myTempArray[i];
				}
			}
			myArray[j] = maxValue;
			j--;
			previousMaxValue = maxValue;
			maxValue = -Integer.MAX_VALUE;
		}
	}

	/**
	 * The insertionSort method implements a sequential sort using the
	 * insertionSort algorithm.
	 * @param myArray Array to sort.
	 */
	public static void insertionSort(int[] myArray)
	{
		int sortedLength = 0;
		int i = myArray.length - 1;
		while (sortedLength < myArray.length)
		{
			// iterate through sorted portion and insert element
			for (int j = 0; j < sortedLength; j++)
			{
				if (myArray[i] < myArray[j])
				{
					insert(myArray, j, myArray[i]);
				}
				else if (j == sortedLength - 1)
				{
					insert(myArray, j + 1, myArray[i]);
				}
			}
			sortedLength++;
		}
	}

	/**
	 * The insert method inserts a value into a given Array, shifting the values
	 * past the index to the right to make room for the new value. The method
	 * acts as a helper method for the insertionSort method.
	 * @param myArray Array in which to insert element
	 * @param myIndex Index in which to insert element
	 * @param myValue Element to insert
	 */
	public static void insert(int[] myArray, int myIndex, int myValue)
	{
		for (int i = myArray.length - 1; i > myIndex; i--)
		{
			myArray[i] = myArray[i - 1];
		}
		myArray[myIndex] = myValue;
	}

	// Non-sequential Recursive Sorting Methods
	// ------------------------------------------------------------------------------------------------------------------------------

	/**
	 * The mergeSort method uses the overloaded recursive mergeSort method to
	 * enact a mergeSort on the entire array instead of a specific section.
	 * @param myArray Array to mergeSort
	 */
	public static void mergeSort(int[] myArray)
	{
		mergeSort(myArray, 0, myArray.length);
	}

	/**
	 * The mergeSort method implements the merge sort algorithm as developed by
	 * @param myArray
	 * @param from
	 * @param to
	 */
	public static void mergeSort(int[] myArray, int from, int to)
	{
		// base case (1 or 2 elements); switch elements if necessary
		if (to - from < 2)
		{
			if (myArray.length != 1)
			{
				if (myArray[from] == myArray[to - 1])
				{
					// switch elements if not in order
					int temp = myArray[from];
					myArray[from] = myArray[to - 1];
					myArray[to - 1] = temp;
				}
				else
				{
					// pass if elements in order
				}
			}
			else
			{
				// pass if length of 1 instead of 2
			}
		}
		// recursive case
		else
		{
			int middle = (to + from) / 2;
			mergeSort(myArray, from, middle);
			mergeSort(myArray, middle, to);
			merge(myArray, from, middle, to);
		}
	}

	/**
	 * The merge method merges two sorted subArrays into the main Array in the
	 * correct order.
	 * @param myArray Array to merge in to
	 * @param from Starting index
	 * @param middle Middle Index
	 * @param to Ending index
	 */
	public static void merge(int myArray[], int from, int middle, int to)
	{
		int[] myTempArray = new int[to - from];
		int i = from;
		int j = middle;
		int k = 0;

		// merger two sorted halves into empty array in order least to greatest
		while (i < middle && j < to)
		{
			if (myArray[i] < myArray[j])
			{
				myTempArray[k] = myArray[i];
				i++;
			}
			else
			{
				myTempArray[k] = myArray[j];
				j++;
			}
			k++;
		}

		// add remaining elements in myArray[from, middle-1] temp array
		while (i < middle)
		{
			myTempArray[k] = myArray[i];
			i++;
			k++;
		}

		// add remaining elements in myArray[middle, to-1] to temp array
		while (j < to)
		{
			myTempArray[k] = myArray[j];
			j++;
			k++;
		}

		// merge temp array back into myArray
		for (int l = 0; l < myTempArray.length; l++)
		{
			myArray[l + from] = myTempArray[l];
		}
	}

	public static void quickSort(int[] myArray)
	{
		quickSort(myArray, 0, myArray.length);
	}

	/**
	 * The quickSort method implements a the quickSort algorithm as developed by
	 * C. A. R. Hoare in 1962.
	 * @param myArray Array to sort
	 */
	public static void quickSort(int[] myArray, int from, int to)
	{
		if (to - from > 1)
		{
			// pivot - index of pivot
			int pivot = from;
			// left - left cursor
			int left = from + 1;
			// right - right cursor
			int right = to - 1;

			// iterate inward from both sides of the array until the middle is
			// reached, swap elements so that they are going to be on the
			// proper side of the pivot
			while (left < right)
			{
				// sweep left
				if (myArray[left] <= myArray[pivot])
				{
					left++;
				}
				// sweep right
				else if (myArray[right] >= myArray[pivot])
				{
					right--;
				}
				// swap the elements to be on the right side of the pivot
				else
				{
					swap(myArray, left, right);
					left++;
					right--;
				}
			}

			// place pivot in proper place
			// place pivot at middle index if greater than middle index
			if (myArray[pivot] > myArray[left])
			{
				swap(myArray, left, pivot);
				pivot = left;
			}
			// place pivot directly left of middle index if less than the middle
			// index
			else
			{
				swap(myArray, left - 1, pivot);
				pivot = left - 1;
			}

			// make recursive calls to new sub arrays that exclude the pivot
			// index
			quickSort(myArray, from, pivot);
			quickSort(myArray, pivot + 1, to);
		}
	}

	/**
	 * The swap method swaps the places of two elements in an array.
	 * @param myArray Array in which to swap elements
	 * @param myIndex1 First index
	 * @param myIndex2 Second index
	 */
	public static void swap(int myArray[], int myIndex1, int myIndex2)
	{
		int temp = myArray[myIndex1];
		myArray[myIndex1] = myArray[myIndex2];
		myArray[myIndex2] = temp;
	}

	/**
	 * This was supposed to be a quick sort, but it always has n^2 iterations.
	 * It works off of the pivot idea, but it isn't the sort. I don't know what
	 * it is.
	 * @param myArray Array to sort
	 */
	public static void pivotSort(int[] myArray)
	{
		int p = myArray.length - 1;
		for (int i = 0; i < myArray.length; i++)
		{
			for (int j = 0; j < myArray.length; j++)
			{
				if (p > j)
				{
					if (myArray[p] <= myArray[j])
					{
						swap(myArray, p, j);
					}
				}
				else
				{
					if (myArray[p] >= myArray[j])
					{
						swap(myArray, p, j);
					}
				}
			}
			p--;
		}
	}

	public static void heapSort(int[] myArray)
	{
	}

	public static void radixSort(int[] myArray)
	{
	}
}
