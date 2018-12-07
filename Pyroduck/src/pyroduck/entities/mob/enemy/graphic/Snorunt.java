package pyroduck.entities.mob.enemy.graphic;

import pyroduck.Game;
import pyroduck.entities.mob.enemy.LowPower;
import pyroduck.graphics.Sprite;
import pyroduck.graphics.SpriteSheet;

/**
 * Implements the behavior, select the image and manage the animation of this enemy.
 * @author Bini, Petruzzello
 */
public class Snorunt extends Enemy{
    
    public int realWidth = 28, realHeight = 28;
     public static Sprite snorunt_up1 = new Sprite(6, 8);
    public static Sprite snorunt_up2 = new Sprite(7, 8);
    public static Sprite snorunt_up3 = new Sprite(8, 8);
    
    public static Sprite snorunt_down1 = new Sprite(6, 11);
    public static Sprite snorunt_down2 = new Sprite(7, 11);
    public static Sprite snorunt_down3 = new Sprite(8, 11);
    
    public static Sprite snorunt_left1 = new Sprite(6, 10);
    public static Sprite snorunt_left2 = new Sprite(7, 10);
    public static Sprite snorunt_left3 = new Sprite(8, 10);

    public static Sprite snorunt_right1 = new Sprite(6, 9);
    public static Sprite snorunt_right2 = new Sprite(7, 9);
    public static Sprite snorunt_right3 = new Sprite(8, 9);

    public static Sprite snorunt_dead = new Sprite(13, 2);
    /**
     * Creates an instance of <b>Snorunt</b> enemy.
     * @param x horizontal coordinate in pixels.
     * @param y vertical coordinate in pixels.
     */
    public Snorunt(int x, int y){
        super(x, y, snorunt_dead, Game.getPlayerSpeed() / 2, 100);
        sprite = snorunt_left1;	
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
                    sprite = Sprite.movingSprite(snorunt_up1, snorunt_up2, snorunt_up3, animate, 60);
                else
                    sprite = snorunt_down1;
                break;
            case 1:
                if(moving)
                    sprite = Sprite.movingSprite(snorunt_right1, snorunt_right2, snorunt_right3, animate, 60);
                else
                    sprite = snorunt_down1;
                break;
            case 2:
                if(moving)
                    sprite = Sprite.movingSprite(snorunt_down1, snorunt_down2, snorunt_down3, animate, 60);
                else
                    sprite = snorunt_down1;
                break;
            case 3:
                if(moving)
                    sprite = Sprite.movingSprite(snorunt_left1, snorunt_left2, snorunt_left3, animate, 60);
                else
                    sprite = snorunt_down1;
                break;
        }    
    }   
}