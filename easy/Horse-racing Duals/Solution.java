// Read inputs from System.in, Write outputs to System.out.
// Your class name has to be Solution

import java.util.*;
import java.io.*;
import java.math.*;

class Solution {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			int strength = in.nextInt();
			list.add(strength);
		}
		Collections.sort(list);
		int min = list.get(1)-list.get(0);
		for (int i = 2; i < list.size(); i++) {
		    int diff = list.get(i) - list.get(i-1);
		    if (diff < min) {
		        min = diff;
		    }
		}
		
		System.out.println(min);
	}
}