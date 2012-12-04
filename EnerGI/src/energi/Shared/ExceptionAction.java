/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package energi.Shared;

/**
 * Defines three possible methods of handling an exception. The first two are system-integrated, whereas the third allows for a user-defined handler
 * @author andrew
 * @version 1.0
 */
public enum ExceptionAction
{
	/**
	 * Terminate the program
	 */
	EXIT,
	/**
	 * Keep the program going without any further action
	 */
	CONTINUE,
	/**
	 * Execute a user-defined handler method passed in upon creation of the exception
	 */
	USER,
}
