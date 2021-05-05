/*
 * Michael Zheng
 * 05/10/21
 * Wormie
 * Worm class, dictating data fields and methods for the worm
 */

import java.util.*;
public class WormTest {
    static ArrayList<Worm> wormList;

    Random randomGenerator1 = new Random();
    Random randomGenerator2 = new Random();
    Random randomGenerator3 = new Random();

    public String wormName;
	Object[] head = new Object[3];
    ArrayList<Object[]> wormSegments = new ArrayList<>();
    boolean Left = false;
    boolean Right = false;


    public WormTest() {
        this("Wormie " + (wormList.size() + 1));
    }

    public WormTest(String name) {
        wormName = name;

        head[0] = (Integer)randomGenerator2.nextInt(500);
        head[1] = (Integer)randomGenerator2.nextInt(500);
        head[2] = "up";

        wormSegments.add(head);
    }


    public void moveOne() {
        for (int segmentIndex = wormSegments.size() - 1; segmentIndex > 0; segmentIndex--) {                
            Object[] precedingSegment = new Object[3];
            System.arraycopy(wormSegments.get(segmentIndex - 1), 0, precedingSegment, 0, 3);

            wormSegments.set(segmentIndex, precedingSegment);
        }


        switch ((String)head[2]) {
            case "up":
                head[1] = (Integer)head[1] - 5;
                break;
            case "left":
                head[0] = (Integer)head[0] - 5;
                break;
            case "down":
                head[1] = (Integer)head[1] + 5;
                break;
            case "right":
                head[0] = (Integer)head[0] + 5;
                break;
        }

    }

    public void changeDirection() {
        if (Left & (! Right)) {
            switch ((String)head[2]) {
                case "up":
                   head[2] = "left";
                    break;
                case "down":
                    head[2] = "right";
                    break;
                case "right":
                    head[2] = "up";
                    break;
                case "left":
                    head[2] = "down";
                    break;
            }
        }

        else if (Right & (! Left)) {
            switch ((String)head[2]) {
                case "up":
                    head[2] = "right";
                    break;
                case "down":
                    head[2] = "left";
                    break;
                case "right":
                    head[2] = "down";
                    break;
                case "left":
                    head[2] = "up";
                    break;
            }
        }
    }

    public void addOne() {
        Object[] lastSegment = wormSegments.get(wormSegments.size() - 1);
        Object[] segment = new Object[3];
    	
        switch ((String)lastSegment[2]) {
    		case "up":
                segment[0] = (Integer)lastSegment[0];
                segment[1] = (Integer)lastSegment[1] + 10;
                break;
            case "down":
                segment[0] = (Integer)lastSegment[0];
                segment[1] = (Integer)lastSegment[1] - 10;
                break;
            case "left":
                segment[0] = (Integer)lastSegment[0] + 10;
                segment[1] = (Integer)lastSegment[1];
                break;
            case "right":
                segment[0] = (Integer)lastSegment[0] - 10;
                segment[1] = (Integer)lastSegment[1];
                break;
    	}

        wormSegments.add(segment);

    }



}