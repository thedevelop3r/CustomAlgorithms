
import static org.junit.Assert.*;

import org.junit.Test;

import CustomAlgorithms.CustomIntArrays;

public class CustomIntArraysSearchesTest
{
	// SequentialSearchTests
	// -----------------------------------------------------------
	
	@Test
	public void testSequentialSearchNotFound()
	{
		int[] arr = new int[]{ 0, 1, 2, 3, 4, 5};
		assertEquals("Sequential Search should return -1 if not found", CustomIntArrays.sequentialSearch(arr, 11), -1);
	}
	
	@Test
	public void testSequentialSearchFoundFirst()
	{
		int[] arr = new int[]{ 0, 1, 2, 3, 4, 5};
		assertEquals("Sequential Search should find element at last array index", CustomIntArrays.sequentialSearch(arr, 0), 0);
	}
	
	@Test
	public void testSequentialSearchFoundLast()
	{
		int[] arr = new int[]{ 0, 1, 2, 3, 4, 5};
		assertEquals("Sequential Search should find element at last array index", CustomIntArrays.sequentialSearch(arr, 5), 5);
	}
	
	@Test
	public void testSequentialSearchFoundFirstInstance()
	{
		int[] arr = new int[]{ 0, 0, 2, 3, 4, 5};
		assertEquals("Sequential Search should find first equivalent element", CustomIntArrays.sequentialSearch(arr, 0), 0);
	}
	
	// Iterative Binary Search Tests
	// ---------------------------------------------------------------
	
	@Test
	public void testbinarySearchNotFound()
	{
		int[] arr = new int[]{ 0, 1, 2, 3, 4, 5};
		assertEquals("Binary Search should return -1 if not found", CustomIntArrays.binarySearch(arr, 11), -1);
	}
	
	@Test
	public void testbinarySearchFoundFirst()
	{
		int[] arr = new int[]{ 0, 1, 2, 3, 4, 5};
		assertEquals("Binary Search should find element at last array index", CustomIntArrays.binarySearch(arr, 0), 0);
	}
	
	@Test
	public void testbinarySearchFoundLast()
	{
		int[] arr = new int[]{ 0, 1, 2, 3, 4, 5};
		assertEquals("Binary Search should find element at last array index", CustomIntArrays.binarySearch(arr, 5), 5);
	}
	
}
