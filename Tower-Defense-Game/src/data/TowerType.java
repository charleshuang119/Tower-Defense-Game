package data;

import org.newdawn.slick.opengl.Texture;
import static helpers.Artist.*;
public enum TowerType {
	
	CannonRed(new Texture[] {QuickLoad("cannonBase"),QuickLoad("cannonGun")},10,1000,3),
	CannonBlue(new Texture[] {QuickLoad("cannonBaseBlue"),QuickLoad("cannonGunBlue")},30,1000,3),
	CannonIce(new Texture[] {QuickLoad("cannonIceBase"),QuickLoad("cannonIceGun")},30,1000,3);
	
	Texture[] textures;
	int damage,range;
	float firingSpeed;
	
	TowerType(Texture[] texuture, int damage,int range,float firingSpeed){
		this.textures = texuture;
		this.damage = damage;
		this.range = range;
		this.firingSpeed = firingSpeed;
	}
}
