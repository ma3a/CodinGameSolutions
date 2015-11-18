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
        int R = in.nextInt(); // the length of the road before the gap.
        int G = in.nextInt(); // the length of the gap.
        int L = in.nextInt(); // the length of the landing platform.
        
        System.err.println("length GAP " +G);

        // game loop
        while (true) {
            int S = in.nextInt(); // the motorbike's speed.
            int X = in.nextInt(); // the position on the road of the motorbike.
            
            String command = null;
            int lengthToGap = R - X - 1;
            boolean speedEnougth = S == G + 1;
            System.err.println(lengthToGap);
            
            if (S < G + 1) {
                command = "SPEED";
            } else if (S > G +1) {
                command = "SLOW";
            }
            
            if (S != 0) {
                if (((lengthToGap % S) == 0) && speedEnougth) {
                    command = "WAIT";
                }
            }
            
            if (lengthToGap == 0) {
                command = "JUMP";
            }
            
            if (lengthToGap < 0) {
                command = "SLOW";
            }

            System.out.println(command);
        }
            
    }
}