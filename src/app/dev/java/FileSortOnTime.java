package app.dev.java;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by java on 04/04/2018.
 */
public class FileSortOnTime
{
	@Test
	public void sortFileByCreatedTime()
	{
		try
		{
			List<String> textList = Files.lines( Paths.get( "F:\\GIT\\TRUNK\\DashBoardClient\\conf\\logReqFile.html" ) ).collect( Collectors.toList() );
			for ( String text : textList )
			{
				text = text.replaceAll( "%", "%%" );
				text = String.format( text.replaceAll( "\\{\\d\\}", "%s" ), "" );

				System.out.println( text );
			}

			String rootPathStr = "E:\\Academic\\Angular";
			File folder = new File( rootPathStr );

			File[] files = folder.listFiles();
			Map<Long, File> timePlusNamesMap = new HashMap<>();
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

						System.out.println( "creationTime: " + attr.creationTime() );
						System.out.println( "creationTime" + view.creationTime() );

						timePlusNamesMap.put( attr.creationTime().toMillis(), file );
					}
					else if ( file.isDirectory() )
					{
						System.out.println( "Directory " + file.getName() );
					}
				}
			}

			Long[] newTimes = timePlusNamesMap.keySet().toArray( new Long[timePlusNamesMap.size()] );
			Arrays.sort( newTimes );

			int count = 0;
			for ( Long createdTime : newTimes )
			{
				count++;
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
}
