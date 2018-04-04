package app.dev.jananda;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by jananda on 04/04/2018.
 */
public class ArrayListCombination
{
	@Test
	public void testListPairs()
	{
		Set<String> animals = ImmutableSet.of( "gerbil", "hamster" );
		Set<String> fruits = ImmutableSet.of( "apple", "orange", "banana" );

		Set<List<String>> product = Sets.cartesianProduct( animals, fruits );
		// {{"gerbil", "apple"}, {"gerbil", "orange"}, {"gerbil", "banana"},
		//  {"hamster", "apple"}, {"hamster", "orange"}, {"hamster", "banana"}}

		Set<Set<String>> animalSets = Sets.powerSet( animals );
		// {{}, {"gerbil"}, {"hamster"}, {"gerbil", "hamster"}}

		//		System.out.println( product );
		//		System.out.println( animalSets );

		product.forEach( System.out::println );
		System.out.println( "++++++++++++++++++++++" );
		animalSets.forEach( System.out::println );
	}

	@Test
	public void testListCominations()
	{
		List<String> listOne = Arrays.asList( "Silver", "White", "Grey", "Purple" );
		List<String> listTwo = Arrays.asList( "Petrol", "Hybrid" );
		List<String> listThree = Arrays.asList( "Toyota", "Micro" );
		List<List<String>> totalList = Arrays.asList( listOne, listTwo, listThree );

		printAllCases( totalList );
	}

	@Test
	public void testAirportCombinations()
	{
		List<String> listOne = Arrays.asList( "LHR", "DXB", "CMB", "AUH", "MLE" );
		List<String> listTwo = Arrays.asList( "LHR", "DXB", "CMB", "AUH", "MLE" );
		List<List<String>> totalList = Arrays.asList( listOne, listTwo );
		printAllCases( totalList );

		Set<List<String>> result = Sets.cartesianProduct( listOne.stream().collect( Collectors.toSet() ), listTwo.stream().collect( Collectors.toSet() ) );
		System.out.println( result.size() );
		System.out.println( result );
	}

	private void printAllCases( List<List<String>> totalList )
	{
		List<String> result = new ArrayList<>( totalList.get( 0 ) );

		for ( int index = 1; index < totalList.size(); index++ )
		{
			result = combineTwoLists( result, totalList.get( index ) );
		}

    /* print */
		int count = 0;
		for ( String s : result )
		{
			System.out.printf( "%d. %s\n", ++count, s );
		}
	}

	private List<String> combineTwoLists( List<String> list1, List<String> list2 )
	{
		List<String> result = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		for ( String s1 : list1 )
		{
			for ( String s2 : list2 )
			{
				if ( !s1.equalsIgnoreCase( s2 ) )
				{
					sb.setLength( 0 );
					sb.append( s1 ).append( ' ' ).append( s2 );
					result.add( sb.toString() );
				}
			}
		}
		return result;
	}

	@Test
	public void testUsingGuava()
	{
		Set<String> colors = ImmutableSet.of( "Silver", "White", "Grey", "Purple" );
		Set<String> fuelTypes = ImmutableSet.of( "Petrol", "Hybrid" );
		Set<String> brands = ImmutableSet.of( "Toyota", "Micro" );

		Set<List<String>> result = Sets.cartesianProduct( colors, fuelTypes, brands );
		Sets.cartesianProduct( colors );
		System.out.println( result );
		System.out.println( colors );
	}

	@Test
	public void testSet()
	{
		String text = "Vision of the Seas";
		Set<String> set = Arrays.stream( text.split( " " ) ).collect( Collectors.toSet() );
		System.out.println( set );
	}

	private List<String> prepareInputs( String name )
	{
		List<String> inputs = new ArrayList<>();
		if ( StringUtils.isNN( name ) )
		{
			String[] in = name.split( " " );
			for ( int i = 0; i < in.length; i++ )
			{
				inputs.add( in[i] );
				if ( i > 0 )
				{
					String text = "";
					for ( int j = 0; j <= i; j++ )
					{
						text += in[j] + " ";
					}
					inputs.add( text );
				}
			}
		}
		return inputs;
	}

	@Test
	public void testSet1()
	{
		String text = "Vision of the Seas";
		Set<String> set = Arrays.stream( text.split( " " ) ).collect( Collectors.toSet() );
		System.out.println( set );
		Set<Set<String>> elements1 = Sets.powerSet( set );
		Set<List<String>> elements2 = Sets.cartesianProduct( set );

		elements1.forEach( System.out::println );
		System.out.println( "++++++++++++++++++++++" );
		elements2.forEach( System.out::println );
	}

	@Test
	public void testUsingGuava1()
	{
		Set<String> colors = ImmutableSet.of( "Silver", "White", "Grey", "Purple" );
		Set<String> fuelTypes = ImmutableSet.of( "Petrol", "Hybrid" );
		Set<String> brands = ImmutableSet.of( "Toyota", "Micro" );

		Set<List<String>> result = Sets.cartesianProduct( colors, fuelTypes, brands );
		System.out.println( result );
		System.out.println( colors );
		System.out.println( Sets.cartesianProduct( colors ) );
	}

	@Test
	public void testPrepareInputs()
	{
		String text = "Vision of the Seas";
		System.out.println( prepareInputs( text ) );
	}
}


