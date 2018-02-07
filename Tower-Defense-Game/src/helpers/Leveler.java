package helpers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import data.Tile;
import data.TileGrid;
import data.TileType;
public class Leveler {

	public static void SaveMap(String mapName, TileGrid grid) {
		String mapData = "";
		for(int i = 0; i < grid.getTilesWide();i++) {
			for(int j = 0; j < grid.getTilesHigh();j++) {
				mapData += getTileID(grid.getTile(i, j));
			}
		}
		try {
			File file = new File(mapName);
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(mapData);
			bw.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static TileGrid LoadMap(String mapName) {
		TileGrid grid = new TileGrid();
		try {
			File map = new File(mapName);
			if(!map.isFile()) {
				String data ="100100000000000110111110000000010000010000000012000011111100012222200000110012222200000011012000000222221010000000022001010222200002201012002000222221012002000000001010222200220001010000000022221012222200022221010220000220011010022000000110012222211111100010000010000000011111110000000000000000000000";
				for(int i = 0;i<grid.getTilesWide();i++) {
					for(int j = 0; j < grid.getTilesHigh();j++) {
						grid.setTile(i, j, getTileType(data.substring(i*grid.getTilesHigh()+j, i*grid.getTilesHigh()+j+1)));
					}
				}
				
			BufferedReader br = new BufferedReader(new FileReader(mapName));
			}
			else {
				BufferedReader br = new BufferedReader(new FileReader(mapName));
				String data = br.readLine();
				for(int i = 0;i<grid.getTilesWide();i++) {
					for(int j = 0; j < grid.getTilesHigh();j++) {
						grid.setTile(i, j, getTileType(data.substring(i*grid.getTilesHigh()+j, i*grid.getTilesHigh()+j+1)));
					}
				}
				br.close();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return grid;
	}
	
	
	public static TileType getTileType(String ID) {
		TileType type = TileType.NULL;
		switch(ID) {
		case "0":
			type = TileType.Grass;
			break;
		case "1":
			type = TileType.Dirt;
			break;
		case "2":
			type = TileType.Water;
			break;
		case "3":
			type = TileType.NULL;
			break;
		}
		return type;
	}
	public static String getTileID(Tile t) {
		String ID = "E";
		switch(t.getType()) {
		case Grass:
			ID = "0";
			break;
		case Dirt:
			ID = "1";
			break;
		case Water:
			ID = "2";
			break;
		case NULL:
			ID = "3";
			break;
		}		
		return ID;
	}
}
