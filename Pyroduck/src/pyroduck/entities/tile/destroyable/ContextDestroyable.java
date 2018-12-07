package pyroduck.entities.tile.destroyable;

/**
 *
 * @author Montefusco
 */
public class ContextDestroyable {
    
    private DestroyableIceTile state;

    public ContextDestroyable() {
        this.state = null;
    }

    public DestroyableIceTile getState() {
        return state;
    }
    
    public void setState(DestroyableIceTile state){
        this.state = state; 
    }
    
    public void nextState(){
        this.state.nextState(this);
    }
}