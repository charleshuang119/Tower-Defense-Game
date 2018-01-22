package data;

import static helpers.Artist.QuickLoad;
import static helpers.Artist.TILE_SIZE;
public class Game {
	
	private TileGrid grid;
	private Player player;
	private WaveManager waveManager;
	private TowerCannonBlue blue;
	
	
	

	public Game(int[][] map) {
		grid = new TileGrid(map);
		
		waveManager = new WaveManager(new Enemy(QuickLoad("enemy64"),grid.getTile(14, 8),grid, TILE_SIZE,TILE_SIZE,70,25),
				2, 2);
		player = new Player(grid,waveManager);
		player.setup();
		
		
	}
		
	public void Update() {
		grid.draw();		
		waveManager.update();
		player.update();

	
	}
}
