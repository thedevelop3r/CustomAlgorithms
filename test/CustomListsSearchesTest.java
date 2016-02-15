
import static org.junit.Assert.*;

import org.junit.Test;

import CustomAlgorithms.CustomArrays;

public class CustomListsSearchesTest
{
	// SequentialSearchTests
	// -----------------------------------------------------------
	
	@Test
	public void testSequentialSearchNotFound()
	{
		Integer[] arr = new Integer[]{ 0, 1, 2, 3, 4, 5};
		assertEquals("Sequential Search should return -1 if not found", CustomArrays.sequentialSearch(arr, 11), -1);
	}
	
	@Test
	public void testSequentialSearchFoundFirst()
	{
		Integer[] arr = new Integer[]{ 0, 1, 2, 3, 4, 5};
		assertEquals("Sequential Search should find element at last array index", CustomArrays.sequentialSearch(arr, 0), 0);
	}
	
	@Test
	public void testSequentialSearchFoundLast()
	{
		Integer[] arr = new Integer[]{ 0, 1, 2, 3, 4, 5};
		assertEquals("Sequential Search should find element at last array index", CustomArrays.sequentialSearch(arr, 5), 5);
	}
	
	@Test
	public void testSequentialSearchFoundFirstInstance()
	{
		Integer[] arr = new Integer[]{ 0, 0, 2, 3, 4, 5};
		assertEquals("Sequential Search should find first equivalent element", CustomArrays.sequentialSearch(arr, 0), 0);
	}
	
	// Iterative Binary Search Tests
	// ---------------------------------------------------------------
	
	@Test
	public void testbinarySearchNotFound()
	{
		Integer[] arr = new Integer[]{ 0, 1, 2, 3, 4, 5};
		assertEquals("Binary Search should return -1 if not found", CustomArrays.binarySearch(arr, 11), -1);
	}
	
	@Test
	public void testbinarySearchFoundFirst()
	{
		Integer[] arr = new Integer[]{ 0, 1, 2, 3, 4, 5};
		assertEquals("Binary Search should find element at last array index", CustomArrays.binarySearch(arr, 0), 0);
	}
	
	@Test
	public void testbinarySearchFoundLast()
	{
		Integer[] arr = new Integer[]{ 0, 1, 2, 3, 4, 5};
		assertEquals("Binary Search should find element at last array index", CustomArrays.binarySearch(arr, 5), 5);
	}
	
}
