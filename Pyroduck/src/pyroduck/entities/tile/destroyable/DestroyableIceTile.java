/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyroduck.entities.tile.destroyable;

import pyroduck.graphics.Sprite;

/**
 *
 * @author Alex
 */
public abstract class DestroyableIceTile extends DestroyableTile{

    
    public DestroyableIceTile(int x, int y, Sprite sprite ) {
        super(x, y, sprite);

    }
    public abstract void Collision(ContextDestroyable contextDestroyable);
    
}
