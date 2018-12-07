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
public class Darkrai extends Enemy{
    
    public int realWidth = 28, realHeight = 28;
       public static Sprite darkrai_up1 = new Sprite(12, 8);
    public static Sprite darkrai_up2 = new Sprite(13, 8);
    public static Sprite darkrai_up3 = new Sprite(14, 8);
    
    public static Sprite darkrai_down1 = new Sprite(12, 11);
    public static Sprite darkrai_down2 = new Sprite(13, 11);
    public static Sprite darkrai_down3 = new Sprite(14, 11);
    
    public static Sprite darkrai_left1 = new Sprite(12, 10);
    public static Sprite darkrai_left2 = new Sprite(13, 10);
    public static Sprite darkrai_left3 = new Sprite(14, 10);

    public static Sprite darkrai_right1 = new Sprite(12, 9);
    public static Sprite darkrai_right2 = new Sprite(13, 9);
    public static Sprite darkrai_right3 = new Sprite(14, 9);

    public static Sprite darkrai_dead = new Sprite(13, 2);
    /**
     * Creates an instance of <b>Darkrai</b> enemy.
     * @param x horizontal coordinate in pixels.
     * @param y vertical coordinate in pixels. 
     */
    public Darkrai(int x, int y){
        super(x, y, darkrai_dead, Game.getPlayerSpeed() - 0.1, 300);
        sprite = darkrai_left1;	
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
                    sprite = Sprite.movingSprite(darkrai_up1, darkrai_up2, darkrai_up3, animate, 60);
                else 
                    sprite = darkrai_down1;
                break;
            case 1:
                if(moving)
                    sprite = Sprite.movingSprite(darkrai_right1, darkrai_right2, darkrai_right3, animate, 60);
                else 
                    sprite = darkrai_down1;
                break;
            case 2:
                if(moving)
                    sprite = Sprite.movingSprite(darkrai_down1, darkrai_down2, darkrai_down3, animate, 60);
                else 
                    sprite = darkrai_down1;
                break;
            case 3:
                if(moving)
                    sprite = Sprite.movingSprite(darkrai_left1, darkrai_left2, darkrai_left3, animate, 60);
                else 
                    sprite = darkrai_down1;
                break;
        }    
    }  
}
