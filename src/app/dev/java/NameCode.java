package app.dev.java;

/**
 * Created by jananda on 04/04/2018.
 */
public class NameCode
{
	private String code;
	private String name;

	public NameCode()
	{
	}

	public NameCode( String code, String name )
	{
		this.code = code;
		this.name = name;
	}

	public String getCode()
	{
		return code;
	}

	public void setCode( String code )
	{
		this.code = code;
	}

	public String getName()
	{
		return name;
	}

	public void setName( String name )
	{
		this.name = name;
	}

	@Override
	public boolean equals( Object o )
	{
		if ( this == o )
			return true;
		if ( o == null || getClass() != o.getClass() )
			return false;

		NameCode nameCode = ( NameCode ) o;

		if ( code != null ? !code.equals( nameCode.code ) : nameCode.code != null )
			return false;
		return name != null ? name.equals( nameCode.name ) : nameCode.name == null;
	}

	@Override
	public int hashCode()
	{
		int result = code != null ? code.hashCode() : 0;
		result = 31 * result + ( name != null ? name.hashCode() : 0 );
		return result;
	}
}
