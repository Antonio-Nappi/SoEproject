package pyroduck.entities.tile.powerup;

import pyroduck.Game;
import pyroduck.graphics.Sprite;

/**
 *
 * @author La Femina, Petruzzello
 */
public class PowerupFlames extends Powerup {
    public static Sprite powerup_flames = new Sprite(4, 3);

    public PowerupFlames(int x, int y) {
        super(x, y, powerup_flames);
    }
    
    @Override
    public void setValues() {
        active = true;
        if(Game.getBombRadius()<= 2)
            Game.addBombRadius(1);
    }
}