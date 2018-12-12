/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyroduck.entities.mob;

import java.util.LinkedList;
import pyroduck.*;
import pyroduck.bomb.Bomb;
import pyroduck.level.Coordinates;

/**
 *
 * @author Umberto
 */
public class AutomatePlayer extends Player{
    
    private final int SIZE_REGISTER = 20;
    private LinkedList<Double> registerX = new LinkedList<>();
    private LinkedList<Double> registerY = new LinkedList<>();
    double i = 0;
    
    public AutomatePlayer(int x, int y) {
        super(x, y);
        fillRegisterX();
        fillRegisterY();
    }
    
    private void fillRegisterX(){
        for(int j = 0;j<113;j++) 
            registerX.add(1.0);
        for(int j = 0;j<49;j++) 
            registerX.add(-1.0);

    }
    
    private void fillRegisterY(){
        for(int j = 0;j<113;j++) 
            registerY.add(0.0);
        for(int j = 0;j<49;j++) 
            registerY.add(0.0);

    }
    @Override
    protected void calculateMove(){
        if((registerX.size()>0&&registerY.size()>0)){
            Double xa = registerX.pop();
            Double ya = registerY.pop();
           if(xa != 0 || ya != 0)  {
                move(xa * Game.getPlayerSpeed(), ya *Game.getPlayerSpeed());
                moving = true;
            } else {
                moving = false;
            }
        }
        else
            moving = false;
    }
    
    @Override
    protected void detectPlaceBomb() {
        if(registerX.size()==48)
        {
            int xt = Coordinates.pixelToTile(x);
            int yt = Coordinates.pixelToTile( y -16); //subtract half player height and minus 1 y position
            placeBomb(xt,yt);
            Game.addBombRate(-1);
        }
    }
    
    @Override
    protected void placeBomb(int x, int y) {
        Bomb b = new Bomb(x, y);
        Board.getInstance().addBomb(b);
    }
    
    @Override
    protected void updateTimerBreaker(){}
    
}

