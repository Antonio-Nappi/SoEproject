package pyroduck.missile;

import static java.lang.Math.abs;
import java.util.List;
import java.util.ListIterator;
import pyroduck.Board;
import pyroduck.Game;
import pyroduck.bomb.*;
import pyroduck.entities.Entity;
import pyroduck.entities.mob.Mob;
import pyroduck.entities.mob.enemy.graphic.Enemy;

import pyroduck.graphics.*;
import pyroduck.level.FileLevel;

/**
 *
 * @author 
 */
public class Missile extends Bomb{

    private final double MISSILE_SPEED = 0.15;
    private final int direction;
    private int range;

    public Missile(int x, int y,int direction) {
        super(x, y);
        this.direction = direction;
        sprite = Sprite.missle;
        range = 30;

    }

    @Override
    public void update() {
        if(!exploded){
            range--;
            move();
            if(range <= 0)
                exploded = true;
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
        return false;      
    }
    
    private void move() {
        double x0 = x, y0 = y;
        switch(direction){
           case 0:
               y0 -= MISSILE_SPEED;
               break;
           case 1:
               x0 += MISSILE_SPEED;
               break;
           case 2:
               y0 += MISSILE_SPEED;
               break;
           case 3: 
               x0 -= MISSILE_SPEED;
               break;
        }
        Entity e = Board.getInstance().entities[((int)x0 + (int)y0 * FileLevel.WIDTH)];
        if(!e.collide(this)){
            x = x0;
            y = y0;
        }else{
            exploded = true;
        }
        List<Mob> mobs1 = Board.getInstance().getMobs();
        ListIterator li = mobs1.listIterator(1);
        while(li.hasNext()){
            Enemy m = (Enemy) li.next();  
            if(abs(m.getX()-x*32) < 35 && abs(m.getY()-y*32) < 35)
                m.kill();
        }
    }
    
    @Override
    public boolean isMissile(){
        return true;
    }
}