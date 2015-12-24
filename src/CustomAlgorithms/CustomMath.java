package CustomAlgorithms;
/**
 * A custom math class for miscellaneous purposes.
 * @author Robert Meade
 *
 */
public class CustomMath
{

	/**
	 * A for-loop implementation of the isPrime method.
	 * @param n
	 * @return isPrime
	 */
	public static boolean isPrime(int n)
	{
		if (n < 2)
		{
			return false;
		}
		else if (n == 2)
		{
			return true;
		}
		else
		{
			for (int i = 2; i <= Math.sqrt(n); i++)
			{
				if (n % i == 0)
				{
					return false;
				}
			}
			return true;
		}
	}

	/**
	 * A recursive implementation of the isPrime method.
	 * @param n
	 * @param i Counter; must start at a value of 2 to function properly
	 * @return isPrime
	 */
	public static boolean isPrime(int n, int i)
	{
		if (n < 2)
		{
			return false;
		}
		else if (n == 2)
		{
			return true;
		}
		else if(i <= Math.sqrt(n))
		{
			if (n % i == 0)
			{
				return false;
			}
			return isPrime(n, i+1);
		}
		return true;
	}

}
