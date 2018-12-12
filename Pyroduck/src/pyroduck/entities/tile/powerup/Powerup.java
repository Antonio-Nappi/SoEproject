package pyroduck.entities.tile.powerup;

import pyroduck.bomb.Bomb;
import pyroduck.bomb.DirectionalExplosion;
import pyroduck.entities.Entity;
import pyroduck.entities.mob.Mob;
import pyroduck.entities.mob.Player;
import pyroduck.entities.tile.destroyable.DestroyableTile;
import pyroduck.graphics.Sprite;
import pyroduck.bomb.Missile;

/**
 *
 * @author La Femina, Petruzzello
 */
public abstract class Powerup extends DestroyableTile {

    protected boolean active = false;
    

    public Powerup(int x, int y, Sprite sprite) {
        super(x, y, sprite);
    }

    public abstract void setValues();

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
    @Override
    public boolean collide(Entity e) {
        if(e.isExplosion() || (e.isBomb() && (((Bomb)e).isMissile())))
            destroyed = true;
        if(e.isMob() && (((Mob)e).isPlayer())) {
            ((Player) e).addPowerup(this);
            remove();
            return true;
        }
        return false;
    }
}