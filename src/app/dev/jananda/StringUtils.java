package app.dev.jananda;

/**
 * Created by jananda on 04/04/2018.
 */
public class StringUtils
{
	public static boolean isNotNull( Object value )
	{
		return !isNull( value );
	}

	/* is Not null string */
	public static boolean isNNStr( String value )
	{
		return value != null && value.length() != 0;
	}

	public static boolean isNN( Object value )
	{
		return !isNull( value );
	}

	public static boolean isNull( Object value )
	{
		return value == null || String.valueOf( value ).trim().length() == 0;
	}

	public static boolean isNotNullOrEmpty( String value )
	{
		return value != null && value.length() > 0;
	}

	public static boolean isNullOrEmpty( String value )
	{
		return value == null || value.length() == 0;
	}
}
