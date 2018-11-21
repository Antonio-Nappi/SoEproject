package pyroduck.entities.tile.powerup;

import pyroduck.Game;
import pyroduck.bomb.DirectionalExplosion;
import pyroduck.entities.Entity;
import pyroduck.entities.mob.Player;
import pyroduck.graphics.Sprite;

/**
 *
 * @author La Femina, Petruzzello
 */
public class PowerupSpeed extends Powerup {

    public PowerupSpeed(int x, int y, Sprite sprite) {
        super(x, y, sprite);
    }

    @Override
    public boolean collide(Entity e) {
        if(e instanceof DirectionalExplosion)
            destroyed = true;
        if(e instanceof Player) {
            ((Player) e).addPowerup(this);
            remove();
            return true;
        }

        return false;
    }

    @Override
    public void setValues() {
        active = true;
        Game.addPlayerSpeed(1.0);
    }
}