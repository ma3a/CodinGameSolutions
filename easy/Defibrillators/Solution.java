import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {
    
    public static final int EARTH_RADIUS = 6371;

    public static void main(String args[]) {
        
        List<Object[]> difibPosition = new ArrayList<Object[]>();
        
        Scanner in = new Scanner(System.in);
        String LON = in.next();
        in.nextLine();
        String LAT = in.next();
        in.nextLine();
        int N = in.nextInt();
        in.nextLine();
        
        LAT = LAT.replaceAll(",",".");
        LON = LON.replaceAll(",",".");
        
        for (int i = 0; i < N; i++) {
            String DEFIB = in.nextLine();
            String[] fields = DEFIB.split(";");
            
            String name = fields[1];
            String lon = fields[4].replaceAll(",",".");
            String latt = fields[5].replaceAll(",",".");
            
            Object[] obj = new Object[] {name, calcDistanse(Double.valueOf(LON),
                                                             Double.valueOf(LAT),
                                                             Double.valueOf(lon),
                                                             Double.valueOf(latt)) };
            difibPosition.add(obj);
        }
        int minimalIndex = 0;
        for (int i = 1; i < difibPosition.size(); i++) {
            Double currentVal = (Double) difibPosition.get(i)[1];
            Double minimalVal = (Double) difibPosition.get(minimalIndex)[1];
            
            if (currentVal < minimalVal) {
                minimalIndex = i;
            }
        }

        System.out.println((difibPosition.get(minimalIndex)[0]));
    }
    
    public static Double calcDistanse(Double uLong, Double uLattit, Double dLong, Double dLattit) {
        Double radLongA = Math.toRadians(uLong);
        Double radLattitA = Math.toRadians(uLattit);
        Double radLongB = Math.toRadians(dLong);
        Double radLattitB = Math.toRadians(dLattit);
        
        Double x = (radLongB - radLongA) * Math.cos((radLattitA + radLattitB) / 2);
        Double y = (radLattitB - radLattitA);
        
        Double d = Math.sqrt( (x * x) + (y * y)) + EARTH_RADIUS;
        
        return d;
    }
}