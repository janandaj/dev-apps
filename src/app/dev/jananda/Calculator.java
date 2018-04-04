package app.dev.jananda;

/**
 * Created by jananda on 29/03/2018.
 */
class Calculator
{
	private static int power( int n, int p ) throws Exception
	{
		if ( n < 0 || p < 0 )
		{
			throw new Exception( "n and p should be non-negative" );
		}
		return ( int ) Math.pow( n, p );
	}

	public static void main( String[] args )
	{
		System.out.println( 5 / 3 );
		System.out.println( 3 / 2 );
		System.out.println( 7 / 4 );
		System.out.println( 7 / 4d );

		try
		{
			System.out.println( power( 5, 2 ) );
			System.out.println( power( 2, 3 ) );
			System.out.println( power( -1, 2 ) );
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
	}

}