package pyroduck.entities.tile.destroyable;

import pyroduck.graphics.Sprite;

/**
 *
 * @author Montefusco
 */
public class BreakingState extends DestroyableIceTile {
    public static Sprite icebroken_2 = new Sprite(13, 0);
    
    public BreakingState(int x, int y) {
        super(x, y, icebroken_2);
        this.timerBreak = 70;
    }

    @Override
    public DestroyableIceTile nextState(ContextDestroyable context){
        DestroyableIceTile newState = new DestroyedState((int)x, (int)y);
        context.setState(newState);
        return newState;
    }
}