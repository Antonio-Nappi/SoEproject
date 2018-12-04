package pyroduck.entities.tile.destroyable;

import pyroduck.entities.Entity;
import pyroduck.entities.mob.Player;
import pyroduck.graphics.Sprite;


public class DestroyedState extends DestroyableIceTile {

    public DestroyedState(int x, int y, Sprite sprite) {
        super(x, y, sprite);
        this.timerBreak = 70;
    }

    @Override
    public DestroyableIceTile nextState(ContextDestroyable context){
        System.out.println("Chiamata di destroyed");
        DestroyableIceTile newState = new WaterState((int)x, (int)y, Sprite.icebroken_4);
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
