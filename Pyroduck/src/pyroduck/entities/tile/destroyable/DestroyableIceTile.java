package pyroduck.entities.tile.destroyable;

import pyroduck.entities.Entity;
import pyroduck.entities.tile.Tile;
import pyroduck.graphics.Sprite;

public abstract class DestroyableIceTile extends Tile{
    protected ContextDestroyable context;
    protected boolean change;
    protected int timerBreak;
    
    public DestroyableIceTile(int x, int y, Sprite sprite) {
        super(x, y, sprite);
        this.realWidth = 32;
        this.realHeight = 32;
        change = true;
        timerBreak = 0;
    }

    public abstract DestroyableIceTile nextState(ContextDestroyable context);
    public abstract boolean getChange();
    public abstract void setChange(boolean change);
    
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
}
