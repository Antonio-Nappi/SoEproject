package pyroduck.entities.tile.destroyable;

import pyroduck.entities.Entity;
import pyroduck.entities.mob.Player;
import pyroduck.graphics.Sprite;


public class BreakingState extends DestroyableIceTile {
    
    public BreakingState(int x, int y, Sprite sprite) {
        super(x, y, sprite);
    }
        
    @Override
    public boolean collide(Entity e){
        if(e instanceof Player){
            System.out.println("Collisione breaking");
            return false;
        }
        return false;
    }

    @Override
    public void nextState(ContextDestroyable context){
        System.out.println("Chiamata di breaking");
        context.setState(new DestroyedState((int)x, (int)y, Sprite.icebroken_2));
    }
}
