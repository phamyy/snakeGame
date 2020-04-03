package snakeGame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class body extends Rectangle {

	int dx, dy;
	Color col = Color.white;
	int xPosition, yPosition;
	int size = 50;
	public int value = 10;
	body leader;
	Random rand = new Random();

	public body() {
		this.setSize(size, size);
		int startX = rand.nextInt(17) * 50;
		int startY = rand.nextInt(13) * 50;
		this.setLocation(startX, startY);
	}

	public body(body leader) {
		this.setSize(leader.width, leader.height);
		this.setLocation(leader.x, leader.y);
		this.leader = leader;

	}

	public void update(head head) {
		// TODO Auto-generated method stub

		this.setLocation(leader.x, leader.y);

	}

	public void draw(Graphics2D win) {
		// TODO Auto-generated method stub
		win.setColor(col);
		win.fill(this);
		win.setColor(Color.black);
		win.draw(this);
	}

}
