/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package energi.Shared;

/**
 * Interface class for event handling. Subclasses are passed to relevant event-driven objects
 * @author andrew
 * @version 1.1
 */

public interface EventHandler
{
	/**
	 * Handle a particular event
	 * @param o The argument passed by the event. This includes information relevant to the event.
	 */
	void handleEvent(Object o);
}
