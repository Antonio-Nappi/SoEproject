package pyroduck.entities.tile.destroyable;

import pyroduck.graphics.Sprite;

/**
 *
 * @author Montefusco
 */
public class BreakingState extends DestroyableIceTile {
    
    public BreakingState(int x, int y, Sprite sprite) {
        super(x, y, sprite);
        this.timerBreak = 70;
    }

    @Override
    public DestroyableIceTile nextState(ContextDestroyable context){
        DestroyableIceTile newState = new DestroyedState((int)x, (int)y, Sprite.icebroken_3);
        context.setState(newState);
        return newState;
    }
}