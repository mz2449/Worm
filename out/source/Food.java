/*
 * Elliot Tufaro
 * 05/10/21
 * Wormie
 * Food class
 */

import java.util.*;

public class Food {
  int[] foodPosition = new int[2];

  boolean set;

  Random randomGenerator1 = new Random();
  Random randomGenerator2 = new Random();

  public Food() {
    set = false;

    if(!set) {
      foodPosition[0] = randomGenerator1.nextInt(3 * Board.playSize[0] / 4) + Board.playSize[0] / 8;
      foodPosition[1] = randomGenerator2.nextInt(3 * Board.playSize[1] / 4) + Board.playCor[1] + Board.playSize[1] / 8;
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
