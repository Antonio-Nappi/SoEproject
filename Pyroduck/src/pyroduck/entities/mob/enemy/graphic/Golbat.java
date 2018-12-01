package pyroduck.entities.mob.enemy.graphic;

import pyroduck.Board;
import pyroduck.Game;
import pyroduck.entities.mob.enemy.LowPower;
import pyroduck.graphics.Sprite;

public class Golbat extends Enemy{

    public Golbat(int x, int y, Board board, int realWidth, int realHeight){
        super(x, y, board, Sprite.golbat_dead, Game.getPlayerSpeed() / 2, 100);
        this.realWidth = realWidth;
        this.realHeight = realHeight;
        sprite = Sprite.golbat_left1;	
        ep = new LowPower();
        direction = ep.calculateDirection();
    }
    
    @Override
    protected void chooseSprite() {
        switch(direction) {
            case 0:
                sprite = Sprite.movingSprite(Sprite.golbat_up1, Sprite.golbat_up2, Sprite.golbat_up3, animate, 60);
                break;
            case 1:
                sprite = Sprite.movingSprite(Sprite.golbat_right1, Sprite.golbat_right2, Sprite.golbat_right3, animate, 60);
                break;
            case 2:
                sprite = Sprite.movingSprite(Sprite.golbat_down1, Sprite.golbat_down2, Sprite.golbat_down3, animate, 60);
                break;
            case 3:
                sprite = Sprite.movingSprite(Sprite.golbat_left1, Sprite.golbat_left2, Sprite.golbat_left3, animate, 60);
                break;
        }    
    }   
}