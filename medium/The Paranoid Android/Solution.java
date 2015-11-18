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
        int nbFloors = in.nextInt(); // number of floors
        int width = in.nextInt(); // width of the area
        int nbRounds = in.nextInt(); // maximum number of rounds
        int exitFloor = in.nextInt(); // floor on which the exit is found
        int exitPos = in.nextInt(); // position of the exit on its floor
        int nbTotalClones = in.nextInt(); // number of generated clones
        int nbAdditionalElevators = in.nextInt(); // ignore (always zero)
        int nbElevators = in.nextInt(); // number of elevators

        int[] elevators = new int[nbFloors];
        for (int i = 0; i < nbElevators; i++) {
            int elevatorFloor = in.nextInt(); // floor on which this elevator is found
            int elevatorPos = in.nextInt(); // position of the elevator on its floor
            elevators[elevatorFloor] = elevatorPos;
        }

        // game loop
        while (true) {
            int cloneFloor = in.nextInt(); // floor of the leading clone
            int clonePos = in.nextInt(); // position of the leading clone on its floor
            String direction = in.next(); // direction of the leading clone: LEFT or RIGHT

            System.err.println("cloneFloor: " + cloneFloor);
            System.err.println("clonePos: " + clonePos);
            System.err.println("direction: " + direction);

            if (cloneFloor == -1 || clonePos == -1) {
                System.out.println("WAIT");
                continue;
            }
            int currentElPos = elevators[cloneFloor];
            if (exitFloor == cloneFloor) {
                currentElPos = exitPos;
            }

            System.err.println("currentElPos: " + currentElPos);
            
            /// 0 EL   CL 80
            /// 0 CL   EL 80
            if (clonePos > currentElPos) {
                if ("RIGHT".equals(direction)) {
                    System.out.println("BLOCK");
                } else {
                    System.out.println("WAIT");
                }
            } else if (currentElPos > clonePos) {
                if ("LEFT".equals(direction)) {
                    System.out.println("BLOCK");   
                } else {
                    System.out.println("WAIT");
                }
            } else { 
                System.out.println("WAIT");
            }
        }
    }
}