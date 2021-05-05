PFont f;  
PFont title; 

Worm testWorm = new Worm("Test Worm");

Food testFood = new Food();

public void drawWorm(Worm curWorm) {
	fill(219,112,147);
	stroke(219,112,147);
	for (Object[] segment: curWorm.wormSegments) {
		rectMode(CENTER);
		rect((int)segment[0], (int)segment[1], 10, 10);
	}
}

public void drawBoard() {
	rectMode(CORNER);
	background(102, 51, 0);

	stroke(130, 180, 255);
	fill(130, 180, 255);
	rect(Board.scoreCor[0], Board.scoreCor[1], Board.scoreSize[0], Board.scoreSize[1]);

	stroke(255,245,63);
	fill(255,245,63);
	ellipse(Board.scoreCor[0] + 5, Board.scoreCor[1], 80, 80);

	stroke(6,127,0);
	for (int i = 0; i<500; i++) {
		rect(i, Board.scoreSize[1], 0.5, Board.grassArray[i]);
	}

	//Game Title
  	textFont(title, 30);                  // Specify font to be used
 	fill(255, 0, 0);                         // Specify font color 
 	text("Wormie", 195, 30); 

	//Display's user content
  	textFont(f, 16);                  // Specify font to be used
  	fill(0);                         // Specify font color 
  	//Get inputs: worm name and length
  	text("Name:", 10, 120);            //(word, x_cord,y_cord)
 	text(testWorm.getName(), 65, 120); // STEP 5 Display Text
 	text("Score:", 350, 120); 
 	text(testWorm.getLength("String"), 400, 120); 
}

public void drawFood() {
	stroke(255, 255, 255);
  	fill(0, 0, 255);
  	circle(testFood.getXFood(), testFood.getYFood(), 10);
}

public void keyPressed() {
	if (key == 'w' || key == 'W') {
		testWorm.changeDirection("up");
	}

	if (key == 'a' || key == 'A') {
		testWorm.changeDirection("left");
	}

	if (key == 's' || key == 'S') {
		testWorm.changeDirection("down");
	}

	if (key == 'd' || key == 'D') {
		testWorm.changeDirection("right");
	}

	if (testWorm.Alive) {
		loop();
	}
}

public void settings() {
	size(Board.playSize[0], Board.playSize[1] + Board.scoreSize[1]);
}
	
public void setup() {
	Board.drawGrass();
	frameRate(15);

  	title = createFont("Arial",16,true);
  	f = createFont("Arial",16,true); //chooses font 

	noLoop();
}

// DRAW FUNCTION
public void draw() {
	if (! testWorm.Alive) {
		noLoop();
	}

	drawBoard();

	if (testFood.set) {
		drawFood();
	}
	else {
		testFood = new Food();
	}

	drawWorm(testWorm);
	testWorm.moveOne();
	testWorm.checkSelfCollision();
	testWorm.checkEdgeCollision();

	int foodXCor = testFood.getXFood();
	int foodYCor = testFood.getYFood();



	if (testWorm.headCollision(foodXCor, foodYCor)) {
		testWorm.addOne();
		testFood.eat();
	}

}
