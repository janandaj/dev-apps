package app.dev.java;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.StringJoiner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by java on 04/04/2018.
 */
public class StreamTest
{
	@Test
	public void testArray()
	{
		String xyz = "ABC,PQR,123,abc,xyz,PQR,123,ABC";
		Object[] objArray = Arrays.stream( xyz.split( "," ) ).distinct().toArray();
		List<String> stringList = Arrays.stream( xyz.split( "," ) ).distinct().collect( Collectors.toList() );
		System.out.println( objArray );
		System.out.println( stringList );
		System.out.println( "success" );

		List<Integer> h2hIds = new ArrayList<>();
		h2hIds.add( 5 );
		h2hIds.add( -1 );
		h2hIds.add( 36 );
		h2hIds.add( 15 );
		h2hIds.add( 21 );
		Collections.sort( h2hIds );
		String x = String.valueOf( h2hIds );
		System.out.println( h2hIds );
		System.out.println( x );

	}

	@Test
	public void testDistinct()
	{
		List<String> list = Arrays.asList( "A", "B", "C", "D", "A", "B", "C" );

		// Get collection without duplicate i.e. distinct only
		List<String> distinctElements = list.stream().distinct().collect( Collectors.toList() );

		Set<String> xyz = new HashSet<>( list );

		//Let's verify distinct elements
		System.out.println( distinctElements );
		System.out.println( xyz );
	}

	@Test
	public void testContractIds()
	{
		List<String> contractIds = new ArrayList<>();
		contractIds.add( "" );
		contractIds.add( "0" );
		contractIds.add( "0000" );
		contractIds.add( "0000.000" );
		contractIds.add( "1" );
		contractIds.add( "2" );
		contractIds.add( "3" );
		contractIds.add( "3.5" );
		contractIds.add( "100.5" );
		contractIds.add( "1005456465465364" );
		contractIds.add( "100545sss6465465364" );
		contractIds.add( "ss100545sss6465465364" );
		contractIds.add( "100545sss6465465364ss" );
		contractIds.add( "XXss" );
		contractIds.add( "101-15" );
		contractIds.add( "45445454" );
		contractIds.add( "0122553232" );
		contractIds.add( "111000" );
		contractIds.add( "111,000" );
		contractIds.add( "-1" );
		contractIds.add( "-145454" );

		String regex = "\\d+";
		Pattern pattern = Pattern.compile( regex );
		contractIds = contractIds.stream().filter( t -> pattern.matcher( t ).matches() ).collect( Collectors.toList() );
		System.out.println( contractIds );
	}

	@Test
	public void testList()
	{
		NameCode port1 = new NameCode();
		port1.setCode( "ABC" );
		port1.setName( "test1" );

		NameCode port2 = new NameCode();
		port2.setCode( "XYZ" );
		port2.setName( "test2" );

		NameCode port3 = new NameCode();
		port3.setCode( "ABC" );
		port3.setName( "test3" );

		List<NameCode> ports = new ArrayList<>();
		ports.add( port1 );
		ports.add( port2 );
		ports.add( port3 );

		System.out.println( ports.stream().distinct().collect( Collectors.toList() ) );
		System.out.println( ports.stream().collect( Collectors.toMap( NameCode::getName, p -> p, ( p, q ) -> p ) ).values() );
		System.out.println( ports.stream().collect( Collectors.toMap( NameCode::getName, p -> p, ( p, q ) -> p ) ).keySet() );

		Set<String> testSet = ports.stream().collect( Collectors.toMap( NameCode::getCode, p -> p, ( p, q ) -> p ) ).keySet();
		System.out.println( ports.stream().collect( Collectors.toMap( NameCode::getCode, p -> p, ( p, q ) -> p ) ).keySet() );
		System.out.println( ports.stream().collect( Collectors.toMap( NameCode::getCode, p -> p, ( p, q ) -> p ) ).values() );

		System.out.println( "success" );
		System.out.println( testSet );

	}

	@org.junit.Test
	public void printTime()
	{
		System.out.println( LocalDate.now() );
		System.out.println( LocalDate.now().minusDays( 1 ) );
		System.out.println( LocalDateTime.now() );
		System.out.println( LocalDateTime.now().minusHours( 5 ) );

		List<String> strings = Arrays.asList( "George", "Sally", "Fred" );
		String collect = strings.stream().collect( Collectors.joining( ",", "{", "}" ) );
		System.out.println( "collect = " + collect );

		StringJoiner sj = new StringJoiner( ":", "[", "]" );
		sj.add( "George" ).add( "Sally" ).add( "Fred" );
		System.out.println( sj.toString() );

		StringJoiner sj1 = new StringJoiner( "-" );
		sj1.add( "George" ).add( "Sally" ).add( "Fred" );
		System.out.println( sj1.toString() );

	}

	@Test
	public void testTime()
	{
		LocalDateTime fromDateTime = LocalDateTime.of( 1984, 12, 16, 7, 45, 55 );
		LocalDateTime toDateTime = LocalDateTime.of( 2014, 9, 10, 6, 40, 45 );
		System.out.println( EDateUtil.timeDiffText( fromDateTime, toDateTime ) );

		String tim = "2017-01-04T20:12:51.483";
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime insertTime = LocalDateTime.parse( tim );
		System.out.println( EDateUtil.timeDiffText( insertTime, now ) );

		System.out.println( EDateUtil.timeDiffTextInUnits( fromDateTime, toDateTime, ChronoUnit.YEARS ) );
		System.out.println( EDateUtil.timeDiffTextInUnits( fromDateTime, toDateTime, ChronoUnit.MONTHS ) );
		System.out.println( EDateUtil.timeDiffTextInUnits( fromDateTime, toDateTime, ChronoUnit.YEARS, ChronoUnit.MONTHS, ChronoUnit.WEEKS, ChronoUnit.DAYS, ChronoUnit.HOURS, ChronoUnit.MINUTES, ChronoUnit.SECONDS ) );

		System.out.println( EDateUtil.timeDiffTextInUnits( insertTime, now ) );
		System.out.println( EDateUtil.timeDiffTextInUnits( insertTime, now, ChronoUnit.DAYS ) );
		System.out.println( EDateUtil.timeDiffTextInUnits( insertTime, now, ChronoUnit.MINUTES ) );
		System.out.println( EDateUtil.timeDiffTextInUnits( insertTime, now, ChronoUnit.YEARS, ChronoUnit.MONTHS, ChronoUnit.DAYS, ChronoUnit.HOURS, ChronoUnit.MINUTES, ChronoUnit.SECONDS ) );

		System.out.println( EDateUtil.timeDifference( insertTime, now ) );
		System.out.println( EDateUtil.timeDifference( insertTime, now, ChronoUnit.MILLIS ) );
		System.out.println( EDateUtil.timeDifference( insertTime, now, ChronoUnit.SECONDS ) );

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

	@Test
	public void testPCM()
	{
		ProductCombinationKey key = new ProductCombinationKey();
		key.addProductCode( "FLT" );
		key.addProductCode( "HTL" );
		key.addProductCode( "CAR" );
		key.addProductCode( "TRS" );
		key.addProductCode( "FLT" );
		key.addProductCode( "HTL" );

		System.out.println( "key.generateKey() = " + key.generateKey() ); // CAR+FLT2+HTL2+TRS

	}

	@Test
	public void testDates()
	{
		Date date = new Date();
		System.out.println( date );

		LocalDate ld = Instant.ofEpochMilli( date.getTime() ).atZone( ZoneId.systemDefault() ).toLocalDate();
		System.out.println( ld );

		LocalDateTime ldt = LocalDateTime.ofInstant( date.toInstant(), ZoneId.systemDefault() );
		System.out.println( ldt );

		System.out.println( LocalDateTime.now() );
		System.out.println( LocalDateTime.now().toEpochSecond( ZoneOffset.UTC ) );
		System.out.println( LocalDateTime.now().atZone( ZoneId.systemDefault() ).toEpochSecond() );
		System.out.println( LocalDateTime.now().hashCode() );
		System.out.println( LocalDateTime.parse( LocalDateTime.now().toString() ).atZone( ZoneId.systemDefault() ).toInstant().toEpochMilli() );
	}

	private void printTime( long time, String timeStr )
	{
		System.out.println( time );
		System.out.println( timeStr );

		LocalDate elapseDate = Instant.ofEpochMilli( time ).atZone( ZoneId.systemDefault() ).toLocalDate();
		LocalDateTime elaspseTime1 = Instant.ofEpochMilli( time ).atZone( ZoneId.systemDefault() ).toLocalDateTime();
		LocalDateTime elaspseTime2 = LocalDateTime.ofInstant( Instant.ofEpochMilli( time ), ZoneId.systemDefault() );

		System.out.println( elapseDate );
		System.out.println( elaspseTime1 );
		System.out.println( elaspseTime2 );

		long timeLong1 = LocalDateTime.parse( elaspseTime1.toString() ).atZone( ZoneId.systemDefault() ).toInstant().toEpochMilli();
		long timeLong2 = LocalDateTime.parse( elaspseTime2.toString() ).atZone( ZoneId.systemDefault() ).toInstant().toEpochMilli();
		long timeLong3 = LocalDateTime.parse( timeStr ).atZone( ZoneId.systemDefault() ).toInstant().toEpochMilli();

		System.out.println( timeLong1 );
		System.out.println( timeLong2 );
		System.out.println( timeLong3 );
	}

	@Test
	public void testLocalTime()
	{
		long time = 1493200745859L;
		String timeStr = "2017-04-26T15:29:05.859";

		long time2 = 1493183447359L;
		String timeStr2 = "2017-04-26T10:40:47.359";

		printTime( time, timeStr );
		printTime( time2, timeStr2 );
	}

	@Test
	public void sortTest()
	{
		List<Long> dur = new ArrayList<>();
		dur.add( 10122L );
		dur.add( 121212L );
		dur.add( 121L );
		dur.add( 222222L );
		dur.add( 5656L );

		System.out.println( Collections.max( dur ) );

		System.out.println( dur.stream().max( Long::compareTo ).orElse( -1l ) );
	}

	@Test
	public void readFileNames()
	{
		try
		{
			String rootPathStr = "E:\\Academic\\Angular";
			File folder = new File( rootPathStr );

			File[] files = folder.listFiles();
			//			int count = 0;
			Map<Long, File> timePlusNamesMap = new HashMap<>();
			//			Map<String, File> namePlusFilesMap = new HashMap<>();

			//			List<File> fileList = new ArrayList<>();
			if ( files != null )
			{
				for ( File file : files )
				{
					if ( file.isFile() )
					{
						String filePathStr = rootPathStr + File.separator + file.getName();
						Path filePath = Paths.get( filePathStr );
						BasicFileAttributes attr = Files.readAttributes( filePath, BasicFileAttributes.class );

						BasicFileAttributes view = Files.getFileAttributeView( filePath, BasicFileAttributeView.class ).readAttributes();

						//						System.out.println( "fileName: " + file.getName() );
						System.out.println( "creationTime: " + attr.creationTime() );
						System.out.println( "creationTime" + view.creationTime() );
						//						System.out.println( "----------------------------------------------" );
						//						System.out.println( "lastModifiedTime: " + attr.lastModifiedTime() );
						//						System.out.println( "lastModifiedTime" + view.lastModifiedTime() );

						timePlusNamesMap.put( attr.creationTime().toMillis(), file );
						//						namePlusFilesMap.put( file.getName(), file );

						//						System.out.println();
						//						System.out.println();

						//						fileList.add( file );
						//						count++;

						//						if ( count == 5 )
						//						{
						//							break;
						//						}
					}
					else if ( file.isDirectory() )
					{
						//					System.out.println( "Directory " + file.getName() );
					}
				}

				//				Arrays.sort( fileList.toArray( new File[fileList.size()] ), new Comparator<File>()
				//				{
				//					public int compare( File f1, File f2 )
				//					{
				//						return Long.compare( f1.lastModified(), f2.lastModified() );
				//					}
				//				} );
				//
				//				for ( File file : fileList )
				//				{
				//					System.out.println( "File " + file.getName() );
				//				}
			}

			Long[] newTimes = timePlusNamesMap.keySet().toArray( new Long[timePlusNamesMap.size()] );
			Arrays.sort( newTimes );

			int count = 0;
			for ( Long createdTime : newTimes )
			{
				count++;
				//				String fileName = timePlusNamesMap.get( createdTime );
				File file = timePlusNamesMap.get( createdTime );
				String name = file.getName();
				String newName = "" + count + name;
				System.out.println( newName );
				File newFile = new File( file.getParent(), newName );
				Files.move( file.toPath(), newFile.toPath() );
				//				break;
			}
		}
		catch ( IOException e )
		{
			e.printStackTrace();
		}
	}

	@Test
	public void checkTimes()
	{
		Map<Long, Integer> countMap = new HashMap<>();
		Map<Long, Long> timeMap = new HashMap<>();
		TimeTracker track = new TimeTracker();
		track.start();
		for ( int i = 0; i < 10000; i++ )
		{
			BigInteger bigInt = new BigInteger( String.valueOf( System.currentTimeMillis() ) + String.valueOf( new Random().nextInt( 1000 ) ) + String.valueOf( new Random().nextInt( 1000 ) ) );

			long ll = bigInt.longValue();

			timeMap.put( ll, System.currentTimeMillis() );
			if ( countMap.containsKey( ll ) )
			{
				countMap.put( ll, countMap.get( ll ) + 1 );
			}
			else
			{
				countMap.put( ll, 1 );
			}
		}
		System.out.println( "total = " + track.end() );

		for ( Map.Entry<Long, Integer> entry : countMap.entrySet() )
		{
			if ( entry.getValue() > 1 )
			{
				System.out.println( entry.getKey() + " = " + entry.getValue() );
				System.out.println( timeMap.get( entry.getKey() ) );
			}
		}
	}

	@Test
	public void testListIndex()
	{
		List<String> myList = new ArrayList<>();
		myList.add( "one" );
		myList.add( "two" );
		myList.add( "three" );
		myList.add( "four" );
		myList.add( "five" );

		System.out.println( "Inserted in 'order': " );
		printList( myList );

		// Clear the list
		myList.clear();

		myList.add( "four" );
		myList.add( "five" );
		myList.add( "one" );
		myList.add( "two" );
		myList.add( "three" );

		System.out.println( "\n" );
		System.out.println( "Inserted out of 'order': " );
		printList( myList );
	}

	private void printList( List<String> myList )
	{
		for ( String string : myList )
		{
			System.out.println( string );
		}
	}

	@Test
	public void testQueueAndStack()
	{
		Queue<Character> queue = new LinkedList<>();
		Stack<Character> stack = new Stack<>();

		queue.offer( 'A' );
		queue.offer( 'B' );

		System.out.println( queue.poll() );
		System.out.println( queue.poll() );

		stack.push( 'A' );
		stack.push( 'B' );

		System.out.println( stack.pop() );
		System.out.println( stack.pop() );

	}

}

