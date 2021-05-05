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
	background(102, 51, 0);
	for (Object[] segment: curWorm.wormSegments) {
		rectMode(CENTER);
		rect((int)segment[0], (int)segment[1], 10, 10);
	}
}

public void drawFood(){
	stroke(255,255,255);
  	fill(0,0,255);
  	circle(testFood.getXFood(), testFood.getYFood(), 10);
 	fill(219,112,147);
	stroke(219,112,147);
}

public void mousePressed() {
	testWorm.addOne();
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
}

public void settings() {
	size(750,750);
}
	
public void setup() {
	background(102, 51, 0);
	frameRate(15);
	fill(219,112,147);
	stroke(219,112,147);
}

public void draw() {
	drawWorm(testWorm);
	testWorm.moveOne();
	int foodXCor = testFood.getXFood();
	int foodYCor = testFood.getYFood();

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

	testWorm.checkEdgeCollision();

	if (! testWorm.Alive) {
		background(0,0,0);
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
