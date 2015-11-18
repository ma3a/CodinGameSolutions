import java.util.*;
import java.io.*;
import java.math.*;

class Player {
    private static char[][] matrix = null;
    private static int height;
    private static int width;

    public static void main(String args[]) {
        
        Scanner in = new Scanner(System.in);
        width = in.nextInt(); 
        in.nextLine();
        height = in.nextInt();
        System.err.println("w= " + width + "  h=" + height);
        matrix = new char[height][width];

        List<Node> nodes = new ArrayList<Node>();

        in.nextLine();
        for (int y = 0; y < height; y++) {
            String line = in.nextLine();

            for (int x=0 ; x < width; x++) {
                matrix[y][x] = line.charAt(x);
                if (notEmpty(x, y)) {
                    Node node = new Node(x, y);
                    nodes.add(node);
                }
            }
        }

        System.err.println(" ######################################");
        for (Node node : nodes) {
            System.err.println("  " + node + "   val=" + matrix[node.y][node.x]);
            System.out.println(node + " " + right(node.x, node.y) + " " + bottom(node.x, node.y));
        }
    }

    private static boolean notEmpty(int x, int y) {
        if (x >= width || y >= height) {
            return false;
        }
        System.err.println("            x=" + x + "  y=" + y + "  val" + matrix[y][x]);
        if ('0' == matrix[y][x]) {
            return true;
        }
        return false;
    }

    private static Node right(int x, int y) {
        for (int i = x + 1; i < width; i++) {
            if (notEmpty(i,y)) {
                return new Node(i,y);
            }
        }
        return Node.falseNode();
    }

    private static Node bottom(int x, int y) {
        for (int i = y + 1; i < height; i++) {
            
            if (notEmpty(x,i)) {
                return new Node(x,i);
            }
        }
        return Node.falseNode();
    }
}

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Node falseNode() {
        return new Node(-1, -1);
    }

    public String toString() {
        return x + " " + y;
    }
}