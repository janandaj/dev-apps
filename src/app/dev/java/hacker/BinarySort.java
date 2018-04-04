package app.dev.java.hacker;

import java.util.Scanner;

/**
 * Created by jananda on 04/04/2018.
 */
public class BinarySort
{
	public static void main( String[] args )
	{
		Scanner in = new Scanner( System.in );
		int n = in.nextInt();
		int[] a = new int[n];
		for ( int a_i = 0; a_i < n; a_i++ )
		{
			a[a_i] = in.nextInt();
		}
		// Write Your Code Here

		//		Arrays.sort( a );

		int total = 0;
		for ( int i = 0; i < n; i++ )
		{
			// Track number of elements swapped during a single array traversal
			int numberOfSwaps = 0;

			for ( int j = 0; j < n - 1; j++ )
			{
				// Swap adjacent elements if they are in decreasing order
				if ( a[j] > a[j + 1] )
				{
					int x = a[j];
					int y = a[j + 1];
					a[j] = y;
					a[j + 1] = x;
					numberOfSwaps++;
				}
			}

			total += numberOfSwaps;

			// If no elements were swapped during a traversal, array is sorted
			if ( numberOfSwaps == 0 )
			{
				break;
			}
		}
		System.out.println( "Array is sorted in " + total + " swaps." );
		System.out.println( "First Element: " + a[0] );
		System.out.println( "Last Element: " + a[n - 1] );
	}
}
