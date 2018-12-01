package pyroduck.entities.mob.enemy.graphic;

import pyroduck.Board;
import pyroduck.Game;
import pyroduck.entities.mob.enemy.MediumPower;
import pyroduck.graphics.Sprite;

public class Arbok extends Enemy{
        
    public Arbok(int x, int y, Board board, int realWidth, int realHeight){
        super(x, y, board, Sprite.arbok_dead, Game.getPlayerSpeed() - 0.1, 200);
        this.realWidth = realWidth;
        this.realHeight = realHeight;
        sprite = Sprite.arbok_left1;	
        ep = new MediumPower(board.getPlayer(), this);
        direction = ep.calculateDirection();
    }
    
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
