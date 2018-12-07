package pyroduck.entities.mob.enemy.graphic;

import pyroduck.Game;
import pyroduck.entities.mob.enemy.LowPower;
import pyroduck.graphics.Sprite;

/**
 * Implements the behavior, select the image and manage the animation of this enemy.
 * @author Bini, Petruzzello
 */
public class Snorunt extends Enemy{
    
    public int realWidth = 28, realHeight = 28;
    /**
     * Creates an instance of <b>Snorunt</b> enemy.
     * @param x horizontal coordinate in pixels.
     * @param y vertical coordinate in pixels.
     */
    public Snorunt(int x, int y){
        super(x, y, Sprite.snorunt_dead, Game.getPlayerSpeed() / 2, 100);
        sprite = Sprite.snorunt_left1;	
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
                    sprite = Sprite.movingSprite(Sprite.snorunt_up1, Sprite.snorunt_up2, Sprite.snorunt_up3, animate, 60);
                else
                    sprite = Sprite.snorunt_down1;
                break;
            case 1:
                if(moving)
                    sprite = Sprite.movingSprite(Sprite.snorunt_right1, Sprite.snorunt_right2, Sprite.snorunt_right3, animate, 60);
                else
                    sprite = Sprite.snorunt_down1;
                break;
            case 2:
                if(moving)
                    sprite = Sprite.movingSprite(Sprite.snorunt_down1, Sprite.snorunt_down2, Sprite.snorunt_down3, animate, 60);
                else
                    sprite = Sprite.snorunt_down1;
                break;
            case 3:
                if(moving)
                    sprite = Sprite.movingSprite(Sprite.snorunt_left1, Sprite.snorunt_left2, Sprite.snorunt_left3, animate, 60);
                else
                    sprite = Sprite.snorunt_down1;
                break;
        }    
    }   
}