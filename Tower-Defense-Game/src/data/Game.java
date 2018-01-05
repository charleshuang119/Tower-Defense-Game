package data;

import static helpers.Artist.QuickLoad;

public class Game {
	
	private TileGrid grid;
	private Player player;
	private WaveManager waveManager;
	
	

	public Game(int[][] map) {
		grid = new TileGrid(map);
		
		waveManager = new WaveManager(new Enemy(QuickLoad("enemy64"),grid.GetTile(14, 8),grid, 64,64,70),
				2,2);
		player = new Player(grid,waveManager);
		
	}
		
	public void Update() {
		grid.Draw();
		waveManager.update();
		player.update();
		
	
	}
}
