package pyroduck.entities.mob.enemy.graphic;

import pyroduck.Board;
import pyroduck.Game;
import pyroduck.entities.mob.enemy.MediumPower;
import pyroduck.graphics.Sprite;

/**
 * Implements the behavior, select the image and manage the animation of this enemy.
 * @author Bini, Petruzzello
 */
public class Glalie extends Enemy{
    
    public Glalie(int x, int y, Board board, int realWidth, int realHeight){
        super(x, y, board, Sprite.glalie_dead, Game.getPlayerSpeed() / 2, 200);
        this.realWidth = realWidth;
        this.realHeight = this.realHeight;
        sprite = Sprite.glalie_left1;	
        ep = new MediumPower(board.getPlayer(), this);
        direction = ep.calculateDirection();
    }
    
    @Override
    protected void chooseSprite() {
        switch(direction) {
            case 0:
               if(moving) sprite = Sprite.movingSprite(Sprite.glalie_up1, Sprite.glalie_up2, Sprite.glalie_up3, animate, 60);
               else sprite = Sprite.glalie_down1;
                break;
            case 1:
                if(moving) sprite = Sprite.movingSprite(Sprite.glalie_right1, Sprite.glalie_right2, Sprite.glalie_right3, animate, 60);
                else sprite = Sprite.glalie_down1;
                break;
            case 2:
              if(moving)  sprite = Sprite.movingSprite(Sprite.glalie_down1, Sprite.glalie_down2, Sprite.glalie_down3, animate, 60);
                else sprite = Sprite.glalie_down1;
                break;
            case 3:
               if(moving) sprite = Sprite.movingSprite(Sprite.glalie_left1, Sprite.glalie_left2, Sprite.glalie_left3, animate, 60);
                else sprite = Sprite.glalie_down1;
                break;
        }    
    }   
}
