package pyroduck.entities.mob.enemy.graphic;

import pyroduck.*;
import pyroduck.entities.mob.enemy.MediumPower;
import pyroduck.graphics.Sprite;

/**
 * Implements the behavior, select the image and manage the animation of this enemy.
 * @author Bini, Petruzzello
 */
public class Arbok extends Enemy{
    
    public int realWidth = 28, realHeight = 28;
    public static Sprite arbok_up1 = new Sprite(12, 4);
    public static Sprite arbok_up2 = new Sprite(13, 4);
    public static Sprite arbok_up3 = new Sprite(14, 4);
    
    public static Sprite arbok_down1 = new Sprite(12, 5);
    public static Sprite arbok_down2 = new Sprite(13, 5);
    public static Sprite arbok_down3 = new Sprite(14, 5);
    
    public static Sprite arbok_left1 = new Sprite(12, 6);
    public static Sprite arbok_left2 = new Sprite(13, 6);
    public static Sprite arbok_left3 = new Sprite(14, 6);

    public static Sprite arbok_right1 = new Sprite(12, 7);
    public static Sprite arbok_right2 = new Sprite(13, 7);
    public static Sprite arbok_right3 = new Sprite(14, 7);

    public static Sprite arbok_dead = new Sprite(13, 2);
    
    /**
     * Creates an instance of <b>Arbok</b> enemy.
     * @param x horizontal coordinate in pixels.
     * @param y vertical coordinate in pixels.
     */
    public Arbok(int x, int y){
        super(x, y, arbok_dead, Game.getPlayerSpeed() - 0.1, 300);
        sprite = arbok_left1;	
        ep = new MediumPower(Board.getInstance().getPlayer(), this);
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
                    sprite = Sprite.movingSprite(arbok_up1, arbok_up2, arbok_up3, animate, 60);
                else 
                    sprite= arbok_down1;
                break;
            case 1:
                if(moving) 
                    sprite = Sprite.movingSprite(arbok_right1, arbok_right2, arbok_right3, animate, 60);
                else 
                    sprite= arbok_down1;
                break;
            case 2:
                if(moving) 
                    sprite = Sprite.movingSprite(arbok_down1, arbok_down2, arbok_down3, animate, 60);
                else 
                    sprite= arbok_down1;

                break;
            case 3:
               if(moving) 
                   sprite = Sprite.movingSprite(arbok_left1, arbok_left2, arbok_left3, animate, 60);
                else 
                   sprite= arbok_down1;
                break;
        }    
    }
}