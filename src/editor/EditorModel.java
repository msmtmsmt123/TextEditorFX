package editor;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 * Version 0.2
 * @author htha9587
 * 6-8-16
 */



public class EditorModel 
{
	/**
	 * Saves changes to files and makes a printStackTrace if a failure occurs.
	 * @param textFile
	 */
	public void save(TextFile textFile)
	{
		try
		{
			Files.write(textFile.getFile(), textFile.getContent(), StandardOpenOption.CREATE);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Loads and reads all lines from the text file.
	 * @param file
	 * @return
	 */
	public IOResult <TextFile> load (Path file)
	{
		try
		{
			List<String> lines = Files.readAllLines(file);
			return new IOResult<>(true, new TextFile( file, lines));
		}
		catch(IOException e)
		{
			e.printStackTrace();
			return new IOResult<>(false, null);
		}
		
	}
	/**
	 * Closes the application.
	 */
	public void close()
	{
		System.exit(0);
	}
	
	
}
