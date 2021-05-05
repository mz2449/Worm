PFont f;  
PFont title; 

void setup(){
  size(500,200);
  background(139, 190, 250);
  stroke(130,180,255);
  fill(130,180,255);
  //rect(0,0,500,80);
  stroke(255,245,63);
  fill(255,245,63);
  ellipse(5,0,150,150);
  for (int i = 0; i<500; i++){
    stroke(6,127,0);
    rect(i,200,1,random(-40,-20));
  }
  title = createFont("Arial",16,true);
  f = createFont("Arial",16,true); //chooses font 
}

void draw() {
  //Game Title
  textFont(title,30);                  // Specify font to be used
  fill(255,0,0);                         // Specify font color 
  text("Wormie",195,30); 
  //Display's user content
  textFont(f,16);                  // Specify font to be used
  fill(0);                         // Specify font color 
  //Get inputs: worm name and length
  text("Name:",10,120);            //(word, x_cord,y_cord)
  text("Worm_name variable",65,120); // STEP 5 Display Text
  text("Score:",350,120); 
  text("worm length",400,120); 
}