package data;

import static helpers.Artist.*;

import org.newdawn.slick.opengl.Texture;

public enum ProjectileType {
	
	CannonBall(QuickLoad("bullet"), 10, 500),
	Iceball(QuickLoad("projectileIceball"), 6, 450);
	
	Texture texture;
	int damage;
	float speed;
	
	ProjectileType(Texture texuture, int damage,float speed){
		this.texture = texuture;
		this.damage = damage;	
		this.speed = speed;
	}
}
