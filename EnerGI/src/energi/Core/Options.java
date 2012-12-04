/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package energi.Core;
import java.util.Properties;
import energi.Shared.*;
import java.io.*;

/**
 * Represents a unified container for game options. Uses key-value pairing for storage and retrieval
 * @author andrew
 * @version 1.0
 */
public class Options
{
	private static Properties properties = new Properties();

	/**
	 * Used to load options from a file. If file does not exist, an empty Options object is created
	 * @param filename The options file
	 * @throws EngineException
	 */
	public static void getFromFile(String filename) throws EngineException
	{
		// load the property list from the file
		try
		{
			properties.load(new FileInputStream(new File(filename)));
		}
		
		catch (IOException e)
		{
			throw new EngineException("Content pipeline error: " + e.getMessage(), ExceptionAction.CONTINUE, null);
		}
	}

	/**
	 * Save the stored options to a file. If the file does not exist, a new one is created
	 * @param filename The options file
	 * @throws EngineException
	 */
	public static void saveToFile(String filename) throws EngineException
	{
		try
		{
			properties.store(new FileOutputStream(new File(filename)), "Settings");
		}
		catch (IOException e)
		{
			// do nothing, a new file will be created
		}
	}

	/**
	 * Get the value for a specific key in the options file
	 * @param key Property key string
	 * @return Value associated with key as a string, or null if key does not exist
	 */
	public static String getValueForKey(String key)
	{
		return properties.getProperty(key);
	}

	/**
	 * Set a value for a specific key. If key doesn't exist, it is added to the property list
	 * @param key Key string you wish to bind a value to
	 * @param value The value you wish to store
	 */
	public static void setValueForKey(String key, String value)
	{
		properties.setProperty(key, value);
	}
}
