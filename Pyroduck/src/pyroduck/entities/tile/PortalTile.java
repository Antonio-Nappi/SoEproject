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
		board = board;
	}
	
	@Override
	public boolean collide(Entity e) {
		
		if(e instanceof Player ) {
			
			if(board.detectNoEnemies() == false)
				return false;
			
			if(e.getXTile() == getX() && e.getYTile() == getY()) {
				if(board.detectNoEnemies())
					//board.nextLevel();
                                    System.out.println("LIVELLO COMPLETATO!!!");
			}
			
			return true;
		}
		
		return false;
	}

}
