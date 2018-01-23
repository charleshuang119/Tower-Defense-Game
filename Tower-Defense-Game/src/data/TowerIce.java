package data;

import java.util.concurrent.CopyOnWriteArrayList;

public class TowerIce extends Tower{

		public TowerIce(TowerType type, Tile startTile, CopyOnWriteArrayList<Enemy> enemies) {
			super(type,startTile,enemies);
		}
		
		@Override
		public void shoot(Enemy target) {
			super.projectiles.add(new ProjectileIceball(super.type.projectileType, super.target,super.getX(),super.getY(),32,32));
		}
		
		
}
