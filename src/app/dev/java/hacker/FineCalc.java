package app.dev.java.hacker;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 * Created by jananda on 17/04/2018.
 */
public class FineCalc
{
	public static void main( String[] args )
	{
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

		Scanner scan = new Scanner( System.in );

		int retDate = scan.nextInt();
		int retMonth = scan.nextInt();
		int retYear = scan.nextInt();
		int dueDate = scan.nextInt();
		int dueMonth = scan.nextInt();
		int dueYear = scan.nextInt();

		LocalDate lcret = LocalDate.of( retYear, retMonth, retDate );
		LocalDate lcdue = LocalDate.of( dueYear, dueMonth, dueDate );

		if ( dueYear == retYear && lcret.isAfter( lcdue ) )
		{
			System.out.println( calcFine( lcdue, lcret ) );
		}
		else if ( dueYear < retYear )
		{
			System.out.println( 10000 );
		}
		else
		{
			System.out.println( 0 );
		}

		testTime();
	}

	private static long calcFine( LocalDate fromDateTime, LocalDate toDateTime )
	{
		LocalDate tempDateTime = LocalDate.from( fromDateTime );

		long years = tempDateTime.until( toDateTime, ChronoUnit.YEARS );
		if ( years > 0 )
		{
			return 10000;
		}

		long months = tempDateTime.until( toDateTime, ChronoUnit.MONTHS );
		if ( months > 0 )
		{
			return 500 * months;
		}

		long days = tempDateTime.until( toDateTime, ChronoUnit.DAYS );
		return 15 * days;
	}

	private static void testTime()
	{
		LocalDateTime fromDateTime = LocalDateTime.of( 1984, 12, 16, 7, 45, 55 );
		LocalDateTime toDateTime = LocalDateTime.of( 2014, 9, 10, 6, 40, 45 );
		System.out.println( timeDiffText( fromDateTime, toDateTime ) );

		String tim = "2017-01-04T20:12:51.483";
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime insertTime = LocalDateTime.parse( tim );
		System.out.println( timeDiffText( insertTime, now ) );

		System.out.println( timeDiffTextInUnits( fromDateTime, toDateTime, ChronoUnit.YEARS ) );
		System.out.println( timeDiffTextInUnits( fromDateTime, toDateTime, ChronoUnit.MONTHS ) );
		System.out.println( timeDiffTextInUnits( fromDateTime, toDateTime, ChronoUnit.YEARS, ChronoUnit.MONTHS, ChronoUnit.WEEKS, ChronoUnit.DAYS, ChronoUnit.HOURS, ChronoUnit.MINUTES, ChronoUnit.SECONDS ) );

		System.out.println( timeDiffTextInUnits( insertTime, now ) );
		System.out.println( timeDiffTextInUnits( insertTime, now, ChronoUnit.DAYS ) );
		System.out.println( timeDiffTextInUnits( insertTime, now, ChronoUnit.MINUTES ) );
		System.out.println( timeDiffTextInUnits( insertTime, now, ChronoUnit.YEARS, ChronoUnit.MONTHS, ChronoUnit.DAYS, ChronoUnit.HOURS, ChronoUnit.MINUTES, ChronoUnit.SECONDS ) );

		System.out.println( timeDifference( insertTime, now ) );
		System.out.println( timeDifference( insertTime, now, ChronoUnit.MILLIS ) );
		System.out.println( timeDifference( insertTime, now, ChronoUnit.SECONDS ) );

		System.out.println( LocalDateTime.parse( tim ).atZone( ZoneId.systemDefault() ).toEpochSecond() );
		System.out.println( LocalDateTime.parse( tim ).atZone( ZoneId.systemDefault() ).toInstant().toEpochMilli() );

		String nowTime = "2017-01-20T18:02:08.807";
		String insertedTime = "2017-01-20T18:02:08.807";
		System.out.println( LocalDateTime.parse( nowTime ).atZone( ZoneId.systemDefault() ).toInstant().toEpochMilli() );
		System.out.println( LocalDateTime.parse( insertedTime ).atZone( ZoneId.systemDefault() ).toInstant().toEpochMilli() );
		long time = 1484928962109L;
		System.out.println( time );

		LocalDate elapseDate = Instant.ofEpochMilli( time ).atZone( ZoneId.systemDefault() ).toLocalDate();
		LocalDateTime elaspseTime = LocalDateTime.ofInstant( Instant.ofEpochMilli( time ), ZoneId.systemDefault() );
		System.out.println( elapseDate );
		System.out.println( nowTime );
		System.out.println( insertedTime );
		System.out.println( elaspseTime );

	}

	private static String getUnitString( ChronoUnit chronoUnit )
	{
		switch ( chronoUnit )
		{
			case YEARS:
				return " years ";
			case MONTHS:
				return " months ";
			case WEEKS:
				return " weeks ";
			case DAYS:
				return " days ";
			case HOURS:
				return " hours ";
			case MINUTES:
				return " minutes ";
			case SECONDS:
				return " seconds ";
			case MILLIS:
				return " milliseconds ";
			default:
				return "";
		}
	}

	private static String timeDiffText( LocalDateTime fromDateTime, LocalDateTime toDateTime )
	{
		String text = "";
		LocalDateTime tempDateTime = LocalDateTime.from( fromDateTime );

		long value = tempDateTime.until( toDateTime, ChronoUnit.YEARS );
		tempDateTime = tempDateTime.plusYears( value );
		text += value > 0 ? value + getUnitString( ChronoUnit.YEARS ) : "";

		value = tempDateTime.until( toDateTime, ChronoUnit.MONTHS );
		tempDateTime = tempDateTime.plusMonths( value );
		text += value > 0 ? value + getUnitString( ChronoUnit.MONTHS ) : "";

		value = tempDateTime.until( toDateTime, ChronoUnit.DAYS );
		tempDateTime = tempDateTime.plusDays( value );
		text += value > 0 ? value + getUnitString( ChronoUnit.DAYS ) : "";

		value = tempDateTime.until( toDateTime, ChronoUnit.HOURS );
		tempDateTime = tempDateTime.plusHours( value );
		text += value > 0 ? value + getUnitString( ChronoUnit.HOURS ) : "";

		value = tempDateTime.until( toDateTime, ChronoUnit.MINUTES );
		tempDateTime = tempDateTime.plusMinutes( value );
		text += value > 0 ? value + getUnitString( ChronoUnit.MINUTES ) : "";

		value = tempDateTime.until( toDateTime, ChronoUnit.SECONDS );
		text += value > 0 ? value + getUnitString( ChronoUnit.SECONDS ) : "";

		value = tempDateTime.until( toDateTime, ChronoUnit.MILLIS );
		text += value > 0 ? value + getUnitString( ChronoUnit.MILLIS ) : "";

		return text;
	}

	private static String timeDiffTextInUnits( LocalDateTime fromDateTime, LocalDateTime toDateTime, ChronoUnit... chronoUnits )
	{
		String text = "";
		for ( ChronoUnit chronoUnit : chronoUnits )
		{
			long unit = timeDifference( fromDateTime, toDateTime, chronoUnit );
			text += unit > 0 ? unit + getUnitString( chronoUnit ) : "";
		}
		return text;
	}

	private static long timeDifference( LocalDateTime fromDateTime, LocalDateTime toDateTime )
	{
		return timeDifference( fromDateTime, toDateTime, ChronoUnit.MILLIS );
	}

	private static long timeDifference( LocalDateTime fromDateTime, LocalDateTime toDateTime, ChronoUnit chronoUnit )
	{
		return chronoUnit.between( fromDateTime, toDateTime );
	}
}
