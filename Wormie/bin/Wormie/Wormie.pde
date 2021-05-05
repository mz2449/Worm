WormTest testWorm = new WormTest("Test Worm");

public void drawWorm(WormTest curWorm) {
	background(0, 255, 0);
	curWorm.changeDirection();
	for (Object[] segment: curWorm.wormSegments) {
		fill(255, 0, 0);
		rectMode(CENTER);
		rect((int)segment[0], (int)segment[1], 10, 10);
	}
	
	curWorm.Left = false;
	curWorm.Right = false;
}

public void mousePressed() {
	testWorm.addOne();
}

public void keyPressed() {
	if (key == 'a' || key == 'A') {
		testWorm.Left = true;
	}

	if (key == 'd' || key == 'D') {
		testWorm.Right = true;
	}
	
}

public void settings() {
	size(500,500);
}
	
public void setup() {
	background(0, 255, 0);
	frameRate(60);
}

public void draw() {
	drawWorm(testWorm);
	testWorm.moveOne();
	}
