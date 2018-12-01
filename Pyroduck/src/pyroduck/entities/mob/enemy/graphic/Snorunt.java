package pyroduck.entities.mob.enemy.graphic;

import pyroduck.Board;
import pyroduck.Game;
import pyroduck.entities.mob.enemy.LowPower;
import pyroduck.graphics.Sprite;

public class Snorunt extends Enemy{
    public Snorunt(int x, int y, Board board){
        super(x, y, board, Sprite.snorunt_dead, Game.getPlayerSpeed() / 2, 100);
        sprite = Sprite.snorunt_left1;	
        ep = new LowPower();
        direction = ep.calculateDirection();
    }
    
    @Override
    protected void chooseSprite() {
        switch(direction) {
            case 0:
                sprite = Sprite.movingSprite(Sprite.snorunt_up1, Sprite.snorunt_up2, Sprite.snorunt_up3, animate, 60);
                break;
            case 1:
                sprite = Sprite.movingSprite(Sprite.snorunt_right1, Sprite.snorunt_right2, Sprite.snorunt_right3, animate, 60);
                break;
            case 2:
                sprite = Sprite.movingSprite(Sprite.snorunt_down1, Sprite.snorunt_down2, Sprite.snorunt_down3, animate, 60);
                break;
            case 3:
                sprite = Sprite.movingSprite(Sprite.snorunt_left1, Sprite.snorunt_left2, Sprite.snorunt_left3, animate, 60);
                break;
        }    
    }   
}