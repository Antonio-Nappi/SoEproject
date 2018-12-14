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
public class PowerupFlames extends Powerup {

    public PowerupFlames(int x, int y, Sprite sprite) {
        super(x, y, sprite);
    }
    
    @Override
    public void setValues() {
        try {
            active = true;
            if(Game.getInstance().getBombRadius()<= 2)
                Game.getInstance().addBombRadius(1);
        } catch (PyroduckException ex) {
            Logger.getLogger(PowerupFlames.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}