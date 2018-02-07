package data;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import helpers.Clock;

import static helpers.Artist.*;

import java.util.ArrayList;

public class Player {

	private TileGrid grid;
	private TileType[] types;
	private WaveManager waveManager;
	private ArrayList<Tower> towerList;
	private boolean leftMouseButtonDown, rightMouseButtonDown, holdingTower;
	private Tower tempTower;
	public static int Cash, Lives;

	public Player(TileGrid grid, WaveManager waveManager) {
		this.grid = grid;
		this.types = new TileType[3];
		this.types[0] = TileType.Grass;
		this.types[1] = TileType.Dirt;
		this.types[2] = TileType.Water;
		this.waveManager = waveManager;
		this.towerList = new ArrayList<Tower>();
		this.leftMouseButtonDown = false;
		this.rightMouseButtonDown = false;
		this.holdingTower = false;
		this.tempTower = null;
		Cash = 0;
		Lives = 0;

	}

	// Initialize Cash and Lives value for player
	public void setup() {
		Cash = 50;
		Lives = 3;
	}

	//Check if player can afford  tower, if so , charge player tower cost
	public static boolean modifyCash(int amount) {
		if (Cash + amount >= 0) {
			Cash = Cash + amount;
			System.out.println(Cash);
			return true;
		}
		System.out.println(Cash);
		return false;
	}

	public static void modifyLives(int amount) {
		Lives += amount;
	}

	public void update() {

		// Update holding tower
		if (holdingTower) {
			tempTower.setX(getMouseTile().getX());
			tempTower.setY(getMouseTile().getY());
			if(!(tempTower.getX()<64&&tempTower.getY()<64)) {
				tempTower.draw();
			}
		}

		// Update all tower in the game
		for (Tower t : towerList) {
			t.update();
			t.draw();
			t.updateEnemyList(waveManager.getCurrentWave().getEnemyList());
		}
		// 0 left, 1 right, handle mouse input
		if (Mouse.isButtonDown(0) && !leftMouseButtonDown) {
			placeTower();
		}

		if (Mouse.isButtonDown(1) && !rightMouseButtonDown) {
			System.out.println("Right clicked");
		}
		leftMouseButtonDown = Mouse.isButtonDown(0);
		rightMouseButtonDown = Mouse.isButtonDown(1);

		// Handle keyboard input
		while (Keyboard.next()) {
			if (Keyboard.getEventKey() == Keyboard.KEY_RIGHT && Keyboard.getEventKeyState()) {
				Clock.ChangeMultiplier(0.2f);
			}
			if (Keyboard.getEventKey() == Keyboard.KEY_LEFT && Keyboard.getEventKeyState()) {
				Clock.ChangeMultiplier(-0.2f);
			}

		}
	}

	private void placeTower() {
		Tile currentTile = getMouseTile();
		
		if (holdingTower) {
			if (!currentTile.getIccupied() && modifyCash(-tempTower.getCost()) ) {
				towerList.add(tempTower);
				currentTile.setOccupied(true);
				holdingTower = false;
				tempTower = null;
			}
		}
		
		
	}

	public void pickTower(Tower t) {
		tempTower = t;
		holdingTower = true;
	}

	private Tile getMouseTile() {
		return grid.getTile(Mouse.getX() / TILE_SIZE, (HEIGHT - Mouse.getY() - 1) / TILE_SIZE);
	}

}
