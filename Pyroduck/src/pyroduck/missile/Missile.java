/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyroduck.missile;

import pyroduck.Game;
import pyroduck.bomb.Bomb;
import pyroduck.entities.Entity;
import pyroduck.entities.mob.enemy.graphic.Enemy;
import pyroduck.entities.tile.destroyable.DestroyableTile;
import pyroduck.graphics.Screen;
import pyroduck.graphics.Sprite;

/**
 *
 * @author Gerry
 */
public class Missile extends Bomb{

    private final int MISSILE_SPEED = 2;

    public Missile(int x, int y) {
        super(x, y);
        sprite = Sprite.bomb;   //mettere missile
    }
    

    @Override
    public void update() {
        if(!exploded){
            move(); 
        }
        else
            remove();
    }

    @Override
    public void render(Screen screen) {
        if(!exploded){
            int xt = (int)x * Game.TILES_SIZE;
            int yt = (int)y * Game.TILES_SIZE;
            screen.renderEntity(xt, yt , this);
        }
    }

    @Override
    public boolean collide(Entity e) {
        if(e instanceof Enemy){
            ((Enemy)e).kill();
            exploded = true;
            return true;
        }
        
        if(e instanceof DestroyableTile){
            return true;
        }
        
        return false;
        
    }
    
    private void move() {
        
        x += MISSILE_SPEED;
        
//        if (x > BOARD_WIDTH)
//            visible = false;
    }
}
