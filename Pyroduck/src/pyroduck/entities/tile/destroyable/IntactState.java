package pyroduck.entities.tile.destroyable;

import pyroduck.entities.Entity;
import pyroduck.entities.mob.Player;
import pyroduck.graphics.Sprite;

public class IntactState extends DestroyableIceTile {

    public IntactState(int x, int y, Sprite sprite) {
        super(x, y, sprite);
    }

    @Override
    public boolean collide(Entity e){   
        if(e instanceof Player){
            System.out.println("Collisione intact");
            return false;
        }
        return false;
    }

    @Override
    public void nextState(ContextDestroyable context){
        System.out.println("Chiamata di intact");
        context.setState(new BreakingState((int)x, (int)y, Sprite.icebroken_1));
    }
}
