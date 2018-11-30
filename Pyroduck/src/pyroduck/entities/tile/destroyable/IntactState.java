package pyroduck.entities.tile.destroyable;

import pyroduck.entities.Entity;
import pyroduck.graphics.Sprite;

public class IntactState extends DestroyableIceTile {
    
    public IntactState(int x, int y, Sprite sprite) {
        super(x, y, sprite);
    }

    @Override
    public void nextState(ContextDestroyable context){
        System.out.println("Chiamata di intact");
        context.setState(new BreakingState((int)x, (int)y, Sprite.icebroken_1));
    }

    @Override
    public boolean getChange() {
        return change;
    }
    
    @Override
    public void setChange(boolean change){
        this.change = change;
    }
    
//    @Override
//    public boolean collide(Entity e) {
//        if(e instanceof BreakingState)
//            change=true;
//        return false;
//    }
}
