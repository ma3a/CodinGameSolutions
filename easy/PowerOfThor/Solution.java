import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int LX = in.nextInt(); // the X position of the light of power
        int LY = in.nextInt(); // the Y position of the light of power
        int TX = in.nextInt(); // Thor's starting X position
        int TY = in.nextInt(); // Thor's starting Y position

        // game loop
        PathCreator creator = new PathCreator(TX, TY, LX, LY);
        while (true) {
            int E = in.nextInt();
            System.err.println("TX: " + TX + " TY:" + TY + " LX:" + LX + " LY:" + LY);
            System.out.println(creator.moveToBestPoint());
        }
    }
}

class Coordinate {
    public int x;
    public int y;
    public double cost;
    public String direction;
    
    public Coordinate(int x, int y, String direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }
}

class PathCreator {
    private Coordinate[] points = new Coordinate[8];
    private int destX;
    private int destY;
    
    public PathCreator(int currentX, int currentY, int destX, int destY) {
        this.destX = destX;
        this.destY = destY;
        
        updateCordinates(currentX, currentY);
    }
    
    public void updateCordinates(int currentX, int currentY) {
        points[0] = new Coordinate(currentX    , currentY - 1, "N");
        points[1] = new Coordinate(currentX + 1, currentY - 1, "NE");
        points[2] = new Coordinate(currentX + 1, currentY    , "E");
        points[3] = new Coordinate(currentX + 1, currentY + 1, "SE");
        points[4] = new Coordinate(currentX    , currentY + 1, "S");
        points[5] = new Coordinate(currentX - 1, currentY + 1, "SW");
        points[6] = new Coordinate(currentX - 1, currentY    , "W");
        points[7] = new Coordinate(currentX - 1, currentY - 1, "NW");
        
        for (int i = 0; i < points.length; i ++) {
            calculateCost(points[i]);
            System.err.println(points[i].direction + " " + points[i].cost);
        }
    }
    
    private void calculateCost(Coordinate point) {
        int dX = (destX - point.x);
        int dY = (destY - point.y);
        
        point.cost = Math.sqrt(((dX*dX) + (dY*dY)));
    }
    
    public String moveToBestPoint() {
        Coordinate minCost = points[0];
        for (int i = 0; i < points.length; i++) {
            if (points[i].cost < minCost.cost) {
                minCost = points[i];
            }
        }
        
        String movement = minCost.direction;
        updateCordinates(minCost.x, minCost.y);
        return movement;
    }
    
}