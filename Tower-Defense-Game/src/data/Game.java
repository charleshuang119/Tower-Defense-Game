package data;

import static helpers.Artist.QuickLoad;
import static helpers.Artist.TILE_SIZE;
import static helpers.Artist.DrawQuadTex;
import org.lwjgl.input.Mouse;

import UI.Button;
import UI.UI;
import UI.UI.Menu;

public class Game {

	private TileGrid grid;
	private Player player;
	private WaveManager waveManager;
	private UI gameUI;
	private Menu towerPickerMenu;

	public Game(TileGrid grid) {
		this.grid = grid;

		waveManager = new WaveManager(
				new Enemy(QuickLoad("enemy64"), grid.getTile(2, 0), grid, TILE_SIZE, TILE_SIZE, 70, 25), 2, 2);
		player = new Player(grid, waveManager);
		player.setup();
		setupUI();

	}

	private void setupUI() {
		gameUI = new UI();
		//towerPickerUI.addButton("CannonBlue", "cannonGunBlue", 0, 0);
		//towerPickerUI.addButton("CannonIce", "cannonIceGun", 64, 0);
		gameUI.createMenu("TowerPicker", 1280, 100,192,960,2,0);
		towerPickerMenu = gameUI.getMenu("TowerPicker");
		towerPickerMenu.quickAdd("BlueCannon", "cannonBaseBlue");
		towerPickerMenu.quickAdd("IceCannon","cannonIceBase");
		
	}

	private void updateUI() {
		gameUI.draw();
		if (Mouse.next()) {
			boolean mouseClicked = Mouse.isButtonDown(0);
			if (mouseClicked) {
				if (towerPickerMenu.isButtonClicked("BlueCannon")) {
					player.pickTower(new TowerCannonBlue(TowerType.CannonBlue, grid.getTile(0, 0),
							waveManager.getCurrentWave().getEnemyList()));
				}
				if(towerPickerMenu.isButtonClicked("IceCannon")) {
					player.pickTower(new TowerCannonIce(TowerType.CannonIce,grid.getTile(0, 0),waveManager.getCurrentWave().getEnemyList()));
				}
			}
		}
	}

	public void Update() {
		DrawQuadTex(QuickLoad("menu_background2"),1280,0,192,960);
		grid.draw();
		waveManager.update();
		player.update();
		updateUI();

	}
}
