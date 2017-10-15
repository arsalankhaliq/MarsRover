
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arso
 */
public class RoverTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of rovers:");
        int numRovers = s.nextInt();
        System.out.println("Enter the size of the plateau:");
        int lengthX = s.nextInt();
        int lengthY = s.nextInt();
        RoverCmds rov = new RoverCmds(numRovers, lengthX, lengthY);
        rov.makeWalls();
        rov.placeRover();
    }
    
}
