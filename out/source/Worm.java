/*
 * Michael Zheng
 * 05/10/21
 * Wormie
 * Worm class, dictating data fields and methods for the worm
 */

import java.util.*;

public class Worm {
    // ArrayList of all Worm objects
    static ArrayList<Worm> wormList;

    // Random number generators for later use
    Random randomGenerator1 = new Random();
    Random randomGenerator2 = new Random();
    Random randomGenerator3 = new Random();

    // Datafield: variables for later use
    public String wormName;
	public Object[] Head = new Object[3]; // Position and direction of the Head
    ArrayList<Object[]> wormSegments = new ArrayList<>(); // ArrayList of every single segment of the worm
    public Boolean Alive;

    public Worm() {
        this("Wormie " + (wormList.size() + 1));
    }

    public Worm(String name) {
        wormName = name;

        Head[0] = (Integer)randomGenerator2.nextInt(250);
        Head[1] = (Integer)randomGenerator2.nextInt(250);
        Head[2] = "none";
        
        wormSegments.add(Head);

        Alive = true;
    }


    public void moveOne() {
        for (int segmentIndex = wormSegments.size() - 1; segmentIndex > 0; segmentIndex--) {                
            Object[] precedingSegment = new Object[3];
            System.arraycopy(wormSegments.get(segmentIndex - 1), 0, precedingSegment, 0, 3);

            wormSegments.set(segmentIndex, precedingSegment);
        }

        switch ((String)Head[2]) {
            case "up":
                Head[1] = (Integer)Head[1] - 10;
                break;
            case "left":
                Head[0] = (Integer)Head[0] - 10;
                break;
            case "down":
                Head[1] = (Integer)Head[1] + 10;
                break;
            case "right":
                Head[0] = (Integer)Head[0] + 10;
                break;
        }
    }

    public void changeDirection(String newDirection) {
        
        switch ((String)Head[2]) {
            case "up":
                if (! newDirection.equals("down")) {
                    break;
                }
                return;
            case "down":
                if (! newDirection.equals("up")) {
                    break;
                }
                return;
            case "left":
               if (! newDirection.equals("right")) {
                    break;
                }
                return;
            case "right":
               if (! newDirection.equals("left")) {
                    break;
                }
                return;
        }

        Head[2] = newDirection;

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

        segment[2] = (String)lastSegment[2];
        wormSegments.add(segment);

    }

    public int getXHead() {
        return (int)Head[0];
    }

    public int getYHead() {
        return (int)Head[1];
    }

    public int getLength() {
        return wormSegments.size();
    }

    public void checkSelfCollision() {
        boolean collided = false;
        for (Object[] segment: wormSegments) {
            if (wormSegments.indexOf(segment) == 0 || wormSegments.indexOf(segment) == 1) {
                continue;
            }
            collided = headCollision((int)segment[0], (int)segment[1]);
        }
        if (collided) {
            Alive = false;
        }
    }

    public void checkEdgeCollision() {
        if (this.getXHead() <= 0 || this.getXHead() >= 550 || this.getYHead() <= 0 || this.getYHead() >= 550)
            Alive = false;
    }

    public boolean headCollision(int xCor, int yCor) {
        if (this.getXHead() > xCor - 10 && this.getXHead() < xCor + 10 && this.getYHead() > yCor - 10 && this.getYHead() < yCor + 10) {
            return true;
        }
        else {
            return false;
        }
    }
}
