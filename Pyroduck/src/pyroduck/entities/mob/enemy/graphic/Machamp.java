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
    
    /**
     * Creates an instance of <b>Machamp</b> enemy.
     * @param x horizontal coordinate of this instance.
     * @param y vertical coordinate of this instance.
     * @param board 
     * @param realWidth real width of this enemy.
     * @param realHeight real height of this enemy.
     */
    public Machamp(int x, int y, Board board, int realWidth, int realHeight){
        super(x, y, board, Sprite.machamp_dead, Game.getPlayerSpeed() / 2, 200);
        this.realWidth = realWidth;
        this.realHeight = realHeight;
        sprite = Sprite.machamp_left1;	
        ep = new MediumPower(board.getPlayer(), this);
        direction = ep.calculateDirection();
    }
    
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
