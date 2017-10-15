
import becker.robots.*;
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
public class RoverCmds {
    
    Scanner s = new Scanner(System.in);
    City mars;
    Rover[] rover;
    String movement;
    int perimeter;
    int wallX;
    int wallY;
    
    
    public RoverCmds(int numRover, int x, int y){
        rover = new Rover[numRover];
        mars = new City(y, x);
        this.wallX = x;
        this.wallY = y;
        this.perimeter = (x * 2) + (y * 2);
    }
    
    //PLACES ROVERS AND SETS THE COMMANDS FOR THEM
    public void placeRover(){
        //LOOP FOR EACH ROVER
        for (int i = 0; i < rover.length; i++) {
            System.out.println("Rover " + (i+1) + " :" + "Please enter starting coordinates and the"
                    + " direction the rover is facing:");
            int x = s.nextInt();
            int y = s.nextInt();
            Direction drctn = null;
            String dir = s.next();
            switch(dir.toUpperCase()){
                case "N"://SETS BEARING TO NORTH
                    drctn = Direction.NORTH;
                    break;
                case "S"://SETS BEARING TO SOUTH
                    drctn = Direction.SOUTH;
                    break;
                case "E"://SETS BEARING TO EAST
                    drctn = Direction.EAST;
                    break;
                case "W"://SETS BEARING TO WEST
                    drctn = Direction.WEST;
                    break;
                default:
                    System.out.println("Invalid entry");
            }
            rover[i] = new Rover(mars, x, y, drctn);
            System.out.println("Enter the commands");
            rover[i].setMvmt(s.next());
        }
        for (int i = 0; i < rover.length; i++) {
            movement = rover[i].getMvmt();
            for (int j = 0; j < movement.length(); j++) {
            switch (Character.toLowerCase(movement.charAt(j))) {
                case 'm'://MOVES THE ROVER IF THERE ARE NO OBSTUCTIONS
                    if(rover[i].frontIsClear()){
                    rover[i].move();
                    }
                    break;
                case 'l'://TURNS THE ROVER LEFT
                    rover[i].turnLeft();
                    break;
                case 'r'://TURNS THE ROVER RIGHT
                    rover[i].turnRight();
                    break;
                default:
                    System.out.println("Invalid entry" + movement.charAt(j));
                    break;
            }
        }
            //DISPLAYS THE POSITION AND BEARING OF THE ROVER AFTER COMMANDS ARE
            //EXECUTED 
            System.out.println("Rover " + (i+1) + " :" + rover[i].getIntersection().getStreet() + " " 
                    + rover[i].getIntersection().getAvenue()+ " "
                    + rover[i].getDirection());
        }
    }
    
    //WALLS TO MARK OFF THE AREA OF THE PLATEAU
    public void makeWalls(){
        
        Wall[] walls = new Wall[perimeter];
        
        for (int i = 0; i < walls.length; i++) {
            //EAST WALLS
            for (int j = 0; j < (wallY + 1); j++) {
                walls[i] = new Wall(mars, j, wallX, Direction.EAST);
            }
            //SOUTH WALLS
            for (int j = 0; j < (wallX + 1); j++) {
                walls[i] = new Wall(mars, wallY, j, Direction.SOUTH);
            }
            //WEST WALLS
            for (int j = 0; j < (wallY  + 1); j++) {
                walls[i] = new Wall(mars, j, 0, Direction.WEST);
            }
            //NORTH WALLS
            for (int j = 0; j < (wallX + 1); j++) {
                walls[i] = new Wall(mars, 0, j, Direction.NORTH);
            }
        }
    }
    
}
