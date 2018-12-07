package pyroduck.entities.tile.destroyable;

import pyroduck.graphics.Sprite;

/**
 *
 * @author Montefusco
 */
public class IntactState extends DestroyableIceTile {
        public static Sprite icebroken_1 = new Sprite(12, 0);
    
    public IntactState(int x, int y) {
        super(x, y, icebroken_1);
    }


    @Override
    public DestroyableIceTile nextState(ContextDestroyable context){
        DestroyableIceTile newState = new BreakingState((int)x, (int)y);
        context.setState(newState);
        return newState;
    }
}