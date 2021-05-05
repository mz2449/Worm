/*
 * Elliot Tufaro
 * 05/10/21
 * Wormie
 * Food class
 */

import java.util.*;

public class Food {

  int[] foodPosition = new int[2];

  boolean set = false;

  public Food() {
    Random randomGenerator1 = new Random();
    Random randomGenerator2 = new Random();

    if(!set) {
      foodPosition[0] = randomGenerator1.nextInt(500);
      foodPosition[1] = randomGenerator2.nextInt(500);
      set = true;
      }
    }

  public void eat() {
    set = false;
  }

  public int getXFood() {
    return foodPosition[0];
  }

  public int getYFood() {
    return foodPosition[1];
  }
  

}
