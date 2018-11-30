package pyroduck.entities.tile.destroyable;

import pyroduck.entities.tile.Tile;
import pyroduck.graphics.Sprite;

public abstract class DestroyableIceTile extends Tile{
    protected ContextDestroyable context;
    
    public DestroyableIceTile(int x, int y, Sprite sprite) {
        super(x, y, sprite);
    }
    
    public abstract void nextState(ContextDestroyable context);
    
}
