package pyroduck.entities.tile.powerup;

import pyroduck.Game;
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
        Game.setPlayerSpeed(1.3);
        Game.setBombRadius(1);
        Game.setBombRate(1);
    }   
}