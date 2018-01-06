package data;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;

import helpers.Clock;
import helpers.StateManager;

import static org.lwjgl.opengl.GL11.*;
import static helpers.Artist.*;

public class Boot {
		
	public static final int WIDTH=600, HEIGHT = 400;
			
	
		public Boot() {
			
			BeginSession();
			

		
			
			//Game game = new Game(map);
			
			while(!Display.isCloseRequested()) {
				Clock.update();
				//game.Update();
				StateManager.update();
				Display.update();
				Display.sync(60);						
			}
			
			Display.destroy();
		}
	
		public static void main(String[] args) {
			new Boot();
		}
}
