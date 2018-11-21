/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyroduck.entities.tile.powerup;

import pyroduck.entities.tile.Tile;
import pyroduck.graphics.Sprite;

/**
 *
 * @author Acer 5744 i5
 */
public abstract class Powerup extends Tile {

	protected boolean _active = false;
	
	
	public Powerup(int x, int y, Sprite sprite) {
		super(x, y, sprite);
		
	}
	
	public abstract void setValues();
        
	public boolean isActive() {
		return _active;
	}

	public void setActive(boolean active) {
		this._active = active;
	}
}
