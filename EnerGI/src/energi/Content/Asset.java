/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package energi.Content;
import java.io.*;
import energi.Shared.*;
/**
 * Abstract class used by all kinds of asset file. Both functions should not and cannot be overridden.
 * @author andrew
 * @version 1.0
 */
public abstract class Asset implements Serializable
{
	/**
	 * Used to import an asset from an existing file. The returned asset is then casted to an object that extends Asset.
	 * @param f The filename
	 * @return a new asset object which is then casted to an asset subclass
	 * @throws EngineException
	 */
	public static Asset load(String f) throws EngineException
	{
		ObjectInputStream o = null;
		try
		{
			o = new ObjectInputStream(new FileInputStream(new File(f)));
		}
		catch (IOException e)
		{
			throw new EngineException("Content pipeline error: " + e.getMessage(), ExceptionAction.EXIT, null);
		}
		
		Asset asset = null;
		try
		{
			asset = (Asset)o.readObject();
		}
		catch (IOException e)
		{
			throw new EngineException("Content pipeline error: " + e.getMessage(), ExceptionAction.EXIT, null);
		}
		catch (ClassNotFoundException e)
		{
			throw new EngineException("Invalid asset", ExceptionAction.EXIT, null);
		}
		return asset;
	}
	
	/**
	 * Save the asset object for later reuse
	 * @param f The filename
	 * @throws EngineException
	 */
	final public void save(String f) throws EngineException
	{
		ObjectOutputStream o = null;
		try
		{
			o = new ObjectOutputStream(new FileOutputStream(new File(f)));
		}
		catch (IOException e)
		{
		}
		
		try
		{
			o.writeObject(this);
		}
		catch (IOException e)
		{
			throw new EngineException("Content pipeline error:" + e.getMessage(), ExceptionAction.CONTINUE, null);
		}
	}
}
