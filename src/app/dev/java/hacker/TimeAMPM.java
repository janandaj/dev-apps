package app.dev.java.hacker;

import java.util.Scanner;
import java.util.StringJoiner;

/**
 * Created by jananda on 04/04/2018.
 */
public class TimeAMPM
{
	//	12:40:22AM 00:40:22
	//	12:00:00AM 00:00:00
	//	12:45:54PM 12:45:54
	public static void main( String[] args )
	{
		Scanner scanner = new Scanner( System.in );
		int n = scanner.nextInt();

		String[] stringArray = new String[n];
		for ( int i = 0; i < n; i++ )
		{
			stringArray[i] = scanner.next();
		}

		for ( String s : stringArray )
		{
			System.out.println( timeConversion( s ) );
		}
	}

	private static String timeConversion( String s )
	{
		if ( s.endsWith( "AM" ) )
		{
			String ss = s.replace( "AM", "" );
			String[] strArray = ss.split( ":" );
			int hour = Integer.parseInt( strArray[0] );
			if ( hour == 12 )
			{
				strArray[0] = "00";
			}

			StringJoiner sj = new StringJoiner( ":" );

			for ( String temp : strArray )
			{
				sj.add( temp );
			}

			return sj.toString();
		}
		else
		{
			String ss = s.replace( "PM", "" );
			String[] strArray = ss.split( ":" );
			int hour = Integer.parseInt( strArray[0] );
			if ( hour != 12 )
			{
				hour += 12;
			}

			strArray[0] = "" + hour;
			StringJoiner sj = new StringJoiner( ":" );

			for ( String temp : strArray )
			{
				sj.add( temp );
			}

			return sj.toString();
		}
	}
}
