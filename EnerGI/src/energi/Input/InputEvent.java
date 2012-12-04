/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package energi.Input;
import energi.Shared.Axis;
import energi.Shared.EventHandler;
import org.lwjgl.input.Keyboard;

/**
 * Represents an input event
 * @author andrew
 * @version 1.0
 */
public class InputEvent
{
	private EventHandler handler;
	private Keys key = null;
	private MouseEvents event = null;
	private Axis axis = null;
	private int buttonIndex;
	private boolean isController = false;
        
        /**
         * Represents the 3 common directional controls on a gamepad (D-Pad, Left and Right Control Sticks)
         */
	public enum Stick
	{
		/**
		 * Point-of-View. Commonly referred to as a Directional Pad, or D-Pad on most controllers
		 */
		POV,
		/**
		 * Right Control Stick. Referred to as a C-stick on Nintendo Controllers
		 */
		RAxis,
		/**
		 * Left Control Stick. Present on all modern controllers
		 */
		LAxis;
	}
	private Stick controlledStick;
	/**
	 * Construct a new input event from a key and event handler
	 * @param k A value from the Keys class corresponding to a keyboard key
	 * @param h The event handler
	 */
	public InputEvent(Keys k, EventHandler h)
	{
		key = k;
		handler = h;
		isController = false;
	}
	
	/**
	 * Construct a new event from a MouseEvent constant and event handler
	 * @param event The mouse event
	 * @param h The event handler
	 */
	public InputEvent(MouseEvents event, EventHandler h)
	{
		this.event = event;
		handler = h;
		switch (event)
		{
			case DeltaX:
			case AbsX:
				axis = Axis.X;
				break;
			case DeltaY:
			case AbsY:
				axis = Axis.Y;
				break;
			case DeltaWheel:
				axis = Axis.Z;
				break;
		}
		isController = false;
	}
	
	/**
	 * Construct a new event from a controller button index and an event handler
	 * @param b The button identifier. This varies between different brands of controller.
	 * @param h The event handler
	 */
	public InputEvent(Buttons b, EventHandler h)
	{
		buttonIndex = b.ordinal();
		handler = h;
		isController = true;
	}
	
	/**
	 * Constructs a new event from an axis, a stick on a controller, and an event handler
	 * @param a The axis on which the event will trigger.
	 * @param stick The stick from which the event will be triggered from. Either POV, LAxis or RAxis
	 * @param h The event handler
	 */
	public InputEvent(Axis a, Stick stick, EventHandler h)
	{
		axis = a;
		handler = h;
		isController = true;
		controlledStick = stick;
	}
	
	/**
	 * Determines whether the event was triggered. If so, the handler is invoked. Otherwise, it is ignored.
	 */
	final public void handleKeyEvent()
	{
		if (key != null && Keyboard.isKeyDown(key.getID()))
		{
			handler.handleEvent(null);
		}
	}
	
	/**
	 * Determines if a mouse or gamepad has triggered a change in movement
	 * @param pos The relative movement of the mouse or a gamepad control stick
	 * @param a The movement axis
	 */
	final public void handleDelta(float pos, Axis a)
	{
		if (pos != 0 && a == axis)
		{
			handler.handleEvent(pos);
		}
	}
	
	/**
	 * Determines the absolute position of the mouse cursor
	 * @param pos The absolute value
	 * @param a The movement axis
	 */
	final public void handleAbsolute(float pos, Axis a)
	{
		if (pos != 0 && a == axis && !isController)
		{
			handler.handleEvent(pos);
		}
	}
	
	/**
	 * Determines which button caused an event, and handles it
	 * @param button The mouse button that triggered the event
	 */
	final public void handleButtonEvent(MouseEvents button)
	{
		if (button == event && button.ordinal() > 4 && !isController)
		{
			handler.handleEvent(0);
		}
	}
	
	/**
	 * Determines the button that caused a controller event, and handles it
	 * @param buttonIndex The button index from the event controller
	 */
	final public void handleControllerEvent(int buttonIndex)
	{
		if (this.buttonIndex == buttonIndex && isController)
		{
			handler.handleEvent(null);
		}
	}
	
	/**
	 * Determines if a control stick or D-Pad has triggered an event. If so, it handles it.
	 * @param a The axis on which the event occurred.
	 * @param stick The stick on which the event occurred
	 * @param val The direction of the axis movement. Between -1 and 1
	 */
	final public boolean handleAxisEvent(Axis a, Stick stick, float val)
	{
		if (controlledStick != null && this.axis == a && controlledStick == stick && Math.round(Math.abs(val)) != 1)
		{
			if (isController)
			{
				handler.handleEvent(val);
			}
			return true;
		}
		return false;
	}
}
