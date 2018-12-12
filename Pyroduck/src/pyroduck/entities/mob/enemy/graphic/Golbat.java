package pyroduck.entities.mob.enemy.graphic;

import pyroduck.entities.mob.enemy.LowPower;
import pyroduck.graphics.Sprite;

/**
 * Implements the behavior, select the image and manage the animation of this enemy.
 * @author Bini, Petruzzello
 */
public class Golbat extends Enemy{

    public int realWidth = 26, realHeight = 26;
    /**
     * Creates an instance of <b>Golbat</b> enemy.
     * @param x horizontal coordinate in pixels.
     * @param y vertical coordinate in pixels.
     */
    public Golbat(int x, int y){
        super(x, y, Sprite.golbat_dead, 0.8, 100);
        sprite = Sprite.golbat_left1;	
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
                    sprite = Sprite.movingSprite(Sprite.golbat_up1, Sprite.golbat_up2, Sprite.golbat_up3, animate, 60);
                else
                    sprite = Sprite.golbat_down1;
                break;
            case 1:
                if (moving)
                    sprite = Sprite.movingSprite(Sprite.golbat_right1, Sprite.golbat_right2, Sprite.golbat_right3, animate, 60);
                else
                    sprite = Sprite.golbat_down1;
                break;
            case 2:
                if (moving)
                    sprite = Sprite.movingSprite(Sprite.golbat_down1, Sprite.golbat_down2, Sprite.golbat_down3, animate, 60);
                else
                    sprite = Sprite.golbat_down1;
                break;
            case 3:
                if (moving)
                    sprite = Sprite.movingSprite(Sprite.golbat_left1, Sprite.golbat_left2, Sprite.golbat_left3, animate, 60);
                else
                    sprite = Sprite.golbat_down1;
                break;
        }    
    }   
}