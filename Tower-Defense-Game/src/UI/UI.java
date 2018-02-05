package UI;

import java.util.ArrayList;

import org.lwjgl.input.Mouse;
import static helpers.Artist.*;

public class UI {

	private ArrayList<Button> buttonList;
	private ArrayList<Menu> menuList;
	public UI() {
		this.buttonList = new ArrayList<Button>();
		this.menuList = new ArrayList<Menu>();
	}
	
	public void addButton(String name, String textureName, int x, int y) {
		buttonList.add(new Button(name,QuickLoad(textureName),x,y));
	}
	
	public boolean isButtonClicked(String buttonName) {
		Button b = getButton(buttonName);
		float mouseY = HEIGHT - Mouse.getY() - 1;
		if(Mouse.getX()> b.getX() && Mouse.getX()<b.getX() + b.getWidth() &&
				mouseY > b.getY() && mouseY <b.getY()+b.getHeight()) {
			return true;
		}
		return false;
	}
	
	private Button getButton(String buttonName) {
		for(Button b:buttonList) {
			if(b.getName().equals(buttonName)) {
				return b;
			}
		}
		return null;
	}
	
	public void draw() {
		for(Button b: buttonList) {
			DrawQuadTex(b.getTexture(),b.getX(),b.getY(),b.getWidth(),b.getHeight());
		}
		for(Menu m:menuList) {
			m.draw();
		}
	}
	
	public void createMenu(String name, int x, int y,int optionsWidth, int optionsHeight) {
		menuList.add(new Menu(name,x,y,optionsWidth,optionsHeight));
	}
	
	public Menu getMenu(String name) {
		for (Menu m: menuList) {
			if(name.equals(m.getName())) {
				return m;
			}
		}
		return null;
	}
	
	
	
	public class Menu {
		
		String name;
		private ArrayList<Button> menuButtons;
		private int x,y,buttonAmount,optionsWidth,optionsHeight;
		
		public Menu(String name, int x, int y, int optionsWidth, int optionsHeight) {
			this.name = name;
			this.x = x;
			this.y = y;
			this.optionsWidth = optionsWidth;
			this.optionsHeight = optionsHeight;
			this.buttonAmount = 0;
			this.menuButtons = new ArrayList<Button>();
		}
		
		public void addButton(Button b) {
			if(optionsWidth != 0) {
				b.setY(y + (buttonAmount / optionsWidth) * TILE_SIZE);
			}
			b.setX(x+(buttonAmount % optionsWidth) * TILE_SIZE);
			buttonAmount++;
			menuButtons.add(b);
		} 
		
		public boolean isButtonClicked(String buttonName) {
			Button b = getButton(buttonName);
			float mouseY = HEIGHT - Mouse.getY() - 1;
			if(Mouse.getX()> b.getX() && Mouse.getX()<b.getX() + b.getWidth() &&
					mouseY > b.getY() && mouseY <b.getY()+b.getHeight()) {
				return true;
			}
			return false;
		}
		
		private Button getButton(String buttonName) {
			for(Button b:menuButtons) {
				if(b.getName().equals(buttonName)) {
					return b;
				}
			}
			return null;
		}
		public void draw() {
			for(Button b: menuButtons) {
				DrawQuadTex(b.getTexture(),b.getX(),b.getY(),b.getWidth(),b.getHeight());
			}
		}
		
		public String getName() {
			return name;
		}
	}
}
