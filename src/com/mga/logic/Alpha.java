package com.mga.logic;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class Alpha extends Enemy {
	public Alpha() {
		this(null, 150, 1, "Alpha" + Math.random());
	}

	public Alpha(Sprite player, int vel, int health, String name) {
		super(player, vel, health, name);
		Sprite spr = this.getSpriteHandler().createSprite(this.getName(),
				"Alpha", "texture/enemy.png");
		spr.setScale(0.2f); // TODO: Add sprite scaling for all.
		this.setSprite(spr);
		getSprite().setX((float) Math.random() * 1000 + 500);
		getSprite().setY((float) Math.random() * 1000 + 500);
	}

	/**
	 * Attack Pattern for Alpha is simply to move towards the enemy at a fixed
	 * rate. dx and dy is the difference between the player and Alpha. theta
	 * turns the image to face the direction of the player.
	 * 
	 */
	@Override
	public void attackPattern(float dTime) {
		// TODO Auto-generated method stub

		if (getPlayer() == null) {
			removeGO(getName());
		}
		// TODO Auto-generated method stub
		else {
			float dx = getPlayer().getX() - getSprite().getX();
			float dy = getPlayer().getY() - getSprite().getY();
			float theta = (float) (180.0 / Math.PI * Math.atan(dy / dx) - 90.0);
			if (dx < 0) {
				theta += 180.0;
			}
			getSprite().setRotation(theta);
			getSprite().setPosition(
					(float) (getSprite().getX() + dTime * getVel() * dx
							/ Math.sqrt(dx * dx + dy * dy)),
					(float) (getSprite().getY() + dTime * getVel() * dy
							/ Math.sqrt(dx * dx + dy * dy)));
		}

	}

}