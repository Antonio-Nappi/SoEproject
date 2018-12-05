package pyroduck.entities.tile.destroyable;

import pyroduck.graphics.Sprite;

/**
 *
 * @author Montefusco
 */
public class IntactState extends DestroyableIceTile {
    
    public IntactState(int x, int y, Sprite sprite) {
        super(x, y, sprite);
    }


    @Override
    public DestroyableIceTile nextState(ContextDestroyable context){
        DestroyableIceTile newState = new BreakingState((int)x, (int)y, Sprite.icebroken_2);
        context.setState(newState);
        return newState;
    }

}
