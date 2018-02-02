package data;

import org.newdawn.slick.opengl.Texture;
import static helpers.Artist.*;
public enum TowerType {
	
	CannonRed(new Texture[] {QuickLoad("cannonBase"),QuickLoad("cannonGun")},ProjectileType.CannonBall,10,1000,3,0),
	CannonBlue(new Texture[] {QuickLoad("cannonBaseBlue"),QuickLoad("cannonGunBlue")},ProjectileType.CannonBall,30,1000,3,15),
	CannonIce(new Texture[] {QuickLoad("cannonIceBase"),QuickLoad("cannonIceGun")}, ProjectileType.Iceball,30,1000,3,20);
	
	Texture[] textures;
	ProjectileType projectileType;
	int damage,range,cost;
	float firingSpeed;
	
	
	TowerType(Texture[] texutures, ProjectileType projectileType, int damage,int range,float firingSpeed, int cost){
		this.textures = texutures;
		this.projectileType = projectileType;
		this.damage = damage;
		this.range = range;
		this.firingSpeed = firingSpeed;
		this.cost = cost;
	}
}
