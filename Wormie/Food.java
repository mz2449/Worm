/*
 * Elliot Tufaro
 * 05/10/21
 * Wormie
 * Food class
 */
 import java.util.*;
  int[] foodPosition = new int[2];
  boolean set = false;
  public Food() {
    Random randomGenerator1 = new Random();
    Random randomGenerator2 = new Random();
    if(!set){
      foodPosition[0] = randomGenerator1.nextInt(500);
      foodPosition[1] = randomGenerator2.nextInt(500);
      set = true;
      }
    }
     
    
}
