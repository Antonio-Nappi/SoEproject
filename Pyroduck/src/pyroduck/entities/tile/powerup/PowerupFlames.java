package pyroduck.entities.tile.powerup;

import pyroduck.Game;
import pyroduck.graphics.Sprite;

/**
 *
 * @author La Femina, Petruzzello
 */
public class PowerupFlames extends Powerup {

    public PowerupFlames(int x, int y, Sprite sprite) {
        super(x, y, sprite);
    }

    @Override
    public void setValues() {
        if (Game.getInstance().getBombRadius() <= 2) {
            Game.getInstance().addBombRadius(1);
        }
    }
}
