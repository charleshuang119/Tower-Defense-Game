package data;

import static helpers.Artist.BeginSession;

import org.lwjgl.opengl.Display;

import helpers.Clock;
import helpers.StateManager;

public class Boot {
		
	public static final int WIDTH=600, HEIGHT = 400;
			
	
		public Boot() {
			
			//Call static method in Artist class to initialize OpenGL calls
			BeginSession();
			
			//Main game loop
			while(!Display.isCloseRequested()) {
				Clock.update();
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
