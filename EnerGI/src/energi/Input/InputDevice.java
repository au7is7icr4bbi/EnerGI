/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package energi.Input;
import energi.Shared.*;
import java.util.LinkedList;
import org.lwjgl.input.*;
import org.lwjgl.LWJGLException;
/**
 * Generic container for an input device (gamepad or keyboard & mouse)
 * @author andrew
 * @version 1.0
 */
public class InputDevice
{
	static private LinkedList <InputEvent> registeredEvents;
	
	/**
	 * Initialise the event queue, create the input devices and allow repeat keyboard events
	 * @throws EngineException 
	 */
	public static void init() throws EngineException
	{
		registeredEvents = new LinkedList <InputEvent>();
		try
		{
			Keyboard.create();
			Controllers.create();
			Mouse.create();
		}
		catch (LWJGLException e)
		{
			throw new EngineException("LWJGL error: " + e.getMessage(), ExceptionAction.CONTINUE, null);
		}
		Keyboard.enableRepeatEvents(true);
	}
	/**
	 * Register an event in the event queue
	 * @param e The input event
	 * @throws EngineException 
	 */
	public static void registerEvent(InputEvent e) throws EngineException
	{
		if(!registeredEvents.add(e))
		{
			throw new EngineException("Could not register event", ExceptionAction.CONTINUE, null);
		}
	}
	
	/**
	 * Scan for triggered events
	 */
	public static void scanEvents()
	{
		// check for keyboard events. A keyboard state check is more efficient in this method.
		for (int i = 0; i < registeredEvents.size(); i++)
		{
			registeredEvents.get(i).handleKeyEvent();
		}
		
		// check all mouse event types
		while (Mouse.next())
		{
			for (int i = 0; i < registeredEvents.size(); i++)
			{
				if (Mouse.getEventButtonState())
				{
					switch (Mouse.getEventButton())
					{
						case 0:
							registeredEvents.get(i).handleButtonEvent(MouseEvents.ButtonLeft);
							break;
						case 1:
							registeredEvents.get(i).handleButtonEvent(MouseEvents.ButtonRight);
							break;
						case 2:
							registeredEvents.get(i).handleButtonEvent(MouseEvents.ButtonMiddle);
							break;
					}
					if (Mouse.getEventDWheel() != 0)
					{
						registeredEvents.get(i).handleDelta(Mouse.getEventDWheel(), Axis.Z);
					}
					if (Mouse.getEventDX() != 0)
					{
						registeredEvents.get(i).handleDelta(Mouse.getEventDX(), Axis.X);
					}
					if (Mouse.getEventDY() != 0)
					{
						registeredEvents.get(i).handleDelta(Mouse.getEventDY(), Axis.Y);
					}
					if (Mouse.getEventX() != 0)
					{
						registeredEvents.get(i).handleAbsolute(Mouse.getEventX(), Axis.X);
					}
					if (Mouse.getEventY() != 0)
					{
						registeredEvents.get(i).handleAbsolute(Mouse.getEventY(), Axis.Y);
					}
				}
				
			}
		}
		// check for controller events
		while (Controllers.next())
		{
			for (int i = 0; i < registeredEvents.size(); i++)
			{
				// event is a button press
				if (Controllers.isEventButton())
				{
					registeredEvents.get(i).handleControllerEvent(Controllers.getEventControlIndex());
				}
				// event is an X-axis change
				if (Controllers.isEventXAxis())
				{
					if (!registeredEvents.get(i).handleAxisEvent(Axis.X, InputEvent.Stick.RAxis, Controllers.getEventSource().getRXAxisValue()))
						registeredEvents.get(i).handleAxisEvent(Axis.X, InputEvent.Stick.LAxis, Controllers.getEventSource().getXAxisValue());
				}
				// event is a POV X-axis change
				if (Controllers.isEventPovX())
				{
					registeredEvents.get(i).handleAxisEvent(Axis.X, InputEvent.Stick.POV, Controllers.getEventSource().getPovX());
				}
				// event is a Y-axis change
				if (Controllers.isEventYAxis())
				{
					// determine which stick was used
					if (!registeredEvents.get(i).handleAxisEvent(Axis.Y, InputEvent.Stick.RAxis, Controllers.getEventSource().getRYAxisValue()))
						registeredEvents.get(i).handleAxisEvent(Axis.Y, InputEvent.Stick.LAxis, Controllers.getEventSource().getYAxisValue());
				}
				// event is a POV Y-axis change
				if (Controllers.isEventPovY())
				{
					registeredEvents.get(i).handleAxisEvent(Axis.Y, InputEvent.Stick.POV, Controllers.getEventSource().getPovY());
				}
			}
		}
	}
}
