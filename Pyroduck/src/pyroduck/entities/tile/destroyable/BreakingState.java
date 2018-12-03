package pyroduck.entities.tile.destroyable;

import pyroduck.graphics.Sprite;


public class BreakingState extends DestroyableIceTile {
    
    public BreakingState(int x, int y, Sprite sprite) {
        super(x, y, sprite);
        change = true;
    }

    @Override
    public void nextState(ContextDestroyable context){
        System.out.println("Chiamata di breaking");
        context.setState(new DestroyedState((int)x, (int)y, Sprite.icebroken_2));
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
//        if(e instanceof DestroyedState)
//            change=true;
//        return false;
//    }
}
