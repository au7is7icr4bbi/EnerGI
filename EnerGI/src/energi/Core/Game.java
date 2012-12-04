package energi.Core;
import energi.Input.InputDevice;
import java.util.LinkedList;
import energi.Shared.*;
import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Controllers;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.openal.AL;

/**
 * Core game object. Handles the application loop and update/draw cycles.
 * This class must be subclassed, and must have its super functions called.
 * A device constant must also be specified in the subclass, within the init function
 * @author andrew
 * @version 1.0
 */
public abstract class Game extends Thread implements GameObject
{
	private LinkedList <GameObject> gameObjects;
	/**
	 * Set this to true to trigger an exit condition
	 */
	protected boolean close = false;
	private float time = 0; // counter used for translation calculations
	static private Game instance; // initialised during the init function call. Pointer to self.
	private float lastTime = 0;

	/**
	 * Initialise the game
	 */
	public Game()
	{
		time = 0;
                lastTime = 0;
		gameObjects = new LinkedList<GameObject>();
	}

	/**
	 * Adds a game object to the list of available game objects
	 * @param obj The game object to add
	 */
	final public void addObject(GameObject obj)
	{
		gameObjects.add(obj);
	}
	
        /**
         * Gets the current game instance
         * @return The game instance
         */
	static public Game getInstance()
	{
		return instance;
	}

	/**
	 * Initialise OpenGL with preset height and width values
	 * @param width Viewport (window) width
	 * @param height Viewport (window) height
	 * @throws EngineException
	 */
	private void GLInit(int width, int height) throws EngineException
	{
		try
		{
			Display.setDisplayMode(new DisplayMode(width,height));
			Display.create();
			Display.setVSyncEnabled(true);
		}
		catch (LWJGLException e)
		{
			throw new EngineException(e);
		}
		glEnable(GL_TEXTURE_2D);
		glShadeModel(GL_SMOOTH);
		glDisable(GL_DEPTH_TEST);
		glDisable(GL_LIGHTING);
		glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
		glClearDepth(1);
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		glViewport(0, 0, width, height);
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, width, 0, height, 1, -1);
		glMatrixMode(GL_MODELVIEW);
	}

	/**
	 * Overrides GameObject's init() function. Calls the init() function for every stored game object.
	 * Subclasses should override this function to create and store all necessary game assets.
	 * @see GameObject
	 * @throws EngineException
	 */
	public void init() throws EngineException
	{
		instance = this;
		GLInit(1024, 768);
		InputDevice.init();
		for (int i = 0; i < gameObjects.size(); i++)
		{
			gameObjects.get(i).init();
		}
	}
	
	private float getTime()
	{
		return (float)(Sys.getTime() * 1000) / (float)Sys.getTimerResolution();
	}
	
        /**
         * Get the elapsed game time since the last update/Draw cycle
         * @return The time delta, expressed in seconds
         */
	public float getDelta()
	{
		time = getTime();
		float delta = time - lastTime;
		lastTime = time;
 
		return delta;
	}

	/**
	 * Starts the game by initialising the game, then starting the application loop on a new thread.
	 */
	@Override
	final public void run()
	{
		try
		{
			init();
			while (!Display.isCloseRequested() || !close)
			{
                            // calculate the elapsed game time for use in the update and draw cycles
                            float delta = getDelta();
                            
                            // update and draw
                            update(delta);
                            Draw(delta);
			}
			AL.destroy();
			Display.destroy();
			Controllers.destroy();
			Keyboard.destroy();
			Mouse.destroy();
		}
		catch (EngineException e)
		{
			e.printCause();
			e.handleException();
		}
	}

	/**
	 * Overrides GameObject's update() function. Calls the update() function
	 * for every stored game object
	 * @see GameObject
	 * @throws EngineException
	 */
	public void update(float delta) throws EngineException
	{
		InputDevice.scanEvents();
		for (int i = 0; i < gameObjects.size(); i++)
		{
                    gameObjects.get(i).update(delta);
		}
	}

	/**
	 * Overrides GameObject's Draw() function. Calls the Draw() function
	 * for every stored game object (if the object is Drawable)
	 * @see GameObject
	 * @throws EngineException
	 */
	public void Draw(float delta) throws EngineException
	{
		glClear(GL_COLOR_BUFFER_BIT);
		for (int i = 0; i < gameObjects.size(); i++)
		{
			gameObjects.get(i).Draw(delta);
		}
		Display.update();
		Display.sync(60);
	}
	
	/**
	 * Entry point for alternative methods of closing the program, allowing for deallocation of system resources
	 */
	public final void exit()
	{
		Display.destroy();
		System.exit(0);
	}
}
