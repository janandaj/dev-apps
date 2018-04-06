package app.dev.java.hacker;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by jananda on 06/04/2018.
 */

//		3
//		1000000007
//		100000003
//		1000003
//
//		Prime
//		Not prime
//		Prime
//
//		10
//		1000000000
//		1000000001
//		1000000002
//		1000000003
//		1000000004
//		1000000005
//		1000000006
//		1000000007
//		1000000008
//		1000000009
//
//		Not prime
//		Not prime
//		Not prime
//		Not prime
//		Not prime
//		Not prime
//		Not prime
//		Prime
//		Not prime
//		Prime

public class PrimeNotPrime
{
	private static long min = 2;
	private static long max = Long.MAX_VALUE;

	public static void main( String[] args )
	{
		Scanner scan = new Scanner( System.in );
		int n = scan.nextInt();
		long[] numArray = new long[n];

		for ( int i = 0; i < n; i++ )
		{
			long x = scan.nextInt();

			if ( x < max )
			{
				max = x;
			}

			if ( x > min )
			{
				min = x;
			}
			numArray[i] = x;
		}

		//		System.out.println( "max = " + min );
		//		System.out.println( "min = " + max );

		//				System.out.println( calculatePrimes( 2 ) );
		//		System.out.println( calculatePrimes( 3 ) );
		//		System.out.println( calculatePrimes( 4 ) );
		//		System.out.println( calculatePrimes( 5 ) );
		//		System.out.println( calculatePrimes( 6 ) );
		//		System.out.println( calculatePrimes( 7 ) );
		//		System.out.println( calculatePrimes( 8 ) );
		//		System.out.println( calculatePrimes( 9 ) );
		//		System.out.println( calculatePrimes( 10 ) );
		//		System.out.println( calculatePrimes( 10000 ) );

//		for ( int i = 0; i < n; i++ )
//		{
//			boolean prime = isPrime( numArray[i] );
//			System.out.println( prime ? "Prime" : "Not prime" );
//		}

		//		List<Long> primeList = calculatePrimes( min );
		//
		//		for ( int i = 0; i < n; i++ )
		//		{
		//			boolean prime = primeList.contains( numArray[i] );
		//			System.out.println( prime ? "Prime" : "Not prime" );
		//		}

		List<Long> primeList = calculatePrimes( min );
		for ( int i = 0; i < n; i++ )
		{
			boolean prime = isPrime2( numArray[i], primeList );
			System.out.println( prime ? "Prime" : "Not prime" );
		}
	}

	private static List<Long> calculatePrimes( long max )
	{
		int d = ( int ) Math.sqrt( max ) + 1;

		List<Long> primeList = new ArrayList<>();

		//		for ( long i = 2; i <= max; i++ )
		for ( long i = 2; i <= d; i++ )
		{
			boolean found = false;
			for ( long j = 2; j <= i; j++ )
			{
				if ( i != j && i % j == 0 )
				{
					found = true;
					break;
				}
			}
			if ( !found )
			{
				primeList.add( i );
			}
		}

		return primeList;
	}

	private static boolean isPrime( long n )
	{
		if ( n <= 1 )
		{
			return false;
		}

		if ( n == 2 )
		{
			return true;
		}

		boolean found = false;
		for ( long i = 2; i < n; i++ )
		{
			if ( n % i == 0 )
			{
				found = true;
				break;
			}
		}
		return !found;
	}

	private static boolean isPrime2( long n, List<Long> primeList )
	{
		if ( n <= 1 )
		{
			return false;
		}

		if ( n == 2 )
		{
			return true;
		}

		boolean found = false;
		for ( long i : primeList )
		{
			if ( n % i == 0 )
			{
				found = true;
				break;
			}
		}
		return !found;
	}
}
