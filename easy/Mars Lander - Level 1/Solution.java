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
        int N = in.nextInt(); // the number of points used to draw the surface of Mars.
        List<Surface> map = new ArrayList<Surface>();
        
        for (int i = 0; i < N; i++) {
            int LAND_X = in.nextInt(); // X coordinate of a surface point. (0 to 6999)
            int LAND_Y = in.nextInt(); // Y coordinate of a surface point. By linking all the points together in a sequential fashion, you form the surface of Mars.
            map.add( new Surface(LAND_X, LAND_Y));
        }

        // game loop
        while (true) {
            int X = in.nextInt();
            int Y = in.nextInt();
            int HS = in.nextInt(); // the horizontal speed (in m/s), can be negative.
            int VS = in.nextInt(); // the vertical speed (in m/s), can be negative.
            int F = in.nextInt(); // the quantity of remaining fuel in liters.
            int R = in.nextInt(); // the rotation angle in degrees (-90 to 90).
            int P = in.nextInt(); // the thrust power (0 to 4).

            Surface[] flat = findFlatSurface(map);
            
            Surface startF = flat[0];
            Surface endF = flat[1];
            
            Surface middleF = new Surface((endF.x + startF.x) / 2, startF.y);
            
            int degree = 0;
            int power = 3;
            
            System.err.println(startF);
            System.err.println(middleF);
            System.err.println(endF);
            
            if (VS < -30) {
                power++;
            }
            
            if (R < 0) {
                degree++;
            }
            if (R > 0) {
                degree--;
            }
            

            

            System.out.println(degree + " " + power);
        }
    }
    
    public static Surface[] findFlatSurface(List<Surface> map) {
        Surface[] interval = new Surface[] {new Surface(-1,-1), new Surface(-1,-1)};
        
        for (int i=0; i< map.size() - 1; i++) {
            if (map.get(i).y == map.get(i+1).y) {
                interval[0] = new Surface(map.get(i).x, map.get(i).y);
                interval[1] = new Surface(map.get(i+1).x, map.get(i+1).y);
            }
        }
        return interval;
    }
}

class Surface {
    public int x;
    public int y;
    
    public Surface(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public String toString() {
        return "x = " + x + " y = " + y;
    }
}