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
public class MalusReverse extends Powerup {

    public MalusReverse(int x, int y, Sprite sprite) {
        super(x, y, sprite);
    }

    @Override
    public void setValues() {
        try {
            Game.getInstance().reverseInput(true);
        } catch (PyroduckException ex) {
            Logger.getLogger(MalusReverse.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}