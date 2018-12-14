package pyroduck.entities.tile.powerup;

import java.util.logging.Level;
import java.util.logging.Logger;
import pyroduck.Game;
import pyroduck.bomb.Bomb;
import pyroduck.entities.Entity;
import pyroduck.entities.mob.Mob;
import pyroduck.entities.mob.Player;
import pyroduck.exceptions.PyroduckException;
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
        if(e.isExplosion()){
            destroyed = true;
            return true;
        }
        if(e.isMob() && (((Mob)e).isPlayer())) {
            ((Player) e).addPowerup(this);
            remove();
            return true;
        }
        if(e.isMob() && !(((Mob)e).isPlayer())){
            return true;
        }
        if(e.isBomb() && ((Bomb) e).isMissile()){
            destroyed = true;
            return true;
        }
        return false;
    }

    @Override
    public void setValues() {
        try {
            active = true;
            if(Game.getInstance().getPlayerSpeed() >= 1.3)
                Game.getInstance().decreasePlayerSpeed(0.3);
        } catch (PyroduckException ex) {
            Logger.getLogger(MalusSlow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}