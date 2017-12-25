package data;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;
import static org.lwjgl.opengl.GL11.*;
import static helpers.Artist.*;

public class Boot {
		
	public static final int WIDTH=600, HEIGHT = 400;
			
	
		public Boot() {
			
			BeginSession();
			
			Tile tile= new Tile(0,0,64,64,TileType.Grass);
			Tile tile2= new Tile(0,64,64,64,TileType.Dirt);
			Tile tile3= new Tile(0,128,64,64,TileType.Dirt);
			
			while(!Display.isCloseRequested()) {
				tile.Draw();
				tile2.Draw();
				tile3.Draw();
				Display.update();
				Display.sync(60);						
			}
			
			Display.destroy();
		}
	
		public static void main(String[] args) {
			new Boot();
		}
}
