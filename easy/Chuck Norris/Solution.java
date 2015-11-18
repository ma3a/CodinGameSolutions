import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String MESSAGE = in.nextLine();
        
        StringBuffer binaryMessage = new StringBuffer();
        for (int i=0; i < MESSAGE.length(); i++) {
            int character = (int) MESSAGE.charAt(i);
            String sevenBit = String.format("%7s", Integer.toBinaryString(character)).replace(' ', '0');
            binaryMessage.append(sevenBit);
        }
        System.err.println(binaryMessage);
        System.out.println(toChuckCode(binaryMessage.toString()));
    }
    
    public static String toChuckCode(String binaryMessage) {
        int sequence = 0;
        int counter = 0;
        
        StringBuilder chuckCode = new StringBuilder();
        
        while (counter < binaryMessage.length()) {
            char current = binaryMessage.charAt(counter);
            System.err.println("\ncurrent = " + current);
            
            if ((counter == 0) ||
               (current == binaryMessage.charAt(counter - 1))) {
                System.err.println("   seq++");
                sequence ++;
            } else if (current != binaryMessage.charAt(counter - 1)) {
                appendSequence(binaryMessage.charAt(counter - 1), sequence, chuckCode);
                chuckCode.append(" ");
                sequence = 1;
            }
            counter++;
        }
        appendSequence(binaryMessage.charAt(binaryMessage.length() - 1), sequence, chuckCode);
        
        return chuckCode.toString();
    }
    
    public static boolean isZero(char character) {
        return character == '0';
    }
    
    public static void appendZero(int count, StringBuilder builder) {
        for (int i = 1; i <= count; i++) {
            builder.append("0");
        }
    }
    
    public static void appendSequence(char current, int sequence, StringBuilder builder) {
        String zeroString = "00";
        String oneString = "0";
        
        boolean isZero = isZero(current);
        if (isZero) {
            System.err.println("   zero ends");
            builder.append(zeroString);
        } else {
            System.err.println("   one ends");
            builder.append(oneString);
        }
        
        builder.append(" ");
        appendZero(sequence, builder);
    }
}