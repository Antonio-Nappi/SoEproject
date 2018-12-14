package pyroduck.bomb;

import static java.lang.Math.abs;
import java.util.List;
import java.util.ListIterator;
import pyroduck.Board;
import pyroduck.Game;
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
    
    private final double MISSILE_SPEED = 2.5;
    private final int direction;
    private int range;

    public Missile(int x, int y,int direction) {
        super(x,y);
        this.direction = direction;
        sprite = Sprite.missle;
        range = 50;
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
        if(!exploded)
            screen.renderEntity((int)x-16, (int)y-32 , this);
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
        Entity e = Board.getInstance().entities[((int)x0/32 + (int)y0/32 * FileLevel.WIDTH)];
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
            if(abs(m.getX()-x) < 32 && abs(m.getY()-y) < 32){
                if(m.isAlive())
                    m.kill();
            }      
        }
    }
    
    @Override
    public boolean isMissile(){
        return true;
    }
}