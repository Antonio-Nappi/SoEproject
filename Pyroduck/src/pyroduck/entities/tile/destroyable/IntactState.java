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
public class IntactState extends DestroyableIceTile {

    public IntactState(int x, int y, Sprite sprite,ContextDestroyable contextDestroyable) {
        super(x, y, sprite, contextDestroyable);
    }

    @Override
    public boolean collide(Entity e){   
        if(e instanceof Player){
            context.setState(new BreakingState((int)x, (int)y, Sprite.icebroken_2,context));
        }
        return false;
    }
    
}