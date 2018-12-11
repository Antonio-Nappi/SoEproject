/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyroduck.entities.mob;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import pyroduck.Board;
import pyroduck.Game;
import pyroduck.bomb.Bomb;
import pyroduck.entities.tile.destroyable.DestroyableIceTile;
import pyroduck.level.Coordinates;

/**
 *
 * @author Umberto
 */
public class AutomatePlayer extends Player{
    
    private final int SIZE_REGISTER = 20;
    private LinkedList<Double> registerX = new LinkedList<>();
    private LinkedList<Double> registerY = new LinkedList<>();
    
    public AutomatePlayer(int x, int y) {
        super(x, y);
        fillRegisterX();
        fillRegisterY();
    }
    
    
    private void fillRegisterX(){
        
    }
    
    private void fillRegisterY(){
        
    }
    @Override
    protected void calculateMove(){
        Double xa = registerX.pop();
        Double ya = registerY.pop();
       if(xa != 0 || ya != 0)  {
            move(xa * Game.getPlayerSpeed(), ya *Game.getPlayerSpeed());
            moving = true;
        } else {
            moving = false;
        }
    }
    
    @Override
    protected void detectPlaceBomb() {
            int xt = Coordinates.pixelToTile(x + sprite.getSize() / 2);
            int yt = Coordinates.pixelToTile( (y + sprite.getSize() / 2) - sprite.getSize() ); //subtract half player height and minus 1 y position
            placeBomb(xt,yt);
            Game.addBombRate(-1);
        }
    
    @Override
    protected void placeBomb(int x, int y) {
        Bomb b = new Bomb(x, y);
        Board.getInstance().addBomb(b);
    }
    
    @Override
    protected void updateTimerBreaker(){}
    
}

