import static org.junit.Assert.*;

import org.junit.Test;

import CustomAlgorithms.CustomArrays;

public class CustomArraysSortsTest
{

	// Test swap method
	// ---------------------------------------------------------------------------

	@Test
	public void testSwap()
	{
		Integer[] arr = new Integer[] {0,1};
		Integer[] result = new Integer[]{1,0};
		
		CustomArrays.swap(arr, 0, 1);
		
		for (Integer i = 0; i < arr.length; i++)
		{
			assertEquals("All array values should be as" + " specified in result array", arr[i], result[i]);
		}
	}
	
	// Test isSorted method
	// --------------------------------------------------------------------------
	
	@Test
	public void testIsSortedAscending()
	{
		Integer[] arr = new Integer[] {0,1,2};
		assertTrue(CustomArrays.isSorted(arr, true));
	}
	
	@Test
	public void testIsSortedDescending()
	{
		Integer[] arr = new Integer[] {2,1,0};
		assertTrue(CustomArrays.isSorted(arr, false));
	}
	
	@Test
	public void testIsSortedNotSorted()
	{
		Integer[] arr = new Integer[] {2,1,2};
		assertFalse(CustomArrays.isSorted(arr, true));
		assertFalse(CustomArrays.isSorted(arr,  false));
	}

	// Test Bubble Sort
	// --------------------------------------------------------------------------

	@Test
	public void testBubbleSortOdd()
	{
		Integer[] arr = new Integer[] { 5, 4, 3, 2, 1 };
		Integer[] result = new Integer[] { 1, 2, 3, 4, 5 };

		CustomArrays.bubbleSort(arr);

		for (Integer i = 0; i < arr.length; i++)
		{
			assertEquals("All array values should be as" + " specified in result array", arr[i], result[i]);
		}
	}

	@Test
	public void testBubbleSortEven()
	{
		Integer[] arr = new Integer[] { 5, 4, 3, 2 };
		Integer[] result = new Integer[] { 2, 3, 4, 5 };

		CustomArrays.bubbleSort(arr);

		for (Integer i = 0; i < arr.length; i++)
		{
			assertEquals("All array values should be as" + " specified in result array", arr[i], result[i]);
		}
	}

	// Test Selection Sort
	// --------------------------------------------------------------------------

	@Test
	public void testSelectionSortOdd()
	{
		Integer[] arr = new Integer[] { 5, 4, 3, 2, 1 };
		Integer[] result = new Integer[] { 1, 2, 3, 4, 5 };

		CustomArrays.selectionSort(arr);

		for (Integer i = 0; i < arr.length; i++)
		{
			assertEquals("All array values should be as" + " specified in result array", arr[i], result[i]);
		}
	}

	@Test
	public void testSelectionSortEven()
	{
		Integer[] arr = new Integer[] { 5, 4, 3, 2 };
		Integer[] result = new Integer[] { 2, 3, 4, 5 };

		CustomArrays.selectionSort(arr);

		for (Integer i = 0; i < arr.length; i++)
		{
			assertEquals("All array values should be as" + " specified in result array", arr[i], result[i]);
		}
	}

	// Test Insertion Sort
	// --------------------------------------------------------------------------

	@Test
	public void testInsertionSortOdd()
	{
		Integer[] arr = new Integer[] { 5, 4, 3, 2, 1 };
		Integer[] result = new Integer[] { 1, 2, 3, 4, 5 };

		CustomArrays.insertionSort(arr);

		for (Integer i = 0; i < arr.length; i++)
		{
			assertEquals("All array values should be as" + " specified in result array", arr[i], result[i]);
		}
	}

	@Test
	public void testInsertionSortEven()
	{
		Integer[] arr = new Integer[] { 5, 4, 3, 2 };
		Integer[] result = new Integer[] { 2, 3, 4, 5 };

		CustomArrays.insertionSort(arr);

		for (Integer i = 0; i < arr.length; i++)
		{
			assertEquals("All array values should be as" + " specified in result array", arr[i], result[i]);
		}
	}

	// Test Merge method
	// ---------------------------------------------------------------------------

	@Test
	public void testMergeCompleteEven()
	{
		Integer[] arr = new Integer[] { 3, 4, 1, 2 };
		Integer[] result = new Integer[] { 1, 2, 3, 4 };

		CustomArrays.merge(arr, 0, 2, 4);

		for (Integer i = 0; i < arr.length; i++)
		{
			assertEquals("All array values should be as" + " specified in result array", arr[i], result[i]);
		}
	}

	@Test
	public void testMergeCompleteOdd()
	{
		Integer[] arr = new Integer[] { 2, 3, 1 };
		Integer[] result = new Integer[] { 1, 2, 3 };

		CustomArrays.merge(arr, 0, 2, 3);

		for (Integer i = 0; i < arr.length; i++)
		{
			assertEquals("All array values should be as" + " specified in result array", arr[i], result[i]);
		}
	}

	@Test
	public void testMergePartial()
	{
		Integer[] arr = new Integer[] { 1, 2, 3, 4, 1, 2 };
		Integer[] result = new Integer[] { 1, 2, 1, 2, 3, 4 };

		CustomArrays.merge(arr, 2, 4, 6);

		for (Integer i = 0; i < arr.length; i++)
		{
			assertEquals("All array values should be as" + " specified in result array", arr[i], result[i]);
		}
	}

	@Test
	public void testMergeSingle()
	{
		Integer[] arr = new Integer[] { 1, 2, 3, 4, 1, 2 };
		Integer[] result = new Integer[] { 1, 2, 1, 2, 3, 4 };

		CustomArrays.merge(arr, 2, 4, 6);

		for (Integer i = 0; i < arr.length; i++)
		{
			assertEquals("All array values should be as" + " specified in result array", arr[i], result[i]);
		}
	}

	// Test Merge Sort
	// -----------------------------------------------------------------------------------

	@Test
	public void testMergeSortOdd()
	{
		Integer[] arr = new Integer[] { 5, 4, 3, 2, 1 };
		Integer[] result = new Integer[] { 1, 2, 3, 4, 5 };

		CustomArrays.mergeSort(arr, 0, arr.length);

		for (Integer i = 0; i < arr.length; i++)
		{
			assertEquals("All array values should be as" + " specified in result array", arr[i], result[i]);
		}
	}

	@Test
	public void testMergeSortEven()
	{
		Integer[] arr = new Integer[] { 5, 4, 3, 2 };
		Integer[] result = new Integer[] { 2, 3, 4, 5 };

		CustomArrays.mergeSort(arr, 0, arr.length);

		for (Integer i = 0; i < arr.length; i++)
		{
			assertEquals("All array values should be as" + " specified in result array", arr[i], result[i]);
		}
	}

	@Test
	public void testMergeCustomArraysingle()
	{
		Integer[] arr = new Integer[] { 1 };
		Integer[] result = new Integer[] { 1 };

		CustomArrays.mergeSort(arr, 0, arr.length);

		for (Integer i = 0; i < arr.length; i++)
		{
			assertEquals("All array values should be as" + " specified in result array", arr[i], result[i]);
		}
	}

	@Test
	public void testMergeSortDouble()
	{
		Integer[] arr = new Integer[] { 2, 1 };
		Integer[] result = new Integer[] { 1, 2 };

		CustomArrays.mergeSort(arr, 0, arr.length);

		for (Integer i = 0; i < arr.length; i++)
		{
			assertEquals("All array values should be as" + " specified in result array", arr[i], result[i]);
		}
	}

	// Test Quick Sort
	// ------------------------------------------------------------------------------

	@Test
	public void testQuickSortOdd()
	{
		Integer[] arr = new Integer[] { 5, 4, 3, 2, 1 };
		Integer[] result = new Integer[] { 1, 2, 3, 4, 5 };

		CustomArrays.quickSort(arr, 0, arr.length);

		for (Integer i = 0; i < arr.length; i++)
		{
			assertEquals("All array values should be as" + " specified in result array", arr[i], result[i]);
		}
	}

	@Test
	public void testQuickSortEven()
	{
		Integer[] arr = new Integer[] { 5, 4, 3, 2 };
		Integer[] result = new Integer[] { 2, 3, 4, 5 };

		CustomArrays.quickSort(arr, 0, arr.length);

		for (Integer i = 0; i < arr.length; i++)
		{
			assertEquals("All array values should be as" + " specified in result array", arr[i], result[i]);
		}
	}

	@Test
	public void testQuickCustomArraysingle()
	{
		Integer[] arr = new Integer[] { 1 };
		Integer[] result = new Integer[] { 1 };

		CustomArrays.quickSort(arr, 0, arr.length);

		for (Integer i = 0; i < arr.length; i++)
		{
			assertEquals("All array values should be as" + " specified in result array", arr[i], result[i]);
		}
	}

	@Test
	public void testQuickSortDouble()
	{
		Integer[] arr = new Integer[] { 2, 1 };
		Integer[] result = new Integer[] { 1, 2 };

		CustomArrays.quickSort(arr, 0, arr.length);

		for (Integer i = 0; i < arr.length; i++)
		{
			assertEquals("All array values should be as" + " specified in result array", arr[i], result[i]);
		}
	}

	// Test maxHeapify
	// ---------------------------------------------------------------

	@Test
	public void testMaxHeapifyComplete()
	{
		Integer[] arr = new Integer[] { 0, 1, 2, 3, 4 };
		Integer[] result = new Integer[] { 4, 3, 2, 0, 1 };

		for (Integer i = arr.length / 2; i >= 0; i--)
		{
			CustomArrays.siftDown(arr, i, arr.length);
		}

		for (Integer i = 0; i < arr.length; i++)
		{
			assertEquals("All array values should be as specified in" + " result array to satisfy the heap property",
					arr[i], result[i]);
		}
	}

	@Test
	public void testMaxHeapifyPartial()
	{
		Integer[] arr = new Integer[] { 0, 1, 2, 3, 4 };
		Integer[] result = new Integer[] { 2, 1, 0, 3, 4 };

		CustomArrays.maxHeapify(arr, 0, 3);

		for (Integer i = 0; i < arr.length; i++)
		{
			assertEquals("All array values should be as specified in"
					+ " result array to satisfy the heap property for the partial array", arr[i], result[i]);
		}
	}

	// Test Heap Sort
	// ----------------------------------------------------------------

	@Test
	public void testHeapSortOdd()
	{
		Integer[] arr = new Integer[] { 5, 4, 3, 2, 1 };
		Integer[] result = new Integer[] { 1, 2, 3, 4, 5 };

		CustomArrays.heapSort(arr);

		for (Integer i = 0; i < arr.length; i++)
		{
			assertEquals("All array values should be as" + " specified in result array", arr[i], result[i]);
		}
	}

	@Test
	public void testHeapSortEven()
	{
		Integer[] arr = new Integer[] { 5, 4, 3, 2 };
		Integer[] result = new Integer[] { 2, 3, 4, 5 };

		CustomArrays.heapSort(arr);

		for (Integer i = 0; i < arr.length; i++)
		{
			assertEquals("All array values should be as" + " specified in result array", arr[i], result[i]);
		}
	}

	@Test
	public void testHeapCustomArraysingle()
	{
		Integer[] arr = new Integer[] { 1 };
		Integer[] result = new Integer[] { 1 };

		CustomArrays.heapSort(arr);

		for (Integer i = 0; i < arr.length; i++)
		{
			assertEquals("All array values should be as" + " specified in result array", arr[i], result[i]);
		}
	}

	@Test
	public void testHeapSortDouble()
	{
		Integer[] arr = new Integer[] { 2, 1 };
		Integer[] result = new Integer[] { 1, 2 };

		CustomArrays.heapSort(arr);

		for (Integer i = 0; i < arr.length; i++)
		{
			assertEquals("All array values should be as" + " specified in result array", arr[i], result[i]);
		}
	}
}
