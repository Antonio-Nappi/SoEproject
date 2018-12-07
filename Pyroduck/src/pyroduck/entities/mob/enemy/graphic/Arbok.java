package pyroduck.entities.mob.enemy.graphic;

import pyroduck.Board;
import pyroduck.Game;
import pyroduck.entities.mob.enemy.MediumPower;
import pyroduck.graphics.Sprite;

/**
 * Implements the behavior, select the image and manage the animation of this enemy.
 * @author Bini, Petruzzello
 */
public class Arbok extends Enemy{
    
    public int realWidth = 28, realHeight = 28;
    /**
     * Creates an instance of <b>Arbok</b> enemy.
     * @param x horizontal coordinate in pixels.
     * @param y vertical coordinate in pixels.
     */
    public Arbok(int x, int y){
        super(x, y, Sprite.arbok_dead, Game.getPlayerSpeed() - 0.1, 300);
        sprite = Sprite.arbok_left1;	
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
                if(moving) sprite = Sprite.movingSprite(Sprite.arbok_up1, Sprite.arbok_up2, Sprite.arbok_up3, animate, 60);
                else sprite= Sprite.arbok_down1;
                break;
            case 1:
                if(moving) sprite = Sprite.movingSprite(Sprite.arbok_right1, Sprite.arbok_right2, Sprite.arbok_right3, animate, 60);
                else sprite= Sprite.arbok_down1;
                break;
            case 2:
                if(moving) sprite = Sprite.movingSprite(Sprite.arbok_down1, Sprite.arbok_down2, Sprite.arbok_down3, animate, 60);
                else sprite= Sprite.arbok_down1;

                break;
            case 3:
               if(moving) sprite = Sprite.movingSprite(Sprite.arbok_left1, Sprite.arbok_left2, Sprite.arbok_left3, animate, 60);
                else sprite= Sprite.arbok_down1;
                break;
        }    
    }
}
