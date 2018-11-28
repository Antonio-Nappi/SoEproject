package pyroduck.entities.mob.enemy.graphic;

import pyroduck.Board;
import pyroduck.Game;
import pyroduck.entities.mob.enemy.MediumPower;
import pyroduck.graphics.Sprite;

public class Glalie extends Enemy{
    
    public Glalie(int x, int y, Board board){
        super(x, y, board, Sprite.glalie_dead, Game.getPlayerSpeed(), 200);
        sprite = Sprite.glalie_left1;	
        ep = new MediumPower(board.getPlayer(), this);
        direction = ep.calculateDirection();
    }
    
    @Override
    protected void chooseSprite() {
        switch(direction) {
            case 0:
                sprite = Sprite.movingSprite(Sprite.glalie_up1, Sprite.glalie_up2, Sprite.glalie_up3, animate, 60);
                break;
            case 1:
                sprite = Sprite.movingSprite(Sprite.glalie_right1, Sprite.glalie_right2, Sprite.glalie_right3, animate, 60);
                break;
            case 2:
                sprite = Sprite.movingSprite(Sprite.glalie_down1, Sprite.glalie_down2, Sprite.glalie_down3, animate, 60);
                break;
            case 3:
                sprite = Sprite.movingSprite(Sprite.glalie_left1, Sprite.glalie_left2, Sprite.glalie_left3, animate, 60);
                break;
        }    
    }   
}