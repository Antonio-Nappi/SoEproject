package pyroduck.entities.tile.destroyable;

import pyroduck.entities.Entity;
import pyroduck.entities.tile.Tile;
import pyroduck.graphics.Sprite;
import pyroduck.level.Coordinates;

public abstract class DestroyableIceTile extends Tile{
    protected ContextDestroyable context;
    protected boolean change;
    
    public DestroyableIceTile(int x, int y, Sprite sprite) {
        super(x, y, sprite);
        change = true;
    }

    public abstract void nextState(ContextDestroyable context);
    public abstract boolean getChange();
    public abstract void setChange(boolean change);
    
    @Override
    public boolean collide(Entity e) {
        double diffX = e.getX() - Coordinates.tileToPixel(getX());
        double diffY = e.getY() - Coordinates.tileToPixel(getY());
        if(!((diffX >= -26 && diffX < 30 && diffY >= 7 && diffY <= 47)))
            change = true;
        return false;
    }
}
