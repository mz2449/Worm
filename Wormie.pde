PFont f;  
PFont title; 

Worm wormOne = new Worm();

Food foodOne = new Food();

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
 	text(wormOne.getName(), 65, 120); // STEP 5 Display Text
 	text("Score:", 350, 120); 
 	text(wormOne.getLength("String"), 400, 120); 
}

public void drawFood() {
	stroke(255, 255, 255);
  	fill(0, 0, 255);
  	circle(foodOne.getXFood(), foodOne.getYFood(), 10);
}

public void keyPressed() {
	if (key == 'w' || key == 'W') {
		wormOne.changeDirection("up");
	}

	if (key == 'a' || key == 'A') {
		wormOne.changeDirection("left");
	}

	if (key == 's' || key == 'S') {
		wormOne.changeDirection("down");
	}

	if (key == 'd' || key == 'D') {
		wormOne.changeDirection("right");
	}

	if (wormOne.Alive) {
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
	if (! wormOne.Alive) {
		noLoop();
	}

	drawBoard();

	if (foodOne.set) {
		drawFood();
	}
	else {
		foodOne = new Food();
	}

	drawWorm(wormOne);
	wormOne.moveOne();
	wormOne.checkSelfCollision();
	wormOne.checkEdgeCollision();

	int foodXCor = foodOne.getXFood();
	int foodYCor = foodOne.getYFood();



	if (wormOne.headCollision(foodXCor, foodYCor)) {
		wormOne.addOne();
		foodOne.eat();
	}

}
