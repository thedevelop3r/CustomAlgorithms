import static org.junit.Assert.*;

import org.junit.Test;

import CustomAlgorithms.CustomIntArrays;

public class CustomIntArraysSortsTest
{

	// Test swap method
	// ---------------------------------------------------------------------------

	@Test
	public void testSwap()
	{
		int[] arr = new int[] {0,1};
		int[] result = new int[]{1,0};
		
		CustomIntArrays.swap(arr, 0, 1);
		
		for (int i = 0; i < arr.length; i++)
		{
			assertEquals("All array values should be as" + " specified in result array", arr[i], result[i]);
		}
	}
	
	// Test isSorted method
	// --------------------------------------------------------------------------
	
	@Test
	public void testIsSortedAscending()
	{
		int[] arr = new int[] {0,1,2};
		assertTrue(CustomIntArrays.isSorted(arr, true));
	}
	
	@Test
	public void testIsSortedDescending()
	{
		int[] arr = new int[] {2,1,0};
		assertTrue(CustomIntArrays.isSorted(arr, false));
	}
	
	@Test
	public void testIsSortedNotSorted()
	{
		int[] arr = new int[] {2,1,2};
		assertFalse(CustomIntArrays.isSorted(arr, true));
		assertFalse(CustomIntArrays.isSorted(arr,  false));
	}

	// Test Bubble Sort
	// --------------------------------------------------------------------------

	@Test
	public void testBubbleSortOdd()
	{
		int[] arr = new int[] { 5, 4, 3, 2, 1 };
		int[] result = new int[] { 1, 2, 3, 4, 5 };

		CustomIntArrays.bubbleSort(arr);

		for (int i = 0; i < arr.length; i++)
		{
			assertEquals("All array values should be as" + " specified in result array", arr[i], result[i]);
		}
	}

	@Test
	public void testBubbleSortEven()
	{
		int[] arr = new int[] { 5, 4, 3, 2 };
		int[] result = new int[] { 2, 3, 4, 5 };

		CustomIntArrays.bubbleSort(arr);

		for (int i = 0; i < arr.length; i++)
		{
			assertEquals("All array values should be as" + " specified in result array", arr[i], result[i]);
		}
	}

	// Test Selection Sort
	// --------------------------------------------------------------------------

	@Test
	public void testSelectionSortOdd()
	{
		int[] arr = new int[] { 5, 4, 3, 2, 1 };
		int[] result = new int[] { 1, 2, 3, 4, 5 };

		CustomIntArrays.selectionSort(arr);

		for (int i = 0; i < arr.length; i++)
		{
			assertEquals("All array values should be as" + " specified in result array", arr[i], result[i]);
		}
	}

	@Test
	public void testSelectionSortEven()
	{
		int[] arr = new int[] { 5, 4, 3, 2 };
		int[] result = new int[] { 2, 3, 4, 5 };

		CustomIntArrays.selectionSort(arr);

		for (int i = 0; i < arr.length; i++)
		{
			assertEquals("All array values should be as" + " specified in result array", arr[i], result[i]);
		}
	}

	// Test Insertion Sort
	// --------------------------------------------------------------------------

	@Test
	public void testInsertionSortOdd()
	{
		int[] arr = new int[] { 5, 4, 3, 2, 1 };
		int[] result = new int[] { 1, 2, 3, 4, 5 };

		CustomIntArrays.insertionSort(arr);

		for (int i = 0; i < arr.length; i++)
		{
			assertEquals("All array values should be as" + " specified in result array", arr[i], result[i]);
		}
	}

	@Test
	public void testInsertionSortEven()
	{
		int[] arr = new int[] { 5, 4, 3, 2 };
		int[] result = new int[] { 2, 3, 4, 5 };

		CustomIntArrays.insertionSort(arr);

		for (int i = 0; i < arr.length; i++)
		{
			assertEquals("All array values should be as" + " specified in result array", arr[i], result[i]);
		}
	}

	// Test Merge method
	// ---------------------------------------------------------------------------

	@Test
	public void testMergeCompleteEven()
	{
		int[] arr = new int[] { 3, 4, 1, 2 };
		int[] result = new int[] { 1, 2, 3, 4 };

		CustomIntArrays.merge(arr, 0, 2, 4);

		for (int i = 0; i < arr.length; i++)
		{
			assertEquals("All array values should be as" + " specified in result array", arr[i], result[i]);
		}
	}

	@Test
	public void testMergeCompleteOdd()
	{
		int[] arr = new int[] { 2, 3, 1 };
		int[] result = new int[] { 1, 2, 3 };

		CustomIntArrays.merge(arr, 0, 2, 3);

		for (int i = 0; i < arr.length; i++)
		{
			assertEquals("All array values should be as" + " specified in result array", arr[i], result[i]);
		}
	}

	@Test
	public void testMergePartial()
	{
		int[] arr = new int[] { 1, 2, 3, 4, 1, 2 };
		int[] result = new int[] { 1, 2, 1, 2, 3, 4 };

		CustomIntArrays.merge(arr, 2, 4, 6);

		for (int i = 0; i < arr.length; i++)
		{
			assertEquals("All array values should be as" + " specified in result array", arr[i], result[i]);
		}
	}

	@Test
	public void testMergeSingle()
	{
		int[] arr = new int[] { 1, 2, 3, 4, 1, 2 };
		int[] result = new int[] { 1, 2, 1, 2, 3, 4 };

		CustomIntArrays.merge(arr, 2, 4, 6);

		for (int i = 0; i < arr.length; i++)
		{
			assertEquals("All array values should be as" + " specified in result array", arr[i], result[i]);
		}
	}

	// Test Merge Sort
	// -----------------------------------------------------------------------------------

	@Test
	public void testMergeSortOdd()
	{
		int[] arr = new int[] { 5, 4, 3, 2, 1 };
		int[] result = new int[] { 1, 2, 3, 4, 5 };

		CustomIntArrays.mergeSort(arr, 0, arr.length);

		for (int i = 0; i < arr.length; i++)
		{
			assertEquals("All array values should be as" + " specified in result array", arr[i], result[i]);
		}
	}

	@Test
	public void testMergeSortEven()
	{
		int[] arr = new int[] { 5, 4, 3, 2 };
		int[] result = new int[] { 2, 3, 4, 5 };

		CustomIntArrays.mergeSort(arr, 0, arr.length);

		for (int i = 0; i < arr.length; i++)
		{
			assertEquals("All array values should be as" + " specified in result array", arr[i], result[i]);
		}
	}

	@Test
	public void testMergeCustomIntArraysingle()
	{
		int[] arr = new int[] { 1 };
		int[] result = new int[] { 1 };

		CustomIntArrays.mergeSort(arr, 0, arr.length);

		for (int i = 0; i < arr.length; i++)
		{
			assertEquals("All array values should be as" + " specified in result array", arr[i], result[i]);
		}
	}

	@Test
	public void testMergeSortDouble()
	{
		int[] arr = new int[] { 2, 1 };
		int[] result = new int[] { 1, 2 };

		CustomIntArrays.mergeSort(arr, 0, arr.length);

		for (int i = 0; i < arr.length; i++)
		{
			assertEquals("All array values should be as" + " specified in result array", arr[i], result[i]);
		}
	}

	// Test Quick Sort
	// ------------------------------------------------------------------------------

	@Test
	public void testQuickSortOdd()
	{
		int[] arr = new int[] { 5, 4, 3, 2, 1 };
		int[] result = new int[] { 1, 2, 3, 4, 5 };

		CustomIntArrays.quickSort(arr, 0, arr.length);

		for (int i = 0; i < arr.length; i++)
		{
			assertEquals("All array values should be as" + " specified in result array", arr[i], result[i]);
		}
	}

	@Test
	public void testQuickSortEven()
	{
		int[] arr = new int[] { 5, 4, 3, 2 };
		int[] result = new int[] { 2, 3, 4, 5 };

		CustomIntArrays.quickSort(arr, 0, arr.length);

		for (int i = 0; i < arr.length; i++)
		{
			assertEquals("All array values should be as" + " specified in result array", arr[i], result[i]);
		}
	}

	@Test
	public void testQuickCustomIntArraysingle()
	{
		int[] arr = new int[] { 1 };
		int[] result = new int[] { 1 };

		CustomIntArrays.quickSort(arr, 0, arr.length);

		for (int i = 0; i < arr.length; i++)
		{
			assertEquals("All array values should be as" + " specified in result array", arr[i], result[i]);
		}
	}

	@Test
	public void testQuickSortDouble()
	{
		int[] arr = new int[] { 2, 1 };
		int[] result = new int[] { 1, 2 };

		CustomIntArrays.quickSort(arr, 0, arr.length);

		for (int i = 0; i < arr.length; i++)
		{
			assertEquals("All array values should be as" + " specified in result array", arr[i], result[i]);
		}
	}

	// Test maxHeapify
	// ---------------------------------------------------------------

	@Test
	public void testMaxHeapifyComplete()
	{
		int[] arr = new int[] { 0, 1, 2, 3, 4 };
		int[] result = new int[] { 4, 3, 2, 0, 1 };

		for (int i = arr.length / 2; i >= 0; i--)
		{
			CustomIntArrays.siftDown(arr, i, arr.length);
		}

		for (int i = 0; i < arr.length; i++)
		{
			assertEquals("All array values should be as specified in" + " result array to satisfy the heap property",
					arr[i], result[i]);
		}
	}

	@Test
	public void testMaxHeapifyPartial()
	{
		int[] arr = new int[] { 0, 1, 2, 3, 4 };
		int[] result = new int[] { 2, 1, 0, 3, 4 };

		CustomIntArrays.maxHeapify(arr, 0, 3);

		for (int i = 0; i < arr.length; i++)
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
		int[] arr = new int[] { 5, 4, 3, 2, 1 };
		int[] result = new int[] { 1, 2, 3, 4, 5 };

		CustomIntArrays.heapSort(arr);

		for (int i = 0; i < arr.length; i++)
		{
			assertEquals("All array values should be as" + " specified in result array", arr[i], result[i]);
		}
	}

	@Test
	public void testHeapSortEven()
	{
		int[] arr = new int[] { 5, 4, 3, 2 };
		int[] result = new int[] { 2, 3, 4, 5 };

		CustomIntArrays.heapSort(arr);

		for (int i = 0; i < arr.length; i++)
		{
			assertEquals("All array values should be as" + " specified in result array", arr[i], result[i]);
		}
	}

	@Test
	public void testHeapCustomIntArraysingle()
	{
		int[] arr = new int[] { 1 };
		int[] result = new int[] { 1 };

		CustomIntArrays.heapSort(arr);

		for (int i = 0; i < arr.length; i++)
		{
			assertEquals("All array values should be as" + " specified in result array", arr[i], result[i]);
		}
	}

	@Test
	public void testHeapSortDouble()
	{
		int[] arr = new int[] { 2, 1 };
		int[] result = new int[] { 1, 2 };

		CustomIntArrays.heapSort(arr);

		for (int i = 0; i < arr.length; i++)
		{
			assertEquals("All array values should be as" + " specified in result array", arr[i], result[i]);
		}
	}

	// Test Binary Radix Sort (binary quick sort)
	// ----------------------------------------------------------------

	@Test
	public void testRadixSortOdd1Bit()
	{
		int[] arr = new int[] { 1, 1, 0, 0, 1 };// ,1,0,0,1,0,1,1,0,1,0};
		int[] result = new int[] { 0, 0, 1, 1, 1 };

		CustomIntArrays.binaryMSDRadixSort(arr, 0, arr.length, 0, -1);

		for (int i = 0; i < arr.length; i++)
		{
			assertEquals("All array values should be as" + " specified in result array", arr[i], result[i]);
		}
	}

	@Test
	public void testRadixSortEven1Bit()
	{
		int[] arr = new int[] { 1, 1, 0, 0, };
		int[] result = new int[] { 0, 0, 1, 1, };

		CustomIntArrays.binaryMSDRadixSort(arr, 0, arr.length, 0, -1);

		for (int i = 0; i < arr.length; i++)
		{
			assertEquals("All array values should be as" + " specified in result array", arr[i], result[i]);
		}
	}

	@Test
	public void testRadixSortOdd2Bit()
	{
		int[] arr = new int[] { 3, 1, 2, 3, 1, 2, 3 };
		int[] result = new int[] { 1, 1, 2, 2, 3, 3, 3 };

		CustomIntArrays.binaryMSDRadixSort(arr, 0, arr.length, 0, -1);

		for (int i = 0; i < arr.length; i++)
		{
			assertEquals("All array values should be as" + " specified in result array", arr[i], result[i]);
		}
	}

	@Test
	public void testRadixSortOdd3Bit()
	{
		int[] arr = new int[] { 3, 1, 2, 2, 7, 6, 3 };
		int[] result = new int[] { 1, 2, 2, 3, 3, 6, 7 };

		CustomIntArrays.binaryMSDRadixSort(arr, 0, arr.length, 0, -1);

		for (int i = 0; i < arr.length; i++)
		{
			assertEquals("All array values should be as" + " specified in result array", arr[i], result[i]);
		}
	}

	@Test
	public void testRadixSortOdd7Bit()
	{
		int[] arr = new int[] { 127, 1, 56, 32, 0, 5, 3 };
		int[] result = new int[] { 0, 1, 3, 5, 32, 56, 127 };

		CustomIntArrays.binaryMSDRadixSort(arr, 0, arr.length, 0, -1);

		for (int i = 0; i < arr.length; i++)
		{
			assertEquals("All array values should be as" + " specified in result array", arr[i], result[i]);
		}
	}

	// Test Decimal Radix Sort
	// -----------------------------------------------------

	@Test
	public void testDecimalLSDRadixSortEven1BitDecimal()
	{
		int[] arr = new int[] { 6, 4, 5, 6, 9, 8, 7, 0 };
		int[] result = new int[] { 0, 4, 5, 6, 6, 7, 8, 9 };

		CustomIntArrays.decimalLSDRadixSort(arr, 0, arr.length);
		
		for (int i = 0; i < arr.length; i++)
		{
			assertEquals("All array values should be as" + " specified in result array", arr[i], result[i]);
		}
	}
	
	@Test
	public void testDecimalLSDRadixSortOdd4BitDecimal()
	{
		int[] arr = new int[] { 2, 4, 5, 607, 9, 8, 7, 1000, 589 };
		int[] result = new int[] { 2,4,5,7,8,9,589,607,1000};

		CustomIntArrays.decimalLSDRadixSort(arr, 0, arr.length);
		
		for (int i = 0; i < arr.length; i++)
		{
			assertEquals("All array values should be as" + " specified in result array", arr[i], result[i]);
		}
	}
	
	// Test Hexadecimal Radix Sort
	// -----------------------------------------------------------
	
	@Test
	public void testHexadecimalLSDRadixSortEven1BitDecimal()
	{
		int[] arr = new int[] { 6, 4, 5, 6, 9, 8, 7, 0 };
		int[] result = new int[] { 0, 4, 5, 6, 6, 7, 8, 9 };

		CustomIntArrays.hexadecimalLSDRadixSort(arr, 0, arr.length);
		
		for (int i = 0; i < arr.length; i++)
		{
			assertEquals("All array values should be as" + " specified in result array", arr[i], result[i]);
		}
	}
	
	@Test
	public void testHexadecimalLSDRadixSortOdd4BitDecimal()
	{
		int[] arr = new int[] { 2, 4, 5, 607, 9, 8, 7, 1000, 589 };
		int[] result = new int[] { 2,4,5,7,8,9,589,607,1000};

		CustomIntArrays.hexadecimalLSDRadixSort(arr, 0, arr.length);
		
		for (int i = 0; i < arr.length; i++)
		{
			assertEquals("All array values should be as" + " specified in result array", arr[i], result[i]);
		}
	}
	
		// Test Hexadecimal Radix Sort (the MAYAN numbering system lol)
		// -----------------------------------------------------------
		
		@Test
		public void testDefinedLSDRadixSortEven1Bitdefined()
		{
			int[] arr = new int[] { 6, 4, 5, 6, 9, 8, 7, 0 };
			int[] result = new int[] { 0, 4, 5, 6, 6, 7, 8, 9 };

			CustomIntArrays.definedBucketsLSDRadixSort(arr, 0, arr.length, 20);
			
			for (int i = 0; i < arr.length; i++)
			{
				assertEquals("All array values should be as" + " specified in result array", arr[i], result[i]);
			}
		}
		
		@Test
		public void testDefinedLSDRadixSortOdd4Bitdefined()
		{
			int[] arr = new int[] { 2, 4, 5, 607, 9, 8, 7, 1000, 589 };
			int[] result = new int[] { 2,4,5,7,8,9,589,607,1000};

			CustomIntArrays.definedBucketsLSDRadixSort(arr, 0, arr.length, 20);
			
			for (int i = 0; i < arr.length; i++)
			{
				assertEquals("All array values should be as" + " specified in result array", arr[i], result[i]);
			}
		}
		
		

}
