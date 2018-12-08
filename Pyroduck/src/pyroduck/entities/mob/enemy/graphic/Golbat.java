package pyroduck.entities.mob.enemy.graphic;

import pyroduck.Game;
import pyroduck.entities.mob.enemy.LowPower;
import pyroduck.graphics.Sprite;

/**
 * Implements the behavior, select the image and manage the animation of this enemy.
 * @author Bini, Petruzzello
 */
public class Golbat extends Enemy{

    public int realWidth = 24, realHeight = 24;
    
     public static Sprite golbat_up1 = new Sprite(6, 4);
    public static Sprite golbat_up2 = new Sprite(7, 4);
    public static Sprite golbat_up3 = new Sprite(8, 4);
    
    public static Sprite golbat_down1 = new Sprite(6, 7);
    public static Sprite golbat_down2 = new Sprite(7, 7);
    public static Sprite golbat_down3 = new Sprite(8, 7);
    
    public static Sprite golbat_left1 = new Sprite(6, 6);
    public static Sprite golbat_left2 = new Sprite(7, 6);
    public static Sprite golbat_left3 = new Sprite(8, 6);

    public static Sprite golbat_right1 = new Sprite(6, 5);
    public static Sprite golbat_right2 = new Sprite(7, 5);
    public static Sprite golbat_right3 = new Sprite(8, 5);

    public static Sprite golbat_dead = new Sprite(13, 2);
    /**
     * Creates an instance of <b>Golbat</b> enemy.
     * @param x horizontal coordinate in pixels.
     * @param y vertical coordinate in pixels.
     */
    public Golbat(int x, int y){
        super(x, y, golbat_dead, Game.getPlayerSpeed() / 2, 100);
        sprite = golbat_left1;	
        ep = new LowPower();
        direction = ep.calculateDirection();
    }
    
    /**
     * Chooses the sprite to show on the screen.
     */
    @Override
    protected void chooseSprite() {
        switch(direction) {
            case 0:
                if(moving)
                    sprite = Sprite.movingSprite(golbat_up1, golbat_up2, golbat_up3, animate, 60);
                else
                    sprite = golbat_down1;
                break;
            case 1:
                if (moving)
                    sprite = Sprite.movingSprite(golbat_right1, golbat_right2, golbat_right3, animate, 60);
                else
                    sprite = golbat_down1;
                break;
            case 2:
                if (moving)
                    sprite = Sprite.movingSprite(golbat_down1, golbat_down2, golbat_down3, animate, 60);
                else
                    sprite = golbat_down1;
                break;
            case 3:
                if (moving)
                    sprite = Sprite.movingSprite(golbat_left1, golbat_left2, golbat_left3, animate, 60);
                else
                    sprite = golbat_down1;
                break;
        }    
    }   
}