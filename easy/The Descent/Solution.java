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

        // game loop
        while (true) {
            int SX = in.nextInt();
            int SY = in.nextInt();
            
            int maxHeightIndex = 0;
            int height = in.nextInt();
            
            for (int i = 1; i < 8 ; i++) {
                int current = in.nextInt();
                if (height <= current) {
                    height = current;
                    maxHeightIndex = i;
                }
            }
            
            if (maxHeightIndex != -1 && SX == maxHeightIndex) {
                System.out.println("FIRE");
            } else {
                System.out.println("HOLD");
            }
        }
    }
}
    