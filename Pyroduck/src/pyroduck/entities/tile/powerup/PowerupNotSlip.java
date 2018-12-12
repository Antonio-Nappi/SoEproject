package pyroduck.entities.tile.powerup;

import pyroduck.Board;
import pyroduck.graphics.Sprite;

/**
 *
 * @author
 */
public class PowerupNotSlip extends Powerup {

     public PowerupNotSlip(int x, int y, Sprite sprite) {
        super(x, y, sprite);
    }

    @Override
    public void setValues() {
        Board.getInstance().setInput();
        Board.getInstance().getPlayer().setInput(Board.getInstance().getInput());
    }    
}