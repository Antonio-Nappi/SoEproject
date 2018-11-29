/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyroduck.entities.tile.destroyable;

import pyroduck.entities.Entity;
import pyroduck.entities.mob.Player;
import pyroduck.graphics.Sprite;

/**
 *
 * @author Alex
 */
public class BreakingState extends DestroyableIceTile {
    
    public BreakingState(int x, int y, Sprite sprite ) {
        super(x, y, sprite);
    }
        
    @Override
    public boolean collide(Entity e){
        System.out.println("rotto");
        if(e instanceof Player)
            context.setState(new DestroyedState((int) x,(int) y , Sprite.icebroken_3,context));
        return false;
    }
}
