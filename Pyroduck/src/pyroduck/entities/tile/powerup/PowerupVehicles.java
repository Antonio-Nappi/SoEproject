package pyroduck.entities.tile.powerup;

import java.util.logging.Level;
import java.util.logging.Logger;
import pyroduck.Game;
import pyroduck.exceptions.PyroduckException;
import pyroduck.graphics.Sprite;

/**
 *
 * @author 
 */
public class PowerupVehicles extends Powerup{

    public PowerupVehicles(int x, int y, Sprite sprite) {
        super(x, y, sprite);
    }

    @Override
    public void setValues() {
        try {
            Game.getInstance().setPlayerSpeed(1.3);
            Game.getInstance().setBombRadius(1);
            Game.getInstance().setBombRate(1);
        } catch (PyroduckException ex) {
            Logger.getLogger(PowerupVehicles.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
}