package pyroduck.entities.tile.destroyable;

import pyroduck.graphics.Sprite;

/**
 *
 * @author 
 */
public class WaterState extends DestroyableIceTile{

    public WaterState(int x, int y, Sprite sprite) {
        super(x, y, sprite);
    }
       
    @Override
    public boolean collide(Entity e){
        if(e instanceof Player)
           ;//((Player) e).kill();
        return false;
    } 

    @Override
    public void nextState(ContextDestroyable context){
        context.setState(new IntactState((int)x, (int)y, Sprite.icebroken_4));
    }
    
    @Override
    public boolean getChange() {
        return change;
    }
    
    @Override
    public void setChange(boolean change){
        this.change = change;
    }
}
