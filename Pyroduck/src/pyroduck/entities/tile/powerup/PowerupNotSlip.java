package pyroduck.entities.tile.powerup;

import pyroduck.graphics.Sprite;

/**
 *
 * @author
 */
public class PowerupNotSlip extends Powerup {
        public static Sprite powerupNotSlip = new Sprite(5,5);

     public PowerupNotSlip(int x, int y) {
        super(x, y, powerupNotSlip);
    }

    @Override
    public void setValues() {}    
}