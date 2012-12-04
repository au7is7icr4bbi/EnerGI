/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package energi.Shared;

import energi.Shared.EngineException;
import energi.Shared.ExceptionAction;
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
public class EngineExceptionTest {
	
	public EngineExceptionTest() {
	}

	@BeforeClass
	public static void setUpClass() throws Exception {
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
	}
	
	@Before
	public void setUp() {
	}
	
	@After
	public void tearDown() {
	}

	/**
	 * Test of printCause method, of class EngineException.
	 */
	@Test
	public void testPrintCause()
	{
		System.out.println("printCause");
		EngineException instance = new EngineException("Test error", ExceptionAction.EXIT, null);
		instance.printCause();
	}
	
}
