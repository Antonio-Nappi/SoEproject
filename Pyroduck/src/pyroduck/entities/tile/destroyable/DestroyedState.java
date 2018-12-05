package pyroduck.entities.tile.destroyable;

import pyroduck.graphics.Sprite;

/**
 *
 * @author Montefusco
 */
public class DestroyedState extends DestroyableIceTile {

    public DestroyedState(int x, int y, Sprite sprite) {
        super(x, y, sprite);
        this.timerBreak = 70;
    }

    @Override
    public DestroyableIceTile nextState(ContextDestroyable context){
        DestroyableIceTile newState = new WaterState((int)x, (int)y, Sprite.icebroken_4);
        context.setState(newState);
        return newState;
    }
  
}
