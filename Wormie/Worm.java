/*
 * Michael Zheng
 * 05/10/21
 * Wormie
 * Worm class, dictating data fields and methods for the worm
 */

import java.util.*;
public class Worm {
    static ArrayList<Worm> wormList;

    Random randomGenerator1 = new Random();
    Random randomGenerator2 = new Random();
    Random randomGenerator3 = new Random();

    public String wormName;
	int[] headPosition = new int[2];
    ArrayList<int[]> wormSegments = new ArrayList<int[]>();
    String Direction;
    boolean Left = false;
    boolean Right = false;


    public Worm() {
        this("Wormie " + (wormList.size() + 1));
    }

    public Worm(String name) {
        wormName = name;

        headPosition[0] = randomGenerator2.nextInt(500);
        headPosition[1] = randomGenerator2.nextInt(500);

        wormSegments.add(headPosition);

        switch (randomGenerator1.nextInt(5) + 1) {
            case 1:
                Direction = "up";
                break;
            case 2:
                Direction = "down";
                break;
            case 3:
                Direction = "left";
                break;
            case 4:
                Direction = "right";
                break;
        }
    }


    public void moveOne() {
        switch (Direction) {
            case "up":
                headPosition[1] = headPosition[1] - 10;
                break;
            case "left":
                headPosition[0] = headPosition[0] - 10;
                break;
            case "down":
                headPosition[1] = headPosition[1] + 10;
                break;
            case "right":
                headPosition[0] = headPosition[0] + 10;
                break;
        }

        for (int[] segment: wormSegments) {
            if (segment == wormSegments.get(0)) {
                continue;
            }
            int segmentIndex = wormSegments.indexOf(segment);
            int[] previousSegment = wormSegments.get(segmentIndex - 1);
            segment = previousSegment;
        }
    }

    public void changeDirection() {
        if (Left & (! Right)) {
            switch (Direction) {
                case "up":
                    Direction = "left";
                    break;
                case "down":
                    Direction = "right";
                    break;
                case "right":
                    Direction = "up";
                    break;
                case "left":
                    Direction = "down";
                    break;
            }
        }

        else if (Right & (! Left)) {
            switch (Direction) {
                case "up":
                    Direction = "right";
                    break;
                case "down":
                    Direction = "left";
                    break;
                case "right":
                    Direction = "down";
                    break;
                case "left":
                    Direction = "up";
                    break;
            }
        }
    }

    public void addOne() {
        int[] lastSegment = wormSegments.get(wormSegments.size() - 1);
        int[] segment = new int[2];
    	
        switch (Direction) {
    		case "up":
                segment[0] = lastSegment[0];
                segment[1] = lastSegment[1] + 5;
                break;
            case "down":
                segment[0] = lastSegment[0];
                segment[1] = lastSegment[1] - 5;
                break;
            case "left":
                segment[0] = lastSegment[0] + 5;
                segment[1] = lastSegment[1];
                break;
            case "right":
                segment[0] = lastSegment[0] - 5;
                segment[1] = lastSegment[1];
                break;
    	}

        wormSegments.add(segment);

    }



}
