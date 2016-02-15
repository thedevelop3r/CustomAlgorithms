package CustomAlgorithms;

import java.util.ArrayList;
import java.util.List;

public class CustomLists
{
	// Searches
		// --------------------------------------------------------------

		/**
		 * The sequentialSearch method searches the given list from start to finish
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
		 * @param list Array to search
		 * @param n Value to search for
		 * @param from starting index (inclusive)
		 * @param to ending index (exclusive)
		 * @return Index of element (-1 if not found)
		 */
		public static <T extends Comparable<? super T>> int sequentialSearch(List<T> list, int from, int to, T n)
		{
			for (int i = from; i < to; i++)
			{
				if (list.get(i).compareTo((T) n) == 0)
				{
					return i;
				}
			}
			return -1;
		}

		/**
		 * The binarySearchIterative method searches a pre-sorted list for a given
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
		 * @param list Array to search
		 * @param n Value to search for
		 * @param from starting value (inclusive)
		 * @param to ending value (exclusive)
		 * @return Index of element (-1 if not found)
		 */
		public static <T extends Comparable<? super T>> int binarySearch(List<T> list, int from, int to, T n)
		{
			to--;

			while (from <= to)
			{
				int middle = (from + to) / 2;

				if (list.get(middle).compareTo(n) == 0)
					return middle;
				else if (n.compareTo(list.get(middle)) > 0)
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
		 * @param list List to sort
		 * @param from starting index (inclusive)
		 * @param to ending index (exclusive)
		 */
		public static <T extends Comparable<? super T>> void bubbleSort(List<T> list, int from, int to)
		{
			for (int i = from; i < to; i++)
			{
				for (int j = from + 1; j < to; j++)
				{
					// swap if in the wrong order
					if (list.get(j).compareTo((T) list.get(j - 1)) < 0)
					{
						swap(list, j, j - 1);
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
		 * @param list List to sort
		 * @param from starting index (inclusive)
		 * @param to ending index (exclusive)
		 */
		public static <T extends Comparable<? super T>> void selectionSort(List<T> list, int from, int to)
		{
			int sortedIndex = from;

			while (sortedIndex < to)
			{
				int minIndex = sortedIndex;

				// find the min value
				for (int i = sortedIndex; i < to; i++)
				{
					if (list.get(minIndex).compareTo((T) list.get(i)) > 0)
					{
						minIndex = i;
					}
				}

				swap(list, minIndex, sortedIndex);

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
		 * @param list List to sort
		 * @param from starting index (inclusive)
		 * @param to ending index (exclusive)
		 */
		public static <T extends Comparable<? super T>> void insertionSort(List<T> list, int from, int to)
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
					if (list.get(i).compareTo((T) list.get(j)) < 0)
					{
						insert(list, j, list.get(i));
						inserted = true;
					}
					else if (j == sortedIndex - 1)
					{
						insert(list, sortedIndex, list.get(i));
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
		 * @param <T> Comparable type
		 * @param list List to sort
		 * @param from starting index (inclusive)
		 * @param to ending index (exclusive)
		 */
		public static <T extends Comparable<? super T>> void mergeSort(List<T> list, int from, int to)
		{
			if (to - from > 1)
			{
				mergeSort(list, from, (from + to) / 2);
				mergeSort(list, (from + to) / 2, to);
			}
			merge(list, from, (from + to) / 2, to);
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
		 * @param list List to sort
		 * @param from starting index (inclusive)
		 * @param to ending index (exclusive)
		 */
		public static <T extends Comparable<? super T>> void quickSort(List<T> list, int from, int to)
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
					if (list.get(left).compareTo((T) list.get(pivot)) <= 0)
					{
						left++;
					}
					// sweep left to find value less than pivot
					else if (list.get(right).compareTo((T) list.get(pivot)) >= 0)
					{
						right--;
					}
					else
					{
						swap(list, right, left);
						left++;
						right--;
					}
				}

				// place pivot in correct position
				// place pivot 1 less than left index if less than left index value
				if (list.get(pivot).compareTo((T) list.get(left)) < 0)
				{
					swap(list, pivot, left - 1);
					pivot = left - 1;
				}
				// plase pivot at left index if greater than or equal to left index
				// value
				else
				{
					swap(list, pivot, left);
					pivot = left;
				}

				// recursively sort remaining partitions
				quickSort(list, from, pivot);
				quickSort(list, pivot + 1, to);
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
		 * @param list List to sort
		 * @param from starting index (inclusive)
		 * @param to ending index (exclusive)
		 */
		public static <T extends Comparable<? super T>> void heapSort(List<T> list, int from, int to)
		{
			maxHeapify(list, from, to);
			for (int i = to - 1; i > from; i--)
			{
				swap(list, from, i);
				siftDown(list, from, i);
			}
		}

		// Helper methods
		// ------------------------------------------------------------------

		/**
		 * The isSorted method checks if an list is sorted ascending or descending.
		 * @param <T> Comparable type
		 * @param list Array to check
		 * @param ascending Check ascending (true) or Check descending (false)
		 * @return is the list in the specified ordering
		 */
		public static <T extends Comparable<? super T>> boolean isSorted(List<T> list, boolean ascending)
		{
			for (int i = 0; i < list.size() - 1; i++)
			{
				if ((list.get(i).compareTo((T) list.get(i + 1)) > 0) == ascending)
				{
					return false;
				}
			}
			return true;
		}

		/**
		 * The swap method swaps elements in the two specified list indices.
		 * @param <T> Comparable type
		 * @param list Array to swap elements of
		 * @param index1 first index to swap
		 * @param index2 second index to swap
		 */
		public static <T extends Comparable<? super T>> void swap(List<T> list, int index1, int index2)
		{
			T temp = list.get(index1);
			list.set(index1, list.get(index2));
			list.set(index2, temp);
		}

		/**
		 * The insert method shifts all elements 1 to the left of the specified
		 * index and inserts the given value at that index.
		 * @param <T> Comparable type
		 * @param list Array to insert element in
		 * @param index Index to insert element at
		 * @param n Value to insert
		 */
		public static <T extends Comparable<? super T>> void insert(List<T> list, int index, T n)
		{
			// shift elements 1 to the right
			for (int i = list.size() - 1; i > index; i--)
			{
				list.set(i, list.get(i - 1));
			}
			list.set(index, n);
		}

		/**
		 * The merge method merges two sorted sub-lists contained in a given list
		 * back into that given list. The sub-lists are defined by the specified
		 * indices.
		 * @param <T> Comparable type
		 * @param list Array to merge sub-lists in to
		 * @param from start index (inclusive in first half)
		 * @param middle middle index (inclusive in second half, exclusive in first
		 *        half)
		 * @param to end index (not inclusive)
		 */
		public static <T extends Comparable<? super T>> void merge(List<T> list, int from, int middle, int to)
		{
			// create temp array list
			ArrayList<T> tempArr = new ArrayList<T>(to - from);
			
			for (int i = 0; i < to - from; i++)
				tempArr.add(null);
			
			int i = from;
			int j = middle;

			// merge sorted list stacks in sorted order
			int k = 0;
			while (i < middle && j < to)
			{
				if (list.get(i).compareTo((T) list.get(j)) < 0)
				{
					tempArr.set(k, list.get(i));
					i++;
				}
				else
				{
					tempArr.set(k, list.get(j));
					j++;
				}

				k++;
			}
			
			// finish merging left stack
			while (i < middle)
			{
				tempArr.set(k, list.get(i));
				i++;
				k++;
			}

			// finish merging right stack
			while (j < to)
			{
				tempArr.set(k, list.get(j));
				j++;
				k++;
			}

			// put temp back into main list
			for (i = 0; i < tempArr.size(); i++)
			{
				list.set(from + i, tempArr.get(i));
			}
		}

		/**
		 * The maxHeapify method creates a max heap data structure out of a given
		 * list.
		 * @param <T> Comparable type
		 * @param list Array to heapify in max ordering
		 * @param from starting index (inclusive)
		 * @param to index to end heap data structure at (not inclusive)
		 */
		public static <T extends Comparable<? super T>> void maxHeapify(List<T> list, int from, int to)
		{
			// build a max heap for the given portion of the list by maxHeapifying
			// the sub-heaps beginning on the lowest layer (starting at index to /
			// 2) of sub-heaps in the portion with children nodes
			// and working backwards up the list
			for (int i = to / 2; i >= from; i--)
			{
				siftDown(list, i, to);
			}
		}

		/**
		 * The siftUp method corrects the ordering in a portion of a max heap data
		 * structure iteratively.
		 * @param <T> Comparable type
		 * @param list Array to correct ordering of max heap portion in
		 * @param from parent index (inclusive)
		 * @param to ending index for heapifying (not inclusive)
		 */
		public static <T extends Comparable<? super T>> void siftDown(List<T> list, int from, int to)
		{
			// get child nodes of from index
			int left = 2 * from + 1;
			int right = 2 * from + 2;

			// move the maximum element found out of the staring parent and its
			// child up the heap until it is its the proper place
			while (left < to && right < to)
			{
				if (list.get(from).compareTo((T) list.get(left)) < 0 && list.get(left).compareTo((T) list.get(right)) > 0)
				{
					swap(list, from, left);
					from = left;
				}
				else if (list.get(from).compareTo((T) list.get(right)) < 0)
				{
					swap(list, from, right);
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
				if (list.get(from).compareTo((T) list.get(left)) < 0)
				{
					swap(list, from, left);
				}
			}
		}
		
		// Delegates
		// ---------------------------------------------------------------

		/**
		 * The bubbleSort method sorts an entire list using bubble sort.
		 * @param <T> Comparable type
		 * @param list list to sort
		 */
		public static <T extends Comparable<? super T>> void bubbleSort(List<T> list)
		{
			bubbleSort(list, 0, list.size());
		}

		/**
		 * The selectionSort method sorts an entire list using a selection sort.
		 * @param <T> Comparable type
		 * @param list list to sort
		 */
		public static <T extends Comparable<? super T>> void selectionSort(List<T> list)
		{
			selectionSort(list, 0, list.size());
		}

		/**
		 * The insertionSort method sorts an entire list using an insertion sort
		 * @param <T> Comparable type
		 * @param list list to sort
		 */
		public static <T extends Comparable<? super T>> void insertionSort(List<T> list)
		{
			insertionSort(list, 0, list.size());
		}

		/**
		 * The mergeSort method sorts an entire list using a merge sort
		 * @param <T> Comparable type
		 * @param list list to sort
		 */
		public static <T extends Comparable<? super T>> void mergeSort(List<T> list)
		{
			mergeSort(list, 0, list.size());
		}

		/**
		 * The quickSort method sorts an entire list using a single pivot quick
		 * sort
		 * @param <T> Comparable type
		 * @param list list to sort
		 */
		public static <T extends Comparable<? super T>> void quickSort(List<T> list)
		{
			quickSort(list, 0, list.size());
		}

		/**
		 * The heapSort method sorts an entire list using a max-heap based heap
		 * sort
		 * @param <T> Comparable type
		 * @param list list to sort
		 */
		public static <T extends Comparable<? super T>> void heapSort(List<T> list)
		{
			heapSort(list, 0, list.size());
		}

		/**
		 * The binarySearchIterative method searches a pre-sorted list for a given
		 * value using an iterative implementation of the binary search algorithm.
		 * If the value is not found, it returns -1.
		 * @param <T> Comparable type
		 * @param list Array to search
		 * @param n Value to search for
		 * @return Index of element (-1 if not found)
		 */
		public static <T extends Comparable<? super T>> int binarySearch(List<T> list, T n)
		{
			return binarySearch(list, 0, list.size(), n);
		}

		/**
		 * The sequentialSearch method searches the given list from start to finish
		 * and returns the first index at which it finds the specified value. If the
		 * value is not found, it returns -1.
		 * @param <T> Comparable type
		 * @param list list to search
		 * @param n value to find
		 * @return Index of element (-1 if not found)
		 */
		public static <T extends Comparable<? super T>> int sequentialSearch(List<T> list, T n)
		{
			return sequentialSearch(list, 0, list.size(), n);
		}
}
