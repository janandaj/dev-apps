package app.dev.jananda;

import java.util.Scanner;

/**
 * Created by jananda on 04/04/2018.
 */
public class PlusMinusZeroAverage
{
	public static void main( String[] args )
	{
		Scanner in = new Scanner( System.in );
		int n = in.nextInt();
		int[] l = new int[n];
		for ( int l_i = 0; l_i < n; l_i++ )
		{
			l[l_i] = in.nextInt();
		}
		plusMinus( l );
		in.close();
	}

	private static void plusMinus( int[] arr )
	{
		int positiveCount = 0;
		int negativeCount = 0;
		int zeroCount = 0;
		int length = arr.length;

		for ( int x : arr )
		{
			if ( x > 0 )
			{
				positiveCount++;
			}
			else if ( x < 0 )
			{
				negativeCount++;
			}
			else
			{
				zeroCount++;
			}
		}

		System.out.println( ( double ) positiveCount / length );
		System.out.println( ( double ) negativeCount / length );
		System.out.println( ( double ) zeroCount / length );

	}
}
