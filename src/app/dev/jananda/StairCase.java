package app.dev.jananda;

import java.util.Scanner;

/**
 * Created by jananda on 04/04/2018.
 */
public class StairCase
{
	public static void main( String[] args )
	{
		Scanner scan = new Scanner( System.in );
		int n = Integer.parseInt( scan.nextLine().trim() );

		staircase( n );
	}

	private static void staircase( int n )
	{
		for ( int i = 1; i <= n; i++ )
		{
			System.out.println( getKey( i, n - i ) );
		}
	}

	private static String getKey( int count, int spaces )
	{
		StringBuilder key = new StringBuilder();
		for ( int i = 0; i < spaces; i++ )
		{
			key.append( " " );
		}
		for ( int i = 0; i < count; i++ )
		{
			key.append( "#" );
		}
		return key.toString();
	}
}
