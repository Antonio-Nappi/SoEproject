package pyroduck.entities.tile.destroyable;

import pyroduck.graphics.Sprite;


public class BreakingState extends DestroyableIceTile {
    
    public BreakingState(int x, int y, Sprite sprite) {
        super(x, y, sprite);
        this.timerBreak = 70;
        change = true;
    }

    @Override
    public DestroyableIceTile nextState(ContextDestroyable context){
        DestroyableIceTile newState = new DestroyedState((int)x, (int)y, Sprite.icebroken_3);
        context.setState(newState);
        return newState;
    }
    
    @Override
    public boolean getChange() {
        return change;
    }
    
    @Override
    public void setChange(boolean change){
        this.change = change;
    }

}
