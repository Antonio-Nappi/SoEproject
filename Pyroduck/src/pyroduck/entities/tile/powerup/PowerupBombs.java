package pyroduck.entities.tile.powerup;

import pyroduck.Game;
import pyroduck.bomb.DirectionalExplosion;
import pyroduck.entities.Entity;
import pyroduck.entities.mob.Player;
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
        active = true;
        if(Game.getBombRate() <= 2)
            Game.addBombRate(1);
    }
}