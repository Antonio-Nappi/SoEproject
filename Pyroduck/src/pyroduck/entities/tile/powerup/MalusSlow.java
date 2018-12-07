package pyroduck.entities.tile.powerup;

import pyroduck.Game;
import pyroduck.bomb.DirectionalExplosion;
import pyroduck.entities.Entity;
import pyroduck.entities.mob.Player;
import pyroduck.entities.mob.enemy.graphic.Enemy;
import pyroduck.graphics.Sprite;

/**
 *
 * @author La Femina, Petruzzello
 */
public class MalusSlow extends Powerup {
    public static Sprite powerupSlow = new Sprite(3, 0);

    public MalusSlow(int x, int y) {
        super(x, y, powerupSlow);
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
        if(e instanceof Enemy){
            return true;
        }
        return false;
    }

    @Override
    public void setValues() {
        active = true;
        if(Game.getPlayerSpeed() >= 1.3)
            Game.decreasePlayerSpeed(0.3);
    }
}