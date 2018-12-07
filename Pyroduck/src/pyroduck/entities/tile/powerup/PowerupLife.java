package pyroduck.entities.tile.powerup;

import pyroduck.Game;
import pyroduck.graphics.Sprite;

/**
 *
 * @author La Femina, Petruzzello
 */
public class PowerupLife extends Powerup {
    public static Sprite powerupLife = new Sprite(5, 4);
    
    public PowerupLife(int x, int y) {
        super(x, y, powerupLife);
    }

    @Override
    public void setValues() {
      active=true;
      Game.addLives(1);
    }   
}