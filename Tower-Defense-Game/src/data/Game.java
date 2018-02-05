package data;

import static helpers.Artist.QuickLoad;
import static helpers.Artist.TILE_SIZE;
import static helpers.Artist.DrawQuadTex;
import org.lwjgl.input.Mouse;

import UI.Button;
import UI.UI;

public class Game {

	private TileGrid grid;
	private Player player;
	private WaveManager waveManager;
	private UI towerPickerUI;

	public Game(int[][] map) {
		grid = new TileGrid(map);

		waveManager = new WaveManager(
				new Enemy(QuickLoad("enemy64"), grid.getTile(14, 8), grid, TILE_SIZE, TILE_SIZE, 70, 25), 2, 2);
		player = new Player(grid, waveManager);
		player.setup();
		setupUI();

	}

	private void setupUI() {
		towerPickerUI = new UI();
		//towerPickerUI.addButton("CannonBlue", "cannonGunBlue", 0, 0);
		//towerPickerUI.addButton("CannonIce", "cannonIceGun", 64, 0);
		towerPickerUI.createMenu("TowerPicker", 1312, 0,2,0);
		towerPickerUI.getMenu("TowerPicker").addButton(new Button("CannonBlue", QuickLoad("cannonGunBlue"), 0, 0));
		towerPickerUI.getMenu("TowerPicker").addButton(new Button("CannonIce", QuickLoad("cannonIceBase"), 0, 0));
		towerPickerUI.getMenu("TowerPicker").addButton(new Button("CannonBlue", QuickLoad("cannonGunBlue"), 0, 0));
		towerPickerUI.getMenu("TowerPicker").addButton(new Button("CannonIce", QuickLoad("cannonIceBase"), 0, 0));
		towerPickerUI.getMenu("TowerPicker").addButton(new Button("CannonBlue", QuickLoad("cannonGunBlue"), 0, 0));
		towerPickerUI.getMenu("TowerPicker").addButton(new Button("CannonBlue", QuickLoad("cannonGunBlue"), 0, 0));
		
	}

	private void updateUI() {
		towerPickerUI.draw();
		if (Mouse.next()) {
			boolean mouseClicked = Mouse.isButtonDown(0);
			if (mouseClicked) {
				if (towerPickerUI.getMenu("TowerPicker").isButtonClicked("CannonBlue")) {
					player.pickTower(new TowerCannonBlue(TowerType.CannonBlue, grid.getTile(0, 0),
							waveManager.getCurrentWave().getEnemyList()));
				}
				if(towerPickerUI.getMenu("TowerPicker").isButtonClicked("CannonIce")) {
					player.pickTower(new TowerCannonIce(TowerType.CannonIce,grid.getTile(0, 0),waveManager.getCurrentWave().getEnemyList()));
				}
			}
		}
	}

	public void Update() {
		DrawQuadTex(QuickLoad("menu_background"),1280,0,192,960);
		grid.draw();
		waveManager.update();
		player.update();
		updateUI();

	}
}
