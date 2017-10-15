
import becker.robots.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arso
 */
public class Rover extends Robot{
    
    String mvmt;
    
    public Rover(City city, int i, int i1, Direction drctn) {
        super(city, i, i1, drctn);
    }
    
    public void turnAround() {
        turnLeft();
        turnLeft();
    }
    
    public void turnRight() {
        this.setSpeed(100);
        turnAround();
        turnLeft();
        this.setSpeed(2);
    }
    
    public String getMvmt(){
        return mvmt;
    }
    
    public void setMvmt(String mvmt){
        this.mvmt = mvmt;
    }
}
