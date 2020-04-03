package snakeGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import utilities.GDV5;
import utilities.SoundDriverHo;

public class snakeSnake extends GDV5 {

	static SoundDriverHo audio;

	sprite endGameExplosions;
	body snake = new body();
	head snakeHead = new head(200, 200);
	head snakeHead2 = new head(400, 200);
	food rat = new food();
	boolean endGameScreen = false;
	boolean gameScreen = false;
	boolean loadingScreen = true;
	boolean rulesPage = false;
	boolean gameScreen2 = false;
	BufferedImage BackGroundImage;
	BufferedImage Keyboard;
	BufferedImage explosions;

	public snakeSnake() {

		String[] sounds = new String[1];
		sounds[0] = "rain.wav";
		audio = new SoundDriverHo(sounds, this);

		BackGroundImage = this.addImage("images/backGround.png");
		Keyboard = this.addImage("images/keyboard.png");
		explosions = this.addImage("images/explosions.png");

		endGameExplosions = new sprite(explosions, 3, 7, .1);

		// implementation of a moving sprite
		// sprite megaMan;
		// megaMan = new sprite(newImage, 4,6,.1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		snakeSnake s1 = new snakeSnake();
		s1.start();

	}

	@Override
	public void update() {

		if (GDV5.KeysPressed[KeyEvent.VK_1]) {
			loadingScreen = false;
			gameScreen = true;
			endGameScreen = false;
			rulesPage = false;
		}
		if (GDV5.KeysPressed[KeyEvent.VK_2]) {
			loadingScreen = false;
			gameScreen = false;
			endGameScreen = false;
			rulesPage = true;
		}
		if (GDV5.KeysPressed[KeyEvent.VK_3]) {
			loadingScreen = false;
			gameScreen = false;
			endGameScreen = false;
			rulesPage = false;
			gameScreen2 = true;
		}
		if (GDV5.KeysPressed[KeyEvent.VK_ENTER]) {
			loadingScreen = true;
			gameScreen = false;
			endGameScreen = false;
			rulesPage = false;
			gameScreen2 = false;
		}

		if (rat == null) {
			rat = new food();

		}

		if (gameScreen) {
			// megaMan.update();
			snakeHead.update(GDV5.KeysPressed);
			// snake.update(snakeHead);

			if (snakeHead.intersects(rat)) {

				snakeHead.addBody();
				rat = new food();
				snakeHead.score += 10;

			}

			for (int i = 1; i < snakeHead.snake.size(); i++) {
				if (snakeHead.intersects(snakeHead.snake.get(i))) {
					// snakeHead.speed = 0;
					snakeHead.setLocation(200, 200);
					endGameScreen = true;
					gameScreen = false;
					rulesPage = false;
					snakeHead.snake.clear();

				}
			}

			if (snakeHead.getBounds().getMaxX() > 800 || snakeHead.getBounds().getX() < 0) {
				// snakeHead.speed = 0;
				snakeHead.setLocation(200, 200);
				endGameScreen = true;
				gameScreen = false;
				rulesPage = false;
				snakeHead.snake.clear();

			}
			if (snakeHead.getBounds().getMinY() < 0 || snakeHead.getBounds().getMaxY() > 600) {
				// snakeHead.speed = 0;
				snakeHead.setLocation(200, 200);
				endGameScreen = true;
				gameScreen = false;
				rulesPage = false;
				snakeHead.snake.clear();

			}
		}

		if (gameScreen2) {

			// megaMan.update();
			snakeHead.update(GDV5.KeysPressed);
			// snake.update(snakeHead);

			if (snakeHead.intersects(rat)) {

				snakeHead.addBody();
				rat = new food();

			}

			for (int i = 1; i < snakeHead.snake.size(); i++) {
				if (snakeHead.intersects(snakeHead.snake.get(i))) {
					// snakeHead.speed = 0;
					snakeHead.setLocation(200, 200);
					endGameScreen = true;
					gameScreen = false;
					rulesPage = false;
					snakeHead.snake.clear();

				}
			}

			if (snakeHead.getBounds().getMaxX() > 800 || snakeHead.getBounds().getX() < 0) {
				// snakeHead.speed = 0;
				snakeHead.setLocation(200, 200);
				endGameScreen = true;
				gameScreen = false;
				rulesPage = false;
				snakeHead.snake.clear();

			}
			if (snakeHead.getBounds().getMinY() < 0 || snakeHead.getBounds().getMaxY() > 600) {
				// snakeHead.speed = 0;
				snakeHead.setLocation(200, 200);
				endGameScreen = true;
				gameScreen = false;
				rulesPage = false;
				snakeHead.snake.clear();

			}

			// megaMan.update();
			snakeHead2.update(GDV5.KeysPressed);
			// snake.update(snakeHead);

			if (snakeHead2.intersects(rat)) {

				snakeHead2.addBody();
				rat = new food();

			}

			for (int i = 1; i < snakeHead2.snake.size(); i++) {
				if (snakeHead2.intersects(snakeHead2.snake.get(i))) {
					// snakeHead.speed = 0;
					snakeHead2.setLocation(200, 200);
					endGameScreen = true;
					gameScreen = false;
					rulesPage = false;
					snakeHead2.snake.clear();

				}
			}

			if (snakeHead2.getBounds().getMaxX() > 800 || snakeHead2.getBounds().getX() < 0) {
				// snakeHead.speed = 0;
				snakeHead2.setLocation(200, 200);
				endGameScreen = true;
				gameScreen = false;
				rulesPage = false;
				snakeHead2.snake.clear();

			}
			if (snakeHead2.getBounds().getMinY() < 0 || snakeHead2.getBounds().getMaxY() > 600) {
				// snakeHead.speed = 0;
				snakeHead2.setLocation(200, 200);
				endGameScreen = true;
				gameScreen = false;
				rulesPage = false;
				snakeHead2.snake.clear();

			}

		}
		
		if(endGameScreen) {
			endGameExplosions.update();
		}

	}

	@Override
	public void draw(Graphics2D win) {
		// TODO Auto-generated method stub

		if (loadingScreen) {
			win.drawImage(BackGroundImage, null, 0, 0);

			win.setColor(Color.white);
			win.setFont(new Font("bebas neue", Font.PLAIN, 20));
			win.drawString("Snake", 300, 40);
			win.drawString("By: Alex Pham", 300, 70);
			win.drawString("Press \"1\" to Start single snake", 50, 550);
			win.drawString("Press \"2\" for the Rules", 50, 580);
			win.drawString("Press \"3\" to start double snake", 400, 550);

			if (!audio.isPlaying(0)) {
				audio.play(0);
			}

		}

		if (rulesPage) {

			win.drawImage(Keyboard, null, 225, 125);
			win.setColor(Color.white);
			win.setFont(new Font("bebas neue", Font.PLAIN, 15));
			win.drawString("1. Use W,A,S,D to move the snake", 75, 350);
			win.drawString(
					"2. Try to collect he most amount of points without touching the snake or going our of bounds", 75,
					400);
			win.drawString("3. Use the arrow keys to control the second snake", 75, 450);
			win.drawString("Press \"Enter\" to escape", 20, 20);

		}

		if (gameScreen) {
			// megaMan.draw(win);
			// snake.draw(win);

			for (int i = 0; i < this.getWidth(); i += 50) {
				win.setColor(Color.white);
				win.drawLine(i, 0, i, this.getHeight());
			}
			for (int i = 0; i < this.getHeight(); i += 50) {
				win.setColor(Color.white);
				win.drawLine(0, i, this.getWidth(), i);
			}
			win.drawString("Score:" + snakeHead.score, 0, 20);

			rat.draw(win);
			snakeHead.draw(win);
		}

		if (gameScreen2) {
			for (int i = 0; i < this.getWidth(); i += 50) {
				win.setColor(Color.white);
				win.drawLine(i, 0, i, this.getHeight());
			}
			for (int i = 0; i < this.getHeight(); i += 50) {
				win.setColor(Color.white);
				win.drawLine(0, i, this.getWidth(), i);
			}

			rat.draw(win);
			snakeHead.draw(win);
			snakeHead2.draw(win);

		}

		if (endGameScreen) {
			win.setColor(Color.white);
			win.drawString("Game Over", 200, 200);
			win.drawString("Press \"Enter\" to restart", 200, 250);
			endGameExplosions.draw(win); 
			endGameExplosions.draw(win);
		}

	}

}
