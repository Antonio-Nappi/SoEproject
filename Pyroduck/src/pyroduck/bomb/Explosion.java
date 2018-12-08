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
     public static Sprite bomb_exploded = new Sprite(12, 1);
    public static Sprite bomb_exploded1 = new Sprite(12, 2);
    

    public static Sprite explosion_vertical = new Sprite(6, 2);
    public static Sprite explosion_vertical1 = new Sprite(7, 2);
    public static Sprite explosion_vertical2 = new Sprite(8, 2);

    public static Sprite explosion_horizontal = new Sprite(10, 1);
    public static Sprite explosion_horizontal1 = new Sprite(10, 2);
    public static Sprite explosion_horizontal2 = new Sprite(10, 3);

    public static Sprite explosion_horizontal_left_last = new Sprite(9, 1);
    public static Sprite explosion_horizontal_left_last1 = new Sprite(9, 2);
    public static Sprite explosion_horizontal_left_last2 = new Sprite(9, 3);

    public static Sprite explosion_horizontal_right_last = new Sprite(11, 1);
    public static Sprite explosion_horizontal_right_last1 = new Sprite(11, 2);
    public static Sprite explosion_horizontal_right_last2 = new Sprite(11, 3);

    public static Sprite explosion_vertical_top_last = new Sprite(6, 1);
    public static Sprite explosion_vertical_top_last1 = new Sprite(7, 1);
    public static Sprite explosion_vertical_top_last2 = new Sprite(8, 1);

    public static Sprite explosion_vertical_down_last = new Sprite(6, 3);
    public static Sprite explosion_vertical_down_last1 = new Sprite(7, 3);
    public static Sprite explosion_vertical_down_last2 = new Sprite(8, 3);

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
                    sprite = explosion_vertical2;
                } else {
                    sprite = explosion_vertical_top_last2;
                }
            break;
            case 1:
                if(last == false) {
                    sprite = explosion_horizontal2;
                } else {
                    sprite = explosion_horizontal_right_last2;
                }
                break;
            case 2:
                if(last == false) {
                    sprite = explosion_vertical2;
                } else {
                    sprite = explosion_vertical_down_last2;
                }
                break;
            case 3: 
                if(last == false) {
                    sprite = explosion_horizontal2;
                } else {
                    sprite = explosion_horizontal_left_last2;
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
        if(e instanceof Mob) 
            ((Mob)e).kill();
        return false;
    }
}