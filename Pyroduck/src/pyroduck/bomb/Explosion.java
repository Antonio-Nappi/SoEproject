package pyroduck.bomb;

import pyroduck.entities.Entity;
import pyroduck.entities.mob.Mob;
import pyroduck.graphics.*;

/**
 * Represents the class able to manage the graphic of the explosion and 
 * used to set the images of each related tile in the explosion
 * @author Corbisiero, Ferrara, La Femina
 */
public class Explosion extends Entity {

    protected boolean last = false;
    protected Sprite sprite1, sprite2;

    /**
     * 
     * @param x
     * @param y
     * @param direction
     * @param last
     */
    public Explosion(int x, int y, int direction, boolean last) {
        this.x = x;
        this.y = y;
        this.last = last;

        switch (direction) {
            case 0:
                if(last == false) {
                    sprite = Sprite.explosion_vertical2;
                } else {
                    sprite = Sprite.explosion_vertical_top_last2;
                }
            break;
            case 1:
                if(last == false) {
                    sprite = Sprite.explosion_horizontal2;
                } else {
                    sprite = Sprite.explosion_horizontal_right_last2;
                }
                break;
            case 2:
                if(last == false) {
                    sprite = Sprite.explosion_vertical2;
                } else {
                    sprite = Sprite.explosion_vertical_down_last2;
                }
                break;
            case 3: 
                if(last == false) {
                    sprite = Sprite.explosion_horizontal2;
                } else {
                    sprite = Sprite.explosion_horizontal_left_last2;
                }
                break;
        }
    }

    /**
     *Invokes the screen's method that provides to print on the screen each related tile in the explosion
     * @param screen on which the print is called.
     */
    @Override
    public void render(Screen screen) {
        int xt = (int)x << 5;
        int yt = (int)y << 5;
        screen.renderEntity(xt, yt , this);
    }

    /**
     * Not implemented method.
     */
    @Override
    public void update() {}

    /**
     * Return false if the explosion entity collide with other entity.
     * @param e is the entity with which is checked the collision.
     * @return 
     */
    @Override
    public boolean collide(Entity e) {
        if(e.isMob()) 
            ((Mob)e).kill();
        return false;
    }
}