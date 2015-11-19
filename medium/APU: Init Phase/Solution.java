import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Don't let the machines win. You are humanity's last hope...
 **/
class Player {
    private static final String NO_NEIGHBOR = "-1 -1";

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int width = in.nextInt(); // the number of cells on the X axis
        in.nextLine();
        int height = in.nextInt(); // the number of cells on the Y axis
        in.nextLine();
        boolean[][] map = new boolean[height][width];
        for (int i = 0; i < height; i++) {

            String line = in.nextLine(); // width characters, each either 0 or .
            System.err.println(line);
            fillElementsFromString(map[i], line);
        }

        printEveryElementNeightbors(map);
    }

    private static void fillElementsFromString(boolean[] line, String lineToRead) {
        for (int i =0; i<line.length; i++) {
            if (lineToRead.charAt(i) == '0') {
                line[i] = true;
            } else {
                line[i] = false;
            }
        }
    }

    private static void printEveryElementNeightbors(boolean[][] map) {
        for (int row=0; row<map.length; row++) {
            for (int column=0; column<map[row].length; column++) {
                System.err.println(column + " " + row + " " + map[row][column]);
                if (map[row][column] == true) {
                    System.out.println(column + " " + row + 
                                       " " + getRightNeighbor(row, column, map) +
                                       " " + getBottomNeighbor(row, column, map));
                }
            }
        }
    }

    private static String getRightNeighbor(int row, int column, boolean[][] map) {
        for (int i = column + 1; i < map[row].length; i++) {
            System.err.println(map[row][i]);
            if (Boolean.TRUE.equals(map[row][i])) {
                return (column + 1) + " " + row;
            }
        }
        return NO_NEIGHBOR;
    }

    private static String getBottomNeighbor(int row, int column, boolean[][] map) {
        for (int i = row + 1; i < map.length; i++) {
            if (map[i][column] == true) {
                return column + " " + (row + 1);
            }
        }
        return NO_NEIGHBOR;
    }

}