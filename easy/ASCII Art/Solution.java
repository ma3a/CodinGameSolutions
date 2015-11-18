import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {
    public static final int CHAR_START = 65;
    public static final int CHAR_END = 91;
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        in.nextLine();
        int H = in.nextInt();
        in.nextLine();
        String T = in.nextLine();
        
        String[] horisontalString = new String[H];
        for (int i = 0; i < H; i++) {
            horisontalString[i] = in.nextLine();
        }
        
        for (int height = 0; height < H; height ++) {
            String horizontalResult = "";
            for (int i = 0; i < T.length(); i++) {
                char character = T.toUpperCase().charAt(i);
                
                int position = (int) character;
                if ((position < CHAR_START || position > CHAR_END )) {
                    position = (int) '[';
                }
                
                
                int charHStart = (position - CHAR_START) * L;
                int charHEnd = charHStart + L;
                
                horizontalResult += horisontalString[height].substring(charHStart,charHEnd);
            }
            System.out.println(horizontalResult);
        }
    }
}