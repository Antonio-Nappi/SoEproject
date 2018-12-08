package pyroduck.entities.tile.powerup;

import pyroduck.Game;
import pyroduck.graphics.Sprite;

/**
 *
 * @author 
 */
public class PowerupVehicles extends Powerup{
    public static Sprite powerup_articuno = new Sprite(3, 5);

    public PowerupVehicles(int x, int y) {
        super(x, y, powerup_articuno);
    }

    @Override
    public void setValues() {
        Game.setPlayerSpeed(1.3);
        Game.setBombRadius(1);
        Game.setBombRate(1);
    }   
}