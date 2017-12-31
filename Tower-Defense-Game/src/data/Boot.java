package data;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;

import helpers.Clock;

import static org.lwjgl.opengl.GL11.*;
import static helpers.Artist.*;

public class Boot {
		
	public static final int WIDTH=600, HEIGHT = 400;
			
	
		public Boot() {
			
			BeginSession();
			

			int[][] map= {
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,1,1,0,0,1,1,0,0,0,0,0,0,0,0},
					{0,0,1,0,0,0,0,1,0,1,1,0,1,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0},
					{0,0,0,2,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,2,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			};
			
			TileGrid grid = new TileGrid(map);
			grid.SetTile(3, 4, grid.GetTile(1,1).getType());
			Enemy e = new Enemy(QuickLoad("enemy64"),grid.GetTile(10, 10),64,64,2);
			while(!Display.isCloseRequested()) {
				Clock.update();
				e.Update();
				grid.Draw();
				e.Draw();
				
				Display.update();
				Display.sync(60);						
			}
			
			Display.destroy();
		}
	
		public static void main(String[] args) {
			new Boot();
		}
}
