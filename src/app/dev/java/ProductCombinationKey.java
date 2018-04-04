package app.dev.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

/**
 * Created by jananda on 04/04/2018.
 */
public class ProductCombinationKey
{
	public static final String SEPARATOR = "-";
	public static final String EMPTYS = "";

	private Map<String, Integer> keyMap;

	public ProductCombinationKey()
	{
		keyMap = new HashMap<>();
	}

	public void addProductCode( String productCode )
	{
		if ( productCode != null )
		{
			Integer v = keyMap.get( productCode );
			if ( v == null )
			{
				v = 0;
			}
			keyMap.put( productCode, v + 1 );
		}
	}

	public String generateKey()
	{
		String[] arr = keyMap.keySet().toArray( new String[keyMap.size()] );

		Arrays.sort( arr );
		StringJoiner ss = new StringJoiner( SEPARATOR );
		for ( String s : arr )
		{
			Integer v = keyMap.get( s );
			ss.add( s + ( v > 1 ? v : EMPTYS ) );
		}
		return ss.toString();
	}

	@Override
	public String toString()
	{
		return "ProductCombinationKey{" + "keyMap=" + keyMap + '}';
	}

	public static String generateKey( String... productCodes )
	{
		ProductCombinationKey key = new ProductCombinationKey();
		for ( String productCode : productCodes )
		{
			key.addProductCode( productCode );
		}
		return key.generateKey();
	}
}

