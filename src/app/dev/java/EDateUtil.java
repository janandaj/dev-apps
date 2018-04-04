package app.dev.java;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Created by jananda on 04/04/2018.
 */
public class EDateUtil
{
	public static String timeDiffTextInUnits( LocalDateTime fromDateTime, LocalDateTime toDateTime, ChronoUnit... chronoUnits )
	{
		String text = "";
		for ( ChronoUnit chronoUnit : chronoUnits )
		{
			long unit = timeDifference( fromDateTime, toDateTime, chronoUnit );
			text += unit > 0 ? unit + getUnitString( chronoUnit ) : "";
		}
		return text;
	}

	public static long timeDifference( LocalDateTime fromDateTime, LocalDateTime toDateTime )
	{
		return timeDifference( fromDateTime, toDateTime, ChronoUnit.MILLIS );
	}

	public static long timeDifference( LocalDateTime fromDateTime, LocalDateTime toDateTime, ChronoUnit chronoUnit )
	{
		return chronoUnit.between( fromDateTime, toDateTime );
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

	public static String timeDiffText( LocalDateTime fromDateTime, LocalDateTime toDateTime )
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
}
