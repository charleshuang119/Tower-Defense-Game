package data;

public class TileGrid {
	
	public Tile[][] map;
	private int tileWide, tileHigh;
	
	public TileGrid(){
		map = new Tile[20][15];
		for (int i = 0;i<map.length;i++) {
			for(int j=0;j<map[i].length;j++) {
				map[i][j]= new Tile(i*64,j*64,64,64,TileType.Grass);
			}
		}
	}
	
	public TileGrid(int[][] newMap) {
		this.tileWide = newMap[0].length;
		this.tileHigh = newMap.length;
		map = new Tile[tileWide][tileHigh];
		for (int i = 0;i<map.length;i++) {
			for(int j=0;j<map[i].length;j++) {
				switch(newMap[j][i]) {
				case 0:
					map[i][j]= new Tile(i*64,j*64,64,64,TileType.Grass);
					break;
				case 1:
					map[i][j]= new Tile(i*64,j*64,64,64,TileType.Dirt);
					break;	
				case 2:
					map[i][j]= new Tile(i*64,j*64,64,64,TileType.Water);
					break;
				}
			}
		}
	}
	
	public void SetTile(int xCoord, int yCoord, TileType type) {
		map[xCoord][yCoord] = new Tile(xCoord*64,yCoord*64,64,64,type);
	}
	
	
	public Tile GetTile(int xPlace,int yPlace) {
		if(xPlace < tileWide && yPlace<tileHigh&& xPlace>-1 && yPlace>-1) {
			return map[xPlace][yPlace];
		}	
		else {
			return new Tile(0,0,0,0,TileType.NULL);
		}
	}
	
	
	public int getTileWide() {
		return tileWide;
	}

	public void setTileWide(int tileWide) {
		this.tileWide = tileWide;
	}

	public int getTileHigh() {
		return tileHigh;
	}

	public void setTileHigh(int tileHigh) {
		this.tileHigh = tileHigh;
	}

	public void Draw() {
		for (int i = 0;i<map.length;i++) {
			for(int j=0;j<map[i].length;j++) {
				Tile t = map[i][j];
				t.Draw();
			}
		}
	}
}
