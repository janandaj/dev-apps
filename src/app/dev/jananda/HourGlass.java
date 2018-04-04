package app.dev.jananda;

import java.util.Scanner;

/**
 * Created by jananda on 04/04/2018.
 */
public class HourGlass
{
	//			1 1 1 0 0 0
	//			0 1 0 0 0 0
	//			1 1 1 0 0 0
	//			0 0 2 4 4 0
	//			0 0 0 2 0 0
	//			0 0 1 2 4 0

	//			-1 -1 0 -9 -2 -2
	//			-2 -1 -6 -8 -2 -5
	//			-1 -1 -1 -2 -3 -4
	//			-1 -9 -2 -4 -4 -5
	//			-7 -3 -3 -2 -9 -9
	//			-1 -3 -1 -2 -4 -5
	//					-6

	public static void main( String[] args )
	{
		Scanner in = new Scanner( System.in );

		int arr[][] = new int[6][6];

		fillArray( arr );

		for ( int i = 0; i < 6; i++ )
		{
			for ( int j = 0; j < 6; j++ )
			{
				arr[i][j] = in.nextInt();
			}
		}

		int largestSum = Integer.MIN_VALUE;

		for ( int i = 0; i < 4; i++ )
		{
			for ( int j = 0; j < 4; j++ )
			{
				int y = calcArraySum( arr, i, j );
				if ( y > largestSum )
				{
					largestSum = y;
				}

			}
		}
		System.out.println( largestSum );

	}

	private static void fillArray( int[][] arr )
	{
		arr[0][0] = 1;
		arr[0][1] = 1;
		arr[0][2] = 1;
		arr[0][3] = 0;
		arr[0][4] = 0;
		arr[0][5] = 0;

		arr[1][0] = 0;
		arr[1][1] = 1;
		arr[1][2] = 0;
		arr[1][3] = 0;
		arr[1][4] = 0;
		arr[1][5] = 0;

		arr[2][0] = 1;
		arr[2][1] = 1;
		arr[2][2] = 1;
		arr[2][3] = 0;
		arr[2][4] = 0;
		arr[2][5] = 0;

		arr[3][0] = 0;
		arr[3][1] = 0;
		arr[3][2] = 2;
		arr[3][3] = 4;
		arr[3][4] = 4;
		arr[3][5] = 0;

		arr[4][0] = 0;
		arr[4][1] = 0;
		arr[4][2] = 0;
		arr[4][3] = 2;
		arr[4][4] = 0;
		arr[4][5] = 0;

		arr[5][0] = 0;
		arr[5][1] = 0;
		arr[5][2] = 1;
		arr[5][3] = 2;
		arr[5][4] = 4;
		arr[5][5] = 0;
	}

	private static int calcArraySum( int[][] arr, int p, int q )
	{
		int x = 0;
		for ( int i = 0; i < 3; i++ )
		{
			for ( int j = 0; j < 3; j++ )
			{
				if ( ( i == 1 && j == 0 ) || ( i == 1 && j == 2 ) )
				{
					continue;
				}
				x += arr[i + p][j + q];
			}
		}
		return x;
	}
}
