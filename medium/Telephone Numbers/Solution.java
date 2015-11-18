import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {
    
    private static PhoneDigit root = new PhoneDigit();

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for (int i = 0; i < N; i++) {
            String telephone = in.next();
            int[] telephoneDig = new int[telephone.length()];
            for (int j=0; j < telephoneDig.length; j++) {
                telephoneDig[j] = Character.getNumericValue(telephone.charAt(j));
            }
            root.populateTelephoneNum(telephoneDig);
        }
        System.out.println(root.count());
    }
}

class PhoneDigit {
    PhoneDigit[] values =  new PhoneDigit[10];
    private int dig;

    public PhoneDigit() {};
    public PhoneDigit(int dig) {
        this.dig = dig;
    };

    public void populateTelephoneNum(int[] tel) {
        PhoneDigit lastDigit = null;
        for (int i=0; i< tel.length; i++) {
            int dig = tel[i];
            if (i == 0) {
                this.addDigit(dig);
                lastDigit = this.getDigit(dig);
            } else {
                lastDigit.addDigit(dig);
                lastDigit = lastDigit.getDigit(dig);
            }
        }
    }
    
    private boolean hasDigit(int digit) {
        return values[digit] != null;
    }
    
    private PhoneDigit getDigit(int digit) {
        return values[digit];
    }
    
    private void addDigit(int digit) {
        if (hasDigit(digit)) {
            return;
        }
        values[digit] = new PhoneDigit(digit);
    }
    
    public int count() {
        return countRecursion(this, 0);
    }
    
    private int countRecursion(PhoneDigit digit, int sum) {
        sum += countNotNullReference(digit.values);

        for (PhoneDigit child : digit.values) {
            if (child != null) {
                sum = countRecursion(child, sum);
            }
        }
        return sum;
    }
    
    private int countNotNullReference(PhoneDigit[] array) {
        int sum = 0;
        for (PhoneDigit digit : array) {
            if (digit != null) {
                sum++;
            }
        }
        return sum;
    }
    
}