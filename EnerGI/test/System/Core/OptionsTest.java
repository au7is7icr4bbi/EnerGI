/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package System.Core;

import energi.Core.Options;
import energi.Shared.EngineException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author andrew
 */
public class OptionsTest {

    public OptionsTest() {
    }

	@BeforeClass
	public static void setUpClass() throws Exception {
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
	}

    @Before
    public void setUp() 
	{
		try
		{
			Options.saveToFile("properties.conf");
		}
		catch (EngineException e)
		{
			e.printCause();
			e.handleException();
		}
    }

    @After
    public void tearDown() {
    }

	/**
	 * Test of saveToFile method, of class Options.
	 */
	@Test
	public void testSaveToFile()
	{
		System.out.println("saveToFile");
		String filename = "properties.conf";
		try
		{
			Options.saveToFile(filename);
		}
		catch (EngineException e)
		{
			e.printCause();
			e.handleException();
		}
	}

	/**
	 * Test of getValueForKey method, of class Options.
	 */
	@Test
	public void testGetValueForKey()
	{
		System.out.println("getValueForKey");
		String key = "Key";
		try
		{
			Options.getFromFile("properties.conf");
		}
		catch (EngineException e)
		{
			e.printCause();
			e.handleException();
		}
		String expResult = "Value";
		Options.setValueForKey(key, "Value");
		String result = Options.getValueForKey(key);
		assertEquals(expResult, result);
	}

	/**
	 * Test of setValueForKey method, of class Options.
	 */
	@Test
	public void testSetValueForKey()
	{
		System.out.println("setValueForKey");
		String key = "Key";
		String value = "Value";
		try
		{
			Options.getFromFile("properties.conf");
		}
		catch (EngineException e)
		{
			e.printCause();
			e.handleException();
		}
		Options.setValueForKey(key, value);
		assertEquals(Options.getValueForKey(key), value);
	}

}