package pyroduck.entities.tile.powerup;

import pyroduck.graphics.Sprite;

/**
 *
 * @author
 */
public class PowerupNotSlip extends Powerup {
    public static Sprite powerup_not_slip = new Sprite(5,5);

     public PowerupNotSlip(int x, int y) {
        super(x, y, powerup_not_slip);
    }

    @Override
    public void setValues() {}    
}