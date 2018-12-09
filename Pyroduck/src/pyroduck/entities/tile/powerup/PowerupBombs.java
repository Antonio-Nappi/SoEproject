package pyroduck.entities.tile.powerup;

import pyroduck.Game;
import pyroduck.graphics.Sprite;

/**
 *
 * @author La Femina, Petruzzello
 */
public class PowerupBombs extends Powerup {
    public static Sprite powerup_bombs = new Sprite(4, 2);

    public PowerupBombs(int x, int y) {
        super(x, y, powerup_bombs);
    }

    @Override
    public void setValues() {
        active = true;
        if(Game.getBombRate() <= 2)
            Game.addBombRate(1);
    }
}