import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import CustomAlgorithms.CustomLists;

public class CustomListsSortsTest
{

	// Test swap method
	// ---------------------------------------------------------------------------

	@Test
	public void testSwap()
	{
		List<Integer> list = new LinkedList<Integer> (Arrays.asList(new Integer[] {0,1}));
		List<Integer> result = new LinkedList<Integer>(Arrays.asList(new Integer[] {1,0}));
		
		CustomLists.swap(list, 0, 1);
		
		for (Integer i = 0; i < list.size(); i++)
		{
			assertEquals("All listay values should be as" + " specified in result listay", list.get(i), result.get(i));
		}
	}
	
	// Test isSorted method
	// --------------------------------------------------------------------------
	
	@Test
	public void testIsSortedAscending()
	{
		List<Integer> list = new LinkedList<Integer> (Arrays.asList(new Integer[] {0,1,2}));
		assertTrue(CustomLists.isSorted(list, true));
	}
	
	@Test
	public void testIsSortedDescending()
	{
		List<Integer> list = new LinkedList<Integer> (Arrays.asList(new Integer[] {2,1,0}));
		assertTrue(CustomLists.isSorted(list, false));
	}
	
	@Test
	public void testIsSortedNotSorted()
	{
		List<Integer> list = new LinkedList<Integer> (Arrays.asList(new Integer[] {2,1,2}));
		assertFalse(CustomLists.isSorted(list, true));
		assertFalse(CustomLists.isSorted(list,  false));
	}

	// Test Bubble Sort
	// --------------------------------------------------------------------------

	@Test
	public void testBubbleSortOdd()
	{
		List<Integer> list = new LinkedList<Integer> (Arrays.asList(new Integer[] { 5, 4, 3, 2, 1 }));
		List<Integer> result = new LinkedList<Integer> (Arrays.asList(new Integer[] { 1, 2, 3, 4, 5 }));

		CustomLists.bubbleSort(list);

		for (Integer i = 0; i < list.size(); i++)
		{
			assertEquals("All listay values should be as" + " specified in result listay", list.get(i), result.get(i));
		}
	}

	@Test
	public void testBubbleSortEven()
	{
		List<Integer> list = new LinkedList<Integer> (Arrays.asList(new Integer[] { 5, 4, 3, 2 }));
		List<Integer> result = new LinkedList<Integer> (Arrays.asList(new Integer[] { 2, 3, 4, 5 }));

		CustomLists.bubbleSort(list);

		for (Integer i = 0; i < list.size(); i++)
		{
			assertEquals("All listay values should be as" + " specified in result listay", list.get(i), result.get(i));
		}
	}

	// Test Selection Sort
	// --------------------------------------------------------------------------

	@Test
	public void testSelectionSortOdd()
	{
		List<Integer> list = new LinkedList<Integer> (Arrays.asList(new Integer[] { 5, 4, 3, 2, 1 }));
		List<Integer> result = new LinkedList<Integer> (Arrays.asList(new Integer[] { 1, 2, 3, 4, 5 }));

		CustomLists.selectionSort(list);

		for (Integer i = 0; i < list.size(); i++)
		{
			assertEquals("All listay values should be as" + " specified in result listay", list.get(i), result.get(i));
		}
	}

	@Test
	public void testSelectionSortEven()
	{
		List<Integer> list = new LinkedList<Integer> (Arrays.asList(new Integer[] { 5, 4, 3, 2 }));
		List<Integer> result = new LinkedList<Integer> (Arrays.asList(new Integer[] { 2, 3, 4, 5 }));

		CustomLists.selectionSort(list);

		for (Integer i = 0; i < list.size(); i++)
		{
			assertEquals("All listay values should be as" + " specified in result listay", list.get(i), result.get(i));
		}
	}

	// Test Insertion Sort
	// --------------------------------------------------------------------------

	@Test
	public void testInsertionSortOdd()
	{
		List<Integer> list = new LinkedList<Integer> (Arrays.asList(new Integer[] { 5, 4, 3, 2, 1 }));
		List<Integer> result = new LinkedList<Integer> (Arrays.asList(new Integer[] { 1, 2, 3, 4, 5 }));

		CustomLists.insertionSort(list);

		for (Integer i = 0; i < list.size(); i++)
		{
			assertEquals("All listay values should be as" + " specified in result listay", list.get(i), result.get(i));
		}
	}

	@Test
	public void testInsertionSortEven()
	{
		List<Integer> list = new LinkedList<Integer> (Arrays.asList(new Integer[] { 5, 4, 3, 2 }));
		List<Integer> result = new LinkedList<Integer> (Arrays.asList(new Integer[] { 2, 3, 4, 5 }));

		CustomLists.insertionSort(list);

		for (Integer i = 0; i < list.size(); i++)
		{
			assertEquals("All listay values should be as" + " specified in result listay", list.get(i), result.get(i));
		}
	}

	// Test Merge method
	// ---------------------------------------------------------------------------

	@Test
	public void testMergeCompleteEven()
	{
		List<Integer> list = new LinkedList<Integer> (Arrays.asList(new Integer[] { 3, 4, 1, 2 }));
		List<Integer> result = new LinkedList<Integer> (Arrays.asList(new Integer[] { 1, 2, 3, 4 }));

		CustomLists.merge(list, 0, 2, 4);

		for (Integer i = 0; i < list.size(); i++)
		{
			assertEquals("All listay values should be as" + " specified in result listay", list.get(i), result.get(i));
		}
	}

	@Test
	public void testMergeCompleteOdd()
	{
		List<Integer> list = new LinkedList<Integer> (Arrays.asList(new Integer[] { 2, 3, 1 }));
		List<Integer> result = new LinkedList<Integer> (Arrays.asList(new Integer[] { 1, 2, 3 }));

		CustomLists.merge(list, 0, 2, 3);

		for (Integer i = 0; i < list.size(); i++)
		{
			assertEquals("All listay values should be as" + " specified in result listay", list.get(i), result.get(i));
		}
	}

	@Test
	public void testMergePartial()
	{
		List<Integer> list = new LinkedList<Integer> (Arrays.asList(new Integer[] { 1, 2, 3, 4, 1, 2 }));
		List<Integer> result = new LinkedList<Integer> (Arrays.asList(new Integer[] { 1, 2, 1, 2, 3, 4 }));

		CustomLists.merge(list, 2, 4, 6);

		for (Integer i = 0; i < list.size(); i++)
		{
			assertEquals("All listay values should be as" + " specified in result listay", list.get(i), result.get(i));
		}
	}

	@Test
	public void testMergeSingle()
	{
		List<Integer> list = new LinkedList<Integer> (Arrays.asList(new Integer[] { 1, 2, 3, 4, 1, 2 }));
		List<Integer> result = new LinkedList<Integer> (Arrays.asList(new Integer[] { 1, 2, 1, 2, 3, 4 }));

		CustomLists.merge(list, 2, 4, 6);

		for (Integer i = 0; i < list.size(); i++)
		{
			assertEquals("All listay values should be as" + " specified in result listay", list.get(i), result.get(i));
		}
	}

	// Test Merge Sort
	// -----------------------------------------------------------------------------------

	@Test
	public void testMergeSortOdd()
	{
		List<Integer> list = new LinkedList<Integer> (Arrays.asList(new Integer[] { 5, 4, 3, 2, 1 }));
		List<Integer> result = new LinkedList<Integer> (Arrays.asList(new Integer[] { 1, 2, 3, 4, 5 }));

		CustomLists.mergeSort(list, 0, list.size());

		for (Integer i = 0; i < list.size(); i++)
		{
			assertEquals("All listay values should be as" + " specified in result listay", list.get(i), result.get(i));
		}
	}

	@Test
	public void testMergeSortEven()
	{
		List<Integer> list = new LinkedList<Integer> (Arrays.asList(new Integer[] { 5, 4, 3, 2 }));
		List<Integer> result = new LinkedList<Integer> (Arrays.asList(new Integer[] { 2, 3, 4, 5 }));

		CustomLists.mergeSort(list, 0, list.size());

		for (Integer i = 0; i < list.size(); i++)
		{
			assertEquals("All listay values should be as" + " specified in result listay", list.get(i), result.get(i));
		}
	}

	@Test
	public void testMergeCustomListsingle()
	{
		List<Integer> list = new LinkedList<Integer> (Arrays.asList(new Integer[] { 1 }));
		List<Integer> result = new LinkedList<Integer> (Arrays.asList(new Integer[] { 1 }));

		CustomLists.mergeSort(list, 0, list.size());

		for (Integer i = 0; i < list.size(); i++)
		{
			assertEquals("All listay values should be as" + " specified in result listay", list.get(i), result.get(i));
		}
	}

	@Test
	public void testMergeSortDouble()
	{
		List<Integer> list = new LinkedList<Integer> (Arrays.asList(new Integer[] { 2, 1 }));
		List<Integer> result = new LinkedList<Integer> (Arrays.asList(new Integer[] { 1, 2 }));

		CustomLists.mergeSort(list, 0, list.size());

		for (Integer i = 0; i < list.size(); i++)
		{
			assertEquals("All listay values should be as" + " specified in result listay", list.get(i), result.get(i));
		}
	}

	// Test Quick Sort
	// ------------------------------------------------------------------------------

	@Test
	public void testQuickSortOdd()
	{
		List<Integer> list = new LinkedList<Integer> (Arrays.asList(new Integer[] { 5, 4, 3, 2, 1 }));
		List<Integer> result = new LinkedList<Integer> (Arrays.asList(new Integer[] { 1, 2, 3, 4, 5 }));

		CustomLists.quickSort(list, 0, list.size());

		for (Integer i = 0; i < list.size(); i++)
		{
			assertEquals("All listay values should be as" + " specified in result listay", list.get(i), result.get(i));
		}
	}

	@Test
	public void testQuickSortEven()
	{
		List<Integer> list = new LinkedList<Integer> (Arrays.asList(new Integer[] { 5, 4, 3, 2 }));
		List<Integer> result = new LinkedList<Integer> (Arrays.asList(new Integer[] { 2, 3, 4, 5 }));

		CustomLists.quickSort(list, 0, list.size());

		for (Integer i = 0; i < list.size(); i++)
		{
			assertEquals("All listay values should be as" + " specified in result listay", list.get(i), result.get(i));
		}
	}

	@Test
	public void testQuickCustomListsingle()
	{
		List<Integer> list = new LinkedList<Integer> (Arrays.asList(new Integer[] { 1 }));
		List<Integer> result = new LinkedList<Integer> (Arrays.asList(new Integer[] { 1 }));

		CustomLists.quickSort(list, 0, list.size());

		for (Integer i = 0; i < list.size(); i++)
		{
			assertEquals("All listay values should be as" + " specified in result listay", list.get(i), result.get(i));
		}
	}

	@Test
	public void testQuickSortDouble()
	{
		List<Integer> list = new LinkedList<Integer> (Arrays.asList(new Integer[] { 2, 1 }));
		List<Integer> result = new LinkedList<Integer> (Arrays.asList(new Integer[] { 1, 2 }));

		CustomLists.quickSort(list, 0, list.size());

		for (Integer i = 0; i < list.size(); i++)
		{
			assertEquals("All listay values should be as" + " specified in result listay", list.get(i), result.get(i));
		}
	}

	// Test maxHeapify
	// ---------------------------------------------------------------

	@Test
	public void testMaxHeapifyComplete()
	{
		List<Integer> list = new LinkedList<Integer> (Arrays.asList(new Integer[] { 0, 1, 2, 3, 4 }));
		List<Integer> result = new LinkedList<Integer> (Arrays.asList(new Integer[] { 4, 3, 2, 0, 1 }));

		for (Integer i = list.size() / 2; i >= 0; i--)
		{
			CustomLists.siftDown(list, i, list.size());
		}

		for (Integer i = 0; i < list.size(); i++)
		{
			assertEquals("All listay values should be as specified in" + " result listay to satisfy the heap property",
					list.get(i), result.get(i));
		}
	}

	@Test
	public void testMaxHeapifyPartial()
	{
		List<Integer> list = new LinkedList<Integer> (Arrays.asList(new Integer[] { 0, 1, 2, 3, 4 }));
		List<Integer> result = new LinkedList<Integer> (Arrays.asList(new Integer[] { 2, 1, 0, 3, 4 }));

		CustomLists.maxHeapify(list, 0, 3);

		for (Integer i = 0; i < list.size(); i++)
		{
			assertEquals("All listay values should be as specified in"
					+ " result listay to satisfy the heap property for the partial listay", list.get(i), result.get(i));
		}
	}

	// Test Heap Sort
	// ----------------------------------------------------------------

	@Test
	public void testHeapSortOdd()
	{
		List<Integer> list = new LinkedList<Integer> (Arrays.asList(new Integer[] { 5, 4, 3, 2, 1 }));
		List<Integer> result = new LinkedList<Integer> (Arrays.asList(new Integer[] { 1, 2, 3, 4, 5 }));

		CustomLists.heapSort(list);

		for (Integer i = 0; i < list.size(); i++)
		{
			assertEquals("All listay values should be as" + " specified in result listay", list.get(i), result.get(i));
		}
	}

	@Test
	public void testHeapSortEven()
	{
		List<Integer> list = new LinkedList<Integer> (Arrays.asList(new Integer[] { 5, 4, 3, 2 }));
		List<Integer> result = new LinkedList<Integer> (Arrays.asList(new Integer[] { 2, 3, 4, 5 }));

		CustomLists.heapSort(list);

		for (Integer i = 0; i < list.size(); i++)
		{
			assertEquals("All listay values should be as" + " specified in result listay", list.get(i), result.get(i));
		}
	}

	@Test
	public void testHeapCustomListsingle()
	{
		List<Integer> list = new LinkedList<Integer> (Arrays.asList(new Integer[] { 1 }));
		List<Integer> result = new LinkedList<Integer> (Arrays.asList(new Integer[] { 1 }));

		CustomLists.heapSort(list);

		for (Integer i = 0; i < list.size(); i++)
		{
			assertEquals("All listay values should be as" + " specified in result listay", list.get(i), result.get(i));
		}
	}

	@Test
	public void testHeapSortDouble()
	{
		List<Integer> list = new LinkedList<Integer> (Arrays.asList(new Integer[] { 2, 1 }));
		List<Integer> result = new LinkedList<Integer> (Arrays.asList(new Integer[] { 1, 2 }));

		CustomLists.heapSort(list);

		for (Integer i = 0; i < list.size(); i++)
		{
			assertEquals("All listay values should be as" + " specified in result listay", list.get(i), result.get(i));
		}
	}
}
