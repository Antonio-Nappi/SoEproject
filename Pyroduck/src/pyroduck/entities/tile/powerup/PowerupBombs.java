package pyroduck.entities.tile.powerup;

import java.util.logging.Level;
import java.util.logging.Logger;
import pyroduck.Game;
import pyroduck.exceptions.PyroduckException;
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
        try {
            if(Game.getInstance().getBombRate() <= 2)
                Game.getInstance().addBombRate(1);
        } catch (PyroduckException ex) {
            Logger.getLogger(PowerupBombs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}