package pyroduck.entities.tile.powerup;

import pyroduck.Game;
import pyroduck.graphics.Sprite;

/**
 *
 * @author La Femina, Petruzzello
 */
public class PowerupSpeed extends Powerup {

    public PowerupSpeed(int x, int y, Sprite sprite) {
        super(x, y, sprite);
    }

    @Override
    public void setValues() {
        if (Game.getInstance().getPlayerSpeed() <= 2.3) {
            Game.getInstance().addPlayerSpeed(0.7);
        }
    }
}