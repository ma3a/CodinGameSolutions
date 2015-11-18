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
        int R = in.nextInt();
        int L = in.nextInt();

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        Sequence seq = new Sequence(R);
        seq.printLine(seq.getLine(L));
    }

}

class Sequence {
	List<Line> lines = new ArrayList();

    public Sequence(int start) {
    	lines.add(new Line(new ArrayList(Arrays.asList(start))));
    }

    public Line getLine(int lineNum) {

    	for (int i=0; i < lineNum; i++) {
    		Line newLine = new Line(lines.get(i));
    		lines.add(newLine);
    	}
    	return lines.get(lineNum-1);
    }

    public void printLine(Line line) {
    	String result = "";
    	for (Integer num : line.numbers) {
    		result += num + " ";
    	}
    	System.out.println(result.trim());
    }
}

class Line {
    public List<Integer> numbers = new ArrayList<Integer>();
    
    public Line(Line prev) {
    	System.err.println(prev.numbers);
        this.numbers = lookAndSay(prev.numbers);
    }
    
    public Line(List<Integer> numbers) {
        this.numbers = numbers;
    }
    
    private List<Integer> lookAndSay(List<Integer> nums) {
        
        int countSay = 0;

        List<Integer> nextLine = new ArrayList<Integer>();

        if (nums.size() == 1) {
        	nextLine.add(1);
        	nextLine.add(nums.get(0));
        	return nextLine;
        }

        for (int i = 1; i < nums.size(); i++) {
        	int prev = nums.get(i-1);
        	int curent = nums.get(i);

        	countSay++;
        	if (prev != curent) {
        		nextLine.add(countSay);
        		nextLine.add(prev);
        		countSay=0;
        	}
        }
        countSay++;
		nextLine.add(countSay);
		nextLine.add(nums.get(nums.size() - 1));
        return nextLine;
    }
}