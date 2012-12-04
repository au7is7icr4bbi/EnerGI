/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package energi.Shared;
import org.lwjgl.LWJGLException;

/**
 * Represents a generic exception thrown within the game engine
 * @author andrew
 * @version 1.0
 */

public class EngineException extends Throwable implements ExceptionHandler
{
	private static final long serialVersionUID = 1L;
	private String message;
	private ExceptionAction action;
	private ExceptionHandler handler;
	
	/**
	 * Initialise the exception object as a generic error
	 */
	public EngineException()
	{
		// do nothing, 
	}
	
	/**
	 * Initialise the exception object from an LWJGL exception. Internal use only
	 * @param e An LWJGL exception object
	 */
	public EngineException(LWJGLException e)
	{
		message = "LWJGL Exception: " + e.getMessage();
		action = ExceptionAction.EXIT;
		handler = null;
	}
	
	/**
	 * Initialise the exception object with a message to print before the stack trace
	 * @param m The error string
	 * @param a An enumerated value dictating the action taken
	 * @param h An object that implements the ExceptionHandler interface
	 */
	public EngineException(String m, ExceptionAction a, ExceptionHandler h)
	{
		message = "EnerGI Exception: " + m;
		action = a;
		handler = h;
	}
	
	/**
	 * Print the cause of the error. If no string is supplied, "Unknown engine error" is printed
	 */
	final public void printCause()
	{
		if (message.isEmpty())
		{
			System.out.println("Unknown engine error");
		}
		else
		{
			System.out.println(message);
		}
	}
	
	/**
	 * Handle the exception depending on the selected option and the supplied exception handler
	 */
	final public void handleException()
	{
		if (action == ExceptionAction.EXIT)
		{
			System.exit(-1);
		}
		else if (action == ExceptionAction.USER)
		{
			// handle the exception with a user-defined method if one is defined, otherwise do nothing
			if (handler != null)
			{
				handler.handleException();
			}
		}
	}
}
