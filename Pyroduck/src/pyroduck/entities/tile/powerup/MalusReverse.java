package pyroduck.entities.tile.powerup;

import pyroduck.Game;
import pyroduck.graphics.Sprite;

/**
 *
 * @author La Femina, Petruzzello
 */
public class MalusReverse extends Powerup {
public static Sprite powerupReverse = new Sprite(4, 4);
    public MalusReverse(int x, int y) {
        super(x, y, powerupReverse);
    }

    @Override
    public void setValues() {
        Game.reverseInput(true);
    }
}