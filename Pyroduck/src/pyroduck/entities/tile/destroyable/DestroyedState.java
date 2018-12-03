package pyroduck.entities.tile.destroyable;

import pyroduck.entities.Entity;
import pyroduck.entities.mob.Player;
import pyroduck.graphics.Sprite;


public class DestroyedState extends DestroyableIceTile {

    public DestroyedState(int x, int y, Sprite sprite ) {
        super(x, y, sprite);
    }

    @Override
    public void nextState(ContextDestroyable context){
        System.out.println("Chiamata di destroyed");
        context.setState(new WaterState((int)x, (int)y, Sprite.icebroken_3));
    }
    
    @Override
    public boolean getChange() {
        return change;
    }
    
    @Override
    public void setChange(boolean change){
        this.change = change;
    }
    
    @Override
    public boolean collide(Entity e){
        if(e instanceof Player)
           ((Player) e).kill();
        return false;
    } 

    
//    @Override
//    public boolean collide(Entity e) {
//        if(e instanceof WaterState)
//            change=true;
//        return false;
//    }
}
