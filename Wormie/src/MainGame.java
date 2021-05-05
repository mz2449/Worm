import processing.core.*;

public class MainGame extends PApplet {
	
	Worm testWorm = new Worm("Test Worm");

	public static void main(String[] args) {
		PApplet.main("MainGame");
	}

	public void drawWorm(Worm drawnWorm) {
		for (int[] segment: drawnWorm.wormSegments) {
			background(0, 255, 0);
			fill(255, 0, 0);
			rect(segment[0], segment[1], 10, 10);
		}
	}
	
	public void settings() {
		size(500,500);
	}
	
	public void setup() {
		background(0, 255, 0);
	}

	public void draw() {
		drawWorm(testWorm);
		testWorm.moveOne();

	}
}