package pyroduck.entities.mob.enemy.graphic;

import pyroduck.Board;
import pyroduck.Game;
import pyroduck.entities.mob.enemy.MediumPower;
import pyroduck.graphics.Sprite;
import pyroduck.graphics.SpriteSheet;

/**
 * Implements the behavior, select the image and manage the animation of this enemy.
 * @author Bini, Petruzzello
 */
public class Glalie extends Enemy{
    
    public int realWidth = 28, realHeight = 28;
    public static Sprite glalie_up1 = new Sprite(9, 8);
    public static Sprite glalie_up2 = new Sprite(10, 8);
    public static Sprite glalie_up3 = new Sprite(11, 8);
    
    public static Sprite glalie_down1 = new Sprite(9, 11);
    public static Sprite glalie_down2 = new Sprite(10, 11);
    public static Sprite glalie_down3 = new Sprite(11, 11);
    
    public static Sprite glalie_left1 = new Sprite(9, 10);
    public static Sprite glalie_left2 = new Sprite(10, 10);
    public static Sprite glalie_left3 = new Sprite(11, 10);

    public static Sprite glalie_right1 = new Sprite(9, 9);
    public static Sprite glalie_right2 = new Sprite(10, 9);
    public static Sprite glalie_right3 = new Sprite(11, 9);

    public static Sprite glalie_dead = new Sprite(13, 2);
    /**
     * Creates an instance of <b>Glalie</b> enemy.
     * @param x horizontal coordinate in pixels.
     * @param y vertical coordinate in pixels. 
     */
    public Glalie(int x, int y){
        super(x, y, glalie_dead, Game.getPlayerSpeed() / 2, 200);
        sprite = glalie_left1;	
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
                   sprite = Sprite.movingSprite(glalie_up1, glalie_up2, glalie_up3, animate, 60);
               else 
                   sprite = glalie_down1;
                break;
            case 1:
                if(moving) 
                    sprite = Sprite.movingSprite(glalie_right1, glalie_right2, glalie_right3, animate, 60);
                else 
                    sprite = glalie_down1;
                break;
            case 2:
                if(moving)  
                    sprite = Sprite.movingSprite(glalie_down1, glalie_down2, glalie_down3, animate, 60);
                else
                    sprite = glalie_down1;
                break;
            case 3:
               if(moving)
                   sprite = Sprite.movingSprite(glalie_left1, glalie_left2, glalie_left3, animate, 60);
                else 
                   sprite = glalie_down1;
                break;
        }    
    }   
}
