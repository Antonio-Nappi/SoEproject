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
    /**
     * Creates an instance of <b>Machamp</b> enemy.
     * @param x horizontal coordinate in pixels.
     * @param y vertical coordinate in pixels.
     * @param board 
     */
    public Machamp(int x, int y, Board board){
        super(x, y, board, Sprite.machamp_dead, Game.getPlayerSpeed() / 2, 200);
        sprite = Sprite.machamp_left1;	
        ep = new MediumPower(board.getPlayer(), this);
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
                sprite = Sprite.movingSprite(Sprite.machamp_up1, Sprite.machamp_up2, Sprite.machamp_up3, animate, 60);
                else sprite = Sprite.machamp_down1;
                break;
            case 1:
                 if(moving)
                sprite = Sprite.movingSprite(Sprite.machamp_right1, Sprite.machamp_right2, Sprite.machamp_right3, animate, 60);
                 else sprite = Sprite.machamp_down1;
                break;
            case 2:
                 if(moving)
                sprite = Sprite.movingSprite(Sprite.machamp_down1, Sprite.machamp_down2, Sprite.machamp_down3, animate, 60);
                 else sprite = Sprite.machamp_down1;
                break;
            case 3:
                if(moving)
                sprite = Sprite.movingSprite(Sprite.machamp_left1, Sprite.machamp_left2, Sprite.machamp_left3, animate, 60);
                else sprite = Sprite.machamp_down1;
                break;
        }    
    }   
}
