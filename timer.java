package snakeGame;

public class timer {

	int tick;
	double delay; // in seconds
	boolean isCounting = false;

	public timer(double delay) {

		this.delay = delay;

	}

	public void start() {
		this.isCounting = true;
	}

	public void stop() {
		this.isCounting = false;
	}

	public void restart() {
		this.tick = 0;
		this.start();
	}

	public boolean update() {

		if (this.isCounting) {

			if (this.tick >= this.delay * 30) {

				this.tick = 0;

				return true;

			} else {
				this.tick++;
			}

		}

		return false;
	}

}
