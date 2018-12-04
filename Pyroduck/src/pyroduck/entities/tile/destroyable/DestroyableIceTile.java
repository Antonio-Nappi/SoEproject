package pyroduck.entities.tile.destroyable;

import pyroduck.entities.Entity;
import pyroduck.entities.tile.Tile;
import pyroduck.graphics.Sprite;
import pyroduck.level.Coordinates;

public abstract class DestroyableIceTile extends Tile{
    protected ContextDestroyable context;
    protected boolean change;
    protected int timerBreak;
    
    public DestroyableIceTile(int x, int y, Sprite sprite) {
        super(x, y, sprite);
        this.realWidth = 40;
        this.realHeight = 40;
        change = true;
        timerBreak = 0;
    }

    public abstract DestroyableIceTile nextState(ContextDestroyable context);
    public abstract boolean getChange();
    public abstract void setChange(boolean change);
    
    @Override
    public boolean collide(Entity e) {
        //double diffX = e.getX() - Coordinates.tileToPixel(getX());
        //double diffY = e.getY() - Coordinates.tileToPixel(getY());
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
