package pyroduck.entities.tile.powerup;

import pyroduck.Game;
import pyroduck.graphics.Sprite;

/**
 *
 * @author La Femina, Petruzzello
 */
public class PowerupSpeed extends Powerup {
public static Sprite powerupSpeed = new Sprite(5, 2);
    public PowerupSpeed(int x, int y) {
        super(x, y, powerupSpeed);
    }

    @Override
    public void setValues() {
        active = true;
        if(Game.getPlayerSpeed()<= 2.3)
            Game.addPlayerSpeed(0.7);
    }
}