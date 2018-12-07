package pyroduck.entities.mob.enemy.graphic;

import pyroduck.Board;
import pyroduck.Game;
import pyroduck.entities.mob.enemy.MediumPower;
import pyroduck.graphics.Sprite;

/**
 * Implements the behavior, select the image and manage the animation of this enemy.
 * @author Bini, Petruzzello
 */
public class Darkrai extends Enemy{
    
    public int realWidth = 28, realHeight = 28;
    /**
     * Creates an instance of <b>Darkrai</b> enemy.
     * @param x horizontal coordinate in pixels.
     * @param y vertical coordinate in pixels. 
     */
    public Darkrai(int x, int y){
        super(x, y, Sprite.darkrai_dead, Game.getPlayerSpeed() - 0.1, 300);
        sprite = Sprite.darkrai_left1;	
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
                if(moving)sprite = Sprite.movingSprite(Sprite.darkrai_up1, Sprite.darkrai_up2, Sprite.darkrai_up3, animate, 60);
                else sprite = Sprite.darkrai_down1;
                break;
            case 1:
                if(moving)sprite = Sprite.movingSprite(Sprite.darkrai_right1, Sprite.darkrai_right2, Sprite.darkrai_right3, animate, 60);
                else sprite = Sprite.darkrai_down1;
                break;
            case 2:
                if(moving)sprite = Sprite.movingSprite(Sprite.darkrai_down1, Sprite.darkrai_down2, Sprite.darkrai_down3, animate, 60);
                else sprite = Sprite.darkrai_down1;
                break;
            case 3:
                if(moving)sprite = Sprite.movingSprite(Sprite.darkrai_left1, Sprite.darkrai_left2, Sprite.darkrai_left3, animate, 60);
                else sprite = Sprite.darkrai_down1;
                break;
        }    
    }  
}
