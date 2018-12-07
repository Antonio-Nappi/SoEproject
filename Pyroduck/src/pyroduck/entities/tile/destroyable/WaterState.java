package pyroduck.entities.tile.destroyable;

import pyroduck.entities.Entity;
import pyroduck.entities.mob.Player;
import pyroduck.graphics.Sprite;

/**
 *
 * @author Montefusco
 */
public class WaterState extends DestroyableIceTile{
    public static Sprite icebroken_4 = new Sprite(15, 0);

    public WaterState(int x, int y) {
        super(x, y, icebroken_4);
    }

    @Override
    public boolean collide(Entity e){
        if(e instanceof Player){
               ((Player) e).kill();
        }
        return false;
    }

    @Override
    public DestroyableIceTile nextState(ContextDestroyable context){
        return this;
    } 
}