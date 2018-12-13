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
    
    private boolean putBomb = false;
    private int counter_idle = 0;
    private static boolean first = true;
    private LinkedList<Double> registerX = new LinkedList<>();
    private LinkedList<Double> registerY = new LinkedList<>();
    
    public AutomatePlayer(int x, int y) {
        super(x, y);
        fillRegisters();
    }
    /*
    
    Promemoria :
    per x: +1 va a destra e -1 va a sinistra
    per y: +1 va giu e -1 va su
    Inizia con x=16, y=32?
    Ogni casella è 32?
    
    */
    
    private void fillRegisters(){
        if(first){
            first = false;
            moveRight(2);  //muoviti a destra di 2 caselle
            moveDown(2);
            wait(6);
            moveRight(3);
            putBomb();
            moveLeft(2);
            wait(9);
            moveRight(3);
            wait(1);
            putBomb();
            moveLeft(2);
            moveDown(1);
            wait(2);
            moveUp(1);
            moveLeft(2);
            putBomb();
            moveLeft(2);
            moveDown(2);
            wait(7);
            moveRight(2);
            moveDown(1); //----
            putBomb();
            moveUp(1);
            moveLeft(1);
            wait(4);
            moveRight(1);
            moveDown(2);
            wait(8);
            moveUp(4);
            moveRight(2);
            wait(1);
            putBomb();
            moveLeft(1);
            putBomb();
            moveLeft(1);
            moveDown(2);
            putBomb();
            moveLeft(2);
            moveDown(1);
            wait(3);
            moveUp(1);
            moveRight(2);
            moveDown(2);
        }
        else{
           moveRight(4);
           moveDown(3);
           putBomb();
           moveUp(3);
           wait(3);
           moveDown(2);
        }
          
    }
    
    @Override
    protected void calculateMove(){
     
        if(counter_idle< 500){  //player initial idle -> 500*15 ms
            counter_idle++;
            return;
        }
        if(registerX.size()>0&&registerY.size()>0){
            Double xa = registerX.pop();
            Double ya = registerY.pop();
           if(xa != 0 || ya != 0)  {
                if(xa == 3)
                    putBomb = true;
                else{
                    move(xa, ya);
                    moving = true;
                }
            } else {
                moving = false;
            }
        }
        else
            moving = false;
    }
    
    @Override
    protected void detectPlaceBomb() {   
        if(putBomb){
            int xt = Coordinates.pixelToTile(x+16);
            int yt = Coordinates.pixelToTile( y -16); //subtract half player height and minus 1 y position
            placeBomb(xt,yt);
            Game.addBombRate(-1);
            putBomb = false;
        }
    }
    
    @Override
    protected void placeBomb(int x, int y) {
        Bomb b = new Bomb(x, y);
        Board.getInstance().addBomb(b);
    }
    
    private void moveLeft(int n){
        for(int i=0; i<n*Game.TILES_SIZE; i++){
            registerX.add(-1.0);
            registerY.add(0.0);
        }
    }
    
    private void moveRight(int n){
        for(int i=0; i<n*Game.TILES_SIZE; i++){
            registerX.add(1.0);
            registerY.add(0.0);
        }
    }
    
    private void moveUp(int n){
        for(int i=0; i<n*Game.TILES_SIZE; i++){
            registerX.add(0.0);
            registerY.add(-1.0);
        }
    }
    
    private void moveDown(int n){
        for(int i=0; i<n*Game.TILES_SIZE; i++){
            registerX.add(0.0);
            registerY.add(1.0);
        }
    }
    
    private void wait(int n){
       for(int i=0; i<n*Game.TILES_SIZE; i++){
            registerX.add(0.0);
            registerY.add(0.0);
        }
    }
    
    private void putBomb(){
        registerX.add(3.0);
        registerY.add(0.0);
    }
    
    @Override
    protected void updateTimerBreaker(){}
    
}

