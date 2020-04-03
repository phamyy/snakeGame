package snakeGame;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

public class sprite implements gameObject {

	BufferedImage[] slides;
	int position;

	timer time;

	public sprite(BufferedImage image, int rows, int cols, double delay) {

		time = new timer(delay);
		time.start();
		slides = new BufferedImage[rows * cols];

		int width = image.getWidth() / cols;
		int height = image.getHeight() / rows;

		int count = 0;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {

				BufferedImage subImage = image.getSubimage(j * width, i * height, width, height);
				this.slides[count] = subImage;
				count++;

			}

		}

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

		if (time.update()) {
			this.position++;
			this.position %= slides.length;

		}

	}

	@Override
	public void draw(Graphics2D win) {
		// TODO Auto-generated method stub

		Random rand = new Random();
		int startX = rand.nextInt(600);
		int startY = rand.nextInt(800);
		win.drawImage(this.slides[this.position], null, startX, startY);

	}

}
