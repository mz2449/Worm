import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Wormie extends PApplet {

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
	background(124,78,2);
	stroke(130,180,255);
	fill(130,180,255);
	rect(0,0,500,80);
	stroke(255,245,63);
	fill(255,245,63);
	ellipse(5,0,80,80);
	for (int i = 0; i<500; i++) {
		stroke(6,127,0);
		rect(i,80,.5f,random(-15,-7));
	}
}

public void drawFood(){
	stroke(255,255,255);
  	fill(0,0,255);
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
	loop();
}

public void settings() {
	size(500,500);
}
	
public void setup() {
	background(102, 51, 0);
	frameRate(15);

	noLoop();
}

// DRAW FUNCTION
public void draw() {
	background(124,78,2);
	drawWorm(testWorm);
	testWorm.moveOne();
	int foodXCor = testFood.getXFood();
	int foodYCor = testFood.getYFood();

	testWorm.checkEdgeCollision();

	testWorm.checkSelfCollision();

	if (testFood.set) {
		drawFood();
	}
	else {
		testFood = new Food();
	}

	if (testWorm.headCollision(foodXCor, foodYCor)) {
		testWorm.addOne();
		testFood.eat();
	}

	if (! testWorm.Alive) {
		background(0,0,0);
		testFood.eat();
		noLoop();
	}
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Wormie" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
