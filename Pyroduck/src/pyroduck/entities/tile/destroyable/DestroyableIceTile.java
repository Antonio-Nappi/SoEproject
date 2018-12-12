package pyroduck.entities.tile.destroyable;

import pyroduck.entities.Entity;
import pyroduck.entities.tile.Tile;
import pyroduck.graphics.Sprite;

/**
 *
 * @author Montefusco
 */
public abstract class DestroyableIceTile extends Tile{
    protected ContextDestroyable context;
    protected int timerBreak;
    
    public DestroyableIceTile(int x, int y, Sprite sprite) {
        super(x, y, sprite);
        this.realWidth = 32;
        this.realHeight = 32;
        timerBreak = 0;
    }

    public abstract DestroyableIceTile nextState(ContextDestroyable context);
    
    @Override
    public boolean collide(Entity e) {
        return false;
    }
    
    public int getTimerBreak(){
        return timerBreak;
    }
    
    public void decreaseTimerBreak(){
        this.timerBreak = this.timerBreak--;
    }
    
    public void setTimerBreak(int timerBreak){
        this.timerBreak = timerBreak;
    }
    
    @Override
    public boolean isDestroyableIceTile(){
        return true;
    }
}