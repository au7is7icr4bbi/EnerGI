/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package energi.Shared;

/**
 * Defines a function which a developer can override to create a user-defined action for an EngineException
 * @author andrew
 * @version 1.0
 */
public interface ExceptionHandler
{
	/**
	 * Handle the exception to which the subclass is passed to.
	 */
	public void handleException();
}
