package pyroduck.entities.tile.powerup;

import java.util.logging.*;
import pyroduck.Game;
import pyroduck.exceptions.PyroduckException;
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
        try {
            active = true;
            if(Game.getInstance().getPlayerSpeed()<= 2.3)
                Game.getInstance().addPlayerSpeed(0.7);
        } catch (PyroduckException ex) {
            Logger.getLogger(PowerupSpeed.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}