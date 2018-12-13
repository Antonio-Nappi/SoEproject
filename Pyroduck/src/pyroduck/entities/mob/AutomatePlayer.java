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
    /*
    
    Promemoria :
    per x: +1 va a destra e -1 va a sinistra
    per y: +1 va giu e -1 va su
    Inizia con x=16, y=32?
    Ogni casella è 32?
    
    */
    
    private void fillRegisterX(){
        for(int j = 0;j<113;j++) //vai a destra di 5 caselle
            registerX.add(1.0);
        for(int j = 0;j<49;j++) //vai a sinistra di 3 caselle
            registerX.add(-1.0);
        for(int j = 0;j<101;j++) //vai a sinistra di 3 caselle
            registerX.add(0.0);//resta fermo
         for(int j = 0;j<97;j++) //vai a destra di 3 caselle
            registerX.add(1.0);
           for(int j = 0;j<97;j++) //vai a sinistra di 5 caselle
            registerX.add(-1.0);
           for(int j = 0;j<31;j++) //aspetta
               registerX.add(0.0);
           for(int j = 0;j<49;j++) //vai a destra di 3 caselle
            registerX.add(+1.0);
            for(int j = 0;j<49;j++) //vai a sinistra di 3 caselle
            registerX.add(-1.0);
             for(int j = 0;j<31;j++) //aspetta
               registerX.add(0.0);
              for(int j = 0;j<33;j++) // vai giu di una casella
               registerX.add(+0.0);
    }
    
    private void fillRegisterY(){
        for(int j = 0;j<113;j++) 
            registerY.add(0.0);
        for(int j = 0;j<49;j++) 
            registerY.add(0.0);
         for(int j = 0;j<101;j++) 
            registerY.add(0.0);
          for(int j = 0;j<97;j++) 
            registerY.add(0.0);
           for(int j = 0;j<97;j++)
            registerY.add(0.0);
           for(int j = 0;j<31;j++) //aspetta
               registerY.add(0.0);
           for(int j = 0;j<49;j++) 
            registerY.add(0.0);
            for(int j = 0;j<49;j++) 
            registerY.add(0.0);
            for(int j = 0;j<31;j++) //aspetta
               registerY.add(0.0);
             for(int j = 0;j<33;j++) // vai giu di una casella
               registerY.add(+1.0);
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
               // System.out.println(registerX.size());

        if(registerX.size()==533|| registerX.size()==288 || registerX.size()==113)
        {
            //System.out.println("BOMB");
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

