package app.dev.jananda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by jananda on 04/04/2018.
 */
public class MaximumPerimeterTraingle
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
		int[] result = maximumPerimeterTriangle( l );
		for ( int i = 0; i < result.length; i++ )
		{
			System.out.print( result[i] + ( i != result.length - 1 ? " " : "" ) );
		}
		System.out.println( "" );

		in.close();
	}

	private static int[] maximumPerimeterTriangle( int[] l )
	{
		// Complete this function
		int[] invalid = new int[] { -1 };

		if ( l.length <= 2 )
		{
			return invalid;
		}

		Arrays.sort( l );

		List<int[]> triList = new ArrayList<>();

		for ( int i = 0; i < l.length; i++ )
		{
			for ( int j = i + 1; j < l.length; j++ )
			{
				for ( int k = j + 1; k < l.length; k++ )
				{
					int arr[] = new int[3];
					arr[0] = l[i];
					arr[1] = l[j];
					arr[2] = l[k];
					triList.add( arr );
				}
			}
		}

		triList.removeIf( triArr -> ( triArr[0] + triArr[1] <= triArr[2] ) || ( triArr[1] + triArr[2] <= triArr[0] ) || ( triArr[2] + triArr[0] <= triArr[1] ) );

		if ( triList.isEmpty() )
		{
			return invalid;
		}

		int maxIndex = 0;
		int maxLength = 0;
		for ( int i = 0; i < triList.size(); i++ )
		{
			int[] intArry = triList.get( i );
			int length = intArry[0] + intArry[1] + intArry[2];

			if ( length > maxLength )
			{
				maxLength = length;
				maxIndex = i;
			}
		}

		return triList.get( maxIndex );
	}

}
