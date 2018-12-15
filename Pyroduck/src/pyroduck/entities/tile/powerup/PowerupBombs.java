package pyroduck.entities.tile.powerup;

import pyroduck.Game;
import pyroduck.graphics.Sprite;

/**
 *
 * @author La Femina, Petruzzello
 */
public class PowerupBombs extends Powerup {

    public PowerupBombs(int x, int y, Sprite sprite) {
        super(x, y, sprite);
    }

    @Override
    public void setValues() {
        if (Game.getInstance().getBombRate() <= 2) {
            Game.getInstance().addBombRate(1);
        }
    }
}
