package snakeGame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class head extends body {

	int dx, dy;
	Color col = Color.red;
	int size = 50;
	int speed = 50;
	int score = 0;
	ArrayList<body> snake = new ArrayList<body>();
	timer delay = new timer(.85);
	body body;

	timer timeBody = new timer(5);

	int xPositionTracker;
	int yPositionTracker;

	public head(int startX, int startY) {
		this.setSize(size, size);
		this.setLocation(startX, startY);
		delay.start();
		timeBody.start();

	}

	public void addBody() {

		// if (timeBody.update() && Math.abs(dx + dy) != 0) {

		if (snake.size() == 0) {

			snake.add(new body(this));
			

		} else {

			snake.add(new body(snake.get(snake.size() - 1)));
			
		}
	}

	// }

	public void update(boolean[] keys) {

		// this.addBody();

		xPositionTracker = this.x;
		yPositionTracker = this.y;

		if (keys[KeyEvent.VK_W]) {
			dy = -speed;
			dx = 0;
		}
		if (keys[KeyEvent.VK_S]) {
			dy = speed;
			dx = 0;
		}
		if (keys[KeyEvent.VK_D]) {
			dx = speed;
			dy = 0;
		}
		if (keys[KeyEvent.VK_A]) {
			dx = -speed;
			dy = 0;
		}
		if (keys[KeyEvent.VK_UP]) {
			dy = -speed;
			dx = 0;
		}
		if (keys[KeyEvent.VK_DOWN]) {
			dy = speed;
			dx = 0;
		}
		if (keys[KeyEvent.VK_RIGHT]) {
			dx = speed;
			dy = 0;
		}
		if (keys[KeyEvent.VK_LEFT]) {
			dx = -speed;
			dy = 0;
		}

		if (delay.update()) {

			for (int i = snake.size() - 1; i >= 0; i--) {

				snake.get(i).update(this);

			}

			this.translate(dx, dy);

		}

	}

	public void draw(Graphics2D win) {

		for (body b : snake) {
			b.draw(win);
		}

		win.setColor(col);

		win.fill(this);
		win.draw(this);
	}

}
