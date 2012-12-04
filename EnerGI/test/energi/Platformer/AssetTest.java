/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package energi.Platformer;
import energi.Content.Asset;
import java.io.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import energi.Shared.EngineException;

/**
 *
 * @author andrew
 */
public class AssetTest 
{
	
	public AssetTest()
	{
	}

	@BeforeClass
	public static void setUpClass() throws Exception
	{
	}

	@AfterClass
	public static void tearDownClass() throws Exception
	{
	}
	
	@Before
	public void setUp()
	{
		ObjectOutputStream o = null;
		try
		{
			o = new ObjectOutputStream(new FileOutputStream(new File("Ground.tile")));		
		}
		catch (IOException e)
		{
			
		}
		
		try
		{
			o.writeObject(new Tile());
			o.close();
		}
		catch (IOException e)
		{
			
		}
	}
	
	@After
	public void tearDown() {
	}

	/**
	 * Test of load method, of class Asset.
	 */
	@Test
	public void testLoad()
	{
		System.out.println("load");
		String f = "Ground.tile";
		Tile expected = new Tile();
		Tile result = null;
		try
		{
			result = (Tile)Asset.load(f);
		}
		catch (EngineException e)
		{
			e.printCause();
			e.handleException();
		}
		assertEquals(expected.getName(), result.getName());
		// TODO review the generated test code and remove the default call to fail.
		//fail("The test case is a prototype.");
	}

	/**
	 * Test of save method, of class Asset.
	 */
	@Test
	public void testSave() {
		System.out.println("save");
		String f = "Ground.tile";
		Tile instance = new Tile();
		Tile loadedTile = null;
		try
		{
			instance.save(f);
			loadedTile = (Tile)Asset.load(f);
		}
		catch (EngineException e)
		{
			e.printCause();
			e.handleException();
		}
		assertEquals(instance.getName(), loadedTile.getName());
		// TODO review the generated test code and remove the default call to fail.
		//fail("The test case is a prototype.");
	}
}

class Tile extends Asset
{
	private static final long serialVersionUID = 1L;
	private String name;
	public Tile()
	{
		name = "Ground";
	}
		
	public String getName()
	{
		return name;
	}
}
