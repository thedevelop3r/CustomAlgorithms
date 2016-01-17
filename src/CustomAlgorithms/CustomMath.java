package CustomAlgorithms;
/**
 * A custom math class for miscellaneous purposes.
 * @author Robert Meade
 *
 */
public class CustomMath
{
	
	public static void main(String[] args)
	{
		System.out.println(fibonacci(13));
	}
	
	/**
	 * A for-loop implementation of a prime number test.
	 * @param n number to check
	 * @return is prime?
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
	 * The isPrimeOver2 method determines whether an int greater than 2 is a prime number.
	 * @param n number to check
	 * @return is prime over 2?
	 */
	public static boolean isPrimeOver2(int n)
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

	/**
	 * A recursive implementation of a prime number test.
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
	
	/**
	 * The random method gets a random double in the range [a,b]
	 * @param a lower bound
	 * @param b upper bound
	 * @return Random double in the range [a,b]
	 */
	public static double random(double a, double b)
	{
		return Math.random() * (b - a) + a;
	}
	
	/**
	 * The fibonacci method provides a recursive implementation of the fibonacci sequence
	 * @param n nth term in fibonnaci sequence
	 * @return value of nth term in sequence
	 */
	public static int fibonacci(int n)
	{
		if (n < 1)
		{
			return 0;
		}
		if(n == 1 || n == 2)
		{
			return 1;
		}
		else
		{
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}
}
