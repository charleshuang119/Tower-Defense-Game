package data;

import static helpers.Artist.*;
import static helpers.Leveler.*;


import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.opengl.Texture;

import UI.UI;
import UI.UI.Menu;

public class Editor{
	
	private TileGrid grid;
	private int index;
	private TileType[] types;
	private UI editorUI;
	private Menu tilePickerMenu;
	private Texture menuBackground;

	
	public Editor() {
		this.grid = LoadMap("newMap1");
		this.index = 0;
		this.types = new TileType[3];
		this.types[0] = TileType.Grass;
		this.types[1] = TileType.Dirt;
		this.types[2] = TileType.Water;
		this.menuBackground = QuickLoad("menu_background");
		setupUI();
	}
	
	private void setupUI(){
		editorUI = new UI();
		editorUI.createMenu("TilePicker", 1280, 100,192,960,2,0);
		tilePickerMenu = editorUI.getMenu("TilePicker");
		tilePickerMenu.quickAdd("Grass","grass64");
		tilePickerMenu.quickAdd("Dirt","dirt64");
		tilePickerMenu.quickAdd("Water", "water64");
	}
	public void update() {
		
		draw();
		editorUI.drawString(1300,700,"Press S to save");
		editorUI.drawString(1350,720,"map");
		// Handle Mouse Input
		if (Mouse.next()) {
			boolean mouseClicked = Mouse.isButtonDown(0);
			if (mouseClicked) {
				if (tilePickerMenu.isButtonClicked("Grass")) {
					index = 0;
				}
				else if(tilePickerMenu.isButtonClicked("Dirt")){
					index = 1;
				}
				else if(tilePickerMenu.isButtonClicked("Water")){
					index = 2;
				}
				else{
					setTile();
				}
			}
		}
		
		//Handle keyboard input
		while(Keyboard.next()) {
			if(Keyboard.getEventKey()==Keyboard.KEY_RIGHT && Keyboard.getEventKeyState()) {
				moveIndex();			
			}
			if(Keyboard.getEventKey()==Keyboard.KEY_S && Keyboard.getEventKeyState()) {
				SaveMap("newMap1",grid);		
			}
		}
	}
	
	private void draw() {
		DrawQuadTex(menuBackground,1280,0,192,960);
		grid.draw();
		editorUI.draw();
	}
	
	private void setTile() {
		int xCoord = (int)Math.floor(Mouse.getX() / TILE_SIZE);
		int yCoord = (int)Math.floor((HEIGHT-Mouse.getY()-1)/TILE_SIZE);
		if(xCoord < 20 && yCoord <15) {
			grid.setTile(xCoord,yCoord,types[index]);
		}
	}
	
	//Allows editor to change which TileType is selected
	private void moveIndex() {
		index++;
		if(index>types.length-1) {
			index = 0;
		}
	}
}
