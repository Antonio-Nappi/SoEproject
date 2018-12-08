package pyroduck.entities.tile.destroyable;

import pyroduck.graphics.Sprite;

/**
 *
 * @author Montefusco
 */
public class DestroyedState extends DestroyableIceTile {
    public static Sprite icebroken_3 = new Sprite(14, 0);

    public DestroyedState(int x, int y) {
        super(x, y, icebroken_3);
        this.timerBreak = 70;
    }

    @Override
    public DestroyableIceTile nextState(ContextDestroyable context){
        DestroyableIceTile newState = new WaterState((int)x, (int)y);
        context.setState(newState);
        return newState;
    }
}