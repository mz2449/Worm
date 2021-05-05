import java.util.*;

public final class Board {
    private Board() {
    }
    static Random randomGenerator1 = new Random();

    static int[] scoreCor = {0, 0};
    static int[] scoreSize = {500, 150};

    static int[] playCor = {0, scoreSize[1]};
    static int[] playSize = {500, 500};

    static int[] grassArray = new int[501];

    public static void drawGrass() {
        int[] retArray = new int[501];
        for (int i = 0; i < 501; i++) {
            retArray[i] = randomGenerator1.nextInt(9) - 15;
        }
        grassArray = retArray;
    }

}
