package pyroduck.entities.tile.powerup;

import pyroduck.Board;
import pyroduck.graphics.Sprite;

/**
 *
 * @author La Femina, Petruzzello
 */
public class PowerupLife extends Powerup {
    
    public PowerupLife(int x, int y, Sprite sprite) {
        super(x, y, sprite);
    }

    @Override
    public void setValues() {
      Board.getInstance().changeLives(1);
    }   
}