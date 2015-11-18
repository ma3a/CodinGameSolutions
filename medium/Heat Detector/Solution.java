import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse the standard input according to the problem
 * statement.
 **/
class Player {
    static int W;
    static int H;

    static int N;

    static int X;
    static int Y;

    static int xMultiple = 1;
    static int yMultiple = 1;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        W = in.nextInt() - 1; // width of the building.
        H = in.nextInt() - 1; // height of the building.
        N = in.nextInt(); // maximum number of turns before game over.

        X = in.nextInt();
        Y = in.nextInt();

        Sector field = null;

        while (true) {
            String BOMB_DIR = in.next();
            if (field == null) {
                field = getSectorByLocationAndDir(BOMB_DIR);
            }

            int[] XY = field.move(BOMB_DIR, X, Y);
            X = XY[0];
            Y = XY[1];

            System.out.println(X + " " + Y);
        }
    }

    private static Sector getSectorByLocationAndDir(String direction) {
        Sector sector = new Sector();
        int[] dir = jumpDirection(direction);
        int x0;
        int x1;
        int y0;
        int y1;

        if (dir[0] < 0) {
            x0 = 0;
            x1 = X;
        } else {
            x0 = X;
            x1 = W;
        }

        if (dir[1] > 0) {
            y0 = Y;
            y1 = H;
        } else {
            y0 = 0;
            y1 = Y;
        }

        return new Sector(x0,y0,x1,y1);
    }

    public static int[] jumpDirection(String direction) {
        int[] location = new int[2];
        switch (direction) {
            case "U":
                location[0] = 0;
                location[1] = -1;
                break;

            case "UR":
                location[0] = 1;
                location[1] = -1;
                break;

            case "UL":
                location[0] = -1;
                location[1] = -1;
                break;

            case "D":
                location[0] = 0;
                location[1] = 1;
                break;

            case "DR":
                location[0] = 1;
                location[1] = 1;
                break;

            case "DL":
                location[0] = -1;
                location[1] = 1;
                break;

            case "L":
                location[0] = -1;
                location[1] = 0;
                break;

            case "R":
                location[0] = 1;
                location[1] = 0;
                break;

            default:
                location[0] = 0;
                location[1] = 0;
        }
        System.err.println("dir " + location[0] + " " + location[1]);
        return location;
    }

}

class Sector {
    int x0;
    int y0;
    int x1;
    int y1;

    public Sector() {}

    public Sector(int x0, int y0, int x1, int y1) {
        this.x0 = x0;
        this.y0 = y0;
        this.x1 = x1;
        this.y1 = y1;
        System.err.println("Sector size:" + x0 + ", " + y0 + "; end:" + x1 + ", " + y1);
    }


    public int[] move(String direction, int X, int Y) {
        System.err.println(direction);

        switch (direction) {

            case "UL":
                this.x1 = X;
                this.y1 = Y;
                break;

            case "UR":
                this.x0 = X;
                this.y1 = Y;
                break;

            case "DL":
                this.x1 = X;
                this.y0 = Y;
                break;

            case "DR":
                this.x0 = X;
                this.y0 = Y;
                break;

            case "U":
                this.x0 = X;
                this.x1 = X;
                this.y1 = Y;
                break;

            case "D":
                this.x0 = X;
                this.x1 = X;
                this.y0 = Y;
                
                break;

            case "R":
                this.y0 = Y;
                this.y1 = Y;
                this.x0 = X;
                break;

            case "L":
                this.y0 = Y;
                this.y1 = Y;
                this.x1 = X;
                break;
        }

        int halfX = (this.x1 - this.x0 ) / 2  + (this.x1 - this.x0 ) % 2 ;
        int halfY = (this.y1 - this.y0 ) / 2  + (this.y1 - this.y0 ) % 2 ;

        System.err.println("halfX :" + halfX + " halfY:" + halfY);

        System.err.println("Sector size:" + x0 + ", " + y0 + "; end:" + x1 + ", " + y1);
        int[] dir = Player.jumpDirection(direction);
        return new int[]{X + dir[0]*halfX, Y + dir[1]*halfY};
    }

}
