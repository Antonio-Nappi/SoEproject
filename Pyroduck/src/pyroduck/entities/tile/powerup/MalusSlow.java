package pyroduck.entities.tile.powerup;

import pyroduck.Game;
import pyroduck.bomb.DirectionalExplosion;
import pyroduck.entities.Entity;
import pyroduck.entities.mob.Mob;
import pyroduck.entities.mob.Player;
import pyroduck.entities.mob.enemy.graphic.Enemy;
import pyroduck.graphics.Sprite;

/**
 *
 * @author La Femina, Petruzzello
 */
public class MalusSlow extends Powerup {

    public MalusSlow(int x, int y, Sprite sprite) {
        super(x, y, sprite);
    }

    @Override
    public boolean collide(Entity e) {
        if(e.isExplosion())
            destroyed = true;
        if(e.isMob() && (((Mob)e).isPlayer())) {
            ((Player) e).addPowerup(this);
            remove();
            return true;
        }
        if(e.isMob() && !(((Mob)e).isPlayer())){
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