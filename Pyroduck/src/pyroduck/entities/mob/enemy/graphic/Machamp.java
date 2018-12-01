package pyroduck.entities.mob.enemy.graphic;

import pyroduck.Board;
import pyroduck.Game;
import pyroduck.entities.mob.enemy.MediumPower;
import pyroduck.graphics.Sprite;

public class Machamp extends Enemy{
    
    public Machamp(int x, int y, Board board){
        super(x, y, board, Sprite.machamp_dead, Game.getPlayerSpeed() / 2, 200);
        sprite = Sprite.machamp_left1;	
        ep = new MediumPower(board.getPlayer(), this);
        direction = ep.calculateDirection();
    }
    
    @Override
    protected void chooseSprite() {
        switch(direction) {
            case 0:
                sprite = Sprite.movingSprite(Sprite.machamp_up1, Sprite.machamp_up2, Sprite.machamp_up3, animate, 60);
                break;
            case 1:
                sprite = Sprite.movingSprite(Sprite.machamp_right1, Sprite.machamp_right2, Sprite.machamp_right3, animate, 60);
                break;
            case 2:
                sprite = Sprite.movingSprite(Sprite.machamp_down1, Sprite.machamp_down2, Sprite.machamp_down3, animate, 60);
                break;
            case 3:
                sprite = Sprite.movingSprite(Sprite.machamp_left1, Sprite.machamp_left2, Sprite.machamp_left3, animate, 60);
                break;
        }    
    }   
}