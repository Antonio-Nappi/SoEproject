package pyroduck.entities.mob.enemy.graphic;

import pyroduck.Board;
import pyroduck.Game;
import pyroduck.entities.mob.enemy.MediumPower;
import pyroduck.graphics.Sprite;

/**
 * Implements the behavior, select the image and manage the animation of this enemy.
 * @author Bini, Petruzzello
 */
public class Machamp extends Enemy{
    
    public int realWidth = 28, realHeight = 28;
    public static Sprite machamp_up1 = new Sprite(9, 5);
    public static Sprite machamp_up2 = new Sprite(10, 5);
    public static Sprite machamp_up3 = new Sprite(11, 5);
    
    public static Sprite machamp_down1 = new Sprite(9, 4);
    public static Sprite machamp_down2 = new Sprite(10, 4);
    public static Sprite machamp_down3 = new Sprite(11, 4);
    
    public static Sprite machamp_left1 = new Sprite(9, 6);
    public static Sprite machamp_left2 = new Sprite(10, 6);
    public static Sprite machamp_left3 = new Sprite(11, 6);

    public static Sprite machamp_right1 = new Sprite(9, 7);
    public static Sprite machamp_right2 = new Sprite(10, 7);
    public static Sprite machamp_right3 = new Sprite(11, 7);

    public static Sprite machamp_dead = new Sprite(13, 2);
    /**
     * Creates an instance of <b>Machamp</b> enemy.
     * @param x horizontal coordinate in pixels.
     * @param y vertical coordinate in pixels.
     */
    public Machamp(int x, int y){
        super(x, y, machamp_dead, Game.getPlayerSpeed() / 2, 200);
        sprite = machamp_left1;	
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
                    sprite = Sprite.movingSprite(machamp_up1, machamp_up2, machamp_up3, animate, 60);
                else
                    sprite = machamp_down1;
                break;
            case 1:
                if(moving)
                    sprite = Sprite.movingSprite(machamp_right1, machamp_right2, machamp_right3, animate, 60);
                else 
                    sprite = machamp_down1;
                break;
            case 2:
                if(moving)
                    sprite = Sprite.movingSprite(machamp_down1, machamp_down2, machamp_down3, animate, 60);
                else
                    sprite = machamp_down1;
                break;
            case 3:
                if(moving)
                    sprite = Sprite.movingSprite(machamp_left1, machamp_left2, machamp_left3, animate, 60);
                else
                    sprite = machamp_down1;
                break;
        }    
    }   
}
