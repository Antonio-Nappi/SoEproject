/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyroduck.entities.tile;

import pyroduck.Board;
import pyroduck.entities.Entity;
import pyroduck.entities.mob.Player;
import pyroduck.graphics.Sprite;

public class PortalTile extends Tile {

	protected Board board;
	
	public PortalTile(int x, int y, Board board, Sprite sprite) {
		super(x, y, sprite);
		this.board = board;
	}
	
	@Override
	public boolean collide(Entity e) {
		
		if(e instanceof Player ) {
			
			if(board.detectNoEnemies() == false)
				return true;
			
			if(e.getXTile() == getX() && e.getYTile() == getY()) {
				if(board.detectNoEnemies())
					board.nextLevel();
			}
			
			return false;
		}
		
		return true;
	}

}
