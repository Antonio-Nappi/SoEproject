package pyroduck.entities.tile.destroyable;

import pyroduck.graphics.Sprite;

public class IntactState extends DestroyableIceTile {
    
    public IntactState(int x, int y, Sprite sprite) {
        super(x, y, sprite);
    }

   
    public DestroyableIceTile nextState(ContextDestroyable context){
        System.out.println("Chiamata di intact");
        DestroyableIceTile newState = new BreakingState((int)x, (int)y, Sprite.icebroken_2);
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
    
//    @Override
//    public boolean collide(Entity e) {
//        if(e instanceof BreakingState)
//            change=true;
//        return false;
//    }
}
