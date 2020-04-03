package snakeGame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class food extends Rectangle {

	int startX, startY;
	int size = 50;
	Random rand = new Random();

	public food() {
		this.setSize(size, size);
		int startX = rand.nextInt(16) * 50;
		int startY = rand.nextInt(12) * 50;
		this.setLocation(startX, startY);

	}

	public void update(head head) {
//		if(this.intersects(head)) {
//			head.addBody();
//		}

	}

	public void draw(Graphics2D win) {
		win.setColor(Color.green);
		win.fill(this);
		win.setColor(Color.white);
		win.draw(this);

	}

}
