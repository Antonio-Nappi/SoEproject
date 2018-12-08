/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyroduck.entities.tile;

import pyroduck.graphics.Sprite;

/**
 * Is the inaccessible tile on the map where the Player can't pass through it.
 * @author Corbisiero, Ferrara, La Femina
 * @version 1.0
 */
public class WallIceTile extends Tile {
     public static Sprite wallice = new Sprite(7, 0);

    /**
     * Creates an object of the WallTile.
     * @param x horizontal coordinate.
     * @param y vertical coordinate.
     * @param sprite related to the tile.
     */
    public WallIceTile(int x, int y) {
        super(x, y,wallice);
    }
}
